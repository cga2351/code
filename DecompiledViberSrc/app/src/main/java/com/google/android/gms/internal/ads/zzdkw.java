package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class zzdkw<T_WRAPPER extends zzdkx<T_ENGINE>, T_ENGINE>
{
  private static final Logger logger = Logger.getLogger(zzdkw.class.getName());
  private static final List<Provider> zzhao;
  public static final zzdkw<zzdky, Cipher> zzhap;
  public static final zzdkw<zzdlc, Mac> zzhaq;
  public static final zzdkw<zzdle, Signature> zzhar;
  public static final zzdkw<zzdld, MessageDigest> zzhas;
  public static final zzdkw<zzdkz, KeyAgreement> zzhat;
  public static final zzdkw<zzdlb, KeyPairGenerator> zzhau;
  public static final zzdkw<zzdla, KeyFactory> zzhav;
  private T_WRAPPER zzhaw;
  private List<Provider> zzhax;
  private boolean zzhay;

  static
  {
    ArrayList localArrayList;
    if (zzdlu.zzavd())
    {
      String[] arrayOfString = { "GmsCore_OpenSSL", "AndroidOpenSSL" };
      localArrayList = new ArrayList();
      int i = 0;
      if (i < 2)
      {
        String str = arrayOfString[i];
        Provider localProvider = Security.getProvider(str);
        if (localProvider != null)
          localArrayList.add(localProvider);
        while (true)
        {
          i++;
          break;
          logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[] { str }));
        }
      }
    }
    for (zzhao = localArrayList; ; zzhao = new ArrayList())
    {
      zzhap = new zzdkw(new zzdky());
      zzhaq = new zzdkw(new zzdlc());
      zzhar = new zzdkw(new zzdle());
      zzhas = new zzdkw(new zzdld());
      zzhat = new zzdkw(new zzdkz());
      zzhau = new zzdkw(new zzdlb());
      zzhav = new zzdkw(new zzdla());
      return;
    }
  }

  private zzdkw(T_WRAPPER paramT_WRAPPER)
  {
    this.zzhaw = paramT_WRAPPER;
    this.zzhax = zzhao;
    this.zzhay = true;
  }

  private final boolean zza(String paramString, Provider paramProvider)
  {
    try
    {
      this.zzhaw.zzb(paramString, paramProvider);
      return true;
    }
    catch (Exception localException)
    {
      zzdma.zzg(localException);
    }
    return false;
  }

  public final T_ENGINE zzgt(String paramString)
    throws GeneralSecurityException
  {
    Iterator localIterator = this.zzhax.iterator();
    while (localIterator.hasNext())
    {
      Provider localProvider = (Provider)localIterator.next();
      if (zza(paramString, localProvider))
        return this.zzhaw.zzb(paramString, localProvider);
    }
    if (this.zzhay)
      return this.zzhaw.zzb(paramString, null);
    throw new GeneralSecurityException("No good Provider found.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdkw
 * JD-Core Version:    0.6.2
 */