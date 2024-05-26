package com.wartec.wartecmod.items.tool;

import com.hbm.entity.logic.EntityBomber;
import com.hbm.lib.Library;
import com.hbm.world.WorldUtil;
import com.wartec.wartecmod.entity.missile.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class ItemCruiseMissileSupport extends Item {

    public ItemCruiseMissileSupport() {
        super();
        this.setHasSubtypes(true);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
    {
        list.add("Aim & click to mark target!");

        switch (stack.getItemDamage()) {
            case 1: list.add("Type: Fragmentation Cruise Missile"); break;
            case 2: list.add("Type: HE Cruise Missile"); break;
            case 3: list.add("Type: Phosphorus Cruise Missile"); break;
            case 4: list.add("Type: Nuclear Cruise Missile"); break;
            case 5 : list.add("Type: Steatlh Cruise Missile"); break;
        }

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        MovingObjectPosition pos = Library.rayTrace(player, 500, 1);
        int x = pos.blockX;
        int y = pos.blockY;
        int z = pos.blockZ;

        if(!world.isRemote)
        {
            switch(stack.getItemDamage()) {
/*
                case 1: EntityAlcmFragmentation Missile = new EntityAlcmFragmentation(world);
                        Missile.setPosition(x + 500, 400, z + 500);
                        WorldUtil.loadAndSpawnEntityInWorld(Missile);
                case 2: EntityAlcmHE Missile1 = new EntityAlcmHE(world);
                        Missile1.setPosition(x + 500, 400, z + 500);
                        WorldUtil.loadAndSpawnEntityInWorld(Missile1);
                case 3: EntityAlcmWP Missile2 = new EntityAlcmWP(world);
                        Missile2.setPosition(x + 500, 400, z + 500);
                        WorldUtil.loadAndSpawnEntityInWorld(Missile2);
                case 4: EntityAlcmStealth Missile3 = new EntityAlcmStealth(world);
                        Missile3.setPosition(x, y, z);
                        WorldUtil.loadAndSpawnEntityInWorld(Missile3);
                case 5: EntityAlcmNuclear Missile4 = new EntityAlcmNuclear(world);
                        Missile4.setPosition(x-50, 400, z-50);
                        WorldUtil.loadAndSpawnEntityInWorld(Missile4);
                        */
            }
            player.addChatMessage(new ChatComponentText("Called in airstrike!"));
            world.playSoundAtEntity(player, "hbm:item.techBleep", 1.0F, 1.0F);

        }

        stack.stackSize -= 1;

        return stack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_)
    {
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 2));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 3));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 4));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 5));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return p_77636_1_.getItemDamage() >= 4;
    }
}
