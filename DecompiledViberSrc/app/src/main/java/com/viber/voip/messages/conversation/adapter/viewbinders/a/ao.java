package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ap;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class ao
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ao(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ap localap = new ap(paramView);
    d[] arrayOfd = new d[16];
    arrayOfd[0] = this.a.f(localap.f);
    arrayOfd[1] = this.a.a(localap.g);
    arrayOfd[2] = this.a.b(localap.h);
    arrayOfd[3] = this.a.c(localap.i);
    arrayOfd[4] = this.a.a(localap.a);
    arrayOfd[5] = this.a.a(paramView);
    arrayOfd[6] = this.a.e(localap.b);
    arrayOfd[7] = this.a.a(localap.c, (c)paramView);
    arrayOfd[8] = this.a.b(localap.d);
    arrayOfd[9] = this.a.c(localap.e);
    arrayOfd[10] = this.a.f(localap.q);
    arrayOfd[11] = this.a.a(localap.o);
    arrayOfd[12] = this.a.g(localap.p);
    arrayOfd[13] = this.a.a(localap.j, localap.k);
    arrayOfd[14] = this.a.a((al)paramView, localap.n, localap.f);
    arrayOfd[15] = this.a.a(paramView, localap.l, localap.m, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ao
 * JD-Core Version:    0.6.2
 */