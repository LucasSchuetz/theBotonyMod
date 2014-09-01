package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import botanyMain.Base;

public class BlockGemRoot extends BlockBush
{
	public BlockGemRoot()
	{
		super();
		
		this.setBlockName(Base.modid + "_" + "gemRoot");
		this.setBlockTextureName(Base.modid + ":" + "gemRoot");
		
		this.setHardness(0.01F);
        this.setCreativeTab(Base.tabSometimes);
		
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
	}
	
	@Override
    public Item getItemDropped(int num, Random rand, int num2)
    {
        return Base.itemGemRootShard;
    }
	
	@Override
    public int quantityDroppedWithBonus(int num, Random rand)
    {
        return 2;
    }
	
	@Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
    }
    
    @Override
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        if (y >= 0 && y < 256)
        {
            Block block = world.getBlock(x, y - 1, z);
            
            return (block == Base.blockFungleGrass || block == Base.blockFungleDirt || block == Blocks.grass || block == Blocks.dirt);
        }
        else
        {
            return false;
        }
    }
}
