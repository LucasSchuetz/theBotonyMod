package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGreanBaen extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer neck;
    ModelRenderer body;
    ModelRenderer tail1;
    ModelRenderer leftWingTop;
    ModelRenderer rightWingTop;
    ModelRenderer leftWingBottom;
    ModelRenderer rightWingBottom;
    ModelRenderer leftWingSide;
    ModelRenderer rightWingSide;
    ModelRenderer Shape1;
  
  public ModelGreanBaen()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-2F, 0F, -6F, 4, 4, 6);
      head.setRotationPoint(0F, 19F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 0, 10);
      neck.addBox(-2F, 0F, 0F, 3, 4, 10);
      neck.setRotationPoint(0F, 20F, 0F);
      neck.setTextureSize(64, 32);
      neck.mirror = true;
      setRotation(neck, 0F, 0.3490659F, 0F);
      body = new ModelRenderer(this, 16, 0);
      body.addBox(-1F, 0F, 0F, 3, 4, 10);
      body.setRotationPoint(2F, 20F, 9F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, -0.3490659F, 0F);
      tail1 = new ModelRenderer(this, 15, 14);
      tail1.addBox(-2F, 0F, 0F, 3, 4, 11);
      tail1.setRotationPoint(-1F, 20F, 18F);
      tail1.setTextureSize(64, 32);
      tail1.mirror = true;
      setRotation(tail1, 0F, 0.3490659F, 0F);
      leftWingTop = new ModelRenderer(this, 0, 11);
      leftWingTop.addBox(0F, -8F, 0F, 1, 8, 1);
      leftWingTop.setRotationPoint(1F, 21F, 2F);
      leftWingTop.setTextureSize(64, 32);
      leftWingTop.mirror = true;
      setRotation(leftWingTop, 0F, 0F, 0.6981317F);
      rightWingTop = new ModelRenderer(this, 4, 11);
      rightWingTop.addBox(-1F, -8F, 0F, 1, 8, 1);
      rightWingTop.setRotationPoint(-1F, 21F, 2F);
      rightWingTop.setTextureSize(64, 32);
      rightWingTop.mirror = true;
      setRotation(rightWingTop, 0F, 0F, -0.6981317F);
      leftWingBottom = new ModelRenderer(this, 0, 29);
      leftWingBottom.addBox(0F, 0F, 0F, 8, 1, 1);
      leftWingBottom.setRotationPoint(7F, 15F, 2F);
      leftWingBottom.setTextureSize(64, 32);
      leftWingBottom.mirror = true;
      setRotation(leftWingBottom, 0F, -0.5235988F, 0F);
      rightWingBottom = new ModelRenderer(this, 18, 29);
      rightWingBottom.addBox(-8F, 0F, 0F, 8, 1, 1);
      rightWingBottom.setRotationPoint(-7F, 15F, 2F);
      rightWingBottom.setTextureSize(64, 32);
      rightWingBottom.mirror = true;
      setRotation(rightWingBottom, 0F, 0.5235988F, 0F);
      leftWingSide = new ModelRenderer(this, 42, 0);
      leftWingSide.addBox(-4F, -2F, 0F, 11, 8, 0);
      leftWingSide.setRotationPoint(7F, 16F, 4F);
      leftWingSide.setTextureSize(64, 32);
      leftWingSide.mirror = true;
      setRotation(leftWingSide, 0F, -0.3316126F, 0.2443461F);
      rightWingSide = new ModelRenderer(this, 42, 8);
      rightWingSide.addBox(-7F, -2F, 0F, 11, 8, 0);
      rightWingSide.setRotationPoint(-7F, 16F, 4F);
      rightWingSide.setTextureSize(64, 32);
      rightWingSide.mirror = true;
      setRotation(rightWingSide, 0F, 0.3316126F, -0.2443461F);
      Shape1 = new ModelRenderer(this, 43, 16);
      Shape1.addBox(-3F, -10F, 0F, 6, 10, 0);
      Shape1.setRotationPoint(0F, 19F, -4F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, -0.6108652F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    neck.render(f5);
    body.render(f5);
    tail1.render(f5);
    leftWingTop.render(f5);
    rightWingTop.render(f5);
    leftWingBottom.render(f5);
    rightWingBottom.render(f5);
    leftWingSide.render(f5);
    rightWingSide.render(f5);
    Shape1.render(f5);
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
    
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.head.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.tail1.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.4F * f1;
    this.Shape1.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1) - 0.8F;
  }
}