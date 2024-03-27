package com.wartec.wartecmod.entity.missile;

import java.util.ArrayList;
import java.util.List;

import com.hbm.config.BombConfig;
import com.hbm.entity.effect.EntityNukeTorex;
import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.items.wartecmodItems;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySupersonicCruiseMissileH extends EntitySupersonicCruiseMissileBase {
	
	public EntitySupersonicCruiseMissileH(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	public EntitySupersonicCruiseMissileH(World world, float x, float y, float z, int a, int b, int c) {
		super(world, x, y, z, a, b, c);
		this.isSupersonic = true;
	}

	@Override
	public void onImpact() {
		this.worldObj.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(worldObj, 150, posX, posY, posZ));
		EntityNukeTorex.statFac(worldObj, posX, posY, posZ, 150);

	}

	@Override
	public List<ItemStack> getDebris() {
		List<ItemStack> list = new ArrayList<ItemStack>();

		list.add(new ItemStack(ModItems.plate_steel, 10));
		list.add(new ItemStack(ModItems.plate_titanium, 6));
		list.add(new ItemStack(ModItems.thruster_medium, 1));
		list.add(new ItemStack(ModItems.circuit_targeting_tier2, 1));
		
		return list;
	}

	@Override
	public ItemStack getDebrisRareDrop() {
		return new ItemStack(wartecmodItems.itemWarheadHeCM);
	}

	@Override
	public RadarTargetType getTargetType() {
		return RadarTargetType.MISSILE_TIER0;
	}
}
