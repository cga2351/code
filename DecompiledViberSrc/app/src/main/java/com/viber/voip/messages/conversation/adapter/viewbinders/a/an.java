package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ao;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.al;
import com.viber.voip.widget.b.c;

public class an
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public an(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ao localao = new ao(paramView);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = this.a.e(localao.f);
    arrayOfd[1] = this.a.a(localao.g);
    arrayOfd[2] = this.a.b(localao.h);
    arrayOfd[3] = this.a.c(localao.i);
    arrayOfd[4] = this.a.a(localao.a);
    arrayOfd[5] = this.a.a(paramView);
    arrayOfd[6] = this.a.e(localao.b);
    arrayOfd[7] = this.a.a(localao.c, (c)paramView);
    arrayOfd[8] = this.a.b(localao.d);
    arrayOfd[9] = this.a.c(localao.e);
    arrayOfd[10] = this.a.f(localao.p);
    arrayOfd[11] = this.a.a(localao.o);
    arrayOfd[12] = this.a.a(localao.j, localao.k);
    arrayOfd[13] = this.a.a((al)paramView, localao.n, localao.f);
    arrayOfd[14] = this.a.a(paramView, localao.l, localao.m, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localao);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.an
 * JD-Core Version:    0.6.2
 */