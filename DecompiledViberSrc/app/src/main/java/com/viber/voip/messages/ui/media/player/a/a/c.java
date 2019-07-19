package com.viber.voip.messages.ui.media.player.a.a;

import android.view.View;
import com.viber.voip.ui.b.a;
import com.viber.voip.util.ch;
import com.viber.voip.util.dj;

public final class c extends b
{
  protected final View g;
  protected final View h;
  protected final View i;

  public c(View paramView1, View paramView2, View paramView3)
  {
    this(paramView1, paramView2, paramView3, 300L, c);
  }

  public c(View paramView1, View paramView2, View paramView3, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
    this.g = paramView1;
    this.h = paramView2;
    this.i = paramView3;
  }

  protected void c()
  {
    super.c();
    if (ch.d(this.a))
      this.g.setTranslationY(0.0F);
    if (ch.c(this.a))
      this.h.setTranslationY(0.0F);
    if (ch.b(this.a))
      this.i.setAlpha(1.0F);
    View[] arrayOfView = new View[3];
    View localView1;
    if (ch.d(this.a))
    {
      localView1 = this.g;
      arrayOfView[0] = localView1;
      if (!ch.c(this.a))
        break label141;
    }
    label141: for (View localView2 = this.h; ; localView2 = null)
    {
      arrayOfView[1] = localView2;
      boolean bool = ch.b(this.a);
      View localView3 = null;
      if (bool)
        localView3 = this.i;
      arrayOfView[2] = localView3;
      a(true, arrayOfView);
      return;
      localView1 = null;
      break;
    }
  }

  protected void e()
  {
    super.e();
    View[] arrayOfView = new View[3];
    View localView1;
    if (!ch.c(this.a, true))
    {
      localView1 = this.g;
      arrayOfView[0] = localView1;
      if (ch.b(this.a, true))
        break label90;
    }
    label90: for (View localView2 = this.h; ; localView2 = null)
    {
      arrayOfView[1] = localView2;
      boolean bool = ch.a(this.a, true);
      View localView3 = null;
      if (!bool)
        localView3 = this.i;
      arrayOfView[2] = localView3;
      a(false, arrayOfView);
      return;
      localView1 = null;
      break;
    }
  }

  public boolean f()
  {
    return (this.i.getVisibility() == 0) || (this.g.getVisibility() == 0) || (this.h.getVisibility() == 0);
  }

  protected void h()
  {
    if (ch.d(this.a))
      a.a(this.g, -this.g.getHeight(), 0.0F, this.e, com.viber.voip.ui.b.c.f);
    if (ch.c(this.a))
      a.a(this.h, this.h.getHeight(), 0.0F, this.e, com.viber.voip.ui.b.c.f);
    if (ch.b(this.a))
      a.a(this.i, this.e, com.viber.voip.ui.b.c.f);
  }

  protected void i()
  {
    if (ch.c(this.a, true))
      if (!ch.b(this.a, true))
        break label82;
    while (true)
    {
      if (!ch.a(this.a, true))
        break label129;
      return;
      if (ch.d(this.a))
      {
        a.b(this.g, 0.0F, -this.g.getHeight(), this.e, com.viber.voip.ui.b.c.e);
        break;
      }
      dj.b(this.g, false);
      break;
      label82: if (ch.c(this.a))
        a.b(this.h, 0.0F, this.h.getHeight(), this.e, com.viber.voip.ui.b.c.e);
      else
        dj.b(this.h, false);
    }
    label129: if (ch.b(this.a))
    {
      a.b(this.i, this.e, com.viber.voip.ui.b.c.e);
      return;
    }
    dj.b(this.i, false);
  }

  protected void j()
  {
    View[] arrayOfView = new View[3];
    arrayOfView[0] = this.g;
    arrayOfView[1] = this.h;
    arrayOfView[2] = this.i;
    a(arrayOfView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.a.c
 * JD-Core Version:    0.6.2
 */