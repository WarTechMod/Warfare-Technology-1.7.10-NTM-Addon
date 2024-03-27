package com.wartec.wartecmod.items;

import net.minecraft.entity.Entity;

public interface IMissileSpawningItem {

    Class<? extends Entity> getMissile();

}
