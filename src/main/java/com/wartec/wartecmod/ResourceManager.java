package com.wartec.wartecmod;

import com.wartec.wartecmod.lib.RefStrings;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ResourceManager {
	
//Blocks	
	//Models
	public static final IModelCustom block_Cruise_Missile = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Cruise_Missile.obj"));
	public static final IModelCustom block_Supersonic_Cruise_Missile = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Supersonic_Cruise_Missile.obj"));
	public static final IModelCustom block_Hypersonic_Cruise_Missile = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Hypersonic_Cruise_Missile.obj"));
	public static final IModelCustom block_Flag = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Flag.obj"));
	public static final IModelCustom launchTube = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/Launch_Tube.obj"));
	public static final IModelCustom vlsExhaust = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/vls_exhaust.obj"));
	public static final IModelCustom BallisticMissileLauncher = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/Ballistic_Missile_Launcher.obj"));
	public static final IModelCustom block_Satellite_Nuclear_Base = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_sat_nuclear_base.obj"));
	public static final IModelCustom block_Satellite_Nuclear_Launcher = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_sat_nuclear_launcher.obj"));
	public static final IModelCustom block_Satellite_Nuclear_Missiles = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_sat_nuclear_missiles.obj"));
	public static final IModelCustom block_Satellite_Nuclear_Com = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_sat_nuclear_com.obj"));
	public static final IModelCustom block_Supersonic_Cruise_Missile_Protection = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Supersonic_Cruise_Missile_Protection.obj"));
	public static final IModelCustom block_Supersonic_Cruise_Missile_Ramjet = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Supersonic_Cruise_Missile_Ramjet.obj"));
	public static final IModelCustom block_Supersonic_Cruise_Missile_Fuselage = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Supersonic_Cruise_Missile_Fuselage.obj"));
	public static final IModelCustom block_Supersonic_Cruise_Missile_Engine = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Supersonic_Cruise_Missile_Engine.obj"));
	public static final IModelCustom block_Supersonic_Cruise_Missile_Booster = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/blocks/block_Supersonic_Cruise_Missile_Booster.obj"));
	//Textures
    public static final ResourceLocation block_Flag_tex_US = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/block_Flag_tex_US.png");
	public static final ResourceLocation block_Flag_tex_SU = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/block_Flag_tex_SU.png");
	public static final ResourceLocation block_Flag_tex_EU = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/block_Flag_tex_EU.png");
	public static final ResourceLocation block_Flag_tex_AL = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/block_Flag_tex_AL.png");
	public static final ResourceLocation block_Flag_tex_CH = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/block_Flag_tex_CH.png");
	public static final ResourceLocation block_Flag_tex_Isr = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/block_Flag_tex_Isr.png");
	public static final ResourceLocation launcher_tex = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/launcher_tex.png");
	public static final ResourceLocation vls_exhaust_tex = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/vls_exhaust_tex.png");
	public static final ResourceLocation launcher_cover_tex = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/launcher_cover_tex.png");
	public static final ResourceLocation BallisticMissileLauncher_tex = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/Ballistic_Missile_Launcher.png");
	public static final ResourceLocation sat_nuclear_base_tex = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/sat_nuclear_base_tex.png");
	public static final ResourceLocation sat_nuclear_com_tex = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/sat_nuclear_com_tex.png");
	public static final ResourceLocation sat_nuclear_launcher_tex = new ResourceLocation(RefStrings.MODID, "textures/models/blocks/sat_nuclear_launcher_tex.png");

//Entities
	//Models
    public static final IModelCustom entity_ASAT_Missile_Warhead = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_ASAT_Missile_Warhead.obj"));
	public static final IModelCustom entity_ASAT_Missile_Fuselage = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_ASAT_Missile_Fuselage.obj"));
	public static final IModelCustom entity_ASAT_Missile_Thruster = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_ASAT_Missile_Thruster.obj"));
	public static final IModelCustom entity_Hypersonic_Cruise_Missile_Scramjet = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Hypersonic_Cruise_Missile_Scramjet.obj"));
	public static final IModelCustom entity_Hypersonic_Cruise_Missile_Booster = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Hypersonic_Cruise_Missile_Booster.obj"));
	public static final IModelCustom entity_Hypersonic_Cruise_Missile_Wings = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Hypersonic_Cruise_Missile_Wings.obj"));
	public static final IModelCustom entity_Hypersonic_Cruise_Missile_Fins = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Hypersonic_Cruise_Missile_Fins.obj"));
	public static final IModelCustom entity_Slbm_Missile = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Slbm_Missile.obj"));
	public static final IModelCustom entity_Cruise_Missile_Base = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Cruise_Missile_Base.obj"));
	public static final IModelCustom entity_Cruise_Missile_Booster = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Cruise_Missile_Booster.obj"));
	public static final IModelCustom entity_Cruise_Missile_Sealing = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Cruise_Missile_Sealing.obj"));
	public static final IModelCustom entity_Cruise_Missile_Fins = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Cruise_Missile_Fins.obj"));
	public static final IModelCustom entity_Cruise_Missile_Turbofan = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Cruise_Missile_Turbofan.obj"));
	public static final IModelCustom entity_Cruise_Missile_Wings = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Cruise_Missile_Wings.obj"));
	public static final IModelCustom entity_Kalibr_Missile = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Kalibr_Missile.obj"));
	public static final IModelCustom entity_Kalibr_Missile_Base = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Kalibr_Missile_Base.obj"));
	public static final IModelCustom entity_Kalibr_Missile_Booster = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Kalibr_Missile_Booster.obj"));
	public static final IModelCustom entity_Kalibr_Missile_Wings = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Kalibr_Missile_Wings.obj"));
	public static final IModelCustom entity_Kalibr_Missile_Fins = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Kalibr_Missile_Fins.obj"));
	public static final IModelCustom entity_Kalibr_Missile_Fins_Folded = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Kalibr_Missile_Fins_Folded.obj"));
	public static final IModelCustom entity_Kalibr_Missile_Valves = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Kalibr_Missile_Valves.obj"));
	public static final IModelCustom entity_Tomahawk_Missile = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Tomahawk_Missile.obj"));	
	public static final IModelCustom entity_Cj10_Missile = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Cj10_Missile.obj"));
	public static final IModelCustom entity_Supersonic_Cruise_Missile_Protection = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Supersonic_Cruise_Missile_Protection.obj"));
	public static final IModelCustom entity_Supersonic_Cruise_Missile_Booster = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Supersonic_Cruise_Missile_Booster.obj"));
	public static final IModelCustom entity_Supersonic_Cruise_Missile_Wings_Large = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Supersonic_Cruise_Missile_Wings_Large.obj"));
	public static final IModelCustom entity_Supersonic_Cruise_Missile_Wings_Small = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Supersonic_Cruise_Missile_Wings_Small.obj"));
	public static final IModelCustom entity_Supersonic_Cruise_Missile_Ramjet = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Supersonic_Cruise_Missile_Ramjet.obj"));
	public static final IModelCustom entity_Supersonic_Cruise_Missile_Fuselage = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Supersonic_Cruise_Missile_Fuselage.obj"));
	public static final IModelCustom entity_Supersonic_Cruise_Missile_Engine = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Supersonic_Cruise_Missile_Engine.obj"));
	public static final IModelCustom entity_Iskander_Missile = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Iskander_Missile.obj"));	
	public static final IModelCustom entity_Lrhw_Missile_Booster = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Lrhw_Missile_Booster.obj"));
	public static final IModelCustom entity_Lrhw_Missile_Cone = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Lrhw_Missile_Cone.obj"));
	public static final IModelCustom entity_Lrhw_Missile_Glider = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Lrhw_Missile_Glider.obj"));
	public static final IModelCustom entity_Missile_Micro = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Missile_Micro.obj"));
	public static final IModelCustom entity_Missile_Anti_Air_Tier1 = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Missile_Anti_Air_Tier1.obj"));
	public static final IModelCustom entity_Satellite_Missile_Nuclear = AdvancedModelLoader.loadModel(new ResourceLocation(RefStrings.MODID, "models/entity_Satellite_Missile_Nuclear.obj"));
	//Textures
	public static final ResourceLocation entity_ASAT_Missile_Warhead_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_ASAT_Missile_Warhead_tex.png");
	public static final ResourceLocation entity_ASAT_Missile_Fuselage_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_ASAT_Missile_Fuselage_tex.png");
	public static final ResourceLocation entity_ASAT_Missile_Thruster_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_ASAT_Missile_Thruster_tex.png");
	public static final ResourceLocation entity_Hypersonic_Cruise_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Hypersonic_Cruise_Missile_tex.png");
	public static final ResourceLocation entity_Hypersonic_Cruise_Missile_Nuclear_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Hypersonic_Cruise_Missile_Nuclear_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_Protection_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_Protection_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_Ramjet_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_Ramjet_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_Fuselage_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_Fuselage_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_Fuselage_H_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_Fuselage_H_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_Engine_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_Engine_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_Booster_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_Booster_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_Wings_Large_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_Wings_Large_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_Wings_Small_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_Wings_Small_tex.png");
	public static final ResourceLocation entity_Slbm_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Slbm_Missile_tex.png");
	public static final ResourceLocation entity_Cruise_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cruise_Missile_tex.png");
	public static final ResourceLocation entity_Cruise_Missile_buster_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cruise_Missile_tex_Buster.png");
	public static final ResourceLocation entity_Cruise_Missile_nuclear_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cruise_Missile_tex_Nuclear.png");
	public static final ResourceLocation entity_Cruise_Missile_Cluster_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cruise_Missile_tex_Cluster.png");
	public static final ResourceLocation entity_Cruise_Missile_H_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cruise_Missile_tex_H.png");
	public static final ResourceLocation entity_Cruise_Missile_Gas_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cruise_Missile_tex_Gas.png");
	public static final ResourceLocation entity_Cruise_Missile_FAE_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cruise_Missile_tex_FAE.png");
	public static final ResourceLocation entity_Cruise_Missile_Emp_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cruise_Missile_tex_Emp.png");
	public static final ResourceLocation Test_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_TH_Cruise_Missile_tex.png");
	public static final ResourceLocation entity_Kalibr_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Kalibr_Missile_tex.png");
	public static final ResourceLocation entity_Cj10_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Cj10_Missile_tex.png");
	public static final ResourceLocation entity_Tomahawk_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Tomahawk_Missile_tex.png");
	public static final ResourceLocation entity_Supersonic_Cruise_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Supersonic_Cruise_Missile_tex.png");
	public static final ResourceLocation entity_Iskander_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Iskander_Missile_tex.png");
	public static final ResourceLocation entity_Lrhw_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Lrhw_Missile_tex.png");
	public static final ResourceLocation entity_Missile_Micro_Gas_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Missile_Micro_Gas.png");
	public static final ResourceLocation entity_Missile_Micro_H_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Missile_Micro_H.png");
	public static final ResourceLocation entity_Missile_Micro_Neutron_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Missile_Micro_Neutron.png");
	public static final ResourceLocation entity_Missile_Anti_Air_Tier1_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_Missile_Anti_Air_Tier1.png");
	public static final ResourceLocation entity_Sat_Nuclear_Missile_tex = new ResourceLocation(RefStrings.MODID, "textures/models/entity_sat_nuclear_missile_tex.png");
	
}
