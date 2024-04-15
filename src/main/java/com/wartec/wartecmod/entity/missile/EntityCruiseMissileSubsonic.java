package com.wartec.wartecmod.entity.missile;

import com.hbm.blocks.ModBlocks;
import com.hbm.entity.effect.EntityNukeTorex;
import com.hbm.entity.logic.EntityEMP;
import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.explosion.ExplosionChaos;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.explosion.ExplosionNukeSmall;
import com.hbm.items.ModItems;
import com.hbm.packet.AuxParticlePacketNT;
import com.hbm.packet.PacketDispatcher;
import com.hbm.potion.HbmPotion;
import com.wartec.wartecmod.blocks.wartecmodBlocks;
import com.wartec.wartecmod.entity.logic.ExplosionLargeAdvanced;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
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
        list.add(new ItemStack(ModItems.ducttape, 1));
        list.add(new ItemStack(ModItems.circuit_targeting_tier1, 1));
        return list;
    }

    @Override
    protected float getContrailScale() {
        return 0.5F;
    }

    public static class EntityCruiseMissileCluster extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileCluster(World world) {
            super(world);
        }

        public EntityCruiseMissileCluster(World world, float x, float y, float z, int a, int b) {
            super(world, x, y, z, a, b);
            this.isCluster = true;
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
            worldObj.setBlock((int) (this.posX), (int) (this.posY + 1), (int) (this.posZ), wartecmodBlocks.decoBlockCruiseMissileCluster);
        }
    }

    public static class EntityCruiseMissileDecoy extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileDecoy(World world) {
            super(world);
        }

        public EntityCruiseMissileDecoy(World world, float x, float y, float z, int a, int b) {
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
            //ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
            //explosionLargeAdvanced.ExplosionAdvanced(worldObj, posX, posY, posZ, 2, 2F, true, ModBlocks.block_slag, 1);
            worldObj.setBlock((int) (this.posX), (int) (this.posY + 1), (int) (this.posZ), Blocks.beacon);
        }
    }

    public static class EntityCruiseMissileNuclear extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileNuclear(World world) {
            super(world);
        }

        public EntityCruiseMissileNuclear(World world, float x, float y, float z, int a, int b) {
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
            this.worldObj.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(worldObj, 75, posX, posY, posZ));
            EntityNukeTorex.statFac(worldObj, posX, posY, posZ, 75);
        }

    }

    public static class EntityCruiseMissileH extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileH(World world) {
            super(world);
        }

        public EntityCruiseMissileH(World world, float x, float y, float z, int a, int b) {
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
            this.worldObj.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(worldObj, 150, posX, posY, posZ));
            EntityNukeTorex.statFac(worldObj, posX, posY, posZ, 150);
        }
    }

    public static class EntityCruiseMissileHE extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileHE(World world) {
            super(world);
        }

        public EntityCruiseMissileHE(World world, float x, float y, float z, int a, int b) {
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
            ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
            explosionLargeAdvanced.ExplosionAdvanced(worldObj, posX, posY, posZ, 20F, 2F, true, ModBlocks.block_slag, 1);
        }
    }

    public static class EntityCruiseMissileTB extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileTB(World world) {
            super(world);
        }

        public EntityCruiseMissileTB(World world, float x, float y, float z, int a, int b) {
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
            ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
            explosionLargeAdvanced.ThermobaricExplosion(worldObj, posX, posY, posZ, 50F, 12F, true, ModBlocks.block_slag, 1);
            ExplosionLarge.spawnShrapnels(worldObj, posX, posY, posZ, 30);
            ExplosionLargeAdvanced.standardMush(worldObj, posX, posY, posZ, 35);}
    }

    public static class EntityCruiseMissileBuster extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileBuster(World world) {
            super(world);
        }

        public EntityCruiseMissileBuster(World world, float x, float y, float z, int a, int b) {
            super(world, x, y, z, a, b);
            this.isStealth = true;
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
            ExplosionLarge.spawnShock(worldObj, posX, posY, posZ, 10 + rand.nextInt(3), 4 + rand.nextGaussian() * 2);
            ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, 5);
            ExplosionLarge.spawnShrapnelShower(worldObj, posX, posY, posZ, 5, 5, 5, 15, 5);
            for (int i = 0; i < 20; i++) {
                this.worldObj.createExplosion(this, this.posX, this.posY + 1 - i, this.posZ, 0.5F, true);
            }
            ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
            explosionLargeAdvanced.ExplosionAdvanced(worldObj, posX, posY - 15, posZ, 20F, 2F, true, ModBlocks.block_slag, 1);
        }
    }

    public static class EntityCruiseMissileEmp extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileEmp(World world) {
            super(world);
        }

        public EntityCruiseMissileEmp(World world, float x, float y, float z, int a, int b) {
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
            EntityEMP emp = new EntityEMP(worldObj);
            emp.posX = posX;
            emp.posY = posY;
            emp.posZ = posZ;

            worldObj.spawnEntityInWorld(emp);
        }
    }

    public static class EntityCruiseMissileMiniNuke extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileMiniNuke(World world) {
            super(world);
        }

        public EntityCruiseMissileMiniNuke(World world, float x, float y, float z, int a, int b) {
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
            ExplosionNukeSmall.explode(worldObj, posX, posY, posZ, ExplosionNukeSmall.PARAMS_MEDIUM);
        }
    }

    public static class EntityCruiseMissileFragmentation extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileFragmentation(World world) {
            super(world);
        }

        public EntityCruiseMissileFragmentation(World world, float x, float y, float z, int a, int b) {
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
            ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
            explosionLargeAdvanced.ExplosionAdvanced(worldObj, posX, posY, posZ, 20F, 2F, false, ModBlocks.block_slag, 1);
        }
    }

    public static class EntityCruiseMissileWP extends EntityCruiseMissileSubsonic {
        public EntityCruiseMissileWP(World world) {
            super(world);
        }

        public EntityCruiseMissileWP(World world, float x, float y, float z, int a, int b) {
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
            ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
            explosionLargeAdvanced.ExplosionStandard(worldObj, posX, posY, posZ, 50F, 5F, false, ModBlocks.block_slag, 1);
            ExplosionLarge.spawnShrapnels(worldObj, posX, posY, posZ, 55);
            ExplosionChaos.burn(worldObj, (int) posX, (int) posY, (int) posZ, 50);
            int radius = 30;
            List<Entity> hit = worldObj.getEntitiesWithinAABBExcludingEntity(
                    null,
                    AxisAlignedBB.getBoundingBox(
                            posX - radius,
                            posY - radius,
                            posZ - radius,
                            posX + radius,
                            posY + radius,
                            posZ + radius
                    )
            );
            for(Entity e : hit) {
                e.setFire(5);
                if(e instanceof EntityLivingBase) {
                    PotionEffect eff = new PotionEffect(
                            HbmPotion.phosphorus.id,
                            30 * 20,
                            0,
                            true
                    );
                    eff.getCurativeItems().clear();
                    ((EntityLivingBase)e).addPotionEffect(eff);
                }
            }
            for(int i = 0; i < 10; i++) {
                NBTTagCompound haze = new NBTTagCompound();
                haze.setString("type", "haze");
                PacketDispatcher.wrapper.sendToAllAround(
                        new AuxParticlePacketNT(
                                haze,
                                posX + worldObj.rand.nextGaussian() * 15,
                                posY,
                                posZ + worldObj.rand.nextGaussian() * 15
                        ),
                        new NetworkRegistry.TargetPoint(
                                worldObj.provider.dimensionId,
                                posX,
                                posY,
                                posZ,
                                150
                        )
                );
            }
            ExplosionLargeAdvanced.standardMush(worldObj, posX, posY, posZ, 15); }
    }

}



