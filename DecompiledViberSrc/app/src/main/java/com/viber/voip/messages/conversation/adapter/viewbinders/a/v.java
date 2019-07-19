package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.w;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class v
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public v(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    w localw = new w(paramView);
    d[] arrayOfd = new d[8];
    arrayOfd[0] = this.a.a(localw.a);
    arrayOfd[1] = this.a.b(localw.b);
    arrayOfd[2] = this.a.c(localw.c);
    arrayOfd[3] = this.a.m(localw.f);
    arrayOfd[4] = this.a.a(localw.i);
    arrayOfd[5] = this.a.q(localw.f);
    arrayOfd[6] = this.a.a(localw.d, localw.e);
    arrayOfd[7] = this.a.a(paramView, localw.g, localw.h, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.v
 * JD-Core Version:    0.6.2
 */