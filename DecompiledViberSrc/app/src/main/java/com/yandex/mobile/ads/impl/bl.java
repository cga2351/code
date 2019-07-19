package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.File;

public final class bl
{
  public static oj a(Context paramContext)
  {
    on.a("Yandex Mobile Ads");
    on.b = false;
    ow localow = new ow(new ph(paramContext, new po()).a());
    new bh();
    File localFile = bh.a(paramContext, "mobileads-volley-cache");
    return new oj(new oy(localFile, (int)db.a(localFile)), localow);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bl
 * JD-Core Version:    0.6.2
 */