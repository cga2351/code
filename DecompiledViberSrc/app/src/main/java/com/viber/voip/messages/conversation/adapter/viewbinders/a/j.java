package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.k;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class j
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public j(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    k localk = new k(paramView);
    d[] arrayOfd = new d[12];
    arrayOfd[0] = this.a.a(localk.f);
    arrayOfd[1] = this.a.b(localk.g);
    arrayOfd[2] = this.a.c(localk.h);
    arrayOfd[3] = this.a.d(localk.b);
    arrayOfd[4] = this.a.a(localk.a, localk.m);
    arrayOfd[5] = this.a.a(localk.c);
    arrayOfd[6] = this.a.e(localk.d);
    arrayOfd[7] = this.a.a(localk.e, (c)paramView);
    arrayOfd[8] = this.a.a(localk.o);
    arrayOfd[9] = this.a.a(localk.i, localk.j);
    arrayOfd[10] = this.a.a(paramView, localk.k, localk.l, (c)paramView);
    arrayOfd[11] = this.a.r(localk.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localk);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.j
 * JD-Core Version:    0.6.2
 */