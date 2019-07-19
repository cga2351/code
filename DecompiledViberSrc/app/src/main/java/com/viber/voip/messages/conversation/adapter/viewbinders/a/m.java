package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.n;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class m
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public m(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    n localn = new n(paramView);
    d[] arrayOfd = new d[14];
    arrayOfd[0] = this.a.e(localn.g);
    arrayOfd[1] = this.a.a(localn.h);
    arrayOfd[2] = this.a.b(localn.i);
    arrayOfd[3] = this.a.c(localn.j);
    arrayOfd[4] = this.a.a(localn.a, localn.o);
    arrayOfd[5] = this.a.d(localn.b);
    arrayOfd[6] = this.a.a(localn.c);
    arrayOfd[7] = this.a.e(localn.d);
    arrayOfd[8] = this.a.b(localn.r, (c)paramView);
    arrayOfd[9] = this.a.a(localn.s, localn.u, localn.t);
    arrayOfd[10] = this.a.a(localn.k, localn.l);
    arrayOfd[11] = this.a.a((al)paramView, localn.q, localn.g);
    arrayOfd[12] = this.a.a(paramView, localn.m, localn.n, (c)paramView);
    arrayOfd[13] = this.a.r(localn.p);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localn);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.m
 * JD-Core Version:    0.6.2
 */