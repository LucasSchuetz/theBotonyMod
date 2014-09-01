package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import botanyEntity.EntityMongrel;

public class ModelMongrel extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer snout;
    ModelRenderer mouth;
    ModelRenderer fangLeft;
    ModelRenderer fangRight;
    ModelRenderer bodyUpper;
    ModelRenderer bodyMiddle;
    ModelRenderer earLeft;
    ModelRenderer earRight;
    ModelRenderer bodyLower;
    ModelRenderer frontLegLeft;
    ModelRenderer frontLegRight;
    ModelRenderer backLegLeft;
    ModelRenderer backLegRight;
    ModelRenderer tail;
  
  public ModelMongrel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 38, 0);
      head.addBox(-3F, -3F, -7F, 6, 6, 7);
      head.setRotationPoint(0F, 14F, -9F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      snout = new ModelRenderer(this, 20, 5);
      snout.addBox(-2F, 0F, -11F, 4, 3, 4);
      snout.setRotationPoint(0F, 14F, -9F);
      snout.setTextureSize(64, 32);
      snout.mirror = true;
      setRotation(snout, 0F, 0F, 0F);
      mouth = new ModelRenderer(this, 29, 0);
      mouth.addBox(-2F, 3F, -10F, 4, 1, 4);
      mouth.setRotationPoint(0F, 14F, -9F);
      mouth.setTextureSize(64, 32);
      mouth.mirror = true;
      setRotation(mouth, 0F, 0F, 0F);
      fangLeft = new ModelRenderer(this, 58, 0);
      fangLeft.addBox(3F, -3F, -9F, 2, 1, 1);
      fangLeft.setRotationPoint(0F, 14F, -9F);
      fangLeft.setTextureSize(64, 32);
      fangLeft.mirror = true;
      setRotation(fangLeft, 0.0349066F, 0F, 1.623156F);
      fangRight = new ModelRenderer(this, 58, 0);
      fangRight.addBox(3F, 1.5F, -9F, 2, 1, 1);
      fangRight.setRotationPoint(0F, 14F, -9F);
      fangRight.setTextureSize(64, 32);
      fangRight.mirror = true;
      setRotation(fangRight, 0.0349066F, 0F, 1.518436F);
      bodyUpper = new ModelRenderer(this, 34, 16);
      bodyUpper.addBox(-4F, -4F, -5F, 8, 9, 7);
      bodyUpper.setRotationPoint(0F, 13F, -4F);
      bodyUpper.setTextureSize(64, 32);
      bodyUpper.mirror = true;
      setRotation(bodyUpper, 0F, 0F, 0F);
      bodyMiddle = new ModelRenderer(this, 0, 4);
      bodyMiddle.addBox(-3F, -3F, 0F, 6, 6, 8);
      bodyMiddle.setRotationPoint(0F, 13F, -3F);
      bodyMiddle.setTextureSize(64, 32);
      bodyMiddle.mirror = true;
      setRotation(bodyMiddle, -0.1745329F, 0F, 0F);
      earLeft = new ModelRenderer(this, 58, 3);
      earLeft.addBox(0F, -6F, -4F, 2, 3, 1);
      earLeft.setRotationPoint(0F, 14F, -9F);
      earLeft.setTextureSize(64, 32);
      earLeft.mirror = true;
      setRotation(earLeft, 0F, -0.0174533F, 0.2094395F);
      earRight = new ModelRenderer(this, 58, 3);
      earRight.addBox(-2F, -6F, -4F, 2, 3, 1);
      earRight.setRotationPoint(0F, 14F, -9F);
      earRight.setTextureSize(64, 32);
      earRight.mirror = true;
      setRotation(earRight, 0F, 0.0174533F, -0.2094395F);
      bodyLower = new ModelRenderer(this, 0, 18);
      bodyLower.addBox(-4F, -4F, 0F, 8, 7, 6);
      bodyLower.setRotationPoint(0F, 15F, 3F);
      bodyLower.setTextureSize(64, 32);
      bodyLower.mirror = true;
      setRotation(bodyLower, 0F, 0F, 0F);
      frontLegLeft = new ModelRenderer(this, 0, 0);
      frontLegLeft.addBox(-1F, 0F, -2F, 2, 8, 2);
      frontLegLeft.setRotationPoint(3F, 16F, -6F);
      frontLegLeft.setTextureSize(64, 32);
      frontLegLeft.mirror = true;
      setRotation(frontLegLeft, 0F, 0F, 0F);
      frontLegRight = new ModelRenderer(this, 0, 0);
      frontLegRight.addBox(-1F, 0F, -2F, 2, 8, 2);
      frontLegRight.setRotationPoint(-3F, 16F, -6F);
      frontLegRight.setTextureSize(64, 32);
      frontLegRight.mirror = true;
      setRotation(frontLegRight, 0F, 0F, 0F);
      backLegLeft = new ModelRenderer(this, 0, 0);
      backLegLeft.addBox(-1F, 0F, -1F, 2, 8, 2);
      backLegLeft.setRotationPoint(3F, 16F, 7F);
      backLegLeft.setTextureSize(64, 32);
      backLegLeft.mirror = true;
      setRotation(backLegLeft, 0F, 0F, 0F);
      backLegRight = new ModelRenderer(this, 0, 0);
      backLegRight.addBox(-1F, 0F, -1F, 2, 8, 2);
      backLegRight.setRotationPoint(-3F, 16F, 7F);
      backLegRight.setTextureSize(64, 32);
      backLegRight.mirror = true;
      setRotation(backLegRight, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 28, 12);
      tail.addBox(-1F, -1F, 0F, 2, 8, 2);
      tail.setRotationPoint(0F, 13F, 8F);
      tail.setTextureSize(64, 32);
      tail.mirror = true;
      setRotation(tail, 0.6632251F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    snout.render(f5);
    mouth.render(f5);
    fangLeft.render(f5);
    fangRight.render(f5);
    bodyUpper.render(f5);
    bodyMiddle.render(f5);
    earLeft.render(f5);
    earRight.render(f5);
    bodyLower.render(f5);
    frontLegLeft.render(f5);
    frontLegRight.render(f5);
    backLegLeft.render(f5);
    backLegRight.render(f5);
    tail.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
  {
      EntityMongrel entitywolf = (EntityMongrel)p_78086_1_;

      if (entitywolf.isAngry())
      {
          this.tail.rotateAngleY = 0.0F;
      }
      else
      {
          this.tail.rotateAngleY = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
      }

//      if (entitywolf.isSitting())
//      {
////          this.bodyLower.setRotationPoint(0.0F, 18.0F, 0.0F);
//          this.bodyLower.rotateAngleX = ((float)Math.PI / 4F);
////          this.bodyMiddle.setRotationPoint(0.0F, 18.0F, 0.0F);
//          this.bodyMiddle.rotateAngleX = ((float)Math.PI / 4F);
////          this.bodyUpper.setRotationPoint(0.0F, 18.0F, 0.0F);
//          this.bodyUpper.rotateAngleX = ((float)Math.PI / 4F);
//          this.tail.setRotationPoint(-1.0F, 21.0F, 6.0F);
//          this.frontLegLeft.setRotationPoint(-2.5F, 22.0F, 2.0F);
//          this.frontLegLeft.rotateAngleX = ((float)Math.PI * 3F / 2F);
//          this.frontLegRight.setRotationPoint(0.5F, 22.0F, 2.0F);
//          this.frontLegRight.rotateAngleX = ((float)Math.PI * 3F / 2F);
//          this.backLegLeft.rotateAngleX = 5.811947F;
//          this.backLegLeft.setRotationPoint(-2.49F, 17.0F, -4.0F);
//          this.backLegRight.rotateAngleX = 5.811947F;
//          this.backLegRight.setRotationPoint(0.51F, 17.0F, -4.0F);
//      }
//      else
//      {
////          this.bodyLower.setRotationPoint(0.0F, 14.0F, 2.0F);
//          this.bodyLower.rotateAngleX = ((float)Math.PI / 2F);
////          this.bodyMiddle.setRotationPoint(0.0F, 14.0F, 2.0F);
//          this.bodyMiddle.rotateAngleX = ((float)Math.PI / 2F);
////          this.bodyUpper.setRotationPoint(0.0F, 14.0F, 2.0F);
//          this.bodyUpper.rotateAngleX = ((float)Math.PI / 2F);
//          this.tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
//          this.frontLegLeft.setRotationPoint(-2.5F, 16.0F, 7.0F);
//          this.frontLegRight.setRotationPoint(0.5F, 16.0F, 7.0F);
//          this.backLegLeft.setRotationPoint(-2.5F, 16.0F, -4.0F);
//          this.backLegRight.setRotationPoint(0.5F, 16.0F, -4.0F);
//          this.frontLegLeft.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
//          this.frontLegRight.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_78086_3_;
//          this.backLegLeft.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_78086_3_;
//          this.backLegRight.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
//      }

      this.head.rotateAngleZ = entitywolf.getInterestedAngle(p_78086_4_) + entitywolf.getShakeAngle(p_78086_4_, 0.0F);
      this.bodyUpper.rotateAngleZ = entitywolf.getShakeAngle(p_78086_4_, -0.16F);
      this.bodyMiddle.rotateAngleZ = entitywolf.getShakeAngle(p_78086_4_, -0.16F);
      this.tail.rotateAngleZ = entitywolf.getShakeAngle(p_78086_4_, -0.2F);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.backLegLeft.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.backLegRight.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.frontLegLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.frontLegRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    
    this.tail.rotateAngleY = (MathHelper.cos(f * 1.5F) * 1.0F * f1);
    this.tail.rotateAngleX = 1.0F;
  }
}