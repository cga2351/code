package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;

public class e
  implements a.a
{
  private final com.viber.voip.messages.adapters.a.e a;

  public e(com.viber.voip.messages.adapters.a.e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.b.e locale = new com.viber.voip.messages.adapters.b.e(paramView);
    d[] arrayOfd = new d[6];
    arrayOfd[0] = this.a.a(locale.e);
    arrayOfd[1] = this.a.a(locale.d);
    arrayOfd[2] = this.a.b(locale.d);
    arrayOfd[3] = this.a.a(locale.a);
    arrayOfd[4] = this.a.a(locale.b, locale.c);
    arrayOfd[5] = this.a.c(paramView);
    return new a(new b(arrayOfd), locale);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.e
 * JD-Core Version:    0.6.2
 */