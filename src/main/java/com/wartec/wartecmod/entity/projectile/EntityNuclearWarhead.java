package com.wartec.wartecmod.entity.projectile;

import com.hbm.entity.effect.EntityNukeTorex;
import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.packet.AuxParticlePacket;
import com.hbm.packet.PacketDispatcher;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityNuclearWarhead extends Entity {

    public EntityNuclearWarhead(World world) {
        super(world);
        this.ignoreFrustumCheck = true;
    }

    @Override
    protected void entityInit() { }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt) { }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt) { }

    @Override
    public void onUpdate() {

        this.lastTickPosX = this.prevPosX = posX;
        this.lastTickPosY = this.prevPosY = posY;
        this.lastTickPosZ = this.prevPosZ = posZ;

        this.motionY -= 0.03;

        PacketDispatcher.wrapper.sendToAllAround(new AuxParticlePacket(posX, posY+8, posZ, 2),
                new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, posX, posY, posZ, 300));

        if(this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ) != Blocks.air) {
            if(!this.worldObj.isRemote) {

                this.worldObj.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(worldObj, 100, posX, posY, posZ));
                EntityNukeTorex.statFac(worldObj, posX, posY, posZ, 100);

                }

                this.setDead();
            }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 15728880;
    }

    @Override
    public float getBrightness(float p_70013_1_) {
        return 1.0F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        return distance < 25000;
    }
}