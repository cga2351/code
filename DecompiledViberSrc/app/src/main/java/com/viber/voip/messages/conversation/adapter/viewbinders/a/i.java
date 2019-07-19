package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.j;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class i
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public i(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    j localj = new j(paramView);
    d[] arrayOfd = new d[18];
    arrayOfd[0] = this.a.e(localj.f);
    arrayOfd[1] = this.a.a(localj.g);
    arrayOfd[2] = this.a.b(localj.h);
    arrayOfd[3] = this.a.c(localj.i);
    arrayOfd[4] = this.a.a(localj.a, localj.n);
    arrayOfd[5] = this.a.d(localj.b);
    arrayOfd[6] = this.a.a(localj.c);
    arrayOfd[7] = this.a.a(paramView);
    arrayOfd[8] = this.a.e(localj.d);
    arrayOfd[9] = this.a.a(localj.e, (c)paramView);
    arrayOfd[10] = this.a.a(localj.r);
    arrayOfd[11] = this.a.b(localj.s, (c)paramView);
    arrayOfd[12] = this.a.a(localj.q, localj.f);
    arrayOfd[13] = this.a.n(localj.t);
    arrayOfd[14] = this.a.a(localj.j, localj.k);
    arrayOfd[15] = this.a.a((al)paramView, localj.p, localj.f);
    arrayOfd[16] = this.a.a(paramView, localj.l, localj.m, (c)paramView);
    arrayOfd[17] = this.a.r(localj.o);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.i
 * JD-Core Version:    0.6.2
 */