package com.a.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public abstract class d extends a
{
  protected float h;
  protected float i;
  protected float j;
  protected float k;
  private final float l;
  private float m;
  private float n;
  private float o;
  private float p;

  public d(Context paramContext)
  {
    super(paramContext);
    this.l = ViewConfiguration.get(paramContext).getScaledEdgeSlop();
  }

  protected static float a(MotionEvent paramMotionEvent, int paramInt)
  {
    float f = paramMotionEvent.getX() - paramMotionEvent.getRawX();
    if (paramInt < paramMotionEvent.getPointerCount())
      return f + paramMotionEvent.getX(paramInt);
    return 0.0F;
  }

  protected static float b(MotionEvent paramMotionEvent, int paramInt)
  {
    float f = paramMotionEvent.getY() - paramMotionEvent.getRawY();
    if (paramInt < paramMotionEvent.getPointerCount())
      return f + paramMotionEvent.getY(paramInt);
    return 0.0F;
  }

  protected abstract void a(int paramInt, MotionEvent paramMotionEvent);

  protected abstract void b(int paramInt, MotionEvent paramMotionEvent);

  protected void b(MotionEvent paramMotionEvent)
  {
    super.b(paramMotionEvent);
    MotionEvent localMotionEvent = this.c;
    this.o = -1.0F;
    this.p = -1.0F;
    float f1 = localMotionEvent.getX(0);
    float f2 = localMotionEvent.getY(0);
    float f3 = localMotionEvent.getX(1);
    float f4 = localMotionEvent.getY(1);
    float f5 = f3 - f1;
    float f6 = f4 - f2;
    this.h = f5;
    this.i = f6;
    float f7 = paramMotionEvent.getX(0);
    float f8 = paramMotionEvent.getY(0);
    float f9 = paramMotionEvent.getX(1);
    float f10 = paramMotionEvent.getY(1);
    float f11 = f9 - f7;
    float f12 = f10 - f8;
    this.j = f11;
    this.k = f12;
  }

  protected boolean c(MotionEvent paramMotionEvent)
  {
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    this.m = (localDisplayMetrics.widthPixels - this.l);
    this.n = (localDisplayMetrics.heightPixels - this.l);
    float f1 = this.l;
    float f2 = this.m;
    float f3 = this.n;
    float f4 = paramMotionEvent.getRawX();
    float f5 = paramMotionEvent.getRawY();
    float f6 = a(paramMotionEvent, 1);
    float f7 = b(paramMotionEvent, 1);
    int i1;
    int i2;
    if ((f4 < f1) || (f5 < f1) || (f4 > f2) || (f5 > f3))
    {
      i1 = 1;
      if ((f6 >= f1) && (f7 >= f1) && (f6 <= f2) && (f7 <= f3))
        break label166;
      i2 = 1;
      label148: if ((i1 == 0) || (i2 == 0))
        break label172;
    }
    label166: label172: 
    while ((i1 != 0) || (i2 != 0))
    {
      return true;
      i1 = 0;
      break;
      i2 = 0;
      break label148;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.a.a.a.d
 * JD-Core Version:    0.6.2
 */