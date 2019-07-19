package com.viber.common.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.viber.common.d.h;

public class b extends a
{
  private final RectF e = new RectF();
  private a f;

  public b(Resources paramResources, Bitmap paramBitmap)
  {
    this(new a(paramBitmap, false), paramResources);
  }

  public b(Resources paramResources, Bitmap paramBitmap, boolean paramBoolean)
  {
    this(new a(paramBitmap, paramBoolean), paramResources);
  }

  protected b(a parama, Resources paramResources)
  {
    super(parama, paramResources);
    this.f = parama;
  }

  private float[] a(int paramInt, float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = { paramFloat1, paramFloat2, paramFloat1, paramFloat2, paramFloat1, paramFloat2, paramFloat1, paramFloat2 };
    if ((paramInt & 0x1) == 0)
    {
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
    }
    if ((paramInt & 0x2) == 0)
    {
      arrayOfFloat[2] = 0.0F;
      arrayOfFloat[3] = 0.0F;
    }
    if ((paramInt & 0x8) == 0)
    {
      arrayOfFloat[4] = 0.0F;
      arrayOfFloat[5] = 0.0F;
    }
    if ((paramInt & 0x4) == 0)
    {
      arrayOfFloat[6] = 0.0F;
      arrayOfFloat[7] = 0.0F;
    }
    return arrayOfFloat;
  }

  public final void a(float paramFloat)
  {
    a locala = this.f;
    this.f.i = paramFloat;
    locala.h = paramFloat;
  }

  public final void a(int paramInt)
  {
    this.f.g = paramInt;
  }

  protected void a(Path paramPath, Rect paramRect)
  {
    a locala = this.f;
    b localb = locala.f;
    float f1 = paramRect.width();
    float f2 = paramRect.height();
    if (f1 > f2);
    for (int i = 1; ; i = 0)
    {
      paramPath.reset();
      switch (1.a[localb.ordinal()])
      {
      default:
        this.e.set(paramRect);
        paramPath.addRect(this.e, Path.Direction.CCW);
        return;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    }
    if (i != 0);
    for (float f13 = f2 / 2.0F; ; f13 = f1 / 2.0F)
    {
      paramPath.addCircle(f1 / 2.0F, f2 / 2.0F, f13, Path.Direction.CCW);
      return;
    }
    float f12;
    if (i != 0)
    {
      f12 = f2;
      if (i != 0)
        ((f1 - f2) / 2.0F);
      if (i == 0)
        break label199;
    }
    while (true)
    {
      h.d(f12, f12, paramPath);
      return;
      f12 = f1;
      break;
      label199: ((f2 - f1) / 2.0F);
    }
    float f9;
    float f10;
    if (i != 0)
    {
      f9 = f2;
      if (i == 0)
        break label261;
      f10 = (f1 - f2) / 2.0F;
      label233: if (i == 0)
        break label267;
    }
    label261: label267: for (float f11 = 0.0F; ; f11 = (f2 - f1) / 2.0F)
    {
      h.a(f9, f9, f10, f11, paramPath);
      return;
      f9 = f1;
      break;
      f10 = 0.0F;
      break label233;
    }
    float f6;
    float f7;
    label302: float f8;
    if (i != 0)
    {
      f6 = f2;
      if (i == 0)
        break label350;
      f7 = (f1 - f2) / 2.0F;
      f8 = 0.0F;
      if (i == 0)
        break label356;
    }
    while (true)
    {
      this.e.set(f7, f8, f7 + f6, f6 + f8);
      paramPath.addRect(this.e, Path.Direction.CCW);
      return;
      f6 = f1;
      break;
      label350: f7 = 0.0F;
      break label302;
      label356: f8 = (f2 - f1) / 2.0F;
    }
    float f3;
    float f4;
    label391: float f5;
    if (i != 0)
    {
      f3 = f2;
      if (i == 0)
        break label455;
      f4 = (f1 - f2) / 2.0F;
      f5 = 0.0F;
      if (i == 0)
        break label461;
    }
    while (true)
    {
      this.e.set(f4, f5, f4 + f3, f3 + f5);
      paramPath.addRoundRect(this.e, a(locala.g, locala.h, locala.i), Path.Direction.CCW);
      return;
      f3 = f1;
      break;
      label455: f4 = 0.0F;
      break label391;
      label461: f5 = (f2 - f1) / 2.0F;
    }
    this.e.set(paramRect);
    paramPath.addRoundRect(this.e, a(12, locala.h, locala.i), Path.Direction.CCW);
    return;
    this.e.set(paramRect);
    paramPath.addRoundRect(this.e, a(locala.g, locala.h, locala.i), Path.Direction.CCW);
  }

  public final void a(b paramb)
  {
    if (paramb == null)
      paramb = b.a;
    this.f.f = paramb;
  }

  public final float e()
  {
    return this.f.h;
  }

  public boolean f()
  {
    return this.f.j;
  }

  protected a g()
  {
    this.f = new a(this.f);
    return this.f;
  }

  static final class a extends a.a
  {
    b.b f = b.b.a;
    int g = 15;
    float h = 0.0F;
    float i = 0.0F;
    boolean j;

    a(Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
      this.j = paramBoolean;
    }

    a(a parama)
    {
      super();
      this.f = parama.f;
      this.h = parama.h;
      this.i = parama.i;
      this.j = parama.j;
      this.g = parama.g;
    }

    public Drawable newDrawable()
    {
      return new b(this, null);
    }

    public Drawable newDrawable(Resources paramResources)
    {
      return new b(this, paramResources);
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[8];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.b
 * JD-Core Version:    0.6.2
 */