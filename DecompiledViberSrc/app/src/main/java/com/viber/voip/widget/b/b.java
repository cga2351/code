package com.viber.voip.widget.b;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.adsnative.c.o;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.conversation.adapter.d.z;

public class b
  implements c.a
{
  private static final float a = o.a(3.0F, ViberApplication.getLocalizedContext());
  private a b;
  private final z c;
  private final RecyclerView d;
  private final View e;
  private final int f;
  private final float g;
  private float h = 1.4E-45F;
  private float i = 1.4E-45F;
  private float j = 0.0F;
  private float k = 1.4E-45F;
  private float l;
  private boolean m;
  private boolean n;
  private boolean o;

  b(View paramView, z paramz, RecyclerView paramRecyclerView)
  {
    this.e = paramView;
    this.c = paramz;
    this.d = paramRecyclerView;
    Resources localResources = paramView.getResources();
    this.f = localResources.getDimensionPixelSize(R.dimen.replyable_free_area);
    this.g = localResources.getDimensionPixelSize(R.dimen.replyable_distance_requirements);
  }

  private void a(float paramFloat)
  {
    float f1 = this.k - this.j;
    float f3;
    if (f1 < paramFloat)
    {
      float f2 = this.j;
      this.j = (paramFloat - f1);
      f3 = this.l + this.j;
      if (f3 + this.e.getX() > this.e.getWidth() - this.f)
        this.j = f2;
    }
    else
    {
      return;
    }
    this.e.setX(f3);
    boolean bool1 = this.o;
    if (this.e.getX() > this.g);
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.o = bool2;
      if ((bool1 == this.o) || (!this.o))
        break;
      this.c.a();
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    if (this.b != null)
      this.b.a(paramBoolean);
    if (this.e.getParent() != null)
      this.e.getParent().requestDisallowInterceptTouchEvent(false);
    this.e.setX(this.l);
    this.h = 1.4E-45F;
    this.i = 1.4E-45F;
    this.n = false;
    this.m = false;
    this.o = false;
  }

  private boolean a()
  {
    return (this.d != null) && (this.d.computeHorizontalScrollOffset() > 0);
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < this.f)
    {
      a(false);
      return false;
    }
    this.n = false;
    this.o = false;
    this.h = paramFloat1;
    this.k = paramFloat1;
    this.i = paramFloat2;
    this.j = 0.0F;
    return true;
  }

  private boolean b(float paramFloat1, float paramFloat2)
  {
    if (this.n)
    {
      a(paramFloat1);
      return true;
    }
    if (this.h + a < paramFloat1)
      if (Math.abs(Math.max(paramFloat2, this.i) - Math.min(paramFloat2, this.i)) < Math.abs(Math.max(paramFloat1, this.h) - Math.min(paramFloat1, this.h)))
      {
        if (this.e.getParent() != null)
          this.e.getParent().requestDisallowInterceptTouchEvent(true);
        if (this.b != null)
          this.b.b();
        this.l = this.e.getX();
        this.n = true;
      }
    while (paramFloat1 >= this.h)
    {
      this.h = paramFloat1;
      this.i = paramFloat2;
      break;
    }
    a(false);
    return false;
  }

  public void a(a parama)
  {
    this.b = parama;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    boolean bool = this.n;
    if (i1 == 0)
      if (a(paramMotionEvent.getX(), paramMotionEvent.getY()))
        this.m = true;
    do
    {
      return bool;
      if (i1 != 2)
        break;
    }
    while ((!this.m) || (a()));
    b(paramMotionEvent.getX(), paramMotionEvent.getY());
    return bool;
    if (i1 == 1)
    {
      a(this.o);
      return bool;
    }
    a(false);
    return bool;
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.b.b
 * JD-Core Version:    0.6.2
 */