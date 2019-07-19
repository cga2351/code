package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbi
{
  private String value;
  private boolean zzanv;
  private final String zzaob;
  private final String zzoj;

  public zzbi(zzbd paramzzbd, String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.zzoj = paramString1;
    this.zzaob = null;
  }

  public final void zzcd(String paramString)
  {
    if (zzfx.zzv(paramString, this.value))
      return;
    SharedPreferences.Editor localEditor = zzbd.zza(this.zzanw).edit();
    localEditor.putString(this.zzoj, paramString);
    localEditor.apply();
    this.value = paramString;
  }

  public final String zzkd()
  {
    if (!this.zzanv)
    {
      this.zzanv = true;
      this.value = zzbd.zza(this.zzanw).getString(this.zzoj, null);
    }
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbi
 * JD-Core Version:    0.6.2
 */