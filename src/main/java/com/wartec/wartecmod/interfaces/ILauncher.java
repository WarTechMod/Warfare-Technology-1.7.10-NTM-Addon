package com.wartec.wartecmod.interfaces;

import com.hbm.interfaces.IBomb;
import net.minecraft.world.World;

public interface ILauncher {

    public ILauncher.StatusReturnCode launch(World world, int x, int y, int z);

    public static enum StatusReturnCode {
        UNDEFINED(false, ""),
        FAILED_TO_CLOSE(false, "Target to close!"),
        FAILED_TO_FAR(false, "Target out of Range!"),
        LAUNCHED(true, "bomb.launched"),
        ERROR_MISSING_COMPONENT(false, "bomb.missingComponent"),
        ERROR_INCOMPATIBLE(false, "bomb.incompatible");

        private String unloc;
        private boolean success;

        private StatusReturnCode(boolean success, String unloc) {
            this.unloc = unloc;
            this.success = success;
        }

        public String getUnlocalizedMessage() {
            return this.unloc;
        }

        public boolean wasSuccessful() {
            return this.success;
        }
    }
}