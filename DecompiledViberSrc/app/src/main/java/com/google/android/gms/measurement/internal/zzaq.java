package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzaq extends zzcs
{
  private static final AtomicReference<String[]> zzalr = new AtomicReference();
  private static final AtomicReference<String[]> zzals = new AtomicReference();
  private static final AtomicReference<String[]> zzalt = new AtomicReference();

  zzaq(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  private static String zza(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, AtomicReference<String[]> paramAtomicReference)
  {
    int i = 0;
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    Preconditions.checkNotNull(paramAtomicReference);
    if (paramArrayOfString1.length == paramArrayOfString2.length);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      while (i < paramArrayOfString1.length)
      {
        if (zzfx.zzv(paramString, paramArrayOfString1[i]))
          try
          {
            String[] arrayOfString = (String[])paramAtomicReference.get();
            if (arrayOfString == null)
            {
              arrayOfString = new String[paramArrayOfString2.length];
              paramAtomicReference.set(arrayOfString);
            }
            if (arrayOfString[i] == null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramArrayOfString2[i]);
              localStringBuilder.append("(");
              localStringBuilder.append(paramArrayOfString1[i]);
              localStringBuilder.append(")");
              arrayOfString[i] = localStringBuilder.toString();
            }
            String str = arrayOfString[i];
            return str;
          }
          finally
          {
          }
        i++;
      }
      return paramString;
    }
  }

  private final String zzb(zzad paramzzad)
  {
    if (paramzzad == null)
      return null;
    if (!zzjf())
      return paramzzad.toString();
    return zzd(paramzzad.zziy());
  }

  private final boolean zzjf()
  {
    zzgw();
    return (this.zzada.zzkn()) && (this.zzada.zzgt().isLoggable(3));
  }

  protected final String zza(zzab paramzzab)
  {
    if (paramzzab == null)
      return null;
    if (!zzjf())
      return paramzzab.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{appId='");
    localStringBuilder.append(paramzzab.zztt);
    localStringBuilder.append("', name='");
    localStringBuilder.append(zzbt(paramzzab.name));
    localStringBuilder.append("', params=");
    localStringBuilder.append(zzb(paramzzab.zzahu));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  protected final String zzb(zzag paramzzag)
  {
    if (paramzzag == null)
      return null;
    if (!zzjf())
      return paramzzag.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("origin=");
    localStringBuilder.append(paramzzag.origin);
    localStringBuilder.append(",name=");
    localStringBuilder.append(zzbt(paramzzag.name));
    localStringBuilder.append(",params=");
    localStringBuilder.append(zzb(paramzzag.zzahu));
    return localStringBuilder.toString();
  }

  protected final String zzbt(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (!zzjf())
      return paramString;
    return zza(paramString, zzcu.zzaqu, zzcu.zzaqt, zzalr);
  }

  protected final String zzbu(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (!zzjf())
      return paramString;
    return zza(paramString, zzcv.zzaqw, zzcv.zzaqv, zzals);
  }

  protected final String zzbv(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (!zzjf())
      return paramString;
    if (paramString.startsWith("_exp_"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("experiment_id");
      localStringBuilder.append("(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return zza(paramString, zzcw.zzaqy, zzcw.zzaqx, zzalt);
  }

  protected final String zzd(Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    if (!zzjf())
      return paramBundle.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(", ");
      while (true)
      {
        localStringBuilder.append(zzbu(str));
        localStringBuilder.append("=");
        localStringBuilder.append(paramBundle.get(str));
        break;
        localStringBuilder.append("Bundle[{");
      }
    }
    localStringBuilder.append("}]");
    return localStringBuilder.toString();
  }

  protected final boolean zzgy()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaq
 * JD-Core Version:    0.6.2
 */