/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.hbm.items.machine.ItemSatChip
 *  cpw.mods.fml.common.registry.GameRegistry
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemFood
 */
package com.wartec.wartecmod.items;

import com.hbm.items.machine.ItemSatChip;
import com.wartec.wartecmod.entity.missile.*;
import com.wartec.wartecmod.items.tool.*;
import com.wartec.wartecmod.wartecmod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class wartecmodItems {
    public static Item itemEngineInletSectionTier1;
    public static Item itemTurbofanEngineTier1;
    public static Item itemSolidBooster;
    public static Item itemCruiseMissileNoWarheadTier1;
    public static Item itemCruiseFinsSmall;
    public static Item itemCruiseFinsBig;
    public static Item itemCruiseWings;
    public static Item itemGuidanceSystemTier1;
    public static Item itemGuidanceSystemTier2;
    public static Item itemGuidanceSystemTier3;
    public static Item itemGuidanceSystemTier4;
    public static Item itemGuidanceSystemTier5;
    public static Item itemGuidanceSystemTier6;
    public static Item itemWarheadHeCM;
    public static Item itemWarheadNuclearCM;
    public static Item itemWarheadBuster;
    public static Item itemWarheadCluster;
    public static Item itemWarheadGas;
    public static Item itemWarheadNeutron;
    public static Item itemWarheadTB;
    public static Item itemWarheadHCM;
    public static Item itemWarheadEmp;
    public static Item itemKKV;
    public static Item itemHWarhead;
    public static Item itemPlateU238;
    public static Item itemIngotArmorSteel;
    public static Item sat_nuclear;
    public static Item sat_emp;
    public static Item itemCruiseMissileHe;
    public static Item itemCruiseMissileCluster;
    public static Item itemMissileStrongAntiBallistic;
    public static Item itemCruiseMissileNuclear;
    public static Item itemCruiseMissileH;
    public static Item itemCruiseMissileBuster;
    public static Item itemCruiseMissileTB;
    public static Item itemCruiseMissileEmp;
    public static Item itemCruiseMissileDecoy;
    public static Item itemCruiseMissileFragmentation;
    public static Item itemCruiseMissileMiniNuke;
    public static Item itemCruiseMissileWP;
    public static Item itemMissileSLBM;
    public static Item itemKalibrMissile;
    public static Item itemTomahawkMissile;
    public static Item itemCj10Missile;
    public static Item itemIskanderMissile;
    public static Item itemLrhwMissile;
    public static Item itemHypersonicCruiseMissileHE;
    public static Item itemSupersonicCruiseMissileHE;
    public static Item itemHypersonicCruiseMissileNuclear;
    public static Item itemSupersonicCruiseMissileH;
    public static Item itemMissileMicroGas;
    public static Item itemMissileMicroNeutron;
    public static Item itemMissileAsat;
    public static Item itemMissileAntiBallisticNuclear;
    public static Item itemMissileAntiAirTier1;
    public static Item itemMissileAntiAirTier2;
    public static Item itemMissileAntiAirTier3;
    public static Item itemMincedMeatRaw;
    public static Item itemMincedMeatCooked;
    public static Item itemTargetFinder;
    public static Item itemMissileStrikeCaller;

    public static void Items() {
        wartecmodItems.initializeItem();
        wartecmodItems.registerItem();
    }

    public static void initializeItem() {
        itemCruiseMissileNoWarheadTier1 = new Item().setUnlocalizedName("ItemCruiseMissileNoWarheadTier1").setCreativeTab(wartecmod.tabwartecmodparts).setTextureName("wartecmod:ItemCruiseMissileNoWarheadTier1");
        itemEngineInletSectionTier1 = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemEngineInletSectionTier1").setTextureName("wartecmod:ItemEngineInletSectionTier1");
        itemTurbofanEngineTier1 = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemTurbofanEngineTier1").setTextureName("wartecmod:ItemTurbofanEngineTier1");
        itemSolidBooster = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemSolidBooster").setTextureName("wartecmod:ItemSolidBooster");
        itemWarheadHeCM = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadHeCM").setTextureName("wartecmod:ItemWarheadHeCM");
        itemWarheadCluster = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadCluster").setTextureName("wartecmod:ItemWarheadCluster");
        itemWarheadBuster = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadBuster").setTextureName("wartecmod:ItemWarheadBuster");
        itemWarheadGas = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadGas").setTextureName("wartecmod:ItemWarheadGas");
        itemWarheadNeutron = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadNeutron").setTextureName("wartecmod:ItemWarheadNeutron");
        itemWarheadNuclearCM = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadNuclearCM").setTextureName("wartecmod:ItemWarheadNuclearCM");
        itemWarheadHCM = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadHCM").setTextureName("wartecmod:ItemWarheadHCM");
        itemWarheadTB = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadFAE").setTextureName("wartecmod:ItemWarheadFAE");
        itemWarheadEmp = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemWarheadEmp").setTextureName("wartecmod:ItemWarheadEmp");
        itemKKV = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemKKV").setTextureName("wartecmod:ItemKKV");
        itemHWarhead = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemHWarhead").setTextureName("wartecmod:ItemHWarhead");
        itemGuidanceSystemTier1 = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemGuidanceSystemTier1").setTextureName("wartecmod:ItemGuidanceSystemTier1");
        itemGuidanceSystemTier2 = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemGuidanceSystemTier2").setTextureName("wartecmod:ItemGuidanceSystemTier2");
        itemGuidanceSystemTier3 = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemGuidanceSystemTier3").setTextureName("wartecmod:ItemGuidanceSystemTier3");
        itemGuidanceSystemTier4 = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemGuidanceSystemTier4").setTextureName("wartecmod:ItemGuidanceSystemTier4");
        itemGuidanceSystemTier5 = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemGuidanceSystemTier5").setTextureName("wartecmod:ItemGuidanceSystemTier5");
        itemGuidanceSystemTier6 = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemGuidanceSystemTier6").setTextureName("wartecmod:ItemGuidanceSystemTier6");
        itemPlateU238 = new Item().setUnlocalizedName("ItemPlateU238").setCreativeTab(wartecmod.tabwartecmodparts).setTextureName("wartecmod:ItemPlateU238");
        itemIngotArmorSteel = new Item().setUnlocalizedName("IngotArmorSteel").setCreativeTab(wartecmod.tabwartecmodparts).setTextureName("wartecmod:ItemIngotArmorSteel");
        itemCruiseFinsSmall = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemCruiseFinsSmall").setTextureName("wartecmod:ItemCruiseFinsSmall");
        itemCruiseFinsBig = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemCruiseFinsBig").setTextureName("wartecmod:ItemCruiseFinsBig");
        itemCruiseWings = new Item().setCreativeTab(wartecmod.tabwartecmodparts).setMaxStackSize(64).setUnlocalizedName("ItemCruiseWings").setTextureName("wartecmod:ItemCruiseWings");
        itemCruiseMissileHe = new ItemCruiseMissileSubsonic(EntityCruiseMissileHE.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileHe").setTextureName("wartecmod:ItemCruiseMissileHe");
        itemCruiseMissileEmp = new ItemCruiseMissileSubsonic(EntityCruiseMissileEmp.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileEmp").setTextureName("wartecmod:ItemCruiseMissileEmp");
        itemCruiseMissileNuclear = new ItemCruiseMissileSubsonic(EntityCruiseMissileNuclear.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileNuclear").setTextureName("wartecmod:ItemCruiseMissileNuclear");
        itemCruiseMissileH = new ItemCruiseMissileSubsonic(EntityCruiseMissileH.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileH").setTextureName("wartecmod:ItemCruiseMissileH");
        itemCruiseMissileCluster = new ItemCruiseMissileSubsonic(EntityCruiseMissileCluster.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileCluster").setTextureName("wartecmod:ItemCruiseMissileCluster");
        itemKalibrMissile = new ItemKalibrMissile().setCreativeTab(wartecmod.tabwartecmodcruisemissiles);
        itemCj10Missile = new ItemCj10Missile(EntityCJ10Missile.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles);
        itemTomahawkMissile = new ItemTomahawkMissile().setCreativeTab(wartecmod.tabwartecmodcruisemissiles);
        itemCruiseMissileBuster = new ItemCruiseMissileSubsonic(EntityCruiseMissileBuster.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileBuster").setTextureName("wartecmod:ItemCruiseMissileBuster");
        itemCruiseMissileEmp = new ItemCruiseMissileSubsonic(EntityCruiseMissileEmp.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileEmp").setTextureName("wartecmod:ItemCruiseMissileEmp");
        itemCruiseMissileTB = new ItemCruiseMissileSubsonic(EntityCruiseMissileTB.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileFAE").setTextureName("wartecmod:ItemCruiseMissileFAE");
        itemCruiseMissileDecoy = new ItemCruiseMissileSubsonic(EntityCruiseMissileSubsonic.EntityCruiseMissileTest.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileDecoy").setTextureName("wartecmod:ItemCruiseMissileDecoy");
        itemCruiseMissileFragmentation = new ItemCruiseMissileSubsonic(EntityCruiseMissileFragmentation.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileFragmentation").setTextureName("wartecmod:ItemCruiseMissileFragmentation");
        itemCruiseMissileMiniNuke = new ItemCruiseMissileSubsonic(EntityCruiseMissileMiniNuke.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileMiniNuke").setTextureName("wartecmod:ItemCruiseMissileMiniNuke");
        itemCruiseMissileWP = new ItemCruiseMissileSubsonic(EntityCruiseMissileWP.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemCruiseMissileWP").setTextureName("wartecmod:ItemCruiseMissileWP");
        itemMissileSLBM = new Item().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemMissileSLBM").setTextureName("wartecmod:ItemMissileSLBM");
        itemIskanderMissile = new ItemIskanderMissile().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemIskanderMissile").setTextureName("wartecmod:ItemIskanderMissile");
        itemLrhwMissile = new Item().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemLrhwMissile").setTextureName("wartecmod:ItemLrhwMissile");
        itemHypersonicCruiseMissileHE = new ItemCruiseMissileHypersonic(EntityHypersonicCruiseMissileHE.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemHypersonicCruiseMissileHE").setTextureName("wartecmod:ItemHypersonicCruiseMissileHe");
        itemSupersonicCruiseMissileHE = new ItemCruiseMissileSupersonic(EntitySupersonicCruiseMissileHE.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemSupersonicCruiseMissileHE").setTextureName("wartecmod:ItemSupersonicCruiseMissileHe");
        itemHypersonicCruiseMissileNuclear = new ItemCruiseMissileHypersonic(EntityHypersonicCruiseMissileNuclear.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemHypersonicCruiseMissileNuclear").setTextureName("wartecmod:ItemHypersonicCruiseMissileNuclear");
        itemSupersonicCruiseMissileH = new ItemCruiseMissileSupersonic(EntitySupersonicCruiseMissileH.class).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setUnlocalizedName("ItemSupersonicCruiseMissileH").setTextureName("wartecmod:ItemSupersonicCruiseMissileH");
        itemMissileMicroGas = new Item().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemMissileMicroGas").setTextureName("wartecmod:ItemMissileMicroGas");
        itemMissileMicroNeutron = new Item().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemMissileMicroNeutron").setTextureName("wartecmod:ItemMissileMicroNeutron");
        itemMissileAntiBallisticNuclear = new Item().setMaxStackSize(1).setUnlocalizedName("ItemMissileAntiBallisticNuclear").setTextureName("wartecmod:ItemMissileAntiBallisticNuclear");
        itemMissileAntiAirTier1 = new ItemMissileAntiAirTier1().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemMissileAntiAirTier1").setTextureName("wartecmod:ItemMissileAntiAirTier1");
        itemMissileAntiAirTier2 = new ItemMissileAntiAirTier2().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemMissileAntiAirTier2").setTextureName("wartecmod:ItemMissileAntiAirTier2");
        itemMissileAntiAirTier3 = new ItemMissileAntiAirTier3().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemMissileAntiAirTier3").setTextureName("wartecmod:ItemMissileAntiAirTier3");
        itemMincedMeatRaw = new ItemFood(1, 0.0f, false).setUnlocalizedName("ItemMincedMeatRaw").setCreativeTab(wartecmod.tabwartecmodcons).setTextureName("wartecmod:ItemMincedMeatRaw");
        itemMincedMeatCooked = new ItemFood(4, 0.0f, false).setUnlocalizedName("ItemMincedMeatCooked").setCreativeTab(wartecmod.tabwartecmodcons).setTextureName("wartecmod:ItemMincedMeatCooked");
        sat_nuclear = new ItemSatChip().setUnlocalizedName("sat_nuclear").setMaxStackSize(1).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setTextureName("wartecmod:ItemSatelliteNuclear");
        sat_emp = new ItemSatChip().setUnlocalizedName("sat_emp").setMaxStackSize(1).setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setTextureName("hbm:sat_mapper");
        itemTargetFinder = new ItemTargetFinder().setUnlocalizedName("ItemTargetFinder").setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setTextureName("wartecmod:ItemTargetFinder");
        itemMissileStrikeCaller = new ItemMissileStrikeCaller().setUnlocalizedName("ItemMissileStrikeCaller").setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setTextureName("wartecmod:ItemMissileStrikeCaller");
        itemMissileAsat = new Item().setCreativeTab(wartecmod.tabwartecmodcruisemissiles).setMaxStackSize(1).setUnlocalizedName("ItemMissileASAT").setTextureName("wartecmod:ItemMissileASAT");

    }

    private static void registerItem() {
        GameRegistry.registerItem(itemCruiseMissileNoWarheadTier1, (String)"ItemCruiseMissileNoWarheadTier1");
        GameRegistry.registerItem(itemEngineInletSectionTier1, (String)"ItemEngineInletSectionTier1");
        GameRegistry.registerItem(itemTurbofanEngineTier1, (String)"ItemTurbofanEngineTier1");
        GameRegistry.registerItem(itemSolidBooster, (String)"ItemSolidBooster");
        GameRegistry.registerItem(itemWarheadHeCM, (String)"ItemWarheadHeCM");
        GameRegistry.registerItem(itemWarheadCluster, (String)"ItemWarheadCluster");
        GameRegistry.registerItem(itemWarheadBuster, (String)"ItemWarheadBuster");
        GameRegistry.registerItem(itemWarheadEmp, (String)"ItemWarheadEmp");
        GameRegistry.registerItem(itemWarheadTB, (String)"ItemWarheadTB");
        GameRegistry.registerItem(itemWarheadNuclearCM, (String)"ItemWarheadNuclearCM");
        GameRegistry.registerItem(itemWarheadHCM, (String)"ItemWarheadHCM");
        GameRegistry.registerItem(itemKKV, (String)"ItemKKV");
        GameRegistry.registerItem(itemHWarhead, (String)"ItemHWarhead");
        GameRegistry.registerItem(itemWarheadGas, (String)"ItemWarheadGas");
        GameRegistry.registerItem(itemWarheadNeutron, (String)"ItemWarheadNeutron");
        GameRegistry.registerItem(itemGuidanceSystemTier1, (String)"ItemGuidanceSystemTier1");
        GameRegistry.registerItem(itemGuidanceSystemTier2, (String)"ItemGuidanceSystemTier2");
        GameRegistry.registerItem(itemGuidanceSystemTier3, (String)"ItemGuidanceSystemTier3");
        GameRegistry.registerItem(itemGuidanceSystemTier4, (String)"ItemGuidanceSystemTier4");
        GameRegistry.registerItem(itemGuidanceSystemTier5, (String)"ItemGuidanceSystemTier5");
        GameRegistry.registerItem(itemGuidanceSystemTier6, (String)"ItemGuidanceSystemTier6");
        GameRegistry.registerItem(itemCruiseFinsSmall, (String)"ItemCruiseFinsSmall");
        GameRegistry.registerItem(itemCruiseFinsBig, (String)"ItemCruiseFinsBig");
        GameRegistry.registerItem(itemCruiseWings, (String)"ItemCruiseWings");
        GameRegistry.registerItem(itemPlateU238, (String)itemPlateU238.getUnlocalizedName());
        GameRegistry.registerItem(itemIngotArmorSteel, (String)"ItemIngotArmorSteel");
        GameRegistry.registerItem(itemCruiseMissileHe, (String)"ItemCruiseMissileHe");
        GameRegistry.registerItem(itemCruiseMissileCluster, (String)"ItemCruiseMissileCluster");
        GameRegistry.registerItem(itemCruiseMissileBuster, (String)"ItemCruiseMissileBuster");
        GameRegistry.registerItem(itemCruiseMissileEmp, (String)"ItemCruiseMissileEmp");
        GameRegistry.registerItem(itemCruiseMissileTB, (String)"ItemCruiseMissileTB");
        GameRegistry.registerItem(itemCruiseMissileNuclear, (String)"ItemCruiseMissileNuclear");
        GameRegistry.registerItem(itemCruiseMissileH, (String)"ItemCruiseMissileH");
        GameRegistry.registerItem(itemCruiseMissileDecoy, (String)"ItemCruiseMissileDecoy");
        GameRegistry.registerItem(itemCruiseMissileFragmentation, (String)"ItemCruiseMissileFragmentation");
        GameRegistry.registerItem(itemCruiseMissileMiniNuke, (String)"ItemCruiseMissileMiniNuke");
        GameRegistry.registerItem(itemCruiseMissileWP, (String)"ItemCruiseMissileWP");
        GameRegistry.registerItem(itemSupersonicCruiseMissileHE, (String)"ItemSupersonicCruiseMissileHE");
        GameRegistry.registerItem(itemSupersonicCruiseMissileH, (String)"ItemSupersonicCruiseMissileH");
        GameRegistry.registerItem(itemHypersonicCruiseMissileHE, (String)"ItemHypersonicCruiseMissileHE");
        GameRegistry.registerItem(itemHypersonicCruiseMissileNuclear, (String)"ItemHypersonicCruiseMissileNuclear");
        GameRegistry.registerItem(itemLrhwMissile, (String)"ItemLrhwMissile");
        GameRegistry.registerItem(itemMissileSLBM, (String)"ItemMissileSLBM");
        GameRegistry.registerItem(itemMissileMicroGas, (String)"ItemMissileMicroGas");
        GameRegistry.registerItem(itemMissileMicroNeutron, (String)"ItemMissileMicroNeutron");
        GameRegistry.registerItem(itemMissileAntiAirTier1, (String)"ItemMissileAntiAirTier1");
        GameRegistry.registerItem(itemMissileAntiAirTier2, (String)"ItemMissileAntiAirTier2");
        GameRegistry.registerItem(itemMissileAntiAirTier3, (String)"ItemMissileAntiAirTier3");
        GameRegistry.registerItem(itemMissileAntiBallisticNuclear, (String)"ItemMissileAntiBallisticNuclear");
        GameRegistry.registerItem(itemTomahawkMissile, (String)"ItemTomahawkMissile");
        GameRegistry.registerItem(itemKalibrMissile, (String)"ItemKalibrMissile");
        GameRegistry.registerItem(itemCj10Missile, (String)"ItemCj10Missile");
        GameRegistry.registerItem(itemIskanderMissile, (String)"ItemIskanderMissile");
        GameRegistry.registerItem(itemMincedMeatRaw, (String)itemMincedMeatRaw.getUnlocalizedName());
        GameRegistry.registerItem(itemMincedMeatCooked, (String)itemMincedMeatCooked.getUnlocalizedName());
        GameRegistry.registerItem(sat_nuclear, (String)sat_nuclear.getUnlocalizedName());
        GameRegistry.registerItem(sat_emp, (String)sat_emp.getUnlocalizedName());
        GameRegistry.registerItem(itemTargetFinder, (String)itemTargetFinder.getUnlocalizedName());
        GameRegistry.registerItem(itemMissileStrikeCaller, itemMissileStrikeCaller.getUnlocalizedName());
        GameRegistry.registerItem(itemMissileAsat, (String)"ItemMissileASAT");

    }
}

