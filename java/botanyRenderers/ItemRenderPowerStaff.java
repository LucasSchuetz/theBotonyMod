package botanyRenderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderPowerStaff implements IItemRenderer
{
	TileEntitySpecialRenderer render;
	private TileEntity te;

	public ItemRenderPowerStaff(TileEntitySpecialRenderer render, TileEntity te)
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
		else if(type == IItemRenderer.ItemRenderType.INVENTORY)
		{
			GL11.glTranslatef(-0.6F, -0.3F, 0.0F);
			GL11.glRotatef(30.0F, 0.0F, 0.0F, -1.0F);
		}
		else if(type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			GL11.glScalef(1.5F, 1.5F, 1.5F);
		}
		else if(type == IItemRenderer.ItemRenderType.EQUIPPED)
		{
			GL11.glScalef(2.0F, 2.5F, 2.0F);
			GL11.glTranslatef(-0.1F, -0.5F, -0.3F);
		}
		
		this.render.renderTileEntityAt(this.te, 0.0D, 0.0D, 0.0D, 0.0F);
	}
}