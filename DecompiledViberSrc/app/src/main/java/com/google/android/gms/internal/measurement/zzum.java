package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzum<T extends zzub>
{
  private static final Logger logger = Logger.getLogger(zztv.class.getName());
  private static String zzbyd = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

  static <T extends zzub> T zzd(Class<T> paramClass)
  {
    ClassLoader localClassLoader = zzum.class.getClassLoader();
    String str1;
    if (paramClass.equals(zzub.class))
      str1 = zzbyd;
    try
    {
      localClass = Class.forName(str1, true, localClassLoader);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ArrayList localArrayList;
      while (true)
      {
        try
        {
          Class localClass;
          zzum localzzum = (zzum)localClass.getConstructor(new Class[0]).newInstance(new Object[0]);
          zzub localzzub2 = (zzub)paramClass.cast(localzzum.zzwd());
          return localzzub2;
          if (!paramClass.getPackage().equals(zzum.class.getPackage()))
            throw new IllegalArgumentException(paramClass.getName());
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramClass.getPackage().getName();
          arrayOfObject[1] = paramClass.getSimpleName();
          str1 = String.format("%s.BlazeGenerated%sLoader", arrayOfObject);
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          throw new IllegalStateException(localNoSuchMethodException2);
          localClassNotFoundException = localClassNotFoundException;
          Iterator localIterator = ServiceLoader.load(zzum.class, localClassLoader).iterator();
          localArrayList = new ArrayList();
          if (!localIterator.hasNext())
            break;
          Logger localLogger;
          Level localLevel;
          String str2;
          try
          {
            localArrayList.add((zzub)paramClass.cast(((zzum)localIterator.next()).zzwd()));
          }
          catch (ServiceConfigurationError localServiceConfigurationError)
          {
            localLogger = logger;
            localLevel = Level.SEVERE;
            str2 = String.valueOf(paramClass.getSimpleName());
            if (str2.length() == 0)
              break label289;
          }
          str3 = "Unable to load ".concat(str2);
          localLogger.logp(localLevel, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", str3, localServiceConfigurationError);
          continue;
        }
        catch (InstantiationException localInstantiationException)
        {
          throw new IllegalStateException(localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          throw new IllegalStateException(localIllegalAccessException2);
        }
        catch (InvocationTargetException localInvocationTargetException2)
        {
          throw new IllegalStateException(localInvocationTargetException2);
        }
        label289: String str3 = new String("Unable to load ");
      }
      if (localArrayList.size() == 1)
        return (zzub)localArrayList.get(0);
      if (localArrayList.size() == 0)
        return null;
      try
      {
        zzub localzzub1 = (zzub)paramClass.getMethod("combine", new Class[] { Collection.class }).invoke(null, new Object[] { localArrayList });
        return localzzub1;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        throw new IllegalStateException(localNoSuchMethodException1);
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        throw new IllegalStateException(localIllegalAccessException1);
      }
      catch (InvocationTargetException localInvocationTargetException1)
      {
        throw new IllegalStateException(localInvocationTargetException1);
      }
    }
  }

  protected abstract T zzwd();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzum
 * JD-Core Version:    0.6.2
 */