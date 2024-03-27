package com.wartec.wartecmod.render.tileentity;

import org.lwjgl.opengl.GL11;

import com.hbm.blocks.ModBlocks;
import com.wartec.wartecmod.ResourceManager;
import com.wartec.wartecmod.wartecmod;
import com.wartec.wartecmod.blocks.wartecmodBlocks;
import com.wartec.wartecmod.lib.RefStrings;
import com.wartec.wartecmod.tileentity.deco.TileEntityDecoBlock;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderTileEntityDecoBlock extends TileEntitySpecialRenderer {
	
	
	public boolean isGlobalRenderer(TileEntityDecoBlock te) {
		    return true;
		 }
	
@Override
public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
            TileEntityDecoBlock te2 = (TileEntityDecoBlock) te;
            GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			
			GL11.glEnable(GL11.GL_LIGHTING);
			

			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockCruiseMissile) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Cruise_Missile_tex);
	        	ResourceManager.block_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
            
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockCruiseMissileCluster) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Cruise_Missile_Cluster_tex);
	        	ResourceManager.block_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockCruiseMissileBuster) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Cruise_Missile_buster_tex);
	        	ResourceManager.block_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockCruiseMissileEmp) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Cruise_Missile_Emp_tex);
	        	ResourceManager.block_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockCruiseMissileFAE) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Cruise_Missile_FAE_tex);
	        	ResourceManager.block_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockCruiseMissileNuclear) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Cruise_Missile_nuclear_tex);
	        	ResourceManager.block_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockCruiseMissileH) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Cruise_Missile_H_tex);
	        	ResourceManager.block_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockSupersonicCruiseMissile) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Ramjet_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Ramjet.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Fuselage_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Fuselage.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Engine_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Engine.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Booster_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Booster.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Protection_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Protection.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockSupersonicCruiseMissileH) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Ramjet_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Ramjet.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Fuselage_H_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Fuselage.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Engine_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Engine.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Booster_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Booster.renderAll();
				bindTexture(com.wartec.wartecmod.ResourceManager.entity_Supersonic_Cruise_Missile_Protection_tex);
				com.wartec.wartecmod.ResourceManager.block_Supersonic_Cruise_Missile_Protection.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockHypersonicCruiseMissile) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Hypersonic_Cruise_Missile_tex);
	        	ResourceManager.block_Hypersonic_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
			if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockHypersonicCruiseMissileNuclear) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	            bindTexture(ResourceManager.entity_Hypersonic_Cruise_Missile_Nuclear_tex);
	        	ResourceManager.block_Hypersonic_Cruise_Missile.renderAll();
	        	GL11.glPopMatrix();
			}
            
            if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockFlagUS) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	        	bindTexture(ResourceManager.block_Flag_tex_US);
	        	ResourceManager.block_Flag.renderAll();
	        	GL11.glPopMatrix();
			}
            if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockFlagSU) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	        	bindTexture(ResourceManager.block_Flag_tex_SU);
	        	ResourceManager.block_Flag.renderAll();
	        	GL11.glPopMatrix();
			}
            if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockFlagEU) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	        	bindTexture(ResourceManager.block_Flag_tex_EU);
	        	ResourceManager.block_Flag.renderAll();
	        	GL11.glPopMatrix();
			}
            if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockFlagAL) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	        	bindTexture(ResourceManager.block_Flag_tex_AL);
	        	ResourceManager.block_Flag.renderAll();
	        	GL11.glPopMatrix();
			}
            if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockFlagCH) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	        	bindTexture(ResourceManager.block_Flag_tex_CH);
	        	ResourceManager.block_Flag.renderAll();
	        	GL11.glPopMatrix();
			
              }
            if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockFlagIsr) {

            	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.0F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}

	            GL11.glEnable(GL11.GL_CULL_FACE);
	        	bindTexture(ResourceManager.block_Flag_tex_Isr);
	        	ResourceManager.block_Flag.renderAll();
	        	GL11.glPopMatrix();
            }
	        	
	        if(te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord) == wartecmodBlocks.decoBlockSatelliteNuclear) {
	        	GL11.glRotatef(180, 0F, 0F, 1F);
				GL11.glTranslatef(0, -1.5F, 0);
				
				switch(te.getBlockMetadata()) {
				case 4: GL11.glRotatef(0, 0F, 1F, 0F); break;
				case 2: GL11.glRotatef(270, 0F, 1F, 0F); break;
				case 5: GL11.glRotatef(180, 0F, 1F, 0F); break;
				case 3: GL11.glRotatef(90, 0F, 1F, 0F); break;
				default:
					GL11.glRotatef(180, 0F, 0F, 1F);
					GL11.glRotated(90, 1, 0, 0);
					GL11.glTranslatef(0, -1.5F, 0);
					break;
				}
				
		        GL11.glEnable(GL11.GL_CULL_FACE);
		        bindTexture(ResourceManager.sat_nuclear_base_tex);
		        ResourceManager.block_Satellite_Nuclear_Base.renderAll();
		        bindTexture(ResourceManager.sat_nuclear_com_tex);
		        ResourceManager.block_Satellite_Nuclear_Com.renderAll();
		        bindTexture(ResourceManager.sat_nuclear_launcher_tex);
		        ResourceManager.block_Satellite_Nuclear_Launcher.renderAll();
		        bindTexture(ResourceManager.entity_Sat_Nuclear_Missile_tex);
		        ResourceManager.block_Satellite_Nuclear_Missiles.renderAll();
		        GL11.glPopMatrix();
	        }
}}

    



