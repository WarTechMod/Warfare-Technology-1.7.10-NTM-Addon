package com.wartec.wartecmod.savedata.satellites;

import com.hbm.saveddata.SatelliteSavedData;
import com.hbm.saveddata.satellites.Satellite;
import com.wartec.wartecmod.entity.missile.EntitySatelliteMissileNuclear;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class SatelliteNuclear extends Satellite {

	int usagesLeft = 4;
	
	public SatelliteNuclear() {
		this.satIface = Interfaces.SAT_COORD;
	}

	public void onOrbit(World world, double x, double y, double z) {

		//for(Object p : world.playerEntities)
			//((EntityPlayer)p).triggerAchievement(MainRegistry.horizonsStart);
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("left", usagesLeft);
	}
	
	public void readFromNBT(NBTTagCompound nbt) {
		usagesLeft = nbt.getInteger("left");
	}
	
	public void onCoordAction(World world, EntityPlayer player, int x, int y, int z) {

		if(usagesLeft < 1)
		   return;

		usagesLeft--;

		SatelliteSavedData.getData(world).markDirty();

		EntitySatelliteMissileNuclear Missile = new EntitySatelliteMissileNuclear(world);
		Missile.setPosition(x + 0.5, 600, z + 0.5);

		IChunkProvider provider = world.getChunkProvider();
		provider.loadChunk(x >> 4, z >> 4);
		
		world.spawnEntityInWorld(Missile);


		
		
		
		//for(Object p : world.playerEntities)
			//((EntityPlayer)p).triggerAchievement(MainRegistry.horizonsEnd);
		
		//not necessary but JUST to make sure
		if(!world.isRemote) {
			
			//MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText(EnumChatFormatting.RED + "Horizons has been activated."));
		}
		}
	}

