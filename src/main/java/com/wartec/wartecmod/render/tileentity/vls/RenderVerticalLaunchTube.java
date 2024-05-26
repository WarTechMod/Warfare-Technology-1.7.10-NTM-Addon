package com.wartec.wartecmod.render.tileentity.vls;

import com.hbm.blocks.BlockDummyable;
import com.hbm.inventory.RecipesCommon;
import com.hbm.render.item.ItemRenderMissileGeneric;
import com.hbm.tileentity.bomb.TileEntityLaunchPad;
import com.wartec.wartecmod.ResourceManager;
import com.wartec.wartecmod.blocks.vls.VerticalLaunchTube;
import com.wartec.wartecmod.blocks.vls.VlsVerticalLauncher;
import com.wartec.wartecmod.tileentity.vls.TileEntityVerticalLaunchTube;
import com.wartec.wartecmod.tileentity.vls.TileEntityVerticalLaunchTubeBase;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsLaunchTube;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

import java.util.function.Consumer;

import static org.lwjgl.opengl.GL11.*;

public class RenderVerticalLaunchTube extends TileEntitySpecialRenderer {

    @Override
    public void renderTileEntityAt(TileEntity tem, double x, double y, double z, float f) {
        if(!(tem.getBlockType() instanceof VerticalLaunchTube))
            return;
        VerticalLaunchTube block = (VerticalLaunchTube) tem.getBlockType();

        final int[] core = block.findCore(Minecraft.getMinecraft().theWorld.provider.worldObj, tem.xCoord, tem.yCoord, tem.zCoord);
        if(core == null)
            return;

        if(!(tem instanceof TileEntityVerticalLaunchTube))
            return;

        TileEntityVerticalLaunchTube te = (TileEntityVerticalLaunchTube) Minecraft.getMinecraft().theWorld.getTileEntity(core[0], core[1], core[2]);

        glPushMatrix();
        glTranslated((x + 0.5), y, (z + 0.5));
        glEnable(GL_LIGHTING);
        glDisable(GL_CULL_FACE);
        this.bindTexture(com.wartec.wartecmod.ResourceManager.launcher_tex);
        com.wartec.wartecmod.ResourceManager.launchTube.renderPart("base");

        glPushMatrix();
        glTranslated(-0.5, 11, 0);
        //glRotated(te.openingAnimation, 0, 0, 1);
        glTranslated(0.5, 0, 0);
        this.bindTexture(com.wartec.wartecmod.ResourceManager.launcher_cover_tex);
        ResourceManager.launchTube.renderPart("cover");
        glPopMatrix();
    }

}