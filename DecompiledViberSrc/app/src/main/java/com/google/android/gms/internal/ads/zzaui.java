package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

@zzare
public final class zzaui
  implements RewardItem
{
  private final zzatr zzdqy;

  public zzaui(zzatr paramzzatr)
  {
    this.zzdqy = paramzzatr;
  }

  public final int getAmount()
  {
    if (this.zzdqy == null)
      return 0;
    try
    {
      int i = this.zzdqy.getAmount();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not forward getAmount to RewardItem", localRemoteException);
    }
    return 0;
  }

  public final String getType()
  {
    if (this.zzdqy == null)
      return null;
    try
    {
      String str = this.zzdqy.getType();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not forward getType to RewardItem", localRemoteException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaui
 * JD-Core Version:    0.6.2
 */