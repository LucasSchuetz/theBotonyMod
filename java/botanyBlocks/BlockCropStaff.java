package botanyBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import botanyMain.Base;
import botanyTileEntity.TileEntityCropStaff;

public class BlockCropStaff extends BlockContainer
{	
	public BlockCropStaff()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "cropStaff");
		this.setBlockTextureName(Base.modid + ":" + "cropStaff");
		
		this.setHardness(2.0F);
		this.setCreativeTab(Base.tabSometimes);
		
		//Block bounds -- What you collide with
		this.setBlockBounds(.25F, 0.0F, 0.25F, 0.75F, 1.65F, 0.75F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int num)
	{
		return new TileEntityCropStaff();
	}
	
	@Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.createNewTileEntity(par1World, par2);
    }
	
	//Called when block is right-clicked
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	ItemStack stack = player.getCurrentEquippedItem();
    	
    	if(stack == null)
    		return false;
    	else if(stack.getItem() == Item.getItemFromBlock(Base.blockPowerBulb))
    	{
    		if(world.getTileEntity(x, y, z) instanceof TileEntityCropStaff)
    		{
        		world.setBlock(x, y, z, Base.blockPowerStaff);
        		
        		if(!player.capabilities.isCreativeMode)
        			stack.stackSize--;
    		}
    		
    		return true;
    	}
    	else //not empty or Power Bulb
    		return true;
    }
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        this.checkBlock(world, x, y, z);
    }

    //Custom name, previously 'func_150090_e'
    private boolean checkBlock(World world, int x, int y, int z)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
            return false;
        }
        else
        {
            return true;
        }
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
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
