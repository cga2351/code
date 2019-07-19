package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.animation.Animator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ca;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.r;
import com.viber.voip.messages.d.l;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.ui.b.c;
import com.viber.voip.ui.b.d;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.h.a;

public class am extends e<com.viber.voip.messages.conversation.adapter.a.a, i>
{
  private static final Logger c = ViberEnv.getLogger();
  protected final ImageView a;
  protected boolean b;
  private final d d;
  private final ca e;
  private final r f;
  private Animator g;
  private Animation h;
  private l i;
  private final h.a j = new an(this);

  public am(ImageView paramImageView, d paramd, ca paramca, r paramr)
  {
    this.a = paramImageView;
    this.d = paramd;
    this.e = paramca;
    this.f = paramr;
    this.a.setOnClickListener(new ao(this));
  }

  private void b()
  {
    aa localaa = i();
    if (localaa == null)
      return;
    this.e.a(localaa, true);
    dj.c(this.a, 0);
    if (new l(localaa).equals(this.i))
    {
      this.i = null;
      d locald = this.d;
      ImageView localImageView = this.a;
      if (com.viber.common.d.a.b());
      for (Interpolator localInterpolator = c.g; ; localInterpolator = c.a)
      {
        this.g = locald.a(localImageView, 0, localInterpolator);
        return;
      }
    }
    this.a.setAlpha(1.0F);
    this.a.setScaleX(1.0F);
    this.a.setScaleY(1.0F);
  }

  private void c()
  {
    aa localaa = i();
    if (localaa == null)
      return;
    this.e.a(localaa, false);
    this.g = this.d.b(this.a, 0, c.h);
  }

  private void f()
  {
    aa localaa = i();
    if ((localaa != null) && (this.e.a(localaa)))
      this.a.startAnimation(g());
  }

  private Animation g()
  {
    if (this.h != null)
      return this.h;
    this.h = AnimationUtils.loadAnimation(this.a.getContext(), R.anim.sticker_clicker_click);
    this.h.setAnimationListener(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        aa localaa = am.a(am.this);
        if (localaa != null)
          am.b(am.this).b(localaa);
      }
    });
    return this.h;
  }

  private l h()
  {
    com.viber.voip.messages.conversation.adapter.a.a locala = (com.viber.voip.messages.conversation.adapter.a.a)d();
    if (locala != null)
      return locala.d();
    return null;
  }

  private aa i()
  {
    com.viber.voip.messages.conversation.adapter.a.a locala = (com.viber.voip.messages.conversation.adapter.a.a)d();
    if (locala != null)
      return locala.c();
    return null;
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    boolean bool1 = true;
    l locall1 = h();
    super.a(parama, parami);
    aa localaa = parama.c();
    l locall2 = parama.d();
    boolean bool2 = parami.n();
    boolean bool3 = this.e.b(localaa);
    boolean bool4;
    int k;
    label89: label115: l locall3;
    if ((!bool2) && (this.e.a(localaa)))
    {
      bool4 = bool1;
      if ((bool2) || (!locall2.equals(locall1)))
        break label206;
      k = bool1;
      if ((bool2) || (this.b == bool4) || (k == 0) || (bool4 == bool3))
        break label212;
      this.b = bool4;
      if (!bool1)
        break label217;
      locall3 = locall2;
      label129: this.i = locall3;
      if ((k == 0) && (this.g != null))
      {
        if (this.g.isStarted())
          this.g.cancel();
        this.g = null;
      }
      if (!bool4)
        break label223;
      this.e.a(localaa, this.a, parami.a(localaa), this.j);
    }
    label206: label212: label217: label223: 
    do
    {
      return;
      bool4 = false;
      break;
      k = 0;
      break label89;
      bool1 = false;
      break label115;
      locall3 = null;
      break label129;
      if (bool1)
      {
        c();
        return;
      }
    }
    while (this.g != null);
    dj.c(this.a, 8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.am
 * JD-Core Version:    0.6.2
 */