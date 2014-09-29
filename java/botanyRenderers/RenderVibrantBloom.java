package botanyRenderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import botanyMain.Base;
import botanyModels.ModelVibrantBloom;

public class RenderVibrantBloom extends TileEntitySpecialRenderer
{
	private ResourceLocation texture = new ResourceLocation(Base.modid + ":textures/tileentity/vibrantBloom.png");
	
	private final ModelVibrantBloom model;
	
	public RenderVibrantBloom()
	{
		this.model = new ModelVibrantBloom();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		
		this.bindTexture(texture);
		
		GL11.glRotatef(-180F, 1.0F, 0.0F, 1.0F);
		
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
	}
}
