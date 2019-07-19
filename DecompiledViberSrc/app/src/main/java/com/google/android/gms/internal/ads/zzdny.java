package com.google.android.gms.internal.ads;

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

abstract class zzdny<T extends zzdnn>
{
  private static final Logger logger = Logger.getLogger(zzdnh.class.getName());
  private static String zzhhb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

  static <T extends zzdnn> T zzb(Class<T> paramClass)
  {
    ClassLoader localClassLoader = zzdny.class.getClassLoader();
    String str1;
    if (paramClass.equals(zzdnn.class))
      str1 = zzhhb;
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
          zzdny localzzdny = (zzdny)localClass.getConstructor(new Class[0]).newInstance(new Object[0]);
          zzdnn localzzdnn2 = (zzdnn)paramClass.cast(localzzdny.zzaxp());
          return localzzdnn2;
          if (!paramClass.getPackage().equals(zzdny.class.getPackage()))
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
          Iterator localIterator = ServiceLoader.load(zzdny.class, localClassLoader).iterator();
          localArrayList = new ArrayList();
          if (!localIterator.hasNext())
            break;
          Logger localLogger;
          Level localLevel;
          String str2;
          try
          {
            localArrayList.add((zzdnn)paramClass.cast(((zzdny)localIterator.next()).zzaxp()));
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
        return (zzdnn)localArrayList.get(0);
      if (localArrayList.size() == 0)
        return null;
      try
      {
        zzdnn localzzdnn1 = (zzdnn)paramClass.getMethod("combine", new Class[] { Collection.class }).invoke(null, new Object[] { localArrayList });
        return localzzdnn1;
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

  protected abstract T zzaxp();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdny
 * JD-Core Version:    0.6.2
 */