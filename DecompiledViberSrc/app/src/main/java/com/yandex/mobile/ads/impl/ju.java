package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.View.OnClickListener;

public final class ju
  implements jt
{
  private final li a;
  private final jq b;

  public ju(li paramli, jq paramjq)
  {
    this.a = paramli;
    this.b = paramjq;
  }

  public final void a(View paramView, String paramString)
  {
    li localli = new li(this.a.a(), this.a.b(), this.a.c(), paramString);
    this.b.a(localli).onClick(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ju
 * JD-Core Version:    0.6.2
 */