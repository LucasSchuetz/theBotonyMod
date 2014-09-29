package botanyBlocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import botanyMain.Base;
import botanyTileEntity.TileEntityVibrantBloom;

public class BlockVibrantBloom extends BlockContainer
{
	protected boolean canBranchesGrow = false;
	protected boolean rootFoundWater = false;
	protected boolean rootNotified = false;
	protected boolean branchCreated = false;
	protected int newYCoord;
	
	public BlockVibrantBloom()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "vibrantBloom");
		this.setBlockTextureName(Base.modid + ":" + "vibrantBloom");
		
		this.setHardness(30.0F);
		this.setResistance(200.0F);
		this.setTickRandomly(true);
		
//		this.setCreativeTab(Base.tabSometimes);
		
		//Block bounds -- What you collide with
		this.setBlockBounds(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
//		TileEntity te = new TileEntity();
//		
//		if (!world.isRemote)
//		{
//			super.updateTick(world, x, y, z, rand);
//			
//			if(!rootNotified)
//			{
//				if(!rootFoundWater)
//					if((rand.nextInt() / 5) == 0)
//						growRoots(world, x, y, z);
//				else //water was found, root needs to be notified
//				{
//					te = world.getTileEntity(x, y - newYCoord, z);
//					
//					if(te != null)
//						if(te instanceof TileEntityVibrantBloomRoot)
//							((TileEntityVibrantBloom)te).setWaterFound = rootFoundWater
//					
//					rootNotified = true;
//							
//				}
//			} //end root notified
//			else //root found water and has been notified
//			{
//				if(!branchCreated)
//				{
//					world.setBlock(x, y + 1, z, Base.blockVibrantBloomBranch);
//					branchCreated = true;
//				}
//				else //branches already growing...
//					if((rand.nextInt() / 10) == 0)
//						growBranches(world, x, y + 1, z); //sets to 'y + 1' because branch 'y + 1' already created
//			}
//		}
	}
	
	private void growRoots(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y - 1, z) != Base.blockVibrantBloomRoot)
		{
			if(world.getBlock(x, y - 1, z) != Blocks.water)
				world.setBlock(x, y - 1, z, Base.blockVibrantBloomRoot);
			else //water was found below root
				rootFoundWater = true;
		}
		else //roots found below, digs deeper, recursion occurs
		{
			newYCoord = y--;
			growRoots(world, x, newYCoord, z);
		}
	}
	
	private void growBranches(World world, int x, int y, int z)
	{
//		TileEntity branch = new TileEntity();
//		branch = world.getTileEntity(x, y, z);
//		
//		if(branch != null)
//			if(branch instanceof TileEntityVibrantBloomBranch)
//				if(((TileEntityVibrantBloomBranch)branch).getBranchNum < 25)
//				{
//					place growth code here when branches finished
//				}
		
		for(int i = -1; i <= 1; i += 2)
		{
			 //the following ifs check for adjacent branch, if found, checks the one on the other side
			//of the found one, if second branch not found, calls recursion
			if(world.getBlock(x + i, y, z) == Base.blockVibrantBloomBranch)
				if(world.getBlock(x + (i * 2), y, z) != Base.blockVibrantBloomBranch)
					growBranches(world, x + i, y, z);
			else if(world.getBlock(x, y + i, z) == Base.blockVibrantBloomBranch)
				if(world.getBlock(x, y + (i * 2), z) != Base.blockVibrantBloomBranch)
					growBranches(world, x, y + i, z);
			else if(world.getBlock(x, y, z + i) == Base.blockVibrantBloomBranch)
				if(world.getBlock(x, y, z + (i * 2)) != Base.blockVibrantBloomBranch)
					growBranches(world, x, y, z + i);
			//else if(block == branch support) {grow along support};
			//above conditional must also add 1 to branches number if sets happen
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int num)
	{
		return new TileEntityVibrantBloom();
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
