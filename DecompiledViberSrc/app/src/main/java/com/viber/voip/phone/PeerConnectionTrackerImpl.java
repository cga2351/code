package com.viber.voip.phone;

import com.viber.common.a.a;
import com.viber.dexshared.Logger;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.voip.ViberEnv;
import java.io.File;
import java.util.Date;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.RTCConfiguration;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.StatsReport;
import org.webrtc.StatsReport.Value;

public class PeerConnectionTrackerImpl extends PeerConnectionNullTrackerImpl
{
  private static final Logger L = ViberEnv.getLogger();
  public static final String PEERCONNECTION_TRACKER_PATH = ViberEnv.getLoggerFactory().getLoggerConfig().a().getParentFile().getAbsolutePath() + "/callstats";
  private final PeerConnectionTrackerReportBuilder mReportBuilder = new PeerConnectionTrackerReportBuilder();

  // ERROR //
  public void save(long paramLong, IPeerConnectionTracker.CompletionCallback paramCompletionCallback)
  {
    // Byte code:
    //   0: new 22	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 61	com/viber/voip/phone/PeerConnectionTrackerImpl:PEERCONNECTION_TRACKER_PATH	Ljava/lang/String;
    //   10: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: ldc 75
    //   15: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: lload_1
    //   19: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: ldc 80
    //   24: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 4
    //   32: new 43	java/io/File
    //   35: dup
    //   36: getstatic 61	com/viber/voip/phone/PeerConnectionTrackerImpl:PEERCONNECTION_TRACKER_PATH	Ljava/lang/String;
    //   39: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokestatic 88	com/viber/voip/util/at:a	(Ljava/io/File;)Z
    //   45: ifne +12 -> 57
    //   48: getstatic 61	com/viber/voip/phone/PeerConnectionTrackerImpl:PEERCONNECTION_TRACKER_PATH	Ljava/lang/String;
    //   51: invokestatic 92	com/viber/voip/util/at:i	(Ljava/lang/String;)Z
    //   54: ifne +3 -> 57
    //   57: aload_0
    //   58: getfield 67	com/viber/voip/phone/PeerConnectionTrackerImpl:mReportBuilder	Lcom/viber/voip/phone/PeerConnectionTrackerReportBuilder;
    //   61: invokevirtual 95	com/viber/voip/phone/PeerConnectionTrackerReportBuilder:build	()Ljava/lang/String;
    //   64: astore 6
    //   66: new 97	java/io/FileOutputStream
    //   69: dup
    //   70: aload 4
    //   72: iconst_0
    //   73: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   76: astore 7
    //   78: new 102	java/io/OutputStreamWriter
    //   81: dup
    //   82: aload 7
    //   84: invokespecial 105	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   87: astore 8
    //   89: aload 8
    //   91: aload 6
    //   93: invokevirtual 108	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   96: aload 8
    //   98: invokevirtual 111	java/io/OutputStreamWriter:flush	()V
    //   101: aload 8
    //   103: ifnull +12 -> 115
    //   106: iconst_0
    //   107: ifeq +92 -> 199
    //   110: aload 8
    //   112: invokevirtual 114	java/io/OutputStreamWriter:close	()V
    //   115: aload 7
    //   117: ifnull +12 -> 129
    //   120: iconst_0
    //   121: ifeq +158 -> 279
    //   124: aload 7
    //   126: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   129: aload_3
    //   130: aload 4
    //   132: aconst_null
    //   133: invokeinterface 121 3 0
    //   138: return
    //   139: astore 20
    //   141: aconst_null
    //   142: aload 20
    //   144: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   147: goto -32 -> 115
    //   150: astore 14
    //   152: aload 14
    //   154: athrow
    //   155: astore 15
    //   157: aload 14
    //   159: astore 12
    //   161: aload 15
    //   163: astore 11
    //   165: aload 7
    //   167: ifnull +13 -> 180
    //   170: aload 12
    //   172: ifnull +127 -> 299
    //   175: aload 7
    //   177: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   180: aload 11
    //   182: athrow
    //   183: astore 5
    //   185: aload_3
    //   186: aload 4
    //   188: aload 5
    //   190: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: invokeinterface 121 3 0
    //   198: return
    //   199: aload 8
    //   201: invokevirtual 114	java/io/OutputStreamWriter:close	()V
    //   204: goto -89 -> 115
    //   207: astore 11
    //   209: aconst_null
    //   210: astore 12
    //   212: goto -47 -> 165
    //   215: astore 17
    //   217: aload 17
    //   219: athrow
    //   220: astore 18
    //   222: aload 17
    //   224: astore 10
    //   226: aload 18
    //   228: astore 9
    //   230: aload 8
    //   232: ifnull +13 -> 245
    //   235: aload 10
    //   237: ifnull +23 -> 260
    //   240: aload 8
    //   242: invokevirtual 114	java/io/OutputStreamWriter:close	()V
    //   245: aload 9
    //   247: athrow
    //   248: astore 16
    //   250: aload 10
    //   252: aload 16
    //   254: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   257: goto -12 -> 245
    //   260: aload 8
    //   262: invokevirtual 114	java/io/OutputStreamWriter:close	()V
    //   265: goto -20 -> 245
    //   268: astore 19
    //   270: aconst_null
    //   271: aload 19
    //   273: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   276: goto -147 -> 129
    //   279: aload 7
    //   281: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   284: goto -155 -> 129
    //   287: astore 13
    //   289: aload 12
    //   291: aload 13
    //   293: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   296: goto -116 -> 180
    //   299: aload 7
    //   301: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   304: goto -124 -> 180
    //   307: astore 9
    //   309: aconst_null
    //   310: astore 10
    //   312: goto -82 -> 230
    //
    // Exception table:
    //   from	to	target	type
    //   110	115	139	java/lang/Throwable
    //   78	89	150	java/lang/Throwable
    //   141	147	150	java/lang/Throwable
    //   199	204	150	java/lang/Throwable
    //   245	248	150	java/lang/Throwable
    //   250	257	150	java/lang/Throwable
    //   260	265	150	java/lang/Throwable
    //   152	155	155	finally
    //   57	78	183	java/lang/Exception
    //   124	129	183	java/lang/Exception
    //   129	138	183	java/lang/Exception
    //   175	180	183	java/lang/Exception
    //   180	183	183	java/lang/Exception
    //   270	276	183	java/lang/Exception
    //   279	284	183	java/lang/Exception
    //   289	296	183	java/lang/Exception
    //   299	304	183	java/lang/Exception
    //   78	89	207	finally
    //   110	115	207	finally
    //   141	147	207	finally
    //   199	204	207	finally
    //   240	245	207	finally
    //   245	248	207	finally
    //   250	257	207	finally
    //   260	265	207	finally
    //   89	101	215	java/lang/Throwable
    //   217	220	220	finally
    //   240	245	248	java/lang/Throwable
    //   124	129	268	java/lang/Throwable
    //   175	180	287	java/lang/Throwable
    //   89	101	307	finally
  }

  public void trackAddIceCandidate(IceCandidate paramIceCandidate, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.trackAddIceCandidate(paramIceCandidate, paramBoolean1, paramBoolean2);
    this.mReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.IceCandidate(paramIceCandidate.sdpMid, Integer.toString(paramIceCandidate.sdpMLineIndex), paramIceCandidate.sdp).toUpdateRecord());
  }

  public void trackAddStream(String paramString, boolean paramBoolean)
  {
    super.trackAddStream(paramString, paramBoolean);
    PeerConnectionTrackerReportBuilder localPeerConnectionTrackerReportBuilder = this.mReportBuilder;
    if (paramBoolean);
    for (String str = "addStream"; ; str = "OnAddStream")
    {
      localPeerConnectionTrackerReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.MediaStream(str, paramString).toUpdateRecord());
      return;
    }
  }

  public void trackCallToken(long paramLong, String paramString)
  {
    super.trackCallToken(paramLong, paramString);
    this.mReportBuilder.setCallToken(paramLong);
    this.mReportBuilder.setDescription(paramString);
  }

  public void trackCreateAnswer(MediaConstraints paramMediaConstraints)
  {
    super.trackCreateAnswer(paramMediaConstraints);
    this.mReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.CreateAnswer(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.AnswerOptions(paramMediaConstraints)).toUpdateRecord());
  }

  public void trackCreateAnswerCallback(String paramString1, String paramString2, String paramString3)
  {
    super.trackCreateAnswerCallback(paramString1, paramString2, paramString3);
    PeerConnectionTrackerReportBuilder localPeerConnectionTrackerReportBuilder = this.mReportBuilder;
    if ((paramString3 == null) || (paramString3.length() == 0));
    for (String str = "OnSuccess"; ; str = "OnFailure")
    {
      localPeerConnectionTrackerReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.SessionDescription("createAnswer", paramString1, paramString2, str).toUpdateRecord());
      return;
    }
  }

  public void trackCreateDataChannel(String paramString, boolean paramBoolean)
  {
    super.trackCreateDataChannel(paramString, paramBoolean);
    this.mReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.DataChannel().toUpdateRecord());
  }

  public void trackCreateOffer(MediaConstraints paramMediaConstraints)
  {
    super.trackCreateOffer(paramMediaConstraints);
    this.mReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.CreateOffer(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.OfferOptions(paramMediaConstraints)).toUpdateRecord());
  }

  public void trackCreateOfferCallback(String paramString1, String paramString2, String paramString3)
  {
    super.trackCreateOfferCallback(paramString1, paramString2, paramString3);
    PeerConnectionTrackerReportBuilder localPeerConnectionTrackerReportBuilder = this.mReportBuilder;
    if ((paramString3 == null) || (paramString3.length() == 0));
    for (String str = "OnSuccess"; ; str = "OnFailure")
    {
      localPeerConnectionTrackerReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.SessionDescription("createOffer", paramString1, paramString2, str).toUpdateRecord());
      return;
    }
  }

  public void trackHostApplicationInfo(BasicRTCCall.RTCCallDelegate paramRTCCallDelegate)
  {
    super.trackHostApplicationInfo(paramRTCCallDelegate);
    this.mReportBuilder.addVersionInfo(paramRTCCallDelegate.getDeviceModel(), paramRTCCallDelegate.getSystemName(), paramRTCCallDelegate.getSystemVersion(), paramRTCCallDelegate.getViberVersion(), paramRTCCallDelegate.getVoiceLibVersion(), paramRTCCallDelegate.getWebRtcVersion());
  }

  public void trackIceConnectionStateChange(PeerConnection.IceConnectionState paramIceConnectionState)
  {
    super.trackIceConnectionStateChange(paramIceConnectionState);
    this.mReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.IceConnectionStateChange(paramIceConnectionState.toString()).toUpdateRecord());
  }

  public void trackIceGatheringStateChange(PeerConnection.IceGatheringState paramIceGatheringState)
  {
    super.trackIceGatheringStateChange(paramIceGatheringState);
    this.mReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.IceGatheringStateChange(paramIceGatheringState.toString()).toUpdateRecord());
  }

  public void trackOnRenegotiationNeeded()
  {
    super.trackOnRenegotiationNeeded();
    this.mReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.OnRenegotiationNeeded().toUpdateRecord());
  }

  public void trackPeerConnection(PeerConnection paramPeerConnection, PeerConnection.RTCConfiguration paramRTCConfiguration, MediaConstraints paramMediaConstraints)
  {
    super.trackPeerConnection(paramPeerConnection, paramRTCConfiguration, paramMediaConstraints);
    PeerConnectionTrackerReportBuilder localPeerConnectionTrackerReportBuilder = this.mReportBuilder;
    if (paramMediaConstraints != null);
    for (String str = paramMediaConstraints.toString(); ; str = "")
    {
      localPeerConnectionTrackerReportBuilder.setMediaConstraints(str);
      this.mReportBuilder.setRtcConfiguration(paramRTCConfiguration);
      return;
    }
  }

  public void trackRemoveStream(String paramString, boolean paramBoolean)
  {
    super.trackRemoveStream(paramString, paramBoolean);
    PeerConnectionTrackerReportBuilder localPeerConnectionTrackerReportBuilder = this.mReportBuilder;
    if (paramBoolean);
    for (String str = "removeStream"; ; str = "OnRemoveStream")
    {
      localPeerConnectionTrackerReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.MediaStream(str, paramString).toUpdateRecord());
      return;
    }
  }

  public void trackSetConfiguration(PeerConnection.RTCConfiguration paramRTCConfiguration)
  {
    super.trackSetConfiguration(paramRTCConfiguration);
  }

  public void trackSetSessionDescription(String paramString1, String paramString2, boolean paramBoolean)
  {
    super.trackSetSessionDescription(paramString1, paramString2, paramBoolean);
    PeerConnectionTrackerReportBuilder localPeerConnectionTrackerReportBuilder = this.mReportBuilder;
    if (paramBoolean);
    for (String str = "setLocalDescription"; ; str = "setRemoteDescription")
    {
      localPeerConnectionTrackerReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.SessionDescription(str, paramString1, paramString2).toUpdateRecord());
      return;
    }
  }

  public void trackSetSessionDescriptionCallback(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super.trackSetSessionDescriptionCallback(paramString1, paramString2, paramString3, paramBoolean);
    PeerConnectionTrackerReportBuilder localPeerConnectionTrackerReportBuilder = this.mReportBuilder;
    String str1;
    if (paramBoolean)
    {
      str1 = "setLocalDescription";
      if ((paramString3 != null) && (paramString3.length() != 0))
        break label70;
    }
    label70: for (String str2 = "OnSuccess"; ; str2 = "OnFailure")
    {
      localPeerConnectionTrackerReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.SessionDescription(str1, paramString1, paramString2, str2).toUpdateRecord());
      return;
      str1 = "setRemoteDescription";
      break;
    }
  }

  public void trackSignalingStateChange(PeerConnection.SignalingState paramSignalingState)
  {
    super.trackSignalingStateChange(paramSignalingState);
    this.mReportBuilder.addUpdateRecord(new PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.SignalingStateChange(paramSignalingState.toString()).toUpdateRecord());
  }

  public void trackStatsReports(StatsReport[] paramArrayOfStatsReport)
  {
    super.trackStatsReports(paramArrayOfStatsReport);
    int i = paramArrayOfStatsReport.length;
    for (int j = 0; j < i; j++)
    {
      StatsReport localStatsReport = paramArrayOfStatsReport[j];
      Date localDate = new Date(()localStatsReport.timestamp);
      for (StatsReport.Value localValue : localStatsReport.values)
      {
        String str = localStatsReport.id + "-" + localValue.name;
        this.mReportBuilder.addDataSeriesValue(str, localDate, localValue.value);
      }
    }
  }

  public void trackStop()
  {
    super.trackStop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PeerConnectionTrackerImpl
 * JD-Core Version:    0.6.2
 */