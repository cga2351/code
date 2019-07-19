package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.o;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class n
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public n(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    o localo = new o(paramView);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = this.a.g(localo.f);
    arrayOfd[1] = this.a.a(localo.g);
    arrayOfd[2] = this.a.b(localo.h);
    arrayOfd[3] = this.a.c(localo.i);
    arrayOfd[4] = this.a.d(localo.b);
    arrayOfd[5] = this.a.a(localo.a, localo.n);
    arrayOfd[6] = this.a.a(paramView);
    arrayOfd[7] = this.a.a(localo.c);
    arrayOfd[8] = this.a.e(localo.d);
    arrayOfd[9] = this.a.a(localo.e, (c)paramView);
    arrayOfd[10] = this.a.a(localo.u, localo.v);
    arrayOfd[11] = this.a.a(localo.j, localo.k);
    arrayOfd[12] = this.a.a(paramView, localo.l, localo.m, (c)paramView);
    arrayOfd[13] = this.a.a(localo.q, localo.r, localo.s, localo.t, localo.p, localo.w);
    arrayOfd[14] = this.a.r(localo.o);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.n
 * JD-Core Version:    0.6.2
 */