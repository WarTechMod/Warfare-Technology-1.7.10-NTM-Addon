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

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemCruiseMissileSubsonic
extends Item
implements IMissileSpawningItem {
    Class<? extends Entity> missile;

    public ItemCruiseMissileSubsonic(Class<? extends Entity> missile) {
        this.setMaxStackSize(1);
        this.missile = missile;
    }

    @Override
    public Class<? extends Entity> getMissile() {
        return missile;
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add(EnumChatFormatting.BOLD + "Speed: " + EnumChatFormatting.RED + "Subsonic");
        list.add(EnumChatFormatting.BOLD + "Propulsion: " + EnumChatFormatting.RED + "Turbojet");
        list.add(EnumChatFormatting.BOLD + "Size: " + EnumChatFormatting.GRAY + "51.8cm");
        list.add(EnumChatFormatting.BOLD + "Min. Range: " + EnumChatFormatting.GRAY + "250 Blocks");
        list.add(EnumChatFormatting.BOLD + "Max. Range: " + EnumChatFormatting.GREEN + "3500 Blocks");
        list.add(EnumChatFormatting.BOLD + "Inaccuracy: " + EnumChatFormatting.GREEN + "< 3 Blocks");
        list.add(EnumChatFormatting.BOLD + "Health: " + EnumChatFormatting.GREEN + "10.0HP");
    }
}

