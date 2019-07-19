package com.viber.voip.phone.conf;

import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.jni.CallStatistics;
import com.viber.jni.PCStatistics;
import com.viber.jni.QualityScore;
import com.viber.jni.QualityScore.IQualityScoreClient;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.StatisticsHelper;
import com.viber.voip.phone.StatisticsHelper.IStatisticsObserver;
import com.viber.voip.phone.conf.utils.MinMaxAvgCalc;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
import org.webrtc.StatsReport.Value;

public class ConferenceStatsCollector
  implements QualityScore.IQualityScoreClient, StatisticsHelper.IStatisticsObserver, IConferenceCall.UiDelegate, cj.b
{
  public static final int DEFAULT_RTT_VALUE = -1;
  private static final Logger L = ViberEnv.getLogger();
  private String mAudioCodec = "";
  private boolean mCallStarted;
  private long mCallToken;
  private int mHandoverCount;
  private String mHsIp = "";
  private MinMaxAvgCalc mHsRttStatCalc;
  private boolean mIsInitiator;
  private String mLocalIp = "";
  private int mNetworkType = 0;
  private MinMaxAvgCalc mParticipants;
  private QualityScore mQuality;
  private MinMaxAvgCalc mQualityScoreStatCalc;
  private cj mReachability = cj.a(ViberApplication.getApplication());
  private MinMaxAvgCalc mRttStatCalc;
  private long mStartTimestamp;

  public ConferenceStatsCollector()
  {
    this.mReachability.a(this);
    this.mNetworkType = convertNetworkTypeJavaToNetDefines(this.mReachability.a());
    this.mQualityScoreStatCalc = new MinMaxAvgCalc();
    this.mRttStatCalc = new MinMaxAvgCalc();
    this.mHsRttStatCalc = new MinMaxAvgCalc();
    this.mParticipants = new MinMaxAvgCalc();
  }

  private int convertNetworkTypeJavaToNetDefines(int paramInt)
  {
    switch (paramInt)
    {
    default:
      this.mNetworkType = 0;
      return 0;
    case 0:
    case 2:
    case 3:
      this.mNetworkType = 1;
      return 0;
    case 1:
    }
    this.mNetworkType = 2;
    return 0;
  }

  public void backgroundDataChanged(boolean paramBoolean)
  {
  }

  public void connectivityChanged(int paramInt1, int paramInt2)
  {
    this.mNetworkType = convertNetworkTypeJavaToNetDefines(paramInt1);
  }

  public void dispose()
  {
    this.mReachability.b(this);
    StatisticsHelper.removeObserver(this);
    if (this.mQuality != null)
    {
      this.mQuality.removeNotifier(this);
      this.mQuality.dispose();
    }
  }

  public CallStatistics getReport()
  {
    long l1;
    String str1;
    String str2;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    boolean bool1;
    long l2;
    int i4;
    String str3;
    if (this.mCallStarted)
    {
      l1 = (SystemClock.elapsedRealtime() - this.mStartTimestamp) / 1000L;
      str1 = this.mLocalIp;
      str2 = this.mHsIp;
      i = this.mHsRttStatCalc.getMin();
      j = this.mRttStatCalc.getMin();
      k = this.mRttStatCalc.getMax();
      m = this.mRttStatCalc.getAverage();
      n = this.mQualityScoreStatCalc.getMin();
      i1 = this.mQualityScoreStatCalc.getMax();
      i2 = this.mQualityScoreStatCalc.getAverage();
      i3 = this.mParticipants.getMax();
      bool1 = this.mCallStarted;
      l2 = this.mCallToken;
      i4 = this.mHandoverCount;
      str3 = this.mAudioCodec;
      if ((this.mIsInitiator) || (!this.mCallStarted))
        break label191;
    }
    label191: for (boolean bool2 = true; ; bool2 = false)
    {
      return new CallStatistics(str1, str2, i, j, k, m, n, i1, i2, i3, bool1, l2, l1, i4, str3, bool2, this.mNetworkType);
      l1 = 0L;
      break;
    }
  }

  public void onCallTokenChanged(long paramLong)
  {
    this.mNetworkType = this.mReachability.a();
    this.mCallToken = paramLong;
  }

  public void onConferenceCreated(int paramInt, long paramLong, Map<String, Integer> paramMap)
  {
    this.mCallToken = paramLong;
    this.mIsInitiator = true;
  }

  public void onDisconnected()
  {
    IConferenceCall.UiDelegate..CC.onDisconnected(this);
  }

  public void onFirstPeerJoined(ConferenceCall paramConferenceCall, String paramString)
  {
    StatisticsHelper.addObserver(this);
    this.mQuality = new QualityScore(this);
    this.mCallStarted = true;
    this.mStartTimestamp = SystemClock.elapsedRealtime();
  }

  public void onLastPeerLeft(ConferenceCall paramConferenceCall)
  {
    IConferenceCall.UiDelegate..CC.onLastPeerLeft(this, paramConferenceCall);
  }

  public void onNewPeerConnectionNeeded()
  {
    IConferenceCall.UiDelegate..CC.onNewPeerConnectionNeeded(this);
  }

  public void onNewStatisticsReport(PCStatistics paramPCStatistics)
  {
    StatsReport[] arrayOfStatsReport = paramPCStatistics.getReports();
    new HashMap();
    int i = -1;
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3 = "";
    int j = arrayOfStatsReport.length;
    int k = 0;
    int m = -1;
    StatsReport localStatsReport;
    Object localObject4;
    int n;
    Object localObject5;
    Object localObject6;
    if (k < j)
    {
      localStatsReport = arrayOfStatsReport[k];
      if ((localStatsReport.type.equals("ssrc")) && (localStatsReport.id.endsWith("send")))
      {
        StatsReport.Value[] arrayOfValue2 = localStatsReport.values;
        int i4 = arrayOfValue2.length;
        int i5 = 0;
        localObject4 = localObject3;
        int i6 = i;
        while (i5 < i4)
        {
          StatsReport.Value localValue2 = arrayOfValue2[i5];
          if (localValue2.name.equals("googRtt"))
            i6 = Integer.parseInt(localValue2.value);
          if (localValue2.name.equals("googCodecName"))
            localObject4 = localValue2.value;
          i5++;
        }
        n = i6;
        localObject5 = localObject2;
        localObject6 = localObject1;
      }
    }
    while (true)
    {
      k++;
      i = n;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      break;
      if (localStatsReport.type.equals("googCandidatePair"))
      {
        StatsReport.Value[] arrayOfValue1 = localStatsReport.values;
        int i1 = arrayOfValue1.length;
        int i2 = -1;
        String str1 = "";
        String str2 = "";
        boolean bool = false;
        for (int i3 = 0; ; i3++)
        {
          StatsReport.Value localValue1;
          if (i3 < i1)
          {
            localValue1 = arrayOfValue1[i3];
            if (localValue1.name.equals("googActiveConnection"))
            {
              bool = Boolean.parseBoolean(localValue1.value);
              if (bool);
            }
          }
          else
          {
            if (!bool)
              break label459;
            m = i2;
            localObject6 = str2;
            localObject4 = localObject3;
            localObject5 = str1;
            n = i;
            break;
          }
          if (localValue1.name.equals("googLocalAddress"))
            str1 = localValue1.value;
          if (localValue1.name.equals("googRemoteAddress"))
            str2 = localValue1.value;
          if (localValue1.name.equals("googRtt"))
            i2 = Integer.parseInt(localValue1.value);
        }
        if (!this.mLocalIp.equals(localObject2))
        {
          if (!this.mLocalIp.isEmpty())
            this.mHandoverCount = (1 + this.mHandoverCount);
          this.mLocalIp = ((String)localObject2);
        }
        this.mHsIp = ((String)localObject1);
        this.mAudioCodec = ((String)localObject3);
        if (i != -1)
          this.mRttStatCalc.count(i);
        if (m != -1)
          this.mHsRttStatCalc.count(m);
        return;
      }
      label459: localObject4 = localObject3;
      n = i;
      localObject5 = localObject2;
      localObject6 = localObject1;
    }
  }

  public void onPeersChanged(Collection paramCollection)
  {
    IConferenceCall.UiDelegate..CC.onPeersChanged(this, paramCollection);
  }

  public void onPeersCountChanged(int paramInt)
  {
    this.mParticipants.count(paramInt);
  }

  public void onPeersInvited(int paramInt, Map paramMap)
  {
    IConferenceCall.UiDelegate..CC.onPeersInvited(this, paramInt, paramMap);
  }

  public void onQualityScoreUpdated(int paramInt1, int paramInt2)
  {
  }

  public void onRawQualityScore(int paramInt)
  {
    if (paramInt >= 0)
      this.mQualityScoreStatCalc.count(paramInt);
  }

  public void onVolumeLevelChanged(Map paramMap, String paramString)
  {
    IConferenceCall.UiDelegate..CC.onVolumeLevelChanged(this, paramMap, paramString);
  }

  public void wifiConnectivityChanged()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.ConferenceStatsCollector
 * JD-Core Version:    0.6.2
 */