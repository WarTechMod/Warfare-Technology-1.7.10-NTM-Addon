/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.hbm.config.GeneralConfig
 *  com.hbm.entity.missile.EntityMissileAntiBallistic
 *  com.hbm.explosion.ExplosionLarge
 *  com.hbm.interfaces.IBomb
 *  com.hbm.interfaces.IBomb$BombReturnCode
 *  com.hbm.interfaces.Spaghetti
 *  com.hbm.items.ModItems
 *  com.hbm.main.MainRegistry
 *  cpw.mods.fml.common.network.internal.FMLNetworkHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockContainer
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 *  org.apache.logging.log4j.Level
 */
package com.wartec.wartecmod.blocks.vls;

import com.hbm.blocks.BlockDummyable;
import com.hbm.handler.MultiblockHandlerXR;
import com.wartec.wartecmod.blocks.wartecmodBlocks;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class VlsExhaust
        extends BlockDummyable
{

    public VlsExhaust(Material p_i45386_1_) {
        super(p_i45386_1_);
    }

    public TileEntity createNewTileEntity(World world, int meta) {
        if(meta >= offset)
            return new TileEntityVlsExhaust();
        return null;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(wartecmodBlocks.VlsExhaust);
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int[] getDimensions() {
        return new int[] {height, 0, 2, 1, 0, 0};
    }

    @Override
    public int getOffset() {
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return Item.getItemFromBlock(wartecmodBlocks.VlsExhaust);
    }

    private final int height = 10;

    @Override
    public void fillSpace(World world, int x, int y, int z, ForgeDirection dir, int o) {
        MultiblockHandlerXR.fillSpace(world, x + dir.offsetX * o, y + dir.offsetY * o, z + dir.offsetZ * o, getDimensions(), this, dir);
        this.makeExtra(world, x, y + height, z);
    }

    @Override
    protected ForgeDirection getDirModified(ForgeDirection dir) {
        return ForgeDirection.NORTH;
    }

}

