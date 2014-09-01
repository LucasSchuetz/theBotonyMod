package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import botanyMain.Base;
import botanyWorldGen.WorldGenMushroomGiant;

public class BlockMushroomGiant extends BlockBush implements IGrowable
{
	public BlockMushroomGiant()
	{
		super();
		
		this.setBlockName(Base.modid + "_" + "mushroomGiant");
		this.setBlockTextureName(Base.modid + ":" + "mushroomGiant");
		
        this.setTickRandomly(true);
        this.setCreativeTab(Base.tabSometimes);
        
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
	@Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par5Random.nextInt(25) == 0)
        {
            byte b0 = 4;
            int l = 5;
            int i1;
            int j1;
            int k1;

            for (i1 = par2 - b0; i1 <= par2 + b0; ++i1)
            {
                for (j1 = par4 - b0; j1 <= par4 + b0; ++j1)
                {
                    for (k1 = par3 - 1; k1 <= par3 + 1; ++k1)
                    {
                        if (par1World.getBlock(i1, k1, j1) == Base.blockMushroomGiant)
                        {
                            --l;

                            if (l <= 0)
                            {
                                return;
                            }
                        }
                    }
                }
            }

            i1 = par2 + par5Random.nextInt(3) - 1;
            j1 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
            k1 = par4 + par5Random.nextInt(3) - 1;

            for (int l1 = 0; l1 < 4; ++l1)
            {
                if (par1World.isAirBlock(i1, j1, k1) && this.canBlockStay(par1World, i1, j1, k1))
                {
                    par2 = i1;
                    par3 = j1;
                    par4 = k1;
                }

                i1 = par2 + par5Random.nextInt(3) - 1;
                j1 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
                k1 = par4 + par5Random.nextInt(3) - 1;
            }

            if (par1World.isAirBlock(i1, j1, k1) && this.canBlockStay(par1World, i1, j1, k1))
            {
                par1World.setBlock(i1, j1, k1, Base.blockMushroomGiant, 0, 2);
            }
        }
    }
    
	@Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
    }

    @Override
    protected boolean canPlaceBlockOn(Block block)
    {
        return block.func_149730_j();
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        if (y >= 0 && y < 256)
        {
            Block block = world.getBlock(x, y - 1, z);
            
            return block == Blocks.mycelium || block == Blocks.dirt || block == Base.blockFungleDirt || block == Base.blockFungleGrass && world.getBlockMetadata(x, y - 1, z) == 2 || world.getFullBlockLightValue(x, y, z) < 13 && block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
        }
        else
        {
            return false;
        }
    }
    
    public boolean fertilizeMushroom(World world, int x, int y, int z, Random rand)
    {
        int l = world.getBlockMetadata(x, y, z);
        world.setBlockToAir(x, y, z);
        WorldGenMushroomGiant worldgenvilemushroom = null;
        
        worldgenvilemushroom = new WorldGenMushroomGiant();

        if (worldgenvilemushroom != null && worldgenvilemushroom.generate(world, rand, x, y, z))
        {
            return true;
        }
        else
        {
            world.setBlock(x, y, z, Base.blockMushroomGiant, l, 3);
            return false;
        }
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
        this.fertilizeMushroom(world, x, y, z, rand);
    }
}
