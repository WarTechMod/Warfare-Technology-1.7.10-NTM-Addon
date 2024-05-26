package com.wartec.wartecmod.entity.missile;

import com.hbm.blocks.ModBlocks;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.entity.logic.ExplosionLargeAdvanced;
import com.wartec.wartecmod.items.wartecmodItems;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityKalibrMissile extends EntitySubsonicCruiseMissileBase {

	public EntityKalibrMissile(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	public EntityKalibrMissile(World world, float x, float y, float z, int a, int b, int c, TileEntityVlsExhaust exhaust) {
		super(world, x, y, z, a, b, c, exhaust);
		this.isSubsonic = true;
	}

	@Override
	public void onImpact() {
		ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
		explosionLargeAdvanced.ExplosionStandard(worldObj, posX, posY, posZ, 25F, 2F, true, ModBlocks.block_slag, 1);
	}
	
	@Override
	public List<ItemStack> getDebris() {
		List<ItemStack> list = new ArrayList<ItemStack>();

		list.add(new ItemStack(ModItems.plate_steel, 10));
		list.add(new ItemStack(ModItems.plate_titanium, 6));
		list.add(new ItemStack(ModItems.thruster_medium, 1));
		
		return list;
	}

	@Override
	public ItemStack getDebrisRareDrop() {
		return new ItemStack(wartecmodItems.itemKalibrMissile);
	}

	@Override
	public RadarTargetType getTargetType() {
		return RadarTargetType.MISSILE_TIER0;
	}
}