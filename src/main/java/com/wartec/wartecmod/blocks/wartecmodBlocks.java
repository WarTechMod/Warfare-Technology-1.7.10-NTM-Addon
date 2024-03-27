package com.wartec.wartecmod.blocks;

import com.hbm.blocks.generic.BlockGeneric;
import com.wartec.wartecmod.blocks.vls.VlsVerticalLauncher;
import com.wartec.wartecmod.wartecmod;
import com.wartec.wartecmod.tileentity.deco.TileEntityDecoBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class wartecmodBlocks {
	
	public static void Blocks()
	{
		initializeBlock();
		registerBlock();
	}
	
	//Missile equipment
	public static final int guiID_LaunchTube = 1;
	public static Block LaunchTube;
	public static Block VlsExhaust;
	public static final int guiID_BallisticMissileLauncher = 2;
	public static Block BallisticMissileLauncher;
	//Blocks
	public static Block BlockArmorSteel;
	public static Block BlockReinforcedWood;
	//Deco
	public static Block decoBlockCruiseMissile;
	public static Block decoBlockCruiseMissileCluster;
	public static Block decoBlockCruiseMissileBuster;
	public static Block decoBlockCruiseMissileEmp;
	public static Block decoBlockCruiseMissileFAE;
	public static Block decoBlockCruiseMissileNuclear;
	public static Block decoBlockCruiseMissileH;
	public static Block decoBlockSupersonicCruiseMissile;
	public static Block decoBlockSupersonicCruiseMissileH;
	public static Block decoBlockHypersonicCruiseMissile;
	public static Block decoBlockHypersonicCruiseMissileNuclear;
	public static Block decoBlockSatelliteNuclear;
	public static Block decoBlockFlagUS;
	public static Block decoBlockFlagSU;
	public static Block decoBlockFlagEU;
	public static Block decoBlockFlagAL;
	public static Block decoBlockFlagCH;
	public static Block decoBlockFlagIsr;
	

	private static void initializeBlock() {
		
		//Missile Equipment
		LaunchTube = new VlsVerticalLauncher(Material.iron).setBlockName("LaunchTube").setHardness(5.0F).setResistance(10.0F).setCreativeTab(com.wartec.wartecmod.wartecmod.tabwartecmodcruisemissiles).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":LaunchTube");
		VlsExhaust = new com.wartec.wartecmod.blocks.vls.VlsExhaust(Material.iron).setBlockName("VlsExhaust").setHardness(5.0F).setResistance(10.0F).setCreativeTab(com.wartec.wartecmod.wartecmod.tabwartecmodcruisemissiles).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":VlsExhaust");
		BallisticMissileLauncher = new com.wartec.wartecmod.blocks.launcher.BallisticMissileLauncher(Material.iron).setBlockName("BallisticMissileLauncher").setHardness(5.0F).setResistance(10.0F).setCreativeTab(com.wartec.wartecmod.wartecmod.tabwartecmodcruisemissiles).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":BallisticMissileLauncher");
		
		//Blocks
		BlockArmorSteel = new BlockGeneric(Material.iron).setBlockName("blockArmorSteel").setCreativeTab(wartecmod.tabwartecmodblocks).setStepSound(Block.soundTypeMetal).setHardness(7.5F).setResistance(20.0F).setBlockTextureName("wartecmod:BlockArmorSteel");
		BlockReinforcedWood = new BlockGeneric(Material.wood).setBlockName("blockReinforcedWood").setCreativeTab(wartecmod.tabwartecmodblocks).setStepSound(Block.soundTypeWood).setResistance(5.0F).setBlockTextureName("wartecmod:BlockReinforcedWood");
	    //Deco
		decoBlockCruiseMissile = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockCruiseMissile").setBlockName("DecoBlockCruiseMissile");
		decoBlockCruiseMissileCluster = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockCruiseMissileCluster").setBlockName("DecoBlockCruiseMissileCluster");
		decoBlockCruiseMissileBuster = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockCruiseMissileBuster").setBlockName("DecoBlockCruiseMissileBuster");
	    decoBlockCruiseMissileEmp = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockCruiseMissileEmp").setBlockName("DecoBlockCruiseMissileEmp");
		decoBlockCruiseMissileFAE = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockCruiseMissileFAE").setBlockName("DecoBlockCruiseMissileFAE");
		decoBlockCruiseMissileNuclear = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockCruiseMissileNuclear").setBlockName("DecoBlockCruiseMissileNuclear");
	    decoBlockCruiseMissileH = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockCruiseMissileH").setBlockName("DecoBlockCruiseMissileH");
	    decoBlockSupersonicCruiseMissile = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockSupersonicCruiseMissile").setBlockName("DecoBlockSupersonicCruiseMissile");
	    decoBlockSupersonicCruiseMissileH = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockSupersonicCruiseMissileH").setBlockName("DecoBlockSupersonicCruiseMissileH");
	    decoBlockHypersonicCruiseMissileNuclear = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockHypersonicCruiseMissileNuclear").setBlockName("DecoBlockHypersonicCruiseMissileNuclear");
	    decoBlockHypersonicCruiseMissile = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockHypersonicCruiseMissile").setBlockName("DecoBlockHypersonicCruiseMissile");
	    decoBlockSatelliteNuclear = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.wood).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockSatelliteNuclear").setBlockName("DecoBlockSatelliteNuclear");
	    decoBlockFlagUS = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.carpet).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockFlagUS").setBlockName("DecoBlockFlagUS");
	    decoBlockFlagSU = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.carpet).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockFlagSU").setBlockName("DecoBlockFlagSU");
	    decoBlockFlagEU = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.carpet).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockFlagEU").setBlockName("DecoBlockFlagEU");
	    decoBlockFlagAL = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.carpet).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockFlagAL").setBlockName("DecoBlockFlagAL");
	    decoBlockFlagCH = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.carpet).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockFlagCH").setBlockName("DecoBlockFlagCH");
	    decoBlockFlagIsr = new com.wartec.wartecmod.blocks.deco.DecoBlock(Material.carpet).setCreativeTab(wartecmod.tabwartecmodblocks).setBlockTextureName(com.wartec.wartecmod.lib.RefStrings.MODID + ":DecoBlockFlagIsr").setBlockName("DecoBlockFlagIsr");
		     
	}

	private static void registerBlock() {
		//MissilesDeco
		GameRegistry.registerBlock(decoBlockCruiseMissile, "DecoBlockCruiseMissile");
		GameRegistry.registerBlock(decoBlockCruiseMissileCluster, "DecoBlockCruiseMissileCluster");
		GameRegistry.registerBlock(decoBlockCruiseMissileBuster, "DecoBlockCruiseMissileBuster");
		GameRegistry.registerBlock(decoBlockCruiseMissileEmp, "DecoBlockCruiseMissileEmp");
		GameRegistry.registerBlock(decoBlockCruiseMissileFAE, "DecoBlockCruiseMissileFAE");
		GameRegistry.registerBlock(decoBlockCruiseMissileNuclear, "DecoBlockCruiseMissileNuclear");
		GameRegistry.registerBlock(decoBlockCruiseMissileH, "DecoBlockCruiseMissileH");
		GameRegistry.registerBlock(decoBlockSupersonicCruiseMissile, "DecoBlockSupersonicCruiseMissile");
		GameRegistry.registerBlock(decoBlockSupersonicCruiseMissileH, "DecoBlockSupersonicCruiseMissileH");
		GameRegistry.registerBlock(decoBlockHypersonicCruiseMissile, "DecoBlockHypersonicCruiseMissile");
		GameRegistry.registerBlock(decoBlockHypersonicCruiseMissileNuclear, "DecoBlockHypersonicCruiseMissileNuclear");
		GameRegistry.registerBlock(decoBlockSatelliteNuclear, "DecoBlockSatelliteNuclear");
		//Missile equipment
		GameRegistry.registerBlock(LaunchTube, LaunchTube.getUnlocalizedName());
		GameRegistry.registerBlock(VlsExhaust, VlsExhaust.getUnlocalizedName());
		GameRegistry.registerBlock(BallisticMissileLauncher, BallisticMissileLauncher.getUnlocalizedName());
		//Blocks
		GameRegistry.registerBlock(BlockArmorSteel, BlockArmorSteel.getUnlocalizedName());
		GameRegistry.registerBlock(BlockReinforcedWood, BlockReinforcedWood.getUnlocalizedName());
		//Deco
		GameRegistry.registerBlock(decoBlockFlagUS, "DecoBlockFlagUS");
		GameRegistry.registerBlock(decoBlockFlagSU, "DecoBlockFlagSU");
		GameRegistry.registerBlock(decoBlockFlagEU, "DecoBlockFlagEU");
		GameRegistry.registerBlock(decoBlockFlagAL, "DecoBlockFlagAL");
		GameRegistry.registerBlock(decoBlockFlagCH, "DecoBlockFlagCH");
		GameRegistry.registerBlock(decoBlockFlagIsr, "DecoBlockFlagIsr");
		//Tileentities
		GameRegistry.registerTileEntity(TileEntityDecoBlock.class, "tileDecoBlockCruiseMissile");
		GameRegistry.registerTileEntity(TileEntityDecoBlock.class, "tileDecoBlockFlagUS");
		GameRegistry.registerTileEntity(TileEntityDecoBlock.class, "tileDecoBlockFlagSU");
		GameRegistry.registerTileEntity(TileEntityDecoBlock.class, "tileDecoBlockFlagEU");
		GameRegistry.registerTileEntity(TileEntityDecoBlock.class, "tileDecoBlockFlagCH");
		
		
	}

}
