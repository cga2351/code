package com.yandex.mobile.ads.impl;

import android.view.View.OnClickListener;
import com.yandex.mobile.ads.nativeads.a;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.f;

public final class jq
{
  private final le a;
  private final a b;
  private final af c;
  private final ao d;

  public jq(le paramle, a parama, af paramaf, ao paramao)
  {
    this.a = paramle;
    this.b = parama;
    this.c = paramaf;
    this.d = paramao;
  }

  public final View.OnClickListener a(li paramli)
  {
    return this.c.d().a(this.a, paramli, this.b, this.c, this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jq
 * JD-Core Version:    0.6.2
 */