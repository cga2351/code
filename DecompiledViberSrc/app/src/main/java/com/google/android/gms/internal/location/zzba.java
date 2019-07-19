package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.location.LocationStatusCodes;

final class zzba extends zzan
{
  private BaseImplementation.ResultHolder<Status> zzdf;

  public zzba(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.zzdf = paramResultHolder;
  }

  public final void zza(int paramInt, PendingIntent paramPendingIntent)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
  }

  public final void zza(int paramInt, String[] paramArrayOfString)
  {
    if (this.zzdf == null)
    {
      Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
      return;
    }
    Status localStatus = LocationStatusCodes.zzd(LocationStatusCodes.zzc(paramInt));
    this.zzdf.setResult(localStatus);
    this.zzdf = null;
  }

  public final void zzb(int paramInt, String[] paramArrayOfString)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzba
 * JD-Core Version:    0.6.2
 */