package com.viber.voip.messages.ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Property;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.clock.CyclicClock;
import com.viber.svg.jni.clock.ProgressClock;
import com.viber.voip.R.anim;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.ui.SendButton;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.ui.d.f;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.af;

public class g
{
  private static final Logger a = ViberEnv.getLogger();
  private ImageView b;
  private f c;
  private f d;
  private f e;
  private ProgressClock f;
  private a g;
  private b h = b.a;
  private Animation i;
  private Animation j;
  private float k;
  private float l;
  private int m;
  private final Property<View, Integer> n = new Property(Integer.class, "bottomPadding")
  {
    public Integer a(View paramAnonymousView)
    {
      return Integer.valueOf(paramAnonymousView.getPaddingBottom());
    }

    public void a(View paramAnonymousView, Integer paramAnonymousInteger)
    {
      paramAnonymousView.setPadding(paramAnonymousView.getPaddingLeft(), paramAnonymousView.getPaddingTop(), paramAnonymousView.getPaddingRight(), paramAnonymousInteger.intValue());
    }
  };

  public g(a parama)
  {
    this.g = parama;
  }

  private int a(float paramFloat)
  {
    int i1 = (int)(100.0D * (paramFloat / this.l));
    if ((i1 > 10) && (i1 < 75))
      return (int)((350.0F + 4.0F * i1) / 13.0F);
    if (i1 >= 75)
      return (int)(2.0F * i1 - 100.0F);
    return 30;
  }

  private void b(View paramView, SendButton paramSendButton)
  {
    this.b = ((ImageView)paramView.findViewById(R.id.ptt_lock));
    this.b.setOnClickListener(new h(this));
    Context localContext = paramView.getContext();
    Resources localResources = localContext.getResources();
    this.l = (localResources.getDimensionPixelSize(R.dimen.ptt_lock_drag_dimention) + paramSendButton.getTop());
    this.k = (0.1F * this.l);
    this.m = localResources.getDimensionPixelSize(R.dimen.ptt_lock_animation_padding_offset);
    final int i1 = localResources.getDimensionPixelSize(R.dimen.ptt_lock_control_width);
    final int i2 = localResources.getDimensionPixelSize(R.dimen.ptt_lock_control_height);
    this.e = new f(dc.c(localContext, R.attr.conversationPttPreviewLockSuggestionPath))
    {
      public int getIntrinsicHeight()
      {
        return i2;
      }

      public int getIntrinsicWidth()
      {
        return i1;
      }
    };
    this.e.a(-65536);
    this.c = new f(dc.c(localContext, R.attr.conversationPttPreviewLockPath))
    {
      public int getIntrinsicHeight()
      {
        return i2;
      }

      public int getIntrinsicWidth()
      {
        return i1;
      }
    };
    this.d = new f(dc.c(localContext, R.attr.conversationPttPreviewLockClosedPath))
    {
      public int getIntrinsicHeight()
      {
        return i1;
      }

      public int getIntrinsicWidth()
      {
        return i1;
      }
    };
    this.f = new ProgressClock(0.0D, this.c.b() / 100.0D);
    this.d.a(new af(0.0D));
    this.e.a(new CyclicClock(this.e.b()));
    this.c.a(this.f);
    this.h = b.b;
    this.i = AnimationUtils.loadAnimation(this.b.getContext(), R.anim.bottom_slide_in);
    this.i.setDuration(100L);
    this.j = AnimationUtils.loadAnimation(this.b.getContext(), R.anim.bottom_slide_out);
    this.j.setDuration(100L);
    this.j.setAnimationListener(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        dj.c(g.a(g.this), 8);
        g.a(g.this).setImageDrawable(g.b(g.this));
      }
    });
  }

  private void d()
  {
    this.g.a();
    af localaf = new af(0.0D);
    this.d.a(localaf);
    this.b.setImageDrawable(this.d);
    this.b.setPadding(0, 0, 0, this.m);
    ObjectAnimator.ofInt(this.b, this.n, new int[] { 0 }).setDuration(200L).start();
    av.a(av.e.a).postDelayed(new i(this), 1000L);
  }

  public void a()
  {
    if (this.h != b.a)
    {
      this.h = b.a;
      this.b.startAnimation(this.j);
    }
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == 0.0F);
    do
    {
      int i1;
      do
      {
        return;
        if (b.c == this.h)
        {
          this.f.setProgress(100.0D);
          return;
        }
        if (paramFloat2 <= this.k)
        {
          this.b.setImageDrawable(this.e);
          return;
        }
        i1 = a(paramFloat2);
        this.b.setImageDrawable(this.c);
        this.f.setProgress(i1);
        this.b.invalidateDrawable(this.c);
      }
      while (i1 < 100);
      this.h = b.c;
    }
    while (this.g == null);
    d();
  }

  public void a(View paramView, SendButton paramSendButton)
  {
    if (this.h == b.a)
    {
      this.h = b.b;
      if (this.b == null)
        b(paramView, paramSendButton);
      this.f.setProgress(30.0D);
      this.b.setImageDrawable(this.e);
      this.b.startAnimation(this.i);
      dj.c(this.b, 0);
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();
  }

  static enum b
  {
    static
    {
      b[] arrayOfb = new b[4];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.g
 * JD-Core Version:    0.6.2
 */