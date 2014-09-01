package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSporeRay extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer Tail_part1;
    ModelRenderer tail_part_2;
    ModelRenderer left_wing;
    ModelRenderer right_wing;
  
  public ModelSporeRay()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Head = new ModelRenderer(this, 30, 0);
      Head.addBox(-2F, 0F, -3F, 4, 2, 3);
      Head.setRotationPoint(0F, 5F, -3F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-4F, 0F, 0F, 8, 2, 7);
      Body.setRotationPoint(0F, 5F, -3F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Tail_part1 = new ModelRenderer(this, 0, 9);
      Tail_part1.addBox(-1F, 0F, 0F, 2, 1, 6);
      Tail_part1.setRotationPoint(0F, 5F, 4F);
      Tail_part1.setTextureSize(64, 32);
      Tail_part1.mirror = true;
      setRotation(Tail_part1, -0.7853982F, 0F, 0F);
      tail_part_2 = new ModelRenderer(this, 16, 9);
      tail_part_2.addBox(-1F, 0F, 0F, 2, 1, 6);
      tail_part_2.setRotationPoint(0F, 9F, 8F);
      tail_part_2.setTextureSize(64, 32);
      tail_part_2.mirror = true;
      setRotation(tail_part_2, 0F, 0F, 0F);
      left_wing = new ModelRenderer(this, 0, 16);
      left_wing.addBox(0F, -1F, -2F, 4, 1, 5);
      left_wing.setRotationPoint(3F, 6F, 0F);
      left_wing.setTextureSize(64, 32);
      left_wing.mirror = true;
      setRotation(left_wing, 0F, 0F, 0.3490659F);
      right_wing = new ModelRenderer(this, 18, 16);
      right_wing.addBox(-4F, -1F, -2F, 4, 1, 5);
      right_wing.setRotationPoint(-3F, 6F, 0F);
      right_wing.setTextureSize(64, 32);
      right_wing.mirror = true;
      setRotation(right_wing, 0F, 0F, -0.3490659F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Head.render(f5);
    Body.render(f5);
    Tail_part1.render(f5);
    tail_part_2.render(f5);
    left_wing.render(f5);
    right_wing.render(f5);
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
    
    //Wings Rotations FLAPPY FLAPPY
    this.right_wing.rotateAngleZ = -(MathHelper.cos(f * 1.2F) * 1.4F * f1) - 0.3F;
    this.left_wing.rotateAngleZ = (MathHelper.cos(f * 1.2F) * 1.4F * f1) + 0.3F;
  }

}
