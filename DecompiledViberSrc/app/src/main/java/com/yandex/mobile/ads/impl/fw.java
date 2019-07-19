package com.yandex.mobile.ads.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public final class fw
{
  public static void a(fx.f paramf, Rect paramRect)
  {
    paramf.setPivot(paramRect.width() / 2.0F, paramRect.height() / 2.0F);
    paramf.setDepthZ(paramRect.width() / 2.0F);
    paramf.setAnimationDuration(400L);
    paramf.setFromInterpolator(a.a);
    paramf.setToInterpolator(a.b);
    paramf.a();
  }

  static final class a
  {
    static final Interpolator a = new LinearInterpolator();
    static final Interpolator b = new AccelerateInterpolator();
  }

  static final class b extends Animation
  {
    private Camera a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;

    public b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      this.b = paramFloat1;
      this.c = paramFloat2;
      this.d = paramFloat3;
      this.e = paramFloat4;
      this.f = paramFloat5;
      this.g = paramFloat6;
    }

    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      float f1 = this.b + paramFloat * (this.c - this.b);
      float f2 = (paramFloat + this.g) / 2.0F;
      float f3 = (float)(this.f * Math.sin(3.141592653589793D * f2));
      Matrix localMatrix = paramTransformation.getMatrix();
      this.a.save();
      this.a.translate(0.0F, 0.0F, f3);
      this.a.rotateY(f1);
      this.a.getMatrix(localMatrix);
      this.a.restore();
      localMatrix.preTranslate(-this.d, -this.e);
      localMatrix.postTranslate(this.d, this.e);
    }

    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      this.a = new Camera();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fw
 * JD-Core Version:    0.6.2
 */