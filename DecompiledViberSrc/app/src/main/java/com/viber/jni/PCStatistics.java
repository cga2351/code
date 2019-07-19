package com.viber.jni;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import org.webrtc.StatsReport;

public class PCStatistics
{
  private static final Logger L = ViberEnv.getLogger();
  public final StatsReport[] mReports;

  public PCStatistics(StatsReport[] paramArrayOfStatsReport)
  {
    this.mReports = paramArrayOfStatsReport;
  }

  private static native void updateStatistics(PCStatistics paramPCStatistics);

  public StatsReport[] getReports()
  {
    return this.mReports;
  }

  public PCStatistics publish()
  {
    try
    {
      updateStatistics(this);
      return this;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
    }
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PCStatistics
 * JD-Core Version:    0.6.2
 */