package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ab;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class aa
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public aa(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ab localab = new ab(paramView);
    d[] arrayOfd = new d[17];
    arrayOfd[0] = this.a.b(localab.f);
    arrayOfd[1] = this.a.a(localab.g);
    arrayOfd[2] = this.a.b(localab.h);
    arrayOfd[3] = this.a.c(localab.i);
    arrayOfd[4] = this.a.a(localab.a);
    arrayOfd[5] = this.a.a(paramView);
    arrayOfd[6] = this.a.e(localab.b);
    arrayOfd[7] = this.a.a(localab.c, (c)paramView);
    arrayOfd[8] = this.a.b(localab.d);
    arrayOfd[9] = this.a.c(localab.e);
    arrayOfd[10] = this.a.d(localab.r);
    arrayOfd[11] = this.a.b(localab.q, (c)paramView);
    arrayOfd[12] = this.a.n(localab.s);
    arrayOfd[13] = this.a.a(localab.j, localab.k);
    arrayOfd[14] = this.a.a(localab.o, localab.p, localab.f);
    arrayOfd[15] = this.a.a(paramView, localab.l, localab.m, (c)paramView);
    arrayOfd[16] = this.a.r(localab.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localab);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.aa
 * JD-Core Version:    0.6.2
 */