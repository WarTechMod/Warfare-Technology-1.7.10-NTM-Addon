/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumChatFormatting
 */
package com.wartec.wartecmod.items;

import com.wartec.wartecmod.entity.missile.EntityKalibrMissile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemKalibrMissile
extends Item
implements IMissileSpawningItem {

    public ItemKalibrMissile() {
        this.setMaxStackSize(1);
        this.setUnlocalizedName("ItemKalibrMissile");
    }

    @Override
    public Class<? extends Entity> getMissile() {
        return EntityKalibrMissile.class;
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add((Object)EnumChatFormatting.BOLD + "Warhead: " + (Object)EnumChatFormatting.YELLOW + "HE");
        list.add((Object)EnumChatFormatting.BOLD + "Strength: " + (Object)EnumChatFormatting.GRAY + "25.0");
        list.add((Object)EnumChatFormatting.BOLD + "Size: " + (Object)EnumChatFormatting.GRAY + "7.20m");
        list.add((Object)EnumChatFormatting.BOLD + "Speed: " + (Object)EnumChatFormatting.RED + "Subsonic");
        list.add((Object)EnumChatFormatting.BOLD + "Propulsion: " + (Object)EnumChatFormatting.RED + "Turbojet");
        list.add((Object)EnumChatFormatting.BOLD + "Size: " + (Object)EnumChatFormatting.GRAY + "51.8cm");
        list.add((Object)EnumChatFormatting.BOLD + "Min. Range: " + (Object)EnumChatFormatting.GRAY + "250 Blocks");
        list.add((Object)EnumChatFormatting.BOLD + "Max. Range: " + (Object)EnumChatFormatting.GREEN + "3500 Blocks");
        list.add((Object)EnumChatFormatting.BOLD + "Health: " + (Object)EnumChatFormatting.GREEN + "10.0HP");
    }
}

