package com.viber.voip.messages.ui.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;

public class c extends LayerDrawable
{
  protected int a = 0;
  private int b = 2;
  private long c;
  private int d = 0;
  private int e;
  private int f;
  private boolean g;

  protected c(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
  }

  private void a(int paramInt)
  {
    this.d = 0;
    this.b = 2;
    this.a = paramInt;
    invalidateSelf();
  }

  protected void a()
  {
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      a(paramInt);
      return;
    }
    this.g = true;
    this.b = 0;
    this.d = 0;
    this.e = 0;
    this.f = 255;
    this.a = paramInt;
    invalidateSelf();
  }

  protected void a(Canvas paramCanvas, Drawable paramDrawable)
  {
  }

  protected void a(Canvas paramCanvas, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt, boolean paramBoolean)
  {
  }

  protected boolean b()
  {
    return true;
  }

  public void draw(Canvas paramCanvas)
  {
    int i = 1;
    if (!b());
    boolean bool;
    label172: 
    do
    {
      return;
      switch (this.b)
      {
      default:
      case 0:
      case 1:
      }
      do
        while (true)
        {
          int j = this.d;
          bool = this.g;
          a();
          if (i == 0)
            break label172;
          if ((bool) && (j != 0) && (j != 255))
            break;
          a(paramCanvas, getDrawable(this.a));
          return;
          this.c = SystemClock.uptimeMillis();
          this.b = i;
          i = 0;
        }
      while (this.c < 0L);
      float f1 = (float)(SystemClock.uptimeMillis() - this.c) / 200.0F;
      if (f1 >= 1.0F);
      while (true)
      {
        float f2 = Math.min(f1, 1.0F);
        this.d = ((int)(this.e + f2 * (this.f - this.e)));
        break;
        i = 0;
      }
    }
    while ((this.a == 0) && (bool));
    a(paramCanvas, getDrawable(-1 + this.a), getDrawable(this.a), this.d, this.g);
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.a.c
 * JD-Core Version:    0.6.2
 */