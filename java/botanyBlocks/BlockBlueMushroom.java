package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlueMushroom extends Block
{
	public BlockBlueMushroom()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "blueMushroom");
		this.setBlockTextureName(Base.modid + ":" + "blueMushroom_outer");
		
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
    
	@Override
    public Item getItemDropped(int num, Random rand, int num1)
    {
        return Base.blockMushroomGiant.getItemDropped(0, rand, num1);
    }
	
    @SideOnly(Side.CLIENT)
    @Override
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(Base.blockMushroomGiant);
    }
}
