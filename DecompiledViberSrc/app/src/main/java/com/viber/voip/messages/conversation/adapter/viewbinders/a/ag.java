package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ah;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class ag
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ag(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ah localah = new ah(paramView);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = this.a.e(localah.f);
    arrayOfd[1] = this.a.a(localah.g);
    arrayOfd[2] = this.a.b(localah.h);
    arrayOfd[3] = this.a.c(localah.i);
    arrayOfd[4] = this.a.a(localah.a);
    arrayOfd[5] = this.a.e(localah.b);
    arrayOfd[6] = this.a.a(localah.c, (c)paramView);
    arrayOfd[7] = this.a.b(localah.d);
    arrayOfd[8] = this.a.c(localah.e);
    arrayOfd[9] = this.a.b(localah.s, (c)paramView);
    arrayOfd[10] = this.a.a(localah.j, localah.k);
    arrayOfd[11] = this.a.a((al)paramView, localah.r, localah.f);
    arrayOfd[12] = this.a.a(paramView, localah.l, localah.m, (c)paramView);
    arrayOfd[13] = this.a.a(localah.n, localah.p, localah.o);
    arrayOfd[14] = this.a.r(localah.q);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localah);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ag
 * JD-Core Version:    0.6.2
 */