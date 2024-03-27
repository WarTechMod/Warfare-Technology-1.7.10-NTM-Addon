package com.wartec.wartecmod.render.missile;

import com.wartec.wartecmod.ResourceManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMissileASAT extends Render {

	public RenderMissileASAT() { }

	@Override
	public void doRender(Entity missile, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {

		GL11.glPushMatrix();
		GL11.glTranslatef((float) p_76986_2_, (float) p_76986_4_, (float) p_76986_6_);
		GL11.glRotatef(missile.prevRotationYaw + (missile.rotationYaw - missile.prevRotationYaw) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(missile.prevRotationPitch + (missile.rotationPitch - missile.prevRotationPitch) * p_76986_9_, 0.0F, 0.0F, 1.0F);
		
		GL11.glScalef(2.0F, 2.0F, 2.0F);

		bindTexture(ResourceManager.entity_ASAT_Missile_Warhead_tex);
		ResourceManager.entity_ASAT_Missile_Warhead.renderAll();
		bindTexture(ResourceManager.entity_ASAT_Missile_Fuselage_tex);
		ResourceManager.entity_ASAT_Missile_Fuselage.renderAll();
		bindTexture(ResourceManager.entity_ASAT_Missile_Thruster_tex);
		ResourceManager.entity_ASAT_Missile_Thruster.renderAll();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return ResourceManager.entity_ASAT_Missile_Fuselage_tex;
	}

}
