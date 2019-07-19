package com.google.android.gms.ads.reward.mediation;

import android.content.Context;
import android.os.Bundle;
import java.util.List;

public abstract interface InitializableMediationRewardedVideoAdAdapter extends MediationRewardedVideoAdAdapter
{
  public abstract void initialize(Context paramContext, MediationRewardedVideoAdListener paramMediationRewardedVideoAdListener, List<Bundle> paramList);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter
 * JD-Core Version:    0.6.2
 */