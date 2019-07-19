package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class f<T>
{
  private final T a;
  private final b<T> b;

  f(T paramT, b<T> paramb)
  {
    this.a = paramT;
    this.b = paramb;
  }

  public static f<Context> a(Context paramContext)
  {
    return new f(paramContext, new a(null));
  }

  private static List<h> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localClass = Class.forName(str);
        if (!h.class.isAssignableFrom(localClass))
          Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[] { str, "com.google.firebase.components.ComponentRegistrar" }));
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Class localClass;
        Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[] { str }), localClassNotFoundException);
        continue;
        localArrayList.add((h)localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[] { str }), localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[] { str }), localInstantiationException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[] { str }), localNoSuchMethodException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[] { str }), localInvocationTargetException);
      }
    }
    return localArrayList;
  }

  public List<h> a()
  {
    return a(this.b.a(this.a));
  }

  private static class a
    implements f.b<Context>
  {
    private static Bundle b(Context paramContext)
    {
      ServiceInfo localServiceInfo;
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
        {
          Log.w("ComponentDiscovery", "Context has no PackageManager.");
          return null;
        }
        localServiceInfo = localPackageManager.getServiceInfo(new ComponentName(paramContext, ComponentDiscoveryService.class), 128);
        if (localServiceInfo == null)
        {
          Log.w("ComponentDiscovery", "ComponentDiscoveryService has no service info.");
          return null;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.w("ComponentDiscovery", "Application info not found.");
        return null;
      }
      Bundle localBundle = localServiceInfo.metaData;
      return localBundle;
    }

    public List<String> a(Context paramContext)
    {
      Bundle localBundle = b(paramContext);
      if (localBundle == null)
      {
        Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
        return Collections.emptyList();
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (("com.google.firebase.components.ComponentRegistrar".equals(localBundle.get(str))) && (str.startsWith("com.google.firebase.components:")))
          localArrayList.add(str.substring("com.google.firebase.components:".length()));
      }
      return localArrayList;
    }
  }

  static abstract interface b<T>
  {
    public abstract List<String> a(T paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.f
 * JD-Core Version:    0.6.2
 */