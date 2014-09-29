package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSapphireLawncher extends ModelBase
{
  //fields
    ModelRenderer baseOne;
    ModelRenderer baseTwo;
    ModelRenderer baseThree;
    ModelRenderer berryOne;
    ModelRenderer berryTwo;
    ModelRenderer berryFour;
    ModelRenderer berryThree;
    ModelRenderer berryFive;
    ModelRenderer berrySix;
    ModelRenderer berrySeven;
    ModelRenderer base;
    ModelRenderer legOne;
    ModelRenderer legTwo;
    ModelRenderer legThree;
    ModelRenderer legFour;
    ModelRenderer legFive;
    ModelRenderer legSix;
    ModelRenderer legSeven;
    ModelRenderer legEight;
    ModelRenderer top;
    ModelRenderer stem;
    ModelRenderer leafRight;
    ModelRenderer leafLeft;
    ModelRenderer head;
    ModelRenderer headSide;
  
  public ModelSapphireLawncher()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      baseOne = new ModelRenderer(this, 0, 25);
      baseOne.addBox(-2F, -3.5F, -2F, 4, 3, 4);
      baseOne.setRotationPoint(0F, 13F, 0F);
      baseOne.setTextureSize(64, 32);
      baseOne.mirror = true;
      setRotation(baseOne, -1.186824F, 0F, 0F);
      baseTwo = new ModelRenderer(this, 0, 0);
      baseTwo.addBox(-5F, -4F, -5F, 10, 1, 10);
      baseTwo.setRotationPoint(0F, 13F, 0F);
      baseTwo.setTextureSize(64, 32);
      baseTwo.mirror = true;
      setRotation(baseTwo, -1.186824F, -0.2617994F, 0.7853982F);
      baseThree = new ModelRenderer(this, 0, 11);
      baseThree.addBox(-5F, -5F, -5F, 10, 1, 10);
      baseThree.setRotationPoint(0F, 13F, 0F);
      baseThree.setTextureSize(64, 32);
      baseThree.mirror = true;
      setRotation(baseThree, -1.308997F, 0F, 0F);
      berryOne = new ModelRenderer(this, 0, 0);
      berryOne.addBox(-1F, -6F, -4F, 2, 1, 2);
      berryOne.setRotationPoint(0F, 13F, 0F);
      berryOne.setTextureSize(64, 32);
      berryOne.mirror = true;
      setRotation(berryOne, -1.308997F, 0F, 0F);
      berryTwo = new ModelRenderer(this, 0, 0);
      berryTwo.addBox(2F, -6F, -3F, 2, 1, 2);
      berryTwo.setRotationPoint(0F, 13F, 0F);
      berryTwo.setTextureSize(64, 32);
      berryTwo.mirror = true;
      setRotation(berryTwo, -1.308997F, 0F, 0F);
      berryFour = new ModelRenderer(this, 0, 0);
      berryFour.addBox(-1F, -6F, -1F, 2, 1, 2);
      berryFour.setRotationPoint(0F, 13F, 0F);
      berryFour.setTextureSize(64, 32);
      berryFour.mirror = true;
      setRotation(berryFour, -1.308997F, 0F, 0F);
      berryThree = new ModelRenderer(this, 0, 0);
      berryThree.addBox(-4F, -6F, -3F, 2, 1, 2);
      berryThree.setRotationPoint(0F, 13F, 0F);
      berryThree.setTextureSize(64, 32);
      berryThree.mirror = true;
      setRotation(berryThree, -1.308997F, 0F, 0F);
      berryThree.mirror = false;
      berryFive = new ModelRenderer(this, 0, 0);
      berryFive.addBox(-1F, -6F, 2F, 2, 1, 2);
      berryFive.setRotationPoint(0F, 13F, 0F);
      berryFive.setTextureSize(64, 32);
      berryFive.mirror = true;
      setRotation(berryFive, -1.308997F, 0F, 0F);
      berrySix = new ModelRenderer(this, 0, 0);
      berrySix.addBox(2F, -6F, 1F, 2, 1, 2);
      berrySix.setRotationPoint(0F, 13F, 0F);
      berrySix.setTextureSize(64, 32);
      berrySix.mirror = true;
      setRotation(berrySix, -1.308997F, 0F, 0F);
      berrySeven = new ModelRenderer(this, 0, 0);
      berrySeven.addBox(-4F, -6F, 1F, 2, 1, 2);
      berrySeven.setRotationPoint(0F, 13F, 0F);
      berrySeven.setTextureSize(64, 32);
      berrySeven.mirror = true;
      setRotation(berrySeven, -1.308997F, 0F, 0F);
      base = new ModelRenderer(this, 30, 11);
      base.addBox(-3F, 4F, -3F, 6, 2, 6);
      base.setRotationPoint(0F, 13F, 0F);
      base.setTextureSize(64, 32);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      legOne = new ModelRenderer(this, 30, 0);
      legOne.addBox(0F, 0F, 0F, 1, 6, 1);
      legOne.setRotationPoint(1F, 19F, 1F);
      legOne.setTextureSize(64, 32);
      legOne.mirror = true;
      setRotation(legOne, 0.4363323F, 0.4363323F, 0F);
      legTwo = new ModelRenderer(this, 30, 0);
      legTwo.addBox(-1F, 0F, 0F, 1, 6, 1);
      legTwo.setRotationPoint(-1F, 19F, 1F);
      legTwo.setTextureSize(64, 32);
      legTwo.mirror = true;
      setRotation(legTwo, 0.4363323F, -0.4363323F, 0F);
      legThree = new ModelRenderer(this, 30, 0);
      legThree.addBox(0F, 0F, -1F, 1, 6, 1);
      legThree.setRotationPoint(1F, 19F, -1F);
      legThree.setTextureSize(64, 32);
      legThree.mirror = true;
      setRotation(legThree, -0.4363323F, -0.4363323F, 0F);
      legFour = new ModelRenderer(this, 30, 0);
      legFour.addBox(-1F, 0F, -1F, 1, 6, 1);
      legFour.setRotationPoint(-1F, 19F, -1F);
      legFour.setTextureSize(64, 32);
      legFour.mirror = true;
      setRotation(legFour, -0.4363323F, 0.4363323F, 0F);
      legFive = new ModelRenderer(this, 30, 0);
      legFive.addBox(0F, 0F, 0F, 1, 6, 1);
      legFive.setRotationPoint(0F, 18F, 0F);
      legFive.setTextureSize(64, 32);
      legFive.mirror = true;
      setRotation(legFive, 0.4363323F, 0.4363323F, 0F);
      legSix = new ModelRenderer(this, 30, 0);
      legSix.addBox(0F, 0F, 0F, 1, 6, 1);
      legSix.setRotationPoint(-1F, 17F, 0F);
      legSix.setTextureSize(64, 32);
      legSix.mirror = true;
      setRotation(legSix, -0.4363323F, 0.4363323F, 0F);
      legSeven = new ModelRenderer(this, 30, 0);
      legSeven.addBox(0F, 0F, 0F, 1, 6, 1);
      legSeven.setRotationPoint(-1F, 18F, 0F);
      legSeven.setTextureSize(64, 32);
      legSeven.mirror = true;
      setRotation(legSeven, 0.4363323F, -0.4363323F, 0F);
      legEight = new ModelRenderer(this, 30, 0);
      legEight.addBox(0F, 0F, 0F, 1, 6, 1);
      legEight.setRotationPoint(1F, 18F, -1F);
      legEight.setTextureSize(64, 32);
      legEight.mirror = true;
      setRotation(legEight, -0.4363323F, -0.4363323F, 0F);
      top = new ModelRenderer(this, 32, 25);
      top.addBox(-3F, -5F, -3F, 6, 2, 5);
      top.setRotationPoint(0F, 13F, 0F);
      top.setTextureSize(64, 32);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      stem = new ModelRenderer(this, 40, 0);
      stem.addBox(-2F, -3F, -2F, 4, 7, 4);
      stem.setRotationPoint(0F, 13F, 0F);
      stem.setTextureSize(64, 32);
      stem.mirror = true;
      setRotation(stem, 0F, 0F, 0F);
      leafRight = new ModelRenderer(this, 16, 28);
      leafRight.addBox(-1F, -2F, -1F, 6, 2, 2);
      leafRight.setRotationPoint(3F, 9F, 0F);
      leafRight.setTextureSize(64, 32);
      leafRight.mirror = true;
      setRotation(leafRight, 0F, 0F, 1.570796F);
      leafLeft = new ModelRenderer(this, 16, 28);
      leafLeft.addBox(-5F, -2F, -1F, 6, 2, 2);
      leafLeft.setRotationPoint(-3F, 9F, 0F);
      leafLeft.setTextureSize(64, 32);
      leafLeft.mirror = true;
      setRotation(leafLeft, 0F, 0F, -1.570796F);
      head = new ModelRenderer(this, 0, 15);
      head.addBox(-1F, -4F, -1F, 3, 4, 2);
      head.setRotationPoint(0F, 8F, -1F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      headSide = new ModelRenderer(this, 0, 3);
      headSide.addBox(-2F, -4F, 0F, 1, 4, 1);
      headSide.setRotationPoint(0F, 8F, -1F);
      headSide.setTextureSize(64, 32);
      headSide.mirror = true;
      setRotation(headSide, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    baseOne.render(f5);
    baseTwo.render(f5);
    baseThree.render(f5);
    berryOne.render(f5);
    berryTwo.render(f5);
    berryFour.render(f5);
    berryThree.render(f5);
    berryFive.render(f5);
    berrySix.render(f5);
    berrySeven.render(f5);
    base.render(f5);
    legOne.render(f5);
    legTwo.render(f5);
    legThree.render(f5);
    legFour.render(f5);
    legFive.render(f5);
    legSix.render(f5);
    legSeven.render(f5);
    legEight.render(f5);
    top.render(f5);
    stem.render(f5);
    leafRight.render(f5);
    leafLeft.render(f5);
    head.render(f5);
    headSide.render(f5);
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
    
    //Leg Rotations
    this.legOne.rotateAngleX = (MathHelper.cos(f * 0.5F) * 0.4F * f1) - 6;
    this.legOne.rotateAngleZ = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) + 6;
    this.legFive.rotateAngleX = (MathHelper.cos(f * 0.5F) * 0.4F * f1) - 6;
    this.legFive.rotateAngleZ = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) + 6;
    this.legTwo.rotateAngleX = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) - 6;
    this.legTwo.rotateAngleZ = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) - 6;
    this.legSeven.rotateAngleX = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) - 6;
    this.legSeven.rotateAngleZ = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) - 6;
    this.legThree.rotateAngleX = (MathHelper.cos(f * 0.5F) * 0.4F * f1) + 6;
    this.legThree.rotateAngleZ = (MathHelper.cos(f * 0.5F) * 0.4F * f1) + 6;
    this.legEight.rotateAngleX = (MathHelper.cos(f * 0.5F) * 0.4F * f1) + 6;
    this.legEight.rotateAngleZ = (MathHelper.cos(f * 0.5F) * 0.4F * f1) + 6;
    this.legFour.rotateAngleX = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) + 6;
    this.legFour.rotateAngleZ = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) - 6;
    this.legSix.rotateAngleX = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) + 6;
    this.legSix.rotateAngleZ = -(MathHelper.cos(f * 0.5F) * 0.4F * f1) - 6;
    
    //Arm Rotations
    this.leafLeft.rotateAngleX = (MathHelper.cos(f * 1.0F) * f1);
    this.leafLeft.rotateAngleY = (MathHelper.cos(f * 1.0F) * 1.7F * f1);
    
    this.leafRight.rotateAngleX = -(MathHelper.cos(f * 1.0F) * f1);
    this.leafRight.rotateAngleY = (MathHelper.cos(f * 1.0F) * 1.7F * f1);
  }

}
