package com.yandex.metrica.impl.ob;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class lh
  implements InvocationHandler
{
  private Object a;
  private final lk b;

  lh(Object paramObject, lk paramlk)
  {
    this.a = paramObject;
    this.b = paramlk;
  }

  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    if ("onInstallReferrerSetupFinished".equals(paramMethod.getName()))
      if (paramArrayOfObject.length == 1)
        if (!paramArrayOfObject[0].equals(Integer.valueOf(0)));
    while (true)
    {
      try
      {
        Object localObject = this.a.getClass().getMethod("getInstallReferrer", new Class[0]).invoke(this.a, new Object[0]);
        this.b.a(new lj((String)localObject.getClass().getMethod("getInstallReferrer", new Class[0]).invoke(localObject, new Object[0]), ((Long)localObject.getClass().getMethod("getReferrerClickTimestampSeconds", new Class[0]).invoke(localObject, new Object[0])).longValue(), ((Long)localObject.getClass().getMethod("getInstallBeginTimestampSeconds", new Class[0]).invoke(localObject, new Object[0])).longValue()));
        return null;
      }
      catch (Exception localException)
      {
        this.b.a(localException);
        continue;
      }
      this.b.a(new IllegalStateException("Referrer check failed with error " + paramArrayOfObject[0]));
      continue;
      this.b.a(new IllegalArgumentException("Args size is not equal to one."));
      continue;
      this.b.a(new IllegalArgumentException("Unexpected method called " + paramMethod.getName()));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lh
 * JD-Core Version:    0.6.2
 */