package botanyEntity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySapphireBerry extends EntityThrowable implements IProjectile
{
    private double damage = 2.0D;
    private boolean lawnched = false; //Checks if thrown by the Sapphire Lawncher (has different onImpact characteristics)
	
    public EntitySapphireBerry(World par1World)
    {
        super(par1World);
    }

    public EntitySapphireBerry(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntitySapphireBerry(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    
    public EntitySapphireBerry(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
        super(par1World);
        this.renderDistanceWeight = 10.0D;

        this.posY = par2EntityLivingBase.posY + (double)par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
        double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
        double d1 = par3EntityLivingBase.boundingBox.minY + (double)(par3EntityLivingBase.height / 3.0F) - this.posY;
        double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);

        if (d3 >= 1.0E-7D)
        {
            float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
            this.yOffset = 0.0F;
            float f4 = (float)d3 * 0.2F;
            this.setThrowableHeading(d0, d1 + (double)f4, d2, par4, par5);
        }
    }
    
    public void setThrownByLawncher(boolean that)
    {
    	lawnched = that;
    }
    
    public void setDamage(double par1)
    {
        this.damage = par1;
    }

    public double getDamage()
    {
        return this.damage;
    }

    protected void onImpact(MovingObjectPosition impact)
    {
    	//Not thrown by the Sapphire Lawncher
    	if(!lawnched)
    	{
        	if (impact.entityHit != null)
            {
            	//Throws monsters in the air and does dmg if not enderman
//                if(impact.entityHit instanceof EntityZombie ||
//                   impact.entityHit instanceof EntitySkeleton ||
//                   impact.entityHit instanceof EntityCreeper ||
//                   impact.entityHit instanceof EntitySpider ||
//                   impact.entityHit instanceof EntityEnderman ||
//                   impact.entityHit instanceof EntitySlime)
//                {
//                	if(!(impact.entityHit instanceof EntityEnderman))
//                		impact.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1.0F);
//                	impact.entityHit.motionY += 1;
//                }
//                else if(impact.entityHit instanceof EntityGhast)
//                {
//                	impact.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1.0F);
//                	impact.entityHit.motionY -= 1;
//                }
                if(impact.entityHit instanceof EntityPlayer)
                {
                	EntityLivingBase entitylivingbase = (EntityLivingBase)impact.entityHit;
                	
                	entitylivingbase.addPotionEffect(new PotionEffect(10, 10, 2));
                }
//                else //if any other entity
//                {
//                	EntityPig entityRidden = new EntityPig(this.worldObj);
//                	EntityBarbedSpike entityRiding = new EntityBarbedSpike(this.worldObj);
//                	entityRidden.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
//                	this.worldObj.spawnEntityInWorld(entityRidden);
//                	
//                	entityRiding.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
//                    this.worldObj.spawnEntityInWorld(entityRiding);
//                    entityRiding.mountEntity(entityRidden);
//                }//spawns a pig and a barbed spike, freakin' pigs with freakin' tentacles on their backs!
            }
    	}
    	else //thrown by Sapphire Lawncher
    	{
    		if(impact.entityHit != null)
    		{
    			impact.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2.0F);
    		}
    	}

        if (!this.worldObj.isRemote)
        {
        	//do something...or nothing? Not sure...
        }
        
    	for(int i = 0; i < 80; ++i)
    	{
    		this.worldObj.spawnParticle("largeexplode", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
    	}

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
