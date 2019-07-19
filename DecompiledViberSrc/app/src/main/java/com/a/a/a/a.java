package com.a.a.a;

import android.content.Context;
import android.view.MotionEvent;

public abstract class a
{
  protected final Context a;
  protected boolean b;
  protected MotionEvent c;
  protected MotionEvent d;
  protected float e;
  protected float f;
  protected long g;

  public a(Context paramContext)
  {
    this.a = paramContext;
  }

  protected abstract void a(int paramInt, MotionEvent paramMotionEvent);

  public boolean a_(MotionEvent paramMotionEvent)
  {
    int i = 0xFF & paramMotionEvent.getAction();
    if (!this.b)
      a(i, paramMotionEvent);
    while (true)
    {
      return true;
      b(i, paramMotionEvent);
    }
  }

  protected void ad_()
  {
    if (this.c != null)
    {
      this.c.recycle();
      this.c = null;
    }
    if (this.d != null)
    {
      this.d.recycle();
      this.d = null;
    }
    this.b = false;
  }

  protected abstract void b(int paramInt, MotionEvent paramMotionEvent);

  protected void b(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = this.c;
    if (this.d != null)
    {
      this.d.recycle();
      this.d = null;
    }
    this.d = MotionEvent.obtain(paramMotionEvent);
    this.g = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
    this.e = paramMotionEvent.getPressure(paramMotionEvent.getActionIndex());
    this.f = localMotionEvent.getPressure(localMotionEvent.getActionIndex());
  }

  public boolean b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.a.a.a.a
 * JD-Core Version:    0.6.2
 */