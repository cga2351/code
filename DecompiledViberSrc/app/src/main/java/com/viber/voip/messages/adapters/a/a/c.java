package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;

public class c
  implements a.a
{
  private final e a;

  public c(e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.b.c localc = new com.viber.voip.messages.adapters.b.c(paramView);
    d[] arrayOfd = new d[12];
    arrayOfd[0] = this.a.a(localc.j);
    arrayOfd[1] = this.a.a(localc.g);
    arrayOfd[2] = this.a.b(localc.g);
    arrayOfd[3] = this.a.a(localc.a);
    arrayOfd[4] = this.a.c(localc.d);
    arrayOfd[5] = this.a.a(localc.h);
    arrayOfd[6] = this.a.b(localc.e);
    arrayOfd[7] = this.a.d(localc.f);
    arrayOfd[8] = this.a.e(localc.b);
    arrayOfd[9] = this.a.b(localc.c);
    arrayOfd[10] = this.a.c(paramView);
    arrayOfd[11] = this.a.c(localc.k);
    return new a(new b(arrayOfd), localc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.c
 * JD-Core Version:    0.6.2
 */