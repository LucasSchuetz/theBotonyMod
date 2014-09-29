package botanyRenderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMongrel extends RenderLiving
{
	private static final ResourceLocation texture = new ResourceLocation(Base.modid + ":textures/entity/mongrel.png");
	
	public RenderMongrel(ModelBase modelBase, float f)
	{
		super(modelBase, f);
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
