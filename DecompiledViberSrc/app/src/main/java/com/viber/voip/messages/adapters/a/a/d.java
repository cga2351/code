package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.b;

public class d
  implements a.a
{
  private final e a;

  public d(e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.b.d locald = new com.viber.voip.messages.adapters.b.d(paramView);
    com.viber.voip.ui.g.d[] arrayOfd = new com.viber.voip.ui.g.d[7];
    arrayOfd[0] = this.a.a(locald.g);
    arrayOfd[1] = this.a.a(locald.f);
    arrayOfd[2] = this.a.b(locald.f);
    arrayOfd[3] = this.a.a(locald.a);
    arrayOfd[4] = this.a.d(locald.e);
    arrayOfd[5] = this.a.a(locald.b, locald.c);
    arrayOfd[6] = this.a.c(paramView);
    return new a(new b(arrayOfd), locald);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.d
 * JD-Core Version:    0.6.2
 */