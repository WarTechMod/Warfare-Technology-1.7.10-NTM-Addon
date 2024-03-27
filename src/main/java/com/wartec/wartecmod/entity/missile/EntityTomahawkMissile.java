package com.wartec.wartecmod.entity.missile;

import java.util.ArrayList;
import java.util.List;

import com.hbm.blocks.ModBlocks;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.entity.logic.ExplosionLargeAdvanced;
import com.wartec.wartecmod.items.wartecmodItems;

import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTomahawkMissile extends EntitySubsonicCruiseMissileBase {

	public EntityTomahawkMissile(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	public EntityTomahawkMissile(World world, float x, float y, float z, int a, int b, int c, TileEntityVlsExhaust exhaust) {
		super(world, x, y, z, a, b, c, exhaust);
		this.isSubsonic = true;
	}

	@Override
	public void onImpact() {
		ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
		explosionLargeAdvanced.ExplosionAdvanced(worldObj, posX, posY, posZ, 25F, 2F, true, ModBlocks.block_slag, 1);
	}
	
	public List<ItemStack> getDebris() {
		List<ItemStack> list = new ArrayList<ItemStack>();

		list.add(new ItemStack(ModItems.plate_steel, 10));
		list.add(new ItemStack(ModItems.plate_titanium, 6));
		list.add(new ItemStack(ModItems.thruster_medium, 1));
		
		return list;
	}

	public ItemStack getDebrisRareDrop() {
		return new ItemStack(wartecmodItems.itemTomahawkMissile);
	}

	@Override
	public RadarTargetType getTargetType() {
		return RadarTargetType.MISSILE_TIER0;
	}
}