package org.webrtc;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class RTCStatsReport
{
  private final Map<String, RTCStats> stats;
  private final long timestampUs;

  public RTCStatsReport(long paramLong, Map<String, RTCStats> paramMap)
  {
    this.timestampUs = paramLong;
    this.stats = paramMap;
  }

  @CalledByNative
  private static RTCStatsReport create(long paramLong, Map paramMap)
  {
    return new RTCStatsReport(paramLong, paramMap);
  }

  public Map<String, RTCStats> getStatsMap()
  {
    return this.stats;
  }

  public double getTimestampUs()
  {
    return this.timestampUs;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ timestampUs: ").append(this.timestampUs).append(", stats: [\n");
    Iterator localIterator = this.stats.values().iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      RTCStats localRTCStats = (RTCStats)localIterator.next();
      if (i == 0)
        localStringBuilder.append(",\n");
      localStringBuilder.append(localRTCStats);
    }
    localStringBuilder.append(" ] }");
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RTCStatsReport
 * JD-Core Version:    0.6.2
 */