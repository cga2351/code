package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.l;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class k
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public k(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    l locall = new l(paramView);
    d[] arrayOfd = new d[16];
    arrayOfd[0] = this.a.d(locall.g);
    arrayOfd[1] = this.a.a(locall.h);
    arrayOfd[2] = this.a.b(locall.i);
    arrayOfd[3] = this.a.c(locall.j);
    arrayOfd[4] = this.a.a(locall.a, locall.o);
    arrayOfd[5] = this.a.d(locall.b);
    arrayOfd[6] = this.a.a(locall.c);
    arrayOfd[7] = this.a.a(paramView);
    arrayOfd[8] = this.a.e(locall.d);
    arrayOfd[9] = this.a.a(locall.e, (c)paramView);
    arrayOfd[10] = this.a.b(locall.s, (c)paramView);
    arrayOfd[11] = this.a.o(locall.r);
    arrayOfd[12] = this.a.a(locall.k, locall.l);
    arrayOfd[13] = this.a.a((al)paramView, locall.q, locall.g);
    arrayOfd[14] = this.a.a(paramView, locall.m, locall.n, (c)paramView);
    arrayOfd[15] = this.a.r(locall.p);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), locall);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.k
 * JD-Core Version:    0.6.2
 */