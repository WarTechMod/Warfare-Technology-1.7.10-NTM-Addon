package com.wartec.wartecmod.hazard;

import com.hbm.hazard.HazardData;
import com.hbm.hazard.HazardSystem;
import com.hbm.hazard.type.HazardTypeAsbestos;
import com.hbm.hazard.type.HazardTypeBase;
import com.hbm.hazard.type.HazardTypeBlinding;
import com.hbm.hazard.type.HazardTypeCoal;
import com.hbm.hazard.type.HazardTypeDigamma;
import com.hbm.hazard.type.HazardTypeExplosive;
import com.hbm.hazard.type.HazardTypeHot;
import com.hbm.hazard.type.HazardTypeHydroactive;
import com.hbm.hazard.type.HazardTypeRadiation;
import com.wartec.wartecmod.items.wartecmodItems;

public class wartecHazardRegistry {

public static final float gen_S = 10_000F;
public static final float gen_H = 2_000F;
public static final float gen_10D = 100F;
public static final float gen_100D = 80F;
public static final float gen_1Y = 50F;
public static final float gen_10Y = 30F;
public static final float gen_100Y = 10F;
public static final float gen_1K = 7.5F;
public static final float gen_10K = 6.25F;
public static final float gen_100K = 5F;
public static final float gen_1M = 2.5F;
public static final float gen_10M = 1.5F;
public static final float gen_100M = 1F;
public static final float gen_1B = 0.5F;
public static final float gen_10B = 0.1F;

public static final float co60 = 30.0F;
public static final float sr90 = 15.0F;
public static final float tc99 = 2.75F;
public static final float i131 = 150.0F;
public static final float xe135 = 1250.0F;
public static final float cs137 = 20.0F;
public static final float au198 = 500.0F;
public static final float at209 = 2000.0F;
public static final float po210 = 75.0F;
public static final float ra226 = 7.5F;
public static final float th232 = 0.1F;
public static final float thf = 1.75F;
public static final float u = 0.35F;
public static final float u233 = 5.0F;
public static final float u235 = 1.0F;
public static final float u238 = 0.25F;
public static final float uf = 0.5F;
public static final float np237 = 2.5F;
public static final float npf = 1.5F;
public static final float pu = 7.5F;
public static final float purg = 6.25F;
public static final float pu238 = 10.0F;
public static final float pu239 = 5.0F;
public static final float pu240 = 7.5F;
public static final float pu241 = 25.0F;
public static final float puf = 4.25F;
public static final float am241 = 8.5F;
public static final float am242 = 9.5F;
public static final float amrg = 9.0F;
public static final float amf = 4.75F;
public static final float mox = 2.5F;
public static final float sa326 = 15.0F;
public static final float sa327 = 17.5F;
public static final float saf = 5.85F;
public static final float sas3 = 5F;
public static final float radsource_mult = 0.5F;
public static final float pobe = po210 * radsource_mult;
public static final float rabe = ra226 * radsource_mult;
public static final float pube = pu238 * radsource_mult;
public static final float zfb_bi = u235 * 0.35F;
public static final float zfb_pu241 = pu241 * 0.5F;
public static final float zfb_am_mix = amrg * 0.5F;
public static final float bf = 300_000.0F;
public static final float bfb = 500_000.0F;

public static final float sr = sa326 * 0.1F;
public static final float sb = sa326 * 0.1F;
public static final float trx = 25.0F;
public static final float trn = 0.1F;
public static final float wst = 15.0F;
public static final float wstv = 7.5F;
public static final float yc = u;
public static final float fo = 10F;

public static final float nugget = 0.1F;
public static final float ingot = 1.0F;
public static final float gem = 1.0F;
public static final float plate = 1.0F;
public static final float powder_mult = 3.0F;
public static final float powder = ingot * powder_mult;
public static final float powder_tiny = nugget * powder_mult;
public static final float ore = ingot;
public static final float block = 10.0F;
public static final float crystal = block;
public static final float billet = 0.5F;
public static final float rtg = billet * 3;
public static final float rod = 0.5F;
public static final float rod_dual = rod * 2;
public static final float rod_quad = rod * 4;
public static final float rod_rbmk = rod * 8;

public static final HazardTypeBase RADIATION = new HazardTypeRadiation();
public static final HazardTypeBase DIGAMMA = new HazardTypeDigamma();
public static final HazardTypeBase HOT = new HazardTypeHot();
public static final HazardTypeBase BLINDING = new HazardTypeBlinding();
public static final HazardTypeBase ASBESTOS = new HazardTypeAsbestos();
public static final HazardTypeBase COAL = new HazardTypeCoal();
public static final HazardTypeBase HYDROACTIVE = new HazardTypeHydroactive();
public static final HazardTypeBase EXPLOSIVE = new HazardTypeExplosive();



public static void registerItems() {
	
	HazardSystem.register(wartecmodItems.itemPlateU238, makeData(RADIATION, (u238 * ingot)*3));
	
}


private static HazardData makeData(HazardTypeBase hazard, float level) { return new HazardData().addEntry(hazard, level);}} 


