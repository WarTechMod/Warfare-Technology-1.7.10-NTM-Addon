package com.wartec.wartecmod.entity.missile;

import com.hbm.entity.missile.EntityMissileTier0;
import com.hbm.items.ModItems;
import com.wartec.wartecmod.entity.submunition.EntityBombletPhosgene;
import com.wartec.wartecmod.items.wartecmodItems;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityMissileMicroPhosgene extends EntityMissileTier0 {

    double Distance;
    double Position;

    public EntityMissileMicroPhosgene(World p_i1582_1_) {
        super(p_i1582_1_);
    }

    public EntityMissileMicroPhosgene(World world, float x, float y, float z, int a, int b) {
        super(world, x, y, z, a, b);
        this.isCluster = true;
    }

    @Override public ItemStack getMissileItemForInfo() { return new ItemStack(wartecmodItems.itemMissileMicroPhosgene);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        Distance = Math.sqrt(((targetX - startX) * (targetX - startX)) + ((targetZ - startZ) * (targetZ - startZ)));

        Position = Math.sqrt(((this.posX - startX) * (this.posX - startX)) + ((this.posZ - startZ) * (this.posZ - startZ)));

        if (this.isCluster && this.Distance - 30 < this.Position && !this.worldObj.isRemote) {
            BombletSplit();
        }
    }

    public void BombletSplit() {
        if (this.Distance-20 < this.Position) {

            if (!this.worldObj.isRemote)
            {
                this.setDead();

                for(int i = 0; i < 10; i++) {

                    EntityBombletPhosgene Bomblet = new EntityBombletPhosgene(worldObj);
                    Bomblet.posX = posX;
                    Bomblet.posY = posY;
                    Bomblet.posZ = posZ;
                    Bomblet.motionX = motionX + rand.nextGaussian() * 0.5D;
                    Bomblet.motionY = motionY + rand.nextGaussian() * 0.5D;
                    Bomblet.motionZ = motionZ + rand.nextGaussian() * 0.5D;
                    Bomblet.ticksExisted = 52;

                    worldObj.spawnEntityInWorld(Bomblet);
                }
            }
        }
    }

    @Override
    public void onImpact() {
        setDead();
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