package com.wartec.wartecmod.entity.missile;

import com.hbm.blocks.ModBlocks;
import com.hbm.explosion.ExplosionChaos;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.items.ModItems;
import com.hbm.packet.AuxParticlePacketNT;
import com.hbm.packet.PacketDispatcher;
import com.hbm.potion.HbmPotion;
import com.wartec.wartecmod.entity.logic.ExplosionLargeAdvanced;
import com.wartec.wartecmod.items.wartecmodItems;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityCruiseMissileWP extends EntitySubsonicCruiseMissileBase {

    public EntityCruiseMissileWP(World p_i1582_1_) {
        super(p_i1582_1_);
    }

    public EntityCruiseMissileWP(World world, float x, float y, float z, int a, int b, int c, TileEntityVlsExhaust exhaust) {
        super(world, x, y, z, a, b, c, exhaust);
        this.isSubsonic = true;
    }


    @Override
    public void onImpact() {ExplosionLargeAdvanced explosionLargeAdvanced = new ExplosionLargeAdvanced();
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
        ExplosionLargeAdvanced.standardMush(worldObj, posX, posY, posZ, 15);
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