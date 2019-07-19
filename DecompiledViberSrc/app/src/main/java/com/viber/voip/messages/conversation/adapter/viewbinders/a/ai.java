package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.aj;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class ai
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ai(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    aj localaj = new aj(paramView);
    d[] arrayOfd = new d[16];
    arrayOfd[0] = this.a.b(localaj.g);
    arrayOfd[1] = this.a.a(localaj.h);
    arrayOfd[2] = this.a.b(localaj.i);
    arrayOfd[3] = this.a.c(localaj.j);
    arrayOfd[4] = this.a.a(paramView);
    arrayOfd[5] = this.a.a(localaj.a);
    arrayOfd[6] = this.a.e(localaj.b);
    arrayOfd[7] = this.a.a(localaj.c, (c)paramView);
    arrayOfd[8] = this.a.b(localaj.d);
    arrayOfd[9] = this.a.c(localaj.e);
    arrayOfd[10] = this.a.a(localaj.f);
    arrayOfd[11] = this.a.a(localaj.q, localaj.g);
    arrayOfd[12] = this.a.n(localaj.p);
    arrayOfd[13] = this.a.a(localaj.k, localaj.l);
    arrayOfd[14] = this.a.a(paramView, localaj.m, localaj.n, (c)paramView);
    arrayOfd[15] = this.a.r(localaj.o);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localaj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ai
 * JD-Core Version:    0.6.2
 */