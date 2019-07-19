package com.viber.voip.messages.ui.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.a;
import com.viber.voip.stickers.f;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.widget.ListViewWithAnimatedView;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final i c;
  private int d;
  private b e;
  private View f;
  private final a g;
  private final Handler h;
  private Runnable i = new Runnable()
  {
    public void run()
    {
      if (d.this.d())
      {
        d.c(d.this).e().a(false);
        d.d(d.this).d();
      }
    }
  };

  public d(Context paramContext, Handler paramHandler, i parami, a parama)
  {
    this.b = paramContext;
    this.h = paramHandler;
    this.c = parami;
    this.g = parama;
  }

  private b a(Context paramContext, ViewGroup paramViewGroup, f paramf, a parama, int paramInt, LayoutInflater paramLayoutInflater)
  {
    c localc = new c(paramContext, paramViewGroup, paramf, parama, paramInt, paramLayoutInflater);
    ListViewWithAnimatedView localListViewWithAnimatedView = localc.a();
    localListViewWithAnimatedView.setAnimatedView(this.f);
    localListViewWithAnimatedView.setSlideInListener(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        d.b(d.this).removeCallbacks(d.a(d.this));
        d.b(d.this).postDelayed(d.a(d.this), 200L);
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        d.b(d.this).removeCallbacks(d.a(d.this));
        d.c(d.this).e().a(true);
        if (d.this.d())
          d.d(d.this).e();
      }
    });
    localListViewWithAnimatedView.setSlideOutListener(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        d.b(d.this).removeCallbacks(d.a(d.this));
        d.b(d.this).postDelayed(d.a(d.this), 200L);
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        d.b(d.this).removeCallbacks(d.a(d.this));
        d.c(d.this).e().a(true);
        if (d.this.d())
          d.d(d.this).e();
      }
    });
    return localc;
  }

  public void a()
  {
    if (e())
      this.e.c();
  }

  public void a(a parama, ViewGroup paramViewGroup, View paramView, LayoutInflater paramLayoutInflater)
  {
    if ((parama == null) || (parama.h()));
    for (int j = 0; ; j = parama.e())
    {
      this.d = j;
      this.f = paramView;
      f localf = this.c.e();
      this.e = a(this.b, paramViewGroup, localf, this.g, this.d, paramLayoutInflater);
      return;
    }
  }

  public void b()
  {
    if (this.e != null)
      this.e.f();
  }

  public b c()
  {
    return this.e;
  }

  public boolean d()
  {
    return this.e != null;
  }

  public boolean e()
  {
    return (d()) && (this.e.b().getVisibility() == 0);
  }

  public static abstract interface a
  {
    public abstract void a(Sticker paramSticker, Bundle paramBundle);

    public abstract void a(Sticker paramSticker, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.d
 * JD-Core Version:    0.6.2
 */