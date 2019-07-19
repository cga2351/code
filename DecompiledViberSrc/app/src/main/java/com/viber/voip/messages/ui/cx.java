package com.viber.voip.messages.ui;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class cx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final Logger a = ViberEnv.getLogger();
  private View b;
  private View c;
  private int[] d = new int[2];
  private float e;
  private float f;
  private boolean g;
  private final Runnable h;

  public cx(View paramView1, View paramView2)
  {
    this.b = paramView1;
    this.c = paramView2;
    this.h = new Runnable()
    {
      public void run()
      {
        cx.this.a();
      }
    };
  }

  public void a()
  {
    if (!this.g)
      return;
    this.b.getLocationOnScreen(this.d);
    float f1 = this.d[0];
    float f2 = this.d[1];
    this.c.getLocationOnScreen(this.d);
    float f3 = this.d[0];
    float f4 = this.d[1];
    float f5 = this.b.getWidth() / 2.0F;
    float f6 = this.b.getHeight() / 2.0F;
    float f7 = this.c.getWidth() / 2.0F;
    float f8 = this.c.getHeight() / 2.0F;
    float f9 = f5 - f7 + this.e;
    float f10 = f6 - f8 + this.f;
    float f11 = f9 + (f1 - f3);
    float f12 = f10 + (f2 - f4);
    float f13 = Math.round(f11 + this.c.getTranslationX());
    float f14 = Math.round(f12 + this.c.getTranslationY());
    this.c.setTranslationX(f13);
    this.c.setTranslationY(f14);
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
  }

  public void b()
  {
    if (!this.g)
      return;
    ViewCompat.postOnAnimation(this.c, this.h);
  }

  public void c()
  {
    this.g = true;
    this.b.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }

  public void d()
  {
    this.g = false;
    if (a.a())
    {
      this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      return;
    }
    this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }

  public void onGlobalLayout()
  {
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.cx
 * JD-Core Version:    0.6.2
 */