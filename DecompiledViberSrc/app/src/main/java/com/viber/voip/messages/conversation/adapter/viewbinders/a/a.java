package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class a
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public a(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.conversation.adapter.c.a locala = new com.viber.voip.messages.conversation.adapter.c.a(paramView);
    d[] arrayOfd = new d[11];
    arrayOfd[0] = this.a.a(locala.a);
    arrayOfd[1] = this.a.b(locala.b);
    arrayOfd[2] = this.a.c(locala.c);
    arrayOfd[3] = this.a.e(locala.m);
    arrayOfd[4] = this.a.h(locala.f);
    arrayOfd[5] = this.a.i(locala.h);
    arrayOfd[6] = this.a.e(locala.l);
    arrayOfd[7] = this.a.h(locala.n);
    arrayOfd[8] = this.a.a(locala.g, locala.h, locala.i);
    arrayOfd[9] = this.a.a(locala.d, locala.e);
    arrayOfd[10] = this.a.a(paramView, locala.j, locala.k, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.a
 * JD-Core Version:    0.6.2
 */