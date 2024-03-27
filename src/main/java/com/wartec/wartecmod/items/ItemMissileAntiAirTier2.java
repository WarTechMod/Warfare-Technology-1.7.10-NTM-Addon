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

import com.wartec.wartecmod.entity.missile.EntityMissileAntiAirTier2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemMissileAntiAirTier2
extends Item
implements IMissileSpawningItem {

    public ItemMissileAntiAirTier2() {
        this.setMaxStackSize(1);
        this.setUnlocalizedName("ItemMissileAntiAirTier2");
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add((Object)EnumChatFormatting.GOLD + "Can be used against:");
        list.add((Object)EnumChatFormatting.YELLOW + " Ballistic Missiles");
    }

    @Override
    public Class<? extends Entity> getMissile() {
        return EntityMissileAntiAirTier2.class;
    }
}

