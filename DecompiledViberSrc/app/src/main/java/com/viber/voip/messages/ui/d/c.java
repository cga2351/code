package com.viber.voip.messages.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.adapters.z;
import com.viber.voip.messages.adapters.z.a;
import com.viber.voip.messages.ui.cd;
import com.viber.voip.messages.ui.cd.a;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.a;
import com.viber.voip.stickers.f;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.widget.ListViewWithAnimatedView;

public class c
  implements b
{
  private static final Logger a = ViberEnv.getLogger();
  private final View b;
  private final ListViewWithAnimatedView c;
  private final z d;
  private Animation e;
  private int f;

  public c(Context paramContext, ViewGroup paramViewGroup, z paramz, LayoutInflater paramLayoutInflater)
  {
    this.e = AnimationUtils.loadAnimation(paramContext, R.anim.fade_in);
    this.e.setDuration(150L);
    this.e.setAnimationListener(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        c.this.c();
      }
    });
    this.d = paramz;
    this.b = paramLayoutInflater.inflate(R.layout.menu_stickers, paramViewGroup, false);
    ((cd)this.b).setPositioningListener(new cd.a()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (c.a(c.this).c(paramAnonymousInt1))
          c.b(c.this).requestLayout();
      }
    });
    this.c = ((ListViewWithAnimatedView)this.b.findViewById(R.id.stickers_list));
    View localView = new View(paramContext);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, paramContext.getResources().getDimensionPixelSize(R.dimen.sticker_menu_height)));
    this.c.addFooterView(localView);
    this.c.setAdapter(this.d);
    this.c.setVerticalScrollBarEnabled(false);
    this.c.a(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        z localz = c.a(c.this);
        if (paramAnonymousInt == 0);
        for (boolean bool = true; ; bool = false)
        {
          localz.a(bool);
          return;
        }
      }
    });
  }

  public c(Context paramContext, ViewGroup paramViewGroup, f paramf, d.a parama, int paramInt, LayoutInflater paramLayoutInflater)
  {
    this(paramContext, paramViewGroup, new z(paramContext, paramInt, paramf, parama, new com.viber.voip.messages.adapters.c(paramContext), paramLayoutInflater), paramLayoutInflater);
    this.f = paramInt;
  }

  public ListViewWithAnimatedView a()
  {
    return this.c;
  }

  public void a(final int paramInt, final z.a parama)
  {
    final int i = this.f;
    this.f = paramInt;
    this.d.a(paramInt, this.c.getFirstVisiblePosition(), true, new z.a()
    {
      public void a()
      {
        if (i != paramInt)
        {
          if ((c.c(c.this).getAnimation() != null) && (!c.c(c.this).getAnimation().hasEnded()))
          {
            c.c(c.this).getAnimation().cancel();
            c.c(c.this).clearAnimation();
          }
          c.this.h();
          c.c(c.this).startAnimation(c.d(c.this));
        }
        while (true)
        {
          if (parama != null)
            parama.a();
          return;
          c.this.c();
        }
      }
    });
  }

  public void a(Sticker paramSticker)
  {
    this.d.a(paramSticker);
  }

  public void a(a parama)
  {
    if (parama.e() == this.f)
      this.d.a(this.f, this.c.getFirstVisiblePosition(), false, null);
  }

  public View b()
  {
    return this.b;
  }

  public void c()
  {
    if (this.d.c())
      this.d.notifyDataSetChanged();
  }

  public void d()
  {
    if ((this.d.d()) && (this.d.f()))
      this.d.notifyDataSetChanged();
  }

  public void e()
  {
    this.d.e();
  }

  public void f()
  {
    c();
  }

  public int g()
  {
    return this.f;
  }

  public void h()
  {
    this.c.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0));
    this.c.setSelectionFromTop(0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.c
 * JD-Core Version:    0.6.2
 */