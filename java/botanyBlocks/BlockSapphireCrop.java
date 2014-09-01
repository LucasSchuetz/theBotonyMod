package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import botanyMain.Base;
import botanyTileEntity.TileEntitySapphireCrop;

public class BlockSapphireCrop extends BlockContainer
{
    int bAmt;
    boolean staffFound;
    
	public BlockSapphireCrop()
	{
		super(Material.cactus);
		
		this.setHardness(3.0F);
		this.setTickRandomly(true);
		
		
		this.setBlockName(Base.modid + "_" + "sapphireCrop");
		this.setBlockTextureName(Base.modid + ":" + "sapphireCrop");
		
		this.setCreativeTab(Base.tabSometimes);
		
		//Block bounds -- What you collide with
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	}
	
	//slows down growth speeds
	@Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
    	TileEntity te = world.getTileEntity(x, y, z);
    	
    	if(te != null)
    	{
    		if(te instanceof TileEntitySapphireCrop)
        		te = (TileEntitySapphireCrop)te;
    		
    		bAmt = ((TileEntitySapphireCrop) te).getBerryAmount();
    		staffFound = ((TileEntitySapphireCrop) te).getStaffFound();
    	}
    	
    	//checks
    	if(!staffFound)
    	{
    		return;
    	}
    	if(world.getBlock(x, y - 1, z) != Blocks.soul_sand)
    		return;
    	if(world.getBlockLightValue(x, y + 1, z) < 9)
    		return;
    	if(rand.nextInt() % 25 != 0)
    		return;
    	if(bAmt < 7)
    	{
    		bAmt++;
    		((TileEntitySapphireCrop) te).setBerryAmount(bAmt);
    	}
    	
    	world.markBlockForUpdate(x, y, z);
    }
	
	//Called when block is sheared
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	ItemStack itemStack = player.getCurrentEquippedItem();
    	TileEntity te = world.getTileEntity(x, y, z);
    	
    	if(te != null)
    	{
    		if(te instanceof TileEntitySapphireCrop)
    			te = (TileEntitySapphireCrop)te;
    		
    		bAmt = ((TileEntitySapphireCrop) te).getBerryAmount();
    		
    		if(itemStack != null)
    		{
        		if(itemStack.getItem() == Base.itemSapphireBerry)
            	{
            		if(bAmt < 7)
            		{
            			bAmt++;
            			((TileEntitySapphireCrop) te).setBerryAmount(bAmt);
            			
                		if(!player.capabilities.isCreativeMode)
                			itemStack.stackSize--;
            		}
            		
            		return true;
            	}
//            	else if(itemStack.getItem() == Items.arrow)
//            	{
//            		if(!world.isRemote)
//            		{
//            			System.out.println(bAmt);
//            		}
//            		return true;
//            	}
            	else if(itemStack.getItem() == Items.shears && isShearable(te))
            	{	
            		ItemStack stack = new ItemStack(Base.itemSapphireBerry);
            		
            		if(!world.isRemote)
            		{
                        Random rand = new Random();
                        EntityItem item = player.entityDropItem(stack, 1.0F);
                        item.motionY += rand.nextFloat() * 0.05F;
                        item.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.2F;
                        item.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.2F;
            		}
            		
                    if(!player.capabilities.isCreativeMode)
                    	itemStack.damageItem(5, player);
                    
                    bAmt--;
                    ((TileEntitySapphireCrop) te).setBerryAmount(bAmt);
                    
            		return true;
            	}
            	else
            		return false;
    		}
    		else
    			return false;
    	}
    	else
    		return false;
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
    
    //Given berry amount, checks to see if shear-able
    //Custom Method
    public boolean isShearable(TileEntity te)
    {
    	if(te != null)
    	{
    		if(te instanceof TileEntitySapphireCrop)
    			te = (TileEntitySapphireCrop)te;
    		
    		bAmt = ((TileEntitySapphireCrop) te).getBerryAmount();
    	}
    	
    	if(bAmt > 0)
    		return true;
    	else
    		return false;
    }
    
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    //Custom name, previously 'func_149930_e'
    private void setDefaultDirection(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }
    
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
    }
	
    @Override
	public TileEntity createNewTileEntity(World world, int num)
	{
		return new TileEntitySapphireCrop();
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
