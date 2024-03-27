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
import com.hbm.interfaces.IBomb;
import com.wartec.wartecmod.blocks.wartecmodBlocks;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsLaunchTube;
import com.wartec.wartecmod.wartecmod;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class VlsVerticalLauncher
		extends BlockDummyable
	implements IBomb
{
	public static boolean keepInventory = false;
	private static final Random field_149933_a = new Random();

	public VlsVerticalLauncher(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		if(meta >= offset)
			return new TileEntityVlsLaunchTube();
		return null;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock((Block) wartecmodBlocks.LaunchTube);
	}

	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
		TileEntityVlsLaunchTube tileentityfurnace;
		if (!keepInventory && (tileentityfurnace = (TileEntityVlsLaunchTube)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_)) != null) {
			for (int i1 = 0; i1 < tileentityfurnace.getSizeInventory(); ++i1) {
				ItemStack itemstack = tileentityfurnace.getStackInSlot(i1);
				if (itemstack == null) continue;
				float f = field_149933_a.nextFloat() * 0.8f + 0.1f;
				float f1 = field_149933_a.nextFloat() * 0.8f + 0.1f;
				float f2 = field_149933_a.nextFloat() * 0.8f + 0.1f;
				while (itemstack.stackSize > 0) {
					int j1 = field_149933_a.nextInt(21) + 10;
					if (j1 > itemstack.stackSize) {
						j1 = itemstack.stackSize;
					}
					itemstack.stackSize -= j1;
					EntityItem entityitem = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + f), (double)((float)p_149749_3_ + f1), (double)((float)p_149749_4_ + f2), new ItemStack(itemstack.getItem(), j1));
					if (itemstack.hasTagCompound()) {
						entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
					}
					float f3 = 0.05f;
					entityitem.motionX = (float)field_149933_a.nextGaussian() * f3;
					entityitem.motionY = (float)field_149933_a.nextGaussian() * f3 + 0.2f;
					entityitem.motionZ = (float)field_149933_a.nextGaussian() * f3;
					p_149749_1_.spawnEntityInWorld((Entity)entityitem);
				}
			}
			p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
		}
		super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(world.isRemote) {
			return true;
		} else if(!player.isSneaking()) {
			int[] pos = this.findCore(world, x, y, z);

			if(pos == null)
				return false;
			FMLNetworkHandler.openGui(player, wartecmod.instance, 1, world, pos[0], pos[1], pos[2]);
			return true;
		} else {
			return true;
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && !world.isRemote) {
			int[] pos = this.findCore(world, x, y, z);
			if(pos == null)
				return;
			TileEntityVlsLaunchTube te = (TileEntityVlsLaunchTube) world.getTileEntity(pos[0], pos[1], pos[2]);
			te.shoot = 50;
		}
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
		return new int[] {height, 0, 0, 0, 0, 0};
	}

	@Override
	public int getOffset() {
		return 0;
	}

	@SideOnly(value=Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
		return Item.getItemFromBlock((Block) wartecmodBlocks.LaunchTube);
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

	public boolean hasComparatorInputOverride()
	{
		return true;
	}

	/**
	 * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
	 * strength when this block inputs to a comparator.
	 */
	public int getComparatorInputOverride(World world, int x, int y, int z, int m)
	{
		int[] pos = this.findCore(world, x, y, z);
		if(pos == null)
			return 0;

		TileEntityVlsLaunchTube te = (TileEntityVlsLaunchTube) world.getTileEntity(pos[0], pos[1], pos[2]);
		if(te == null)
			return 0;

		return te.slots[0] == null ? 0 : 15;
	}

	@Override
	public BombReturnCode explode(World world, int x, int y, int z) {
		int[] pos = this.findCore(world, x, y, z);
		if(pos == null)
			return BombReturnCode.UNDEFINED;
		TileEntityVlsLaunchTube te = (TileEntityVlsLaunchTube) world.getTileEntity(pos[0], pos[1], pos[2]);
		return te.shoot(world, x, y, z);
	}
}

