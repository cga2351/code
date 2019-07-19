package com.viber.voip.phone;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaConstraints.KeyValuePair;
import org.webrtc.PeerConnection.RTCConfiguration;

public class PeerConnectionTrackerReportBuilder
{
  private static final Logger L;
  private static final int updateLogCapacity = 200;
  private final LinkedList<PeerConnectionRecord> peerConnectionRecords = new LinkedList();
  private String userAgent = "Viber_Android";

  static
  {
    if (!PeerConnectionTrackerReportBuilder.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      L = ViberEnv.getLogger();
      return;
    }
  }

  private static String Escape(String paramString)
  {
    if (!paramString.startsWith("\""));
    for (String str = "\"" + paramString; ; str = paramString)
    {
      if (!paramString.endsWith("\""))
        str = str + "\"";
      return str;
    }
  }

  private static <T> Collection<T> Escape(Collection<T> paramCollection)
  {
    while (true)
    {
      Collection localCollection;
      Object localObject;
      try
      {
        localCollection = (Collection)paramCollection.getClass().newInstance();
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((localObject == null) || (localObject.getClass() != String.class))
            break label87;
          localCollection.add(Escape((String)localObject));
          continue;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        localCollection = null;
        return localCollection;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return null;
      }
      label87: localCollection.add(localObject);
    }
  }

  private void fillStatsSeries(PeerConnectionRecord paramPeerConnectionRecord, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramPeerConnectionRecord.dataSeries.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localJSONObject.put(((DataSeries)localEntry.getValue()).id, ((DataSeries)localEntry.getValue()).toStatRecord().toJson());
    }
    paramJSONObject.put("stats", localJSONObject);
  }

  private void fillUpdateLog(PeerConnectionRecord paramPeerConnectionRecord, JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramPeerConnectionRecord.updateLog.iterator();
    while (localIterator.hasNext())
    {
      UpdateRecord localUpdateRecord = (UpdateRecord)localIterator.next();
      if (localUpdateRecord != null)
        localJSONArray.put(localUpdateRecord.toJson());
    }
    paramJSONObject.put("updateLog", localJSONArray);
  }

  private static <T> T fromJSON(String paramString)
  {
    try
    {
      PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable localJSONSerializable = PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.fromJSONString(paramString);
      return localJSONSerializable;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private PeerConnectionRecord getPeerConnectionRecord()
  {
    if (this.peerConnectionRecords.size() == 0)
      this.peerConnectionRecords.add(new PeerConnectionRecord());
    return (PeerConnectionRecord)this.peerConnectionRecords.getLast();
  }

  private static <T> String toJSON(List<T> paramList, boolean paramBoolean)
  {
    Object localObject = "";
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable localJSONSerializable;
      if (localIterator.hasNext())
        localJSONSerializable = PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.obtain(localIterator.next());
      try
      {
        String str = (String)localObject + localJSONSerializable.Serialize();
        localObject = str;
        continue;
        return localObject;
      }
      catch (JSONException localJSONException)
      {
      }
    }
  }

  private static <T> JSONObject toJSON(Object paramObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Field[] arrayOfField = paramObject.getClass().getFields();
    int i = arrayOfField.length;
    int j = 0;
    while (true)
    {
      Field localField;
      if (j < i)
        localField = arrayOfField[j];
      try
      {
        localJSONObject.put(localField.getName(), localField.get(paramObject));
        label50: j++;
        continue;
        return localJSONObject;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label50;
      }
    }
  }

  public void addDataSeriesValue(String paramString1, Date paramDate, String paramString2)
  {
    DataSeries localDataSeries = getDataSeries(paramString1);
    assert (localDataSeries != null);
    localDataSeries.add(paramDate, paramString2);
  }

  public void addUpdateRecord(UpdateRecord paramUpdateRecord)
  {
    while (getPeerConnectionRecord().updateLog.size() >= 200)
      getPeerConnectionRecord().updateLog.remove();
    getPeerConnectionRecord().updateLog.offer(paramUpdateRecord);
  }

  public void addVersionInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.userAgent = ("Viber_Android/" + paramString4 + " (" + paramString2 + " " + paramString3 + "; " + paramString1 + "; VoiceLib " + paramString5 + "; WebRTC " + paramString6 + ")");
  }

  public String build()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Iterator localIterator = this.peerConnectionRecords.iterator();
    if (localIterator.hasNext())
    {
      PeerConnectionRecord localPeerConnectionRecord = (PeerConnectionRecord)localIterator.next();
      JSONObject localJSONObject3 = new JSONObject();
      fillUpdateLog(localPeerConnectionRecord, localJSONObject3);
      if (localPeerConnectionRecord.constraints != null);
      for (String str = localPeerConnectionRecord.constraints.toString(); ; str = "")
      {
        localJSONObject3.put("constraints", str);
        fillStatsSeries(localPeerConnectionRecord, localJSONObject3);
        localJSONObject3.put("url", "http://viber.com/call?id=" + localPeerConnectionRecord.calltoken + "&description=" + localPeerConnectionRecord.description);
        localJSONObject3.put("rtcConfiguration", localPeerConnectionRecord.rtcConfiguration);
        localJSONObject2.put(localPeerConnectionRecord.calltoken, localJSONObject3);
        break;
      }
    }
    localJSONObject1.put("PeerConnections", localJSONObject2);
    localJSONObject1.put("UserAgent", this.userAgent);
    localJSONObject1.put("getUserMedia", new JSONArray());
    return localJSONObject1.toString();
  }

  public DataSeries getDataSeries(String paramString)
  {
    if (!getPeerConnectionRecord().dataSeries.containsKey(paramString))
      getPeerConnectionRecord().dataSeries.put(paramString, new DataSeries(paramString));
    return (DataSeries)getPeerConnectionRecord().dataSeries.get(paramString);
  }

  public void setCallToken(long paramLong)
  {
    PeerConnectionRecord localPeerConnectionRecord = getPeerConnectionRecord();
    PeerConnectionRecord.access$202(localPeerConnectionRecord, localPeerConnectionRecord.calltoken + Long.toString(paramLong));
  }

  public void setDescription(String paramString)
  {
    PeerConnectionRecord.access$302(getPeerConnectionRecord(), paramString);
  }

  public void setMediaConstraints(String paramString)
  {
    getPeerConnectionRecord().constraints = paramString;
  }

  public void setRtcConfiguration(PeerConnection.RTCConfiguration paramRTCConfiguration)
  {
    try
    {
      getPeerConnectionRecord().rtcConfiguration = toJSON(paramRTCConfiguration).toString();
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public static class DataSeries
  {
    private static int capacity;
    private final String id;
    private Queue<Date> times = new LinkedList();
    private Queue<String> values = new LinkedList();

    static
    {
      if (!PeerConnectionTrackerReportBuilder.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        capacity = 1200;
        return;
      }
    }

    DataSeries(String paramString)
    {
      this.id = paramString;
    }

    private static String serializedValues(String paramString, Queue<String> paramQueue)
    {
      if ((paramString.startsWith("ssrc_")) && (paramString.endsWith("-ssrc")))
        return "[" + TextUtils.join(",", PeerConnectionTrackerReportBuilder.Escape(paramQueue)) + "]";
      if ((paramQueue == null) || (paramQueue.size() < 0))
        return "[]";
      String str = (String)paramQueue.peek();
      if (("null".compareTo(str) == 0) || (PeerConnectionTrackerReportBuilder.FormatUtils.isNumeric(str)) || (PeerConnectionTrackerReportBuilder.FormatUtils.isBoolean(str)));
      for (int i = 0; ; i = 1)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("[");
        if (i != 0)
          paramQueue = PeerConnectionTrackerReportBuilder.Escape(paramQueue);
        return TextUtils.join(",", paramQueue) + "]";
      }
    }

    public boolean add(Date paramDate, String paramString)
    {
      while (this.times.size() >= capacity)
        this.times.remove();
      while (this.values.size() >= capacity)
        this.values.remove();
      this.times.offer(paramDate);
      this.values.offer(paramString);
      assert (this.times.size() == this.values.size());
      return this.times.size() == this.values.size();
    }

    public PeerConnectionTrackerReportBuilder.StatRecord toStatRecord()
    {
      if (this.times.size() != 0)
        return new PeerConnectionTrackerReportBuilder.StatRecord((Date)this.times.peek(), (Date)((LinkedList)this.times).getLast(), serializedValues(this.id, this.values));
      return new PeerConnectionTrackerReportBuilder.StatRecord(new Date(), new Date(), serializedValues(this.id, this.values));
    }
  }

  private static final class FormatUtils
  {
    static final Pattern mNumericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    static boolean isBoolean(String paramString)
    {
      return ("true".compareToIgnoreCase(paramString) == 0) || ("false".compareToIgnoreCase(paramString) == 0);
    }

    public static boolean isNumeric(String paramString)
    {
      return mNumericPattern.matcher(paramString).matches();
    }
  }

  private static final class JSONAPI
  {
    public static final class JSONIntSerializable extends PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable
    {
      public PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.kType getType()
      {
        return PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.kType.kInt;
      }

      public String toJSONString(JSONObject paramJSONObject)
        throws JSONException
      {
        return null;
      }
    }

    public static abstract class JSONSerializable
    {
      public final kType type = getType();

      public JSONSerializable()
      {
      }

      private JSONSerializable(String paramString)
        throws JSONException
      {
        new JSONObject(paramString);
      }

      public static JSONSerializable fromJSONString(String paramString)
        throws JSONException
      {
        new JSONObject(paramString);
        return null;
      }

      public static <T> JSONSerializable obtain(T paramT)
      {
        if ((Integer.TYPE != paramT.getClass()) && (Integer.class == paramT.getClass()));
        return null;
      }

      public String Serialize()
        throws JSONException
      {
        return toJSONString(new JSONObject());
      }

      public abstract kType getType();

      public abstract String toJSONString(JSONObject paramJSONObject)
        throws JSONException;

      public static enum kType
      {
        static
        {
          kString = new kType("kString", 1);
          kInt = new kType("kInt", 2);
          kRtcUpdateLogEvent = new kType("kRtcUpdateLogEvent", 3);
          kType[] arrayOfkType = new kType[4];
          arrayOfkType[0] = kUnknown;
          arrayOfkType[1] = kString;
          arrayOfkType[2] = kInt;
          arrayOfkType[3] = kRtcUpdateLogEvent;
        }
      }
    }
  }

  public static class PeerConnectionRecord
  {
    private String calltoken = "ct_";
    public String constraints = "";
    private Map<String, PeerConnectionTrackerReportBuilder.DataSeries> dataSeries = new HashMap();
    private String description = "";
    public String rtcConfiguration = "";
    private Queue<PeerConnectionTrackerReportBuilder.UpdateRecord> updateLog = new LinkedList();
  }

  public static class StatRecord
  {
    public Date endTime = new Date();
    public Date startTime = new Date();
    public String values = "";

    public StatRecord(Date paramDate1, Date paramDate2, String paramString)
    {
      this.startTime = paramDate1;
      this.endTime = paramDate2;
      this.values = paramString;
    }

    public JSONObject toJson()
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("startTime", PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.dateFormat.format(this.startTime));
      localJSONObject.put("endTime", PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.dateFormat.format(this.endTime));
      localJSONObject.put("values", this.values);
      return localJSONObject;
    }
  }

  public static class UpdateRecord
  {
    public String time = null;
    public String type = "";
    public String value = "";

    public UpdateRecord(String paramString1, String paramString2)
    {
      this(new Date(), paramString1, paramString2);
    }

    public UpdateRecord(Date paramDate, String paramString1, String paramString2)
    {
      this.time = PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.dateFormat.format(paramDate);
      this.type = paramString1;
      this.value = paramString2;
    }

    public UpdateRecord(Map.Entry<String, String> paramEntry)
    {
      this((String)paramEntry.getKey(), (String)paramEntry.getValue());
    }

    public JSONObject toJson()
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      String str1;
      String str2;
      if (this.type != null)
      {
        str1 = this.type;
        localJSONObject.put("type", str1);
        if (this.time == null)
          break label80;
        str2 = this.time;
        label41: localJSONObject.put("time", str2);
        if (this.value == null)
          break label87;
      }
      label80: label87: for (String str3 = this.value; ; str3 = "")
      {
        localJSONObject.put("value", str3);
        return localJSONObject;
        str1 = "";
        break;
        str2 = "";
        break label41;
      }
    }

    public String toString()
    {
      new JSONObject();
      try
      {
        JSONObject localJSONObject = toJson();
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        if ("{\"type\":\"" + null != this.type)
          return this.type;
        if ("\", \"time\":\"" + null != this.time)
          return this.time;
        if ("\", \"value\":\"" + null != this.value)
          return this.value;
      }
      return "\"}";
    }
  }

  public static class UserMedia
  {
    public String audio = "";
    public String origin = "";
    public int pid = 0;
    public int rid = 0;
    public String video = "";
  }

  public static final class WebRTCInternalsRepresentable
  {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    public static final String kAddStreamType = "addStream";
    public static final String kCreateAnswerType = "createAnswer";
    public static final String kCreateOfferType = "createOffer";
    public static final String kFieldTime = "time";
    public static final String kFieldType = "type";
    public static final String kFieldValue = "value";
    public static final String kIceConnectionStateChangeType = "iceConnectionStateChange";
    public static final String kIceGatheringStateChangeType = "iceGatheringStateChange";
    public static final String kIceRestart = "iceRestart";
    public static final String kOfferToReceiveAudio = "offerToReceiveAudio";
    public static final String kOfferToReceiveVideo = "offerToReceiveVideo";
    public static final String kOnAddStreamType = "OnAddStream";
    public static final String kOnFailurePostfix = "OnFailure";
    public static final String kOnIceCandidateType = "onIceCandidate";
    public static final String kOnRemoveStreamType = "OnRemoveStream";
    public static final String kOnRenegotiationNeededType = "onRenegotiationNeeded";
    public static final String kOnSuccessPostfix = "OnSuccess";
    public static final String kRemoveStreamType = "removeStream";
    public static final String kRtcConfigurationType = "rtcConfiguration";
    public static final String kSetLocalDescriptionType = "setLocalDescription";
    public static final String kSetRemoteDescriptionType = "setRemoteDescription";
    public static final String kSignalingStateChangeType = "signalingStateChange";
    public static final String kVoiceActivityDetection = "voiceActivityDetection";

    private static boolean checkMediaConstraints(String paramString, List<MediaConstraints.KeyValuePair> paramList)
    {
      MediaConstraints.KeyValuePair localKeyValuePair = new MediaConstraints.KeyValuePair(paramString, "true");
      return (paramList != null) && (paramList.contains(localKeyValuePair));
    }

    public static class AnswerOptions extends PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable
    {
      public final boolean voiceActivityDetection;

      AnswerOptions(MediaConstraints paramMediaConstraints)
      {
      }

      AnswerOptions(boolean paramBoolean)
      {
        this.voiceActivityDetection = paramBoolean;
      }

      public PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.kType getType()
      {
        return PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.kType.kRtcUpdateLogEvent;
      }

      public String toJSONString(JSONObject paramJSONObject)
        throws JSONException
      {
        paramJSONObject.put("voiceActivityDetection", this.voiceActivityDetection);
        return paramJSONObject.toString();
      }
    }

    public static class CreateAnswer extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {

      @Nonnull
      public final PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.AnswerOptions options;

      @Nonnull
      public final String postfix;

      CreateAnswer(PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.AnswerOptions paramAnswerOptions)
      {
        this(paramAnswerOptions, "");
      }

      CreateAnswer(PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.AnswerOptions paramAnswerOptions, String paramString)
      {
        this.options = paramAnswerOptions;
        this.postfix = paramString;
      }

      public String eventType()
      {
        return "createAnswer" + this.postfix;
      }

      public String getValue()
      {
        try
        {
          String str = "options: " + this.options.toJSONString(new JSONObject());
          return str;
        }
        catch (Exception localException)
        {
        }
        return "options: {}";
      }
    }

    public static class CreateOffer extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {

      @Nonnull
      public final PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.OfferOptions options;

      @Nonnull
      public final String postfix;

      CreateOffer(PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.OfferOptions paramOfferOptions)
      {
        this(paramOfferOptions, "");
      }

      CreateOffer(PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.OfferOptions paramOfferOptions, String paramString)
      {
        this.options = paramOfferOptions;
        this.postfix = paramString;
      }

      public String eventType()
      {
        return "createOffer" + this.postfix;
      }

      public String getValue()
      {
        try
        {
          String str = "options: " + this.options.toJSONString(new JSONObject());
          return str;
        }
        catch (Exception localException)
        {
        }
        return "options: {}";
      }
    }

    public static class DataChannel extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {
      public String id;
      public boolean reliable;

      public String eventType()
      {
        return "";
      }

      public String getValue()
      {
        return null;
      }
    }

    public static class IceCandidate extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {
      public final String candidate;
      public final String sdpMLineIndex;
      public final String sdpMid;

      public IceCandidate(String paramString1, String paramString2, String paramString3)
      {
        this.sdpMid = paramString1;
        this.sdpMLineIndex = paramString2;
        this.candidate = paramString3;
      }

      public String eventType()
      {
        return "onIceCandidate";
      }

      public String getValue()
      {
        try
        {
          String str = "sdpMid: " + this.sdpMid + ", sdpMLineIndex: " + this.sdpMLineIndex + ", candidate: " + this.candidate;
          return str;
        }
        catch (Exception localException)
        {
        }
        return "";
      }
    }

    public static class IceConnectionStateChange extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {
      public final String state;

      IceConnectionStateChange(String paramString)
      {
        this.state = paramString;
      }

      public String eventType()
      {
        return "iceConnectionStateChange";
      }

      public String getValue()
      {
        try
        {
          String str = this.state;
          return str;
        }
        catch (Exception localException)
        {
        }
        return "";
      }
    }

    public static class IceGatheringStateChange extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {
      public final String state;

      IceGatheringStateChange(String paramString)
      {
        this.state = paramString;
      }

      public String eventType()
      {
        return "iceGatheringStateChange";
      }

      public String getValue()
      {
        try
        {
          String str = this.state;
          return str;
        }
        catch (Exception localException)
        {
        }
        return "";
      }
    }

    public static class MediaStream extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {
      public final String type;
      public final String value;

      public MediaStream(String paramString1, String paramString2)
      {
        this.type = paramString1;
        this.value = paramString2;
      }

      public String eventType()
      {
        return this.type;
      }

      public String getValue()
      {
        try
        {
          String str = this.value;
          return str;
        }
        catch (Exception localException)
        {
        }
        return "";
      }
    }

    public static class OfferOptions extends PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable
    {
      public final boolean iceRestart;
      public final boolean offerToReceiveAudio;
      public final boolean offerToReceiveVideo;
      public final boolean voiceActivityDetection;

      OfferOptions(MediaConstraints paramMediaConstraints)
      {
      }

      OfferOptions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
      {
        this.offerToReceiveAudio = paramBoolean1;
        this.offerToReceiveVideo = paramBoolean2;
        this.voiceActivityDetection = paramBoolean3;
        this.iceRestart = paramBoolean4;
      }

      public PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.kType getType()
      {
        return PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.kType.kRtcUpdateLogEvent;
      }

      public String toJSONString(JSONObject paramJSONObject)
        throws JSONException
      {
        paramJSONObject.put("offerToReceiveVideo", this.offerToReceiveVideo);
        paramJSONObject.put("offerToReceiveAudio", this.offerToReceiveAudio);
        paramJSONObject.put("voiceActivityDetection", this.voiceActivityDetection);
        paramJSONObject.put("iceRestart", this.iceRestart);
        return paramJSONObject.toString();
      }
    }

    public static class OnRenegotiationNeeded extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {
      public String eventType()
      {
        return "onRenegotiationNeeded";
      }

      public String getValue()
      {
        return "";
      }
    }

    public static class RtcConfiguration extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {
      public String bundlePolicy;
      public int iceCandidatePoolSize;
      public List<String> iceServers;
      public String iceTransportPolicy;
      public String rtcpMuxPolicy;
      public String sdpSemantics;

      public String eventType()
      {
        return "rtcConfiguration";
      }

      public String getValue()
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("sdpSemantics", this.sdpSemantics);
          localJSONObject.put("iceTransportPolicy", this.iceTransportPolicy);
          localJSONObject.put("rtcpMuxPolicy", this.rtcpMuxPolicy);
          localJSONObject.put("iceCandidatePoolSize", this.iceCandidatePoolSize);
          localJSONObject.put("iceServers", this.iceServers);
          localJSONObject.put("bundlePolicy", this.bundlePolicy);
          String str = localJSONObject.toString();
          return str;
        }
        catch (Exception localException)
        {
        }
        return "";
      }
    }

    public static abstract class RtcUpdateLogEntry extends PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable
    {
      public final Date event_date = new Date();

      public abstract String eventType();

      public Date getDate()
      {
        return this.event_date;
      }

      public PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.kType getType()
      {
        return PeerConnectionTrackerReportBuilder.JSONAPI.JSONSerializable.kType.kRtcUpdateLogEvent;
      }

      public abstract String getValue();

      public String toJSONString(JSONObject paramJSONObject)
        throws JSONException
      {
        paramJSONObject.put("type", eventType());
        paramJSONObject.put("time", PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.dateFormat.format(getDate()));
        paramJSONObject.put("value", getValue());
        return paramJSONObject.toString();
      }

      public PeerConnectionTrackerReportBuilder.UpdateRecord toUpdateRecord()
      {
        return new PeerConnectionTrackerReportBuilder.UpdateRecord(getDate(), eventType(), getValue());
      }
    }

    public static class SessionDescription extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {

      @Nonnull
      public final String desc_type;

      @Nonnull
      public final String postfix;

      @Nonnull
      public final String sdp;

      @Nonnull
      public final String type;

      SessionDescription(String paramString1, String paramString2, String paramString3)
      {
        this(paramString1, paramString2, paramString3, "");
      }

      SessionDescription(String paramString1, String paramString2, String paramString3, String paramString4)
      {
        this.type = paramString1;
        this.desc_type = paramString2.toLowerCase();
        this.sdp = paramString3;
        this.postfix = paramString4;
      }

      public String eventType()
      {
        return this.type + this.postfix;
      }

      public String getValue()
      {
        try
        {
          String str = "type: " + this.desc_type.toLowerCase() + ", sdp: " + this.sdp;
          return str;
        }
        catch (Exception localException)
        {
        }
        return "";
      }
    }

    public static class SignalingStateChange extends PeerConnectionTrackerReportBuilder.WebRTCInternalsRepresentable.RtcUpdateLogEntry
    {
      public final String state;

      SignalingStateChange(String paramString)
      {
        this.state = paramString;
      }

      public String eventType()
      {
        return "signalingStateChange";
      }

      public String getValue()
      {
        try
        {
          String str = this.state;
          return str;
        }
        catch (Exception localException)
        {
        }
        return "";
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PeerConnectionTrackerReportBuilder
 * JD-Core Version:    0.6.2
 */