package com.wartec.wartecmod.packet;

import com.hbm.interfaces.Spaghetti;
import com.wartec.wartecmod.items.wartecmodItems;
import com.wartec.wartecmod.tileentity.launcher.TileEntityBallisticMissileLauncher;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TEBallisticMissileLauncherMissilePacket implements IMessage {

	int x;
	int y;
	int z;
	int type;

	public TEBallisticMissileLauncherMissilePacket() { }

	@Spaghetti("die")
	public TEBallisticMissileLauncherMissilePacket(int x, int y, int z, ItemStack stack) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = 0;
		if(stack != null) {
			if(stack.getItem() == wartecmodItems.itemMissileSLBM)
				type = 1;
			if(stack.getItem() == wartecmodItems.itemIskanderMissile)
				type = 2;
			if(stack.getItem() == wartecmodItems.itemLrhwMissile)
				type = 3;
			if(stack.getItem() == wartecmodItems.itemMissileMicroGas)
				type = 4;
			if(stack.getItem() == wartecmodItems.itemMissileMicroNeutron)
				type = 6;
			if(stack.getItem() == wartecmodItems.itemMissileAsat)
				type = 7;
		}
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		type = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(type);
	}

	public static class Handler implements IMessageHandler<TEBallisticMissileLauncherMissilePacket, IMessage> {
		
		@Override
		public IMessage onMessage(TEBallisticMissileLauncherMissilePacket m, MessageContext ctx) {
			
			try {
				TileEntity te = Minecraft.getMinecraft().theWorld.getTileEntity(m.x, m.y, m.z);
	
				if (te != null && te instanceof TileEntityBallisticMissileLauncher) {
						
					TileEntityBallisticMissileLauncher gen = (TileEntityBallisticMissileLauncher)te;
					gen.state = m.type;
				}
			} catch(Exception e) { }
			
			return null;
		}
	}
}
