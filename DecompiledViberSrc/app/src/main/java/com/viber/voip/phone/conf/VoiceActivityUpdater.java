package com.viber.voip.phone.conf;

import com.viber.dexshared.Logger;
import com.viber.jni.PCStatistics;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.StatisticsHelper;
import com.viber.voip.phone.StatisticsHelper.IStatisticsObserver;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
import org.webrtc.StatsReport.Value;

public class VoiceActivityUpdater
  implements StatisticsHelper.IStatisticsObserver
{
  private static final Logger L = ViberEnv.getLogger();
  final LevelUpdateCallback mCallback;

  public VoiceActivityUpdater(LevelUpdateCallback paramLevelUpdateCallback)
  {
    this.mCallback = paramLevelUpdateCallback;
    StatisticsHelper.addObserver(this);
  }

  public void dispose()
  {
    StatisticsHelper.removeObserver(this);
  }

  public void onNewStatisticsReport(PCStatistics paramPCStatistics)
  {
    StatsReport[] arrayOfStatsReport = paramPCStatistics.getReports();
    HashMap localHashMap = new HashMap();
    int i = 0;
    int j = arrayOfStatsReport.length;
    int k = 0;
    if (k < j)
    {
      StatsReport localStatsReport = arrayOfStatsReport[k];
      String str1;
      String str2;
      String str3;
      if (localStatsReport.type.compareTo("ssrc") == 0)
      {
        StatsReport.Value[] arrayOfValue = localStatsReport.values;
        int n = arrayOfValue.length;
        int i1 = 0;
        str1 = "";
        str2 = "";
        str3 = "";
        int i2 = 0;
        if (i2 < n)
        {
          StatsReport.Value localValue = arrayOfValue[i2];
          if (localValue.name.compareTo("audioOutputLevel") == 0)
            str3 = localValue.value;
          while (true)
          {
            i2++;
            break;
            if (localValue.name.compareTo("audioInputLevel") == 0)
              str2 = localValue.value;
            else if ((localValue.name.compareTo("ssrc") != 0) && (localValue.name.compareTo("totalAudioEnergy") != 0))
              if (localValue.name.compareTo("googTrackId") == 0)
                str1 = localValue.value;
              else if (localValue.name.compareTo("mediaType") == 0)
                if (localValue.value.compareTo("audio") == 0)
                  i1 = 1;
                else
                  i1 = 0;
          }
        }
        if (i1 != 0)
          if (str2.isEmpty());
      }
      for (int m = Integer.parseInt(str2); ; m = i)
      {
        k++;
        i = m;
        break;
        if (!str3.isEmpty())
          localHashMap.put(str1, Integer.valueOf(Integer.parseInt(str3)));
      }
    }
    if (this.mCallback != null)
      this.mCallback.onLevelsUpdated(localHashMap, i);
  }

  public static abstract interface LevelUpdateCallback
  {
    public abstract void onLevelsUpdated(Map<String, Integer> paramMap, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.VoiceActivityUpdater
 * JD-Core Version:    0.6.2
 */