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

import com.wartec.wartecmod.entity.missile.EntityIskanderMissile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemIskanderMissile
extends Item
implements IMissileSpawningItem {

    public ItemIskanderMissile() {
        this.setMaxStackSize(1);
        this.setUnlocalizedName("ItemIskanderMissile");
    }

    @Override
    public Class<? extends Entity> getMissile() {
        return EntityIskanderMissile.class;
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add((Object)EnumChatFormatting.BOLD + "Warhead: " + (Object)EnumChatFormatting.YELLOW + "HE");
        list.add((Object)EnumChatFormatting.BOLD + "Strength: " + (Object)EnumChatFormatting.GRAY + "40.0");
        list.add((Object)EnumChatFormatting.BOLD + "Size: " + (Object)EnumChatFormatting.GRAY + "7.30m");
    }
}

