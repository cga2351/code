package com.a.a.a;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public class b extends a
{
  private static final PointF h = new PointF();
  private final a i;
  private PointF j;
  private PointF k;
  private PointF l = new PointF();
  private PointF m = new PointF();

  public b(Context paramContext, a parama)
  {
    super(paramContext);
    this.i = parama;
  }

  private PointF c(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    int n = paramMotionEvent.getPointerCount();
    int i1 = 0;
    float f2 = 0.0F;
    while (i1 < n)
    {
      f2 += paramMotionEvent.getX(i1);
      f1 += paramMotionEvent.getY(i1);
      i1++;
    }
    return new PointF(f2 / n, f1 / n);
  }

  protected void a(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    case 1:
    default:
      return;
    case 0:
      ad_();
      this.c = MotionEvent.obtain(paramMotionEvent);
      this.g = 0L;
      b(paramMotionEvent);
      return;
    case 2:
    }
    this.b = this.i.b(this);
  }

  protected void b(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    default:
    case 1:
    case 3:
    case 2:
    }
    do
    {
      return;
      this.i.c(this);
      ad_();
      return;
      b(paramMotionEvent);
    }
    while ((this.e / this.f <= 0.67F) || (!this.i.a(this)));
    this.c.recycle();
    this.c = MotionEvent.obtain(paramMotionEvent);
  }

  protected void b(MotionEvent paramMotionEvent)
  {
    super.b(paramMotionEvent);
    MotionEvent localMotionEvent = this.c;
    this.j = c(paramMotionEvent);
    this.k = c(localMotionEvent);
    int n;
    if (localMotionEvent.getPointerCount() != paramMotionEvent.getPointerCount())
    {
      n = 1;
      if (n == 0)
        break label110;
    }
    label110: for (PointF localPointF1 = h; ; localPointF1 = new PointF(this.j.x - this.k.x, this.j.y - this.k.y))
    {
      this.m = localPointF1;
      PointF localPointF2 = this.l;
      localPointF2.x += this.m.x;
      PointF localPointF3 = this.l;
      localPointF3.y += this.m.y;
      return;
      n = 0;
      break;
    }
  }

  public PointF c()
  {
    return this.m;
  }

  public static abstract interface a
  {
    public abstract boolean a(b paramb);

    public abstract boolean b(b paramb);

    public abstract void c(b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.a.a.a.b
 * JD-Core Version:    0.6.2
 */