package com.wartec.wartecmod.entity.missile;

import com.hbm.entity.effect.EntityNukeCloudSmall;
import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.items.wartecmodItems;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityMissileSlbm extends EntityBallisticMissileBase {

	public EntityMissileSlbm(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	public EntityMissileSlbm(World world, float x, float y, float z, int a, int b) {
		super(world, x, y, z, a, b);
	}

	@Override
	public void onImpact() {
		
		loadNeighboringChunks((int)(posX / 55), (int)(posZ / 55));
		//1. Sprengkopf
    	worldObj.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(worldObj, 150, posX+50, posY, posZ)); //St�rke 250

		EntityNukeCloudSmall entity2 = new EntityNukeCloudSmall(this.worldObj, 1000, 150 * 0.005F);//250
    	entity2.posX = this.posX+50;
    	entity2.posY = this.posY;
    	entity2.posZ = this.posZ;
    	this.worldObj.spawnEntityInWorld(entity2);
    	
    	//2.Sprengkopf
    	worldObj.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(worldObj, 150, posX-50, posY, posZ+50)); //St�rke 250

		EntityNukeCloudSmall entity3 = new EntityNukeCloudSmall(this.worldObj, 1000, 150 * 0.005F);//250
    	entity3.posX = this.posX-50;
    	entity3.posY = this.posY;
    	entity3.posZ = this.posZ+50;
    	this.worldObj.spawnEntityInWorld(entity3);
    	
    	//3.Sprengkopf
    	worldObj.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(worldObj, 150, posX-50, posY, posZ-50)); //St�rke 250

		EntityNukeCloudSmall entity4 = new EntityNukeCloudSmall(this.worldObj, 1000, 150 * 0.005F);//250
    	entity4.posX = this.posX-50;
    	entity4.posY = this.posY;
    	entity4.posZ = this.posZ-50;
    	this.worldObj.spawnEntityInWorld(entity4);
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
		return RadarTargetType.MISSILE_TIER4;
	}
}