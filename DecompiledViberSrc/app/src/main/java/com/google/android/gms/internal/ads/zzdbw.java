package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzdbw
{
  private static final CopyOnWriteArrayList<zzdbv> zzgpi = new CopyOnWriteArrayList();

  public static zzdbv zzgh(String paramString)
    throws GeneralSecurityException
  {
    Iterator localIterator = zzgpi.iterator();
    while (localIterator.hasNext())
    {
      zzdbv localzzdbv = (zzdbv)localIterator.next();
      if (localzzdbv.zzgf(paramString))
        return localzzdbv;
    }
    String str1 = String.valueOf(paramString);
    if (str1.length() != 0);
    for (String str2 = "No KMS client does support: ".concat(str1); ; str2 = new String("No KMS client does support: "))
      throw new GeneralSecurityException(str2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbw
 * JD-Core Version:    0.6.2
 */