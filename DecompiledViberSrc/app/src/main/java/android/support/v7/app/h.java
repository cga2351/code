package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class h
{
  private static Field a;
  private static boolean b;
  private static Class c;
  private static boolean d;
  private static Field e;
  private static boolean f;
  private static Field g;
  private static boolean h;

  static void a(Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 28);
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 24)
      {
        d(paramResources);
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        c(paramResources);
        return;
      }
    }
    while (Build.VERSION.SDK_INT < 21);
    b(paramResources);
  }

  private static void a(Object paramObject)
  {
    if (!d);
    while (true)
    {
      try
      {
        c = Class.forName("android.content.res.ThemedResourceCache");
        d = true;
        if (c == null)
          return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
        continue;
      }
      if (!f);
      try
      {
        e = c.getDeclaredField("mUnthemedEntries");
        e.setAccessible(true);
        f = true;
        if (e == null)
          continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        try
        {
          localLongSparseArray = (LongSparseArray)e.get(paramObject);
          if (localLongSparseArray == null)
            continue;
          localLongSparseArray.clear();
          return;
          localNoSuchFieldException = localNoSuchFieldException;
          Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          while (true)
          {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", localIllegalAccessException);
            LongSparseArray localLongSparseArray = null;
          }
        }
      }
    }
  }

  private static void b(Resources paramResources)
  {
    if (!b);
    try
    {
      a = Resources.class.getDeclaredField("mDrawableCache");
      a.setAccessible(true);
      b = true;
      if (a == null);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        localMap = (Map)a.get(paramResources);
        if (localMap != null)
          localMap.clear();
        return;
        localNoSuchFieldException = localNoSuchFieldException;
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        while (true)
        {
          Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", localIllegalAccessException);
          Map localMap = null;
        }
      }
    }
  }

  private static void c(Resources paramResources)
  {
    if (!b);
    try
    {
      a = Resources.class.getDeclaredField("mDrawableCache");
      a.setAccessible(true);
      b = true;
      if (a == null);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject1;
      while (true)
      {
        try
        {
          Object localObject2 = a.get(paramResources);
          localObject1 = localObject2;
          if (localObject1 != null)
            break;
          return;
          localNoSuchFieldException = localNoSuchFieldException;
          Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", localIllegalAccessException);
        }
        localObject1 = null;
      }
      a(localObject1);
    }
  }

  private static void d(Resources paramResources)
  {
    if (!h);
    while (true)
    {
      try
      {
        g = Resources.class.getDeclaredField("mResourcesImpl");
        g.setAccessible(true);
        h = true;
        if (g == null)
          return;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException2);
        continue;
      }
      try
      {
        Object localObject4 = g.get(paramResources);
        localObject1 = localObject4;
        if (localObject1 == null)
          continue;
        if (b);
      }
      catch (IllegalAccessException localNoSuchFieldException1)
      {
        try
        {
          a = localObject1.getClass().getDeclaredField("mDrawableCache");
          a.setAccessible(true);
          b = true;
          if (a == null);
        }
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          while (true)
          {
            try
            {
              Object localObject3 = a.get(localObject1);
              localObject2 = localObject3;
              if (localObject2 == null)
                break;
              a(localObject2);
              return;
              localIllegalAccessException1 = localIllegalAccessException1;
              Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", localIllegalAccessException1);
              Object localObject1 = null;
              continue;
              localNoSuchFieldException1 = localNoSuchFieldException1;
              Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException1);
            }
            catch (IllegalAccessException localIllegalAccessException2)
            {
              Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", localIllegalAccessException2);
            }
            Object localObject2 = null;
          }
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.h
 * JD-Core Version:    0.6.2
 */