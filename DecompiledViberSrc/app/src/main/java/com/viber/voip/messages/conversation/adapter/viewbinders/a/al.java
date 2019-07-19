package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.am;
import com.viber.voip.messages.conversation.adapter.viewbinders.bl;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class al
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public al(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    am localam = new am(paramView);
    bl localbl = this.a.a(localam.h, localam.i, localam.j, localam.k, localam.l, localam.g);
    d[] arrayOfd = new d[14];
    arrayOfd[0] = localbl;
    arrayOfd[1] = this.a.a(localam.g, localbl);
    arrayOfd[2] = this.a.a(localam.m);
    arrayOfd[3] = this.a.b(localam.n);
    arrayOfd[4] = this.a.c(localam.o);
    arrayOfd[5] = this.a.a(localam.a);
    arrayOfd[6] = this.a.a(localam.f);
    arrayOfd[7] = this.a.e(localam.b);
    arrayOfd[8] = this.a.a(localam.c, (c)paramView);
    arrayOfd[9] = this.a.c(localam.e);
    arrayOfd[10] = this.a.b(localam.d);
    arrayOfd[11] = this.a.a(localam.p, localam.q);
    arrayOfd[12] = this.a.a(paramView, localam.r, localam.s, (c)paramView);
    arrayOfd[13] = this.a.r(localam.t);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localam);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.al
 * JD-Core Version:    0.6.2
 */