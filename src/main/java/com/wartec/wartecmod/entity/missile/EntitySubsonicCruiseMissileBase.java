package com.wartec.wartecmod.entity.missile;

import api.hbm.entity.IRadarDetectable;
import com.hbm.entity.logic.IChunkLoader;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.main.MainRegistry;
import com.wartec.wartecmod.entity.submunition.EntityBombletHE;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import net.minecraftforge.common.ForgeChunkManager.Type;

import java.util.ArrayList;
import java.util.List;

public abstract class EntitySubsonicCruiseMissileBase extends Entity implements IChunkLoader, IRadarDetectable {
	
	int startX;
	int startY;
	int startZ;
	int targetX;
	int targetY;
	int targetZ;
	int velocity;
	double Distance;
	double CruiseMissilePosition;
    double BoosterDisengagement;
	double SubmunitionDispensing;
    double startsonicspeed;
	double decelY;
	double accelXZ;
	boolean isSubsonic = false;
	boolean isCluster = false;
    private Ticket loaderTicket;
    public int health = 10;
    protected TileEntityVlsExhaust exhaust = null;
    

	public EntitySubsonicCruiseMissileBase(World p_i1582_1_) {
		super(p_i1582_1_);
		this.ignoreFrustumCheck = true;
		startX = (int) posX;
		startY = (int) posY;
		startZ = (int) posZ;
		targetX = (int) posX;
		targetY = (int) posY;
		targetZ = (int) posZ;
	}
	
    public boolean canBeCollidedWith()
    {
        return true;
    }
    
    public boolean attackEntityFrom(DamageSource src, float dmg)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            if (!this.isDead && !this.worldObj.isRemote)
            {
            	health -= dmg;
            	
                if (this.health <= 0)
                {
                    this.setDead();
                    this.killMissile();
                }
            }

            return true;
        }
    }
    
    
    private void killMissile() {
        ExplosionLarge.explode(worldObj, posX, posY, posZ, 5, true, false, true);
        ExplosionLarge.spawnShrapnelShower(worldObj, posX, posY, posZ, motionX, motionY, motionZ, 15, 0.075);
        ExplosionLarge.spawnMissileDebris(worldObj, posX, posY, posZ, motionX, motionY, motionZ, 0.25, getDebris(), getDebrisRareDrop());
    }

	public EntitySubsonicCruiseMissileBase(World world, float x, float y, float z, int a, int b, int c, TileEntityVlsExhaust exh) {
		super(world);
		this.ignoreFrustumCheck = true;
		/*this.posX = x;
		this.posY = y;
		this.posZ = z;*/
		this.setLocationAndAngles(x, y, z, 0, 0);
		startX = (int) x;
		startY = (int) y;
		startZ = (int) z;
		targetX = a;
		targetY = b;
		targetZ = c;
		this.exhaust = exh;

		Distance = Math.sqrt(((targetX - startX)*(targetX - startX)) + ((targetY - startY)*(targetY - startY)) + ((targetZ - startZ)*(targetZ - startZ)));

		BoosterDisengagement = (Math.sqrt(((targetX - startX)*(targetX - startX)) + ((targetY - startY)*(targetY - startY)) + ((targetZ - startZ)*(targetZ - startZ))))*0.15;

		SubmunitionDispensing = (Math.sqrt(((targetX - startX)*(targetX - startX)) + ((targetY - startY)*(targetY - startY)) + ((targetZ - startZ)*(targetZ - startZ))))*0.95;

		startsonicspeed = BoosterDisengagement*1.34;
		
		
		this.motionY = 0.25;
		
        Vec3 vector = Vec3.createVectorHelper(targetX - startX, targetY - startY, targetZ - startZ);
		accelXZ = decelY = 1/vector.lengthVector();
		decelY *= 0.25;
			
		velocity = 1;

        this.setSize(1.5F, 1.5F);
	}

	@Override
	protected void entityInit() {
		init(ForgeChunkManager.requestTicket(MainRegistry.instance, worldObj, Type.ENTITY));
		this.dataWatcher.addObject(8, Integer.valueOf(this.health));
		this.dataWatcher.addObject(9, 1);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		motionX = nbt.getDouble("moX");
		motionY = nbt.getDouble("moY");
		motionZ = nbt.getDouble("moZ");
		posX = nbt.getDouble("poX");
		posY = nbt.getDouble("poY");
		posZ = nbt.getDouble("poZ");
		decelY = nbt.getDouble("decel");
		accelXZ = nbt.getDouble("accel");
		targetX = nbt.getInteger("tX");
		targetY = nbt.getInteger("tY");
		targetZ = nbt.getInteger("tZ");
		startX = nbt.getInteger("sX");
		startY = nbt.getInteger("sY");
		startZ = nbt.getInteger("sZ");
		velocity = nbt.getInteger("veloc");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
		nbt.setDouble("moX", motionX);
		nbt.setDouble("moY", motionY);
		nbt.setDouble("moZ", motionZ);
		nbt.setDouble("poX", posX);
		nbt.setDouble("poY", posY);
		nbt.setDouble("poZ", posZ);
		nbt.setDouble("decel", decelY);
		nbt.setDouble("accel", accelXZ);
		nbt.setInteger("tX", targetX);
		nbt.setInteger("tY", targetY);
		nbt.setInteger("tZ", targetZ);
		nbt.setInteger("sX", startX);
		nbt.setInteger("sY", startY);
		nbt.setInteger("sZ", startZ);
		nbt.setInteger("veloc", velocity);
	}
	
	protected void rotation() {
        float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

        for (this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0D / Math.PI) -90; this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
        {
            ;
        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }
	}
	private void spawnExhaust(double x, double y, double z) {

		NBTTagCompound data = new NBTTagCompound();
		data.setString("type", "exhaust");
		data.setString("mode", "soyuz");
		if(exhaust == null) {
			data.setInteger("count", 5);
			data.setDouble("width", worldObj.rand.nextDouble() * 0.25 - 0.5);
		} else {
			data.setInteger("count", 2);
			data.setDouble("width", worldObj.rand.nextDouble() * 0.25 - 0.8);

			NBTTagCompound vep = new NBTTagCompound();
			vep.setString("type", "exhaust");
			vep.setString("mode", "soyuz");
			vep.setInteger("count", 1);
			vep.setDouble("width", worldObj.rand.nextDouble() * 0.25 - 0.8);
			vep.setDouble("posX", exhaust.xCoord);
			vep.setDouble("posY", exhaust.yCoord+11);
			vep.setDouble("posZ", exhaust.zCoord);
			MainRegistry.proxy.effectNT(vep);
		}
		data.setDouble("posX", x);
		data.setDouble("posY", y);
		data.setDouble("posZ", z);
		
		MainRegistry.proxy.effectNT(data);
	}

	public double getTargetHeight() {
		return this.targetY;
	}

	public double[] getTarget() {
		return new double[] { this.targetX, this.targetY, this.targetZ };
	}

	public void setTarget(int a, int b, int c) {
		this.targetX = a;
		this.targetY = b;
		this.targetZ = c;
	}
	
	@Override
    public void onUpdate() {

		//1.Position
		CruiseMissilePosition = Math.sqrt(((this.posX - startX) * (this.posX - startX)) + ((this.posY - startY) * (this.posY - startY)) + ((this.posZ - startZ) * (this.posZ - startZ)));

		//2. Geschwindigkeiten
		if(velocity < 2)
			velocity = 2;
		if(this.ticksExisted > 40)
			velocity = 4;
		else if(this.ticksExisted > 20)
			velocity = 3;
		//if(this.CruiseMissilePosition > this.startsonicspeed && isSubsonic && !this.worldObj.isRemote)
			//velocity = 4;
		//this.velocityChanged = true;


		this.dataWatcher.updateObject(8, Integer.valueOf(this.health));

		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		//TODO: instead of crappy skipping, implement a hitscan
		for(int i = 0; i < velocity; i++) {
		//this.posX += this.motionX;
		//this.posY += this.motionY;
		//this.posZ += this.motionZ;

		//this.setLocationAndAngles(posX + (this.motionX*1.0033) * velocity, posY + this.motionY * velocity, posZ + (this.motionZ*0.9952) * velocity, 0, 0);
		this.setLocationAndAngles(posX + this.motionX * velocity, posY + this.motionY * velocity, posZ + this.motionZ * velocity, 0, 0);


		this.rotation();

		this.motionY -= decelY * velocity;

		Vec3 vector = Vec3.createVectorHelper(targetX - startX, targetY - startY, targetZ - startZ);
		vector = vector.normalize();
		vector.xCoord *= accelXZ * velocity;
		vector.zCoord *= accelXZ * velocity;


		if (motionY > 0) {
			motionX += vector.xCoord;
			motionZ += vector.zCoord;
		}

		if (motionY < 0) {
			motionX -= vector.xCoord;
			motionZ -= vector.zCoord;
		}

		//3. Bedingungen für Transformation
		if (this.CruiseMissilePosition < this.BoosterDisengagement && this.dataWatcher.getWatchableObjectInt(9) == 1 && !this.worldObj.isRemote) {//this.ticksExisted > 5
			this.spawnExhaust(posX - vector.xCoord * i, (posY + 1) - vector.yCoord * i, posZ - vector.zCoord * i); // velocity=i
			}

		if (this.CruiseMissilePosition > this.BoosterDisengagement && this.dataWatcher.getWatchableObjectInt(9) == 1 && !this.worldObj.isRemote) {//this.ticksExisted > 205
			this.MissileToCruiseMissile();
		}

		new TargetPoint(worldObj.provider.dimensionId, posX, posY, posZ, 300); //300

		if (this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ) != Blocks.air &&
				this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ) != Blocks.water &&
				this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ) != Blocks.flowing_water) {


			if (!this.worldObj.isRemote) {
				onImpact();
			}
			this.setDead();
			return;
		}

		if (this.isCluster && this.Distance-30 < this.CruiseMissilePosition && !this.worldObj.isRemote) {
			BombletSplit();
		}

		loadNeighboringChunks((int) (posX / 16), (int) (posZ / 16));

	      }
		}

	public void BombletSplit() {
		if (this.Distance-30 < this.CruiseMissilePosition) {

			if (worldObj.isRemote)
				return;
			ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, 7);
			this.setDead();

				for (int i = 0; i < 100; i++) {

					EntityBombletHE Bomblet = new EntityBombletHE(worldObj);
					Bomblet.posX = posX;
					Bomblet.posY = posY;
					Bomblet.posZ = posZ;
					Bomblet.motionX = motionX + rand.nextGaussian() * 0.7D;
					Bomblet.motionY = motionY + rand.nextGaussian() * 0.7D;
					Bomblet.motionZ = motionZ + rand.nextGaussian() * 0.7D;
					Bomblet.ticksExisted = 52;

					worldObj.spawnEntityInWorld(Bomblet);
				}
			}
		}
	
	
    
	
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance)
    {
        return distance < 500000;
    }
    
	public abstract void onImpact();


	public abstract List<ItemStack> getDebris();
	
	public abstract ItemStack getDebrisRareDrop();
	
	public void cluster() { }
	
	public void init(Ticket ticket) {
		if(!worldObj.isRemote) {
			
            if(ticket != null) {
            	
                if(loaderTicket == null) {
                	
                	loaderTicket = ticket;
                	loaderTicket.bindEntity(this);
                	loaderTicket.getModData();
                }

                ForgeChunkManager.forceChunk(loaderTicket, new ChunkCoordIntPair(chunkCoordX, chunkCoordZ));
            }
        }
	}

	List<ChunkCoordIntPair> loadedChunks = new ArrayList<ChunkCoordIntPair>();

	public void loadNeighboringChunks(int newChunkX, int newChunkZ)
	{
		if(!worldObj.isRemote && loaderTicket != null)
		{
			for(ChunkCoordIntPair chunk : loadedChunks)
			{
				ForgeChunkManager.unforceChunk(loaderTicket, chunk);
			}

			loadedChunks.clear();
			loadedChunks.add(new ChunkCoordIntPair(newChunkX, newChunkZ));
			loadedChunks.add(new ChunkCoordIntPair(newChunkX + 1, newChunkZ + 1));
			loadedChunks.add(new ChunkCoordIntPair(newChunkX - 1, newChunkZ - 1));
			loadedChunks.add(new ChunkCoordIntPair(newChunkX + 1, newChunkZ - 1));
			loadedChunks.add(new ChunkCoordIntPair(newChunkX - 1, newChunkZ + 1));
			loadedChunks.add(new ChunkCoordIntPair(newChunkX + 1, newChunkZ));
			loadedChunks.add(new ChunkCoordIntPair(newChunkX, newChunkZ + 1));
			loadedChunks.add(new ChunkCoordIntPair(newChunkX - 1, newChunkZ));
			loadedChunks.add(new ChunkCoordIntPair(newChunkX, newChunkZ - 1));

			for(ChunkCoordIntPair chunk : loadedChunks)
			{
				ForgeChunkManager.forceChunk(loaderTicket, chunk);
			}
		}
	}
    

    private void MissileToCruiseMissile() {
		ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, 7);
		this.dataWatcher.updateObject(9, 2);
    }

}