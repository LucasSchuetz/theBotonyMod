package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import botanyMain.Base;
import botanyTileEntity.TileEntityVibrantBloom;
import botanyTileEntity.TileEntityVibrantBloomRoot;

public class BlockVibrantBloomRoot extends BlockContainer
{
	private boolean needsNewRoot;
	private boolean mainFound = false;
	private int yCoord, j;
	
	public BlockVibrantBloomRoot()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "vibrantBloomRoot");
		this.setBlockTextureName(Base.modid + ":" + "vibrantBloomRoot");
		
//		this.setCreativeTab(Base.tabSometimes);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if(!world.isRemote)
			if(needsNewRoot)
				if((rand.nextInt() / 5) == 0)
				{
					world.setBlock(x, yCoord, y, Base.blockVibrantBloomRoot);
					needsNewRoot = false;
				}
	}
	
	@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
		j = 0; //count for searching for main block to notify
		TileEntity te = new TileEntity();
		
		for(int i = -1; i <= 1; i += 2)
		{
			if(!(world.getTileEntity(x, y + i, z) instanceof TileEntityVibrantBloomRoot))
				if(world.getTileEntity(x, y + (i * 2), z) instanceof TileEntityVibrantBloomRoot)
				{
					//Notify this block to regrow
					yCoord = y + i;
					needsNewRoot = true;
					
					//Notify main that water is not being supplied
					while(!mainFound)
					{
						if(world.getTileEntity(x, y + j, z) instanceof TileEntityVibrantBloom)
						{
							te = world.getTileEntity(x, y + j, z);
							mainFound = true;
							((TileEntityVibrantBloom)te).setWatered(false);
						}
						else
							j++;
					}
					mainFound = false;
				}
		}
		
		if(needsNewRoot) System.out.println("NEEDS NEW ROOT");
    }

	@Override
	public TileEntity createNewTileEntity(World world, int num)
	{
		return new TileEntityVibrantBloomRoot();
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
