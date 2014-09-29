package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import botanyMain.Base;
import botanyWorldGen.WorldGenInfectedTree;

public class BlockInfectedSapling extends BlockBush implements IGrowable
{
	public static final String[] WOOD_TYPES = new String[] {
	"Infected"};

	public BlockInfectedSapling()
	{
		super();
		
		this.setBlockName(Base.modid + "_" + "infectedSapling");
		this.setBlockTextureName(Base.modid + ":" + "infectedSapling");
	
		float var3 = 0.4F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
		this.setCreativeTab(Base.tabSometimes);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (!world.isRemote)
		{
			super.updateTick(world, x, y, z, rand);
			
			if (world.getBlockLightValue(x, y + 1, z) >= 9 && rand.nextInt(7) == 0)
			{
				this.growTree(world, x, y, z, rand);
			}
		}
	}
	
	//1.7.10 changed name to 'func_149878_d' so...should work
	public void growTree(World world, int x, int y, int z, Random rand)
	{
		if (!TerrainGen.saplingGrowTree(world, rand, x, y, z)) return;
		int l = world.getBlockMetadata(x, y, z) & 3;
		Object object = null;
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		
		if (l == 1)
		{
			object = new WorldGenInfectedTree(true);
		}
		else if (l == 2)
		{
			object = new WorldGenInfectedTree(true);
		}
		else if (l == 3)
		{
			for (i1 = 0; i1 >= -1; --i1)
			{
				for (j1 = 0; j1 >= -1; --j1)
				{
					if (this.isSameSapling(world, x + i1, y, z + j1, 3) && this.isSameSapling(world, x + i1 + 1, y, z + j1, 3) && this.isSameSapling(world, x + i1, y, z + j1 + 1, 3) && this.isSameSapling(world, x + i1 + 1, y, z + j1 + 1, 3))
					{
						object = new WorldGenInfectedTree(true, 10 + rand.nextInt(20), 3, 3, true);
						flag = true;
						break;
					}
				}
				
				if (object != null)
				{
					break;
				}
			}
			
			if (object == null)
			{
				j1 = 0;
				i1 = 0;
				object = new WorldGenInfectedTree(true, 4 + rand.nextInt(7), 3, 3, true);
			}
		}
		else
		{
			object = new WorldGenInfectedTree(true);
			
			if (rand.nextInt(10) == 0)
			{
				object = new WorldGenInfectedTree(true);
			}
		}
		
		if (flag)
		{
			world.setBlock(x + i1, y, z + j1, Base.blockInfectedSapling, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1, Base.blockInfectedSapling, 0, 4);
			world.setBlock(x + i1, y, z + j1 + 1, Base.blockInfectedSapling, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1 + 1, Base.blockInfectedSapling, 0, 4);
		}
		else
		{
			world.setBlock(x, y, z, Base.blockInfectedSapling, 0, 4);
		}
		
		if (!((WorldGenerator)object).generate(world, rand, x + i1, y, z + j1))
		{
			if (flag)
			{
				world.setBlock(x + i1, y, z + j1, Base.blockInfectedSapling, l, 4);
				world.setBlock(x + i1 + 1, y, z + j1, Base.blockInfectedSapling, l, 4);
				world.setBlock(x + i1, y, z + j1 + 1, Base.blockInfectedSapling, l, 4);
				world.setBlock(x + i1 + 1, y, z + j1 + 1, Base.blockInfectedSapling, l, 4);
			}
			else
			{
				world.setBlock(x, y, z, Base.blockInfectedSapling, l, 4);
			}
		}
	}

	public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
	{
		return par1World.getBlock(par2, par3, par4) == Base.blockInfectedSapling && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
	}
	
	protected boolean canThisPlantGrowOnThisBlockID(int block)
	{
		return block == Block.getIdFromBlock(Base.blockFungleGrass) || block == Block.getIdFromBlock(Base.blockFungleDirt) ||
			   block == Block.getIdFromBlock(Blocks.grass) || block == Block.getIdFromBlock(Blocks.dirt);
	}

	/**VANILLA IGROWABLE METHODS BELOW**/
	
    public boolean func_149851_a(World world, int x, int y, int z, boolean bool)
    {
        return true;
    }

    public boolean func_149852_a(World world, Random rnad, int x, int y, int z)
    {
        return (double)world.rand.nextFloat() < 0.45D;
    }

    public void func_149853_b(World world, Random rand, int x, int y, int z)
    {
        this.growTree(world, x, y, z, rand);
    }
}
