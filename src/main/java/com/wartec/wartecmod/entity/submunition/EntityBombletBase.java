package com.wartec.wartecmod.entity.submunition;

import com.hbm.config.GeneralConfig;
import com.hbm.main.MainRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class EntityBombletBase extends EntityThrowable {

    private ForgeChunkManager.Ticket loaderTicket;

    public EntityBombletBase(World p_i1773_1_) {
        super(p_i1773_1_);
    }

    public EntityBombletBase(World p_i1774_1_, EntityLivingBase p_i1774_2_) {
        super(p_i1774_1_, p_i1774_2_);
    }

    public EntityBombletBase(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    @Override
    public void onUpdate() {

        super.onUpdate();

        loadNeighboringChunks((int) (posX / 16), (int) (posZ / 16));

        this.prevRotationPitch = this.rotationPitch;
        this.rotationPitch -= Vec3.createVectorHelper(motionX, motionY, motionZ).lengthVector() * 25;
        this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

        while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
            this.prevRotationYaw -= 360.0F;
        }

        while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
    }

    @Override
    protected void onImpact(MovingObjectPosition p_70184_1_) {
        if(p_70184_1_.entityHit != null) {
            byte b0 = 0;

            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
        }

        if(!worldObj.isRemote) {
            if(GeneralConfig.enableExtendedLogging) {

                String s = "null";

                if(getThrower() != null && getThrower() instanceof EntityPlayer)
                    s = ((EntityPlayer) getThrower()).getDisplayName();

                MainRegistry.logger.log(Level.INFO, "[GREN] Set off grenade at " + ((int) posX) + " / " + ((int) posY) + " / " + ((int) posZ) + " by " + s + "!");
            }
        }

        this.explode();
    }

    public void init(ForgeChunkManager.Ticket ticket) {
        if(!worldObj.isRemote) {

            if(ticket != null) {

                if(loaderTicket == null) {

                    loaderTicket = ticket;
                    loaderTicket.bindEntity(this);
                    loaderTicket.getModData();
                }

                ForgeChunkManager.forceChunk(loaderTicket, new ChunkCoordIntPair(chunkCoordX, chunkCoordZ));
            }
        }
    }

    List<ChunkCoordIntPair> loadedChunks = new ArrayList<ChunkCoordIntPair>();

    public void loadNeighboringChunks(int newChunkX, int newChunkZ)
    {
        if(!worldObj.isRemote && loaderTicket != null)
        {
            for(ChunkCoordIntPair chunk : loadedChunks)
            {
                ForgeChunkManager.unforceChunk(loaderTicket, chunk);
            }

            loadedChunks.clear();
            loadedChunks.add(new ChunkCoordIntPair(newChunkX, newChunkZ));
            loadedChunks.add(new ChunkCoordIntPair(newChunkX + 1, newChunkZ + 1));
            loadedChunks.add(new ChunkCoordIntPair(newChunkX - 1, newChunkZ - 1));
            loadedChunks.add(new ChunkCoordIntPair(newChunkX + 1, newChunkZ - 1));
            loadedChunks.add(new ChunkCoordIntPair(newChunkX - 1, newChunkZ + 1));
            loadedChunks.add(new ChunkCoordIntPair(newChunkX + 1, newChunkZ));
            loadedChunks.add(new ChunkCoordIntPair(newChunkX, newChunkZ + 1));
            loadedChunks.add(new ChunkCoordIntPair(newChunkX - 1, newChunkZ));
            loadedChunks.add(new ChunkCoordIntPair(newChunkX, newChunkZ - 1));

            for(ChunkCoordIntPair chunk : loadedChunks)
            {
                ForgeChunkManager.forceChunk(loaderTicket, chunk);
            }
        }
    }

    public abstract void explode();

}