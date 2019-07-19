package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.os.ResultReceiver;
import com.yandex.mobile.ads.impl.cp;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.es;
import com.yandex.mobile.ads.impl.et;
import com.yandex.mobile.ads.impl.ku;

public final class bg
{
  private AdTapHandler a;

  public final cp a(Context paramContext, eo parameo, ResultReceiver paramResultReceiver)
  {
    if (this.a != null)
    {
      et localet = es.a().a(paramContext);
      if ((localet != null) && (localet.b()));
      for (int i = 1; i != 0; i = 0)
        return new g(this.a);
    }
    return new ku(paramContext, parameo, paramResultReceiver);
  }

  final void a(AdTapHandler paramAdTapHandler)
  {
    this.a = paramAdTapHandler;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.bg
 * JD-Core Version:    0.6.2
 */