package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.ae;

public final class kr
{
  private final ko a = new ko();
  private final cy b = new cy();

  public final void a(ak paramak, ae paramae)
  {
    if ((km)paramae.findViewById(7846) == null)
    {
      km localkm = new km(paramae.getContext(), this.b);
      localkm.setId(7846);
      paramae.addView(localkm);
    }
    ks localks = (ks)paramae.findViewById(7845);
    if (localks == null)
    {
      localks = new ks(paramae.getContext());
      localks.setId(7845);
      paramae.addView(localks);
    }
    localks.setDescription(this.a.a(paramak));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kr
 * JD-Core Version:    0.6.2
 */