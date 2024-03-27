package com.wartec.wartecmod.entity.missile;

import com.hbm.main.MainRegistry;
import com.hbm.packet.AuxParticlePacket;
import com.hbm.packet.PacketDispatcher;
import com.hbm.saveddata.SatelliteSavedData;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMissileASAT extends Entity {

    private final int satId;

    double acceleration = 0.00D;

    public EntityMissileASAT(World world) {
        super(world);
        satId = 0;
    }

    public EntityMissileASAT(World world, float x, float y, float z, int satId) {
        super(world);
        this.ignoreFrustumCheck = true;
        this.setLocationAndAngles(x, y, z, 0, 0);
        this.satId = satId;
    }

    @Override
    protected void entityInit() { }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt) { }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt) { }

    @Override
    public void onUpdate() {

        if(motionY < 3.7D) {
            acceleration += 0.0007D;
            motionY += acceleration;
        }

        this.lastTickPosX = this.prevPosX = posX;
        this.lastTickPosY = this.prevPosY = posY;
        this.lastTickPosZ = this.prevPosZ = posZ;
        this.setLocationAndAngles(posX + this.motionX, posY + this.motionY, posZ + this.motionZ, 0, 0);
        this.rotation();

        this.spawnExhaust(posX, posY, posZ);
                new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, posX, posY, posZ, 300);

        if(!worldObj.isRemote) {
            if (this.posY >= 600) {
                System.out.println("deleted sat " + satId);

                SatelliteSavedData sd = SatelliteSavedData.getData(worldObj);
                sd.sats.remove(satId);
                sd.markDirty();

                System.out.println("is taken: " + SatelliteSavedData.getData(worldObj).isFreqTaken(satId));
                System.out.println("is dirty: " + SatelliteSavedData.getData(worldObj).isDirty());
                System.out.println("sat: "+SatelliteSavedData.getData(worldObj).getSatFromFreq(satId));

                this.setDead();
            }
        }
    }

    private void spawnExhaust(double x, double y, double z) {

        NBTTagCompound data = new NBTTagCompound();
        data.setString("type", "exhaust");
        data.setString("mode", "soyuz");
        data.setInteger("count", 2);
        data.setDouble("width", worldObj.rand.nextDouble() * 0.25 - 0.5);
        data.setDouble("posX", x);
        data.setDouble("posY", y);
        data.setDouble("posZ", z);

        MainRegistry.proxy.effectNT(data);
    }

    protected void rotation() {
        this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

        while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
            this.prevRotationPitch += 360.0F;
        }

        while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
            this.prevRotationYaw -= 360.0F;
        }

        while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
            this.prevRotationYaw += 360.0F;
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