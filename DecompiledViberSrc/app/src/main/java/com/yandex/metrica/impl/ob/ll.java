package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ll
{
  private final Context a;

  public ll(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }

  @SuppressLint({"PrivateApi"})
  public void a(final lk paramlk)
  {
    try
    {
      Class localClass1 = Class.forName("com.android.installreferrer.api.InstallReferrerClient");
      Method localMethod = localClass1.getDeclaredMethod("newBuilder", new Class[] { Context.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.a;
      Object localObject1 = localMethod.invoke(localClass1, arrayOfObject);
      Class localClass2 = Class.forName("com.android.installreferrer.api.InstallReferrerStateListener");
      final Object localObject2 = localObject1.getClass().getDeclaredMethod("build", new Class[0]).invoke(localObject1, new Object[0]);
      Object localObject3 = Proxy.newProxyInstance(localClass2.getClassLoader(), new Class[] { localClass2 }, new lh(localObject2, new lk()
      {
        public void a()
        {
          if (localObject2 != null);
          try
          {
            localObject2.getClass().getDeclaredMethod("endConnection", new Class[0]).invoke(localObject2, new Object[0]);
            return;
          }
          catch (Exception localException)
          {
          }
        }

        public void a(lj paramAnonymouslj)
        {
          paramlk.a(paramAnonymouslj);
          a();
        }

        public void a(Throwable paramAnonymousThrowable)
        {
          paramlk.a(paramAnonymousThrowable);
          a();
        }
      }));
      localObject2.getClass().getDeclaredMethod("startConnection", new Class[] { localClass2 }).invoke(localObject2, new Object[] { localObject3 });
      return;
    }
    catch (Exception localException)
    {
      paramlk.a(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ll
 * JD-Core Version:    0.6.2
 */