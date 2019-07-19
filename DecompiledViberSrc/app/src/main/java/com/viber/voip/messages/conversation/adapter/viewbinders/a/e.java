package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.f;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class e
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public e(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    f localf = new f(paramView);
    d[] arrayOfd = new d[9];
    arrayOfd[0] = this.a.c(localf.i);
    arrayOfd[1] = this.a.a(localf.a);
    arrayOfd[2] = this.a.b(localf.b);
    arrayOfd[3] = this.a.c(localf.c);
    arrayOfd[4] = this.a.l(localf.f);
    arrayOfd[5] = this.a.k(localf.f);
    arrayOfd[6] = this.a.a(localf.j, localf.k);
    arrayOfd[7] = this.a.a(localf.d, localf.e);
    arrayOfd[8] = this.a.a(paramView, localf.g, localf.h, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.e
 * JD-Core Version:    0.6.2
 */