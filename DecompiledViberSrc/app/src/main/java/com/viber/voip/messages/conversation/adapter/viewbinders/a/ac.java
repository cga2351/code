package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ad;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class ac
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ac(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ad localad = new ad(paramView);
    d[] arrayOfd = new d[18];
    arrayOfd[0] = this.a.e(localad.f);
    arrayOfd[1] = this.a.a(localad.g);
    arrayOfd[2] = this.a.b(localad.h);
    arrayOfd[3] = this.a.c(localad.i);
    arrayOfd[4] = this.a.a(localad.a);
    arrayOfd[5] = this.a.a(paramView);
    arrayOfd[6] = this.a.e(localad.b);
    arrayOfd[7] = this.a.a(localad.c, (c)paramView);
    arrayOfd[8] = this.a.b(localad.d);
    arrayOfd[9] = this.a.c(localad.e);
    arrayOfd[10] = this.a.a(localad.q);
    arrayOfd[11] = this.a.b(localad.r, (c)paramView);
    arrayOfd[12] = this.a.a(localad.p, localad.f);
    arrayOfd[13] = this.a.n(localad.s);
    arrayOfd[14] = this.a.a(localad.j, localad.k);
    arrayOfd[15] = this.a.a((al)paramView, localad.o, localad.f);
    arrayOfd[16] = this.a.a(paramView, localad.l, localad.m, (c)paramView);
    arrayOfd[17] = this.a.r(localad.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localad);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ac
 * JD-Core Version:    0.6.2
 */