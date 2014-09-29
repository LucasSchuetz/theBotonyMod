package botanyBlocks;

import net.minecraft.block.BlockBush;
import botanyMain.Base;

public class BlockVileMushroom extends BlockBush
{
	public BlockVileMushroom()
	{
		super();
		
		this.setBlockName(Base.modid + "_" + "mushroomVile");
		this.setBlockTextureName(Base.modid + ":" + "mushroomVile");
		
        this.setCreativeTab(Base.tabSometimes);
        
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
}
