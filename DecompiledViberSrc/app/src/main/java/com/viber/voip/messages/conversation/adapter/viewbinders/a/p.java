package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.q;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class p
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public p(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    q localq = new q(paramView);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = this.a.b(localq.g);
    arrayOfd[1] = this.a.a(localq.h);
    arrayOfd[2] = this.a.b(localq.i);
    arrayOfd[3] = this.a.c(localq.j);
    arrayOfd[4] = this.a.a(localq.a, localq.o);
    arrayOfd[5] = this.a.d(localq.b);
    arrayOfd[6] = this.a.a(paramView);
    arrayOfd[7] = this.a.a(localq.c);
    arrayOfd[8] = this.a.e(localq.d);
    arrayOfd[9] = this.a.a(localq.e, (c)paramView);
    arrayOfd[10] = this.a.a(localq.q, localq.g);
    arrayOfd[11] = this.a.b(localq.r, localq.s);
    arrayOfd[12] = this.a.a(localq.k, localq.l);
    arrayOfd[13] = this.a.a(paramView, localq.m, localq.n, (c)paramView);
    arrayOfd[14] = this.a.r(localq.p);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localq);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.p
 * JD-Core Version:    0.6.2
 */