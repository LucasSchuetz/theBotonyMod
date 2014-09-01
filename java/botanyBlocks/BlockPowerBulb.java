package botanyBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import botanyMain.Base;
import botanyTileEntity.TileEntityPowerBulb;

public class BlockPowerBulb extends BlockContainer
{	
	public BlockPowerBulb()
	{
		super(Material.cactus);

		this.setBlockName(Base.modid + "_" + "powerBulb");
		this.setBlockTextureName(Base.modid + ":" + "powerBulb");
		
		this.setHardness(0.4F);
		this.setCreativeTab(Base.tabSometimes);
		
		//Block bounds -- What you collide with
		this.setBlockBounds(.10F, 0.0F, 0.10F, 0.90F, 0.50F, 0.90F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int num)
	{
		return new TileEntityPowerBulb();
	}
	
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        this.checkBlock(world, x, y, z);
    }

    //Custom name, previously 'func_150090_e'
    private boolean checkBlock(World world, int x, int y, int z)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
            return false;
        }
        else
        {
            return true;
        }
    }
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
