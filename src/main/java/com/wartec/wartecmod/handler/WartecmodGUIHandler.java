package com.wartec.wartecmod.handler;

import com.hbm.tileentity.IGUIProvider;
import com.wartec.wartecmod.blocks.wartecmodBlocks;
import com.wartec.wartecmod.inventory.container.ContainerBallisticMissileLauncher;
import com.wartec.wartecmod.inventory.container.ContainerLaunchTube;
import com.wartec.wartecmod.inventory.gui.GUIBallisticMissileLauncher;
import com.wartec.wartecmod.inventory.gui.GUILaunchTube;
import com.wartec.wartecmod.tileentity.launcher.TileEntityBallisticMissileLauncher;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsLaunchTube;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class WartecmodGUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity instanceof IGUIProvider) {
			return ((IGUIProvider) entity).provideContainer(ID, player, world, x, y, z);
		}
		
		Block block = world.getBlock(x, y, z);
		
		if(block instanceof IGUIProvider) {
			return ((IGUIProvider) block).provideContainer(ID, player, world, x, y, z);
		}
		
		switch(ID) {
	        case wartecmodBlocks.guiID_LaunchTube: {
			if(entity instanceof TileEntityVlsLaunchTube) {
				return new ContainerLaunchTube(player.inventory, (TileEntityVlsLaunchTube) entity);
			}
			return null;
			
	        }
			
	        case wartecmodBlocks.guiID_BallisticMissileLauncher: {
			if(entity instanceof TileEntityBallisticMissileLauncher) {
				return new ContainerBallisticMissileLauncher(player.inventory, (TileEntityBallisticMissileLauncher) entity);
			}
			return null;
			
	        }
	}
		return null;
	}
		
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			TileEntity entity = world.getTileEntity(x, y, z);
			
		if(entity instanceof IGUIProvider) {
			return ((IGUIProvider) entity).provideGUI(ID, player, world, x, y, z);
		}
			
		Block block = world.getBlock(x, y, z);
			
		if(block instanceof IGUIProvider) {
			return ((IGUIProvider) block).provideGUI(ID, player, world, x, y, z);
		}
		
		switch(ID) {
            case wartecmodBlocks.guiID_LaunchTube: {
			if(entity instanceof TileEntityVlsLaunchTube) {
				return new GUILaunchTube(player.inventory, (TileEntityVlsLaunchTube) entity);
			}
			return null;
			
            }
			
	        case wartecmodBlocks.guiID_BallisticMissileLauncher: {
			if(entity instanceof TileEntityBallisticMissileLauncher) {
				return new GUIBallisticMissileLauncher(player.inventory, (TileEntityBallisticMissileLauncher) entity);
			}
			return null;
			
				
	}
    }
		return null;
	}
}
		
		



		

			
		
