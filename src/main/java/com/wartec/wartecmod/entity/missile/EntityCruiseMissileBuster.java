package com.wartec.wartecmod.entity.missile;

import java.util.ArrayList;
import java.util.List;

import com.hbm.blocks.ModBlocks;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.entity.logic.ExplosionLargeAdvanced;
import com.wartec.wartecmod.items.wartecmodItems;

import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCruiseMissileBuster extends EntitySubsonicCruiseMissileBase {

		public EntityCruiseMissileBuster(World p_i1582_1_) {
			super(p_i1582_1_);
		}

		public EntityCruiseMissileBuster(World world, float x, float y, float z, int a, int b, int c, TileEntityVlsExhaust exhaust) {
			super(world, x, y, z, a, b, c, exhaust);
			this.isSubsonic = true;
		}

		@Override
		public void onImpact() {
			ExplosionLarge.spawnShock(worldObj, posX, posY, posZ, 10 + rand.nextInt(3), 4 + rand.nextGaussian() * 2);
			ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, 5);
			ExplosionLarge.spawnShrapnelShower(worldObj, posX, posY, posZ, 5, 5, 5, 15, 5);
			for(int i = 0; i < 20; i++)
			{
				this.worldObj.createExplosion(this, this.posX, this.posY+1 - i, this.posZ, 0.5F, true);
			}
			ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
			explosionLargeAdvanced.ExplosionAdvanced(worldObj, posX, posY-15, posZ, 20F, 2F, true, ModBlocks.block_slag, 1);
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
			return new ItemStack(wartecmodItems.itemWarheadBuster);
		}

		@Override
		public RadarTargetType getTargetType() {
			return RadarTargetType.MISSILE_TIER0;
		}
	}


