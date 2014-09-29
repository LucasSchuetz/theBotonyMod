package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLifeBasin extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer stand;
    ModelRenderer bottom;
    ModelRenderer wallOne;
    ModelRenderer wallThree;
    ModelRenderer wallFour;
    ModelRenderer cover;
    ModelRenderer boneOne;
    ModelRenderer boneTwo;
    ModelRenderer boneThree;
    ModelRenderer boneFour;
    ModelRenderer boneTipOne;
    ModelRenderer boneTipTwo;
    ModelRenderer boneTipThree;
    ModelRenderer boneTipFour;
    ModelRenderer glassThree;
    ModelRenderer glassFour;
    ModelRenderer pillarOne;
    ModelRenderer pillarTwo;
    ModelRenderer row;
    ModelRenderer frontGlass;
  
  public ModelLifeBasin()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      base = new ModelRenderer(this, 0, 0);
      base.addBox(-3F, 0F, -3F, 6, 2, 6);
      base.setRotationPoint(0F, 22F, 0F);
      base.setTextureSize(64, 32);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      stand = new ModelRenderer(this, 0, 8);
      stand.addBox(-2F, 0F, -2F, 4, 3, 4);
      stand.setRotationPoint(0F, 19F, 0F);
      stand.setTextureSize(64, 32);
      stand.mirror = true;
      setRotation(stand, 0F, 0F, 0F);
      bottom = new ModelRenderer(this, 0, 15);
      bottom.addBox(-6F, 0F, -5F, 10, 2, 10);
      bottom.setRotationPoint(1F, 17F, 0F);
      bottom.setTextureSize(64, 32);
      bottom.mirror = true;
      setRotation(bottom, 0F, 0F, 0F);
      wallOne = new ModelRenderer(this, 0, 27);
      wallOne.addBox(-5F, 0F, 0F, 10, 4, 1);
      wallOne.setRotationPoint(0F, 13F, 4F);
      wallOne.setTextureSize(64, 32);
      wallOne.mirror = true;
      setRotation(wallOne, 0F, 0F, 0F);
      wallThree = new ModelRenderer(this, 46, 20);
      wallThree.addBox(0F, 0F, -4F, 1, 4, 8);
      wallThree.setRotationPoint(4F, 13F, 0F);
      wallThree.setTextureSize(64, 32);
      wallThree.mirror = true;
      setRotation(wallThree, 0F, 0F, 0F);
      wallFour = new ModelRenderer(this, 46, 20);
      wallFour.addBox(0F, 0F, -4F, 1, 4, 8);
      wallFour.setRotationPoint(-5F, 13F, 0F);
      wallFour.setTextureSize(64, 32);
      wallFour.mirror = true;
      setRotation(wallFour, 0F, 0F, 0F);
      cover = new ModelRenderer(this, 26, 1);
      cover.addBox(-3F, 0F, -3F, 6, 1, 6);
      cover.setRotationPoint(0F, 12F, 0F);
      cover.setTextureSize(64, 32);
      cover.mirror = true;
      setRotation(cover, 0F, 0F, 0F);
      boneOne = new ModelRenderer(this, 56, 12);
      boneOne.addBox(-1F, -14F, -1F, 2, 14, 2);
      boneOne.setRotationPoint(3F, 24F, -3F);
      boneOne.setTextureSize(64, 32);
      boneOne.mirror = true;
      setRotation(boneOne, 0.2443461F, 0F, 0.2443461F);
      boneTwo = new ModelRenderer(this, 56, 12);
      boneTwo.addBox(-1F, -14F, -1F, 2, 14, 2);
      boneTwo.setRotationPoint(-3F, 24F, -3F);
      boneTwo.setTextureSize(64, 32);
      boneTwo.mirror = true;
      setRotation(boneTwo, 0.2443461F, 0F, -0.2443461F);
      boneThree = new ModelRenderer(this, 56, 12);
      boneThree.addBox(0F, -14F, 0F, 2, 14, 2);
      boneThree.setRotationPoint(2F, 24F, 2F);
      boneThree.setTextureSize(64, 32);
      boneThree.mirror = true;
      setRotation(boneThree, -0.2443461F, 0F, 0.2443461F);
      boneFour = new ModelRenderer(this, 56, 12);
      boneFour.addBox(0F, -14F, 0F, 2, 14, 2);
      boneFour.setRotationPoint(-4F, 24F, 2F);
      boneFour.setTextureSize(64, 32);
      boneFour.mirror = true;
      setRotation(boneFour, -0.2443461F, 0F, -0.2443461F);
      boneTipOne = new ModelRenderer(this, 0, 15);
      boneTipOne.addBox(0F, 0F, 0F, 1, 2, 3);
      boneTipOne.setRotationPoint(7F, 11F, -8F);
      boneTipOne.setTextureSize(64, 32);
      boneTipOne.mirror = true;
      setRotation(boneTipOne, 0.2443461F, 0F, 0.2443461F);
      boneTipTwo = new ModelRenderer(this, 0, 15);
      boneTipTwo.addBox(0F, 0F, -1F, 1, 2, 3);
      boneTipTwo.setRotationPoint(-8F, 11F, -7F);
      boneTipTwo.setTextureSize(64, 32);
      boneTipTwo.mirror = true;
      setRotation(boneTipTwo, 0.2443461F, 0F, -0.2443461F);
      boneTipThree = new ModelRenderer(this, 0, 15);
      boneTipThree.addBox(0F, 0F, -1F, 1, 2, 3);
      boneTipThree.setRotationPoint(7F, 11F, 6F);
      boneTipThree.setTextureSize(64, 32);
      boneTipThree.mirror = true;
      setRotation(boneTipThree, -0.2443461F, 0F, 0.2443461F);
      boneTipFour = new ModelRenderer(this, 0, 15);
      boneTipFour.addBox(0F, 0F, -1F, 1, 2, 3);
      boneTipFour.setRotationPoint(-8F, 11F, 6F);
      boneTipFour.setTextureSize(64, 32);
      boneTipFour.mirror = true;
      setRotation(boneTipFour, -0.2443461F, 0F, -0.2443461F);
      glassThree = new ModelRenderer(this, 16, 10);
      glassThree.addBox(-1F, 0F, 0F, 2, 0, 1);
      glassThree.setRotationPoint(3F, 13F, 0F);
      glassThree.setTextureSize(64, 32);
      glassThree.mirror = true;
      setRotation(glassThree, 0.0174533F, 1.570796F, 0F);
      glassFour = new ModelRenderer(this, 16, 10);
      glassFour.addBox(-1F, 0F, 0F, 2, 0, 1);
      glassFour.setRotationPoint(-4F, 13F, 0F);
      glassFour.setTextureSize(64, 32);
      glassFour.mirror = true;
      setRotation(glassFour, 0.0174533F, 1.570796F, 0F);
      pillarOne = new ModelRenderer(this, 31, 15);
      pillarOne.addBox(0F, 0F, 0F, 2, 4, 1);
      pillarOne.setRotationPoint(3F, 13F, -5F);
      pillarOne.setTextureSize(64, 32);
      pillarOne.mirror = true;
      setRotation(pillarOne, 0F, 0F, 0F);
      pillarTwo = new ModelRenderer(this, 31, 15);
      pillarTwo.addBox(0F, 0F, 0F, 2, 4, 1);
      pillarTwo.setRotationPoint(-5F, 13F, -5F);
      pillarTwo.setTextureSize(64, 32);
      pillarTwo.mirror = true;
      setRotation(pillarTwo, 0F, 0F, 0F);
      row = new ModelRenderer(this, 31, 20);
      row.addBox(-3F, 0F, 0F, 6, 1, 1);
      row.setRotationPoint(0F, 13F, -5F);
      row.setTextureSize(64, 32);
      row.mirror = true;
      setRotation(row, 0F, 0F, 0F);
      frontGlass = new ModelRenderer(this, 25, 29);
      frontGlass.addBox(0F, 0F, 0F, 6, 3, 0);
      frontGlass.setRotationPoint(-3F, 14F, -5F);
      frontGlass.setTextureSize(64, 32);
      frontGlass.mirror = true;
      setRotation(frontGlass, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    stand.render(f5);
    bottom.render(f5);
    wallOne.render(f5);
    wallThree.render(f5);
    wallFour.render(f5);
    cover.render(f5);
    boneOne.render(f5);
    boneTwo.render(f5);
    boneThree.render(f5);
    boneFour.render(f5);
    boneTipOne.render(f5);
    boneTipTwo.render(f5);
    boneTipThree.render(f5);
    boneTipFour.render(f5);
    glassThree.render(f5);
    glassFour.render(f5);
    pillarOne.render(f5);
    pillarTwo.render(f5);
    row.render(f5);
    frontGlass.render(f5);
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
	    base.render(f);
	    stand.render(f);
	    bottom.render(f);
	    wallOne.render(f);
	    wallThree.render(f);
	    wallFour.render(f);
	    cover.render(f);
	    boneOne.render(f);
	    boneTwo.render(f);
	    boneThree.render(f);
	    boneFour.render(f);
	    boneTipOne.render(f);
	    boneTipTwo.render(f);
	    boneTipThree.render(f);
	    boneTipFour.render(f);
	    glassThree.render(f);
	    glassFour.render(f);
	    pillarOne.render(f);
	    pillarTwo.render(f);
	    row.render(f);
	    frontGlass.render(f);
  }
}
