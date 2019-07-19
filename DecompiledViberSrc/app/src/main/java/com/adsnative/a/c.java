package com.adsnative.a;

import com.adsnative.ads.l;
import java.lang.reflect.Constructor;

public class c
{
  protected static c a = new c();

  public static a a(String paramString)
    throws Exception
  {
    if (paramString != null)
    {
      Class localClass = Class.forName(paramString).asSubclass(a.class);
      return a.a(localClass);
    }
    return new l();
  }

  protected a a(Class<? extends a> paramClass)
    throws Exception
  {
    if (paramClass == null)
      throw new NullPointerException("CustomAdNetwork class is null");
    Constructor localConstructor = paramClass.getDeclaredConstructor((Class[])null);
    localConstructor.setAccessible(true);
    return (a)localConstructor.newInstance(new Object[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.a.c
 * JD-Core Version:    0.6.2
 */