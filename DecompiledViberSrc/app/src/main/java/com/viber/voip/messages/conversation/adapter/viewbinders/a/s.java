package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.t;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class s
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public s(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    t localt = new t(paramView);
    d[] arrayOfd = new d[12];
    arrayOfd[0] = this.a.b(localt.d);
    arrayOfd[1] = this.a.a(localt.e);
    arrayOfd[2] = this.a.b(localt.f);
    arrayOfd[3] = this.a.c(localt.g);
    arrayOfd[4] = this.a.e(localt.a);
    arrayOfd[5] = this.a.a(localt.b, (c)paramView);
    arrayOfd[6] = this.a.b(localt.c);
    arrayOfd[7] = this.a.a(localt.p, localt.m);
    arrayOfd[8] = this.a.d(localt.q);
    arrayOfd[9] = this.a.a(localt.h, localt.i);
    arrayOfd[10] = this.a.a(paramView, localt.j, localt.k, (c)paramView);
    arrayOfd[11] = this.a.a(localt.n, localt.o, localt.l, localt.d);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.s
 * JD-Core Version:    0.6.2
 */