package com.wartec.wartecmod.render.tileentity;

import com.wartec.wartecmod.ResourceManager;
import org.lwjgl.opengl.GL11;

import com.wartec.wartecmod.tileentity.launcher.TileEntityBallisticMissileLauncher;


import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderTileEntityBallisticMissileLauncher extends TileEntitySpecialRenderer {

    @Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y, z + 0.5D);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
        bindTexture(com.wartec.wartecmod.ResourceManager.BallisticMissileLauncher_tex);
        com.wartec.wartecmod.ResourceManager.BallisticMissileLauncher.renderAll();

        GL11.glDisable(GL11.GL_CULL_FACE);
        int state = 0;
        
        if(tileEntity instanceof TileEntityBallisticMissileLauncher)
        	state = ((TileEntityBallisticMissileLauncher)tileEntity).state;
        
	        GL11.glTranslated(0, 1, 0);
	        
			if(state == 1)
			{
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Slbm_Missile_tex);
				com.wartec.wartecmod.ResourceManager.entity_Slbm_Missile.renderAll();
			}
			
			if(state == 2)
			{
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Iskander_Missile_tex);
				com.wartec.wartecmod.ResourceManager.entity_Iskander_Missile.renderAll();
			}
			if(state == 3)
			{
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Lrhw_Missile_tex);
				com.wartec.wartecmod.ResourceManager.entity_Lrhw_Missile_Cone.renderAll();
				com.wartec.wartecmod.ResourceManager.entity_Lrhw_Missile_Booster.renderAll();
				GL11.glTranslated(0.0D, 8.47D, 0.0D);
				com.wartec.wartecmod.ResourceManager.entity_Lrhw_Missile_Glider.renderAll();
			}
			if(state == 4)
			{
				GL11.glScalef(2.0F, 2.0F, 2.0F);
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Missile_Micro_Gas_tex);
				com.wartec.wartecmod.ResourceManager.entity_Missile_Micro.renderAll();
			}
			if(state == 5)
			{
				GL11.glScalef(2.0F, 2.0F, 2.0F);
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Missile_Micro_H_tex);
				com.wartec.wartecmod.ResourceManager.entity_Missile_Micro.renderAll();
			}
			if(state == 6)
			{
				GL11.glScalef(2.0F, 2.0F, 2.0F);
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Missile_Micro_Neutron_tex);
				com.wartec.wartecmod.ResourceManager.entity_Missile_Micro.renderAll();
			}
			if(state == 7)
			{
				GL11.glScalef(2.0F, 2.0F, 2.0F);
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_ASAT_Missile_Warhead_tex);
				com.wartec.wartecmod.ResourceManager.entity_ASAT_Missile_Warhead.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_ASAT_Missile_Fuselage_tex);
				com.wartec.wartecmod.ResourceManager.entity_ASAT_Missile_Fuselage.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_ASAT_Missile_Thruster_tex);
				ResourceManager.entity_ASAT_Missile_Thruster.renderAll();
			}
			
	        GL11.glEnable(GL11.GL_CULL_FACE);

        GL11.glPopMatrix();
    }

}