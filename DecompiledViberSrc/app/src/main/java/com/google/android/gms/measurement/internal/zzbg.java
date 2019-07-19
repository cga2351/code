package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbg
{
  private long value;
  private boolean zzanv;
  private final long zzanx;
  private final String zzoj;

  public zzbg(zzbd paramzzbd, String paramString, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zzoj = paramString;
    this.zzanx = paramLong;
  }

  public final long get()
  {
    if (!this.zzanv)
    {
      this.zzanv = true;
      this.value = zzbd.zza(this.zzanw).getLong(this.zzoj, this.zzanx);
    }
    return this.value;
  }

  public final void set(long paramLong)
  {
    SharedPreferences.Editor localEditor = zzbd.zza(this.zzanw).edit();
    localEditor.putLong(this.zzoj, paramLong);
    localEditor.apply();
    this.value = paramLong;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbg
 * JD-Core Version:    0.6.2
 */