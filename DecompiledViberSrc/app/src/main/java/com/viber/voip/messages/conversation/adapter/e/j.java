package com.viber.voip.messages.conversation.adapter.e;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.b;
import com.viber.voip.messages.extras.image.c;

public class j
{
  private static final Logger a = ViberEnv.getLogger();
  private static final int[] b = arrayOfInt;
  private b c;
  private Resources d;
  private float e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;

  static
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = c.a;
    arrayOfInt[1] = c.a;
  }

  public j(b paramb, Resources paramResources)
  {
    this.c = paramb;
    this.d = paramResources;
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.e = paramFloat;
    this.i = ((int)(paramInt2 / this.e));
    this.j = ((int)(paramInt1 / this.e));
  }

  private boolean c()
  {
    return (this.f > 0) && (this.g > 0) && (this.h > 0) && (this.e > 0.0F) && (this.i > 0) && (this.j > 0);
  }

  public int a()
  {
    return this.g;
  }

  public void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    DisplayMetrics localDisplayMetrics = this.d.getDisplayMetrics();
    int m;
    if (this.c.a())
      m = localDisplayMetrics.heightPixels;
    while (true)
    {
      a((int)(paramFloat1 * m), (int)(paramFloat2 * m), (int)(paramFloat3 * paramInt), paramFloat4);
      return;
      int k = localDisplayMetrics.heightPixels;
      m = paramInt;
      paramInt = k;
    }
  }

  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int[] arrayOfInt = (int[])b.clone();
    if ((!c()) || (paramInt1 < 0) || (paramInt2 < 0))
      return arrayOfInt;
    if ((paramInt1 >= this.f) && (paramInt1 <= this.g) && (paramInt2 <= this.h))
    {
      arrayOfInt[0] = paramInt1;
      if (paramInt1 / paramInt2 <= this.e)
        break label438;
    }
    label414: label438: for (int k = (int)(paramInt1 / this.e); ; k = paramInt2)
    {
      arrayOfInt[1] = Math.max(k, paramInt2);
      float f2;
      while ((paramBoolean) && (arrayOfInt[0] < this.g) && (arrayOfInt[1] < this.h))
      {
        float f1 = this.g / arrayOfInt[0];
        f2 = this.h / arrayOfInt[1];
        if (f1 > f2)
          break label414;
        arrayOfInt[0] = this.g;
        arrayOfInt[1] = ((int)(f1 * arrayOfInt[1]));
        return arrayOfInt;
        if ((paramInt1 > this.g) && (paramInt2 <= this.h))
        {
          arrayOfInt[0] = this.g;
          arrayOfInt[1] = Math.max(this.i, (int)(paramInt2 * (this.g / paramInt1)));
        }
        else if ((paramInt1 >= this.f) && (paramInt1 <= this.g) && (paramInt2 > this.h))
        {
          arrayOfInt[0] = Math.max(this.f, (int)(paramInt1 * (this.h / paramInt2)));
          arrayOfInt[1] = this.h;
        }
        else if ((paramInt1 > this.g) && (paramInt2 > this.h))
        {
          float f3 = Math.min(this.g / paramInt1, this.h / paramInt2);
          arrayOfInt[0] = Math.max(this.f, (int)(f3 * paramInt1));
          arrayOfInt[1] = Math.max(this.i, (int)(f3 * paramInt2));
        }
        else if (paramInt1 < this.f)
        {
          arrayOfInt[0] = this.f;
          arrayOfInt[1] = Math.min(this.h, (int)(paramInt2 * (this.f / paramInt1)));
          arrayOfInt[1] = Math.max(this.j, arrayOfInt[1]);
        }
      }
      break;
      arrayOfInt[0] = ((int)(f2 * arrayOfInt[0]));
      arrayOfInt[1] = this.h;
      return arrayOfInt;
    }
  }

  public int b()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.j
 * JD-Core Version:    0.6.2
 */