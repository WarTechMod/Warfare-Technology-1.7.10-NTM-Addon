package com.wartec.wartecmod.tileentity;

import com.wartec.wartecmod.tileentity.launcher.TileEntityBallisticMissileLauncher;
import com.wartec.wartecmod.tileentity.vls.TileEntityVerticalLaunchTube;
import com.wartec.wartecmod.tileentity.vls.TileEntityVerticalLaunchTubeBase;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsLaunchTube;

import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityRegistry {
	
	public static void registerTileEntities() {
		
		GameRegistry.registerTileEntity(TileEntityVerticalLaunchTubeBase.class, com.wartec.wartecmod.lib.RefStrings.MODID + "LaunchTubeBase");
		GameRegistry.registerTileEntity(TileEntityVerticalLaunchTube.class, com.wartec.wartecmod.lib.RefStrings.MODID + "LaunchTube");
		GameRegistry.registerTileEntity(TileEntityVlsLaunchTube.class, com.wartec.wartecmod.lib.RefStrings.MODID + "LaunchTubeAlt");
		GameRegistry.registerTileEntity(TileEntityVlsExhaust.class, com.wartec.wartecmod.lib.RefStrings.MODID + "VlsExhaust");
		GameRegistry.registerTileEntity(TileEntityBallisticMissileLauncher.class, com.wartec.wartecmod.lib.RefStrings.MODID + "BallisticMissileLauncher");
		}
}
