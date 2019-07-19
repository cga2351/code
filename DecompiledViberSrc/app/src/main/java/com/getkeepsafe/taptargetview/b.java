package com.getkeepsafe.taptargetview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;

public class b
{
  private int A = 20;
  private int B = 18;
  final CharSequence a;
  final CharSequence b;
  float c = 0.96F;
  int d = 44;
  Rect e;
  Drawable f;
  Typeface g;
  Typeface h;
  int i = -1;
  boolean j = false;
  boolean k = true;
  boolean l = true;
  boolean m = false;
  float n = 0.54F;
  private int o = -1;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  private int s = -1;
  private Integer t = null;
  private Integer u = null;
  private Integer v = null;
  private Integer w = null;
  private Integer x = null;
  private int y = -1;
  private int z = -1;

  protected b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == null)
      throw new IllegalArgumentException("Cannot pass null title");
    this.a = paramCharSequence1;
    this.b = paramCharSequence2;
  }

  private int a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt2 != -1)
      return paramContext.getResources().getDimensionPixelSize(paramInt2);
    return d.b(paramContext, paramInt1);
  }

  public static b a(View paramView, CharSequence paramCharSequence)
  {
    return a(paramView, paramCharSequence, null);
  }

  public static b a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new e(paramView, paramCharSequence1, paramCharSequence2);
  }

  private Integer a(Context paramContext, Integer paramInteger, int paramInt)
  {
    if (paramInt != -1)
      paramInteger = Integer.valueOf(ContextCompat.getColor(paramContext, paramInt));
    return paramInteger;
  }

  public Rect a()
  {
    if (this.e == null)
      throw new IllegalStateException("Requesting bounds that are not set! Make sure your target is ready");
    return this.e;
  }

  public b a(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
      throw new IllegalArgumentException("Given an invalid alpha value: " + paramFloat);
    this.c = paramFloat;
    return this;
  }

  public b a(int paramInt)
  {
    this.o = paramInt;
    return this;
  }

  public b a(Typeface paramTypeface)
  {
    if (paramTypeface == null)
      throw new IllegalArgumentException("Cannot use a null typeface");
    this.g = paramTypeface;
    return this;
  }

  public b a(Drawable paramDrawable)
  {
    return a(paramDrawable, false);
  }

  public b a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable == null)
      throw new IllegalArgumentException("Cannot use null drawable");
    this.f = paramDrawable;
    if (!paramBoolean)
      this.f.setBounds(new Rect(0, 0, this.f.getIntrinsicWidth(), this.f.getIntrinsicHeight()));
    return this;
  }

  public b a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }

  Integer a(Context paramContext)
  {
    return a(paramContext, this.t, this.o);
  }

  public void a(Runnable paramRunnable)
  {
    paramRunnable.run();
  }

  public b b(int paramInt)
  {
    this.p = paramInt;
    return this;
  }

  public b b(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }

  Integer b(Context paramContext)
  {
    return a(paramContext, this.u, this.p);
  }

  public b c(int paramInt)
  {
    this.r = paramInt;
    return this;
  }

  public b c(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }

  Integer c(Context paramContext)
  {
    return a(paramContext, this.v, this.q);
  }

  public b d(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Given negative text size");
    this.A = paramInt;
    return this;
  }

  public b d(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }

  Integer d(Context paramContext)
  {
    return a(paramContext, this.w, this.r);
  }

  public b e(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  Integer e(Context paramContext)
  {
    return a(paramContext, this.x, this.s);
  }

  int f(Context paramContext)
  {
    return a(paramContext, this.A, this.y);
  }

  int g(Context paramContext)
  {
    return a(paramContext, this.B, this.z);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.getkeepsafe.taptargetview.b
 * JD-Core Version:    0.6.2
 */