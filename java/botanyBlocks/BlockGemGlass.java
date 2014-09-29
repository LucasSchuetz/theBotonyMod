package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGemGlass extends Block
{
	private boolean sideRendered;
	
    public BlockGemGlass()
    {
        super(Material.glass);
        
        this.setBlockName(Base.modid + "_" + "gemGlass");
        this.setBlockTextureName(Base.modid + ":" + "gemGlass");
        
        this.setStepSound(Block.soundTypeGlass);
        this.setHardness(0.3F);
        this.setCreativeTab(Base.tabSometimes);
    }

    @Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass()
    {
        return 1;
    }

    //Calls adjacent blocks and renders block side if the adjacent blocks are not gem glass
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess aBlock, int x, int y, int z, int metadata)
    {
        Block block = aBlock.getBlock(x, y, z);

        if (this == Base.blockGemGlass)
        {
            if (aBlock.getBlockMetadata(x, y, z) != aBlock.getBlockMetadata(x - Facing.offsetsXForSide[metadata], y - Facing.offsetsYForSide[metadata], z - Facing.offsetsZForSide[metadata]))
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return !this.sideRendered && block == this ? false : super.shouldSideBeRendered(aBlock, x, y, z, metadata);
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

    @Override
    protected boolean canSilkHarvest()
    {
        return true;
    }
}
