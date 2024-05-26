package com.wartec.wartecmod;

import com.hbm.main.ResourceManager;
import com.hbm.render.item.ItemRenderMissileGeneric;
import com.wartec.wartecmod.entity.missile.*;
import com.hbm.inventory.RecipesCommon;
import com.hbm.tileentity.bomb.TileEntityLaunchPadBase;
import com.wartec.wartecmod.items.wartecmodItems;

import static com.hbm.render.item.ItemRenderMissileGeneric.generateLarge;
import static com.hbm.render.item.ItemRenderMissileGeneric.generateStandard;

public class hbmRegistry {

    public static void registerTileEntityLaunchPad(){

        TileEntityLaunchPadBase.registerLaunchables();
        TileEntityLaunchPadBase.missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemMissileMicroPhosgene), EntityMissileMicroPhosgene.class);
        TileEntityLaunchPadBase.missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemMissileMicroGas), EntityMissileMicroGas.class);
        TileEntityLaunchPadBase.missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemMissileMicroNeutron), EntityMissileMicroNeutron.class);
    }

    public static void renderTileEntityLaunchPad() {

        ItemRenderMissileGeneric.init();
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemMissileMicroNeutron), generateStandard(com.wartec.wartecmod.ResourceManager.entity_Missile_Micro_Neutron_tex, ResourceManager.missileMicro));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemMissileMicroGas), generateStandard(com.wartec.wartecmod.ResourceManager.entity_Missile_Micro_Gas_tex, ResourceManager.missileMicro));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemMissileMicroPhosgene), generateStandard(com.wartec.wartecmod.ResourceManager.entity_Missile_Micro_Neutron_tex, ResourceManager.missileMicro));
    }

    public static void renderItemMissile(){

        ItemRenderMissileGeneric.init();
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileH), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_H_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileHe), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNuclear), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_nuclear_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileTB), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_Cluster_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileDecoy), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_nuclear_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileEmp), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_Emp_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileFragmentation), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileMiniNuke), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_nuclear_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileBuster), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_buster_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));
        ItemRenderMissileGeneric.renderers.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileCluster), generateLarge(com.wartec.wartecmod.ResourceManager.entity_Cruise_Missile_Cluster_tex, com.wartec.wartecmod.ResourceManager.entity_Tomahawk_Missile));



    }
    public static void registerTurretTargets(){
        com.hbm.util.CompatExternal.registerTurretTargetSimple(EntityCruiseMissileSubsonic.class, 3);
        //com.hbm.util.CompatExternal.registerTurretTargetSimple(EntityArtilleryRocket.class, 3);
        //com.hbm.util.CompatExternal.registerTurretTargetSimple(EntityArtilleryShell.class, 3);
    }
}
