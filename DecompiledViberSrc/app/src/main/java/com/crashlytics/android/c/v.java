package com.crashlytics.android.c;

import android.content.Context;
import android.os.Bundle;
import c.a.a.a.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class v
  implements b
{
  private static final List<Class<?>> a = Collections.unmodifiableList(Arrays.asList(new Class[] { String.class, String.class, Bundle.class, Long.class }));
  private final l b;
  private Object c;

  public v(l paraml)
  {
    this.b = paraml;
  }

  private Class<?> a(String paramString)
  {
    try
    {
      Class localClass = this.b.r().getClassLoader().loadClass(paramString);
      return localClass;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static String a(String paramString, Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject2.put(str, paramBundle.get(str));
    }
    localJSONObject1.put("name", paramString);
    localJSONObject1.put("parameters", localJSONObject2);
    return localJSONObject1.toString();
  }

  static boolean a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length != a.size())
      return false;
    Iterator localIterator = a.iterator();
    int i = paramArrayOfObject.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label58;
      if (!paramArrayOfObject[j].getClass().equals(localIterator.next()))
        break;
    }
    label58: return true;
  }

  private Object b(Class<?> paramClass)
  {
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("getInstance", new Class[] { Context.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b.r();
      Object localObject = localMethod.invoke(paramClass, arrayOfObject);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static void b(l paraml, String paramString, Bundle paramBundle)
  {
    try
    {
      paraml.a("$A$:" + a(paramString, paramBundle));
      return;
    }
    catch (JSONException localJSONException)
    {
      c.g().d("CrashlyticsCore", "Unable to serialize Firebase Analytics event; " + paramString);
    }
  }

  Object a(Class paramClass)
  {
    try
    {
      if (this.c == null)
        this.c = Proxy.newProxyInstance(this.b.r().getClassLoader(), new Class[] { paramClass }, new InvocationHandler()
        {
          public boolean a(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            if (paramAnonymousObject1 == paramAnonymousObject2);
            while ((paramAnonymousObject2 != null) && (Proxy.isProxyClass(paramAnonymousObject2.getClass())) && (super.equals(Proxy.getInvocationHandler(paramAnonymousObject2))))
              return true;
            return false;
          }

          public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
          {
            String str1 = paramAnonymousMethod.getName();
            if ((paramAnonymousArrayOfObject.length == 1) && (str1.equals("equals")))
              return Boolean.valueOf(a(paramAnonymousObject, paramAnonymousArrayOfObject[0]));
            if ((paramAnonymousArrayOfObject.length == 0) && (str1.equals("hashCode")))
              return Integer.valueOf(super.hashCode());
            if ((paramAnonymousArrayOfObject.length == 0) && (str1.equals("toString")))
              return super.toString();
            if ((paramAnonymousArrayOfObject.length == 4) && (str1.equals("onEvent")) && (v.a(paramAnonymousArrayOfObject)))
            {
              String str2 = (String)paramAnonymousArrayOfObject[0];
              String str3 = (String)paramAnonymousArrayOfObject[1];
              Bundle localBundle = (Bundle)paramAnonymousArrayOfObject[2];
              if ((str2 != null) && (!str2.equals("crash")))
              {
                v.a(v.a(v.this), str3, localBundle);
                return null;
              }
            }
            StringBuilder localStringBuilder = new StringBuilder("Unexpected method invoked on AppMeasurement.EventListener: " + str1 + "(");
            for (int i = 0; i < paramAnonymousArrayOfObject.length; i++)
            {
              if (i > 0)
                localStringBuilder.append(", ");
              localStringBuilder.append(paramAnonymousArrayOfObject[0].getClass().getName());
            }
            localStringBuilder.append("); returning null");
            c.g().e("CrashlyticsCore", localStringBuilder.toString());
            return null;
          }
        });
      Object localObject2 = this.c;
      return localObject2;
    }
    finally
    {
    }
  }

  public boolean a()
  {
    Class localClass1 = a("com.google.android.gms.measurement.AppMeasurement");
    if (localClass1 == null)
    {
      c.g().a("CrashlyticsCore", "Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
      return false;
    }
    Object localObject = b(localClass1);
    if (localObject == null)
    {
      c.g().d("CrashlyticsCore", "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Could not create an instance of Firebase Analytics.");
      return false;
    }
    Class localClass2 = a("com.google.android.gms.measurement.AppMeasurement$OnEventListener");
    if (localClass2 == null)
    {
      c.g().d("CrashlyticsCore", "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Could not get class com.google.android.gms.measurement.AppMeasurement$OnEventListener");
      return false;
    }
    try
    {
      Method localMethod = localClass1.getDeclaredMethod("registerOnMeasurementEventListener", new Class[] { localClass2 });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a(localClass2);
      localMethod.invoke(localObject, arrayOfObject);
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      c.g().d("CrashlyticsCore", "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Method registerOnMeasurementEventListener not found.", localNoSuchMethodException);
      return false;
    }
    catch (Exception localException)
    {
      while (true)
        c.g().d("CrashlyticsCore", "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: " + localException.getMessage(), localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.v
 * JD-Core Version:    0.6.2
 */