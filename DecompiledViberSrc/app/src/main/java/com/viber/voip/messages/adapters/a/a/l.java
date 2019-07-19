package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;

public class l
  implements a.a
{
  private final e a;

  public l(e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.b.l locall = new com.viber.voip.messages.adapters.b.l(paramView);
    d[] arrayOfd = new d[7];
    arrayOfd[0] = this.a.c(locall.b);
    arrayOfd[1] = this.a.f(locall.e);
    arrayOfd[2] = this.a.g(locall.g);
    arrayOfd[3] = this.a.d(locall.f);
    arrayOfd[4] = this.a.a(locall.c);
    arrayOfd[5] = this.a.e(locall.a);
    arrayOfd[6] = this.a.c(paramView);
    return new a(new b(arrayOfd), locall);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.l
 * JD-Core Version:    0.6.2
 */