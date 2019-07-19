package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.yandex.mobile.ads.nativeads.a;
import com.yandex.mobile.ads.nativeads.af;

public final class jv
  implements View.OnClickListener
{
  private final le a;
  private final a b;
  private final af c;
  private final li d;
  private final ao e;

  public jv(le paramle, a parama, af paramaf, li paramli, ao paramao)
  {
    this.a = paramle;
    this.b = parama;
    this.c = paramaf;
    this.d = paramli;
    this.e = paramao;
  }

  public final void onClick(View paramView)
  {
    if ((this.d != null) && (this.a.e()))
    {
      if (this.e != null)
        this.e.c();
      Context localContext = paramView.getContext();
      this.b.a(localContext, this.d, this.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jv
 * JD-Core Version:    0.6.2
 */