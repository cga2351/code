package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

public final class zzab
{
  final String name;
  private final String origin;
  final long timestamp;
  final long zzaht;
  final zzad zzahu;
  final String zztt;

  zzab(zzbw paramzzbw, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    this.zztt = paramString2;
    this.name = paramString3;
    if (TextUtils.isEmpty(paramString1))
      paramString1 = null;
    this.origin = paramString1;
    this.timestamp = paramLong1;
    this.zzaht = paramLong2;
    if ((this.zzaht != 0L) && (this.zzaht > this.timestamp))
      paramzzbw.zzgt().zzjj().zzg("Event created with reverse previous/current timestamps. appId", zzas.zzbw(paramString2));
    Bundle localBundle;
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      localBundle = new Bundle(paramBundle);
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str == null)
        {
          paramzzbw.zzgt().zzjg().zzby("Param name can't be null");
          localIterator.remove();
        }
        else
        {
          Object localObject = paramzzbw.zzgr().zzh(str, localBundle.get(str));
          if (localObject == null)
          {
            paramzzbw.zzgt().zzjj().zzg("Param value can't be null", paramzzbw.zzgq().zzbu(str));
            localIterator.remove();
          }
          else
          {
            paramzzbw.zzgr().zza(localBundle, str, localObject);
          }
        }
      }
    }
    for (zzad localzzad = new zzad(localBundle); ; localzzad = new zzad(new Bundle()))
    {
      this.zzahu = localzzad;
      return;
    }
  }

  private zzab(zzbw paramzzbw, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, zzad paramzzad)
  {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramzzad);
    this.zztt = paramString2;
    this.name = paramString3;
    if (TextUtils.isEmpty(paramString1))
      paramString1 = null;
    this.origin = paramString1;
    this.timestamp = paramLong1;
    this.zzaht = paramLong2;
    if ((this.zzaht != 0L) && (this.zzaht > this.timestamp))
      paramzzbw.zzgt().zzjj().zze("Event created with reverse previous/current timestamps. appId, name", zzas.zzbw(paramString2), zzas.zzbw(paramString3));
    this.zzahu = paramzzad;
  }

  public final String toString()
  {
    String str1 = this.zztt;
    String str2 = this.name;
    String str3 = String.valueOf(this.zzahu);
    return 33 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "Event{appId='" + str1 + "', name='" + str2 + "', params=" + str3 + '}';
  }

  final zzab zza(zzbw paramzzbw, long paramLong)
  {
    return new zzab(paramzzbw, this.origin, this.zztt, this.name, this.timestamp, paramLong, this.zzahu);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzab
 * JD-Core Version:    0.6.2
 */