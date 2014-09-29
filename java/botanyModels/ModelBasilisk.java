package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBasilisk extends ModelBase
{
  //fields
    ModelRenderer bodyTorso;
    ModelRenderer bodyTop;
    ModelRenderer bodyBottom;
    ModelRenderer tailTop;
    ModelRenderer bellyTop;
    ModelRenderer bellyBottom;
    ModelRenderer backOne;
    ModelRenderer backTwo;
    ModelRenderer head;
    ModelRenderer neck;
    ModelRenderer jaw;
    ModelRenderer topFangRight;
    ModelRenderer topFangLeft;
    ModelRenderer bottomFangLeft;
    ModelRenderer bottomFangRight;
    ModelRenderer tailOne;
    ModelRenderer tailTwo;
    ModelRenderer tailThree;
    ModelRenderer tailFour;
    ModelRenderer tailEndOne;
    ModelRenderer tailEndTwo;
    ModelRenderer tailEndThree;
    ModelRenderer tailEndFour;
    ModelRenderer tailEndFive;
    ModelRenderer alphaHood;
    ModelRenderer hoodTop;
    ModelRenderer hoodLower;
  
  public ModelBasilisk()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      bodyTorso = new ModelRenderer(this, 0, 47);
      bodyTorso.addBox(-6F, 0F, -4F, 12, 13, 4);
      bodyTorso.setRotationPoint(0F, -7F, 0F);
      bodyTorso.setTextureSize(128, 64);
      bodyTorso.mirror = true;
      setRotation(bodyTorso, 0F, 0F, 0F);
      bodyTop = new ModelRenderer(this, 32, 52);
      bodyTop.addBox(-5F, -6F, -6F, 10, 6, 6);
      bodyTop.setRotationPoint(0F, -7F, 0F);
      bodyTop.setTextureSize(128, 64);
      bodyTop.mirror = true;
      setRotation(bodyTop, 0.7853982F, 0F, 0F);
      bodyBottom = new ModelRenderer(this, 64, 48);
      bodyBottom.addBox(-5F, 10F, -10F, 10, 12, 4);
      bodyBottom.setRotationPoint(0F, -7F, 0F);
      bodyBottom.setTextureSize(128, 64);
      bodyBottom.mirror = true;
      setRotation(bodyBottom, 0.5235988F, 0F, 0F);
      tailTop = new ModelRenderer(this, 64, 48);
      tailTop.addBox(-5F, 14F, -20F, 10, 12, 4);
      tailTop.setRotationPoint(0F, -7F, 0F);
      tailTop.setTextureSize(128, 64);
      tailTop.mirror = true;
      setRotation(tailTop, 1.047198F, 0F, 0F);
      bellyTop = new ModelRenderer(this, 92, 48);
      bellyTop.addBox(-3F, 3F, -6F, 6, 12, 4);
      bellyTop.setRotationPoint(0F, -7F, 0F);
      bellyTop.setTextureSize(128, 64);
      bellyTop.mirror = true;
      setRotation(bellyTop, 0F, 0F, 0F);
      bellyBottom = new ModelRenderer(this, 60, 0);
      bellyBottom.addBox(-3F, 12F, -11F, 6, 9, 5);
      bellyBottom.setRotationPoint(0F, -7F, 0F);
      bellyBottom.setTextureSize(128, 64);
      bellyBottom.mirror = true;
      setRotation(bellyBottom, 0.4014257F, 0F, 0F);
      backOne = new ModelRenderer(this, 110, 0);
      backOne.addBox(-3F, 8F, -8F, 6, 20, 3);
      backOne.setRotationPoint(0F, -7F, 0F);
      backOne.setTextureSize(128, 64);
      backOne.mirror = true;
      setRotation(backOne, 0.6108652F, 0F, 0F);
      backTwo = new ModelRenderer(this, 110, 0);
      backTwo.addBox(-3F, 0F, 0F, 6, 30, 3);
      backTwo.setRotationPoint(0F, 19F, 10F);
      backTwo.setTextureSize(128, 64);
      backTwo.mirror = true;
      setRotation(backTwo, 1.48353F, 0F, 0F);
      head = new ModelRenderer(this, 0, 31);
      head.addBox(-4F, -10F, -4F, 8, 10, 6);
      head.setRotationPoint(0F, -10F, -8F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 1.745329F, 0F, 0F);
      neck = new ModelRenderer(this, 28, 43);
      neck.addBox(-5F, -4F, -8F, 10, 4, 4);
      neck.setRotationPoint(0F, -7F, 0F);
      neck.setTextureSize(128, 64);
      neck.mirror = true;
      setRotation(neck, 0F, 0F, 0F);
      jaw = new ModelRenderer(this, 28, 32);
      jaw.addBox(-3F, 4F, -9F, 6, 2, 9);
      jaw.setRotationPoint(0F, -10F, -8F);
      jaw.setTextureSize(128, 64);
      jaw.mirror = true;
      setRotation(jaw, 0.2094395F, 0F, 0F);
      topFangRight = new ModelRenderer(this, 0, 31);
      topFangRight.addBox(-3.8F, 5F, -9F, 1, 2, 2);
      topFangRight.setRotationPoint(0F, -10F, -8F);
      topFangRight.setTextureSize(128, 64);
      topFangRight.mirror = true;
      setRotation(topFangRight, 0F, 0F, 0F);
      topFangLeft = new ModelRenderer(this, 0, 31);
      topFangLeft.addBox(2.8F, 5F, -9F, 1, 2, 2);
      topFangLeft.setRotationPoint(0F, -10F, -8F);
      topFangLeft.setTextureSize(128, 64);
      topFangLeft.mirror = true;
      setRotation(topFangLeft, 0F, 0F, 0F);
      bottomFangLeft = new ModelRenderer(this, 22, 31);
      bottomFangLeft.addBox(2.8F, 6F, -9F, 1, 3, 1);
      bottomFangLeft.setRotationPoint(0F, -10F, -8F);
      bottomFangLeft.setTextureSize(128, 64);
      bottomFangLeft.mirror = true;
      setRotation(bottomFangLeft, 0.0872665F, 0F, 0F);
      bottomFangRight = new ModelRenderer(this, 22, 31);
      bottomFangRight.addBox(-3.8F, 7F, -9F, 1, 3, 1);
      bottomFangRight.setRotationPoint(0F, -11F, -8F);
      bottomFangRight.setTextureSize(128, 64);
      bottomFangRight.mirror = true;
      setRotation(bottomFangRight, 0.0872665F, 0F, 0F);
      tailOne = new ModelRenderer(this, 58, 32);
      tailOne.addBox(-5F, 0F, 0F, 10, 4, 11);
      tailOne.setRotationPoint(0F, 19F, 13F);
      tailOne.setTextureSize(128, 64);
      tailOne.mirror = true;
      setRotation(tailOne, -0.0872665F, 0F, 0F);
      tailTwo = new ModelRenderer(this, 58, 32);
      tailTwo.addBox(-5F, 1F, 10F, 10, 4, 11);
      tailTwo.setRotationPoint(0F, 19F, 13F);
      tailTwo.setTextureSize(128, 64);
      tailTwo.mirror = true;
      setRotation(tailTwo, 0F, -0.0174533F, 0F);
      tailThree = new ModelRenderer(this, 58, 32);
      tailThree.addBox(-5F, 1F, 21F, 10, 4, 11);
      tailThree.setRotationPoint(0F, 19F, 13F);
      tailThree.setTextureSize(128, 64);
      tailThree.mirror = true;
      setRotation(tailThree, 0F, 0F, 0F);
      tailFour = new ModelRenderer(this, 58, 32);
      tailFour.addBox(-5F, 1F, 32F, 10, 4, 11);
      tailFour.setRotationPoint(0F, 19F, 13F);
      tailFour.setTextureSize(128, 64);
      tailFour.mirror = true;
      setRotation(tailFour, 0F, 0.0174533F, 0F);
      tailEndOne = new ModelRenderer(this, 74, 17);
      tailEndOne.addBox(-4F, 0F, 0F, 8, 4, 10);
      tailEndOne.setRotationPoint(0F, 20F, 56F);
      tailEndOne.setTextureSize(128, 64);
      tailEndOne.mirror = true;
      setRotation(tailEndOne, 0F, 0.0523599F, 0F);
      tailEndTwo = new ModelRenderer(this, 74, 17);
      tailEndTwo.addBox(-4F, 0F, 10F, 8, 4, 10);
      tailEndTwo.setRotationPoint(0F, 20F, 56F);
      tailEndTwo.setTextureSize(128, 64);
      tailEndTwo.mirror = true;
      setRotation(tailEndTwo, 0F, -0.0174533F, 0F);
      tailEndThree = new ModelRenderer(this, 100, 35);
      tailEndThree.addBox(-3F, 0F, 0F, 6, 4, 8);
      tailEndThree.setRotationPoint(0F, 20F, 76F);
      tailEndThree.setTextureSize(128, 64);
      tailEndThree.mirror = true;
      setRotation(tailEndThree, 0F, 0F, 0F);
      tailEndFour = new ModelRenderer(this, 100, 35);
      tailEndFour.addBox(-3F, 0F, 8F, 6, 4, 8);
      tailEndFour.setRotationPoint(0F, 20F, 76F);
      tailEndFour.setTextureSize(128, 64);
      tailEndFour.mirror = true;
      setRotation(tailEndFour, 0F, -0.0174533F, 0F);
      tailEndFive = new ModelRenderer(this, 82, 0);
      tailEndFive.addBox(-2F, 0F, 0F, 4, 4, 10);
      tailEndFive.setRotationPoint(0F, 20F, 92F);
      tailEndFive.setTextureSize(128, 64);
      tailEndFive.mirror = true;
      setRotation(tailEndFive, 0F, 0F, 0F);
      alphaHood = new ModelRenderer(this, 0, 0);
      alphaHood.addBox(-13F, 3F, -2F, 26, 6, 3);
      alphaHood.setRotationPoint(0F, -7F, 0F);
      alphaHood.setTextureSize(128, 64);
      alphaHood.mirror = true;
      setRotation(alphaHood, 0F, 0F, 0F);
      hoodTop = new ModelRenderer(this, 0, 9);
      hoodTop.addBox(-10F, -3F, -3F, 20, 6, 3);
      hoodTop.setRotationPoint(0F, -7F, 0F);
      hoodTop.setTextureSize(128, 64);
      hoodTop.mirror = true;
      setRotation(hoodTop, 0.3316126F, 0F, 0F);
      hoodLower = new ModelRenderer(this, 0, 18);
      hoodLower.addBox(-10F, 9F, 0F, 20, 6, 3);
      hoodLower.setRotationPoint(0F, -7F, -2F);
      hoodLower.setTextureSize(128, 64);
      hoodLower.mirror = true;
      setRotation(hoodLower, -0.0349066F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    bodyTorso.render(f5);
    bodyTop.render(f5);
    bodyBottom.render(f5);
    tailTop.render(f5);
    bellyTop.render(f5);
    bellyBottom.render(f5);
    backOne.render(f5);
    backTwo.render(f5);
    head.render(f5);
    neck.render(f5);
    jaw.render(f5);
    topFangRight.render(f5);
    topFangLeft.render(f5);
    bottomFangLeft.render(f5);
    bottomFangRight.render(f5);
    tailOne.render(f5);
    tailTwo.render(f5);
    tailThree.render(f5);
    tailFour.render(f5);
    tailEndOne.render(f5);
    tailEndTwo.render(f5);
    tailEndThree.render(f5);
    tailEndFour.render(f5);
    tailEndFive.render(f5);
    alphaHood.render(f5);
    hoodTop.render(f5);
    hoodLower.render(f5);
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
  }

}