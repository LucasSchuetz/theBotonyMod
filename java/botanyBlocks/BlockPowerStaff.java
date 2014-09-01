package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import botanyMain.Base;
import botanyTileEntity.TileEntityPowerStaff;
import botanyTileEntity.TileEntitySapphireCrop;

public class BlockPowerStaff extends BlockContainer
{	
	boolean staffFoundOnBreak;
	
	public BlockPowerStaff()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "powerStaff");
		this.setBlockTextureName(Base.modid + ":" + "powerStaff");
		
		this.setTickRandomly(true);
		this.setHardness(200.0F);
		
		this.setCreativeTab(Base.tabSometimes);
		
		//Block bounds -- What you collide with
		this.setBlockBounds(.25F, 0.0F, 0.25F, 0.75F, 1.65F, 0.75F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int num)
	{
		return new TileEntityPowerStaff();
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{	
        //Checks for grow-able crops in the area
    	for(int j = -5; j <= 5; j++)
    	{
    		for(int k = -5; k <= 5; k++)
    		{
    			 TileEntity te = world.getTileEntity(x + j, y, z + k);
    			 
    			 if(te != null)
    			 {
    				 if(te instanceof TileEntitySapphireCrop)
    				 {
    					 ((TileEntitySapphireCrop)te).setStaffFound(true);
    				 }
    			 }
    		}
    	}
	}
	
	@Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
    {
        //Checks for grow-able crops in the area and sets staffFound to false
    	for(int j = -5; j <= 5; j++)
    	{
    		for(int k = -5; k <= 5; k++)
    		{
    			 TileEntity te = world.getTileEntity(x + j, y, z + k);
    			 
    			 if(te != null)
    			 {
    				 if(te instanceof TileEntitySapphireCrop)
    				 {
    					 if(((TileEntitySapphireCrop)te).getStaffFound())
    					 {
    						 ((TileEntitySapphireCrop)te).setStaffFound(false);
    					 }
    				 }
    			 }
    		}
    	}
    	
    	ItemStack gem = new ItemStack(Base.blockPowerBulb);
    	EntityPlayer player = world.getClosestPlayer(x, y, z, 10);
    	
    	if(!world.isRemote)
    	{
    		Random rand = new Random();
    		
    		EntityItem item = player.entityDropItem(gem, 1.0F);
            item.motionY += rand.nextFloat() * 0.05F;
            item.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.2F;
            item.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.2F;
    	}

        super.breakBlock(world, x, y, z, par5, par6);
    }
	
	@Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.createNewTileEntity(world, x);
    }
	
	//Called when block is right-clicked
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	ItemStack gem = new ItemStack(Base.blockPowerBulb);
    	
        if(!world.isRemote)
        {
        	Random rand = new Random();
            EntityItem item = player.entityDropItem(gem, 1.0F);
            item.motionY += rand.nextFloat() * 0.05F;
            item.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.2F;
            item.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.2F;
        }
        
		world.setBlock(x, y, z, Base.blockCropStaff);
		
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
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
