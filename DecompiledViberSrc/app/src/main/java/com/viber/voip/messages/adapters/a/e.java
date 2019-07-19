package com.viber.voip.messages.adapters.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.messages.adapters.a.b.ab;
import com.viber.voip.messages.adapters.a.b.c;
import com.viber.voip.messages.adapters.a.b.d;
import com.viber.voip.messages.adapters.a.b.f;
import com.viber.voip.messages.adapters.a.b.g;
import com.viber.voip.messages.adapters.a.b.h;
import com.viber.voip.messages.adapters.a.b.i;
import com.viber.voip.messages.adapters.a.b.k;
import com.viber.voip.messages.adapters.a.b.l;
import com.viber.voip.messages.adapters.a.b.m;
import com.viber.voip.messages.adapters.a.b.n;
import com.viber.voip.messages.adapters.a.b.o;
import com.viber.voip.messages.adapters.a.b.p;
import com.viber.voip.messages.adapters.a.b.q;
import com.viber.voip.messages.adapters.a.b.r;
import com.viber.voip.messages.adapters.a.b.x;
import com.viber.voip.messages.adapters.a.b.y;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.widget.AccurateChronometer;
import com.viber.voip.widget.AvatarWithInitialsView;
import com.viber.voip.widget.GroupIconView;
import javax.inject.Inject;

public class e
{
  private final com.viber.voip.util.e.e a;
  private final com.viber.voip.messages.j b;
  private final ai c;
  private final com.viber.voip.messages.d.b d;
  private com.viber.voip.messages.adapters.c.b e;

  @Inject
  public e(com.viber.voip.util.e.e parame, com.viber.voip.messages.j paramj, ai paramai, com.viber.voip.messages.d.b paramb)
  {
    this.a = parame;
    this.b = paramj;
    this.c = paramai;
    this.d = paramb;
  }

  public <T extends a> ab<T> a(TextView paramTextView)
  {
    return new ab(paramTextView);
  }

  public c a(AccurateChronometer paramAccurateChronometer)
  {
    return new c(paramAccurateChronometer);
  }

  public com.viber.voip.messages.adapters.a.b.e a(ViberTextView paramViberTextView)
  {
    return new com.viber.voip.messages.adapters.a.b.e(paramViberTextView.getContext(), paramViberTextView);
  }

  public <T extends a> f<T> a(AvatarWithInitialsView paramAvatarWithInitialsView)
  {
    return new f(paramAvatarWithInitialsView.getContext(), paramAvatarWithInitialsView, this.a);
  }

  public h a(ImageView paramImageView)
  {
    return new h(paramImageView.getContext(), paramImageView);
  }

  public <T extends a> com.viber.voip.messages.adapters.a.b.j<T> a(GroupIconView paramGroupIconView)
  {
    return new com.viber.voip.messages.adapters.a.b.j(paramGroupIconView.getContext(), paramGroupIconView, this.a);
  }

  public r a(View paramView)
  {
    return new r(paramView);
  }

  public x a(View paramView, TextView paramTextView)
  {
    return new x(paramView, paramTextView);
  }

  public void a(com.viber.voip.messages.adapters.c.b paramb)
  {
    this.e = paramb;
  }

  public <T extends a> g<T> b(TextView paramTextView)
  {
    return new g(paramTextView);
  }

  public p b(ImageView paramImageView)
  {
    return new p(paramImageView, this.e);
  }

  public q b(View paramView)
  {
    return new q(paramView);
  }

  public <T extends a> com.viber.voip.messages.adapters.a.b.b<T> c(View paramView)
  {
    return new com.viber.voip.messages.adapters.a.b.b(paramView);
  }

  public <T extends a> i<T> c(TextView paramTextView)
  {
    return new i(paramTextView.getContext(), paramTextView);
  }

  public o c(ImageView paramImageView)
  {
    return new o(paramImageView);
  }

  public d d(View paramView)
  {
    return new d(paramView, this.e);
  }

  public k d(ImageView paramImageView)
  {
    return new k(paramImageView);
  }

  public <T extends a> y<T> d(TextView paramTextView)
  {
    return new y(paramTextView.getContext(), paramTextView, this.d, this.b, this.c);
  }

  public <T extends a> n<T> e(TextView paramTextView)
  {
    return new n(paramTextView);
  }

  public m f(TextView paramTextView)
  {
    return new m(paramTextView.getContext(), paramTextView);
  }

  public l g(TextView paramTextView)
  {
    return new l(paramTextView.getContext(), paramTextView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.e
 * JD-Core Version:    0.6.2
 */