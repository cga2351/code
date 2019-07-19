package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;

public class f
  implements a.a
{
  private final e a;

  public f(e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.b.f localf = new com.viber.voip.messages.adapters.b.f(paramView);
    d[] arrayOfd = new d[10];
    arrayOfd[0] = this.a.a(localf.h);
    arrayOfd[1] = this.a.a(localf.e);
    arrayOfd[2] = this.a.b(localf.e);
    arrayOfd[3] = this.a.a(localf.a);
    arrayOfd[4] = this.a.c(localf.c);
    arrayOfd[5] = this.a.a(localf.f);
    arrayOfd[6] = this.a.d(localf.d);
    arrayOfd[7] = this.a.e(localf.b);
    arrayOfd[8] = this.a.c(paramView);
    arrayOfd[9] = this.a.c(localf.i);
    return new a(new b(arrayOfd), localf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.f
 * JD-Core Version:    0.6.2
 */