package com.wartec.wartecmod.render.tileentity.vls;

import com.wartec.wartecmod.ResourceManager;
import com.wartec.wartecmod.blocks.vls.VlsExhaust;
import com.wartec.wartecmod.blocks.vls.VlsVerticalLauncher;
import com.wartec.wartecmod.tileentity.vls.TileEntityVlsExhaust;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import static org.lwjgl.opengl.GL11.*;

public class RenderTileEntityVlsExhaust extends TileEntitySpecialRenderer {

    @Override
    public void renderTileEntityAt(TileEntity tem, double x, double y, double z, float f) {
        if(!(tem.getBlockType() instanceof VlsExhaust))
            return;
        VlsExhaust block = (VlsExhaust) tem.getBlockType();

        final int[] core = block.findCore(Minecraft.getMinecraft().theWorld.provider.worldObj, tem.xCoord, tem.yCoord, tem.zCoord);
        if(core == null)
            return;

        if(!(tem instanceof TileEntityVlsExhaust))
            return;

        TileEntityVlsExhaust te = (TileEntityVlsExhaust) Minecraft.getMinecraft().theWorld.getTileEntity(core[0], core[1], core[2]);

        glPushMatrix();
        glTranslated(x + 0.5, y, z + 1);
        glEnable(GL_LIGHTING);
        glDisable(GL_CULL_FACE);
        this.bindTexture(ResourceManager.vls_exhaust_tex);
        ResourceManager.vlsExhaust.renderPart("base");

        glPushMatrix();
        glTranslated(-0.5, 11, 0);
        glRotated(te.openingAnimation, 0, 0, 1);
        glTranslated(0.5, 0, 0);
        this.bindTexture(ResourceManager.launcher_cover_tex);
        ResourceManager.vlsExhaust.renderPart("cover");
        glPopMatrix();

        glPopMatrix();
    }
}

