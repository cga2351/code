package com.viber.voip.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.h.a;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.d;
import com.viber.voip.messages.conversation.adapter.d.v.b;
import com.viber.voip.messages.conversation.adapter.d.v.c;
import com.viber.voip.messages.d.l;
import com.viber.voip.messages.ui.view.AudioPttVolumeBarsView;
import com.viber.voip.messages.ui.view.AudioPttVolumeBarsView.a;
import com.viber.voip.q.a.a;
import com.viber.voip.q.i;
import com.viber.voip.sound.ptt.PttUtils.AudioBarsInfo;
import com.viber.voip.ui.dialogs.ah;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.util.ae;
import com.viber.voip.util.dj;
import com.viber.voip.widget.AudioPttControlView;

public class bf
  implements v.b, v.c, AudioPttVolumeBarsView.a
{
  private final ImageView a;
  private final AudioPttVolumeBarsView b;
  private final View c;
  private final AudioPttControlView d;
  private final TextView e;
  private final Context f;
  private com.viber.voip.q.a g;
  private c h;
  private a i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private l m;

  public bf(ImageView paramImageView, AudioPttVolumeBarsView paramAudioPttVolumeBarsView, View paramView, AudioPttControlView paramAudioPttControlView, TextView paramTextView, ai paramai, i parami, Handler paramHandler, Context paramContext, d paramd, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    this.a = paramImageView;
    this.b = paramAudioPttVolumeBarsView;
    this.c = paramView;
    this.d = paramAudioPttControlView;
    this.e = paramTextView;
    this.f = paramContext;
    if (com.viber.common.d.a.g());
    for (Object localObject = new b(); ; localObject = new a()
    {
      public void a()
      {
        bg.a(this);
      }

      public void b()
      {
        bg.b(this);
      }

      public boolean c()
      {
        return bg.c(this);
      }
    })
    {
      this.i = ((a)localObject);
      this.h = new c();
      this.g = new com.viber.voip.q.a(paramai, parami, paramHandler, paramd);
      this.j = paramDrawable1;
      this.k = paramDrawable2;
      this.l = paramDrawable3;
      return;
    }
  }

  private void a(Drawable paramDrawable, boolean paramBoolean)
  {
    dj.c(this.a, paramBoolean);
    dj.c(this.e, paramBoolean);
    this.a.setImageDrawable(paramDrawable);
  }

  private void a(l paraml, aa paramaa, boolean paramBoolean)
  {
    if (!paraml.equals(this.m));
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
        c();
      this.m = paraml;
      b();
      this.g.a(paramaa, bool);
      if (paramBoolean)
        this.g.b();
      return;
    }
  }

  public View a()
  {
    return this.c;
  }

  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
      this.g.a(paramFloat1, paramFloat2, paramBoolean2);
  }

  public void a(View paramView)
  {
    if (this.c != paramView)
      return;
    this.b.a(paramView);
  }

  public void a(View paramView, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.c != paramView)
      return;
    this.b.a(paramView, paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    this.g.a(false);
    a(new l(paramaa), paramaa, paramBoolean);
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, boolean paramBoolean)
  {
    a(parama.d(), parama.c(), paramBoolean);
  }

  public void b()
  {
    this.g.a(this.h);
    this.b.setProgressChangeListener(this);
  }

  public void b(View paramView)
  {
    if (this.c != paramView)
      return;
    this.b.b(paramView);
  }

  public void c()
  {
    this.g.a();
    this.b.setProgressChangeListener(null);
    this.i.b();
    this.b.b();
    this.b.d();
  }

  public void d()
  {
    this.g.b();
  }

  static abstract interface a
  {
    public abstract void a();

    public abstract void b();

    public abstract boolean c();
  }

  class b
    implements bf.a
  {
    private AnimatorSet b;

    b()
    {
    }

    private AnimatorSet d()
    {
      if (this.b == null)
      {
        this.b = new AnimatorSet();
        this.b.setDuration(400L);
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
        localValueAnimator.addUpdateListener(new bh(this));
        AnimatorSet localAnimatorSet = this.b;
        Animator[] arrayOfAnimator = new Animator[3];
        arrayOfAnimator[0] = localValueAnimator;
        arrayOfAnimator[1] = ObjectAnimator.ofFloat(bf.a(bf.this), View.ALPHA, new float[] { 0.4F, 1.0F });
        arrayOfAnimator[2] = ObjectAnimator.ofFloat(bf.b(bf.this), View.ALPHA, new float[] { 0.0F, 1.0F });
        localAnimatorSet.playTogether(arrayOfAnimator);
      }
      return this.b;
    }

    public void a()
    {
      if (c())
        d().cancel();
      bf.c(bf.this).setImageAlpha(0);
      bf.a(bf.this).setAlpha(0.4F);
      bf.b(bf.this).setAlpha(0.0F);
      d().start();
    }

    public void b()
    {
      if (c())
        d().cancel();
      bf.c(bf.this).setImageAlpha(255);
      bf.b(bf.this).setAlpha(1.0F);
      bf.a(bf.this).setAlpha(1.0F);
    }

    public boolean c()
    {
      return (this.b != null) && (this.b.isStarted());
    }
  }

  class c
    implements a.a
  {
    c()
    {
    }

    public void a()
    {
      bf.a(bf.this, bf.g(bf.this), true);
      bf.a(bf.this).a(false);
      bf.f(bf.this).setUnreadState(false);
    }

    public void a(float paramFloat)
    {
      bf.f(bf.this).setProgress(paramFloat);
    }

    public void a(int paramInt)
    {
      bf.a(bf.this).a(paramInt / 100.0D);
    }

    public void a(long paramLong)
    {
      bf.b(bf.this).setVisibility(0);
      bf.b(bf.this).setText(ae.f(paramLong));
    }

    public void a(long paramLong, boolean paramBoolean)
    {
      if ((paramBoolean) && (bf.f(bf.this).e()))
        return;
      bf.f(bf.this).a(paramLong);
    }

    public void a(PttUtils.AudioBarsInfo paramAudioBarsInfo)
    {
      bf.f(bf.this).setAudioBarsInfo(paramAudioBarsInfo);
    }

    public void a(boolean paramBoolean)
    {
      bf localbf = bf.this;
      if (paramBoolean);
      for (Drawable localDrawable = bf.d(bf.this); ; localDrawable = bf.e(bf.this))
      {
        bf.a(localbf, localDrawable, true);
        bf.a(bf.this).a(paramBoolean);
        bf.f(bf.this).setUnreadState(paramBoolean);
        return;
      }
    }

    public void b()
    {
      if (bf.h(bf.this).c())
        return;
      bf.h(bf.this).a();
    }

    public void b(boolean paramBoolean)
    {
      bf.a(bf.this, null, false);
      bf.a(bf.this).a(0.0D);
      bf.f(bf.this).setUnreadState(paramBoolean);
    }

    public void c()
    {
      if (bf.f(bf.this).c())
        return;
      bf.f(bf.this).a();
    }

    public void d()
    {
      bf.f(bf.this).d();
    }

    public void e()
    {
      ViberApplication.getInstance().showToast(R.string.file_not_found);
    }

    public void f()
    {
      p.b(2).d();
    }

    public void g()
    {
      ah.d().d();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.bf
 * JD-Core Version:    0.6.2
 */