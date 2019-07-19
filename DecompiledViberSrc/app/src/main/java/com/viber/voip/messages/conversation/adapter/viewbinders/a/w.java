package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.x;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class w
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public w(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    x localx = new x(paramView);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = this.a.b(localx.g);
    arrayOfd[1] = this.a.a(localx.h);
    arrayOfd[2] = this.a.b(localx.i);
    arrayOfd[3] = this.a.c(localx.j);
    arrayOfd[4] = this.a.a(localx.a);
    arrayOfd[5] = this.a.a(paramView);
    arrayOfd[6] = this.a.e(localx.b);
    arrayOfd[7] = this.a.a(localx.c, (c)paramView);
    arrayOfd[8] = this.a.b(localx.d);
    arrayOfd[9] = this.a.c(localx.e);
    arrayOfd[10] = this.a.a(localx.f);
    arrayOfd[11] = this.a.f(localx.p);
    arrayOfd[12] = this.a.a(localx.k, localx.l);
    arrayOfd[13] = this.a.a(paramView, localx.m, localx.n, (c)paramView);
    arrayOfd[14] = this.a.r(localx.o);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localx);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.w
 * JD-Core Version:    0.6.2
 */