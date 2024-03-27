package com.wartec.wartecmod.items.tool;

import java.util.List;


import api.hbm.item.IDesignatorItem;
import com.wartec.wartecmod.blocks.vls.VlsVerticalLauncher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemTargetFinder extends Item implements IDesignatorItem {

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
		if(itemstack.stackTagCompound != null) {
			list.add("Target Coordinates:");
			list.add("X: " + itemstack.stackTagCompound.getInteger("xCoord"));
			list.add("Y: " + itemstack.stackTagCompound.getInteger("yCoord"));
			list.add("Z: " + itemstack.stackTagCompound.getInteger("zCoord"));
		} else {
			list.add("Please select a target.");
		}
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		if(!(world.getBlock(x, y, z) instanceof VlsVerticalLauncher)) {

			if(stack.stackTagCompound == null)
				stack.stackTagCompound = new NBTTagCompound();
			
			stack.stackTagCompound.setInteger("xCoord", x);
			stack.stackTagCompound.setInteger("yCoord", y);
			stack.stackTagCompound.setInteger("zCoord", z);
			
			if(world.isRemote) {
				player.addChatMessage(new ChatComponentText("Position set!"));
			}

			world.playSoundAtEntity(player, "hbm:item.techBleep", 1.0F, 1.0F);

			return true;
		}

		return false;
	}

	@Override
	public boolean isReady(World world, ItemStack stack, int x, int y, int z) {
		return stack.hasTagCompound();
	}

	@Override
	public Vec3 getCoords(World world, ItemStack stack, int x, int y, int z) {
		return Vec3.createVectorHelper(stack.stackTagCompound.getInteger("xCoord"), stack.stackTagCompound.getInteger("yCoord"), stack.stackTagCompound.getInteger("zCoord"));
	}
}
