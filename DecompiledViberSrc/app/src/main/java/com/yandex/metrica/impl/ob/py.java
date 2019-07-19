package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.UUID;

public class py
  implements px<String>
{
  public pv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return pv.a(this, "ApiKey is empty. Please, read official documentation how to obtain one: https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-initialize-docpage/");
    try
    {
      UUID.fromString(paramString);
      pv localpv = pv.a(this);
      return localpv;
    }
    catch (Exception localException)
    {
    }
    return pv.a(this, "Invalid ApiKey=" + paramString + ". Please, read official documentation how to obtain one: https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-initialize-docpage/");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.py
 * JD-Core Version:    0.6.2
 */