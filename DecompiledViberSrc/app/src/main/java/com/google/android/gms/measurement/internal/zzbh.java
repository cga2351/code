package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.SecureRandom;

public final class zzbh
{
  private final long zzabv;

  @VisibleForTesting
  private final String zzany;
  private final String zzanz;
  private final String zzaoa;

  private zzbh(zzbd paramzzbd, String paramString, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString);
    if (paramLong > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.zzany = String.valueOf(paramString).concat(":start");
      this.zzanz = String.valueOf(paramString).concat(":count");
      this.zzaoa = String.valueOf(paramString).concat(":value");
      this.zzabv = paramLong;
      return;
    }
  }

  private final void zzfl()
  {
    this.zzanw.zzaf();
    long l = this.zzanw.zzbx().currentTimeMillis();
    SharedPreferences.Editor localEditor = zzbd.zza(this.zzanw).edit();
    localEditor.remove(this.zzanz);
    localEditor.remove(this.zzaoa);
    localEditor.putLong(this.zzany, l);
    localEditor.apply();
  }

  private final long zzfn()
  {
    return zzbd.zza(this.zzanw).getLong(this.zzany, 0L);
  }

  public final void zzc(String paramString, long paramLong)
  {
    this.zzanw.zzaf();
    if (zzfn() == 0L)
      zzfl();
    if (paramString == null)
      paramString = "";
    long l = zzbd.zza(this.zzanw).getLong(this.zzanz, 0L);
    if (l <= 0L)
    {
      SharedPreferences.Editor localEditor2 = zzbd.zza(this.zzanw).edit();
      localEditor2.putString(this.zzaoa, paramString);
      localEditor2.putLong(this.zzanz, 1L);
      localEditor2.apply();
      return;
    }
    if ((0xFFFFFFFF & this.zzanw.zzgr().zzmk().nextLong()) < 9223372036854775807L / (l + 1L));
    for (int i = 1; ; i = 0)
    {
      SharedPreferences.Editor localEditor1 = zzbd.zza(this.zzanw).edit();
      if (i != 0)
        localEditor1.putString(this.zzaoa, paramString);
      localEditor1.putLong(this.zzanz, l + 1L);
      localEditor1.apply();
      return;
    }
  }

  public final Pair<String, Long> zzfm()
  {
    this.zzanw.zzaf();
    this.zzanw.zzaf();
    long l1 = zzfn();
    if (l1 == 0L)
      zzfl();
    for (long l2 = 0L; l2 < this.zzabv; l2 = Math.abs(l1 - this.zzanw.zzbx().currentTimeMillis()))
      return null;
    if (l2 > this.zzabv << 1)
    {
      zzfl();
      return null;
    }
    String str = zzbd.zza(this.zzanw).getString(this.zzaoa, null);
    long l3 = zzbd.zza(this.zzanw).getLong(this.zzanz, 0L);
    zzfl();
    if ((str == null) || (l3 <= 0L))
      return zzbd.zzana;
    return new Pair(str, Long.valueOf(l3));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbh
 * JD-Core Version:    0.6.2
 */