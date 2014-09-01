package botanyModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFungleCrab extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer back_shell;
    ModelRenderer Body;
    ModelRenderer lower_body;
    ModelRenderer right_eye;
    ModelRenderer left_eye;
    ModelRenderer back_shell_top;
    ModelRenderer right_top_arm;
    ModelRenderer left_top_arm;
    ModelRenderer left_arm_bottom;
    ModelRenderer right_arm_bottom;
    ModelRenderer large_claw_base;
    ModelRenderer Small_Claw;
    ModelRenderer Large_Claw_Top;
    ModelRenderer Large_Claw_Bottom;
    ModelRenderer top_right_leg_front;
    ModelRenderer bottom_right_leg_front;
    ModelRenderer top_right_leg_back;
    ModelRenderer bottom_left_leg_front;
    ModelRenderer top_left_leg_back;
    ModelRenderer top_left_leg_front;
    ModelRenderer bottom_right_leg_back;
    ModelRenderer bottom_left_leg_back;
  
  public ModelFungleCrab()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3F, -3F, -2F, 4, 3, 3);
      head.setRotationPoint(1F, 15F, -1F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      back_shell = new ModelRenderer(this, 44, 8);
      back_shell.addBox(-4F, -5F, 0F, 8, 8, 2);
      back_shell.setRotationPoint(0F, 16F, 3F);
      back_shell.setTextureSize(64, 32);
      back_shell.mirror = true;
      setRotation(back_shell, 0.5235988F, 0F, 0F);
      Body = new ModelRenderer(this, 28, 18);
      Body.addBox(-5F, 0F, -4F, 10, 3, 8);
      Body.setRotationPoint(0F, 15F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      lower_body = new ModelRenderer(this, 24, 0);
      lower_body.addBox(-3F, 0F, -3F, 6, 2, 6);
      lower_body.setRotationPoint(0F, 18F, 0F);
      lower_body.setTextureSize(64, 32);
      lower_body.mirror = true;
      setRotation(lower_body, 0F, 0F, 0F);
      right_eye = new ModelRenderer(this, 18, 0);
      right_eye.addBox(-1F, -2F, -1F, 1, 2, 1);
      right_eye.setRotationPoint(-1F, 12F, -2F);
      right_eye.setTextureSize(64, 32);
      right_eye.mirror = true;
      setRotation(right_eye, 0F, 0F, -0.3490659F);
      left_eye = new ModelRenderer(this, 22, 0);
      left_eye.addBox(0F, -2F, -1F, 1, 2, 1);
      left_eye.setRotationPoint(1F, 12F, -2F);
      left_eye.setTextureSize(64, 32);
      left_eye.mirror = true;
      setRotation(left_eye, 0F, 0F, 0.3490659F);
      back_shell_top = new ModelRenderer(this, 48, 0);
      back_shell_top.addBox(-2F, -2F, 0F, 4, 4, 2);
      back_shell_top.setRotationPoint(0F, 14F, 4F);
      back_shell_top.setTextureSize(64, 32);
      back_shell_top.mirror = true;
      setRotation(back_shell_top, 0.5235988F, 0F, 0F);
      right_top_arm = new ModelRenderer(this, 28, 8);
      right_top_arm.addBox(-6F, -1F, 0F, 6, 2, 2);
      right_top_arm.setRotationPoint(-4F, 15F, -2F);
      right_top_arm.setTextureSize(64, 32);
      right_top_arm.mirror = true;
      setRotation(right_top_arm, 0F, -0.7853982F, 0F);
      left_top_arm = new ModelRenderer(this, 28, 12);
      left_top_arm.addBox(-6F, -1F, -2F, 6, 2, 2);
      left_top_arm.setRotationPoint(4F, 15F, -2F);
      left_top_arm.setTextureSize(64, 32);
      left_top_arm.mirror = true;
      setRotation(left_top_arm, 0F, -1.954769F, 0F);
      left_arm_bottom = new ModelRenderer(this, 20, 11);
      left_arm_bottom.addBox(0F, 0F, -6F, 1, 1, 6);
      left_arm_bottom.setRotationPoint(7F, 15F, -6F);
      left_arm_bottom.setTextureSize(64, 32);
      left_arm_bottom.mirror = true;
      setRotation(left_arm_bottom, -0.6108652F, 0.5061455F, 0F);
      right_arm_bottom = new ModelRenderer(this, 8, 0);
      right_arm_bottom.addBox(-1F, -1F, -6F, 2, 2, 6);
      right_arm_bottom.setRotationPoint(-8F, 15F, -5F);
      right_arm_bottom.setTextureSize(64, 32);
      right_arm_bottom.mirror = true;
      setRotation(right_arm_bottom, 0F, -0.3490659F, 0F);
      large_claw_base = new ModelRenderer(this, 28, 18);
      large_claw_base.addBox(-1F, -3F, -2F, 2, 6, 2);
      large_claw_base.setRotationPoint(-6F, 15F, -10F);
      large_claw_base.setTextureSize(64, 32);
      large_claw_base.mirror = true;
      setRotation(large_claw_base, 0F, -0.7853982F, 0F);
      Small_Claw = new ModelRenderer(this, 12, 8);
      Small_Claw.addBox(-2F, -1F, -1F, 3, 2, 1);
      Small_Claw.setRotationPoint(5F, 12F, -10F);
      Small_Claw.setTextureSize(64, 32);
      Small_Claw.mirror = true;
      setRotation(Small_Claw, 0F, -0.9424778F, 0F);
      Large_Claw_Top = new ModelRenderer(this, 0, 6);
      Large_Claw_Top.addBox(-1F, -1F, -4F, 2, 2, 4);
      Large_Claw_Top.setRotationPoint(-5F, 13F, -11F);
      Large_Claw_Top.setTextureSize(64, 32);
      Large_Claw_Top.mirror = true;
      setRotation(Large_Claw_Top, -0.5235988F, -0.7853982F, 0F);
      Large_Claw_Bottom = new ModelRenderer(this, 12, 14);
      Large_Claw_Bottom.addBox(-1F, -1F, -4F, 2, 2, 4);
      Large_Claw_Bottom.setRotationPoint(-5F, 17F, -11F);
      Large_Claw_Bottom.setTextureSize(64, 32);
      Large_Claw_Bottom.mirror = true;
      setRotation(Large_Claw_Bottom, 0.5235988F, -0.7853982F, 0F);
      top_right_leg_front = new ModelRenderer(this, 0, 12);
      top_right_leg_front.addBox(-1F, 0F, -1F, 1, 5, 1);
      top_right_leg_front.setRotationPoint(-3F, 18F, -1F);
      top_right_leg_front.setTextureSize(64, 32);
      top_right_leg_front.mirror = true;
      setRotation(top_right_leg_front, 0F, 0F, 0.7330383F);
      bottom_right_leg_front = new ModelRenderer(this, 0, 24);
      bottom_right_leg_front.addBox(0F, 0F, 0F, 1, 3, 1);
      bottom_right_leg_front.setRotationPoint(-7F, 21F, -2F);
      bottom_right_leg_front.setTextureSize(64, 32);
      bottom_right_leg_front.mirror = true;
      setRotation(bottom_right_leg_front, 0F, 0F, 0F);
      top_right_leg_back = new ModelRenderer(this, 0, 18);
      top_right_leg_back.addBox(-1F, 0F, 1F, 1, 5, 1);
      top_right_leg_back.setRotationPoint(-3F, 18F, 1F);
      top_right_leg_back.setTextureSize(64, 32);
      top_right_leg_back.mirror = true;
      setRotation(top_right_leg_back, 0F, 0F, 0.7330383F);
      bottom_left_leg_front = new ModelRenderer(this, 0, 28);
      bottom_left_leg_front.addBox(0F, 0F, 0F, 1, 3, 1);
      bottom_left_leg_front.setRotationPoint(6F, 21F, -2F);
      bottom_left_leg_front.setTextureSize(64, 32);
      bottom_left_leg_front.mirror = true;
      setRotation(bottom_left_leg_front, 0F, 0F, 0F);
      top_left_leg_back = new ModelRenderer(this, 4, 18);
      top_left_leg_back.addBox(0F, 0F, 0F, 1, 5, 1);
      top_left_leg_back.setRotationPoint(3F, 18F, 1F);
      top_left_leg_back.setTextureSize(64, 32);
      top_left_leg_back.mirror = true;
      setRotation(top_left_leg_back, 0F, 0F, -0.7330383F);
      top_left_leg_front = new ModelRenderer(this, 4, 12);
      top_left_leg_front.addBox(0F, 0F, -1F, 1, 5, 1);
      top_left_leg_front.setRotationPoint(3F, 18F, -1F);
      top_left_leg_front.setTextureSize(64, 32);
      top_left_leg_front.mirror = true;
      setRotation(top_left_leg_front, 0F, 0F, -0.7330383F);
      bottom_right_leg_back = new ModelRenderer(this, 4, 24);
      bottom_right_leg_back.addBox(0F, 0F, 0F, 1, 3, 1);
      bottom_right_leg_back.setRotationPoint(-7F, 21F, 2F);
      bottom_right_leg_back.setTextureSize(64, 32);
      bottom_right_leg_back.mirror = true;
      setRotation(bottom_right_leg_back, 0F, 0F, 0F);
      bottom_left_leg_back = new ModelRenderer(this, 4, 28);
      bottom_left_leg_back.addBox(0F, 0F, 0F, 1, 3, 1);
      bottom_left_leg_back.setRotationPoint(6F, 21F, 1F);
      bottom_left_leg_back.setTextureSize(64, 32);
      bottom_left_leg_back.mirror = true;
      setRotation(bottom_left_leg_back, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    back_shell.render(f5);
    Body.render(f5);
    lower_body.render(f5);
    right_eye.render(f5);
    left_eye.render(f5);
    back_shell_top.render(f5);
    right_top_arm.render(f5);
    left_top_arm.render(f5);
    left_arm_bottom.render(f5);
    right_arm_bottom.render(f5);
    large_claw_base.render(f5);
    Small_Claw.render(f5);
    Large_Claw_Top.render(f5);
    Large_Claw_Bottom.render(f5);
    top_right_leg_front.render(f5);
    bottom_right_leg_front.render(f5);
    top_right_leg_back.render(f5);
    bottom_left_leg_front.render(f5);
    top_left_leg_back.render(f5);
    top_left_leg_front.render(f5);
    bottom_right_leg_back.render(f5);
    bottom_left_leg_back.render(f5);
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
    
    //Claw pinch
    this.Large_Claw_Top.rotateAngleX = (MathHelper.cos(f * 0.6666F) * 1.4F * f1);
    this.Large_Claw_Bottom.rotateAngleX = -(MathHelper.cos(f * 0.6666F) * 1.4F * f1);

    //Top Leg Sections
    this.top_right_leg_front.rotateAngleX = MathHelper.cos(f * 1.5F) * 1.2F * f1;
    this.top_right_leg_back.rotateAngleX = -(MathHelper.cos(f * 1.5F) * 1.2F * f1);
    this.top_left_leg_front.rotateAngleX = MathHelper.cos(f * 1.5F) * 1.2F * f1;
    this.top_left_leg_back.rotateAngleX = -(MathHelper.cos(f * 1.5F) * 1.2F * f1);
    this.bottom_right_leg_front.offsetZ = MathHelper.cos(f * 1.5F) * 0.4F * f1;
    this.bottom_right_leg_front.offsetY = -0.005F * (MathHelper.cos(f*20.0F));
    this.bottom_right_leg_back.offsetZ = -(MathHelper.cos(f * 1.5F) * 0.4F * f1);
    this.bottom_right_leg_back.offsetY = -0.005F * (MathHelper.cos(f*20.0F));
    this.bottom_left_leg_front.offsetZ = MathHelper.cos(f * 1.5F) * 0.4F * f1;
    this.bottom_left_leg_front.offsetY = -0.005F * (MathHelper.cos(f*20.0F));
    this.bottom_left_leg_back.offsetZ = -(MathHelper.cos(f * 1.5F) * 0.4F * f1);
    this.bottom_left_leg_back.offsetY = -0.005F * (MathHelper.cos(f*20.0F));
  }
}
