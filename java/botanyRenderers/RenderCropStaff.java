package botanyRenderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import botanyMain.Base;
import botanyModels.ModelPowerStaff;
import botanyTileEntity.TileEntityCropStaff;

public class RenderCropStaff extends TileEntitySpecialRenderer
{
	private ResourceLocation texture = new ResourceLocation(Base.modid + ":" + "textures/tileentity/powerStaff.png");
	
	private ModelPowerStaff stick;
	
	public RenderCropStaff()
	{
		this.stick = new ModelPowerStaff();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		
		TileEntityCropStaff tile = (TileEntityCropStaff)tileEntity;
		
		//All movement, rendering handled here
		renderBlock(tile, tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord, Base.blockPowerStaff, scale);
		
		GL11.glPopMatrix();
	}
	
	public void renderBlock(TileEntityCropStaff tileEntity, World world, int i, int j, int k, Block block, float scale)
	{	
		if(tileEntity != null)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0.5F, 1.5F, 0.5F);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);

			//Render stick
			GL11.glPushMatrix();
			this.bindTexture(texture);
			this.stick.renderModel(0.0625F);
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			
			GL11.glPopMatrix();
		}
	}
}
