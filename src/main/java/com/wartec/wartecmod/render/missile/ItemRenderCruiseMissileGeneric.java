package com.wartec.wartecmod.render.missile;

import com.hbm.inventory.RecipesCommon;
import com.hbm.items.ModItems;
import com.hbm.main.ResourceManager;
import com.hbm.render.item.ItemRenderMissileGeneric;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.function.Consumer;

public class ItemRenderCruiseMissileGeneric implements IItemRenderer {

    public static HashMap<RecipesCommon.ComparableStack, Consumer<TextureManager>> renderers = new HashMap();

    protected ItemRenderCruiseMissileGeneric.RenderMissileType type;

    public static enum RenderMissileType {
        TYPE_TIER3
    }

    public ItemRenderCruiseMissileGeneric(ItemRenderCruiseMissileGeneric.RenderMissileType type) {
        this.type = type;
    }

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
        return helper == ItemRendererHelper.ENTITY_BOBBING || helper == ItemRendererHelper.ENTITY_ROTATION;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        Consumer<TextureManager> renderer = renderers.get(new RecipesCommon.ComparableStack(item).makeSingular());
        if(renderer == null) return;

        GL11.glPushMatrix();

        double guiScale = 1;
        double guiOffset = 0;

        switch(this.type) {

            case TYPE_TIER3: guiScale = 1.25D; guiOffset = 1D; break;

        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);

        switch(type) {
            case EQUIPPED:
                double s = 0.15;
                GL11.glTranslated(0.5, -0.25, 0);
                GL11.glScaled(s, s, s);
                break;
            case EQUIPPED_FIRST_PERSON:
                double heldScale = 0.1;
                GL11.glTranslated(0.5, 0.25, 0);
                GL11.glScaled(heldScale, heldScale, heldScale);
                break;
            case ENTITY:
                double s2 = 0.15;
                GL11.glScaled(s2, s2, s2);
                break;
            case INVENTORY:
                RenderHelper.enableGUIStandardItemLighting();
                GL11.glScaled(guiScale, guiScale, guiScale);
                GL11.glRotated(135, 0, 0, 1);
                GL11.glRotatef(System.currentTimeMillis() / 15 % 360, 0, 1, 0);
                GL11.glTranslated(0, -16 + guiOffset, 0);
                break;
            default: break;
        }

        GL11.glDisable(GL11.GL_CULL_FACE);
        renderer.accept(Minecraft.getMinecraft().renderEngine);
        GL11.glEnable(GL11.GL_CULL_FACE);

        GL11.glPopMatrix();
    }

    public static Consumer<TextureManager> generateStandard(ResourceLocation texture, IModelCustom model) { return generateWithScale(texture, model, 1F); }
    public static Consumer<TextureManager> generateLarge(ResourceLocation texture, IModelCustom model) { return generateWithScale(texture, model, 1.5F); }
    public static Consumer<TextureManager> generateDouble(ResourceLocation texture, IModelCustom model) { return generateWithScale(texture, model, 2F); }

    public static Consumer<TextureManager> generateWithScale(ResourceLocation texture, IModelCustom model, float scale) {
        return x -> {
            GL11.glScalef(scale, scale, scale);
            GL11.glShadeModel(GL11.GL_SMOOTH);
            x.bindTexture(texture); model.renderAll();
            GL11.glShadeModel(GL11.GL_FLAT);
        };
    }

    public static void init() {

        renderers.put(new RecipesCommon.ComparableStack(ModItems.missile_test), generateStandard(ResourceManager.missileMicroTest_tex, ResourceManager.missileMicro));
    }
}