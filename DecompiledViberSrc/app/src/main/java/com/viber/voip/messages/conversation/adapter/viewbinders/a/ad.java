package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ae;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class ad
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ad(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ae localae = new ae(paramView);
    d[] arrayOfd = new d[12];
    arrayOfd[0] = this.a.a(localae.f);
    arrayOfd[1] = this.a.b(localae.g);
    arrayOfd[2] = this.a.c(localae.h);
    arrayOfd[3] = this.a.a(localae.a);
    arrayOfd[4] = this.a.e(localae.b);
    arrayOfd[5] = this.a.a(localae.c, (c)paramView);
    arrayOfd[6] = this.a.b(localae.d);
    arrayOfd[7] = this.a.c(localae.e);
    arrayOfd[8] = this.a.a(localae.n);
    arrayOfd[9] = this.a.a(localae.i, localae.j);
    arrayOfd[10] = this.a.a(paramView, localae.k, localae.l, (c)paramView);
    arrayOfd[11] = this.a.r(localae.m);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localae);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ad
 * JD-Core Version:    0.6.2
 */