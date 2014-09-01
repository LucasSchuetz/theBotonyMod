package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlueMushroomStem extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	public BlockBlueMushroomStem()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "blueMushroomStem");
//		this.setBlockTextureName(Base.modid + ":" + "blueMushroomStem");

		this.setHardness(0.5F);
		this.setCreativeTab(Base.tabSometimes);
	}

    public int quantityDropped(Random par1Random)
    {
        int i = par1Random.nextInt(10) - 7;

        if (i < 0)
        {
            i = 0;
        }

        return i;
    }

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int num)
	{
		return side == 1 || side == 0 ? this.iconTop : this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(Base.modid + ":" + "blueMushroomStem" + "_side");
		this.iconTop = icon.registerIcon(Base.modid + ":" + "blueMushroomStem" + "_top");
	}
}
