package com.wartec.wartecmod.savedata.satellites;

import com.hbm.saveddata.SatelliteSavedData;
import com.hbm.saveddata.satellites.Satellite;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class SatelliteEMP extends Satellite {
	
	boolean used = false;
	
	public SatelliteEMP() {
		this.satIface = Interfaces.SAT_COORD;
		this.satIface = Interfaces.SAT_PANEL;
	}

	public void onOrbit(World world, double x, double y, double z) {

		//for(Object p : world.playerEntities)
			//((EntityPlayer)p).triggerAchievement(MainRegistry.horizonsStart);
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setBoolean("used", used);
	}
	
	public void readFromNBT(NBTTagCompound nbt) {
		used = nbt.getBoolean("used");
	}
	
	public void onCoordAction(World world, EntityPlayer player, int x, int y, int z) {
		
		if(used)
			return;
		
		used = true;
		SatelliteSavedData.getData(world).markDirty();
		
		//nuke
		
		IChunkProvider provider = world.getChunkProvider();
		provider.loadChunk(x >> 4, z >> 4);

		

		//for(Object p : world.playerEntities)
			//((EntityPlayer)p).triggerAchievement(MainRegistry.horizonsEnd);
		
		//not necessary but JUST to make sure
		if(!world.isRemote) {
			
			//MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText(EnumChatFormatting.RED + "Horizons has been activated."));
		}
	}
}
