package com.adsnative.a;

import com.adsnative.ads.b;
import java.lang.reflect.Constructor;

public class e
{
  protected static e a = new e();

  public static d a(String paramString)
    throws Exception
  {
    if (paramString != null)
    {
      Class localClass = Class.forName(paramString).asSubclass(d.class);
      return a.a(localClass);
    }
    return new b();
  }

  protected d a(Class<? extends d> paramClass)
    throws Exception
  {
    if (paramClass == null)
      throw new NullPointerException("CustomAdNetwork class is null");
    Constructor localConstructor = paramClass.getDeclaredConstructor((Class[])null);
    localConstructor.setAccessible(true);
    return (d)localConstructor.newInstance(new Object[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.a.e
 * JD-Core Version:    0.6.2
 */