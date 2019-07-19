package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ai;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class ah
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public ah(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ai localai = new ai(paramView);
    d[] arrayOfd = new d[17];
    arrayOfd[0] = this.a.g(localai.g);
    arrayOfd[1] = this.a.a(localai.h);
    arrayOfd[2] = this.a.b(localai.i);
    arrayOfd[3] = this.a.c(localai.j);
    arrayOfd[4] = this.a.a(paramView);
    arrayOfd[5] = this.a.a(localai.a);
    arrayOfd[6] = this.a.e(localai.b);
    arrayOfd[7] = this.a.a(localai.c, (c)paramView);
    arrayOfd[8] = this.a.b(localai.d);
    arrayOfd[9] = this.a.c(localai.e);
    arrayOfd[10] = this.a.a(localai.f);
    arrayOfd[11] = this.a.a(localai.w);
    arrayOfd[12] = this.a.a(localai.u, localai.v);
    arrayOfd[13] = this.a.a(localai.k, localai.l);
    arrayOfd[14] = this.a.a(paramView, localai.m, localai.n, (c)paramView);
    arrayOfd[15] = this.a.a(localai.q, localai.r, localai.s, localai.t, localai.p, localai.w);
    arrayOfd[16] = this.a.r(localai.o);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localai);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.ah
 * JD-Core Version:    0.6.2
 */