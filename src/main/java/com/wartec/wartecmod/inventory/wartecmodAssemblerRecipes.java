package com.wartec.wartecmod.inventory;

import static com.hbm.inventory.OreDictManager.ANY_HIGHEXPLOSIVE;

import com.hbm.blocks.ModBlocks;
import com.hbm.inventory.OreDictManager;
import com.hbm.inventory.RecipesCommon.AStack;
import com.hbm.inventory.RecipesCommon.ComparableStack;
import com.hbm.inventory.RecipesCommon.OreDictStack;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.items.ModItems;

import com.wartec.wartecmod.items.wartecmodItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class wartecmodAssemblerRecipes {
	
	public static void AssemblerRecipes()
	{
		//Assembler-Rezpte
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemCruiseMissileHe, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier1, 1),
				new ComparableStack(wartecmodItems.itemWarheadHeCM, 1),},300);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemCruiseMissileEmp, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier2, 1),
				new ComparableStack(wartecmodItems.itemWarheadEmp, 1),},300);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemCruiseMissileNuclear, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier3, 1),
				new ComparableStack(wartecmodItems.itemWarheadNuclearCM, 1),},300);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemCruiseMissileH, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier4, 1),
				new ComparableStack(wartecmodItems.itemWarheadHCM, 1),},300);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemCruiseMissileBuster, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier1, 1),
				new ComparableStack(wartecmodItems.itemWarheadBuster, 1),},300);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemCruiseMissileCluster, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier1, 1),
				new ComparableStack(wartecmodItems.itemWarheadCluster, 1), },300);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemCruiseMissileTB, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier3, 1),
				new ComparableStack(wartecmodItems.itemWarheadTB, 1), },300);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemMissileStrongAntiBallistic, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemKKV, 1), 
				new ComparableStack(ModItems.fuel_tank_medium, 1), 
				new ComparableStack(ModItems.thruster_medium, 1), 
				new OreDictStack("plateTitanium", 10), 
				new OreDictStack("plateSteel", 14), 
				new ComparableStack(ModItems.circuit_targeting_tier4, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier6, 1), },350);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemMissileSLBM, 1), new AStack[] {
				new ComparableStack(wartecmodItems.itemHWarhead, 1), 
				new ComparableStack(ModItems.fuel_tank_large, 1), 
				new ComparableStack(ModItems.thruster_large, 1), 
				new OreDictStack("plateTitanium", 20), 
				new OreDictStack("plateSteel", 24), 
				new OreDictStack("plateAluminum", 16),
				new ComparableStack(ModItems.circuit_targeting_tier4, 1),
				new ComparableStack(wartecmodItems.itemGuidanceSystemTier5, 1), },750);
		
//Parts
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemEngineInletSectionTier1, 1), new AStack[] {
				   new ComparableStack(ModItems.hull_big_steel, 2), 
				   new ComparableStack(ModItems.mechanism_revolver_2, 2),
				   new ComparableStack(ModItems.hull_small_steel, 1), },150);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemTurbofanEngineTier1, 1), new AStack[] {
				   new ComparableStack(ModItems.hull_big_titanium, 1), 
				   new ComparableStack(ModItems.hull_small_steel, 1),
				   new ComparableStack(ModItems.turbine_tungsten, 2), 
				   new ComparableStack(ModItems.turbine_titanium, 2), 
				   new ComparableStack(ModItems.bolt_compound, 1),
				   new ComparableStack(ModItems.ingot_red_copper, 4),
				   new ComparableStack(ModItems.wire_copper, 6), 
				   new ComparableStack(wartecmodItems.itemCruiseFinsSmall, 4),},300);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemSolidBooster, 1), new AStack[] { 
				new ComparableStack(ModItems.hull_big_steel, 1),
				new ComparableStack(Items.flint_and_steel, 1),
				new ComparableStack(ModItems.rocket_fuel, 5), },125);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemCruiseMissileNoWarheadTier1, 1), new AStack[] { 
				new ComparableStack(ModItems.sphere_steel, 1),
				new ComparableStack(ModItems.circuit_targeting_tier1, 1),
				new ComparableStack(ModItems.hull_big_steel, 5),
				new ComparableStack(ModItems.fuel_tank_large, 1),
				new ComparableStack(ModItems.mechanism_revolver_2, 2),
				new ComparableStack(wartecmodItems.itemCruiseWings, 1),
				new ComparableStack(wartecmodItems.itemEngineInletSectionTier1, 1),
				new ComparableStack(wartecmodItems.itemTurbofanEngineTier1, 1),
				new ComparableStack(wartecmodItems.itemSolidBooster, 1), },500);
		///
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadNuclearCM, 1), new AStack[] {
				new ComparableStack(ModItems.hull_small_steel, 1), 
				   new ComparableStack(ModItems.sphere_steel, 1),
				   new ComparableStack(ModItems.nugget_pu239, 13), 
				   new OreDictStack(OreDictManager.getReflector(), 2),
				   new OreDictStack(ANY_HIGHEXPLOSIVE.ingot(), 4),
				   new ComparableStack(ModItems.circuit_targeting_tier2, 1), },500);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemHWarhead, 1), new AStack[] {
				new OreDictStack("plateTitanium", 12), 
				new OreDictStack("plateSteel", 8), 
				new ComparableStack(ModItems.ingot_pu239, 1), 
				new ComparableStack(Blocks.tnt, 4),  
				new OreDictStack(OreDictManager.getReflector(), 3), 
				new ComparableStack(ModItems.lithium, 4), 
				new ComparableStack(ModItems.cell_deuterium, 6),
				new ComparableStack(wartecmodItems.itemPlateU238, 5), },850);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadCluster, 1), new AStack[] {
				   new OreDictStack("plateSteel", 4),
				   new OreDictStack("plateTitanium", 2),
				   new ComparableStack(Blocks.tnt, 3), 
				   new ComparableStack(ModItems.pellet_cluster, 16), },250);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadHeCM, 1), new AStack[] {
				   new OreDictStack("plateAluminum", 6), 
				   new OreDictStack("plateSteel", 4), 
				   new OreDictStack("plateTitanium", 2),
				   new ComparableStack(Blocks.tnt, 3),},100);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadTB, 1), new AStack[] {
				   new OreDictStack("plateAluminum", 6), 
				   new OreDictStack("plateSteel", 4), 
				   new OreDictStack("plateTitanium", 2),
				   new ComparableStack(ModItems.ball_tatb, 24),
				   new OreDictStack(Fluids.KEROSENE_REFORM.getDict(1_000), 16),
				   new OreDictStack(Fluids.ACID.getDict(1_000), 16),},150);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadEmp, 1), new AStack[] {
				   new OreDictStack("plateLead", 6), 
				   new OreDictStack("plateSteel", 2),
				   new ComparableStack(ModItems.circuit_red_copper,1),
				   new ComparableStack(ModItems.magnetron,3),},150);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadGas, 1), new AStack[] {
				   new OreDictStack("plateAluminum", 6), 
				   new OreDictStack("plateSteel", 4), 
				   new OreDictStack("plateTitanium", 2),
				   new ComparableStack(ModItems.pellet_gas, 3),
				   new ComparableStack(Blocks.tnt, 1),},150);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadBuster, 1), new AStack[] {
				   new OreDictStack("plateTitanium", 6), 
				   new OreDictStack("plateSteel", 4),
				   new ComparableStack(wartecmodItems.itemPlateU238, 4), 
				   new ComparableStack(Blocks.tnt, 3),
				   new ComparableStack(ModBlocks.det_cord, 3),},125);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemKKV, 1), new AStack[] {
				   new OreDictStack("plateTitanium", 6), 
				   new ComparableStack(wartecmodItems.itemPlateU238, 5), 
				   new ComparableStack(ModBlocks.block_tungsten, 1),
				   new ComparableStack(ModBlocks.block_u238, 1),},100);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadHCM, 1), new AStack[] {
				new ComparableStack(ModItems.hull_big_steel, 1), 
				new ComparableStack(ModItems.hull_small_steel, 1),
				new ComparableStack(ModItems.ingot_pu239, 1), 
				new ComparableStack(Blocks.tnt, 8), 
				new OreDictStack(OreDictManager.getReflector(), 3), 
				new ComparableStack(ModItems.lithium, 3), 
				new ComparableStack(ModItems.cell_deuterium, 5), },750);
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemWarheadNeutron, 1), new AStack[] {
				 new ComparableStack(ModItems.plate_steel, 5),  
				 new ComparableStack(Blocks.tnt, 4), 
			     new ComparableStack(ModItems.ingot_pu239, 1),
			     new ComparableStack(ModItems.custom_dirty, 5),} ,250);
		
		
		com.hbm.inventory.recipes.AssemblerRecipes.makeRecipe(new ComparableStack(wartecmodItems.itemPlateU238, 2), new AStack[] {
				   new ComparableStack(ModItems.ingot_u238, 3),},30);
		
		com.hbm.inventory.recipes.AssemblerRecipes.loadRecipes();
		
	                      
		                                 
	}
}


