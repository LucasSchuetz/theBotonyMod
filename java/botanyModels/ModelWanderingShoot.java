package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWanderingShoot extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer stemOne;
    ModelRenderer stemTwo;
    ModelRenderer stemThree;
    ModelRenderer stemFour;
    ModelRenderer body;
    ModelRenderer leftLegFront;
    ModelRenderer leftLegMiddle;
    ModelRenderer leftLegBack;
    ModelRenderer rightLegFront;
    ModelRenderer rightLegMiddle;
    ModelRenderer rightLegBack;
    ModelRenderer leafLeft;
    ModelRenderer leafRight;
    ModelRenderer bodyLeafLeft;
    ModelRenderer bodyLeafRight;
  
  public ModelWanderingShoot()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 1);
      head.addBox(-3F, -3F, -12F, 6, 6, 12);
      head.setRotationPoint(0F, 3F, -6F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0.4363323F, 0F, 0F);
      stemOne = new ModelRenderer(this, 0, 19);
      stemOne.addBox(-1F, -1F, -8F, 2, 2, 8);
      stemOne.setRotationPoint(0F, 3F, 1F);
      stemOne.setTextureSize(64, 32);
      stemOne.mirror = true;
      setRotation(stemOne, -0.0523599F, 0F, 0F);
      stemTwo = new ModelRenderer(this, 20, 19);
      stemTwo.addBox(-1F, -1F, -8F, 2, 2, 8);
      stemTwo.setRotationPoint(0F, 8F, 6F);
      stemTwo.setTextureSize(64, 32);
      stemTwo.mirror = true;
      setRotation(stemTwo, -0.7504916F, 0F, 0F);
      stemThree = new ModelRenderer(this, 40, 19);
      stemThree.addBox(-1F, -1F, 0F, 2, 2, 8);
      stemThree.setRotationPoint(0F, 15F, 5F);
      stemThree.setTextureSize(64, 32);
      stemThree.mirror = true;
      setRotation(stemThree, 1.500983F, 0F, 0F);
      stemFour = new ModelRenderer(this, 0, 1);
      stemFour.addBox(-1F, -9F, -1F, 2, 10, 2);
      stemFour.setRotationPoint(0F, 19F, -2F);
      stemFour.setTextureSize(64, 32);
      stemFour.mirror = true;
      setRotation(stemFour, -0.9948377F, 0F, 0F);
      body = new ModelRenderer(this, 24, 0);
      body.addBox(-4F, -2F, -4F, 8, 4, 9);
      body.setRotationPoint(0F, 20F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leftLegFront = new ModelRenderer(this, 0, 19);
      leftLegFront.addBox(0F, 0F, -1F, 1, 7, 1);
      leftLegFront.setRotationPoint(3F, 21F, -2F);
      leftLegFront.setTextureSize(64, 32);
      leftLegFront.mirror = true;
      setRotation(leftLegFront, 0F, 0.7853982F, -1.134464F);
      leftLegMiddle = new ModelRenderer(this, 4, 19);
      leftLegMiddle.addBox(0F, 0F, 0F, 1, 7, 1);
      leftLegMiddle.setRotationPoint(3F, 21F, 0F);
      leftLegMiddle.setTextureSize(64, 32);
      leftLegMiddle.mirror = true;
      setRotation(leftLegMiddle, 0F, 0F, -1.134464F);
      leftLegBack = new ModelRenderer(this, 12, 19);
      leftLegBack.addBox(0F, 0F, 0F, 1, 7, 1);
      leftLegBack.setRotationPoint(3F, 21F, 4F);
      leftLegBack.setTextureSize(64, 32);
      leftLegBack.mirror = true;
      setRotation(leftLegBack, 1.134464F, 0.7853982F, 0F);
      rightLegFront = new ModelRenderer(this, 16, 19);
      rightLegFront.addBox(-1F, 0F, -1F, 1, 7, 1);
      rightLegFront.setRotationPoint(-3F, 21F, -2F);
      rightLegFront.setTextureSize(64, 32);
      rightLegFront.mirror = true;
      setRotation(rightLegFront, 0F, -0.7853982F, 1.134464F);
      rightLegMiddle = new ModelRenderer(this, 20, 19);
      rightLegMiddle.addBox(-1F, 0F, 0F, 1, 7, 1);
      rightLegMiddle.setRotationPoint(-3F, 21F, 0F);
      rightLegMiddle.setTextureSize(64, 32);
      rightLegMiddle.mirror = true;
      setRotation(rightLegMiddle, 0F, 0F, 1.134464F);
      rightLegBack = new ModelRenderer(this, 24, 19);
      rightLegBack.addBox(-1F, 0F, 0F, 1, 7, 1);
      rightLegBack.setRotationPoint(-3F, 21F, 4F);
      rightLegBack.setTextureSize(64, 32);
      rightLegBack.mirror = true;
      setRotation(rightLegBack, 1.134464F, -0.7853982F, 0F);
      leafLeft = new ModelRenderer(this, 32, 19);
      leafLeft.addBox(-6F, 0F, 0F, 6, 8, 0);
      leafLeft.setRotationPoint(0F, 13F, 5F);
      leafLeft.setTextureSize(64, 32);
      leafLeft.mirror = true;
      setRotation(leafLeft, 0F, 0F, -2.356194F);
      leafRight = new ModelRenderer(this, 49, 0);
      leafRight.addBox(0F, 0F, 0F, 6, 8, 0);
      leafRight.setRotationPoint(0F, 13F, 5F);
      leafRight.setTextureSize(64, 32);
      leafRight.mirror = true;
      setRotation(leafRight, 0F, 0F, 2.356194F);
      bodyLeafLeft = new ModelRenderer(this, 0, 29);
      bodyLeafLeft.addBox(0F, 0F, 0F, 4, 3, 0);
      bodyLeafLeft.setRotationPoint(4F, 18F, -2F);
      bodyLeafLeft.setTextureSize(64, 32);
      bodyLeafLeft.mirror = true;
      setRotation(bodyLeafLeft, 0F, -0.7853982F, -0.7853982F);
      bodyLeafRight = new ModelRenderer(this, 8, 29);
      bodyLeafRight.addBox(-4F, 0F, 0F, 4, 3, 0);
      bodyLeafRight.setRotationPoint(-4F, 18F, -2F);
      bodyLeafRight.setTextureSize(64, 32);
      bodyLeafRight.mirror = true;
      setRotation(bodyLeafRight, 0F, 0.7853982F, 0.7853982F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    stemOne.render(f5);
    stemTwo.render(f5);
    stemThree.render(f5);
    stemFour.render(f5);
    body.render(f5);
    leftLegFront.render(f5);
    leftLegMiddle.render(f5);
    leftLegBack.render(f5);
    rightLegFront.render(f5);
    rightLegMiddle.render(f5);
    rightLegBack.render(f5);
    leafLeft.render(f5);
    leafRight.render(f5);
    bodyLeafLeft.render(f5);
    bodyLeafRight.render(f5);
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
    
    //Leg movement
    this.leftLegBack.rotateAngleZ = -1.0F;
    this.leftLegBack.rotateAngleX = (MathHelper.cos(f * 1.5F) * 1.2F * f1);
    this.leftLegFront.rotateAngleX = -(MathHelper.cos(f * 1.5F) * 1.2F * f1);
    this.leftLegMiddle.rotateAngleX = (MathHelper.cos(f * 1.5F) * 1.2F * f1);
    this.rightLegBack.rotateAngleZ = 1.0F;
    this.rightLegBack.rotateAngleX = -(MathHelper.cos(f * 1.5F) * 1.2F * f1);
    this.rightLegFront.rotateAngleX = (MathHelper.cos(f * 1.5F) * 1.2F * f1);
    this.rightLegMiddle.rotateAngleX = -(MathHelper.cos(f * 1.5F) * 1.2F * f1);
    
    //Head movement
    this.stemOne.rotateAngleX = (MathHelper.cos(f * 1.5F) * 0.6F * f1);
    this.head.offsetY = (MathHelper.cos(f * 1.5F) * 0.2F * f1);
  }

}
