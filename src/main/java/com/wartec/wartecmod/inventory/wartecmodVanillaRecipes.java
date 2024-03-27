package com.wartec.wartecmod.inventory;

import com.hbm.blocks.ModBlocks;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.blocks.wartecmodBlocks;

import com.wartec.wartecmod.items.wartecmodItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class wartecmodVanillaRecipes {
	
	public static void VanillaRecipes()
	{
		//Crafting-Rezepte
		        		
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



	    //Dekoblockcrafting	
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
				
		//Specialmissiles
				GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemTomahawkMissile), wartecmodItems.itemCruiseMissileHe,wartecmodBlocks.decoBlockFlagUS);
				GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemTomahawkMissile), wartecmodItems.itemCruiseMissileHe,wartecmodBlocks.decoBlockFlagEU);
				GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemKalibrMissile), wartecmodItems.itemCruiseMissileHe,wartecmodBlocks.decoBlockFlagSU);
				GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemCj10Missile), wartecmodItems.itemCruiseMissileHe,wartecmodBlocks.decoBlockFlagCH);
				GameRegistry.addShapelessRecipe(new ItemStack(wartecmodItems.itemIskanderMissile), ModItems.missile_burst,wartecmodBlocks.decoBlockFlagSU);


				 



		//Ofen-Rezepte
				GameRegistry.addSmelting(wartecmodItems.itemMincedMeatRaw, new ItemStack(wartecmodItems.itemMincedMeatCooked), 1.0F);
				

	}

}
