package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzadh
{
  private final Object lock = new Object();

  @VisibleForTesting
  boolean zzcxq = true;
  private final List<zzadf> zzcxr = new LinkedList();
  private final Map<String, String> zzcxs = new LinkedHashMap();
  private zzadh zzcxt;

  public zzadh(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.zzcxs.put("action", paramString1);
    this.zzcxs.put("ad_format", paramString2);
  }

  public final boolean zza(zzadf paramzzadf, long paramLong, String[] paramArrayOfString)
  {
    synchronized (this.lock)
    {
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        zzadf localzzadf = new zzadf(paramLong, paramArrayOfString[j], paramzzadf);
        this.zzcxr.add(localzzadf);
      }
      return true;
    }
  }

  public final void zzc(zzadh paramzzadh)
  {
    synchronized (this.lock)
    {
      this.zzcxt = paramzzadh;
      return;
    }
  }

  public final zzadf zzfa(long paramLong)
  {
    if (!this.zzcxq)
      return null;
    return new zzadf(paramLong, null, null);
  }

  public final void zzh(String paramString1, String paramString2)
  {
    if ((!this.zzcxq) || (TextUtils.isEmpty(paramString2)));
    zzacx localzzacx;
    do
    {
      return;
      localzzacx = zzk.zzlk().zzuw();
    }
    while (localzzacx == null);
    synchronized (this.lock)
    {
      zzadb localzzadb = localzzacx.zzch(paramString1);
      Map localMap = this.zzcxs;
      localMap.put(paramString1, localzzadb.zzg((String)localMap.get(paramString1), paramString2));
      return;
    }
  }

  public final String zzqx()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.lock)
    {
      Iterator localIterator = this.zzcxr.iterator();
      while (localIterator.hasNext())
      {
        zzadf localzzadf1 = (zzadf)localIterator.next();
        long l1 = localzzadf1.getTime();
        String str2 = localzzadf1.zzqu();
        zzadf localzzadf2 = localzzadf1.zzqv();
        if ((localzzadf2 != null) && (l1 > 0L))
        {
          long l2 = l1 - localzzadf2.getTime();
          localStringBuilder.append(str2).append('.').append(l2).append(',');
        }
      }
    }
    this.zzcxr.clear();
    if (!TextUtils.isEmpty(null))
      localStringBuilder.append(null);
    while (true)
    {
      String str1 = localStringBuilder.toString();
      return str1;
      if (localStringBuilder.length() > 0)
        localStringBuilder.setLength(-1 + localStringBuilder.length());
    }
  }

  @VisibleForTesting
  final Map<String, String> zzqy()
  {
    synchronized (this.lock)
    {
      zzacx localzzacx = zzk.zzlk().zzuw();
      if ((localzzacx == null) || (this.zzcxt == null))
      {
        Map localMap1 = this.zzcxs;
        return localMap1;
      }
      Map localMap2 = localzzacx.zza(this.zzcxs, this.zzcxt.zzqy());
      return localMap2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadh
 * JD-Core Version:    0.6.2
 */