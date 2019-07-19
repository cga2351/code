package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.p;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class o
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public o(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    p localp = new p(paramView);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = this.a.b(localp.g);
    arrayOfd[1] = this.a.a(localp.h);
    arrayOfd[2] = this.a.b(localp.i);
    arrayOfd[3] = this.a.c(localp.j);
    arrayOfd[4] = this.a.a(localp.a, localp.o);
    arrayOfd[5] = this.a.d(localp.b);
    arrayOfd[6] = this.a.a(paramView);
    arrayOfd[7] = this.a.a(localp.c);
    arrayOfd[8] = this.a.e(localp.d);
    arrayOfd[9] = this.a.a(localp.e, (c)paramView);
    arrayOfd[10] = this.a.a(localp.q, localp.g);
    arrayOfd[11] = this.a.n(localp.r);
    arrayOfd[12] = this.a.a(localp.k, localp.l);
    arrayOfd[13] = this.a.a(paramView, localp.m, localp.n, (c)paramView);
    arrayOfd[14] = this.a.r(localp.p);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localp);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.o
 * JD-Core Version:    0.6.2
 */