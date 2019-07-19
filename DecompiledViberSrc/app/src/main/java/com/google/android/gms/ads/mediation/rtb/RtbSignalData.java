package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import javax.annotation.Nullable;

public class RtbSignalData
{
  private final Bundle zzcgw;

  @Nullable
  private final AdSize zzdh;
  private final MediationConfiguration zzeoe;
  private final Context zzlj;

  public RtbSignalData(Context paramContext, MediationConfiguration paramMediationConfiguration, Bundle paramBundle, @Nullable AdSize paramAdSize)
  {
    this.zzlj = paramContext;
    this.zzeoe = paramMediationConfiguration;
    this.zzcgw = paramBundle;
    this.zzdh = paramAdSize;
  }

  @Nullable
  public AdSize getAdSize()
  {
    return this.zzdh;
  }

  public MediationConfiguration getConfiguration()
  {
    return this.zzeoe;
  }

  public Context getContext()
  {
    return this.zzlj;
  }

  public Bundle getNetworkExtras()
  {
    return this.zzcgw;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.rtb.RtbSignalData
 * JD-Core Version:    0.6.2
 */