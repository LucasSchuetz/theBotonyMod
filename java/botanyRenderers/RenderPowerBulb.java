package botanyRenderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import botanyMain.Base;
import botanyModels.ModelPowerBulb;

public class RenderPowerBulb extends TileEntitySpecialRenderer
{
	private final ModelPowerBulb model;
	
	public RenderPowerBulb()
	{
		this.model = new ModelPowerBulb();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
		
		ResourceLocation textures = (new ResourceLocation(Base.modid + ":textures/tileentity/powerBulb.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		
		GL11.glRotatef(-180F, 1.0F, 0.0F, 1.0F);
		
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
