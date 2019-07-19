package com.yandex.mobile.ads.impl;

import android.content.Context;

public final class cq
  implements cs
{
  private final Context a;
  private final af b;

  public cq(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = af.a();
  }

  public final void a(String paramString)
  {
    bn localbn = new bn(paramString, new a(paramString));
    this.b.a(this.a, localbn);
  }

  private static final class a
    implements pl.a<oh>
  {
    private final String a;

    a(String paramString)
    {
      this.a = paramString;
    }

    public final void a(ov paramov)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.a;
      arrayOfObject[1] = paramov.toString();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cq
 * JD-Core Version:    0.6.2
 */