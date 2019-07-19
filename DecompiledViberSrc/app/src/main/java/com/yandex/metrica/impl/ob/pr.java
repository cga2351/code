package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

public class pr
  implements px<String>
{
  private final String a;

  public pr(String paramString)
  {
    this.a = paramString;
  }

  public pv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return pv.a(this, this.a + " is empty.");
    return pv.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pr
 * JD-Core Version:    0.6.2
 */