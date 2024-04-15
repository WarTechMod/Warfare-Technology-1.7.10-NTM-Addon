package com.wartec.wartecmod.render.missile;

import org.lwjgl.opengl.GL11;

import com.wartec.wartecmod.ResourceManager;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCruiseMissileCluster extends Render {
	
	public RenderCruiseMissileCluster() { }

	@Override
	public void doRender(Entity missile, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {

		GL11.glPushMatrix();
		GL11.glScaled(1.0D, 1.0D, 1.0D);
        GL11.glTranslatef((float) p_76986_2_, (float) p_76986_4_, (float) p_76986_6_);
        GL11.glRotatef(missile.prevRotationYaw + (missile.rotationYaw - missile.prevRotationYaw) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(missile.prevRotationPitch + (missile.rotationPitch - missile.prevRotationPitch) * p_76986_9_, 0.0F, 0.0F, 1.0F);
        
        
        bindTexture(ResourceManager.entity_Cruise_Missile_Cluster_tex);
        ResourceManager.entity_Cruise_Missile_Base.renderAll();
        
        if(missile.getDataWatcher().getWatchableObjectInt(9) == 1) {
        	ResourceManager.entity_Cruise_Missile_Booster.renderAll();
        	ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
        }
        if(missile.getDataWatcher().getWatchableObjectInt(9) == 2) {
        	ResourceManager.entity_Cruise_Missile_Turbofan.renderAll();
        	ResourceManager.entity_Cruise_Missile_Wings.renderAll();
        	ResourceManager.entity_Cruise_Missile_Fins.renderAll();
        }
		if(missile.getDataWatcher().getWatchableObjectInt(9) == 3) {
			ResourceManager.entity_Cruise_Missile_Fins.renderAll();
		}
        GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return ResourceManager.entity_Cruise_Missile_Cluster_tex;
	}

}
