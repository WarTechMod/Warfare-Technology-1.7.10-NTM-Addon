package com.wartec.wartecmod.packet;



import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketRegistry {

	//Mark 1 Packet Sending Device
	public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(com.wartec.wartecmod.lib.RefStrings.MODID);

	public static final void registerPackets()
	{
		int i = 0;

		wrapper.registerMessage(TEBallisticMissileLauncherMissilePacket.Handler.class, TEBallisticMissileLauncherMissilePacket.class, i++, Side.CLIENT);
		wrapper.registerMessage(TELaunchTubePacket.Handler.class, TELaunchTubePacket.class, i++, Side.CLIENT);
		}
	
}