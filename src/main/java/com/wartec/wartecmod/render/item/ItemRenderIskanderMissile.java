package com.wartec.wartecmod.render.item;

import org.lwjgl.opengl.GL11;

import com.wartec.wartecmod.ResourceManager;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class ItemRenderIskanderMissile implements IItemRenderer {
	
public ItemRenderIskanderMissile() {}
	
	
	@Override	
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
			switch(type) {
			case EQUIPPED:
			case EQUIPPED_FIRST_PERSON:
			case ENTITY:
			case INVENTORY:
				return true;
			default: return false;
			}
	}
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		
		return type == ItemRenderType.ENTITY && (helper == ItemRendererHelper.ENTITY_ROTATION || helper == ItemRendererHelper.ENTITY_BOBBING);
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
        GL11.glPushMatrix();
		
		GL11.glEnable(GL11.GL_CULL_FACE);
	
		switch(type) {
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
			
			double s = 0.2;
			GL11.glScaled(s, s, s);
			
			GL11.glTranslated(2, 0, 0);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(ResourceManager.entity_Iskander_Missile_tex);
			ResourceManager.entity_Iskander_Missile.renderAll();
			
			
			break;
			
		case ENTITY:
			double s1 = 0.2;
			GL11.glScaled(s1, s1, s1);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(ResourceManager.entity_Iskander_Missile_tex);
			ResourceManager.entity_Iskander_Missile.renderAll();
			
			break;
			
		case INVENTORY:
			
			GL11.glTranslated( 8/ 1, 0, 0);

			GL11.glRotated(135, 0, 0, 1);
			GL11.glRotated(215, 1, 0, 0);
			
			GL11.glTranslated(5.5, 16.5, 0);
			
			GL11.glScaled(-2, -2, -2);

			GL11.glRotatef(System.currentTimeMillis() / 25 % 360, 0, -1, 0);
			Minecraft.getMinecraft().renderEngine.bindTexture(ResourceManager.entity_Iskander_Missile_tex);
			ResourceManager.entity_Iskander_Missile.renderAll();
			
			
		default: break;
		}
		
        ResourceManager.entity_Iskander_Missile.renderAll();
		
		GL11.glPopMatrix();
	}

}