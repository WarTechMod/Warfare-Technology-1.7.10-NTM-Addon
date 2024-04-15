package com.wartec.wartecmod;

import com.hbm.tileentity.turret.TileEntityTurretBaseNT;
import com.hbm.util.CompatExternal;
import com.wartec.wartecmod.entity.missile.EntityCruiseMissileBaseNT;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.List;

public class EntityChecker extends TileEntityTurretBaseNT {

    TileEntityTurretBaseNT Obj = new TileEntityTurretBaseNT() {

        @Override
        public void updateFiringTick() {

        }

        @Override
        protected List<Integer> getAmmoList() {
            return null;
        }

        @Override
        public long getMaxPower() {
            return 0;
        }

        @Override
        public GuiScreen provideGUI(int ID, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }
    };
        @Override
        public boolean entityAcceptableTarget (Entity e){


            if(Obj.targetMachines) {


                if (e instanceof EntityCruiseMissileBaseNT) return true;
                for (Class c : CompatExternal.turretTargetMachine) if (c.isAssignableFrom(e.getClass())) return true;
            }

            return super.entityAcceptableTarget(e);

        }

        @Override
        public void updateFiringTick () {

        }

        @Override
        protected List<Integer> getAmmoList () {
            return null;
        }

        @Override
        public long getMaxPower () {
            return 0;
        }

        @Override
        public GuiScreen provideGUI ( int ID, EntityPlayer player, World world,int x, int y, int z){
            return null;
        }

        @Override
        public String getName () {
            return null;
        }
}
