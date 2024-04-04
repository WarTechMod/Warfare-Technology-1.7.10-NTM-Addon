package com.wartec.wartecmod.entity.missile;

import com.hbm.blocks.ModBlocks;
import com.hbm.entity.missile.EntityMissileBaseNT;
import com.hbm.entity.missile.EntityMissileTier0;
import com.hbm.explosion.ExplosionNukeSmall;
import com.hbm.items.ItemAmmoEnums;
import com.hbm.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityCruiseMissileSubsonic extends EntityCruiseMissileBaseNT {

    public EntityCruiseMissileSubsonic(World world) {
        super(world);
    }

    public EntityCruiseMissileSubsonic(World world, float x, float y, float z, int a, int b) {
        super(world, x, y, z, a, b);
    }

    @Override
    public List<ItemStack> getDebris() {
        List<ItemStack> list = new ArrayList<ItemStack>();
        list.add(new ItemStack(ModItems.wire_aluminium, 4));
        list.add(new ItemStack(ModItems.plate_titanium, 4));
        list.add(new ItemStack(ModItems.hull_small_aluminium, 2));
        list.add(new ItemStack(ModItems.ducttape, 1));
        list.add(new ItemStack(ModItems.circuit_targeting_tier1, 1));
        return list;
    }

    @Override
    protected float getContrailScale() {
        return 0.5F;
    }

    public static class EntityMissileTest extends EntityCruiseMissileSubsonic {
        public EntityMissileTest(World world) {
            super(world);
        }

        public EntityMissileTest(World world, float x, float y, float z, int a, int b) {
            super(world, x, y, z, a, b);
        }

        @Override
        public ItemStack getDebrisRareDrop() {
            return null;
        }

        @Override
        public ItemStack getMissileItemForInfo() {
            return new ItemStack(ModItems.missile_test);
        }

        @Override
        public void onImpact() {
            int x = (int) Math.floor(posX);
            int y = (int) Math.floor(posY);
            int z = (int) Math.floor(posZ);
            int range = 50;

            for (int iX = -range; iX <= range; iX++) {
                for (int iY = -range; iY <= range; iY++) {
                    for (int iZ = -range; iZ <= range; iZ++) {
                        double dist = Math.sqrt(iX * iX + iY * iY + iZ * iZ);
                        if (dist > range) continue;
                        Block block = worldObj.getBlock(x + iX, y + iY, z + iZ);
                        int meta = worldObj.getBlockMetadata(x + iX, y + iY, z + iZ);
                        int charMeta = (int) MathHelper.clamp_double(12 - (dist / range) * (dist / range) * 13, 0, 12);

                        if (block.isNormalCube()) {
                            if (block != ModBlocks.sellafield_slaked || meta < charMeta) {
                                worldObj.setBlock(x + iX, y + iY, z + iZ, ModBlocks.sellafield_slaked, charMeta, 3);
                            }
                        } else {
                            worldObj.setBlock(x + iX, y + iY, z + iZ, Blocks.air);
                        }
                    }
                }
            }
        }
    }

    public static class EntityCruiseMissileTest extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileTest(World world) {
            super(world);
        }

        public EntityCruiseMissileTest(World world, float x, float y, float z, int a, int b) {
            super(world, x, y, z, a, b);
        }

        @Override
        public void onImpact() {
            ExplosionNukeSmall.explode(worldObj, posX, posY + 0.5, posZ, ExplosionNukeSmall.PARAMS_HIGH);
        }

        @Override
        public ItemStack getDebrisRareDrop() {
            return ModItems.ammo_nuke.stackFromEnum(ItemAmmoEnums.AmmoFatman.HIGH);
        }

        @Override
        public ItemStack getMissileItemForInfo() {
            return new ItemStack(ModItems.missile_micro);
        }
    }
}
