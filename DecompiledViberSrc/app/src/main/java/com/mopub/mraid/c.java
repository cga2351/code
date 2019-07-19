package com.mopub.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.mopub.common.util.Dips;

class c
{
  private final Context a;
  private final Rect b;
  private final Rect c;
  private final Rect d;
  private final Rect e;
  private final Rect f;
  private final Rect g;
  private final Rect h;
  private final Rect i;
  private final float j;

  c(Context paramContext, float paramFloat)
  {
    this.a = paramContext.getApplicationContext();
    this.j = paramFloat;
    this.b = new Rect();
    this.c = new Rect();
    this.d = new Rect();
    this.e = new Rect();
    this.f = new Rect();
    this.g = new Rect();
    this.h = new Rect();
    this.i = new Rect();
  }

  private void a(Rect paramRect1, Rect paramRect2)
  {
    paramRect2.set(Dips.pixelsToIntDips(paramRect1.left, this.a), Dips.pixelsToIntDips(paramRect1.top, this.a), Dips.pixelsToIntDips(paramRect1.right, this.a), Dips.pixelsToIntDips(paramRect1.bottom, this.a));
  }

  Rect a()
  {
    return this.c;
  }

  void a(int paramInt1, int paramInt2)
  {
    this.b.set(0, 0, paramInt1, paramInt2);
    a(this.b, this.c);
  }

  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    a(this.d, this.e);
  }

  Rect b()
  {
    return this.d;
  }

  void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    a(this.f, this.g);
  }

  Rect c()
  {
    return this.e;
  }

  void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.h.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    a(this.h, this.i);
  }

  Rect d()
  {
    return this.g;
  }

  Rect e()
  {
    return this.h;
  }

  Rect f()
  {
    return this.i;
  }

  public float getDensity()
  {
    return this.j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.c
 * JD-Core Version:    0.6.2
 */