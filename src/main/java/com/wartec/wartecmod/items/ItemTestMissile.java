package com.wartec.wartecmod.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemTestMissile
        extends Item
        implements IMissileSpawningItem {
    Class<? extends Entity> missile;

    public ItemTestMissile(Class<? extends Entity> missile) {
        this.setMaxStackSize(1);
        this.missile = missile;
    }

    @Override
    public Class<? extends Entity> getMissile() {
        return missile;
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add((Object) EnumChatFormatting.BOLD + "TEST");
    }
}

