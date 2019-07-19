package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.View.OnClickListener;

public final class js
  implements jp
{
  private final View a;

  public js(View paramView)
  {
    this.a = paramView;
  }

  public final void a(li paramli, jq paramjq)
  {
    View.OnClickListener localOnClickListener = paramjq.a(paramli);
    this.a.setOnClickListener(localOnClickListener);
    jw localjw = jw.a(this.a.getContext());
    this.a.setOnTouchListener(localjw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.js
 * JD-Core Version:    0.6.2
 */