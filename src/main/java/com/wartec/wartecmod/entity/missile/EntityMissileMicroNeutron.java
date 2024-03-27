package com.wartec.wartecmod.entity.missile;

import com.hbm.entity.effect.EntityNukeTorex;
import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.explosion.ExplosionNukeSmall;
import com.hbm.explosion.ExplosionNukeSmall.MukeParams;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.items.wartecmodItems;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityMissileMicroNeutron extends EntityBallisticMissileBase {

	public EntityMissileMicroNeutron(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	public EntityMissileMicroNeutron(World world, float x, float y, float z, int a, int b) {
		super(world, x, y, z, a, b);
	}
	
	public static MukeParams NEUTRON_WARHEAD = new MukeParams() {{ miniNuke = true; blastRadius = 35; shrapnelCount = 0; radiationLevel = 1000; }};
	

	@Override
	public void onImpact() {
		ExplosionNukeSmall.explode(worldObj, posX, posY, posZ, EntityMissileMicroNeutron.NEUTRON_WARHEAD);
	}

	@Override
	public List<ItemStack> getDebris() {
		List<ItemStack> list = new ArrayList<ItemStack>();

		list.add(new ItemStack(ModItems.plate_titanium, 10));
		list.add(new ItemStack(ModItems.plate_steel, 12));
		list.add(new ItemStack(ModItems.plate_aluminium, 8));
		list.add(new ItemStack(ModItems.thruster_large, 1));
		list.add(new ItemStack(wartecmodItems.itemGuidanceSystemTier5, 1));
		list.add(new ItemStack(ModItems.circuit_targeting_tier4, 1));
		
		
		return list;
	}

	@Override
	public ItemStack getDebrisRareDrop() {
		return new ItemStack(wartecmodItems.itemHWarhead);
	}

	@Override
	public RadarTargetType getTargetType() {
		return RadarTargetType.MISSILE_TIER0;
	}
}