package com.viber.voip.widget;

import android.content.Context;
import com.viber.voip.R.attr;
import com.viber.voip.util.dc;

public class r extends ag
{
  private ag.g c;
  private ag.g d;
  private ag.g e;
  private ag.g f;
  private boolean g;
  private int h;

  public r(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.c = new ag.g(dc.c(paramContext, R.attr.heartLike));
    this.d = new ag.g(dc.c(paramContext, R.attr.heartLikeWithStroke));
    this.e = new ag.g(dc.c(paramContext, R.attr.heartUnlike));
    this.f = new ag.g(dc.c(paramContext, R.attr.heartUnlikeWithStroke));
    this.h = -16777216;
  }

  private void a(ag.g paramg, boolean paramBoolean, a parama)
  {
    this.a[0] = paramg;
    if (paramBoolean)
    {
      ag.c localc = new ag.c(0.5D, 0.3D);
      localc.a(new s(parama));
      this.a[0].setClock(localc);
    }
    while (true)
    {
      invalidate();
      return;
      this.a[0].setClock(new ag.d(this.a[0].a()));
    }
  }

  public void a(boolean paramBoolean, a parama)
  {
    ag.g localg = this.e;
    if (this.g)
      localg = this.f;
    a(localg, paramBoolean, parama);
  }

  public boolean a()
  {
    ag.g localg = this.a[0];
    boolean bool1 = false;
    if (localg != null)
    {
      boolean bool2 = this.a[0].c();
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  public void b()
  {
    if (this.a[0] != null)
    {
      this.a[0].setClock(new ag.d(this.a[0].a()));
      invalidate();
    }
  }

  public void b(boolean paramBoolean, a parama)
  {
    ag.g localg = this.c;
    if (this.g)
      localg = this.d;
    a(localg, paramBoolean, parama);
  }

  public void setStrokeColor(int paramInt)
  {
    this.h = paramInt;
  }

  public void setUseStrokeColor(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.d.a(this.h);
    this.f.a(this.h);
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.r
 * JD-Core Version:    0.6.2
 */