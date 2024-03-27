package com.wartec.wartecmod.entity.logic;

import com.hbm.blocks.ModBlocks;
import com.hbm.entity.projectile.EntityArtilleryShell;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.explosion.vanillant.ExplosionVNT;
import com.hbm.explosion.vanillant.standard.*;
import com.hbm.packet.AuxParticlePacketNT;
import com.hbm.packet.PacketDispatcher;
import com.wartec.wartecmod.entity.missile.EntityHypersonicCruiseMissileBase;
import com.wartec.wartecmod.entity.missile.EntitySubsonicCruiseMissileBase;
import com.wartec.wartecmod.entity.missile.EntitySupersonicCruiseMissileBase;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import static com.hbm.items.weapon.ItemAmmoArty.rand;

public class ExplosionLargeAdvanced {
	
	public boolean isDead;
	
	public void ExplosionAdvanced(World worldObj, double posX, double posY, double posZ, float size, float rangeMod, boolean breaksBlocks, Block slag, int slagMeta) {
		worldObj.playSoundEffect(posX, posY, posZ, "wartecmod:entity.bombDet3", 50.0F, 0.9F + worldObj.rand.nextFloat() * 0.2F);
		Vec3 vec = Vec3.createVectorHelper(posX, posY, posZ).normalize();
		ExplosionVNT xnt = new ExplosionVNT(worldObj, posX, posY, posZ, size);
		ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, cloudFunction((int)size));
		ExplosionLarge.spawnRubble(worldObj, posX, posY, posZ, cloudFunction((int)size));
		ExplosionLarge.spawnShrapnels(worldObj, posX, posY, posZ, cloudFunction((int)size));
		if(breaksBlocks) {
			xnt.setBlockAllocator(new BlockAllocatorStandard(48));
			xnt.setBlockProcessor(new BlockProcessorStandard().setNoDrop().withBlockEffect(new BlockMutatorDebris(slag, slagMeta)));
		}
		xnt.setEntityProcessor(new EntityProcessorCross(7.5).withRangeMod(rangeMod));
		xnt.setPlayerProcessor(new PlayerProcessorStandard());
		xnt.setSFX(new ExplosionEffectStandard());
		xnt.explode();
		killAndClear();
	}

	public void ExplosionStandard(World worldObj, double posX, double posY, double posZ, float size, float rangeMod, boolean breaksBlocks, Block slag, int slagMeta) {
		worldObj.playSoundEffect(posX, posY, posZ, "wartecmod:entity.bombDet3", 50.0F, 0.9F + worldObj.rand.nextFloat() * 0.2F);
		Vec3 vec = Vec3.createVectorHelper(posX, posY, posZ).normalize();
		ExplosionVNT xnt = new ExplosionVNT(worldObj, posX, posY, posZ, size);
		if(breaksBlocks) {
			xnt.setBlockAllocator(new BlockAllocatorStandard(48));
			xnt.setBlockProcessor(new BlockProcessorStandard().setNoDrop().withBlockEffect(new BlockMutatorDebris(slag, slagMeta)));
		}
		xnt.setEntityProcessor(new EntityProcessorCross(7.5).withRangeMod(rangeMod));
		xnt.setPlayerProcessor(new PlayerProcessorStandard());
		xnt.setSFX(new ExplosionEffectStandard());
		xnt.explode();
		killAndClear();
	}
	
	public void ThermobaricExplosion(World worldObj, double posX, double posY, double posZ, float size, float rangeMod, boolean breaksBlocks, Block slag, int slagMeta) {
		worldObj.playSoundEffect(posX, posY, posZ, "hbm:weapon.explosionMedium", 50.0F, 0.9F + worldObj.rand.nextFloat() * 0.2F);
		Vec3 vec = Vec3.createVectorHelper(posX, posY, posZ).normalize();
		ExplosionVNT xnt = new ExplosionVNT(worldObj, posX, posY, posZ, size);
		if(breaksBlocks) {
			xnt.setBlockAllocator(new BlockAllocatorStandard(48));
			xnt.setBlockProcessor(new BlockProcessorStandard().setNoDrop().withBlockEffect(new BlockMutatorDebris(slag, slagMeta)));
		}
		xnt.setEntityProcessor(new EntityProcessorCross(7.5).withRangeMod(rangeMod));
		xnt.setPlayerProcessor(new PlayerProcessorStandard());
		xnt.setSFX(new ExplosionEffectStandard());
		xnt.explode();
		killAndClear();
	}
	
	public static void standardMush(World world, double x, double y, double z, float size) {
		NBTTagCompound data = new NBTTagCompound();
		data.setString("type", "rbmkmush");
		data.setFloat("scale", size);
		PacketDispatcher.wrapper.sendToAllAround(new AuxParticlePacketNT(data, x, y, z), new TargetPoint(world.provider.dimensionId, x, y, z, 250));
	}
	
	public static int cloudFunction(int i) {
		//return (int)(345 * (1 - Math.pow(Math.E, -i/15)) + 15);
		return (int)(850 * (1 - Math.pow(Math.E, -i/15)) + 15);
	}
	
	public static int rubbleFunction(int i) {
		return i/10;
	}
	
	public static int shrapnelFunction(int i) {
		return i/3;
	}
	
	private void killAndClear() {
		this.setDead();
	}
	public void setDead()
    {
        this.isDead = true;
    }

	public static void ClusterStandard(EntitySubsonicCruiseMissileBase Missile, int clusterType, int amount, double splitHeight, double deviation) {
		if(Missile.motionY > 0) return;
		if(Missile.getTargetHeight() + splitHeight < Missile.posY) return;

		Missile.setDead();

		NBTTagCompound data = new NBTTagCompound();
		data.setString("type", "plasmablast");
		data.setFloat("r", 1.0F);
		data.setFloat("g", 1.0F);
		data.setFloat("b", 1.0F);
		data.setFloat("scale", 50F);
		PacketDispatcher.wrapper.sendToAllAround(new AuxParticlePacketNT(data, Missile.posX, Missile.posY, Missile.posZ),
				new TargetPoint(Missile.dimension, Missile.posX, Missile.posY, Missile.posZ, 500));

		for(int i = 0; i < amount; i++) {
			EntityArtilleryShell Bomblet = new EntityArtilleryShell(Missile.worldObj);
			Bomblet.setType(clusterType);
			Bomblet.motionX = i == 0 ? Bomblet.motionX : (Bomblet.motionX + rand.nextGaussian() * deviation);
			Bomblet.motionY = Bomblet.motionY;
			Bomblet.motionZ = i == 0 ? Bomblet.motionZ : (Bomblet.motionZ + rand.nextGaussian() * deviation);
			Bomblet.setPositionAndRotation(Bomblet.posX, Bomblet.posY, Bomblet.posZ, Bomblet.rotationYaw, Bomblet.rotationPitch);
			double[] target = Bomblet.getTarget();
			Bomblet.setTarget(target[0], target[1], target[2]);
			Bomblet.setWhistle(Bomblet.getWhistle() && !Bomblet.didWhistle());
			Bomblet.worldObj.spawnEntityInWorld(Bomblet);
		}
	}

}
