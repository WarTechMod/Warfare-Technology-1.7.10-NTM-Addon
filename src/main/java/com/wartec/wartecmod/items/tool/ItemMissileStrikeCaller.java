package com.wartec.wartecmod.items.tool;

import api.hbm.item.IDesignatorItem;
import com.hbm.interfaces.IBomb;
import com.hbm.lib.Library;
import com.hbm.util.ChatBuilder;
import com.wartec.wartecmod.blocks.vls.VlsVerticalLauncher;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsLaunchTube;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class ItemMissileStrikeCaller extends Item implements IDesignatorItem {

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
        if(itemstack.stackTagCompound != null) {
            list.add("VLS-Block Coordinates:");
            list.add("X: " + itemstack.stackTagCompound.getInteger("vlsX"));
            list.add("y: " + itemstack.stackTagCompound.getInteger("vlsX"));
            list.add("Z: " + itemstack.stackTagCompound.getInteger("vlsZ"));
            list.add("Target Coordinates:");
            list.add("X: " + itemstack.stackTagCompound.getInteger("targetX"));
            list.add("Y: " + itemstack.stackTagCompound.getInteger("targetY"));
            list.add("Z: " + itemstack.stackTagCompound.getInteger("targetZ"));
        } else {
            list.add("Please select a target and VLS launcher!");
        }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if(world.getBlock(x, y, z) instanceof VlsVerticalLauncher) {

            if(stack.stackTagCompound == null)
                stack.stackTagCompound = new NBTTagCompound();

            stack.stackTagCompound.setInteger("vlsX", x);
            stack.stackTagCompound.setInteger("vlsY", y);
            stack.stackTagCompound.setInteger("vlsZ", z);

            if(world.isRemote) {
                player.addChatMessage(new ChatComponentText("Set VLS launcher position!"));
            }

            world.playSoundAtEntity(player, "hbm:item.techBleep", 1.0F, 1.0F);

            return true;
        }else {

            if(stack.stackTagCompound == null)
                stack.stackTagCompound = new NBTTagCompound();

            stack.stackTagCompound.setInteger("targetX", x);
            stack.stackTagCompound.setInteger("targetY", y);
            stack.stackTagCompound.setInteger("targetZ", z);

            if(world.isRemote) {
                player.addChatMessage(new ChatComponentText("Set target position!"));
            }

            world.playSoundAtEntity(player, "hbm:item.techBleep", 1.0F, 1.0F);

            return true;
        }

    }

    private void sendNotSet(World world, EntityPlayer player, String msg) {
        if(!world.isRemote) {
            player.addChatMessage(ChatBuilder.start("[").color(EnumChatFormatting.DARK_AQUA)
                    .nextTranslation(this.getUnlocalizedName() + ".name").color(EnumChatFormatting.DARK_AQUA)
                    .next("] ").color(EnumChatFormatting.DARK_AQUA)
                    .next("No positions set!").color(EnumChatFormatting.RED).flush());
        }
    }

    private void sendError(World world, EntityPlayer player) {
        if(!world.isRemote) {
            player.addChatMessage(ChatBuilder.start("[").color(EnumChatFormatting.DARK_AQUA)
                    .nextTranslation(this.getUnlocalizedName() + ".name").color(EnumChatFormatting.DARK_AQUA)
                    .next("] ").color(EnumChatFormatting.DARK_AQUA)
                    .nextTranslation(IBomb.BombReturnCode.ERROR_NO_BOMB.getUnlocalizedMessage()).color(EnumChatFormatting.RED).flush());
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if(stack.stackTagCompound == null || !stack.stackTagCompound.hasKey("targetX")) {
            MovingObjectPosition pos = Library.rayTrace(player, 300, 1);
            int x = pos.blockX;
            int y = pos.blockY;
            int z = pos.blockZ;

            if(!(world.getBlock(x, y, z) instanceof VlsVerticalLauncher)) {

                if(stack.stackTagCompound == null)
                    stack.stackTagCompound = new NBTTagCompound();

                stack.stackTagCompound.setInteger("targetX", x);
                stack.stackTagCompound.setInteger("targetY", y);
                stack.stackTagCompound.setInteger("targetZ", z);

                if(world.isRemote) {
                    player.addChatMessage(new ChatComponentText("Target position set to X:" + x + ", Y:" + y +", Z:" + z));
                }

                world.playSoundAtEntity(player, "hbm:item.techBleep", 1.0F, 1.0F);

                return stack;
            }

            return stack;
        } else {
            if(!stack.stackTagCompound.hasKey("vlsX")) {
                sendNotSet(world, player, "VLS position not set!");
                return stack;
            }

            if(!stack.stackTagCompound.hasKey("targetX")) {
                sendNotSet(world, player, "Target position not set!");
                return stack;
            }

            int vlsX = stack.stackTagCompound.getInteger("vlsX");
            int vlsY = stack.stackTagCompound.getInteger("vlsY");
            int vlsZ = stack.stackTagCompound.getInteger("vlsZ");

            int targetX = stack.stackTagCompound.getInteger("targetX");
            int targetY = stack.stackTagCompound.getInteger("targetY");
            int targetZ = stack.stackTagCompound.getInteger("targetZ");

            if(world.getBlock(vlsX, vlsY, vlsZ) instanceof VlsVerticalLauncher) {
                int[] pos = ((VlsVerticalLauncher)world.getBlock(vlsX, vlsY, vlsZ)).findCore(world, vlsX, vlsY, vlsZ);
                if(pos == null) {
                    sendError(world, player);
                    return stack;
                }
                TileEntityVlsLaunchTube te = (TileEntityVlsLaunchTube) world.getTileEntity(pos[0], pos[1], pos[2]);

                world.playSoundAtEntity(player, "hbm:item.techBleep", 1.0F, 1.0F);
                if(!world.isRemote) {
                    IBomb.BombReturnCode ret = te.shootSpecial(world, pos[0], pos[1], pos[2], targetX, targetY, targetZ);

                    player.addChatMessage(ChatBuilder.start("[").color(EnumChatFormatting.DARK_AQUA)
                            .nextTranslation(this.getUnlocalizedName() + ".name").color(EnumChatFormatting.DARK_AQUA)
                            .next("] ").color(EnumChatFormatting.DARK_AQUA)
                            .nextTranslation(ret.getUnlocalizedMessage()).color(ret.wasSuccessful() ? EnumChatFormatting.YELLOW : EnumChatFormatting.RED).flush());

                    stack.stackTagCompound.removeTag("targetX");
                    stack.stackTagCompound.removeTag("targetY");
                    stack.stackTagCompound.removeTag("targetZ");
                }

            } else {
                sendError(world, player);
            }
        }

        return stack;

    }

    @Override
    public boolean isReady(World world, ItemStack stack, int x, int y, int z) {
        return stack.hasTagCompound();
    }

    @Override
    public Vec3 getCoords(World world, ItemStack stack, int x, int y, int z) {
        return Vec3.createVectorHelper(stack.stackTagCompound.getInteger("targetX"), stack.stackTagCompound.getInteger("targetY"), stack.stackTagCompound.getInteger("targetZ"));
    }
}
