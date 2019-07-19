package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.u;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class t
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public t(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    u localu = new u(paramView);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = this.a.e(localu.g);
    arrayOfd[1] = this.a.a(localu.h);
    arrayOfd[2] = this.a.b(localu.i);
    arrayOfd[3] = this.a.c(localu.j);
    arrayOfd[4] = this.a.a(localu.a, localu.o);
    arrayOfd[5] = this.a.d(localu.b);
    arrayOfd[6] = this.a.a(localu.c);
    arrayOfd[7] = this.a.a(paramView);
    arrayOfd[8] = this.a.e(localu.d);
    arrayOfd[9] = this.a.a(localu.e, (c)paramView);
    arrayOfd[10] = this.a.f(localu.r);
    arrayOfd[11] = this.a.a(localu.q);
    arrayOfd[12] = this.a.a(localu.k, localu.l);
    arrayOfd[13] = this.a.a((al)paramView, localu.p, localu.g);
    arrayOfd[14] = this.a.a(paramView, localu.m, localu.n, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localu);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.t
 * JD-Core Version:    0.6.2
 */