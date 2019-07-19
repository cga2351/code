package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.y;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class x
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public x(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    y localy = new y(paramView);
    d[] arrayOfd = new d[8];
    arrayOfd[0] = this.a.c(localy.i);
    arrayOfd[1] = this.a.a(localy.a);
    arrayOfd[2] = this.a.b(localy.b);
    arrayOfd[3] = this.a.c(localy.c);
    arrayOfd[4] = this.a.l(localy.f);
    arrayOfd[5] = this.a.k(localy.f);
    arrayOfd[6] = this.a.a(localy.d, localy.e);
    arrayOfd[7] = this.a.a(paramView, localy.g, localy.h, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localy);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.x
 * JD-Core Version:    0.6.2
 */