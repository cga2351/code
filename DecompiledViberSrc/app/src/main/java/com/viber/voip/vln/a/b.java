package com.viber.voip.vln.a;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.viber.voip.analytics.story.j;
import com.viber.voip.util.da;

public class b
  implements a
{
  private final com.viber.voip.analytics.g a;

  public b(com.viber.voip.analytics.g paramg)
  {
    this.a = paramg;
  }

  public void a(String paramString, ReadableArray paramReadableArray, Promise paramPromise)
  {
    if (da.a(paramString))
    {
      paramPromise.reject("IllegalArgument", "attribute name is empty");
      return;
    }
    if (paramReadableArray == null)
    {
      paramPromise.reject("IllegalArgument", "array attribute value is null");
      return;
    }
    String[] arrayOfString = new String[paramReadableArray.size()];
    int i = 0;
    try
    {
      int j = paramReadableArray.size();
      while (i < j)
      {
        arrayOfString[i] = paramReadableArray.getString(i);
        i++;
      }
    }
    catch (Exception localException)
    {
      paramPromise.reject("IllegalArgument", "array items must be String");
      return;
    }
    this.a.a(com.viber.voip.analytics.story.g.a(paramString, arrayOfString, com.viber.voip.analytics.b.a.class));
    paramPromise.resolve(null);
  }

  public void a(String paramString, ReadableMap paramReadableMap1, ReadableMap paramReadableMap2, Promise paramPromise)
  {
    if (da.a(paramString))
    {
      paramPromise.reject("IllegalArgument", "event name is empty");
      return;
    }
    this.a.a(e.a(paramString, paramReadableMap1, paramReadableMap2, com.viber.voip.analytics.b.a.class));
    paramPromise.resolve(null);
  }

  public void a(String paramString, Boolean paramBoolean, Promise paramPromise)
  {
    if (da.a(paramString))
    {
      paramPromise.reject("IllegalArgument", "attribute name is empty");
      return;
    }
    if (paramBoolean == null)
    {
      paramPromise.reject("IllegalArgument", "boolean attribute value is null");
      return;
    }
    this.a.a(com.viber.voip.analytics.story.g.a(paramString, paramBoolean, com.viber.voip.analytics.b.a.class));
    paramPromise.resolve(null);
  }

  public void a(String paramString, Double paramDouble, Promise paramPromise)
  {
    if (da.a(paramString))
    {
      paramPromise.reject("IllegalArgument", "attribute name is empty");
      return;
    }
    if (paramDouble == null)
    {
      paramPromise.reject("IllegalArgument", "double attribute value is null");
      return;
    }
    this.a.a(com.viber.voip.analytics.story.g.a(paramString, paramDouble, com.viber.voip.analytics.b.a.class));
    paramPromise.resolve(null);
  }

  public void a(String paramString, Integer paramInteger, Promise paramPromise)
  {
    if (da.a(paramString))
    {
      paramPromise.reject("IllegalArgument", "attribute name is empty");
      return;
    }
    if (paramInteger == null)
    {
      paramPromise.reject("IllegalArgument", "integer attribute value is null");
      return;
    }
    this.a.a(com.viber.voip.analytics.story.g.a(paramString, paramInteger, com.viber.voip.analytics.b.a.class));
    paramPromise.resolve(null);
  }

  public void a(String paramString1, String paramString2, Promise paramPromise)
  {
    if (da.a(paramString1))
    {
      paramPromise.reject("IllegalArgument", "attribute name is empty");
      return;
    }
    if (paramString2 == null)
    {
      paramPromise.reject("IllegalArgument", "string attribute value is null");
      return;
    }
    this.a.a(com.viber.voip.analytics.story.g.a(paramString1, paramString2, com.viber.voip.analytics.b.a.class));
    paramPromise.resolve(null);
  }

  public void b(String paramString1, String paramString2, Promise paramPromise)
  {
    if (da.a(paramString1))
    {
      paramPromise.reject("IllegalArgument", "attribute name is empty");
      return;
    }
    if (paramString2 == null)
    {
      paramPromise.reject("IllegalArgument", "string attribute value is null");
      return;
    }
    j localj = e.a(paramString1, paramString2);
    if (localj != null)
      this.a.a(localj);
    paramPromise.resolve(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.a.b
 * JD-Core Version:    0.6.2
 */