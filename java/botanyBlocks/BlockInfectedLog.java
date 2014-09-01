package botanyBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockInfectedLog extends BlockRotatedPillar
{
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	public BlockInfectedLog()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "infectedLog");
//		this.setBlockTextureName(Base.modid + ":" + "infectedLog");
		
		this.setHardness(2.0F);
		this.setCreativeTab(Base.tabSometimes);
	}
	
	@Override
    public void breakBlock(World world, int x, int y, int z, Block aBlock, int metadata)
    {
        byte b0 = 4;
        int i1 = b0 + 1;

        if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1))
        {
            for (int j1 = -b0; j1 <= b0; ++j1)
            {
                for (int k1 = -b0; k1 <= b0; ++k1)
                {
                    for (int l1 = -b0; l1 <= b0; ++l1)
                    {
                        Block block = world.getBlock(x + j1, y + k1, z + l1);
                        if (block.isLeaves(world, x + j1, y + k1, z + l1))
                        {
                            block.beginLeavesDecay(world, x + j1, y + k1, z + l1);
                        }
                    }
                }
            }
        }
    }
	
	@Override
	protected IIcon getSideIcon(int p_150163_1_)
	{
		return this.blockIcon;
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.iconTop;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(Base.modid + ":" + "infectedLog" + "_side");
		this.iconTop = icon.registerIcon(Base.modid + ":" + "infectedLog" + "_top");
	}

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
}
