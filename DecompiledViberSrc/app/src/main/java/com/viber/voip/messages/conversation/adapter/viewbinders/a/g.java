package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.h;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class g
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public g(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    h localh = new h(paramView);
    d[] arrayOfd = new d[17];
    arrayOfd[0] = this.a.b(localh.f);
    arrayOfd[1] = this.a.a(localh.g);
    arrayOfd[2] = this.a.b(localh.h);
    arrayOfd[3] = this.a.c(localh.i);
    arrayOfd[4] = this.a.a(localh.a, localh.n);
    arrayOfd[5] = this.a.d(localh.b);
    arrayOfd[6] = this.a.a(paramView);
    arrayOfd[7] = this.a.a(localh.c);
    arrayOfd[8] = this.a.e(localh.d);
    arrayOfd[9] = this.a.a(localh.e, (c)paramView);
    arrayOfd[10] = this.a.d(localh.s);
    arrayOfd[11] = this.a.b(localh.r, (c)paramView);
    arrayOfd[12] = this.a.n(localh.t);
    arrayOfd[13] = this.a.a(localh.j, localh.k);
    arrayOfd[14] = this.a.a(localh.p, localh.q, localh.f);
    arrayOfd[15] = this.a.a(paramView, localh.l, localh.m, (c)paramView);
    arrayOfd[16] = this.a.r(localh.o);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localh);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.g
 * JD-Core Version:    0.6.2
 */