package com.crashlytics.android.a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class c
{
  final e a;
  final Map<String, Object> b = new ConcurrentHashMap();

  public c(e parame)
  {
    this.a = parame;
  }

  void a(String paramString, Number paramNumber)
  {
    if ((this.a.a(paramString, "key")) || (this.a.a(paramNumber, "value")))
      return;
    a(this.a.a(paramString), paramNumber);
  }

  void a(String paramString, Object paramObject)
  {
    if (!this.a.a(this.b, paramString))
      this.b.put(paramString, paramObject);
  }

  void a(String paramString1, String paramString2)
  {
    if ((this.a.a(paramString1, "key")) || (this.a.a(paramString2, "value")))
      return;
    a(this.a.a(paramString1), this.a.a(paramString2));
  }

  public String toString()
  {
    return new JSONObject(this.b).toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.c
 * JD-Core Version:    0.6.2
 */