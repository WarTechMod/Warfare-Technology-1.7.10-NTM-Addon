package com.wartec.wartecmod.savedata.satellites;

import com.hbm.saveddata.satellites.Satellite;
import com.wartec.wartecmod.items.wartecmodItems;

public class SatelliteRegistry {
	public static void registerAll() {

		Satellite.registerSatellite(SatelliteNuclear.class, wartecmodItems.sat_nuclear);
		Satellite.registerSatellite(SatelliteEmp.class, wartecmodItems.sat_emp);

	}
}
