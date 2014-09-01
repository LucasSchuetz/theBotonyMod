package botanyRenderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import botanyMain.Base;
import botanyModels.ModelPowerBulb;
import botanyModels.ModelPowerStaff;

public class RenderPowerStaff extends TileEntitySpecialRenderer
{
	private static final ResourceLocation stickTexture = new ResourceLocation(Base.modid + ":" + "textures/tileentity/powerStaff.png");
	private static final ResourceLocation bulbTexture = new ResourceLocation(Base.modid + ":" + "textures/tileentity/powerBulb.png");

	private ModelPowerStaff stick;
	private ModelPowerBulb bulb;
	
	private float yRotateAngle = 0.10F;
	private float xOffset = -0.25F;
	private float speed = 1.0F;
	private boolean goUp = false;
	
	public RenderPowerStaff()
	{
		this.stick = new ModelPowerStaff();
		this.bulb = new ModelPowerBulb();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);

		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);

		//Render stick
		GL11.glPushMatrix();
		this.bindTexture(stickTexture);
		this.stick.renderModel(0.0625F);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
		
		this.bindTexture(bulbTexture);
		
		//Offsets Below
		GL11.glPushMatrix();
		
		if(!goUp)
		{
			xOffset += 0.0005F;
			
			if(xOffset >= -0.25F)
				goUp = true;
		}
		else if(goUp)
		{
			xOffset -= 0.0005F;
			
			if(xOffset <= -0.35F)
				goUp = false;
		}
		GL11.glTranslatef(0.0F, xOffset, 0.0F);
		
		//Rotations Below
		GL11.glPushMatrix();
		yRotateAngle += scale * speed;
		if(yRotateAngle <= 360)
			yRotateAngle -= 360;
		GL11.glRotatef(yRotateAngle, 0.0F, 1.0F, 0.0f);
		
		this.bulb.renderModel(0.0625F);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPopMatrix();
	}
}
