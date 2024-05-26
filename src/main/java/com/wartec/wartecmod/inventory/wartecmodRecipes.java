package com.wartec.wartecmod.inventory;

import com.hbm.blocks.ModBlocks;
import com.hbm.inventory.OreDictManager;
import com.hbm.inventory.RecipesCommon;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.recipes.ArcWelderRecipes;
import com.hbm.inventory.recipes.AssemblerRecipes;
import com.hbm.inventory.recipes.ShredderRecipes;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.blocks.wartecmodBlocks;
import com.wartec.wartecmod.items.wartecmodItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static com.hbm.inventory.OreDictManager.ANY_HIGHEXPLOSIVE;

public class wartecmodRecipes {

    public static void Recipes() {

        //ArcWelder
        ArcWelderRecipes.recipes.add(new ArcWelderRecipes.ArcWelderRecipe(new ItemStack(wartecmodItems.itemMissileAsat, 1), 100, 5_000L,
                new RecipesCommon.ComparableStack(ModItems.thruster_medium, 1), new RecipesCommon.ComparableStack(ModItems.fuel_tank_medium), new RecipesCommon.ComparableStack(ModItems.mp_warhead_10_he)));
        //ASSembler
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileHe, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadHeCM, 1),},300);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileEmp, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier2, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadEmp, 1),},300);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNuclear, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier3, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadNuclearCM, 1),},300);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileH, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier4, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadHCM, 1),},300);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileBuster, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadBuster, 1),},300);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileCluster, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadCluster, 1), },300);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileTB, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier3, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadTB, 1), },300);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemMissileStrongAntiBallistic, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemKKV, 1),
                new RecipesCommon.ComparableStack(ModItems.fuel_tank_medium, 1),
                new RecipesCommon.ComparableStack(ModItems.thruster_medium, 1),
                new RecipesCommon.OreDictStack("plateTitanium", 10),
                new RecipesCommon.OreDictStack("plateSteel", 14),
                new RecipesCommon.ComparableStack(ModItems.circuit_targeting_tier4, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier6, 1), },350);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemMissileSLBM, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(wartecmodItems.itemHWarhead, 1),
                new RecipesCommon.ComparableStack(ModItems.fuel_tank_large, 1),
                new RecipesCommon.ComparableStack(ModItems.thruster_large, 1),
                new RecipesCommon.OreDictStack("plateTitanium", 20),
                new RecipesCommon.OreDictStack("plateSteel", 24),
                new RecipesCommon.OreDictStack("plateAluminum", 16),
                new RecipesCommon.ComparableStack(ModItems.circuit_targeting_tier4, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemGuidanceSystemTier5, 1), },750);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemEngineInletSectionTier1, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(ModItems.mechanism_revolver_2, 2), },150);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemTurbofanEngineTier1, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(ModItems.turbine_tungsten, 2),
                new RecipesCommon.ComparableStack(ModItems.turbine_titanium, 2),
                new RecipesCommon.ComparableStack(ModItems.ingot_red_copper, 4),
                new RecipesCommon.ComparableStack(ModItems.wire_copper, 6),
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseFinsSmall, 4),},300);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemSolidBooster, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(Items.flint_and_steel, 1),
                new RecipesCommon.ComparableStack(ModItems.rocket_fuel, 5), },125);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(ModItems.sphere_steel, 1),
                new RecipesCommon.ComparableStack(ModItems.circuit_targeting_tier1, 1),
                new RecipesCommon.ComparableStack(ModItems.fuel_tank_large, 1),
                new RecipesCommon.ComparableStack(ModItems.mechanism_revolver_2, 2),
                new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseWings, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemEngineInletSectionTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemTurbofanEngineTier1, 1),
                new RecipesCommon.ComparableStack(wartecmodItems.itemSolidBooster, 1), },500);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadNuclearCM, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(ModItems.sphere_steel, 1),
                new RecipesCommon.ComparableStack(ModItems.nugget_pu239, 13),
                new RecipesCommon.OreDictStack(OreDictManager.getReflector(), 2),
                new RecipesCommon.OreDictStack(ANY_HIGHEXPLOSIVE.ingot(), 4),
                new RecipesCommon.ComparableStack(ModItems.circuit_targeting_tier2, 1), },500);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemHWarhead, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.OreDictStack("plateTitanium", 12),
                new RecipesCommon.OreDictStack("plateSteel", 8),
                new RecipesCommon.ComparableStack(ModItems.ingot_pu239, 1),
                new RecipesCommon.ComparableStack(Blocks.tnt, 4),
                new RecipesCommon.OreDictStack(OreDictManager.getReflector(), 3),
                new RecipesCommon.ComparableStack(ModItems.lithium, 4),
                new RecipesCommon.ComparableStack(ModItems.cell_deuterium, 6),
                new RecipesCommon.ComparableStack(wartecmodItems.itemPlateU238, 5), },850);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadCluster, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.OreDictStack("plateSteel", 4),
                new RecipesCommon.OreDictStack("plateTitanium", 2),
                new RecipesCommon.ComparableStack(Blocks.tnt, 3),
                new RecipesCommon.ComparableStack(ModItems.pellet_cluster, 16), },250);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadHeCM, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.OreDictStack("plateAluminum", 6),
                new RecipesCommon.OreDictStack("plateSteel", 4),
                new RecipesCommon.OreDictStack("plateTitanium", 2),
                new RecipesCommon.ComparableStack(Blocks.tnt, 3),},100);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadTB, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.OreDictStack("plateAluminum", 6),
                new RecipesCommon.OreDictStack("plateSteel", 4),
                new RecipesCommon.OreDictStack("plateTitanium", 2),
                new RecipesCommon.ComparableStack(ModItems.ball_tatb, 24),
                new RecipesCommon.OreDictStack(Fluids.KEROSENE_REFORM.getDict(1_000), 16),
                new RecipesCommon.OreDictStack(Fluids.ACID.getDict(1_000), 16),},150);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadEmp, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.OreDictStack("plateLead", 6),
                new RecipesCommon.OreDictStack("plateSteel", 2),
                new RecipesCommon.ComparableStack(ModItems.circuit_red_copper,1),
                new RecipesCommon.ComparableStack(ModItems.magnetron,3),},150);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadGas, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.OreDictStack("plateAluminum", 6),
                new RecipesCommon.OreDictStack("plateSteel", 4),
                new RecipesCommon.OreDictStack("plateTitanium", 2),
                new RecipesCommon.ComparableStack(ModItems.pellet_gas, 3),
                new RecipesCommon.ComparableStack(Blocks.tnt, 1),},150);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadBuster, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.OreDictStack("plateTitanium", 6),
                new RecipesCommon.OreDictStack("plateSteel", 4),
                new RecipesCommon.ComparableStack(wartecmodItems.itemPlateU238, 4),
                new RecipesCommon.ComparableStack(Blocks.tnt, 3),
                new RecipesCommon.ComparableStack(ModBlocks.det_cord, 3),},125);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemKKV, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.OreDictStack("plateTitanium", 6),
                new RecipesCommon.ComparableStack(wartecmodItems.itemPlateU238, 5),
                new RecipesCommon.ComparableStack(ModBlocks.block_tungsten, 1),
                new RecipesCommon.ComparableStack(ModBlocks.block_u238, 1),},100);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadHCM, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(ModItems.ingot_pu239, 1),
                new RecipesCommon.ComparableStack(Blocks.tnt, 8),
                new RecipesCommon.OreDictStack(OreDictManager.getReflector(), 3),
                new RecipesCommon.ComparableStack(ModItems.lithium, 3),
                new RecipesCommon.ComparableStack(ModItems.cell_deuterium, 5), },750);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemWarheadNeutron, 1), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(ModItems.plate_steel, 5),
                new RecipesCommon.ComparableStack(Blocks.tnt, 4),
                new RecipesCommon.ComparableStack(ModItems.ingot_pu239, 1),
                new RecipesCommon.ComparableStack(ModItems.custom_dirty, 5),} ,250);
        AssemblerRecipes.makeRecipe(new RecipesCommon.ComparableStack(wartecmodItems.itemPlateU238, 2), new RecipesCommon.AStack[] {
                new RecipesCommon.ComparableStack(ModItems.ingot_u238, 3),},30);
        //Shredder
        ShredderRecipes.setRecipe(new ItemStack(Items.beef, 1, 0), new ItemStack(wartecmodItems.itemMincedMeatRaw, 9));
        //VanillaRecipes
        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemGuidanceSystemTier1, 1), "X#*",
                "   ",
                "   ", Character.valueOf('X'), ModItems.circuit_targeting_tier1, Character.valueOf('#'), Items.redstone, Character.valueOf('*'), ModItems.circuit_aluminium);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemGuidanceSystemTier2, 1), "X#*",
                "   ",
                "   ", Character.valueOf('X'), ModItems.circuit_targeting_tier2, Character.valueOf('#'), ModItems.powder_quartz, Character.valueOf('*'), ModItems.circuit_copper);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemGuidanceSystemTier3, 1), "X#*",
                "   ",
                "   ", Character.valueOf('X'), ModItems.circuit_targeting_tier3, Character.valueOf('#'), ModItems.powder_gold, Character.valueOf('*'), ModItems.circuit_red_copper);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemGuidanceSystemTier4, 1), "X#*",
                "   ",
                "   ", Character.valueOf('X'), ModItems.circuit_targeting_tier4, Character.valueOf('#'), ModItems.powder_lapis, Character.valueOf('*'), ModItems.circuit_gold);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemGuidanceSystemTier5, 1), "X#*",
                "   ",
                "   ", Character.valueOf('X'), ModItems.circuit_targeting_tier5, Character.valueOf('#'), ModItems.powder_diamond, Character.valueOf('*'), ModItems.circuit_schrabidium);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemGuidanceSystemTier6, 1), "X#*",
                "   ",
                "   ", Character.valueOf('X'), ModItems.powder_spark_mix, Character.valueOf('#'), ModItems.battery_potatos, Character.valueOf('*'), wartecmodItems.itemGuidanceSystemTier5);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemCruiseWings, 1), "   ",
                "X#X",
                "   ", Character.valueOf('X'), ModItems.plate_titanium, Character.valueOf('#'), ModBlocks.steel_scaffold);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemCruiseFinsSmall, 1), "   ",
                "X#X",
                "   ", Character.valueOf('X'), ModItems.plate_steel, Character.valueOf('#'), ModBlocks.steel_scaffold);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemCruiseFinsBig, 1), "   ",
                "   ",
                "X#X", Character.valueOf('X'), ModItems.plate_titanium, Character.valueOf('#'), ModBlocks.steel_scaffold);

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.barricade, 8), "XXX",
                "X#X",
                "XXX", Character.valueOf('X'), Items.leather, Character.valueOf('#'), Blocks.sand);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodBlocks.decoBlockFlagUS, 9), "X**",
                "###",
                "***", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, (short)11), Character.valueOf('#'), new ItemStack(Blocks.wool, 1, (short)14), Character.valueOf('*'),  new ItemStack(Blocks.wool, 1, (short)0));

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodBlocks.decoBlockFlagEU, 9), "XXX",
                "X#X",
                "XXX", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, (short)4), Character.valueOf('#'), new ItemStack(Blocks.wool, 1, (short)11));

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodBlocks.decoBlockFlagSU, 9), "X##",
                "###",
                "###", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, (short)4), Character.valueOf('#'), new ItemStack(Blocks.wool, 1, (short)14));

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodBlocks.decoBlockFlagCH, 9), "XX#",
                "###",
                "###", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, (short)4), Character.valueOf('#'), new ItemStack(Blocks.wool, 1, (short)14));

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodBlocks.decoBlockFlagAL, 9), "XXX",
                "X#X",
                "XXX", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, (short)13), Character.valueOf('#'), new ItemStack(Blocks.wool, 1, (short)0));

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodBlocks.decoBlockFlagIsr, 9), "XXX",
                "#X#",
                "XXX", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, (short)11), Character.valueOf('#'), new ItemStack(Blocks.wool, 1, (short)0));

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemMissileMicroGas, 1), "X# ",
                "*  ",
                "   ", Character.valueOf('X'), ModItems.missile_assembly, Character.valueOf('#'), wartecmodItems.itemWarheadGas, Character.valueOf('*'), ModItems.circuit_targeting_tier2);

        GameRegistry.addShapedRecipe(new ItemStack(wartecmodItems.itemMissileMicroNeutron, 1), "X# ",
                "*  ",
                "   ", Character.valueOf('X'), ModItems.missile_assembly, Character.valueOf('#'), wartecmodItems.itemWarheadNeutron, Character.valueOf('*'), ModItems.circuit_targeting_tier3);

        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodBlocks.decoBlockCruiseMissile), wartecmodItems.itemCruiseMissileHe);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodBlocks.decoBlockCruiseMissileBuster), wartecmodItems.itemCruiseMissileBuster);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodBlocks.decoBlockCruiseMissileCluster), wartecmodItems.itemCruiseMissileCluster);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodBlocks.decoBlockCruiseMissileEmp), wartecmodItems.itemCruiseMissileEmp);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodBlocks.decoBlockCruiseMissileFAE), wartecmodItems.itemCruiseMissileTB);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodBlocks.decoBlockCruiseMissileNuclear), wartecmodItems.itemCruiseMissileNuclear);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodBlocks.decoBlockCruiseMissileH), wartecmodItems.itemCruiseMissileH);

        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCruiseMissileHe), wartecmodBlocks.decoBlockCruiseMissile);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCruiseMissileBuster), wartecmodBlocks.decoBlockCruiseMissileBuster);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCruiseMissileCluster), wartecmodBlocks.decoBlockCruiseMissileCluster);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCruiseMissileNuclear), wartecmodBlocks.decoBlockCruiseMissileNuclear);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCruiseMissileH), wartecmodBlocks.decoBlockCruiseMissileH);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCruiseMissileTB), wartecmodBlocks.decoBlockCruiseMissileFAE);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCruiseMissileEmp), wartecmodBlocks.decoBlockCruiseMissileEmp);

        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemTomahawkMissile), wartecmodItems.itemCruiseMissileHe,wartecmodBlocks.decoBlockFlagUS);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemTomahawkMissile), wartecmodItems.itemCruiseMissileHe,wartecmodBlocks.decoBlockFlagEU);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemKalibrMissile), wartecmodItems.itemCruiseMissileHe,wartecmodBlocks.decoBlockFlagSU);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCj10Missile), wartecmodItems.itemCruiseMissileHe,wartecmodBlocks.decoBlockFlagCH);
        GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemIskanderMissile), ModItems.missile_burst,wartecmodBlocks.decoBlockFlagSU);

        GameRegistry.addSmelting(wartecmodItems.itemMincedMeatRaw, new ItemStack(wartecmodItems.itemMincedMeatCooked), 1.0F);
    }
}
