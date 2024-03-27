/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
 *  net.minecraft.tileentity.TileEntity
 *  org.lwjgl.opengl.GL11
 */
package com.wartec.wartecmod.render.tileentity.vls;

import com.wartec.wartecmod.ResourceManager;
import com.wartec.wartecmod.blocks.vls.VlsVerticalLauncher;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsLaunchTube;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import static org.lwjgl.opengl.GL11.*;

public class RenderTileEntityVlsLaunchTube
		extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tem, double x, double y, double z, float f) {
		if(!(tem.getBlockType() instanceof VlsVerticalLauncher))
			return;
		VlsVerticalLauncher block = (VlsVerticalLauncher) tem.getBlockType();

		final int[] core = block.findCore(Minecraft.getMinecraft().theWorld.provider.worldObj, tem.xCoord, tem.yCoord, tem.zCoord);
		if(core == null)
			return;

		if(!(tem instanceof TileEntityVlsLaunchTube))
			return;

		TileEntityVlsLaunchTube te = (TileEntityVlsLaunchTube) Minecraft.getMinecraft().theWorld.getTileEntity(core[0], core[1], core[2]);

		glPushMatrix();
		glTranslated((x + 0.5), y, (z + 0.5));
		glEnable(GL_LIGHTING);
		glDisable(GL_CULL_FACE);
		this.bindTexture(ResourceManager.launcher_tex);
		ResourceManager.launchTube.renderPart("base");

		glPushMatrix();
		glTranslated(-0.5, 11, 0);
		glRotated(te.openingAnimation, 0, 0, 1);
		glTranslated(0.5, 0, 0);
		this.bindTexture(ResourceManager.launcher_cover_tex);
		ResourceManager.launchTube.renderPart("cover");
		glPopMatrix();

		glDisable(GL_CULL_FACE);
		int state  = te.state;
		glTranslated(0.0, 1.0, 0.0);
		if (state == 1) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 2) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_buster_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 3) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_Cluster_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 4) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_Gas_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 5) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_Emp_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 6) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_FAE_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 7) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_nuclear_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 8) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_H_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 9) {
			glScalef(1.0f, 1.0f, 1.0f);
			glTranslated(0.0, 0.0, 0.0);
			this.bindTexture(ResourceManager.entity_Hypersonic_Cruise_Missile_tex);
			ResourceManager.entity_Hypersonic_Cruise_Missile_Scramjet.renderAll();
			ResourceManager.entity_Hypersonic_Cruise_Missile_Booster.renderAll();
		}
		if (state == 10) {
			glScalef(1.0f, 1.0f, 1.0f);
			glTranslated(0.0, 0.0, 0.0);
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Ramjet_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Ramjet.renderAll();
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Fuselage_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Fuselage.renderAll();
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Engine_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Engine.renderAll();
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Booster_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Booster.renderAll();
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Protection_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Protection.renderAll();
		}
		if (state == 11) {
			glScalef(1.0f, 1.0f, 1.0f);
			glTranslated(0.0, 0.0, 0.0);
			this.bindTexture(ResourceManager.entity_Tomahawk_Missile_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 12) {
			glScalef(1.0f, 1.0f, 1.0f);
			glTranslated(0.0, 0.0, 0.0);
			this.bindTexture(ResourceManager.entity_Kalibr_Missile_tex);
			ResourceManager.entity_Kalibr_Missile_Base.renderAll();
			ResourceManager.entity_Kalibr_Missile_Booster.renderAll();
			ResourceManager.entity_Kalibr_Missile_Fins_Folded.renderAll();
		}
		if (state == 13) {
			glScalef(1.0f, 1.0f, 1.0f);
			glTranslated(0.0, 0.0, 0.0);
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Ramjet_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Ramjet.renderAll();
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Fuselage_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Fuselage.renderAll();
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Engine_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Engine.renderAll();
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Booster_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Booster.renderAll();
			this.bindTexture(ResourceManager.entity_Supersonic_Cruise_Missile_Protection_tex);
			ResourceManager.entity_Supersonic_Cruise_Missile_Protection.renderAll();
		}
		if (state == 14) {
			glScalef(1.0f, 1.0f, 1.0f);
			glTranslated(0.0, 0.0, 0.0);
			this.bindTexture(ResourceManager.entity_Hypersonic_Cruise_Missile_Nuclear_tex);
			ResourceManager.entity_Hypersonic_Cruise_Missile_Scramjet.renderAll();
			ResourceManager.entity_Hypersonic_Cruise_Missile_Booster.renderAll();
		}
		if (state == 15) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Cruise_Missile_nuclear_tex);
			ResourceManager.entity_Cruise_Missile_Base.renderAll();
			ResourceManager.entity_Cruise_Missile_Booster.renderAll();
			ResourceManager.entity_Cruise_Missile_Sealing.renderAll();
		}
		if (state == 16) {
			glScalef(1.0f, 1.0f, 1.0f);
			this.bindTexture(ResourceManager.entity_Missile_Anti_Air_Tier1_tex);
			ResourceManager.entity_Missile_Anti_Air_Tier1.renderAll();
		}
		glEnable(GL_CULL_FACE);

		glPopMatrix();
	}
}

