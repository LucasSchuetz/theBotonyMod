package botanyRenderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderLifeBasin implements IItemRenderer
{
	TileEntitySpecialRenderer render;
	private TileEntity te;

	public ItemRenderLifeBasin(TileEntitySpecialRenderer render, TileEntity te)
	{
	    this.render = render;
	    this.te = te;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		if (type == IItemRenderer.ItemRenderType.ENTITY)
		{
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		}
		
		((RenderLifeBasin)this.render).tileEntityInHandRenderer(this.te, 0.0D, 0.0D, 0.0D, 0.0F);
	}
}