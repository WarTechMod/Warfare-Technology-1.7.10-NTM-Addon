package com.wartec.wartecmod.items;

import com.hbm.items.ItemCustomLore;
import com.hbm.items.weapon.ItemMissile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemCruiseMissile extends ItemCustomLore {

    public final ItemCruiseMissile.MissileFormFactor formFactor;
    public final ItemCruiseMissile.MissileTier tier;
    public final ItemCruiseMissile.MissileFuel fuel;
    public int fuelCap;
    public boolean launchable = true;

    public ItemCruiseMissile(ItemCruiseMissile.MissileFormFactor form, ItemCruiseMissile.MissileTier tier) {
        this(form, tier, form.defaultFuel);
    }

    public ItemCruiseMissile(ItemCruiseMissile.MissileFormFactor form, ItemCruiseMissile.MissileTier tier, ItemCruiseMissile.MissileFuel fuel) {
        this.formFactor = form;
        this.tier = tier;
        this.fuel = fuel;
        this.setFuelCap(this.fuel.defaultCap);
    }

    public ItemCruiseMissile notLaunchable() {
        this.launchable = false;
        return this;
    }

    public ItemCruiseMissile setFuelCap(int fuelCap) {
        this.fuelCap = fuelCap;
        return this;
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool) {
        list.add(EnumChatFormatting.ITALIC + this.tier.display);

        if(!this.launchable) {
            list.add(EnumChatFormatting.RED + "Not launchable!");
        } else {
            list.add("Fuel: " + this.fuel.display);
            if(this.fuelCap > 0) list.add("Fuel capacity: " + this.fuelCap + "mB");
            super.addInformation(itemstack, player, list, bool);
        }
    }

    public enum MissileFormFactor {
        //ABM(ItemCruiseMissile.MissileFuel.SOLID),
        MICRO(ItemCruiseMissile.MissileFuel.SOLID),
        //V2(ItemCruiseMissile.MissileFuel.ETHANOL_PEROXIDE),
        //STRONG(ItemCruiseMissile.MissileFuel.KEROSENE_PEROXIDE),
        //HUGE(ItemCruiseMissile.MissileFuel.KEROSENE_LOXY),
        //ATLAS(ItemCruiseMissile.MissileFuel.JETFUEL_LOXY),
        OTHER(MissileFuel.CRUISE_MISSILE);

        protected ItemCruiseMissile.MissileFuel defaultFuel;

        private MissileFormFactor(ItemCruiseMissile.MissileFuel defaultFuel) {
            this.defaultFuel = defaultFuel;
        }
    }

    public enum MissileTier {
        Tier0("Subsonic Cruise Missile"),
        TIER1("Supersonic Cruise Missile"),
        TIER2("Hypersonic Cruise Missile"),
        TIER3("Tier 3"),
        TIER4("Tier 4");

        public String display;

        private MissileTier(String display) {
            this.display = display;
        }
    }

    public enum MissileFuel {
        CRUISE_MISSILE(EnumChatFormatting.RED + "Jet Fuel", 16_000),
        SOLID(EnumChatFormatting.GOLD + "Solid Fuel (pre-fueled)", 0);

        public String display;
        public int defaultCap;

        private MissileFuel(String display, int defaultCap) {
            this.display = display;
            this.defaultCap = defaultCap;
        }
    }
}