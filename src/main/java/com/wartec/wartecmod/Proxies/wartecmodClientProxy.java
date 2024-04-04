package com.wartec.wartecmod.Proxies;


import com.wartec.wartecmod.entity.missile.*;
import com.wartec.wartecmod.items.wartecmodItems;
import com.wartec.wartecmod.render.item.*;
import com.wartec.wartecmod.render.missile.*;
import com.wartec.wartecmod.render.tileentity.RenderTileEntityBallisticMissileLauncher;
import com.wartec.wartecmod.render.tileentity.*;
import com.wartec.wartecmod.render.tileentity.vls.RenderTileEntityVlsLaunchTube;
import com.wartec.wartecmod.render.tileentity.vls.RenderTileEntityVlsExhaust;
import com.wartec.wartecmod.tileentity.deco.TileEntityDecoBlock;
import com.wartec.wartecmod.tileentity.launcher.TileEntityBallisticMissileLauncher;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsLaunchTube;


import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class wartecmodClientProxy extends wartecmodProxy {
	
	@Override
	public void registerRenderers() {
		//TE
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDecoBlock.class, new RenderTileEntityDecoBlock());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVlsLaunchTube.class, new RenderTileEntityVlsLaunchTube());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVlsExhaust.class, new RenderTileEntityVlsExhaust());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBallisticMissileLauncher.class, new RenderTileEntityBallisticMissileLauncher());

         //Entities
    	RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileHE.class, new RenderCruiseMissileHE());
    	RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileH.class, new RenderCruiseMissileH());
        RenderingRegistry.registerEntityRenderingHandler(EntityMissileSlbm.class, new RenderMissileSlbm());
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileNuclear.class, new RenderCruiseMissileNuclear());
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileTB.class, new RenderCruiseMissileFAE());
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileBuster.class, new RenderCruiseMissileBuster());
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileEmp.class, new RenderCruiseMissileEmp());
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileCluster.class, new RenderCruiseMissileCluster());
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileFragmentation.class, new RenderCruiseMissileFragmentation());
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileSubsonic.EntityCruiseMissileTest.class, new RenderCruiseMissileDecoy()); //Decoy
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileMiniNuke.class, new RenderCruiseMissileMiniNuke());
        RenderingRegistry.registerEntityRenderingHandler(EntityCruiseMissileWP.class, new RenderCruiseMissileWP());


        RenderingRegistry.registerEntityRenderingHandler(EntityHypersonicCruiseMissileHE.class, new RenderHypersonicCruiseMissileHE());
        RenderingRegistry.registerEntityRenderingHandler(EntityIskanderMissile.class, new RenderIskanderMissile());
        RenderingRegistry.registerEntityRenderingHandler(EntityLrhwMissile.class, new RenderLrhwMissile());
        RenderingRegistry.registerEntityRenderingHandler(EntitySupersonicCruiseMissileHE.class, new RenderSupersonicCruiseMissileHE());
        RenderingRegistry.registerEntityRenderingHandler(EntityTomahawkMissile.class, new RenderTomahawkMissile());
        RenderingRegistry.registerEntityRenderingHandler(EntityKalibrMissile.class, new RenderKalibrMissile());
        RenderingRegistry.registerEntityRenderingHandler(EntitySupersonicCruiseMissileH.class, new RenderSupersonicCruiseMissileH());
        RenderingRegistry.registerEntityRenderingHandler(EntityHypersonicCruiseMissileNuclear.class, new RenderHypersonicCruiseMissileNuclear());
        RenderingRegistry.registerEntityRenderingHandler(EntityMissileMicroGas.class, new RenderMissileMicroGas());
        RenderingRegistry.registerEntityRenderingHandler(EntityMissileMicroNeutron.class, new RenderMissileMicroNeutron());
        RenderingRegistry.registerEntityRenderingHandler(EntityMissileAntiBallisticNuclear.class, new RenderMissileAntiBallisticNuclear());
        RenderingRegistry.registerEntityRenderingHandler(EntityMissileAntiAirTier1.class, new RenderMissileAntiAirTier1());
        RenderingRegistry.registerEntityRenderingHandler(EntitySatelliteMissileNuclear.class, new RenderSatelliteMissileNuclear());
        RenderingRegistry.registerEntityRenderingHandler(EntityMissileASAT.class, new RenderMissileASAT());

        
         //Items
		MinecraftForgeClient.registerItemRenderer(wartecmodItems.itemKalibrMissile, new ItemRenderKalibrMissile());
		MinecraftForgeClient.registerItemRenderer(wartecmodItems.itemTomahawkMissile, new ItemRenderTomahawkMissile());
		MinecraftForgeClient.registerItemRenderer(wartecmodItems.itemCj10Missile, new ItemRenderCj10Missile());
		MinecraftForgeClient.registerItemRenderer(wartecmodItems.itemIskanderMissile, new ItemRenderIskanderMissile());
		
		
	}
}
