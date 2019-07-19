package com.amazon.device.iap.internal.b;

import java.util.HashMap;
import java.util.Map;

public class h
{
  public final Map<String, Object> a = new HashMap();

  static
  {
    if (!h.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      b = bool;
      return;
    }
  }

  public Object a()
  {
    return this.a.get("RESPONSE");
  }

  public Object a(String paramString)
  {
    return this.a.get(paramString);
  }

  public void a(Object paramObject)
  {
    if ((!b) && (paramObject == null))
      throw new AssertionError();
    this.a.put("RESPONSE", paramObject);
  }

  public void a(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
  }

  public void b()
  {
    this.a.remove("RESPONSE");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.h
 * JD-Core Version:    0.6.2
 */