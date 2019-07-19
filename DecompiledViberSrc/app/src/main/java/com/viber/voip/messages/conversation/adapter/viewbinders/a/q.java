package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.r;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class q
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public q(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    r localr = new r(paramView);
    d[] arrayOfd = new d[18];
    arrayOfd[0] = this.a.f(localr.g);
    arrayOfd[1] = this.a.a(localr.h);
    arrayOfd[2] = this.a.b(localr.i);
    arrayOfd[3] = this.a.c(localr.j);
    arrayOfd[4] = this.a.a(localr.a, localr.o);
    arrayOfd[5] = this.a.d(localr.b);
    arrayOfd[6] = this.a.a(localr.c);
    arrayOfd[7] = this.a.a(paramView);
    arrayOfd[8] = this.a.e(localr.d);
    arrayOfd[9] = this.a.a(localr.e, (c)paramView);
    arrayOfd[10] = this.a.a(localr.s);
    arrayOfd[11] = this.a.g(localr.t);
    arrayOfd[12] = this.a.b(localr.u, (c)paramView);
    arrayOfd[13] = this.a.a(localr.r, localr.g);
    arrayOfd[14] = this.a.a(localr.k, localr.l);
    arrayOfd[15] = this.a.a((al)paramView, localr.q, localr.g);
    arrayOfd[16] = this.a.a(paramView, localr.m, localr.n, (c)paramView);
    arrayOfd[17] = this.a.r(localr.p);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.q
 * JD-Core Version:    0.6.2
 */