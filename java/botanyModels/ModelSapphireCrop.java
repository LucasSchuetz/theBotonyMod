package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSapphireCrop extends ModelBase
{
  //fields
    ModelRenderer stem;
    ModelRenderer baseOne;
    ModelRenderer baseTwo;
    ModelRenderer baseThree;
    ModelRenderer leafRight;
    ModelRenderer leafLeft;
    ModelRenderer berryOne;
    ModelRenderer berryTwo;
    ModelRenderer berryFour;
    ModelRenderer berryThree;
    ModelRenderer berryFive;
    ModelRenderer berrySix;
    ModelRenderer berrySeven;
  
  public ModelSapphireCrop()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      stem = new ModelRenderer(this, 40, 0);
      stem.addBox(-2F, 0F, -2F, 4, 7, 4);
      stem.setRotationPoint(0F, 17F, 0F);
      stem.setTextureSize(64, 32);
      stem.mirror = true;
      setRotation(stem, 0F, 0F, 0F);
      baseOne = new ModelRenderer(this, 0, 25);
      baseOne.addBox(-3F, -1F, -3F, 6, 1, 6);
      baseOne.setRotationPoint(0F, 18F, 0F);
      baseOne.setTextureSize(64, 32);
      baseOne.mirror = true;
      setRotation(baseOne, 0.1745329F, 0F, 0F);
      baseTwo = new ModelRenderer(this, 0, 0);
      baseTwo.addBox(-5F, -1F, -5F, 10, 1, 10);
      baseTwo.setRotationPoint(0F, 17F, 0F);
      baseTwo.setTextureSize(64, 32);
      baseTwo.mirror = true;
      setRotation(baseTwo, 0.0872665F, 0.7853982F, 0.0872665F);
      baseThree = new ModelRenderer(this, 0, 11);
      baseThree.addBox(-5F, -1F, -5F, 10, 1, 10);
      baseThree.setRotationPoint(0F, 16F, 0F);
      baseThree.setTextureSize(64, 32);
      baseThree.mirror = true;
      setRotation(baseThree, 0.1745329F, 0F, 0F);
      leafRight = new ModelRenderer(this, 28, 25);
      leafRight.addBox(0F, 0F, 0F, 8, 0, 6);
      leafRight.setRotationPoint(1F, 21F, 1F);
      leafRight.setTextureSize(64, 32);
      leafRight.mirror = true;
      setRotation(leafRight, 0.1745329F, 0F, 0F);
      leafLeft = new ModelRenderer(this, 12, 25);
      leafLeft.addBox(-8F, 0F, -6F, 8, 0, 6);
      leafLeft.setRotationPoint(-1F, 21F, -1F);
      leafLeft.setTextureSize(64, 32);
      leafLeft.mirror = true;
      setRotation(leafLeft, 0.1745329F, 0F, 0F);
      berryOne = new ModelRenderer(this, 0, 0);
      berryOne.addBox(-1F, -1F, -1F, 2, 1, 2);
      berryOne.setRotationPoint(2F, 14.8F, 2F);
      berryOne.setTextureSize(64, 32);
      berryOne.mirror = true;
      setRotation(berryOne, 0.1745329F, 0F, 0F);
      berryTwo = new ModelRenderer(this, 0, 3);
      berryTwo.addBox(-1F, -1F, -1F, 2, 1, 2);
      berryTwo.setRotationPoint(-2F, 14.8F, 2F);
      berryTwo.setTextureSize(64, 32);
      berryTwo.mirror = true;
      setRotation(berryTwo, 0.1745329F, 0F, 0F);
      berryFour = new ModelRenderer(this, 0, 6);
      berryFour.addBox(-1F, -1F, -1F, 2, 1, 2);
      berryFour.setRotationPoint(0F, 15F, 0F);
      berryFour.setTextureSize(64, 32);
      berryFour.mirror = true;
      setRotation(berryFour, 0.1745329F, 0F, 0F);
      berryThree = new ModelRenderer(this, 30, 0);
      berryThree.addBox(-1F, -1F, -1F, 2, 1, 2);
      berryThree.setRotationPoint(3F, 15F, 0F);
      berryThree.setTextureSize(64, 32);
      berryThree.mirror = true;
      setRotation(berryThree, 0.1745329F, 0F, 0F);
      berryThree.mirror = false;
      berryFive = new ModelRenderer(this, 30, 3);
      berryFive.addBox(-1F, -1F, -1F, 2, 1, 2);
      berryFive.setRotationPoint(-3F, 15F, 0F);
      berryFive.setTextureSize(64, 32);
      berryFive.mirror = true;
      setRotation(berryFive, 0.1745329F, 0F, 0F);
      berrySix = new ModelRenderer(this, 0, 11);
      berrySix.addBox(-1F, -1F, -1F, 2, 1, 2);
      berrySix.setRotationPoint(2F, 15.5F, -2F);
      berrySix.setTextureSize(64, 32);
      berrySix.mirror = true;
      setRotation(berrySix, 0.1745329F, 0F, 0F);
      berrySeven = new ModelRenderer(this, 0, 14);
      berrySeven.addBox(-1F, -1F, -1F, 2, 1, 2);
      berrySeven.setRotationPoint(-2F, 15.5F, -2F);
      berrySeven.setTextureSize(64, 32);
      berrySeven.mirror = true;
      setRotation(berrySeven, 0.1745329F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    stem.render(f5);
    baseOne.render(f5);
    baseTwo.render(f5);
    baseThree.render(f5);
    leafRight.render(f5);
    leafLeft.render(f5);
    berryOne.render(f5);
    berryTwo.render(f5);
    berryFour.render(f5);
    berryThree.render(f5);
    berryFive.render(f5);
    berrySix.render(f5);
    berrySeven.render(f5);
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

  public void renderModel(float f)
  {
	    stem.render(f);
	    baseOne.render(f);
	    baseTwo.render(f);
	    baseThree.render(f);
	    leafRight.render(f);
	    leafLeft.render(f);
	    berryOne.render(f);
	    berryTwo.render(f);
	    berryFour.render(f);
	    berryThree.render(f);
	    berryFive.render(f);
	    berrySix.render(f);
	    berrySeven.render(f);
  }
}
