package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public abstract interface MediationAdapter extends MediationExtrasReceiver
{
  public abstract void onDestroy();

  public abstract void onPause();

  public abstract void onResume();

  public static final class zza
  {
    private int zzena;

    public final Bundle zzacc()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("capabilities", this.zzena);
      return localBundle;
    }

    public final zza zzdj(int paramInt)
    {
      this.zzena = 1;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationAdapter
 * JD-Core Version:    0.6.2
 */