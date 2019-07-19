package com.google.android.gms.ads.mediation;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract interface MediationAdLoadCallback<MediationAdT, MediationAdCallbackT>
{
  public abstract void onFailure(String paramString);

  public abstract MediationAdCallbackT onSuccess(MediationAdT paramMediationAdT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationAdLoadCallback
 * JD-Core Version:    0.6.2
 */