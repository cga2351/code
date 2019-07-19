package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;

public final class hn
{
  private final hg a;

  public hn(hg paramhg)
  {
    this.a = paramhg;
  }

  public static hm a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    Context localContext = paramView.getContext();
    hf localhf = hg.a(paramView, paramBoolean1);
    if (paramBoolean2)
      return new hl(localhf);
    return new hk(localContext, localhf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.hn
 * JD-Core Version:    0.6.2
 */