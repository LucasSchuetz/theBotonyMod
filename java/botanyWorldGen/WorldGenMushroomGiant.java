package botanyWorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import botanyMain.Base;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMushroomGiant extends WorldGenerator implements IWorldGenerator
{
	private int mushroomType = 1;
	private boolean saplingUsed = true;
	
	public WorldGenMushroomGiant(int id)
	{
		this.mushroomType = id;
	}
	
	public WorldGenMushroomGiant(boolean saplinged)
	{
		this.saplingUsed = saplinged;
	}
	
	public WorldGenMushroomGiant() {}
	
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        int l = this.mushroomType;

        int i1 = rand.nextInt(3) + 4;
        boolean flag = true;

        if (y >= 1 && y + i1 + 1 < 256)
        {
            int j1;
            int k1;
            int l1;
            int i2;

            for (j1 = y; j1 <= y + 1 + i1; ++j1)
            {
                byte b0 = 3;

                if (j1 <= y + 3)
                {
                    b0 = 0;
                }

                for (k1 = x - b0; k1 <= x + b0 && flag; ++k1)
                {
                    for (l1 = z - b0; l1 <= z + b0 && flag; ++l1)
                    {
                        if (j1 >= 0 && j1 < 256)
                        {
                            i2 = Block.getIdFromBlock(world.getBlock(k1, j1, l1));
                            Block block = world.getBlock(x, y, z);
                            
                            if (block != null && !block.isAir(world, k1, j1, l1) && !block.isLeaves(world, k1, j1, l1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                j1 = Block.getIdFromBlock(world.getBlock(x, y - 1, z));

                if (saplingUsed && (j1 != Block.getIdFromBlock(Base.blockFungleDirt) && j1 != Block.getIdFromBlock(Base.blockFungleGrass)))
                {
                    return false;
                }
                else if(!saplingUsed && (j1 != Block.getIdFromBlock(Base.blockFungleDirt) && j1 != Block.getIdFromBlock(Base.blockFungleGrass) &&
                						 j1 != Block.getIdFromBlock(Blocks.dirt) && j1 != Block.getIdFromBlock(Blocks.grass)))
                {
                	return false;
                }
                else
                {
                    int j2 = y + i1;

                    if (l == 1)
                    {
                        j2 = y + i1 - 3;
                    }

                    for (k1 = j2; k1 <= y + i1; ++k1)
                    {
                        l1 = 1;

                        if (k1 < y + i1)
                        {
                            ++l1;
                        }

                        if (l == 0)
                        {
                            l1 = 3;
                        }

                        for (i2 = x - l1; i2 <= x + l1; ++i2)
                        {
                            for (int k2 = z - l1; k2 <= z + l1; ++k2)
                            {
                                int l2 = 5;

                                if (i2 == x - l1)
                                {
                                    --l2;
                                }

                                if (i2 == x + l1)
                                {
                                    ++l2;
                                }

                                if (k2 == z - l1)
                                {
                                    l2 -= 3;
                                }

                                if (k2 == z + l1)
                                {
                                    l2 += 3;
                                }

                                if (l == 0 || k1 < y + i1)
                                {
                                    if ((i2 == x - l1 || i2 == x + l1) && (k2 == z - l1 || k2 == z + l1))
                                    {
                                        continue;
                                    }

                                    if (i2 == x - (l1 - 1) && k2 == z - l1)
                                    {
                                        l2 = 1;
                                    }

                                    if (i2 == x - l1 && k2 == z - (l1 - 1))
                                    {
                                        l2 = 1;
                                    }

                                    if (i2 == x + (l1 - 1) && k2 == z - l1)
                                    {
                                        l2 = 3;
                                    }

                                    if (i2 == x + l1 && k2 == z - (l1 - 1))
                                    {
                                        l2 = 3;
                                    }

                                    if (i2 == x - (l1 - 1) && k2 == z + l1)
                                    {
                                        l2 = 7;
                                    }

                                    if (i2 == x - l1 && k2 == z + (l1 - 1))
                                    {
                                        l2 = 7;
                                    }

                                    if (i2 == x + (l1 - 1) && k2 == z + l1)
                                    {
                                        l2 = 9;
                                    }

                                    if (i2 == x + l1 && k2 == z + (l1 - 1))
                                    {
                                        l2 = 9;
                                    }
                                }

                                if (l2 == 5 && k1 < y + i1)
                                {
                                    l2 = 0;
                                }

                                Block block = world.getBlock(i2, k1, k2);

                                if ((l2 != 0 || y >= y + i1 - 1) && (block == null || block.canBeReplacedByLeaves(world, i2, k1, k2)))
                                {
                                    this.setBlockAndNotifyAdequately(world, i2, k1, k2, Base.blockBlueMushroom, l2);
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < i1; ++k1)
                    {
                        l1 = Block.getIdFromBlock(world.getBlock(x, y + k1, z));

                        Block block = world.getBlock(x, y + k1, z);

                        if (block.canBeReplacedByLeaves(world, x, y + k1, z))
                        {
                            this.setBlockAndNotifyAdequately(world, x, y + k1, z, Base.blockBlueMushroomStem, 10);
                        }
                    }

                    return true;
                }
            }
        }
        else
        {
            return false;
        }
    }
    
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		for(int i = 0; i < 10; i++)
		{
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(16);
			int zCoord = chunkZ + random.nextInt(16);
			(new WorldGenMushroomGiant()).generate(world, random, xCoord, yCoord, zCoord);
		}	
	}
}
