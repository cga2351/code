package com.viber.voip.phone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.d.a.b;
import com.d.a.b.b;
import com.d.a.d;
import com.d.a.d.a;
import com.d.a.f;
import com.viber.jni.PCStatistics;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import org.webrtc.StatsReport;
import org.webrtc.StatsReport.Value;

public class VideoCallStatistics
  implements StatisticsHelper.IStatisticsObserver
{
  private static final String STATS_REPORT_ACTUAL_ENC_BITRATE = "googActualEncBitrate";
  private static final String STATS_REPORT_AVAILABLE_RECV_BANDWIDTH = "googAvailableReceiveBandwidth";
  private static final String STATS_REPORT_AVAILABLE_SEND_BANDWIDTH = "googAvailableSendBandwidth";
  private static final String STATS_REPORT_BYTES_RECEIVED = "bytesReceived";
  private static final String STATS_REPORT_BYTES_SENT = "bytesSent";
  private static final String STATS_REPORT_CODEC_IMPL_NAME = "codecImplementationName";
  private static final String STATS_REPORT_CODEC_NAME = "googCodecName";
  private static final String STATS_REPORT_DISCARDED_ON_SEND = "packetsDiscardedOnSend";
  private static final String STATS_REPORT_FIRS_SENT = "googFirsSent";
  private static final String STATS_REPORT_FRAMERATE_SENT = "googFrameRateSent";
  private static final String STATS_REPORT_FRAMES_ENCODED = "framesEncoded";
  private static final String STATS_REPORT_FRAME_HEIGHT_RECEIVED = "googFrameHeightReceived";
  private static final String STATS_REPORT_FRAME_HEIGHT_SENT = "googFrameHeightSent";
  private static final String STATS_REPORT_FRAME_WIDTH_RECEIVED = "googFrameWidthReceived";
  private static final String STATS_REPORT_FRAME_WIDTH_SENT = "googFrameWidthSent";
  private static final String STATS_REPORT_JITTER_RECEIVED = "googJitterReceived";
  private static final String STATS_REPORT_MEDIA_TYPE = "mediaType";
  private static final String STATS_REPORT_NACKS_RECEIVED = "googNacksReceived";
  private static final String STATS_REPORT_NACKS_SENT = "googNacksSent";
  private static final String STATS_REPORT_PACKETS_RECEIVED = "packetsReceived";
  private static final String STATS_REPORT_PACKETS_SENT = "packetsSent";
  private static final String STATS_REPORT_PLIS_RECEIVED = "googPlisReceived";
  private static final String STATS_REPORT_PLIS_SENT = "googPlisSent";
  private static final String STATS_REPORT_REQUESTS_SENT = "requestsSent";
  private static final String STATS_REPORT_RETRANSMIT_BITRATE = "googRetransmitBitrate";
  private static final String STATS_REPORT_RTT_FIELD = "googRtt";
  private static final String STATS_REPORT_TARGET_ENC_BITRATE = "googTargetEncBitrate";
  private static final String STATS_REPORT_TRANSMIT_BITRATE = "googTransmitBitrate";
  private d incomingBWSeries = null;
  private Context mContext;
  private LayoutInflater mInflater;
  private FrameLayout media_statistics_charts;
  private b media_statistics_graphview;
  private d outgoingBWSeries = null;
  private TextView overlay_decoderDisabledLabel = null;
  private TextView overlay_encoderDisabledLabel = null;
  private TextView overlay_estimatedRecvBW = null;
  private TextView overlay_estimatedSendBW = null;
  private TextView overlay_frameDropLabel = null;
  private TextView overlay_latencyOveruseInfo = null;
  private TextView overlay_localRTCP = null;
  private TextView overlay_recvCodecInfo = null;
  private TextView overlay_remoteRTCP = null;
  private TextView overlay_rtt = null;
  private TextView overlay_sendCodecInfo = null;
  private TextView overlay_totalBitrateSent = null;
  private TextView overlay_videoBitrateSent = null;
  private TextView overlay_voiceCodec = null;
  private TextView overlay_voiceSR = null;
  private TextView overlay_vvLoss = null;
  private int tickvalue = 0;

  public VideoCallStatistics(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    this.mContext = paramContext;
    this.mInflater = paramLayoutInflater;
  }

  public View inflate()
  {
    View localView = this.mInflater.inflate(R.layout.video_call_statistics, null);
    this.media_statistics_charts = ((FrameLayout)localView.findViewById(R.id.media_statistics_charts));
    this.overlay_rtt = ((TextView)localView.findViewById(R.id.media_stats_rtt));
    this.overlay_estimatedRecvBW = ((TextView)localView.findViewById(R.id.media_stats_estimatedRecvBW));
    this.overlay_estimatedSendBW = ((TextView)localView.findViewById(R.id.media_stats_estimatedSendBW));
    this.overlay_voiceSR = ((TextView)localView.findViewById(R.id.media_stats_voiceSR));
    this.overlay_videoBitrateSent = ((TextView)localView.findViewById(R.id.media_stats_videoBitrateSent));
    this.overlay_totalBitrateSent = ((TextView)localView.findViewById(R.id.media_stats_totalBitrateSent));
    this.overlay_vvLoss = ((TextView)localView.findViewById(R.id.media_stats_vvLoss));
    this.overlay_localRTCP = ((TextView)localView.findViewById(R.id.media_stats_localRTCP));
    this.overlay_remoteRTCP = ((TextView)localView.findViewById(R.id.media_stats_remoteRTCP));
    this.overlay_sendCodecInfo = ((TextView)localView.findViewById(R.id.media_stats_sendCodecInfo));
    this.overlay_recvCodecInfo = ((TextView)localView.findViewById(R.id.media_stats_recvCodecInfo));
    this.overlay_voiceCodec = ((TextView)localView.findViewById(R.id.media_stats_voice_codec));
    this.overlay_latencyOveruseInfo = ((TextView)localView.findViewById(R.id.media_stats_latency_info));
    this.overlay_frameDropLabel = ((TextView)localView.findViewById(R.id.media_stats_framedrop_label));
    this.overlay_encoderDisabledLabel = ((TextView)localView.findViewById(R.id.media_stats_enc_disabled_label));
    this.overlay_decoderDisabledLabel = ((TextView)localView.findViewById(R.id.media_stats_dec_disabled_label));
    this.media_statistics_graphview = new f(this.mContext, "");
    this.media_statistics_charts.addView(this.media_statistics_graphview, new FrameLayout.LayoutParams(-2, -2));
    this.incomingBWSeries = new d("in_BW", new d.a(-65536, 2), new b.b[0]);
    this.outgoingBWSeries = new d("out_BW", new d.a(-16711936, 2), new b.b[0]);
    this.media_statistics_graphview.a(this.incomingBWSeries);
    this.media_statistics_graphview.a(this.outgoingBWSeries);
    this.media_statistics_graphview.a(0.0D, 90.0D);
    this.media_statistics_graphview.setScalable(true);
    this.media_statistics_graphview.setScrollable(true);
    return localView;
  }

  public void onNewStatisticsReport(PCStatistics paramPCStatistics)
  {
    if (paramPCStatistics == null)
      return;
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3 = "";
    Object localObject4 = "";
    double d1 = 0.0D;
    double d2 = 0.0D;
    Object localObject5 = "";
    Object localObject6 = "";
    StatsReport[] arrayOfStatsReport = paramPCStatistics.getReports();
    int i = arrayOfStatsReport.length;
    int j = 0;
    Object localObject7 = "";
    String str1;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    Object localObject13;
    int m;
    label102: StatsReport.Value localValue;
    if (j < i)
    {
      StatsReport.Value[] arrayOfValue = arrayOfStatsReport[j].values;
      int k = arrayOfValue.length;
      str1 = "";
      localObject8 = localObject6;
      localObject9 = localObject5;
      localObject10 = localObject4;
      localObject11 = localObject3;
      localObject12 = localObject2;
      localObject13 = localObject1;
      m = 0;
      if (m < k)
      {
        localValue = arrayOfValue[m];
        if ("googRtt".equals(localValue.name))
          localObject13 = (String)localObject13 + localValue.value + "; ";
      }
    }
    while (true)
      while (true)
      {
        label160: m++;
        break label102;
        if ("googAvailableSendBandwidth".equals(localValue.name))
          localObject11 = (String)localObject11 + localValue.value + "; ";
        try
        {
          while (true)
          {
            double d4 = Double.parseDouble(localValue.value);
            d2 = d4;
            break label160;
            if ("googAvailableReceiveBandwidth".equals(localValue.name))
              localObject12 = (String)localObject12 + localValue.value + "; ";
            try
            {
              double d3 = Double.parseDouble(localValue.value);
              d1 = d3;
              break label160;
              if ("bytesSent".equals(localValue.name))
              {
                localObject10 = (String)localObject10 + "bytesSent=" + localValue.value + "; ";
                break label160;
              }
              if ("packetsSent".equals(localValue.name))
              {
                localObject10 = (String)localObject10 + "pktsSent=" + localValue.value + "; ";
                break label160;
              }
              if ("mediaType".equals(localValue.name))
              {
                StringBuilder localStringBuilder3 = new StringBuilder().append(str1);
                if (localValue.value.length() != 0);
                for (String str5 = localValue.value + ": "; ; str5 = "")
                {
                  str1 = str5;
                  break;
                }
              }
              if ("googCodecName".equals(localValue.name))
              {
                StringBuilder localStringBuilder2 = new StringBuilder().append(str1);
                if (localValue.value.length() != 0);
                for (String str4 = localValue.value + "; "; ; str4 = "")
                {
                  str1 = str4;
                  break;
                }
              }
              if ("codecImplementationName".equals(localValue.name))
              {
                StringBuilder localStringBuilder1 = new StringBuilder().append(str1);
                if (localValue.value.length() != 0);
                for (String str3 = "impl=" + localValue.value + "; "; ; str3 = "")
                {
                  str1 = str3;
                  break;
                }
              }
              if ("googFrameHeightReceived".equals(localValue.name))
              {
                localObject8 = (String)localObject8 + "h:" + localValue.value + " ";
                break label160;
              }
              if ("googFrameWidthReceived".equals(localValue.name))
              {
                localObject8 = (String)localObject8 + "w:" + localValue.value + " ";
                break label160;
              }
              if ("googFrameHeightSent".equals(localValue.name))
              {
                localObject9 = (String)localObject9 + "h:" + localValue.value + " ";
                break label160;
              }
              if (!"googFrameWidthSent".equals(localValue.name))
                break label160;
              localObject9 = (String)localObject9 + "w:" + localValue.value + " ";
              break label160;
              String str2 = (String)localObject7 + str1 + "; ";
              j++;
              localObject7 = str2;
              localObject1 = localObject13;
              localObject2 = localObject12;
              localObject3 = localObject11;
              localObject4 = localObject10;
              localObject5 = localObject9;
              localObject6 = localObject8;
              break;
              if (this.overlay_rtt != null)
                this.overlay_rtt.setText((CharSequence)localObject1);
              if (this.overlay_estimatedRecvBW != null)
                this.overlay_estimatedRecvBW.setText((CharSequence)localObject2);
              if (this.overlay_estimatedSendBW != null)
                this.overlay_estimatedSendBW.setText((CharSequence)localObject3);
              if (this.overlay_voiceSR != null)
                this.overlay_voiceSR.setText("" + "/" + "");
              if (this.overlay_totalBitrateSent != null)
                this.overlay_totalBitrateSent.setText((CharSequence)localObject4);
              if (this.overlay_videoBitrateSent != null)
                this.overlay_videoBitrateSent.setText("");
              if (this.overlay_vvLoss != null)
                this.overlay_vvLoss.setText("");
              if (this.incomingBWSeries != null)
                this.incomingBWSeries.a(new b.b(this.tickvalue, d1), true, 90);
              if (this.outgoingBWSeries != null)
                this.outgoingBWSeries.a(new b.b(this.tickvalue, d2), true, 90);
              if (this.overlay_voiceCodec != null)
                this.overlay_voiceCodec.setText((CharSequence)localObject7);
              if (this.overlay_sendCodecInfo != null)
                this.overlay_sendCodecInfo.setText((CharSequence)localObject5);
              if (this.overlay_recvCodecInfo != null)
                this.overlay_recvCodecInfo.setText((CharSequence)localObject6);
              this.tickvalue = (1 + this.tickvalue);
              return;
            }
            catch (Exception localException1)
            {
            }
          }
        }
        catch (Exception localException2)
        {
        }
      }
  }

  public void startUpdating()
  {
    StatisticsHelper.addObserver(this);
  }

  public void stopUpdating()
  {
    StatisticsHelper.removeObserver(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.VideoCallStatistics
 * JD-Core Version:    0.6.2
 */