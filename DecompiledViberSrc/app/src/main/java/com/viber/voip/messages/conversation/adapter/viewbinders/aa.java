package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.a.c.a.i.a;
import com.viber.voip.messages.conversation.adapter.d.n;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.messages.ui.view.AnimatedLikesView.a;
import com.viber.voip.messages.ui.view.AnimatedLikesView.b;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class aa extends e<a, i>
  implements View.OnClickListener
{
  private final AnimatedLikesView a;
  private final n b;

  public aa(AnimatedLikesView paramAnimatedLikesView, n paramn)
  {
    this.a = paramAnimatedLikesView;
    this.b = paramn;
    this.a.setLikesClickListener(this);
  }

  private void a(a parama)
  {
    com.viber.voip.messages.conversation.aa localaa = parama.c();
    if (localaa.ab())
    {
      AnimatedLikesView localAnimatedLikesView2 = this.a;
      if (localaa.n() <= 1);
      for (AnimatedLikesView.a locala2 = AnimatedLikesView.a.b; ; locala2 = AnimatedLikesView.a.f)
      {
        localAnimatedLikesView2.a(locala2);
        return;
      }
    }
    AnimatedLikesView localAnimatedLikesView1 = this.a;
    if (localaa.n() < 1);
    for (AnimatedLikesView.a locala1 = AnimatedLikesView.a.a; ; locala1 = AnimatedLikesView.a.e)
    {
      localAnimatedLikesView1.a(locala1);
      return;
    }
  }

  public void a(a parama, i parami)
  {
    int i;
    boolean bool;
    label85: AnimatedLikesView localAnimatedLikesView2;
    String str;
    if ((d() != null) && (((a)d()).c().y() != parama.c().y()))
    {
      i = 1;
      super.a(parama, parami);
      com.viber.voip.messages.conversation.aa localaa = parama.c();
      if ((!localaa.ac()) || (localaa.y() <= 0L))
        break label231;
      AnimatedLikesView localAnimatedLikesView1 = this.a;
      if (parami.j())
        break label210;
      bool = true;
      localAnimatedLikesView1.setEnabled(bool);
      localAnimatedLikesView2 = this.a;
      if (localaa.n() <= 0)
        break label216;
      str = da.b(localaa.n());
      label116: if (!localaa.ab())
        break label223;
    }
    label210: label216: label223: for (AnimatedLikesView.b localb = AnimatedLikesView.b.b; ; localb = AnimatedLikesView.b.a)
    {
      localAnimatedLikesView2.a(str, localb);
      i.a locala = parami.I();
      this.a.setStrokeColor(locala.a);
      this.a.a(locala.f);
      this.a.setCounterTextColor(locala);
      if (i != 0)
        this.a.a();
      dj.c(this.a, 0);
      this.a.setClickable(true);
      return;
      i = 0;
      break;
      bool = false;
      break label85;
      str = "";
      break label116;
    }
    label231: dj.c(this.a, 8);
    this.a.setClickable(false);
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if (locala != null)
    {
      a(locala);
      this.b.h(locala.c());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.aa
 * JD-Core Version:    0.6.2
 */