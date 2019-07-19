package com.yandex.metrica.impl;

import com.yandex.metrica.impl.ob.pl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class r
{
  private Map<String, String> a = new HashMap();
  private pl b;

  r(pl parampl)
  {
    this.b = parampl;
  }

  String a()
  {
    if (this.a.isEmpty())
      return null;
    return new JSONObject(this.a).toString();
  }

  void a(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      this.a.remove(paramString1);
      return;
    }
    this.b.a(this.a, paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.r
 * JD-Core Version:    0.6.2
 */