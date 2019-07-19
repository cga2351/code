package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.m;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class l
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public l(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    m localm = new m(paramView);
    d[] arrayOfd = new d[8];
    arrayOfd[0] = this.a.a(localm.g);
    arrayOfd[1] = this.a.b(localm.h);
    arrayOfd[2] = this.a.c(localm.i);
    arrayOfd[3] = this.a.e(localm.f);
    arrayOfd[4] = this.a.p(localm.e);
    arrayOfd[5] = this.a.a(localm.j, localm.k);
    arrayOfd[6] = this.a.a(localm.d, localm.l);
    arrayOfd[7] = this.a.a(paramView, localm.a, localm.b, (c)paramView, localm.d);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.l
 * JD-Core Version:    0.6.2
 */