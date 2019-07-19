package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.e;
import com.viber.voip.ui.g.b;
import com.viber.voip.widget.b.c;

public class d
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public d(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    e locale = new e(paramView);
    com.viber.voip.ui.g.d[] arrayOfd = new com.viber.voip.ui.g.d[14];
    arrayOfd[0] = this.a.b(locale.g);
    arrayOfd[1] = this.a.a(locale.h);
    arrayOfd[2] = this.a.b(locale.i);
    arrayOfd[3] = this.a.c(locale.j);
    arrayOfd[4] = this.a.a(locale.a, locale.o);
    arrayOfd[5] = this.a.d(locale.b);
    arrayOfd[6] = this.a.a(locale.c);
    arrayOfd[7] = this.a.a(paramView);
    arrayOfd[8] = this.a.e(locale.d);
    arrayOfd[9] = this.a.a(locale.e, (c)paramView);
    arrayOfd[10] = this.a.f(locale.q);
    arrayOfd[11] = this.a.a(locale.k, locale.l);
    arrayOfd[12] = this.a.a(paramView, locale.m, locale.n, (c)paramView);
    arrayOfd[13] = this.a.r(locale.p);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), locale);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.d
 * JD-Core Version:    0.6.2
 */