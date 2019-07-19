package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

@zzare
public final class zzaby extends zzaan
{
  private final OnAdMetadataChangedListener zzckf;

  public zzaby(OnAdMetadataChangedListener paramOnAdMetadataChangedListener)
  {
    this.zzckf = paramOnAdMetadataChangedListener;
  }

  public final void onAdMetadataChanged()
    throws RemoteException
  {
    if (this.zzckf != null)
      this.zzckf.onAdMetadataChanged();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaby
 * JD-Core Version:    0.6.2
 */