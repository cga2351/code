package com.yandex.mobile.ads.nativeads;

import android.text.TextUtils;
import com.yandex.mobile.ads.impl.lh;
import com.yandex.mobile.ads.impl.ll;
import com.yandex.mobile.ads.impl.nd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class p
{
  private final nd a = new nd();

  public static List<String> a(ll paramll)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = nd.a(paramll).iterator();
    while (localIterator.hasNext())
    {
      lh locallh = (lh)localIterator.next();
      if (!TextUtils.isEmpty(locallh.d()))
        localArrayList.add(locallh.d());
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.p
 * JD-Core Version:    0.6.2
 */