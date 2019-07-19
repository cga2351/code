package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;

public class g
  implements a.a
{
  private final e a;

  public g(e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.b.g localg = new com.viber.voip.messages.adapters.b.g(paramView);
    d[] arrayOfd = new d[8];
    arrayOfd[0] = this.a.a(localg.g);
    arrayOfd[1] = this.a.a(localg.d);
    arrayOfd[2] = this.a.b(localg.d);
    arrayOfd[3] = this.a.a(localg.e);
    arrayOfd[4] = this.a.a(localg.a);
    arrayOfd[5] = this.a.a(localg.b);
    arrayOfd[6] = this.a.d(localg.c);
    arrayOfd[7] = this.a.c(paramView);
    return new a(new b(arrayOfd), localg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.g
 * JD-Core Version:    0.6.2
 */