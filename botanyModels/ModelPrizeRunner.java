package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPrizeRunner extends ModelBase
{
  //fields
    ModelRenderer beakTop;
    ModelRenderer head;
    ModelRenderer neck;
    ModelRenderer beakBottom;
    ModelRenderer body;
    ModelRenderer leftLegThigh;
    ModelRenderer RightLegThigh;
    ModelRenderer rightLegTop;
    ModelRenderer leftLegTop;
    ModelRenderer leftFoot;
    ModelRenderer rightFoot;
    ModelRenderer tail;
    ModelRenderer tailLeft;
    ModelRenderer tailRight;
    ModelRenderer leftEyeBrow;
    ModelRenderer rightEyeBrow;
  
  public ModelPrizeRunner()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      beakTop = new ModelRenderer(this, 12, 9);
      beakTop.addBox(-2F, 0F, -6F, 4, 1, 6);
      beakTop.setRotationPoint(0F, 5F, -15F);
      beakTop.setTextureSize(64, 32);
      beakTop.mirror = true;
      setRotation(beakTop, 0F, 0F, 0F);
      head = new ModelRenderer(this, 32, 4);
      head.addBox(-3F, -5F, -6F, 6, 6, 6);
      head.setRotationPoint(0F, 7F, -9F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 56, 8);
      neck.addBox(-1F, -6F, -1F, 2, 6, 2);
      neck.setRotationPoint(0F, 8F, -4F);
      neck.setTextureSize(64, 32);
      neck.mirror = true;
      setRotation(neck, 1.308997F, 0F, 0F);
      beakBottom = new ModelRenderer(this, 50, 0);
      beakBottom.addBox(-1F, 0F, -5F, 2, 1, 5);
      beakBottom.setRotationPoint(0F, 6F, -15F);
      beakBottom.setTextureSize(64, 32);
      beakBottom.mirror = true;
      setRotation(beakBottom, 0F, 0F, 0F);
      body = new ModelRenderer(this, 8, 16);
      body.addBox(-4F, -1F, 0F, 8, 6, 10);
      body.setRotationPoint(0F, 8F, -5F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leftLegThigh = new ModelRenderer(this, 24, 0);
      leftLegThigh.addBox(0F, -2F, -3F, 2, 4, 5);
      leftLegThigh.setRotationPoint(3F, 13F, 1F);
      leftLegThigh.setTextureSize(64, 32);
      leftLegThigh.mirror = true;
      setRotation(leftLegThigh, 1.396263F, 0F, 0F);
      RightLegThigh = new ModelRenderer(this, 4, 17);
      RightLegThigh.addBox(-2F, -2F, -3F, 2, 4, 5);
      RightLegThigh.setRotationPoint(-3F, 13F, 1F);
      RightLegThigh.setTextureSize(64, 32);
      RightLegThigh.mirror = true;
      setRotation(RightLegThigh, 1.396263F, 0F, 0F);
      rightLegTop = new ModelRenderer(this, 40, 16);
      rightLegTop.addBox(-1F, 0F, -1F, 2, 8, 2);
      rightLegTop.setRotationPoint(-4F, 15F, 1F);
      rightLegTop.setTextureSize(64, 32);
      rightLegTop.mirror = true;
      setRotation(rightLegTop, 0F, 0F, 0F);
      leftLegTop = new ModelRenderer(this, 48, 16);
      leftLegTop.addBox(-1F, 0F, -1F, 2, 8, 2);
      leftLegTop.setRotationPoint(4F, 15F, 1F);
      leftLegTop.setTextureSize(64, 32);
      leftLegTop.mirror = true;
      setRotation(leftLegTop, 0F, 0F, 0F);
      leftFoot = new ModelRenderer(this, 2, 10);
      leftFoot.addBox(-2F, 0F, -3F, 4, 1, 4);
      leftFoot.setRotationPoint(4F, 23F, 1F);
      leftFoot.setTextureSize(64, 32);
      leftFoot.mirror = true;
      setRotation(leftFoot, 0F, 0F, 0F);
      rightFoot = new ModelRenderer(this, 8, 4);
      rightFoot.addBox(-2F, 0F, -3F, 4, 1, 4);
      rightFoot.setRotationPoint(-4F, 23F, 1F);
      rightFoot.setTextureSize(64, 32);
      rightFoot.mirror = true;
      setRotation(rightFoot, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 44, 16);
      tail.addBox(0F, -3F, 0F, 0, 6, 10);
      tail.setRotationPoint(0F, 7F, 5F);
      tail.setTextureSize(64, 32);
      tail.mirror = true;
      setRotation(tail, 0.2617994F, 0F, 0F);
      tailLeft = new ModelRenderer(this, 60, 16);
      tailLeft.addBox(-1F, -10F, 0F, 2, 10, 0);
      tailLeft.setRotationPoint(3F, 8F, 5F);
      tailLeft.setTextureSize(64, 32);
      tailLeft.mirror = true;
      setRotation(tailLeft, -0.7853982F, 0F, 0.7853982F);
      tailRight = new ModelRenderer(this, 56, 16);
      tailRight.addBox(-1F, -10F, 0F, 2, 10, 0);
      tailRight.setRotationPoint(-3F, 8F, 5F);
      tailRight.setTextureSize(64, 32);
      tailRight.mirror = true;
      setRotation(tailRight, -0.7853982F, 0F, -0.7853982F);
      leftEyeBrow = new ModelRenderer(this, 39, -5);
      leftEyeBrow.addBox(0F, 0F, 0F, 0, 1, 8);
      leftEyeBrow.setRotationPoint(3F, 4F, -13F);
      leftEyeBrow.setTextureSize(64, 32);
      leftEyeBrow.mirror = true;
      setRotation(leftEyeBrow, 0.5235988F, 0.1745329F, 0F);
      rightEyeBrow = new ModelRenderer(this, 39, -6);
      rightEyeBrow.addBox(0F, 0F, 0F, 0, 1, 8);
      rightEyeBrow.setRotationPoint(-3F, 4F, -13F);
      rightEyeBrow.setTextureSize(64, 32);
      rightEyeBrow.mirror = true;
      setRotation(rightEyeBrow, 0.5235988F, -0.1745329F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    beakTop.render(f5);
    head.render(f5);
    neck.render(f5);
    beakBottom.render(f5);
    body.render(f5);
    leftLegThigh.render(f5);
    RightLegThigh.render(f5);
    rightLegTop.render(f5);
    leftLegTop.render(f5);
    leftFoot.render(f5);
    rightFoot.render(f5);
    tail.render(f5);
    tailLeft.render(f5);
    tailRight.render(f5);
    leftEyeBrow.render(f5);
    rightEyeBrow.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    //Rotations
    this.leftLegThigh.rotateAngleX = (MathHelper.cos(f * 1.0F) * 1.4F * f1);
    this.RightLegThigh.rotateAngleX = -(MathHelper.cos(f * 1.0F) * 1.4F * f1);
    
    //Offsets
    
    
    //Legs and Feet (under thighs) <-- Offsets and Rotations
    this.leftLegTop.rotateAngleX = (MathHelper.cos(f * 1.0F) * 2.0F * f1);
    this.leftLegTop.offsetY = -(MathHelper.cos(f * 1.5F) * 0.2F * f1) - 0.04F;
    this.leftFoot.rotateAngleX = (MathHelper.cos(f * 1.0F) * 2.0F * f1);
    this.leftFoot.offsetZ = (MathHelper.cos(f * 1.0F) * 1.0F * f1);
    this.leftFoot.offsetY = -(MathHelper.sin(f * 2.0F) * 0.175F * f1) - 0.04F;
    this.rightLegTop.rotateAngleX = -(MathHelper.cos(f * 1.0F) * 2.0F * f1);
    this.rightLegTop.offsetY = -(MathHelper.cos(f * 2.0F) * 0.2F * f1) - 0.04F;
    this.rightFoot.rotateAngleX = -(MathHelper.cos(f * 1.0F) * 2.0F * f1);
    this.rightFoot.offsetZ = -(MathHelper.cos(f * 1.0F) * 1.0F * f1);
    this.rightFoot.offsetY = -(MathHelper.sin(f * 2.0F) * 0.175F * f1) - 0.04F;
  }

}
