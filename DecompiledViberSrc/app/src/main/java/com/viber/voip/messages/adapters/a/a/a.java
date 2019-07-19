package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;

public class a
  implements a.a
{
  private final e a;

  public a(e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.b.a locala = new com.viber.voip.messages.adapters.b.a(paramView);
    d[] arrayOfd = new d[6];
    arrayOfd[0] = this.a.c(locala.b);
    arrayOfd[1] = this.a.f(locala.f);
    arrayOfd[2] = this.a.g(locala.c);
    arrayOfd[3] = this.a.d(locala.g);
    arrayOfd[4] = this.a.a(locala.d);
    arrayOfd[5] = this.a.e(locala.a);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.a
 * JD-Core Version:    0.6.2
 */