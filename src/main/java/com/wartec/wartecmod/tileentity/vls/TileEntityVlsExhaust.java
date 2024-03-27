package com.wartec.wartecmod.tileentity.vls;

import com.hbm.packet.NBTPacket;
import com.hbm.packet.PacketDispatcher;
import com.hbm.tileentity.INBTPacketReceiver;
import com.hbm.tileentity.TileEntityLoadedBase;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityVlsExhaust
        extends TileEntityLoadedBase
        implements INBTPacketReceiver {

    public int openingAnimation = 0;
    public boolean open = false;

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        openingAnimation = nbt.getInteger("openanim");
        open = nbt.getBoolean("open");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setInteger("openanim", openingAnimation);
        nbt.setBoolean("open", open);
    }

    @Override
    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            if(open && openingAnimation < 90)
                openingAnimation += 3;
            if(!open && openingAnimation > 0)
                openingAnimation -= 3;

            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("openanim", openingAnimation);
            PacketDispatcher.wrapper.sendToAllAround(new NBTPacket(nbt, xCoord, yCoord, zCoord), new NetworkRegistry.TargetPoint(this.worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 50));
        }
    }

    public void networkUnpack(NBTTagCompound data) {
        openingAnimation = data.getInteger("openanim");
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return TileEntity.INFINITE_EXTENT_AABB;
    }

    @SideOnly(value= Side.CLIENT)
    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }

}

