package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class ak
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ak(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.conversation.adapter.c.al localal = new com.viber.voip.messages.conversation.adapter.c.al(paramView);
    d[] arrayOfd = new d[18];
    arrayOfd[0] = this.a.f(localal.f);
    arrayOfd[1] = this.a.a(localal.g);
    arrayOfd[2] = this.a.b(localal.h);
    arrayOfd[3] = this.a.c(localal.i);
    arrayOfd[4] = this.a.a(localal.a);
    arrayOfd[5] = this.a.a(paramView);
    arrayOfd[6] = this.a.e(localal.b);
    arrayOfd[7] = this.a.a(localal.c, (c)paramView);
    arrayOfd[8] = this.a.b(localal.d);
    arrayOfd[9] = this.a.c(localal.e);
    arrayOfd[10] = this.a.a(localal.q);
    arrayOfd[11] = this.a.g(localal.r);
    arrayOfd[12] = this.a.b(localal.s, (c)paramView);
    arrayOfd[13] = this.a.a(localal.p, localal.f);
    arrayOfd[14] = this.a.a(localal.j, localal.k);
    arrayOfd[15] = this.a.a((com.viber.voip.widget.al)paramView, localal.o, localal.f);
    arrayOfd[16] = this.a.a(paramView, localal.l, localal.m, (c)paramView);
    arrayOfd[17] = this.a.r(localal.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localal);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ak
 * JD-Core Version:    0.6.2
 */