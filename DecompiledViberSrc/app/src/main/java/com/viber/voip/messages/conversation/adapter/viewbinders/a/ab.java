package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ac;
import com.viber.voip.messages.conversation.adapter.viewbinders.r;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class ab
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ab(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ac localac = new ac(paramView);
    r localr = this.a.b(localac.p);
    d[] arrayOfd = new d[16];
    arrayOfd[0] = localr;
    arrayOfd[1] = this.a.a(localac.f, localr.b());
    arrayOfd[2] = this.a.a(localac.g);
    arrayOfd[3] = this.a.b(localac.h);
    arrayOfd[4] = this.a.c(localac.i);
    arrayOfd[5] = this.a.a(localac.a);
    arrayOfd[6] = this.a.a(paramView);
    arrayOfd[7] = this.a.e(localac.b);
    arrayOfd[8] = this.a.a(localac.c, (c)paramView);
    arrayOfd[9] = this.a.b(localac.d);
    arrayOfd[10] = this.a.c(localac.e);
    arrayOfd[11] = this.a.b(localac.q, (c)paramView);
    arrayOfd[12] = this.a.a(localac.j, localac.k);
    arrayOfd[13] = this.a.b((al)paramView, localac.o, localac.f);
    arrayOfd[14] = this.a.a(paramView, localac.l, localac.m, (c)paramView);
    arrayOfd[15] = this.a.r(localac.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localac);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ab
 * JD-Core Version:    0.6.2
 */