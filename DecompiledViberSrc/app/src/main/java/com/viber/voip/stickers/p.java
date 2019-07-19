package com.viber.voip.stickers;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ax;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.an;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;

public class p
{
  public static int a;
  public static int b;
  public static int c;
  public static float d;
  public static final float e;
  public static final float f;
  public static final float g;
  public static final float h;
  private static final Logger i = ViberEnv.getLogger();
  private static final int[] j = { 144, 130, 100, 86, 80, 65, 60, 50, 43, 40 };
  private static final int[] k = { 30, 45, 60 };
  private static final int[] l = { 30, 40, 60, 80, 120 };
  private static p t;
  private static p u;
  private final int m = 2;
  private final int n;
  private final int o;
  private final int p;
  private final float q;
  private final float r;
  private final float s;

  static
  {
    Application localApplication = ViberApplication.getApplication();
    boolean bool = ViberApplication.isTablet(localApplication);
    int i2;
    if (localApplication == null)
    {
      h = 0.18F;
      int[] arrayOfInt = j.a(localApplication);
      int i1 = arrayOfInt[0];
      i2 = arrayOfInt[1];
      g = i1;
      e = i1;
      if (!bool)
        break label348;
    }
    label348: for (float f1 = i2 * dj.d(ViberApplication.getApplication()); ; f1 = i2)
    {
      f = f1;
      a = d.ax.a.d();
      if (a == 0)
      {
        a = h();
        d.ax.a.a(a);
      }
      d = i();
      b = d.ax.b.d();
      if (b == 0)
      {
        b = a(localApplication.getResources().getDimensionPixelSize(R.dimen.sticker_package_icon_size), k);
        d.ax.b.a(b);
      }
      c = l[(-1 + l.length)];
      t = new p(5, 10, 0.15F, 0.08F, 0.2F);
      u = new p(4, 8, 0.2F, 0.1F, 0.2F);
      return;
      TypedValue localTypedValue = new TypedValue();
      localApplication.getResources().getValue(R.dimen.conversation_sticker_cell_percent, localTypedValue, true);
      h = localTypedValue.getFloat();
      break;
    }
  }

  private p(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!ViberApplication.isTablet(ViberApplication.getApplication()))
      this.o = paramInt1;
    for (this.s = paramFloat1; ; this.s = paramFloat2)
    {
      this.n = paramInt1;
      this.p = paramInt2;
      this.r = paramFloat2;
      this.q = paramFloat3;
      return;
      this.o = paramInt2;
    }
  }

  private static int a(int paramInt, int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i2 = 0;
    int i3 = 2147483647;
    while (i1 < paramArrayOfInt.length)
    {
      int i4 = paramArrayOfInt[i1];
      if ((i4 < i3) && (i4 >= paramInt))
        i3 = i4;
      if (i2 < i4)
        i2 = i4;
      i1++;
    }
    if (i3 == 2147483647)
      return i2;
    return i3;
  }

  public static int a(boolean paramBoolean)
  {
    if (paramBoolean)
      return 300;
    return a;
  }

  public static p a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return t;
    case 143700:
    }
    return u;
  }

  public static void a(Sticker paramSticker, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = paramInt1 / paramInt3;
    float f2 = paramInt2 / paramInt3;
    paramSticker.setColSpan(Math.round(f1));
    paramSticker.setRowSpan(Math.round(f2));
    if (paramSticker.getColSpan() > 3)
      paramSticker.setColSpan(3);
    do
      while (paramSticker.getRowSpan() > 2)
      {
        paramSticker.setRowSpan(2);
        return;
        if (paramSticker.getColSpan() == 0)
          paramSticker.setColSpan(1);
      }
    while (paramSticker.getRowSpan() != 0);
    paramSticker.setRowSpan(1);
  }

  public static int f()
  {
    return j[(-1 + j.length)];
  }

  private static int g()
  {
    return (int)(0.5D + g * h);
  }

  private static int h()
  {
    return a(g(), j);
  }

  private static float i()
  {
    double d1 = Math.sqrt(j() / 2464.0D);
    double d2 = a;
    if (d2 / d1 < 2.799999952316284D)
      d1 = d2 / 2.799999952316284D;
    return (float)d1;
  }

  private static int j()
  {
    float f1 = (float)an.b();
    if (an.a());
    return (int)(f1 * 0.0625F);
  }

  public float a()
  {
    return this.s;
  }

  public float b()
  {
    return this.r;
  }

  public float c()
  {
    return this.q;
  }

  public int d()
  {
    return this.n;
  }

  public int e()
  {
    return 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.p
 * JD-Core Version:    0.6.2
 */