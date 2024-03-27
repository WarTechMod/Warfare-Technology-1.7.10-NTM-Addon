package com.wartec.wartecmod.render.missile;

import org.lwjgl.opengl.GL11;

import com.wartec.wartecmod.ResourceManager;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLrhwMissile extends Render {

	public RenderLrhwMissile() { }

	@Override
	public void doRender(Entity missile, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {

		GL11.glPushMatrix();
        GL11.glTranslatef((float) p_76986_2_, (float) p_76986_4_, (float) p_76986_6_);
        GL11.glRotatef(missile.prevRotationYaw + (missile.rotationYaw - missile.prevRotationYaw) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(missile.prevRotationPitch + (missile.rotationPitch - missile.prevRotationPitch) * p_76986_9_, 0.0F, 0.0F, 1.0F);
        
        
        bindTexture(ResourceManager.entity_Lrhw_Missile_tex);
        
        ResourceManager.entity_Lrhw_Missile_Glider.renderAll();
        
        if(missile.getDataWatcher().getWatchableObjectInt(10) == 1) {
        	ResourceManager.entity_Lrhw_Missile_Booster.renderAll();
        	ResourceManager.entity_Lrhw_Missile_Cone.renderAll();
        }
        
        GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return ResourceManager.entity_Lrhw_Missile_tex;
	}

}