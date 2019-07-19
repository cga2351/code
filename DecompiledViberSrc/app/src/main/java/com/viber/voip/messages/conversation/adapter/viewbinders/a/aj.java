package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ak;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class aj
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public aj(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ak localak = new ak(paramView);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = this.a.b(localak.g);
    arrayOfd[1] = this.a.a(localak.h);
    arrayOfd[2] = this.a.b(localak.i);
    arrayOfd[3] = this.a.c(localak.j);
    arrayOfd[4] = this.a.a(paramView);
    arrayOfd[5] = this.a.a(localak.b);
    arrayOfd[6] = this.a.e(localak.c);
    arrayOfd[7] = this.a.a(localak.d, (c)paramView);
    arrayOfd[8] = this.a.b(localak.e);
    arrayOfd[9] = this.a.c(localak.f);
    arrayOfd[10] = this.a.a(localak.p, localak.g);
    arrayOfd[11] = this.a.b(localak.q, localak.r);
    arrayOfd[12] = this.a.a(localak.k, localak.l);
    arrayOfd[13] = this.a.a(paramView, localak.m, localak.n, (c)paramView);
    arrayOfd[14] = this.a.r(localak.o);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localak);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.aj
 * JD-Core Version:    0.6.2
 */