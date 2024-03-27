package com.wartec.wartecmod.entity.missile;

import com.hbm.entity.effect.EntityNukeTorex;
import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.explosion.ExplosionNukeSmall;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.items.wartecmodItems;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityCruiseMissileMiniNuke extends EntitySubsonicCruiseMissileBase {

    public EntityCruiseMissileMiniNuke(World p_i1582_1_) {
        super(p_i1582_1_);
    }

    public EntityCruiseMissileMiniNuke(World world, float x, float y, float z, int a, int b, int c, TileEntityVlsExhaust exhaust) {
        super(world, x, y, z, a, b, c, exhaust);
        this.isSubsonic = true;
    }

    @Override
    public void onImpact() {
        ExplosionNukeSmall.explode(worldObj, posX, posY, posZ, ExplosionNukeSmall.PARAMS_MEDIUM);
    }

    @Override
    public List<ItemStack> getDebris() {
        List<ItemStack> list = new ArrayList<ItemStack>();

        list.add(new ItemStack(ModItems.plate_steel, 10));
        list.add(new ItemStack(ModItems.plate_titanium, 6));
        list.add(new ItemStack(ModItems.thruster_medium, 1));
        list.add(new ItemStack(wartecmodItems.itemGuidanceSystemTier4, 1));

        return list;
    }


    @Override
    public ItemStack getDebrisRareDrop() {
        return new ItemStack(wartecmodItems.itemWarheadNuclearCM);
    }

    @Override
    public RadarTargetType getTargetType() {
        return RadarTargetType.MISSILE_TIER0;
    }
}