package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbf
{
  private boolean value;
  private final boolean zzanu;
  private boolean zzanv;
  private final String zzoj;

  public zzbf(zzbd paramzzbd, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zzoj = paramString;
    this.zzanu = paramBoolean;
  }

  public final boolean get()
  {
    if (!this.zzanv)
    {
      this.zzanv = true;
      this.value = zzbd.zza(this.zzanw).getBoolean(this.zzoj, this.zzanu);
    }
    return this.value;
  }

  public final void set(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = zzbd.zza(this.zzanw).edit();
    localEditor.putBoolean(this.zzoj, paramBoolean);
    localEditor.apply();
    this.value = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbf
 * JD-Core Version:    0.6.2
 */