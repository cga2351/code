package com.viber.voip.phone.call;

import android.text.TextUtils;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CallInfo
{
  private int ENDING_STATES = 3840;
  private int mAdProviderType = 0;
  private int mAdsType = 0;
  private long mAssociatedConversationId = -1L;
  private int mCallType;
  private final CallerInfo mCallerInfo;
  private String mConferenceId;
  private Map<String, Object> mCustomProperies = Collections.synchronizedMap(new HashMap());
  private InCallState mInCallState;
  private boolean mIsEndCallStarted;
  private boolean mIsFromSecretConversation;
  private boolean mIsOutgoingVideoCall;
  private boolean mIsTransfer = false;
  private boolean mIsViberOut;
  private boolean mShowAddToCallAnimation;
  private String mToNumber;
  private final CallType mType;
  private VideoState mVideoState = VideoState.OFF;

  public CallInfo(CallType paramCallType, CallerInfo paramCallerInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, long paramLong, String paramString2)
  {
    if (paramCallType == null)
      throw new IllegalArgumentException("The mType argument is invalid");
    if (paramCallerInfo == null)
      throw new IllegalArgumentException("The mCallerInfo argument is invalid");
    this.mType = paramCallType;
    this.mCallerInfo = paramCallerInfo;
    this.mCallType = paramInt;
    this.mIsTransfer = paramBoolean1;
    this.mIsViberOut = paramBoolean2;
    this.mIsFromSecretConversation = paramBoolean4;
    this.mIsOutgoingVideoCall = paramBoolean3;
    this.mConferenceId = paramString1;
    this.mAssociatedConversationId = paramLong;
    this.mToNumber = paramString2;
    this.mInCallState = new InCallState();
  }

  public CallInfo(CallerInfo paramCallerInfo, int paramInt, boolean paramBoolean, String paramString1, long paramLong, String paramString2)
  {
    this(CallType.INCOMING, paramCallerInfo, paramInt, paramBoolean, false, false, false, paramString1, paramLong, paramString2);
  }

  public CallInfo(CallerInfo paramCallerInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, long paramLong)
  {
    this(CallType.OUTGOING, paramCallerInfo, 0, false, paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramLong, null);
  }

  public int getAdProviderType()
  {
    return this.mAdProviderType;
  }

  public int getAdsType()
  {
    return this.mAdsType;
  }

  public long getAssociatedConversationId()
  {
    return this.mAssociatedConversationId;
  }

  public int getCallType()
  {
    return this.mCallType;
  }

  public CallerInfo getCallerInfo()
  {
    return this.mCallerInfo;
  }

  public String getConferenceId()
  {
    return this.mConferenceId;
  }

  public <T> T getCustomProperty(String paramString)
  {
    return this.mCustomProperies.get(paramString);
  }

  public InCallState getInCallState()
  {
    return this.mInCallState;
  }

  public String getToNumber()
  {
    return this.mToNumber;
  }

  public CallType getType()
  {
    return this.mType;
  }

  public VideoState getVideoState()
  {
    return this.mVideoState;
  }

  public boolean hasCustomProperty(String paramString)
  {
    return this.mCustomProperies.containsKey(paramString);
  }

  public boolean isCallAnswering()
  {
    return this.mInCallState.getState() == 7;
  }

  public boolean isCallEnding()
  {
    int i = this.mInCallState.getState();
    return ((this.ENDING_STATES & 1 << i) > 0) || (i == 0);
  }

  public boolean isCallInProgress()
  {
    int i = this.mInCallState.getState();
    return (i == 3) || (i == 2);
  }

  public boolean isCallInRingback()
  {
    return this.mInCallState.getState() == 6;
  }

  public boolean isCalling()
  {
    int i = this.mInCallState.getState();
    return (i != 0) && (i != 10);
  }

  public boolean isConference()
  {
    return !TextUtils.isEmpty(this.mConferenceId);
  }

  public boolean isEndCallStarted()
  {
    return this.mIsEndCallStarted;
  }

  public boolean isFromSecretConversation()
  {
    return this.mIsFromSecretConversation;
  }

  public boolean isIncomingVideoCall()
  {
    return 2 == this.mCallType;
  }

  public boolean isLocalVideoAvailable()
  {
    return this.mInCallState.canSendVideo;
  }

  public boolean isOutgoing()
  {
    int i = this.mInCallState.getState();
    return (i == 4) || (i == 6);
  }

  public boolean isOutgoingVideoCall()
  {
    return this.mIsOutgoingVideoCall;
  }

  public boolean isPureViberCall()
  {
    return (isViberCall()) && (!isViberOut());
  }

  public boolean isPureViberIn()
  {
    return (isViberIn()) && (!isVln());
  }

  public boolean isRemoteVideoAvailable()
  {
    return this.mInCallState.canReceiveVideo;
  }

  public boolean isRinging()
  {
    return this.mInCallState.getState() == 5;
  }

  public boolean isTransfer()
  {
    return this.mIsTransfer;
  }

  public boolean isViberCall()
  {
    return (this.mCallType == 0) || (this.mCallType == 2);
  }

  public boolean isViberCallInProgress()
  {
    return this.mInCallState.getState() == 3;
  }

  public boolean isViberIn()
  {
    return this.mCallType == 1;
  }

  public boolean isViberOut()
  {
    return this.mIsViberOut;
  }

  public boolean isVln()
  {
    return (!TextUtils.isEmpty(this.mToNumber)) && (this.mCallType == 1);
  }

  public void markEndCallAsStarted()
  {
    this.mIsEndCallStarted = true;
  }

  public boolean needShowAd(int paramInt)
  {
    return this.mAdsType == paramInt;
  }

  public boolean needShowAds()
  {
    return this.mAdsType != 0;
  }

  public void putCustomProperty(String paramString, Object paramObject)
  {
    this.mCustomProperies.put(paramString, paramObject);
  }

  public void setAdProviderType(int paramInt)
  {
    this.mAdProviderType = paramInt;
  }

  public void setAdType(int paramInt)
  {
    this.mAdsType = paramInt;
  }

  public void setShowAddToCallAnimation(boolean paramBoolean)
  {
    this.mShowAddToCallAnimation = paramBoolean;
  }

  public void setVideoState(VideoState paramVideoState)
  {
    this.mVideoState = paramVideoState;
  }

  public boolean showAddToCallAnimation()
  {
    return this.mShowAddToCallAnimation;
  }

  public void switchToConference(String[] paramArrayOfString, long paramLong, String paramString, boolean paramBoolean)
  {
    ConferenceInfo localConferenceInfo = new ConferenceInfo();
    localConferenceInfo.setIsSelfInitiated(paramBoolean);
    this.mConferenceId = paramString;
    ConferenceParticipant[] arrayOfConferenceParticipant = new ConferenceParticipant[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      arrayOfConferenceParticipant[i] = new ConferenceParticipant();
      arrayOfConferenceParticipant[i].setMemberId(paramArrayOfString[i]);
    }
    localConferenceInfo.setParticipants(arrayOfConferenceParticipant);
    this.mInCallState.setCallToken(paramLong);
    this.mCallerInfo.setConferenceInfo(localConferenceInfo);
  }

  public String toString()
  {
    return "CallInfo{ENDING_STATES=" + this.ENDING_STATES + ",\n mType=" + this.mType + ",\n mCallerInfo=" + this.mCallerInfo + ",\n mInCallState=" + this.mInCallState + ",\n mCallType=" + this.mCallType + ",\n mIsTransfer=" + this.mIsTransfer + ",\n mIsViberOut=" + this.mIsViberOut + ",\n mIsFromSecretConversation=" + this.mIsFromSecretConversation + ",\n mIsOutgoingVideoCall=" + this.mIsOutgoingVideoCall + ",\n mToNumber=" + this.mToNumber + ",\n mVideoState=" + this.mVideoState + ",\n mAdsType=" + this.mAdsType + ",\n mAdProviderType=" + this.mAdProviderType + ",\n mIsEndCallStarted=" + this.mIsEndCallStarted + ",\n mCustomProperies=" + this.mCustomProperies + ",\n mConferenceId=" + this.mConferenceId + '}';
  }

  public static enum CallType
  {
    static
    {
      CallType[] arrayOfCallType = new CallType[2];
      arrayOfCallType[0] = INCOMING;
      arrayOfCallType[1] = OUTGOING;
    }
  }

  public static enum VideoState
  {
    static
    {
      MIN = new VideoState("MIN", 1);
      MAX = new VideoState("MAX", 2);
      VideoState[] arrayOfVideoState = new VideoState[3];
      arrayOfVideoState[0] = OFF;
      arrayOfVideoState[1] = MIN;
      arrayOfVideoState[2] = MAX;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.CallInfo
 * JD-Core Version:    0.6.2
 */