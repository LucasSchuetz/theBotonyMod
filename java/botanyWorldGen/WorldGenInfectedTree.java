package botanyWorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import botanyMain.Base;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenInfectedTree extends WorldGenerator implements IWorldGenerator
{
	private final int minTreeHeight;
	private final boolean vinesGrow;
	private final int metaWood;
	private final int metaLeaves;
	private boolean saplingUsed;
	
	public WorldGenInfectedTree(boolean par1)
	{
		this(par1, 12, 0, 0, false);
		
		this.saplingUsed = par1;
	}
	
	public WorldGenInfectedTree(boolean par1, int par2, int x, int y, boolean z)
	{
		super(par1);
		
		this.saplingUsed = par1;
		this.minTreeHeight = par2;
		this.metaWood = x;
		this.metaLeaves = y;
		this.vinesGrow = z;
	}
	
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
    	int treeHeight = rand.nextInt(3) + 6; //height range of tree (6-9 blocks tall);
    	int branchHeight = y + (treeHeight - 6);
    	int branchOrientation = rand.nextInt(4); //helps with a more modular feel
    	int xCoord, yCoord, zCoord, placeHeight;
    	boolean flag = true;
    	
    	if(y >= 1 && (y + treeHeight + 1 < 256) && !world.isRemote) //if sapling height is viable for tree to grow then...
    	{
    		int id = Block.getIdFromBlock(world.getBlock(x, y, z));
    		Block block = world.getBlock(x, y, z);
    		
    		if(block != null || saplingUsed)
    		{
    			if(saplingUsed || (block == Blocks.dirt || block == Blocks.grass ||
    			   block == Base.blockFungleDirt || block == Base.blockFungleGrass ||
    			   block.isAir(world, x, y, z) || block == Blocks.tallgrass))
    			{
    				//populates trunk
    	    		for(placeHeight = 0; placeHeight <= treeHeight; ++placeHeight)
    	    		{
    	    			world.setBlock(x, y + placeHeight, z, Base.blockInfectedLog);
    	    		}
    	    		
    	    		//populates branches with leaves
    	    		if(branchOrientation == 0)
    	    		{
    	    			//branch 1
    	    			world.setBlock(x - 1, branchHeight + 3, z, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 3, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 2, Base.blockInfectedLog);
    	    			//branch 2
    	    			world.setBlock(x + 1, branchHeight + 4, z, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 4, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 3, branchHeight + 4, z + 2, Base.blockInfectedLog);
    	    			//branch 3
    	    			world.setBlock(x, branchHeight + 4, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x, branchHeight + 4, z - 2, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 4, z - 3, Base.blockInfectedLog);
    	    			//branch 4
    	    			world.setBlock(x + 1, branchHeight + 6, z, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 6, z - 2, Base.blockInfectedLog);
    	    			//branch 5
    	    			world.setBlock(x, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x, branchHeight + 6, z + 2, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 6, z + 2, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 6, z + 3, Base.blockInfectedLog);
    	    			//branch 6
    	    			world.setBlock(x - 1, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 6, z - 2, Base.blockInfectedLog);
    	    			world.setBlock(x - 3, branchHeight + 6, z - 2, Base.blockInfectedLog);
    	    		}
    	    		else if(branchOrientation == 1)
    	    		{
    	    			//branch 1
    	    			world.setBlock(x, branchHeight + 3, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 3, z + 2, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 4, z + 2, Base.blockInfectedLog);
    	    			//branch 2
    	    			world.setBlock(x, branchHeight + 4, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 4, z - 2, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 4, z - 2, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 4, z - 3, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 3, Base.blockInfectedLog);
    	    			//branch 3
    	    			world.setBlock(x - 1, branchHeight + 4, z, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 4, z, Base.blockInfectedLog);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 1, Base.blockInfectedLog);
    	    			//branch 4
    	    			world.setBlock(x, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			//branch 5
    	    			world.setBlock(x + 1, branchHeight + 6, z, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 6, z, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 3, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			//branch 6
    	    			world.setBlock(x - 1, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 6, z + 2, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 6, z + 3, Base.blockInfectedLog);
    	    		}
    	    		else if(branchOrientation == 2)
    	    		{
    	    			//branch 1
    	    			world.setBlock(x + 1, branchHeight + 3, z, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 3, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 2, Base.blockInfectedLog);
    	    			//branch 2
    	    			world.setBlock(x - 1, branchHeight + 4, z, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 4, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 3, branchHeight + 4, z - 2, Base.blockInfectedLog);
    	    			//branch 3
    	    			world.setBlock(x, branchHeight + 4, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x, branchHeight + 4, z + 2, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 4, z + 3, Base.blockInfectedLog);
    	    			//branch 4
    	    			world.setBlock(x - 1, branchHeight + 6, z, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 6, z + 2, Base.blockInfectedLog);
    	    			//branch 5
    	    			world.setBlock(x, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x, branchHeight + 6, z - 2, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 6, z - 2, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 6, z - 3, Base.blockInfectedLog);
    	    			//branch 6
    	    			world.setBlock(x + 1, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 6, z + 2, Base.blockInfectedLog);
    	    			world.setBlock(x + 3, branchHeight + 6, z + 2, Base.blockInfectedLog);
    	    		}
    	    		else if(branchOrientation == 3)
    	    		{
    	    			//branch 1
    	    			world.setBlock(x, branchHeight + 3, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 3, z - 2, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 4, z - 2, Base.blockInfectedLog);
    	    			//branch 2
    	    			world.setBlock(x, branchHeight + 4, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 4, z + 2, Base.blockInfectedLog);
    	    			world.setBlock(x - 1, branchHeight + 4, z + 2, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 4, z + 3, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 3, Base.blockInfectedLog);
    	    			//branch 3
    	    			world.setBlock(x + 1, branchHeight + 4, z, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 4, z, Base.blockInfectedLog);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 1, Base.blockInfectedLog);
    	    			//branch 4
    	    			world.setBlock(x, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 1, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			//branch 5
    	    			world.setBlock(x - 1, branchHeight + 6, z, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 6, z, Base.blockInfectedLog);
    	    			world.setBlock(x - 2, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			world.setBlock(x - 3, branchHeight + 6, z + 1, Base.blockInfectedLog);
    	    			//branch 6
    	    			world.setBlock(x + 1, branchHeight + 6, z - 1, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 6, z - 2, Base.blockInfectedLog);
    	    			world.setBlock(x + 2, branchHeight + 6, z - 3, Base.blockInfectedLog);
    	    		}
    	    		else //somehow a random number between 0 and 3 was NOT 0, 1, 2, or 3...wtf?
    	    			return false;
    	    		
    	    		//Leaf gen
    	    		if(branchOrientation == 0)
    	    		{
    	    			//branch 1
    	    			world.setBlock(x - 1, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 5, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 3, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 3, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			//branch 2
    	    			world.setBlock(x + 2, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 5, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 5, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 4, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 5, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			//branch 3
    	    			world.setBlock(x - 3, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 5, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 4, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 5, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			//branch 4
    	    			world.setBlock(x, branchHeight + 6, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 6, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 6, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 7, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 6, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 6, z - 3, Base.blockInfectedLeaf);
    	    			//branch 5
    	    			world.setBlock(x - 1, branchHeight + 6, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 6, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 6, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 6, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 6, z + 5, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 7, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 7, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 6, z + 3, Base.blockInfectedLeaf);
    	    			//branch 6
    	    			world.setBlock(x - 1, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 6, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 6, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 7, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 6, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 6, z - 2, Base.blockInfectedLeaf);
    	    		}
    	    		else if(branchOrientation == 1)
    	    		{
    	    			//branch 1
    	    			world.setBlock(x + 2, branchHeight + 4, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 5, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 3, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 3, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z + 4, Base.blockInfectedLeaf);
    	    			//branch 2
    	    			world.setBlock(x + 2, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 5, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 5, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 4, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 5, Base.blockInfectedLeaf);
    	    			//branch 3
    	    			world.setBlock(x - 3, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 5, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 4, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 5, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z, Base.blockInfectedLeaf);
    	    			//branch 4
    	    			world.setBlock(x - 2, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 6, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 6, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 7, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 6, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 6, z - 2, Base.blockInfectedLeaf);
    	    			//branch 5
    	    			world.setBlock(x + 2, branchHeight + 6, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 6, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 5, branchHeight + 6, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 7, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 7, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 6, z - 2, Base.blockInfectedLeaf);
    	    			//branch 6
    	    			world.setBlock(x, branchHeight + 6, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 6, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 6, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 6, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 7, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 6, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 6, z + 4, Base.blockInfectedLeaf);
    	    		}
    	    		else if(branchOrientation == 2)
    	    		{
    	    			//branch 1
    	    			world.setBlock(x + 1, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 5, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 3, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 3, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			//branch 2
    	    			world.setBlock(x - 2, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 5, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 5, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 4, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 5, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			//branch 3
    	    			world.setBlock(x + 3, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 5, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 4, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 5, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			//branch 4
    	    			world.setBlock(x, branchHeight + 6, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 6, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 6, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 7, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 6, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 6, z + 3, Base.blockInfectedLeaf);
    	    			//branch 5
    	    			world.setBlock(x + 1, branchHeight + 6, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 6, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 6, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 6, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 6, z - 5, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 7, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 7, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 6, z - 3, Base.blockInfectedLeaf);
    	    			//branch 6
    	    			world.setBlock(x + 1, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 6, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 6, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 7, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 6, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 6, z + 2, Base.blockInfectedLeaf);
    	    		}
    	    		else if(branchOrientation == 3)
    	    		{
    	    			//branch 1
    	    			world.setBlock(x - 2, branchHeight + 4, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 5, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 3, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 3, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z - 4, Base.blockInfectedLeaf);
    	    			//branch 2
    	    			world.setBlock(x - 2, branchHeight + 4, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 1, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 5, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 5, z + 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 4, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 4, z + 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 4, z + 5, Base.blockInfectedLeaf);
    	    			//branch 3
    	    			world.setBlock(x + 3, branchHeight + 4, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 4, z - 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 5, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 4, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 4, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 5, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 4, z, Base.blockInfectedLeaf);
    	    			//branch 4
    	    			world.setBlock(x + 2, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 6, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 4, branchHeight + 6, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 7, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 6, z + 2, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 6, z + 2, Base.blockInfectedLeaf);
    	    			//branch 5
    	    			world.setBlock(x - 2, branchHeight + 6, z - 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 6, z, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 4, branchHeight + 6, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 5, branchHeight + 6, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 2, branchHeight + 7, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 7, z + 1, Base.blockInfectedLeaf);
    	    			world.setBlock(x - 3, branchHeight + 6, z + 2, Base.blockInfectedLeaf);
    	    			//branch 6
    	    			world.setBlock(x, branchHeight + 6, z -1, Base.blockInfectedLeaf);
    	    			world.setBlock(x, branchHeight + 6, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 6, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 3, branchHeight + 6, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 7, z - 3, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 1, branchHeight + 6, z - 4, Base.blockInfectedLeaf);
    	    			world.setBlock(x + 2, branchHeight + 6, z - 4, Base.blockInfectedLeaf);
    	    		}
    	    		else
    	    			return false;
    	    		
    	    		return true;
    			}
    			else
    				return false;
    		}
    		else
    			return false;
    	}
    	else //shit y height for growth...
    	{
    		return false;
    	}
    }
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		for(int i = 0; i < 10; i++)
		{
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(16);
			int zCoord = chunkZ + random.nextInt(16);
			(new WorldGenInfectedTree(false, 12, 0, 0, false)).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
}