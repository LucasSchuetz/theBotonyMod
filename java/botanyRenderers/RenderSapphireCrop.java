package botanyRenderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import botanyMain.Base;
import botanyModels.ModelSapphireCrop;
import botanyTileEntity.TileEntitySapphireCrop;

public class RenderSapphireCrop extends TileEntitySpecialRenderer
{
	private ResourceLocation texture = new ResourceLocation(Base.modid + ":" + "textures/tileentity/sapphireCrop/sapphireCrop_0.png");
	
	private ModelSapphireCrop model;
	int bAmt;
	
	public RenderSapphireCrop()
	{
		this.model = new ModelSapphireCrop();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		
		TileEntity te = tileEntity;
		int meta = 0;
		
		if(te != null)
		{
			if(te instanceof TileEntitySapphireCrop)
				te = (TileEntitySapphireCrop)te;
			bAmt = ((TileEntitySapphireCrop) te).getBerryAmount();
			meta = tileEntity.getBlockMetadata();
		}
		
		ResourceLocation textures;
		
		//Handles the texture
		switch(bAmt)
		{
		case 0:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_0.png"));
			break;
		case 1:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_1.png"));
			break;
		case 2:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_2.png"));
			break;
		case 3:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_3.png"));
			break;
		case 4:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_4.png"));
			break;
		case 5:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_5.png"));
			break;
		case 6:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_6.png"));
			break;
		case 7:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_7.png"));
			break;
		default:
			textures = (new ResourceLocation(Base.modid + ":textures/tileentity/sapphireCrop/sapphireCrop_0.png"));
			break;
		}
		
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		
		GL11.glPushMatrix();
		
		if(meta % 4 == 0) GL11.glRotatef(-180F, 1.0F, 0.0F, 1.0F);
		if(meta % 4 == 1) GL11.glRotatef(-180F, -1.0F, 0.0F, 1.0F);
		if(meta % 4 == 2) GL11.glRotatef(-180F, 0.0F, 0.0F, 1.0F);
		if(meta % 4 == 3) GL11.glRotatef(-180F, 90F, 0.0F, 1.0F);
		
		this.model.renderModel(0.0625F);
		
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

			//Rendering
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
