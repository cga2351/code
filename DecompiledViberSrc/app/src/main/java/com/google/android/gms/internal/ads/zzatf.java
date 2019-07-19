package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

@zzare
public final class zzatf
  implements RewardItem
{
  private final zzass zzdqr;

  public zzatf(zzass paramzzass)
  {
    this.zzdqr = paramzzass;
  }

  public final int getAmount()
  {
    if (this.zzdqr == null)
      return 0;
    try
    {
      int i = this.zzdqr.getAmount();
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
    if (this.zzdqr == null)
      return null;
    try
    {
      String str = this.zzdqr.getType();
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzatf
 * JD-Core Version:    0.6.2
 */