package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelArrowFish extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer right_fin;
    ModelRenderer left_fin;
    ModelRenderer top_dorsal_fin;
    ModelRenderer bottom_dorsal_fin;
  
  public ModelArrowFish()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, -2F, -3F, 1, 3, 5);
      Body.setRotationPoint(0F, 22F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      right_fin = new ModelRenderer(this, 12, 0);
      right_fin.addBox(0F, 0F, -1F, 1, 1, 3);
      right_fin.setRotationPoint(1F, 22F, -1F);
      right_fin.setTextureSize(64, 32);
      right_fin.mirror = true;
      setRotation(right_fin, 0F, 0.7853982F, 0F);
      left_fin = new ModelRenderer(this, 20, 0);
      left_fin.addBox(-1F, 0F, -1F, 1, 1, 3);
      left_fin.setRotationPoint(0F, 22F, -1F);
      left_fin.setTextureSize(64, 32);
      left_fin.mirror = true;
      setRotation(left_fin, 0.0174533F, -0.7853982F, 0F);
      top_dorsal_fin = new ModelRenderer(this, 0, 8);
      top_dorsal_fin.addBox(0F, -1F, 0F, 1, 2, 2);
      top_dorsal_fin.setRotationPoint(0F, 23F, 1F);
      top_dorsal_fin.setTextureSize(64, 32);
      top_dorsal_fin.mirror = true;
      setRotation(top_dorsal_fin, 0.7853982F, 0F, 0F);
      bottom_dorsal_fin = new ModelRenderer(this, 0, 12);
      bottom_dorsal_fin.addBox(0F, -2F, 0F, 1, 2, 2);
      bottom_dorsal_fin.setRotationPoint(0F, 20F, 0F);
      bottom_dorsal_fin.setTextureSize(64, 32);
      bottom_dorsal_fin.mirror = true;
      setRotation(bottom_dorsal_fin, -0.7853982F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    right_fin.render(f5);
    left_fin.render(f5);
    top_dorsal_fin.render(f5);
    bottom_dorsal_fin.render(f5);
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
    this.right_fin.rotateAngleY = (MathHelper.cos(f * 5.0F) * 1.0F * f1) + 0.8F;
    this.left_fin.rotateAngleY = -(MathHelper.cos(f * 5.0F) * 1.0F * f1) - 0.8F;
    this.bottom_dorsal_fin.rotateAngleY = (MathHelper.cos(f * 4.5F) * 3.0F * f1);
    this.top_dorsal_fin.rotateAngleY = (MathHelper.cos(f * 4.5F) * 3.0F * f1);
    
    //Side fish offsets
    this.right_fin.offsetZ = 0.1F;
    this.left_fin.offsetZ = 0.1F;
  }

}