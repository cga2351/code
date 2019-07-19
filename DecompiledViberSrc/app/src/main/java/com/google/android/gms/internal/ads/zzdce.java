package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzdce
{
  private static final Logger logger = Logger.getLogger(zzdce.class.getName());
  private static final ConcurrentMap<String, zzdbr> zzgpp = new ConcurrentHashMap();
  private static final ConcurrentMap<String, Boolean> zzgpq = new ConcurrentHashMap();
  private static final ConcurrentMap<String, zzdbj> zzgpr = new ConcurrentHashMap();
  private static final ConcurrentMap<Class<?>, zzdcb<?>> zzgps = new ConcurrentHashMap();

  private static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }

  private static <P> zzdbr<P> zza(String paramString, Class<P> paramClass)
    throws GeneralSecurityException
  {
    zzdbr localzzdbr = (zzdbr)zzgpp.get(paramString);
    if (localzzdbr == null)
      throw new GeneralSecurityException(78 + String.valueOf(paramString).length() + "No key manager found for key type: " + paramString + ".  Check the configuration of the registry.");
    if ((paramClass != null) && (!localzzdbr.zzanr().equals(paramClass)))
    {
      String str1 = localzzdbr.zzanr().getName();
      String str2 = paramClass.getName();
      throw new GeneralSecurityException(80 + String.valueOf(str1).length() + String.valueOf(paramString).length() + String.valueOf(str2).length() + "Primitive type " + str1 + " of keymanager for type " + paramString + " does not match requested primitive type " + str2);
    }
    return localzzdbr;
  }

  public static <P> zzdbz<P> zza(zzdbt paramzzdbt, zzdbr<P> paramzzdbr, Class<P> paramClass)
    throws GeneralSecurityException
  {
    Class localClass = (Class)checkNotNull(paramClass);
    zzdcg.zzd(paramzzdbt.zzant());
    zzdbz localzzdbz = zzdbz.zza(localClass);
    Iterator localIterator = paramzzdbt.zzant().zzasi().iterator();
    while (localIterator.hasNext())
    {
      zzdgz.zzb localzzb = (zzdgz.zzb)localIterator.next();
      if (localzzb.zzaso() == zzdgt.zzgul)
      {
        zzdca localzzdca = localzzdbz.zza(zza(localzzb.zzasn().zzart(), localzzb.zzasn().zzaru(), localClass), localzzb);
        if (localzzb.zzasp() == paramzzdbt.zzant().zzash())
          localzzdbz.zza(localzzdca);
      }
    }
    return localzzdbz;
  }

  public static zzdgq zza(zzdgv paramzzdgv)
    throws GeneralSecurityException
  {
    while (true)
    {
      try
      {
        zzdbr localzzdbr = zza(paramzzdgv.zzart(), null);
        if (((Boolean)zzgpq.get(paramzzdgv.zzart())).booleanValue())
        {
          zzdgq localzzdgq = localzzdbr.zzr(paramzzdgv.zzaru());
          return localzzdgq;
        }
        String str1 = String.valueOf(paramzzdgv.zzart());
        if (str1.length() != 0)
        {
          str2 = "newKey-operation not permitted for key type ".concat(str1);
          throw new GeneralSecurityException(str2);
        }
      }
      finally
      {
      }
      String str2 = new String("newKey-operation not permitted for key type ");
    }
  }

  public static zzdpj zza(String paramString, zzdpj paramzzdpj)
    throws GeneralSecurityException
  {
    while (true)
    {
      try
      {
        zzdbr localzzdbr = zza(paramString, null);
        if (((Boolean)zzgpq.get(paramString)).booleanValue())
        {
          zzdpj localzzdpj = localzzdbr.zzb(paramzzdpj);
          return localzzdpj;
        }
        String str1 = String.valueOf(paramString);
        if (str1.length() != 0)
        {
          str2 = "newKey-operation not permitted for key type ".concat(str1);
          throw new GeneralSecurityException(str2);
        }
      }
      finally
      {
      }
      String str2 = new String("newKey-operation not permitted for key type ");
    }
  }

  public static <P> P zza(zzdbz<P> paramzzdbz)
    throws GeneralSecurityException
  {
    zzdcb localzzdcb = (zzdcb)zzgps.get(paramzzdbz.zzanr());
    if (localzzdcb == null)
    {
      String str1 = String.valueOf(paramzzdbz.zzanr().getName());
      if (str1.length() != 0);
      for (String str2 = "No wrapper found for ".concat(str1); ; str2 = new String("No wrapper found for "))
        throw new GeneralSecurityException(str2);
    }
    return localzzdcb.zza(paramzzdbz);
  }

  private static <P> P zza(String paramString, zzdmq paramzzdmq, Class<P> paramClass)
    throws GeneralSecurityException
  {
    return zza(paramString, paramClass).zzp(paramzzdmq);
  }

  public static <P> P zza(String paramString, zzdpj paramzzdpj, Class<P> paramClass)
    throws GeneralSecurityException
  {
    return zza(paramString, (Class)checkNotNull(paramClass)).zza(paramzzdpj);
  }

  public static <P> P zza(String paramString, byte[] paramArrayOfByte, Class<P> paramClass)
    throws GeneralSecurityException
  {
    return zza(paramString, zzdmq.zzz(paramArrayOfByte), (Class)checkNotNull(paramClass));
  }

  public static <P> void zza(zzdbr<P> paramzzdbr)
    throws GeneralSecurityException
  {
    try
    {
      zza(paramzzdbr, true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static <P> void zza(zzdbr<P> paramzzdbr, boolean paramBoolean)
    throws GeneralSecurityException
  {
    if (paramzzdbr == null)
      try
      {
        throw new IllegalArgumentException("key manager must be non-null.");
      }
      finally
      {
      }
    String str1 = paramzzdbr.getKeyType();
    if (zzgpp.containsKey(str1))
    {
      zzdbr localzzdbr = zza(str1, null);
      boolean bool = ((Boolean)zzgpq.get(str1)).booleanValue();
      if ((!paramzzdbr.getClass().equals(localzzdbr.getClass())) || ((!bool) && (paramBoolean)))
      {
        Logger localLogger = logger;
        Level localLevel = Level.WARNING;
        String str2 = String.valueOf(str1);
        if (str2.length() != 0);
        for (String str3 = "Attempted overwrite of a registered key manager for key type ".concat(str2); ; str3 = new String("Attempted overwrite of a registered key manager for key type "))
        {
          localLogger.logp(localLevel, "com.google.crypto.tink.Registry", "registerKeyManager", str3);
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = str1;
          arrayOfObject[1] = localzzdbr.getClass().getName();
          arrayOfObject[2] = paramzzdbr.getClass().getName();
          throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", arrayOfObject));
        }
      }
    }
    zzgpp.put(str1, paramzzdbr);
    zzgpq.put(str1, Boolean.valueOf(paramBoolean));
  }

  public static <P> void zza(zzdcb<P> paramzzdcb)
    throws GeneralSecurityException
  {
    if (paramzzdcb == null)
      try
      {
        throw new IllegalArgumentException("wrapper must be non-null");
      }
      finally
      {
      }
    Class localClass = paramzzdcb.zzanr();
    if (zzgps.containsKey(localClass))
    {
      zzdcb localzzdcb = (zzdcb)zzgps.get(localClass);
      if (!paramzzdcb.getClass().equals(localzzdcb.getClass()))
      {
        Logger localLogger = logger;
        Level localLevel = Level.WARNING;
        String str1 = String.valueOf(localClass.toString());
        if (str1.length() != 0);
        for (String str2 = "Attempted overwrite of a registered SetWrapper for type ".concat(str1); ; str2 = new String("Attempted overwrite of a registered SetWrapper for type "))
        {
          localLogger.logp(localLevel, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", str2);
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = localClass.getName();
          arrayOfObject[1] = localzzdcb.getClass().getName();
          arrayOfObject[2] = paramzzdcb.getClass().getName();
          throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", arrayOfObject));
        }
      }
    }
    zzgps.put(localClass, paramzzdcb);
  }

  public static void zza(String paramString, zzdbj<?> paramzzdbj)
    throws GeneralSecurityException
  {
    while (true)
    {
      try
      {
        if (!zzgpr.containsKey(paramString.toLowerCase()))
          break;
        zzdbj localzzdbj = (zzdbj)zzgpr.get(paramString.toLowerCase());
        if (paramzzdbj.getClass().equals(localzzdbj.getClass()))
          break;
        Logger localLogger = logger;
        Level localLevel = Level.WARNING;
        String str1 = String.valueOf(paramString);
        if (str1.length() != 0)
        {
          str2 = "Attempted overwrite of a catalogueName catalogue for name ".concat(str1);
          localLogger.logp(localLevel, "com.google.crypto.tink.Registry", "addCatalogue", str2);
          throw new GeneralSecurityException(47 + String.valueOf(paramString).length() + "catalogue for name " + paramString + " has been already registered");
        }
      }
      finally
      {
      }
      String str2 = new String("Attempted overwrite of a catalogueName catalogue for name ");
    }
    zzgpr.put(paramString.toLowerCase(), paramzzdbj);
  }

  public static zzdpj zzb(zzdgv paramzzdgv)
    throws GeneralSecurityException
  {
    while (true)
    {
      try
      {
        zzdbr localzzdbr = zza(paramzzdgv.zzart(), null);
        if (((Boolean)zzgpq.get(paramzzdgv.zzart())).booleanValue())
        {
          zzdpj localzzdpj = localzzdbr.zzq(paramzzdgv.zzaru());
          return localzzdpj;
        }
        String str1 = String.valueOf(paramzzdgv.zzart());
        if (str1.length() != 0)
        {
          str2 = "newKey-operation not permitted for key type ".concat(str1);
          throw new GeneralSecurityException(str2);
        }
      }
      finally
      {
      }
      String str2 = new String("newKey-operation not permitted for key type ");
    }
  }

  public static zzdbj<?> zzgi(String paramString)
    throws GeneralSecurityException
  {
    if (paramString == null)
      throw new IllegalArgumentException("catalogueName must be non-null.");
    zzdbj localzzdbj = (zzdbj)zzgpr.get(paramString.toLowerCase());
    if (localzzdbj == null)
    {
      String str = String.format("no catalogue found for %s. ", new Object[] { paramString });
      if (paramString.toLowerCase().startsWith("tinkaead"))
        str = String.valueOf(str).concat("Maybe call AeadConfig.register().");
      if (paramString.toLowerCase().startsWith("tinkdeterministicaead"))
        str = String.valueOf(str).concat("Maybe call DeterministicAeadConfig.register().");
      while (true)
      {
        throw new GeneralSecurityException(str);
        if (paramString.toLowerCase().startsWith("tinkstreamingaead"))
          str = String.valueOf(str).concat("Maybe call StreamingAeadConfig.register().");
        else if ((paramString.toLowerCase().startsWith("tinkhybriddecrypt")) || (paramString.toLowerCase().startsWith("tinkhybridencrypt")))
          str = String.valueOf(str).concat("Maybe call HybridConfig.register().");
        else if (paramString.toLowerCase().startsWith("tinkmac"))
          str = String.valueOf(str).concat("Maybe call MacConfig.register().");
        else if ((paramString.toLowerCase().startsWith("tinkpublickeysign")) || (paramString.toLowerCase().startsWith("tinkpublickeyverify")))
          str = String.valueOf(str).concat("Maybe call SignatureConfig.register().");
        else if (paramString.toLowerCase().startsWith("tink"))
          str = String.valueOf(str).concat("Maybe call TinkConfig.register().");
      }
    }
    return localzzdbj;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdce
 * JD-Core Version:    0.6.2
 */