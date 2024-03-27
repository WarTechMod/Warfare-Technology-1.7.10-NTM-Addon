package com.wartec.wartecmod.inventory;

import com.hbm.inventory.recipes.ShredderRecipes;

import com.wartec.wartecmod.items.wartecmodItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class wartecmodShredderRecipes {
	
	public static void Shredderrecipes()
	{
		ShredderRecipes.setRecipe(new ItemStack(Items.beef, 1, 0), new ItemStack(wartecmodItems.itemMincedMeatRaw, 9));
		
		com.hbm.inventory.recipes.ShredderRecipes.getShredderRecipes();

	}

}
