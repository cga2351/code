package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

public class MediationConfiguration
{
  private final Bundle zzemx;
  private final AdFormat zzenb;

  public MediationConfiguration(AdFormat paramAdFormat, Bundle paramBundle)
  {
    this.zzenb = paramAdFormat;
    this.zzemx = paramBundle;
  }

  public AdFormat getFormat()
  {
    return this.zzenb;
  }

  public Bundle getServerParameters()
  {
    return this.zzemx;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationConfiguration
 * JD-Core Version:    0.6.2
 */