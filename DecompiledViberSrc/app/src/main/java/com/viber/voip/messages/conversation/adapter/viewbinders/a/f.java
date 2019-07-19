package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.g;
import com.viber.voip.messages.conversation.adapter.viewbinders.r;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class f
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public f(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    g localg = new g(paramView);
    r localr = this.a.a(localg.q);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = localr;
    arrayOfd[1] = this.a.a(localg.f, localr.b());
    arrayOfd[2] = this.a.a(localg.g);
    arrayOfd[3] = this.a.b(localg.h);
    arrayOfd[4] = this.a.c(localg.i);
    arrayOfd[5] = this.a.a(localg.a, localg.r);
    arrayOfd[6] = this.a.d(localg.b);
    arrayOfd[7] = this.a.a(paramView);
    arrayOfd[8] = this.a.a(localg.c);
    arrayOfd[9] = this.a.e(localg.d);
    arrayOfd[10] = this.a.a(localg.e, (c)paramView);
    arrayOfd[11] = this.a.a(localg.o, localg.p);
    arrayOfd[12] = this.a.a(localg.j, localg.k);
    arrayOfd[13] = this.a.a(paramView, localg.l, localg.m, (c)paramView);
    arrayOfd[14] = this.a.r(localg.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.f
 * JD-Core Version:    0.6.2
 */