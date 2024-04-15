package com.wartec.wartecmod.tileentity.vls;

import api.hbm.energymk2.IEnergyReceiverMK2;
import api.hbm.fluid.IFluidStandardReceiver;
import api.hbm.item.IDesignatorItem;
import com.hbm.config.GeneralConfig;
import com.hbm.entity.missile.EntityMissileAntiBallistic;
import com.hbm.interfaces.IBomb;
import com.hbm.inventory.RecipesCommon;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.fluid.tank.FluidTank;
import com.hbm.items.ModItems;
import com.hbm.lib.Library;
import com.hbm.main.MainRegistry;
import com.hbm.tileentity.IGUIProvider;
import com.hbm.tileentity.IRadarCommandReceiver;
import com.hbm.tileentity.TileEntityMachineBase;
import com.hbm.util.TrackerUtil;
import com.hbm.util.fauxpointtwelve.BlockPos;
import com.hbm.util.fauxpointtwelve.DirPos;
import com.wartec.wartecmod.entity.missile.EntityCruiseMissileBaseNT;
import com.wartec.wartecmod.entity.missile.EntityCruiseMissileSubsonic;
import com.wartec.wartecmod.inventory.container.ContainerVerticalLaunchTube;
import com.wartec.wartecmod.inventory.gui.GUIVerticalLaunchTube;
import com.wartec.wartecmod.items.ItemCruiseMissile;
import com.wartec.wartecmod.items.wartecmodItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.apache.logging.log4j.Level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class TileEntityVerticalLaunchTubeBase extends TileEntityMachineBase implements IEnergyReceiverMK2, IFluidStandardReceiver, IGUIProvider, IRadarCommandReceiver {

    /** Automatic instantiation of generic missiles, i.e. everything that both extends EntityMissileBaseNT and needs a designator */
    public static final HashMap<RecipesCommon.ComparableStack, Class<? extends EntityCruiseMissileBaseNT>> missiles = new HashMap();

    public static void registerLaunchables() {

        //Tier 0
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileCluster), EntityCruiseMissileSubsonic.EntityCruiseMissileCluster.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileDecoy), EntityCruiseMissileSubsonic.EntityCruiseMissileDecoy.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileBuster), EntityCruiseMissileSubsonic.EntityCruiseMissileBuster.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileHe), EntityCruiseMissileSubsonic.EntityCruiseMissileHE.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileWP), EntityCruiseMissileSubsonic.EntityCruiseMissileWP.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileTB), EntityCruiseMissileSubsonic.EntityCruiseMissileTB.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileMiniNuke), EntityCruiseMissileSubsonic.EntityCruiseMissileMiniNuke.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileFragmentation), EntityCruiseMissileSubsonic.EntityCruiseMissileFragmentation.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileEmp), EntityCruiseMissileSubsonic.EntityCruiseMissileEmp.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileNuclear), EntityCruiseMissileSubsonic.EntityCruiseMissileNuclear.class);
        missiles.put(new RecipesCommon.ComparableStack(wartecmodItems.itemCruiseMissileH), EntityCruiseMissileSubsonic.EntityCruiseMissileH.class);

    }

    public ItemStack toRender;

    public long power;
    public final long maxPower = 100_000;

    public int prevRedstonePower;
    public int redstonePower;
    public Set<BlockPos> activatedBlocks = new HashSet<>(4);

    public int state = 0;
    public static final int STATE_MISSING = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_READY = 2;

    public FluidTank[] tanks;

    public TileEntityVerticalLaunchTubeBase() {
        super(7);
        this.tanks = new FluidTank[2];
        this.tanks[0] = new FluidTank(Fluids.NONE, 24_000);
        this.tanks[1] = new FluidTank(Fluids.NONE, 24_000);
    }

    @Override
    public String getName() {
        return "container.launchTube";
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[] { 0 };
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return slot == 0 && this.isMissileValid(stack);
    }

    public abstract DirPos[] getConPos();

    @Override
    public void updateEntity() {

        if(!worldObj.isRemote) {

            if(worldObj.getTotalWorldTime() % 20 == 0) {
                for(DirPos pos : getConPos()) {
                    this.trySubscribe(worldObj, pos.getX(), pos.getY(), pos.getZ(), pos.getDir());
                    if(tanks[0].getTankType() != Fluids.NONE) this.trySubscribe(tanks[0].getTankType(), worldObj, pos.getX(), pos.getY(), pos.getZ(), pos.getDir());
                    if(tanks[1].getTankType() != Fluids.NONE) this.trySubscribe(tanks[1].getTankType(), worldObj, pos.getX(), pos.getY(), pos.getZ(), pos.getDir());
                }
            }

            if(this.redstonePower > 0 && this.prevRedstonePower <= 0) {
                this.launchFromDesignator();
            }

            this.prevRedstonePower = this.redstonePower;

            this.power = Library.chargeTEFromItems(slots, 2, power, maxPower);
            tanks[0].loadTank(3, 4, slots);
            tanks[1].loadTank(5, 6, slots);

            if(this.isMissileValid()) {
                if(slots[0].getItem() instanceof ItemCruiseMissile) {
                    ItemCruiseMissile missile = (ItemCruiseMissile) slots[0].getItem();
                    setFuel(missile);
                }
            }

            this.networkPackNT(250);
        }
    }

    @Override
    public void serialize(ByteBuf buf) {
        super.serialize(buf);

        buf.writeLong(this.power);
        buf.writeInt(this.state);
        tanks[0].serialize(buf);
        tanks[1].serialize(buf);

        if(slots[0] != null) {
            buf.writeBoolean(true);
            buf.writeInt(Item.getIdFromItem(slots[0].getItem()));
            buf.writeShort((short) slots[0].getItemDamage());
        } else {
            buf.writeBoolean(false);
        }
    }

    @Override
    public void deserialize(ByteBuf buf) {
        super.deserialize(buf);

        this.power = buf.readLong();
        this.state = buf.readInt();
        tanks[0].deserialize(buf);
        tanks[1].deserialize(buf);

        if(buf.readBoolean()) {
            this.toRender = new ItemStack(Item.getItemById(buf.readInt()), 1, buf.readShort());
        } else {
            this.toRender = null;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        power = nbt.getLong("power");
        tanks[0].readFromNBT(nbt, "t0");
        tanks[1].readFromNBT(nbt, "t1");

        this.redstonePower = nbt.getInteger("redstonePower");
        this.prevRedstonePower = nbt.getInteger("prevRedstonePower");
        NBTTagCompound activatedBlocks = nbt.getCompoundTag("activatedBlocks");
        this.activatedBlocks.clear();
        for(int i = 0; i < activatedBlocks.func_150296_c().size() / 3; i++) {
            this.activatedBlocks.add(new BlockPos(activatedBlocks.getInteger("x" + i), activatedBlocks.getInteger("y" + i), activatedBlocks.getInteger("z" + i)));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setLong("power", power);
        tanks[0].writeToNBT(nbt, "t0");
        tanks[1].writeToNBT(nbt, "t1");

        nbt.setInteger("redstonePower", redstonePower);
        nbt.setInteger("prevRedstonePower", prevRedstonePower);
        NBTTagCompound activatedBlocks = new NBTTagCompound();
        int i = 0;
        for(BlockPos p : this.activatedBlocks) {
            activatedBlocks.setInteger("x" + i, p.getX());
            activatedBlocks.setInteger("y" + i, p.getY());
            activatedBlocks.setInteger("z" + i, p.getZ());
            i++;
        }
        nbt.setTag("activatedBlocks", activatedBlocks);
    }

    public void updateRedstonePower(int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        boolean powered = worldObj.isBlockIndirectlyGettingPowered(x, y, z);
        boolean contained = activatedBlocks.contains(pos);
        if(!contained && powered){
            activatedBlocks.add(pos);
            if(redstonePower == -1){
                redstonePower = 0;
            }
            redstonePower++;
        } else if(contained && !powered){
            activatedBlocks.remove(pos);
            redstonePower--;
            if(redstonePower == 0){
                redstonePower = -1;
            }
        }
    }

    @Override public long getPower() { return power; }
    @Override public void setPower(long power) { this.power = power; }
    @Override public long getMaxPower() { return maxPower; }
    @Override public FluidTank[] getAllTanks() { return this.tanks; }
    @Override public FluidTank[] getReceivingTanks() { return this.tanks; }

    @Override public boolean canConnect(ForgeDirection dir) {
        return dir != ForgeDirection.UP && dir != ForgeDirection.DOWN;
    }

    @Override
    public Container provideContainer(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new ContainerVerticalLaunchTube(player.inventory, this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public GuiScreen provideGUI(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new GUIVerticalLaunchTube(player.inventory, this);
    }

    @SuppressWarnings("incomplete-switch") //shut up
    public void setFuel(ItemCruiseMissile missile) {
        switch(missile.fuel) {
            case CRUISE_MISSILE:
                tanks[0].setTankType(Fluids.KEROSENE_REFORM);
                tanks[1].setTankType(Fluids.NONE);
                break;
        }
    }

    /** Requires the missile slot to be non-null and he item to be compatible */
    public boolean isMissileValid() {
        return slots[0] != null && isMissileValid(slots[0]);
    }

    public boolean isMissileValid(ItemStack stack) {
        return stack.getItem() instanceof ItemCruiseMissile && ((ItemCruiseMissile) stack.getItem()).launchable;
    }

    public boolean hasFuel() {
        if(this.power < 75_000) return false;

        if(slots[0] != null && slots[0].getItem() instanceof ItemCruiseMissile) {
            ItemCruiseMissile missile = (ItemCruiseMissile) slots[0].getItem();
            if(this.tanks[0].getFill() < missile.fuelCap) return false;
            if(this.tanks[1].getFill() < missile.fuelCap) return false;

            return true;
        }

        return false;
    }

    public Entity instantiateMissile(int targetX, int targetZ) {

        if(slots[0] == null) return null;

        Class<? extends EntityCruiseMissileBaseNT> clazz = TileEntityVerticalLaunchTubeBase.missiles.get(new RecipesCommon.ComparableStack(slots[0]).makeSingular());

        if(clazz != null) {
            try {
                EntityCruiseMissileBaseNT missile = clazz.getConstructor(World.class, float.class, float.class, float.class, int.class, int.class).newInstance(worldObj, xCoord + 0.5F, yCoord + (float) getLaunchOffset() /* Position arguments need to be floats, jackass */, zCoord + 0.5F, targetX, targetZ);
                if(GeneralConfig.enableExtendedLogging) MainRegistry.logger.log(Level.INFO, "[MISSILE] Tried to launch missile at " + xCoord + " / " + yCoord + " / " + zCoord + " to " + xCoord + " / " + zCoord + "!");
                missile.getDataWatcher().updateObject(3, (byte) MathHelper.clamp_int(this.getBlockMetadata() - 10, 2, 5));
                return missile;
            } catch(Exception e) { }
        }

        if(slots[0].getItem() == ModItems.missile_anti_ballistic) {
            EntityMissileAntiBallistic missile = new EntityMissileAntiBallistic(worldObj);
            missile.posX = xCoord + 0.5D;
            missile.posY = yCoord + getLaunchOffset();
            missile.posZ = zCoord + 0.5D;
            return missile;
        }

        return null;
    }

    public void finalizeLaunch(Entity missile) {
        worldObj.spawnEntityInWorld(missile);
        TrackerUtil.setTrackingRange(worldObj, missile, 500);
        worldObj.playSoundEffect(xCoord + 0.5, yCoord, zCoord + 0.5, "hbm:weapon.missileTakeOff", 2.0F, 1.0F);

        this.power -= 75_000;

        if(slots[0] != null && slots[0].getItem() instanceof ItemCruiseMissile) {
            ItemCruiseMissile item = (ItemCruiseMissile) slots[0].getItem();
            tanks[0].setFill(tanks[0].getFill() - item.fuelCap);
            tanks[1].setFill(tanks[1].getFill() - item.fuelCap);
        }

        this.decrStackSize(0, 1);
    }

    public IBomb.BombReturnCode launchFromDesignator() {
        if(!canLaunch()) return IBomb.BombReturnCode.ERROR_MISSING_COMPONENT;

        boolean needsDesignator = needsDesignator(slots[0].getItem());

        int targetX = 0;
        int targetZ = 0;

        if(slots[1] != null && slots[1].getItem() instanceof IDesignatorItem) {
            IDesignatorItem designator = (IDesignatorItem) slots[1].getItem();

            if(!designator.isReady(worldObj, slots[1], xCoord, yCoord, zCoord) && needsDesignator) return IBomb.BombReturnCode.ERROR_MISSING_COMPONENT;

            Vec3 coords = designator.getCoords(worldObj, slots[1], xCoord, yCoord, zCoord);
            targetX = (int) Math.floor(coords.xCoord);
            targetZ = (int) Math.floor(coords.zCoord);

        } else {
            if(needsDesignator) return IBomb.BombReturnCode.ERROR_MISSING_COMPONENT;
        }

        return this.launchToCoordinate(targetX, targetZ);
    }

    public IBomb.BombReturnCode launchToEntity(Entity entity) {
        if(!canLaunch()) return IBomb.BombReturnCode.ERROR_MISSING_COMPONENT;

        Entity e = instantiateMissile((int) Math.floor(entity.posX), (int) Math.floor(entity.posZ));
        if(e != null) {

            if(e instanceof EntityMissileAntiBallistic) {
                EntityMissileAntiBallistic abm = (EntityMissileAntiBallistic) e;
                abm.tracking = entity;
            }

            finalizeLaunch(e);
            return IBomb.BombReturnCode.LAUNCHED;
        }
        return IBomb.BombReturnCode.ERROR_MISSING_COMPONENT;
    }

    public IBomb.BombReturnCode launchToCoordinate(int targetX, int targetZ) {
        if(!canLaunch()) return IBomb.BombReturnCode.ERROR_MISSING_COMPONENT;

        Entity e = instantiateMissile(targetX, targetZ);
        if(e != null) {
            finalizeLaunch(e);
            return IBomb.BombReturnCode.LAUNCHED;
        }
        return IBomb.BombReturnCode.ERROR_MISSING_COMPONENT;
    }

    @Override
    public boolean sendCommandPosition(int x, int y, int z) {
        return this.launchToCoordinate(x, z) == IBomb.BombReturnCode.LAUNCHED;
    }

    @Override
    public boolean sendCommandEntity(Entity target) {
        return this.launchToEntity(target) == IBomb.BombReturnCode.LAUNCHED;
    }

    public boolean needsDesignator(Item item) {
        return item != ModItems.missile_anti_ballistic;
    }

    /** Full launch condition, checks if the item is launchable, fuel and power are present and any additional checks based on launch pad type */
    public boolean canLaunch() {
        return this.isMissileValid() && this.hasFuel() && this.isReadyForLaunch();
    }

    public int getFuelState() {
        return getGaugeState(0);
    }

    public int getOxidizerState() {
        return getGaugeState(1);
    }

    public int getGaugeState(int tank) {
        if(slots[0] == null) return 0;

        if(slots[0].getItem() instanceof ItemCruiseMissile) {
            ItemCruiseMissile missile = (ItemCruiseMissile) slots[0].getItem();
            ItemCruiseMissile.MissileFuel fuel = missile.fuel;

            if(fuel == ItemCruiseMissile.MissileFuel.SOLID) return 0;
            return tanks[tank].getFill() >= missile.fuelCap ? 1 : -1;
        }

        return 0;
    }

    /** Any extra conditions for launching in addition to the missile being valid and fueled */
    public abstract boolean isReadyForLaunch();
    public abstract double getLaunchOffset();
}