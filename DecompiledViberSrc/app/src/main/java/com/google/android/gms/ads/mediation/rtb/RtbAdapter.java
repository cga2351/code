package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.mediation.Adapter;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class RtbAdapter extends Adapter
{
  public abstract void collectSignals(RtbSignalData paramRtbSignalData, SignalCallbacks paramSignalCallbacks);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.rtb.RtbAdapter
 * JD-Core Version:    0.6.2
 */