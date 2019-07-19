package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.v;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class u
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public u(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    v localv = new v(paramView);
    d[] arrayOfd = new d[16];
    arrayOfd[0] = this.a.f(localv.g);
    arrayOfd[1] = this.a.a(localv.h);
    arrayOfd[2] = this.a.b(localv.i);
    arrayOfd[3] = this.a.c(localv.j);
    arrayOfd[4] = this.a.a(localv.a, localv.o);
    arrayOfd[5] = this.a.d(localv.b);
    arrayOfd[6] = this.a.a(localv.c);
    arrayOfd[7] = this.a.a(paramView);
    arrayOfd[8] = this.a.e(localv.d);
    arrayOfd[9] = this.a.a(localv.e, (c)paramView);
    arrayOfd[10] = this.a.f(localv.s);
    arrayOfd[11] = this.a.a(localv.q);
    arrayOfd[12] = this.a.g(localv.r);
    arrayOfd[13] = this.a.a(localv.k, localv.l);
    arrayOfd[14] = this.a.a((al)paramView, localv.p, localv.g);
    arrayOfd[15] = this.a.a(paramView, localv.m, localv.n, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.u
 * JD-Core Version:    0.6.2
 */