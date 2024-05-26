package com.wartec.wartecmod.entity.missile;

import com.hbm.blocks.ModBlocks;
import com.hbm.entity.missile.EntityMissileBaseNT;
import com.hbm.entity.missile.EntityMissileTier1;
import com.hbm.entity.missile.EntityMissileTier2;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.items.ModItems;
import com.hbm.main.MainRegistry;
import com.wartec.wartecmod.entity.logic.ExplosionLargeAdvanced;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

public class EntityCMTest extends EntityMissileTier2 {

    public static Class<? extends EntityMissileBaseNT> EntityCruiseMissileDecoy;
    double Distance;
    double CruiseMissilePosition;
    double BoosterDisengagement;
    double SubmunitionDispensing;

    public int health = 10;
    public EntityCMTest(World world, float x, float y, float z, int a, int b) {
        super(world, x, y, z, a, b);

        this.motionY = 0.25;

        Distance = Math.sqrt(((targetX - startX)*(targetX - startX)) + ((targetZ - startZ)*(targetZ - startZ)));

        BoosterDisengagement = (Math.sqrt(((targetX - startX)*(targetX - startX)) + ((targetZ - startZ)*(targetZ - startZ))))*0.15;

        SubmunitionDispensing = (Math.sqrt(((targetX - startX)*(targetX - startX)) +  ((targetZ - startZ)*(targetZ - startZ))))*0.95;

        decelY *= 0.25;
        velocity = 5;
    }


    @Override
    protected void entityInit() {
        super.entityInit();
        init(ForgeChunkManager.requestTicket(MainRegistry.instance, worldObj, ForgeChunkManager.Type.ENTITY));
        this.dataWatcher.addObject(3, new Byte((byte) 5));
        this.dataWatcher.addObject(9, 1);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (velocity < 15) velocity += MathHelper.clamp_double(this.ticksExisted / 60D * 0.05D, 0, 0.05);

        CruiseMissilePosition = Math.sqrt(((this.posX - startX) * (this.posX - startX)) + ((this.posZ - startZ) * (this.posZ - startZ)));


        if (this.CruiseMissilePosition < this.BoosterDisengagement && this.dataWatcher.getWatchableObjectInt(9) == 1 && !this.worldObj.isRemote) {//this.ticksExisted > 5
            this.spawnContrail();
        }

        if (this.CruiseMissilePosition > this.BoosterDisengagement && this.dataWatcher.getWatchableObjectInt(9) == 1 && !this.worldObj.isRemote) {//this.ticksExisted > 205
            this.MissileToCruiseMissile();
        }

        if(this.Distance - 50 < this.CruiseMissilePosition && !this.worldObj.isRemote && !isCluster) {
            worldObj.playSoundEffect(posX, posY-2, posZ, "wartecmod:weapon.CruiseMissileWhistle", 10.0f, 1.0f);
        }

        if (this.isCluster && this.Distance - 30 < this.CruiseMissilePosition && !this.worldObj.isRemote) {
            //if (this.isCluster && this.posX == this.targetX && this.posZ == this.targetZ && !this.worldObj.isRemote) {
            //BombletSplit();
            this.dataWatcher.updateObject(9, 3);
        }
    }

    @Override
    public ItemStack getMissileItemForInfo() {
        return null;
    }

    @Override
    public void onImpact() {

    }

    @Override
    public ItemStack getDebrisRareDrop() {
        return null;
    }

    private void MissileToCruiseMissile() {
        ExplosionLarge.spawnParticles(worldObj, posX, posY, posZ, 7);
        this.dataWatcher.updateObject(9, 2);
    }

    public static class EntityCruiseMissileDecoy extends EntityCMTest {

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
            ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
            explosionLargeAdvanced.ExplosionStandard(worldObj, posX, posY, posZ, 20, 20F, true, ModBlocks.block_slag, 1);
            //worldObj.setBlock((int) (this.posX), (int) (this.posY + 1), (int) (this.posZ), Blocks.beacon);
        }
    }
}
