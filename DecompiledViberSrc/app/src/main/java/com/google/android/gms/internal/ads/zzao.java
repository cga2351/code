package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class zzao
{
  final String zza;
  final long zzb;
  final long zzc;
  long zzcb;
  final String zzcc;
  final long zzd;
  final long zze;
  final List<zzl> zzg;

  zzao(String paramString, zzc paramzzc)
  {
  }

  private zzao(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<zzl> paramList)
  {
    this.zzcc = paramString1;
    if ("".equals(paramString2))
      paramString2 = null;
    this.zza = paramString2;
    this.zzb = paramLong1;
    this.zzc = paramLong2;
    this.zzd = paramLong3;
    this.zze = paramLong4;
    this.zzg = paramList;
  }

  static zzao zzc(zzap paramzzap)
    throws IOException
  {
    if (zzan.zzb(paramzzap) != 538247942)
      throw new IOException();
    return new zzao(zzan.zza(paramzzap), zzan.zza(paramzzap), zzan.zzc(paramzzap), zzan.zzc(paramzzap), zzan.zzc(paramzzap), zzan.zzc(paramzzap), zzan.zzb(paramzzap));
  }

  final boolean zza(OutputStream paramOutputStream)
  {
    while (true)
    {
      try
      {
        zzan.zza(paramOutputStream, 538247942);
        zzan.zza(paramOutputStream, this.zzcc);
        if (this.zza == null)
        {
          str = "";
          zzan.zza(paramOutputStream, str);
          zzan.zza(paramOutputStream, this.zzb);
          zzan.zza(paramOutputStream, this.zzc);
          zzan.zza(paramOutputStream, this.zzd);
          zzan.zza(paramOutputStream, this.zze);
          List localList = this.zzg;
          if (localList == null)
            break;
          zzan.zza(paramOutputStream, localList.size());
          Iterator localIterator = localList.iterator();
          if (!localIterator.hasNext())
            break label172;
          zzl localzzl = (zzl)localIterator.next();
          zzan.zza(paramOutputStream, localzzl.getName());
          zzan.zza(paramOutputStream, localzzl.getValue());
          continue;
        }
      }
      catch (IOException localIOException)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localIOException.toString();
        zzag.d("%s", arrayOfObject);
        return false;
      }
      String str = this.zza;
    }
    zzan.zza(paramOutputStream, 0);
    label172: paramOutputStream.flush();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzao
 * JD-Core Version:    0.6.2
 */