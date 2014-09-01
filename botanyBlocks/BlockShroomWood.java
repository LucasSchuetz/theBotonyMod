package botanyBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import botanyMain.Base;

public class BlockShroomWood extends Block
{
	public BlockShroomWood()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "shroomWood");
		this.setBlockTextureName(Base.modid + ":" + "shroomWood");
		
		this.setHardness(2.5F);
		
		this.setCreativeTab(Base.tabSometimes);
	}
}
