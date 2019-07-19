package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.an;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class am
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public am(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    an localan = new an(paramView);
    d[] arrayOfd = new d[12];
    arrayOfd[0] = this.a.b(localan.f);
    arrayOfd[1] = this.a.a(localan.g);
    arrayOfd[2] = this.a.b(localan.h);
    arrayOfd[3] = this.a.c(localan.i);
    arrayOfd[4] = this.a.e(localan.a);
    arrayOfd[5] = this.a.a(localan.b, (c)paramView);
    arrayOfd[6] = this.a.b(localan.c);
    arrayOfd[7] = this.a.c(localan.d);
    arrayOfd[8] = this.a.a(localan.e);
    arrayOfd[9] = this.a.a(localan.j, localan.k);
    arrayOfd[10] = this.a.a(paramView, localan.l, localan.m, (c)paramView);
    arrayOfd[11] = this.a.a(localan.o, localan.p, localan.n, localan.f);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localan);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.am
 * JD-Core Version:    0.6.2
 */