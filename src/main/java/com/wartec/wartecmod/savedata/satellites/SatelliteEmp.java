package com.wartec.wartecmod.savedata.satellites;

import com.hbm.entity.effect.EntityNukeCloudSmall;
import com.hbm.entity.logic.EntityEMP;
import com.hbm.saveddata.SatelliteSavedData;
import com.hbm.saveddata.satellites.Satellite;
import com.hbm.saveddata.satellites.Satellite.Interfaces;
import com.wartec.wartecmod.entity.missile.EntitySatelliteMissileNuclear;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class SatelliteEmp extends Satellite {
	
	boolean used = false;
	
	public SatelliteEmp() {
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
		
		EntityNukeCloudSmall Nuke = new EntityNukeCloudSmall(world);
		Nuke.setPosition(x + 0.5, 600, z + 0.5);
		
		EntityEMP Nuke1 = new EntityEMP(world);
		Nuke1.posX = x + 0.5;
		Nuke1.posY = y;
		Nuke1.posZ = z + 0.5;
		
		IChunkProvider provider = world.getChunkProvider();
		provider.loadChunk(x >> 4, z >> 4);
		
		world.spawnEntityInWorld(Nuke);
		
		world.spawnEntityInWorld(Nuke1);
		

		//for(Object p : world.playerEntities)
			//((EntityPlayer)p).triggerAchievement(MainRegistry.horizonsEnd);
		
		//not necessary but JUST to make sure
		if(!world.isRemote) {
			
			//MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText(EnumChatFormatting.RED + "Horizons has been activated."));
		}
	}
}
