package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPowerBulb extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer bulb;
    ModelRenderer leafOne;
    ModelRenderer leafTwo;
    ModelRenderer leafThree;
    ModelRenderer leafFour;
    ModelRenderer top;
    ModelRenderer end;
  
  public ModelPowerBulb()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      base = new ModelRenderer(this, 0, 0);
      base.addBox(-2F, -1F, -2F, 4, 1, 4);
      base.setRotationPoint(0F, 0F, 0F);
      base.setTextureSize(64, 32);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      bulb = new ModelRenderer(this, 10, 0);
      bulb.addBox(-3F, -6F, -3F, 6, 5, 6);
      bulb.setRotationPoint(0F, 0F, 0F);
      bulb.setTextureSize(64, 32);
      bulb.mirror = true;
      setRotation(bulb, 0F, 0.7853982F, 0F);
      leafOne = new ModelRenderer(this, 28, 0);
      leafOne.addBox(0F, 0F, -2F, 4, 1, 4);
      leafOne.setRotationPoint(2F, -2F, 0F);
      leafOne.setTextureSize(64, 32);
      leafOne.mirror = true;
      setRotation(leafOne, 0F, 0F, -0.7853982F);
      leafTwo = new ModelRenderer(this, 28, 0);
      leafTwo.addBox(-4F, 0F, -2F, 4, 1, 4);
      leafTwo.setRotationPoint(-2F, -2F, 0F);
      leafTwo.setTextureSize(64, 32);
      leafTwo.mirror = true;
      setRotation(leafTwo, 0F, 0F, 0.7853982F);
      leafThree = new ModelRenderer(this, 28, 0);
      leafThree.addBox(-2F, 0F, -4F, 4, 1, 4);
      leafThree.setRotationPoint(0F, -2F, -2F);
      leafThree.setTextureSize(64, 32);
      leafThree.mirror = true;
      setRotation(leafThree, -0.7853982F, 0F, 0F);
      leafFour = new ModelRenderer(this, 28, 0);
      leafFour.addBox(-2F, 0F, 0F, 4, 1, 4);
      leafFour.setRotationPoint(0F, -2F, 2F);
      leafFour.setTextureSize(64, 32);
      leafFour.mirror = true;
      setRotation(leafFour, 0.7853982F, 0F, 0F);
      top = new ModelRenderer(this, 0, 11);
      top.addBox(-2F, 0F, -2F, 4, 1, 4);
      top.setRotationPoint(0F, -7F, 0F);
      top.setTextureSize(64, 32);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      end = new ModelRenderer(this, 0, 6);
      end.addBox(-1F, 0F, -1F, 2, 1, 2);
      end.setRotationPoint(0F, -8F, 0F);
      end.setTextureSize(64, 32);
      end.mirror = true;
      setRotation(end, 0F, 0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    bulb.render(f5);
    leafOne.render(f5);
    leafTwo.render(f5);
    leafThree.render(f5);
    leafFour.render(f5);
    top.render(f5);
    end.render(f5);
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
	    bulb.render(f);
	    leafOne.render(f);
	    leafTwo.render(f);
	    leafThree.render(f);
	    leafFour.render(f);
	    top.render(f);
	    end.render(f);
  }
}
