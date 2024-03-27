package com.wartec.wartecmod.entity;

import com.wartec.wartecmod.entity.missile.*;
import com.wartec.wartecmod.wartecmod;
import cpw.mods.fml.common.registry.EntityRegistry;

public class wartecmodEntities {
    
    public static void registerAll(wartecmod mod) {
        EntityRegistry.registerModEntity(EntityMissileSlbm.class, "entity_slbm_Missile", 1, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileHE.class, "entity_Cruise_Missile", 2, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileH.class, "entity_Cruise_Missile_H", 3, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileNuclear.class, "entity_Cruise_Missile_Nuclear", 4, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileTB.class, "entity_Cruise_Missile_FAE", 6, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileCluster.class, "entity_Cruise_Missile_Cluster", 7, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileBuster.class, "entity_Cruise_Missile_Buster", 8, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileEmp.class, "entity_Cruise_Missile_Emp", 9, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityHypersonicCruiseMissileHE.class, "entity_Hypersonic_Cruise_Missile", 10, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityIskanderMissile.class, "entity_Iskander_Missile", 11, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityLrhwMissile.class, "entity_Lrhw_Missile", 12, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntitySupersonicCruiseMissileHE.class, "entity_Supersonic_Cruise_Missile", 13, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityTomahawkMissile.class, "entity_Tomahawk_Missile", 14, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityKalibrMissile.class, "entity_Kalibr_Missile", 15, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntitySupersonicCruiseMissileH.class, "entity_Supersonic_Cruise_Missile_Nuclear", 16, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityHypersonicCruiseMissileNuclear.class, "entity_Hypersonic_Cruise_Missile_H", 17, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityMissileMicroGas.class, "entity_Missile_Micro_Gas", 18, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityMissileMicroNeutron.class, "entity_Missile_Micro_Neutron", 20, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityMissileAntiBallisticNuclear.class, "entity_Missile_Anti_Ballistic_Nuclear", 19, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityMissileAntiAirTier1.class, "entity_Missile_Anti_Air_Tier1", 21, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCJ10Missile.class, "entity_CJ10_Missile", 22, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntitySatelliteMissileNuclear.class, "entity_Satellite_Missile_Nuclear", 23, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileFragmentation.class, "entity_Cruise_Missile_Fragmentation", 24, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityMissileASAT.class, "entity_Missile_asat", 25, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileDecoy.class, "entity_Cruise_Missile_Decoy", 26, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileMiniNuke.class, "entity_Cruise_Missile_Mini_Nuke", 27, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileWP.class, "entity_Cruise_Missile_WP", 28, mod, 1000, 1, true);
        EntityRegistry.registerModEntity(EntityCruiseMissileFragmentation.class, "entity_Cruise_Missile_Fragmentation", 29, mod, 1000, 1, true);
        }
    
}
