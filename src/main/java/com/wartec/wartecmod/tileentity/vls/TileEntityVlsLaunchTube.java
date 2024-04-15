/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.hbm.lib.Library
 *  com.hbm.packet.AuxElectricityPacket
 *  com.hbm.packet.PacketDispatcher
 *  com.hbm.tileentity.TileEntityLoadedBase
 *  cpw.mods.fml.common.network.NetworkRegistry$TargetPoint
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ISidedInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraftforge.common.util.ForgeDirection
 */
package com.wartec.wartecmod.tileentity.vls;

import api.hbm.energymk2.IEnergyReceiverMK2;
import com.hbm.config.GeneralConfig;
import com.hbm.entity.missile.EntityMissileAntiBallistic;
import com.hbm.explosion.ExplosionLarge;
import com.hbm.interfaces.Spaghetti;
import com.hbm.items.ModItems;
import com.hbm.items.weapon.ItemMissile;
import com.hbm.lib.Library;
import com.hbm.main.MainRegistry;
import com.hbm.packet.AuxElectricityPacket;
import com.hbm.packet.PacketDispatcher;
import com.hbm.tileentity.TileEntityLoadedBase;
import com.wartec.wartecmod.blocks.vls.VlsExhaust;
import com.wartec.wartecmod.blocks.vls.VlsVerticalLauncher;
import com.wartec.wartecmod.entity.missile.EntityMissileAntiAirTier1;
import com.wartec.wartecmod.entity.missile.EntityMissileAntiBallisticNuclear;
import com.wartec.wartecmod.interfaces.ILauncher;
import com.wartec.wartecmod.items.IMissileSpawningItem;
import com.wartec.wartecmod.items.wartecmodItems;
import com.wartec.wartecmod.packet.PacketRegistry;
import com.wartec.wartecmod.packet.TELaunchTubePacket;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import java.util.List;

public class TileEntityVlsLaunchTube
		extends TileEntityLoadedBase
		implements ISidedInventory,
		IEnergyReceiverMK2 {
	public ItemStack[] slots = new ItemStack[3];
	public long power;
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{0, 1, 2};
	private static final int[] slots_side = new int[]{0};
	public int state = 0;

	public int openingAnimation = 0;
	public boolean open = false;
	public int shoot = 0;

	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null) {
			ItemStack itemStack = this.slots[i];
			this.slots[i] = null;
			return itemStack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		this.slots[i] = itemStack;
		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return "container.LaunchTube";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
			return false;
		}
		return player.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) <= 64.0;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return true;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.slots[i] != null) {
			if (this.slots[i].stackSize <= j) {
				ItemStack itemStack = this.slots[i];
				this.slots[i] = null;
				return itemStack;
			}
			ItemStack itemStack1 = this.slots[i].splitStack(j);
			if (this.slots[i].stackSize == 0) {
				this.slots[i] = null;
			}
			return itemStack1;
		}
		return null;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("items", 10);
		this.power = nbt.getLong("power");

		openingAnimation = nbt.getInteger("openanim");
		shoot = nbt.getInteger("shoot");
		open = nbt.getBoolean("open");

		this.slots = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < list.tagCount(); ++i) {
			NBTTagCompound nbt1 = list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("slot");
			if (b0 < 0 || b0 >= this.slots.length) continue;
			this.slots[b0] = ItemStack.loadItemStackFromNBT((NBTTagCompound)nbt1);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagList list = new NBTTagList();
		nbt.setLong("power", this.power);

		nbt.setInteger("openanim",openingAnimation);
		nbt.setInteger("shoot",shoot);
		nbt.setBoolean("open",open);

		for (int i = 0; i < this.slots.length; ++i) {
			if (this.slots[i] == null) continue;
			NBTTagCompound nbt1 = new NBTTagCompound();
			nbt1.setByte("slot", (byte)i);
			this.slots[i].writeToNBT(nbt1);
			list.appendTag((NBTBase)nbt1);
		}
		nbt.setTag("items", (NBTBase)list);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return p_94128_1_ == 0 ? slots_bottom : (p_94128_1_ == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemStack, int j) {
		return this.isItemValidForSlot(i, itemStack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return true;
	}

	public long getPowerScaled(long i) {
		return this.power * i / 100000L;
	}

	private TileEntityVlsExhaust exhaust = null;
	private int exhaustSearchDelay = 0;

	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			if(exhaustSearchDelay <= 0) {
				exhaust = findExhaust();
				exhaustSearchDelay = 90;
			}
			exhaustSearchDelay--;

			if(open && openingAnimation < 90)
				openingAnimation += 3;
			if( !open && openingAnimation > 0)
				openingAnimation -= 3;

			if(shoot == 50) {
				open = true;
				if(exhaust != null)
					exhaust.open = true;
			}
			if(openingAnimation >= 86 && shoot == 50) {
				this.shoot(this.worldObj, xCoord, yCoord, zCoord);
				shoot--;
			}
			if(shoot > 0 && shoot < 50)
				shoot--;
			if(shoot == 0) {
				open = false;
				if(exhaust != null)
					exhaust.open = false;
			}

			this.power = Library.chargeTEFromItems(this.slots, 2, this.power, 100000L);
			this.updateConnections();
			PacketRegistry.wrapper.sendToAllAround(new TELaunchTubePacket(this.xCoord, this.yCoord, this.zCoord, this.slots[0], openingAnimation), new NetworkRegistry.TargetPoint(this.worldObj.provider.dimensionId, (double)this.xCoord, (double)this.yCoord, (double)this.zCoord, 250.0));
			PacketDispatcher.wrapper.sendToAllAround(new AuxElectricityPacket(this.xCoord, this.yCoord, this.zCoord, this.power), new NetworkRegistry.TargetPoint(this.worldObj.provider.dimensionId, (double)this.xCoord, (double)this.yCoord, (double)this.zCoord, 50.0));
		}
	}

	private void updateConnections() {
		this.trySubscribe(this.worldObj, this.xCoord + 1, this.yCoord, this.zCoord, Library.POS_X);
		this.trySubscribe(this.worldObj, this.xCoord - 1, this.yCoord, this.zCoord, Library.NEG_X);
		this.trySubscribe(this.worldObj, this.xCoord, this.yCoord, this.zCoord + 1, Library.POS_Z);
		this.trySubscribe(this.worldObj, this.xCoord, this.yCoord, this.zCoord - 1, Library.NEG_Z);
		this.trySubscribe(this.worldObj, this.xCoord, this.yCoord - 1, this.zCoord, Library.NEG_Y);
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return TileEntity.INFINITE_EXTENT_AABB;
	}

	@Override
	public void setPower(long i) {
		this.power = i;
	}

	@Override
	public long getPower() {
		return this.power;
	}

	@Override
	public long getMaxPower() {
		return 100000L;
	}

	@Override
	public long transferPower(long power) {
		this.power += power;
		if (this.power > this.getMaxPower()) {
			long overshoot = this.power - this.getMaxPower();
			this.power = this.getMaxPower();
			return overshoot;
		}
		return 0L;
	}

	@Override
	public boolean canConnect(ForgeDirection dir) {
		return dir != ForgeDirection.UP && dir != ForgeDirection.UNKNOWN;
	}

	@SideOnly(value=Side.CLIENT)
	@Override
	public double getMaxRenderDistanceSquared() {
		return 65536.0;
	}

	private int[] findNearesExhaust() {
		int[] pos = new int[] {xCoord, zCoord};

		List<int[]> visited = new ArrayList<>();
		visited.add(pos);

		return getNeighbors(pos, 30, visited);
	}

	private int[] getNeighbors(int[] pos, int maxit, List<int[]> visited) {
		if(maxit <= 0)
			return null;

		Block neighbor;
		int[] p;

		neighbor = worldObj.getBlock(pos[0], yCoord, pos[1] - 1);
		p = new int[] {pos[0], pos[1]-1};
		//if(!visited.contains(p)) {
			visited.add(p);
			if (neighbor instanceof VlsExhaust) {
				return p;
			}
			if (neighbor instanceof VlsVerticalLauncher) {
				int[] s = getNeighbors(p, maxit - 1, visited);
				if (s != null) {
					return s;
				}
			}
		//}

		neighbor = worldObj.getBlock(pos[0], yCoord, pos[1] + 1);
		p = new int[] {pos[0], pos[1]+1};
		//if(!visited.contains(p)) {
			visited.add(p);
			if (neighbor instanceof VlsExhaust) {
				return p;
			}
			if (neighbor instanceof VlsVerticalLauncher) {
				int[] s = getNeighbors(p, maxit - 1, visited);
				if (s != null) {
					return s;
				}
			}
		//}

		neighbor = worldObj.getBlock(pos[0] - 1, yCoord, pos[1]);
		p = new int[] {pos[0]-1, pos[1]};
		//if(!visited.contains(p)) {
			visited.add(p);
			if (neighbor instanceof VlsExhaust) {
				return p;
			}
			if (neighbor instanceof VlsVerticalLauncher) {
				int[] s = getNeighbors(p, maxit - 1, visited);
				if (s != null) {
					return s;
				}
			}
		//}

		neighbor = worldObj.getBlock(pos[0] + 1, yCoord, pos[1]);
		p = new int[] {pos[0]+1, pos[1]};
		//if(!visited.contains(p)) {
			visited.add(p);
			if (neighbor instanceof VlsExhaust) {
				return p;
			}
			if (neighbor instanceof VlsVerticalLauncher) {
				return getNeighbors(p, maxit - 1, visited);
			}
		//}

		return null;
	}

	public TileEntityVlsExhaust findExhaust() {
		int[] exh = findNearesExhaust();
		//System.out.println(Arrays.toString(exh));
		if(exh != null) {
			Block b = worldObj.getBlock(exh[0], yCoord, exh[1]);
			if(b instanceof VlsExhaust) {
				VlsExhaust exhaust = (VlsExhaust) b;
				int[] c = exhaust.findCore(worldObj, exh[0], yCoord, exh[1]);
				return (TileEntityVlsExhaust) worldObj.getTileEntity(c[0], c[1], c[2]);
			}
			return null;
		}
		return null;
	}

	public ILauncher.StatusReturnCode shoot(World world, int x, int y, int z) {
		try {
			int[] pos = ((VlsVerticalLauncher)world.getBlock(x, y, z)).findCore(world, x, y, z);
			if(pos == null) {;
				return ILauncher.StatusReturnCode.ERROR_MISSING_COMPONENT;
			}
			TileEntityVlsLaunchTube entity = (TileEntityVlsLaunchTube)world.getTileEntity(pos[0], pos[1], pos[2]);

			int xCoord = entity.slots[1].stackTagCompound.getInteger("xCoord");
			int yCoord = entity.slots[1].stackTagCompound.getInteger("yCoord");
			int zCoord = entity.slots[1].stackTagCompound.getInteger("zCoord");
			if (xCoord == entity.xCoord && zCoord == entity.zCoord) {
				xCoord += 6;
			}

			return shootSpecial(world, pos[0], pos[1], pos[2], xCoord, yCoord, zCoord);
		} catch (Exception e) { }
		return ILauncher.StatusReturnCode.ERROR_MISSING_COMPONENT;
	}

	@Spaghetti(value="AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA *takes breath* AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
	public ILauncher.StatusReturnCode shootSpecial(World world, int x, int y, int z, int xCoord, int yCoord, int zCoord) {
		TileEntityVlsLaunchTube entity = (TileEntityVlsLaunchTube)world.getTileEntity(x, y, z);

		int Range = (int) ((Math.sqrt(((xCoord - x) * (xCoord - x)) + ((yCoord - y) * (yCoord - y)) + ((zCoord - z) * (zCoord - z)))));

		if (entity.slots[0] == null || world.isRemote) {
			return ILauncher.StatusReturnCode.ERROR_MISSING_COMPONENT;
		}
		if (Range < 250 ) {
			return ILauncher.StatusReturnCode.FAILED_TO_CLOSE;
		}
		if (Range > 4500 ) {
			return ILauncher.StatusReturnCode.FAILED_TO_FAR;
		}
		if (entity.power >= 75000L) {
			if(entity.slots[0].getItem() instanceof ItemMissile) {
				Class<? extends Entity> missile = ((IMissileSpawningItem) entity.slots[0].getItem()).getMissile();
				Entity missileEntity;
				try {
					TileEntityVlsExhaust exhaust = findExhaust();
					try {
						Constructor<?> constructor = missile.getConstructor(World.class, float.class, float.class, float.class, int.class, int.class, int.class, TileEntityVlsExhaust.class);
						missileEntity = (Entity) constructor.newInstance(world, (float) x + 0.5f, (float) y + 11.0f, (float) z + 0.5f, xCoord, yCoord, zCoord, exhaust);
					} catch (Exception e) {
						// old constructor ~~(definetifly wasnt too lazy to update everything)~~
						Constructor<?> constructor = missile.getConstructor(World.class, float.class, float.class, float.class, int.class, int.class, int.class);
						missileEntity = (Entity) constructor.newInstance(world, (float) x + 0.5f, (float) y + 11.0f, (float) z + 0.5f, xCoord, yCoord, zCoord);
					}

					world.spawnEntityInWorld(missileEntity);
					world.playSoundEffect(x, y + 10, z, "wartecmod:weapon.CruiseMissileTakeoff", 10.0f, 1.0f);

					if(exhaust == null) {
						ExplosionLarge.spawnParticles(world, x, y + 11.0f, z, 5);
					}

					entity.power -= 50000L;
					entity.slots[0] = null;
					if (GeneralConfig.enableExtendedLogging) {
						MainRegistry.logger.log(Level.INFO, "[MISSILE] Tried to launch missile at " + x + " / " + y + " / " + z + " to " + xCoord + " / " + zCoord + "!");
					}
					return ILauncher.StatusReturnCode.LAUNCHED;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		if (entity.slots[0] != null && entity.slots[0].getItem() == ModItems.missile_anti_ballistic && entity.power >= 75000L) {
			EntityMissileAntiBallistic missile = new EntityMissileAntiBallistic(world);
			missile.posX = (float)x + 0.5f;
			missile.posY = (float)y + 11;
			missile.posZ = (float)z + 0.5f;
			world.spawnEntityInWorld((Entity)missile);
			entity.power -= 75000L;
			entity.slots[0] = null;
			world.playSoundEffect((double)x, (double)y, (double)z, "hbm:weapon.missileTakeOff", 2.0f, 1.0f);
			return ILauncher.StatusReturnCode.LAUNCHED;
		}
		if (entity.slots[0] != null && entity.slots[0].getItem() == wartecmodItems.itemMissileAntiBallisticNuclear && entity.power >= 5000L) {
			EntityMissileAntiBallisticNuclear missile = new EntityMissileAntiBallisticNuclear(world);
			missile.posX = (float)x + 0.5f;
			missile.posY = (float)y + 11;
			missile.posZ = (float)z + 0.5f;
			world.spawnEntityInWorld((Entity)missile);
			entity.power -= 5000L;
			entity.slots[0] = null;
			world.playSoundEffect((double)x, (double)y, (double)z, "hbm:weapon.missileTakeOff", 2.0f, 1.0f);
			return ILauncher.StatusReturnCode.LAUNCHED;
		}
		if (entity.slots[0] != null && entity.slots[0].getItem() == wartecmodItems.itemMissileAntiAirTier1 && entity.power >= 50000L) {
			EntityMissileAntiAirTier1 missile = new EntityMissileAntiAirTier1(world);
			missile.posX = (float)x + 0.5f;
			missile.posY = (float)y + 11;
			missile.posZ = (float)z + 0.5f;
			world.spawnEntityInWorld((Entity)missile);
			entity.power -= 5000L;
			entity.slots[0] = null;
			world.playSoundEffect((double)x, (double)y, (double)z, "hbm:weapon.missileTakeOff", 2.0f, 1.0f);
			return ILauncher.StatusReturnCode.LAUNCHED;
		}
		return ILauncher.StatusReturnCode.ERROR_MISSING_COMPONENT;
	}
}

