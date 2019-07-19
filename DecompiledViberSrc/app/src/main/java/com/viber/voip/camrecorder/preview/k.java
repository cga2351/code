package com.viber.voip.camrecorder.preview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.d.d.a;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.l;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.List;

class k
  implements View.OnClickListener, l<f>
{
  private static final Logger a = ViberEnv.getLogger();
  private f b;
  private i c;
  private View d;
  private ViewGroup e;
  private ViewGroup f;
  private View g;
  private View h;
  private AnimatorSet i;
  private AnimatorSet j;
  private int k = 0;
  private final a l;
  private final List<b> m;

  k(f paramf, a parama)
  {
    this.b = paramf;
    this.l = parama;
    this.m = new ArrayList();
    this.c = new i(this.b.getContext(), this.b.getView(), this.b.getLayoutInflater(), new d.a()
    {
      public void a(Sticker paramAnonymousSticker, Bundle paramAnonymousBundle)
      {
        k.a(k.this).a(paramAnonymousSticker);
        k.this.onHide();
      }

      public void a(Sticker paramAnonymousSticker, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, Bundle paramAnonymousBundle)
      {
      }
    });
  }

  private void a(int paramInt)
  {
    this.k = paramInt;
    f();
  }

  private void a(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.j != null)
      this.j.removeListener(paramAnimatorListener);
  }

  private void f()
  {
    this.l.a(this.k);
    int n = this.m.size();
    for (int i1 = 0; i1 < n; i1++)
      ((b)this.m.get(i1)).a(this.k);
  }

  private void g()
  {
    if (this.i != null);
    View localView1;
    do
    {
      return;
      localView1 = this.b.getView();
    }
    while (localView1 == null);
    int n = this.b.getContext().getResources().getDimensionPixelSize(R.dimen.custom_cam_top_controls_underlay_height);
    int i1 = localView1.getHeight();
    this.i = new AnimatorSet();
    AnimatorSet localAnimatorSet1 = this.i;
    Animator[] arrayOfAnimator1 = new Animator[2];
    ViewGroup localViewGroup1 = this.f;
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = i1;
    arrayOfFloat1[1] = 0.0F;
    arrayOfAnimator1[0] = ObjectAnimator.ofFloat(localViewGroup1, "translationY", arrayOfFloat1).setDuration(400L);
    View localView2 = this.g;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = (-n);
    arrayOfFloat2[1] = 0.0F;
    arrayOfAnimator1[1] = ObjectAnimator.ofFloat(localView2, "translationY", arrayOfFloat2).setDuration(400L);
    localAnimatorSet1.playTogether(arrayOfAnimator1);
    this.i.setInterpolator(new DecelerateInterpolator());
    this.j = new AnimatorSet();
    AnimatorSet localAnimatorSet2 = this.j;
    Animator[] arrayOfAnimator2 = new Animator[2];
    ViewGroup localViewGroup2 = this.f;
    float[] arrayOfFloat3 = new float[1];
    arrayOfFloat3[0] = (i1 - n);
    arrayOfAnimator2[0] = ObjectAnimator.ofFloat(localViewGroup2, "translationY", arrayOfFloat3).setDuration(400L);
    View localView3 = this.g;
    float[] arrayOfFloat4 = new float[1];
    arrayOfFloat4[0] = (-n);
    arrayOfAnimator2[1] = ObjectAnimator.ofFloat(localView3, "translationY", arrayOfFloat4).setDuration(400L);
    localAnimatorSet2.playTogether(arrayOfAnimator2);
    this.j.setInterpolator(new AccelerateInterpolator());
  }

  private void h()
  {
    if (this.e == null)
      onCreateView(this.b.getLayoutInflater(), (ViewGroup)this.b.getView(), null);
  }

  private void i()
  {
    this.f.removeView(this.d);
    this.d = this.c.a(null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, R.id.collapse_btn_bg);
    this.f.addView(this.d, 0, localLayoutParams);
    if (this.i != null)
      this.i.cancel();
    if (this.j != null)
      this.j.cancel();
    this.i = null;
    this.j = null;
  }

  private void j()
  {
    if (this.e.getVisibility() != 0)
      dj.b(this.e, true);
    this.c.i();
    a(1);
  }

  private void k()
  {
    if (this.e != null)
    {
      this.e.clearAnimation();
      if (this.i != null)
        this.i.cancel();
      if (this.j != null)
        this.j.cancel();
    }
  }

  private void l()
  {
    dj.b(this.e, false);
    a(0);
  }

  final void a(b paramb)
  {
    if (!this.m.contains(paramb))
      this.m.add(paramb);
  }

  public boolean a()
  {
    return 1 == this.k;
  }

  final void b(b paramb)
  {
    if (this.m.contains(paramb))
      this.m.remove(paramb);
  }

  public boolean b()
  {
    return (3 == this.k) || (2 == this.k);
  }

  void c()
  {
    this.c.o();
  }

  void d()
  {
    if (this.e != null)
      i();
    if (a())
      j();
  }

  public void e()
  {
    this.c.n();
    k();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.h)
      onHide();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.e != null)
      return this.d;
    this.e = ((ViewGroup)paramLayoutInflater.inflate(R.layout.activity_customcam_preview_sticker_menu_container, paramViewGroup, false));
    dj.b(this.e, false);
    this.f = ((ViewGroup)this.e.findViewById(R.id.sticker_menu_content));
    this.g = this.e.findViewById(R.id.toolbar_bg);
    this.h = this.e.findViewById(R.id.collapse_btn);
    this.h.setOnClickListener(this);
    i();
    paramViewGroup.addView(this.e);
    return this.e;
  }

  public void onHide()
  {
    if ((3 == this.k) || (!a()))
      return;
    g();
    if (2 == this.k)
      this.i.cancel();
    this.j.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        k.c(k.this);
        k.a(k.this, this);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        k.a(k.this, 3);
      }
    });
    this.j.start();
  }

  public void onShow()
  {
    h();
    if ((2 == this.k) || (a()))
      return;
    g();
    if (3 == this.k)
      this.j.cancel();
    dj.b(this.e, true);
    this.i.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        k.b(k.this);
        k.a(k.this, this);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        k.a(k.this, 2);
      }
    });
    this.i.start();
  }

  static abstract interface a extends k.b
  {
    public abstract void a(Sticker paramSticker);
  }

  static abstract interface b
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.k
 * JD-Core Version:    0.6.2
 */