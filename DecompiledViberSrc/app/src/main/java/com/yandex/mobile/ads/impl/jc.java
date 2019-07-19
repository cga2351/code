package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.mobile.ads.nativeads.Rating;

public final class jc<V extends View,  extends Rating> extends je<V, String>
{
  public jc(V paramV)
  {
    super(paramV);
  }

  public final void a(V paramV)
  {
    ((Rating)paramV).setRating(Float.valueOf(0.0F));
    super.a(paramV);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jc
 * JD-Core Version:    0.6.2
 */