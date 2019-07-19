package com.google.android.gms.ads.mediation.rtb;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract interface SignalCallbacks
{
  public abstract void onFailure(String paramString);

  public abstract void onSuccess(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.rtb.SignalCallbacks
 * JD-Core Version:    0.6.2
 */