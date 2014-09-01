package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBarbedSpike extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer stemOne;
    ModelRenderer stemTwo;
    ModelRenderer stemThree;
    ModelRenderer stemFour;
    ModelRenderer stemFive;
    ModelRenderer spikeBottom;
    ModelRenderer spikeTip;
  
  public ModelBarbedSpike()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3F, -2F, -2F, 7, 5, 4);
      head.setRotationPoint(0F, 1F, 4F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0.5235988F, 0F, 0F);
      stemOne = new ModelRenderer(this, 12, 19);
      stemOne.addBox(-1F, -7F, -1F, 3, 8, 3);
      stemOne.setRotationPoint(0F, 0F, -1F);
      stemOne.setTextureSize(64, 32);
      stemOne.mirror = true;
      setRotation(stemOne, 1.134464F, 0F, 0F);
      stemTwo = new ModelRenderer(this, 12, 9);
      stemTwo.addBox(-1F, -6F, -1F, 3, 7, 3);
      stemTwo.setRotationPoint(0F, 5F, 2F);
      stemTwo.setTextureSize(64, 32);
      stemTwo.mirror = true;
      setRotation(stemTwo, 0.5235988F, 0F, 0F);
      stemThree = new ModelRenderer(this, 22, 0);
      stemThree.addBox(-1F, -6F, -1F, 3, 7, 3);
      stemThree.setRotationPoint(0F, 11F, 2F);
      stemThree.setTextureSize(64, 32);
      stemThree.mirror = true;
      setRotation(stemThree, 0F, 0F, 0F);
      stemFour = new ModelRenderer(this, 0, 20);
      stemFour.addBox(-1F, -6F, -1F, 3, 7, 3);
      stemFour.setRotationPoint(0F, 17F, 0F);
      stemFour.setTextureSize(64, 32);
      stemFour.mirror = true;
      setRotation(stemFour, -0.3490659F, 0F, 0F);
      stemFive = new ModelRenderer(this, 0, 9);
      stemFive.addBox(-1F, -6F, -1F, 3, 7, 3);
      stemFive.setRotationPoint(0F, 23F, 0F);
      stemFive.setTextureSize(64, 32);
      stemFive.mirror = true;
      setRotation(stemFive, 0F, 0F, 0F);
      spikeBottom = new ModelRenderer(this, 24, 10);
      spikeBottom.addBox(0F, -10F, -1F, 2, 10, 2);
      spikeBottom.setRotationPoint(-1F, -3F, -6F);
      spikeBottom.setTextureSize(64, 32);
      spikeBottom.mirror = true;
      setRotation(spikeBottom, 1.570796F, 0F, 0F);
      spikeTip = new ModelRenderer(this, 34, 0);
      spikeTip.addBox(0F, 0F, 0F, 1, 10, 1);
      spikeTip.setRotationPoint(0F, -4F, -15F);
      spikeTip.setTextureSize(64, 32);
      spikeTip.mirror = true;
      setRotation(spikeTip, -0.9250245F, 0F, 0F);
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
    stemFive.render(f5);
    spikeBottom.render(f5);
    spikeTip.render(f5);
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