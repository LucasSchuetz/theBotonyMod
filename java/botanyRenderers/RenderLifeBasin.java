package botanyRenderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import botanyMain.Base;
import botanyModels.ModelLifeBasin;

public class RenderLifeBasin extends TileEntitySpecialRenderer
{
	private final ResourceLocation texture = new ResourceLocation(Base.modid + ":" + "textures/tileentity/lifeBasin.png");
	
	private final ModelLifeBasin model;
	
	public RenderLifeBasin()
	{
		this.model = new ModelLifeBasin();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
//		GL11.glPushMatrix();
//		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		
		this.bindTexture(texture);
		
		int meta = tileEntity.getBlockMetadata();
		GL11.glPushMatrix();
		
		if(meta % 4 == 0) GL11.glRotatef(-180F, 1.0F, 0.0F, 1.0F);
		if(meta % 4 == 1) GL11.glRotatef(-180F, -1.0F, 0.0F, 1.0F);
		if(meta % 4 == 2) GL11.glRotatef(-180F, 0.0F, 0.0F, 1.0F);
		if(meta % 4 == 3) GL11.glRotatef(-180F, 90F, 0.0F, 1.0F);
		
		this.model.renderModel(0.0625F);
		
//		GL11.glPopMatrix();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	public void tileEntityInHandRenderer(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		
		if(tileEntity != null)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0.5F, 1.5F, 0.5F);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);

			//Renderer
			GL11.glPushMatrix();
			this.bindTexture(texture);
			this.model.renderModel(0.0625F);
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			
			GL11.glPopMatrix();
		}
		
		GL11.glPopMatrix();
	}
}
