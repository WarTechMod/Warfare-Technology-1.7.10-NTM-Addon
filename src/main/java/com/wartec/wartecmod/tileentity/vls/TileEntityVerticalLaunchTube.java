package com.wartec.wartecmod.tileentity.vls;

import api.hbm.energymk2.IEnergyReceiverMK2;
import api.hbm.fluid.IFluidStandardReceiver;
import com.hbm.lib.Library;
import com.hbm.main.MainRegistry;
import com.hbm.util.fauxpointtwelve.DirPos;
import com.wartec.wartecmod.entity.missile.EntityCruiseMissileBaseNT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class TileEntityVerticalLaunchTube extends TileEntityVerticalLaunchTubeBase implements IEnergyReceiverMK2, IFluidStandardReceiver {

    @Override public boolean isReadyForLaunch() { return delay <= 0; }
    @Override public double getLaunchOffset() { return 1D; }

    public int delay = 0;

    @Override
    public void updateEntity() {

        if(!worldObj.isRemote) {

            if(this.delay > 0) delay--;

            if(!this.isMissileValid() || !this.hasFuel()) {
                this.delay = 100;
            }

            if(!this.hasFuel() || !this.isMissileValid()) {
                this.state = this.STATE_MISSING;
            } else {
                if(this.delay > 0) {
                    this.state = this.STATE_LOADING;
                } else {
                    this.state = this.STATE_READY;
                }
            }

        } else {

            List<EntityCruiseMissileBaseNT> entities = worldObj.getEntitiesWithinAABB(EntityCruiseMissileBaseNT.class, AxisAlignedBB.getBoundingBox(xCoord - 0.5, yCoord, zCoord - 0.5, xCoord + 1.5, yCoord + 10, zCoord + 1.5));

            if(!entities.isEmpty()) {
                for(int i = 0; i < 15; i++) {

                    ForgeDirection dir = ForgeDirection.getOrientation(this.getBlockMetadata() - 10);
                    if(worldObj.rand.nextBoolean()) dir = dir.getOpposite();
                    if(worldObj.rand.nextBoolean()) dir = dir.getRotation(ForgeDirection.UP);
                    float moX = (float) (worldObj.rand.nextGaussian() * 0.15F + 0.75) * dir.offsetX;
                    float moZ = (float) (worldObj.rand.nextGaussian() * 0.15F + 0.75) * dir.offsetZ;

                    MainRegistry.proxy.spawnParticle(xCoord + 0.5, yCoord + 0.25, zCoord + 0.5, "launchsmoke", new float[] {moX, 0, moZ});
                }
            }
        }

        super.updateEntity();
    }

    @Override
    public void finalizeLaunch(Entity missile) {
        super.finalizeLaunch(missile);
        this.delay = 100;
    }

    @Override
    public DirPos[] getConPos() {
        return new DirPos[] {
                new DirPos(xCoord + 2, yCoord, zCoord - 1, Library.POS_X),
                new DirPos(xCoord + 2, yCoord, zCoord + 1, Library.POS_X),
                new DirPos(xCoord - 2, yCoord, zCoord - 1, Library.NEG_X),
                new DirPos(xCoord - 2, yCoord, zCoord + 1, Library.NEG_X),
                new DirPos(xCoord - 1, yCoord, zCoord + 2, Library.POS_Z),
                new DirPos(xCoord + 1, yCoord, zCoord + 2, Library.POS_Z),
                new DirPos(xCoord - 1, yCoord, zCoord - 2, Library.NEG_Z),
                new DirPos(xCoord + 1, yCoord, zCoord - 2, Library.NEG_Z)
        };
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.delay = nbt.getInteger("delay");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("delay", delay);
    }

    AxisAlignedBB bb = null;

    @Override
    public AxisAlignedBB getRenderBoundingBox() {

        if(bb == null) {
            bb = AxisAlignedBB.getBoundingBox(
                    xCoord - 2,
                    yCoord,
                    zCoord - 2,
                    xCoord + 3,
                    yCoord + 15,
                    zCoord + 3
            );
        }

        return bb;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 65536.0D;
    }
}
