package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.lf;

public final class k extends NativeAdAssets
{
  private ar a;

  final void a(lf paramlf)
  {
    ar localar = null;
    if (paramlf != null)
      localar = new ar(paramlf);
    this.a = localar;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    k localk;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      if (!super.equals(paramObject))
        return false;
      localk = (k)paramObject;
      if (this.a != null)
        return this.a.equals(localk.a);
    }
    while (localk.a == null);
    return false;
  }

  public final int hashCode()
  {
    int i = 31 * super.hashCode();
    if (this.a != null);
    for (int j = this.a.hashCode(); ; j = 0)
      return j + i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.k
 * JD-Core Version:    0.6.2
 */