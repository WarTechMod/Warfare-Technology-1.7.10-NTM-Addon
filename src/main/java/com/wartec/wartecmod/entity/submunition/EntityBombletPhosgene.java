package com.wartec.wartecmod.entity.submunition;

import com.hbm.entity.effect.EntityMist;
import com.hbm.handler.pollution.PollutionHandler;
import com.hbm.inventory.fluid.Fluids;
import net.minecraft.world.World;

public class EntityBombletPhosgene extends EntityBombletBase {


    public EntityBombletPhosgene(World p_i1773_1_)
    {
        super(p_i1773_1_);
    }

    @Override
    public void explode() {

        if (!worldObj.isRemote) {
            EntityMist mist = new EntityMist(worldObj);
            mist.setType(Fluids.PHOSGENE);
            mist.setPosition(posX, posY, posZ);
            mist.setArea(10, 10);
            mist.setDuration(160);
            worldObj.spawnEntityInWorld(mist);
        }
        PollutionHandler.incrementPollution(worldObj, (int) posX, (int) posY, (int) posZ, PollutionHandler.PollutionType.HEAVYMETAL, 10F);
        PollutionHandler.incrementPollution(worldObj, (int) posX, (int) posY, (int) posZ, PollutionHandler.PollutionType.POISON, 15F);
    }
}