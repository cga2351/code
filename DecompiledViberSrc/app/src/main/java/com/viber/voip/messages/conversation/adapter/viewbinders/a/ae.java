package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.af;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class ae
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ae(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    af localaf = new af(paramView);
    d[] arrayOfd = new d[16];
    arrayOfd[0] = this.a.d(localaf.f);
    arrayOfd[1] = this.a.a(localaf.g);
    arrayOfd[2] = this.a.b(localaf.h);
    arrayOfd[3] = this.a.c(localaf.i);
    arrayOfd[4] = this.a.a(localaf.a);
    arrayOfd[5] = this.a.a(paramView);
    arrayOfd[6] = this.a.e(localaf.b);
    arrayOfd[7] = this.a.a(localaf.c, (c)paramView);
    arrayOfd[8] = this.a.b(localaf.d);
    arrayOfd[9] = this.a.c(localaf.e);
    arrayOfd[10] = this.a.b(localaf.q, (c)paramView);
    arrayOfd[11] = this.a.o(localaf.p);
    arrayOfd[12] = this.a.a(localaf.j, localaf.k);
    arrayOfd[13] = this.a.a((al)paramView, localaf.o, localaf.f);
    arrayOfd[14] = this.a.a(paramView, localaf.l, localaf.m, (c)paramView);
    arrayOfd[15] = this.a.r(localaf.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localaf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ae
 * JD-Core Version:    0.6.2
 */