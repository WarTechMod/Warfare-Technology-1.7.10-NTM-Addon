package com.wartec.wartecmod.entity.missile;

import api.hbm.entity.IRadarDetectableNT;
import com.hbm.entity.logic.IChunkLoader;
import com.hbm.entity.projectile.EntityThrowableInterp;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.explosion.vanillant.ExplosionVNT;
import com.hbm.explosion.vanillant.standard.*;
import com.hbm.main.MainRegistry;
import com.hbm.util.TrackerUtil;
import com.wartec.wartecmod.entity.submunition.EntityBombletHE;
import com.wartec.wartecmod.items.ItemCruiseMissile;
import com.wartec.wartecmod.tileentity.vls.TileEntityVerticalLaunchTubeBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityTrackerEntry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeChunkManager;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityCruiseMissileBaseNT extends EntityThrowableInterp implements IChunkLoader, IRadarDetectableNT {

    protected TileEntityVerticalLaunchTubeBase exhaust = null;
    public int startX;
    public int startZ;

    public int targetX;

    public int targetZ;
    public double velocity;
    public double decelY;
    public double accelXZ;
    public boolean isCluster = false;
    public boolean isStealth = false;
    double Distance;

    double CruiseMissilePosition;
    double BoosterDisengagement;
    double SubmunitionDispensing;
    private ForgeChunkManager.Ticket loaderTicket;
    public int health = 25;


    public EntityCruiseMissileBaseNT(World world) {
        super(world);
        this.ignoreFrustumCheck = true;
        startX = (int) posX;
        startZ = (int) posZ;
        targetX = (int) posX;
        targetZ = (int) posZ;
    }

    public EntityCruiseMissileBaseNT(World world, float x, float y, float z, int a, int b) {
        super(world);
        this.ignoreFrustumCheck = true;
        this.setLocationAndAngles(x, y, z, 0, 0);
        startX = (int) x;
        startZ = (int) z;
        targetX = a;
        targetZ = b;
        this.motionY = 1;

        Distance = Math.sqrt(((targetX - startX)*(targetX - startX)) + ((targetZ - startZ)*(targetZ - startZ)));

        BoosterDisengagement = (Math.sqrt(((targetX - startX)*(targetX - startX)) + ((targetZ - startZ)*(targetZ - startZ))))*0.15;

        SubmunitionDispensing = (Math.sqrt(((targetX - startX)*(targetX - startX)) +  ((targetZ - startZ)*(targetZ - startZ))))*0.95;

        Vec3 vector = Vec3.createVectorHelper(this.targetX - this.startX, 0, this.targetZ - this.startZ);
        //vector.xCoord *= (1+(17.5/this.Distance));
        //vector.zCoord *= (1+(17.5/this.Distance));
        accelXZ = decelY =   1 / vector.lengthVector();
        decelY *= 1;
        velocity = 0;

        this.rotationYaw = (float) (Math.atan2(this.targetX - this.posX, this.targetZ - this.posZ) * 180.0D / Math.PI);

        this.setSize(1.5F, 1.5F);

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
            vep.setDouble("posY", exhaust.yCoord-5);
            vep.setDouble("posZ", exhaust.zCoord);
            MainRegistry.proxy.effectNT(vep);
        }
        data.setDouble("posX", x);
        data.setDouble("posY", y);
        data.setDouble("posZ", z);

        MainRegistry.proxy.effectNT(data);
    }

    /** Auto-generates radar blip level and all that from the item */
    public abstract ItemStack getMissileItemForInfo();

    @Override
    public boolean canBeSeenBy(Object radar) {
        if(this.isStealth && !this.worldObj.isRemote && this.dataWatcher.getWatchableObjectInt(9) == 2) {
            return false;
        }
        return true;
    }

    @Override
    public boolean paramsApplicable(RadarScanParams params) {
        if(!params.scanMissiles) return false;
        return true;
    }

    @Override
    public boolean suppliesRedstone(RadarScanParams params) {
        if(params.smartMode && this.motionY >= 0) return false;
        return true;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        init(ForgeChunkManager.requestTicket(MainRegistry.instance, worldObj, ForgeChunkManager.Type.ENTITY));
        this.dataWatcher.addObject(3, new Byte((byte) 5));
        this.dataWatcher.addObject(9, 1);
    }


    @Override
    protected double motionMult() {
        return velocity;
    }

    @Override
    public boolean doesImpactEntities() {
        return false;
    }

    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();

        if (velocity < 4) velocity += MathHelper.clamp_double(this.ticksExisted / 60D * 0.05, 0, 0.05);

        CruiseMissilePosition = Math.sqrt(((this.posX - this.startX) * (this.posX - this.startX)) + ((this.posZ - this.startZ) * (this.posZ - this.startZ)));


        if (this.CruiseMissilePosition > this.BoosterDisengagement && this.dataWatcher.getWatchableObjectInt(9) == 1 && !this.worldObj.isRemote) {//this.ticksExisted > 205
            this.MissileToCruiseMissile();
        }

        if(this.Distance - 50 == this.CruiseMissilePosition && !this.worldObj.isRemote && !isCluster) {
        worldObj.playSoundEffect(this.posX, this.posY-2, this.posZ, "wartecmod:weapon.CruiseMissileWhistle", 10.0f, 1.0f);
        }

        if (this.isCluster && this.Distance - 30 < this.CruiseMissilePosition && !this.worldObj.isRemote) {
            //if (this.isCluster && this.posX == this.targetX && this.posZ == this.targetZ && !this.worldObj.isRemote) {
            BombletSplit();
            this.dataWatcher.updateObject(9, 3);
        }


        if (!worldObj.isRemote) {

            if(hasPropulsion()) {
                this.motionY -= decelY * velocity;

            Vec3 vector = Vec3.createVectorHelper(this.targetX - this.startX, 0, this.targetZ - this.startZ);
            vector = vector.normalize();
            vector.xCoord *= accelXZ;
            vector.zCoord *= accelXZ;

            if (this.CruiseMissilePosition < this.BoosterDisengagement && this.dataWatcher.getWatchableObjectInt(9) == 1 && !this.worldObj.isRemote) {//this.ticksExisted > 5
                this.spawnExhaust(this.posX - vector.xCoord * velocity, (this.posY) - vector.yCoord * velocity, this.posZ - vector.zCoord * velocity);
            }

            if (motionY > 0) {
                motionX += vector.xCoord * velocity;
                motionZ += vector.zCoord * velocity;
            }

            if (motionY < 0) {
                motionX -= vector.xCoord * velocity;
                motionZ -= vector.zCoord * velocity;
            }
        } else {
            motionX *= 0.99;
            motionZ *= 0.99;
                if (motionY > -0.1875)
                      motionY -= 0.25;
        }

        this.rotationYaw = (float) (Math.atan2(targetX - posX, targetZ - posZ) * 180.0D / Math.PI);
        float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        for (this.rotationPitch = (float) (Math.atan2(this.motionY, f2) * 180.0D / Math.PI) - 90; this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
            ;
        EntityTrackerEntry tracker = TrackerUtil.getTrackerEntry((WorldServer) worldObj, this.getEntityId());
        if (tracker != null) tracker.lastYaw += 100; //coax the tracker into sending smother updates

        loadNeighboringChunks((int) Math.floor(posX / 16), (int) Math.floor(posZ / 16));
    }

        while(this.rotationPitch - this.prevRotationPitch >= 180.0F) this.prevRotationPitch += 360.0F;
        while(this.rotationYaw - this.prevRotationYaw < -180.0F) this.prevRotationYaw -= 360.0F;
        while(this.rotationYaw - this.prevRotationYaw >= 180.0F) this.prevRotationYaw += 360.0F;
    }
    public void BombletSplit() {
        if (this.Distance-30 < this.CruiseMissilePosition) {
        //if (this.posX == this.targetX && this.posZ == this.targetZ) {

            if (worldObj.isRemote)
                return;
            ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, 7);

            for (int i = 0; i < 100; i++) {

                EntityBombletHE Bomblet = new EntityBombletHE(worldObj);
                Bomblet.posX = posX;
                Bomblet.posY = posY;
                Bomblet.posZ = posZ;
                Bomblet.motionX = motionX + rand.nextGaussian() * 0.75D;
                Bomblet.motionY = motionY + rand.nextGaussian() * 0.75D;
                Bomblet.motionZ = motionZ + rand.nextGaussian() * 0.75D;
                Bomblet.ticksExisted = 52;

                worldObj.spawnEntityInWorld(Bomblet);
            }
        }
    }

    public boolean hasPropulsion() {
        return true;
    }


    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        motionX = nbt.getDouble("moX");
        motionY = nbt.getDouble("moY");
        motionZ = nbt.getDouble("moZ");
        posX = nbt.getDouble("poX");
        posY = nbt.getDouble("poY");
        posZ = nbt.getDouble("poZ");
        decelY = nbt.getDouble("decel");
        accelXZ = nbt.getDouble("accel");
        targetX = nbt.getInteger("tX");
        targetZ = nbt.getInteger("tZ");
        startX = nbt.getInteger("sX");
        startZ = nbt.getInteger("sZ");
        velocity = nbt.getDouble("veloc");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setDouble("moX", motionX);
        nbt.setDouble("moY", motionY);
        nbt.setDouble("moZ", motionZ);
        nbt.setDouble("poX", posX);
        nbt.setDouble("poY", posY);
        nbt.setDouble("poZ", posZ);
        nbt.setDouble("decel", decelY);
        nbt.setDouble("accel", accelXZ);
        nbt.setInteger("tX", targetX);
        nbt.setInteger("tZ", targetZ);
        nbt.setInteger("sX", startX);
        nbt.setInteger("sZ", startZ);
        nbt.setDouble("veloc", velocity);
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(this.isEntityInvulnerable()) {
            return false;
        } else {
            if(this.health > 0 && !this.worldObj.isRemote) {
                health -= amount;

                if(this.health <= 0) {
                    this.killMissile();
                }
            }

            return true;
        }
    }

    protected void killMissile() {
        if(!this.isDead) {
            this.setDead();
            ExplosionLarge.explode(worldObj, posX, posY, posZ, 5, true, false, true);
            ExplosionLarge.spawnShrapnelShower(worldObj, posX, posY, posZ, motionX, motionY, motionZ, 15, 0.075);
            ExplosionLarge.spawnMissileDebris(worldObj, posX, posY, posZ, motionX, motionY, motionZ, 0.25, getDebris(), getDebrisRareDrop());
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        return true;
    }

    @Override
    protected void onImpact(MovingObjectPosition mop) {
        if(mop != null && mop.typeOfHit == mop.typeOfHit.BLOCK) {
            this.onImpact();
            this.setDead();
        }
    }

    public abstract void onImpact();
    public abstract List<ItemStack> getDebris();
    public abstract ItemStack getDebrisRareDrop();
    public void cluster() { }

    @Override
    public double getGravityVelocity() {
        return 0.0D;
    }

    @Override
    protected float getAirDrag() {
        return 1F;
    }

    @Override
    protected float getWaterDrag() {
        return 1F;
    }

    @Override
    public void init(ForgeChunkManager.Ticket ticket) {
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

    public void loadNeighboringChunks(int newChunkX, int newChunkZ) {
        if(!worldObj.isRemote && loaderTicket != null) {

            clearChunkLoader();

            loadedChunks.clear();
            loadedChunks.add(new ChunkCoordIntPair(newChunkX, newChunkZ));
            //loadedChunks.add(new ChunkCoordIntPair(newChunkX + (int) Math.floor((this.posX + this.motionX * this.motionMult()) / 16D), newChunkZ + (int) Math.floor((this.posZ + this.motionZ * this.motionMult()) / 16D)));

            for(ChunkCoordIntPair chunk : loadedChunks) {
                ForgeChunkManager.forceChunk(loaderTicket, chunk);
            }
        }
    }

    @Override
    public void setDead() {
        super.setDead();
        this.clearChunkLoader();
    }

    public void clearChunkLoader() {
        if(!worldObj.isRemote && loaderTicket != null) {
            for(ChunkCoordIntPair chunk : loadedChunks) {
                ForgeChunkManager.unforceChunk(loaderTicket, chunk);
            }
        }
    }

    public void explodeStandard(float strength, int resolution, boolean fire, boolean largeSmoke) {
        ExplosionVNT xnt = new ExplosionVNT(worldObj, posX, posY, posZ, strength);
        xnt.setBlockAllocator(new BlockAllocatorStandard(resolution));
        xnt.setBlockProcessor(new BlockProcessorStandard().setNoDrop().withBlockEffect(fire ? new BlockMutatorFire() : null));
        xnt.setEntityProcessor(new EntityProcessorCross(7.5D).withRangeMod(2));
        xnt.setPlayerProcessor(new PlayerProcessorStandard());
        xnt.setSFX(new ExplosionEffectStandard());
        if(largeSmoke) ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, ExplosionLarge.cloudFunction((int) strength));
        xnt.explode();
    }

    @Override
    public String getUnlocalizedName() {
        ItemStack item = this.getMissileItemForInfo();
        if(item != null && item.getItem() instanceof ItemCruiseMissile) {
            ItemCruiseMissile missile = (ItemCruiseMissile) item.getItem();
            switch(missile.tier) {
                case Tier0: return "radar.target.tier0";
                case TIER1: return "radar.target.tier1";
                case TIER2: return "radar.target.tier2";
                case TIER3: return "radar.target.tier3";
                case TIER4: return "radar.target.tier4";
                default: return "Unknown";
            }
        }

        return "Unknown";
    }

    @Override
    public int getBlipLevel() {
        ItemStack item = this.getMissileItemForInfo();
        if(item != null && item.getItem() instanceof ItemCruiseMissile) {
            ItemCruiseMissile missile = (ItemCruiseMissile) item.getItem();
            switch(missile.tier) {
                case Tier0: return IRadarDetectableNT.TIER0;
                case TIER1: return IRadarDetectableNT.TIER1;
                case TIER2: return IRadarDetectableNT.TIER2;
                case TIER3: return IRadarDetectableNT.TIER3;
                case TIER4: return IRadarDetectableNT.TIER4;
                default: return IRadarDetectableNT.SPECIAL;
            }
        }

        return IRadarDetectableNT.SPECIAL;
    }

    private void MissileToCruiseMissile() {
        ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, 7);
        this.dataWatcher.updateObject(9, 2);
    }
}