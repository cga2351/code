package com.yandex.mobile.ads.impl;

import org.json.JSONObject;

final class dy
{
  private final ds a;

  dy(ds paramds)
  {
    this.a = paramds;
  }

  private void b(String paramString)
  {
    c(String.format("window.mraidbridge.%s", new Object[] { paramString }));
  }

  private void c(String paramString)
  {
    this.a.loadUrl("javascript: ".concat(String.valueOf(paramString)));
    new Object[] { paramString };
  }

  final void a()
  {
    b("notifyReadyEvent();");
  }

  final void a(eb parameb)
  {
    b("nativeCallComplete(" + JSONObject.quote(parameb.a()) + ")");
  }

  final void a(eb parameb, String paramString)
  {
    b("notifyErrorEvent(" + JSONObject.quote(parameb.a()) + ", " + JSONObject.quote(paramString) + ")");
  }

  final void a(String paramString)
  {
    this.a.b(paramString);
  }

  final void a(ek[] paramArrayOfek)
  {
    if (paramArrayOfek.length > 0)
    {
      String str = "";
      StringBuilder localStringBuilder = new StringBuilder("fireChangeEvent({");
      int i = paramArrayOfek.length;
      for (int j = 0; j < i; j++)
      {
        ek localek = paramArrayOfek[j];
        localStringBuilder.append(str);
        localStringBuilder.append(localek.a());
        str = ", ";
      }
      localStringBuilder.append("})");
      b(localStringBuilder.toString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dy
 * JD-Core Version:    0.6.2
 */