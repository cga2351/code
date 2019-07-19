package com.viber.voip.vln.a;

import android.support.v4.util.ArrayMap;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.viber.voip.analytics.e.b;
import com.viber.voip.analytics.story.n;
import com.viber.voip.util.da;

public class d
  implements c
{
  private final com.viber.voip.analytics.g a;

  public d(com.viber.voip.analytics.g paramg)
  {
    this.a = paramg;
  }

  public void a(ReadableArray paramReadableArray, Promise paramPromise)
  {
    if ((paramReadableArray == null) || (paramReadableArray.size() == 0))
    {
      paramPromise.reject("IllegalArgument", "properties is empty");
      return;
    }
    this.a.a(e.a(paramReadableArray, com.viber.voip.analytics.e.g.e));
    paramPromise.resolve(null);
  }

  public void a(ReadableMap paramReadableMap, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("IllegalArgument", "properties is null");
      return;
    }
    this.a.a(e.a(paramReadableMap, com.viber.voip.analytics.e.g.c));
    paramPromise.resolve(null);
  }

  public void a(String paramString, Promise paramPromise)
  {
    if (da.a(paramString))
    {
      paramPromise.reject("IllegalArgument", "event name is empty");
      return;
    }
    this.a.b(e.a(paramString, null, b.class));
    paramPromise.resolve(null);
  }

  public void a(String paramString, ReadableMap paramReadableMap, Promise paramPromise)
  {
    if (da.a(paramString))
    {
      paramPromise.reject("IllegalArgument", "event name is empty");
      return;
    }
    this.a.a(e.a(paramString, paramReadableMap, b.class));
    paramPromise.resolve(null);
  }

  public void a(String paramString, Integer paramInteger, Promise paramPromise)
  {
    if (da.a(paramString))
    {
      paramPromise.reject("IllegalArgument", "property name is empty");
      return;
    }
    if (paramInteger == null)
    {
      paramPromise.reject("IllegalArgument", "num is null");
      return;
    }
    this.a.a(n.a(paramString, paramInteger.intValue()));
    paramPromise.resolve(null);
  }

  public void b(ReadableMap paramReadableMap, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("IllegalArgument", "properties is null");
      return;
    }
    this.a.a(e.a(paramReadableMap, com.viber.voip.analytics.e.g.b));
    paramPromise.resolve(null);
  }

  public void b(String paramString, Promise paramPromise)
  {
    if (paramString == null)
    {
      paramPromise.reject("IllegalArgument", "properties is null");
      return;
    }
    this.a.b(com.viber.voip.analytics.story.g.a(paramString, "", b.class));
    paramPromise.resolve(null);
  }

  public void c(ReadableMap paramReadableMap, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("IllegalArgument", "properties is null");
      return;
    }
    this.a.a(e.a(paramReadableMap, com.viber.voip.analytics.e.g.f));
    paramPromise.resolve(null);
  }

  public void d(ReadableMap paramReadableMap, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("IllegalArgument", "properties is null");
      return;
    }
    this.a.a(e.a(paramReadableMap, com.viber.voip.analytics.e.g.g));
    paramPromise.resolve(null);
  }

  public void e(ReadableMap paramReadableMap, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("IllegalArgument", "properties is null");
      return;
    }
    ArrayMap localArrayMap = n.a(paramReadableMap.toHashMap());
    this.a.a(n.a(localArrayMap, "", new String[] { "" }));
    paramPromise.resolve(null);
  }

  public void f(ReadableMap paramReadableMap, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("IllegalArgument", "properties is null");
      return;
    }
    this.a.a(com.viber.voip.analytics.story.g.b(paramReadableMap.toHashMap(), new Class[] { b.class }));
    paramPromise.resolve(null);
  }

  public void g(ReadableMap paramReadableMap, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("IllegalArgument", "properties is null");
      return;
    }
    this.a.a(com.viber.voip.analytics.story.g.a(paramReadableMap.toHashMap(), new Class[] { b.class }));
    paramPromise.resolve(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.a.d
 * JD-Core Version:    0.6.2
 */