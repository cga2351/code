package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.i;
import com.viber.voip.messages.conversation.adapter.viewbinders.r;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class h
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public h(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    i locali = new i(paramView);
    r localr = this.a.b(locali.r);
    d[] arrayOfd = new d[16];
    arrayOfd[0] = localr;
    arrayOfd[1] = this.a.a(locali.g, localr.b());
    arrayOfd[2] = this.a.a(locali.h);
    arrayOfd[3] = this.a.b(locali.i);
    arrayOfd[4] = this.a.c(locali.j);
    arrayOfd[5] = this.a.a(locali.a, locali.o);
    arrayOfd[6] = this.a.d(locali.b);
    arrayOfd[7] = this.a.a(locali.c);
    arrayOfd[8] = this.a.a(paramView);
    arrayOfd[9] = this.a.e(locali.d);
    arrayOfd[10] = this.a.a(locali.e, (c)paramView);
    arrayOfd[11] = this.a.b(locali.s, (c)paramView);
    arrayOfd[12] = this.a.a(locali.k, locali.l);
    arrayOfd[13] = this.a.b((al)paramView, locali.q, locali.g);
    arrayOfd[14] = this.a.a(paramView, locali.m, locali.n, (c)paramView);
    arrayOfd[15] = this.a.r(locali.p);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), locali);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.h
 * JD-Core Version:    0.6.2
 */