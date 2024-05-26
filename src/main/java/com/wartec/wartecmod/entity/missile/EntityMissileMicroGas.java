package com.wartec.wartecmod.entity.missile;

import com.hbm.entity.effect.EntityMist;
import com.hbm.entity.missile.EntityMissileTier0;
import com.hbm.entity.projectile.EntityNightmareBlast;
import com.hbm.explosion.ExplosionChaos;
import com.hbm.handler.pollution.PollutionHandler;
import com.hbm.inventory.RecipesCommon;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.items.wartecmodItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityMissileMicroGas extends EntityMissileTier0 {

	public EntityMissileMicroGas(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	public EntityMissileMicroGas(World world, float x, float y, float z, int a, int b) {
		super(world, x, y, z, a, b);
	}

	@Override
	public ItemStack getMissileItemForInfo() { return new ItemStack(wartecmodItems.itemMissileMicroGas); }

	@Override
	public void onImpact() {
		setDead();
		Vec3 vec = Vec3.createVectorHelper(motionX, motionY, motionZ).normalize();
		EntityMist mist = new EntityMist(worldObj);
		mist.setType(Fluids.CHLORINE);
		mist.setPosition(posX, posY, posZ);
		mist.setArea(35, 15F);
		worldObj.spawnEntityInWorld(mist);
		PollutionHandler.incrementPollution(worldObj, (int) posX, (int) posY, (int) posZ, PollutionHandler.PollutionType.HEAVYMETAL, 5F);
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

}