package com.viber.voip.phone.call;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.Arrays;
import java.util.Observable;

public class InCallState extends Observable
  implements Cloneable
{
  private static final Logger L = ViberEnv.getLogger();
  public boolean canReceiveVideo = true;
  public boolean canSendVideo = true;
  private boolean mCallEnded = false;
  private int mCallQuality = 0;
  private CallStats mCallStats = new CallStats();
  private long mCreatedTime = System.currentTimeMillis();
  private int mDisconnectStatus = 0;
  private int mEndReason = 0;
  private long mEndTimeMillis = -1L;
  private boolean mIsBlockedCaller = false;
  private boolean mIsBlockedDestination = false;
  private volatile boolean mIsConferenceSupported;
  private boolean mIsDataInterrupted = false;
  private boolean mIsFailed = false;
  private boolean mIsHeadphonesEnabled = false;
  private boolean mIsHoldEnabled = false;
  private boolean mIsHoldInitiator = false;
  private boolean mIsLocalVideoStarted = false;
  private boolean mIsMuteEnabled = false;
  private boolean mIsPeerOnHold = false;
  private boolean mIsPeerRinging = false;
  private boolean mIsRemoteVideoStarted = false;
  private boolean mIsSpeakerEnabled = false;
  private boolean mIsTransferFailed = false;
  private boolean mIsTransferring = false;
  private boolean mIsUserReaction;
  private int mPeerCid = 0;
  private int mSecureState = 0;
  private byte[] mSharedSecret = null;
  private String mSharedSecretString = null;
  private int mState = 0;
  private long mToken = 0L;
  private int mTransferFailedReason;
  private long mTransferToken;

  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    return null;
  }

  public int getCallQuality()
  {
    return this.mCallQuality;
  }

  public CallStats getCallStats()
  {
    return this.mCallStats;
  }

  public long getCallToken()
  {
    return this.mToken;
  }

  public long getCreatedTime()
  {
    return this.mCreatedTime;
  }

  public int getDisconnectStatus()
  {
    return this.mDisconnectStatus;
  }

  public int getEndReason()
  {
    return this.mEndReason;
  }

  public long getEndTime()
  {
    return this.mEndTimeMillis;
  }

  public long getLifeTime()
  {
    return System.currentTimeMillis() - this.mCreatedTime;
  }

  public int getPeerCid()
  {
    return this.mPeerCid;
  }

  public int getSecureState()
  {
    return this.mSecureState;
  }

  public byte[] getSharedSecret()
  {
    return this.mSharedSecret;
  }

  public String getSharedSecretString()
  {
    return this.mSharedSecretString;
  }

  public int getState()
  {
    return this.mState;
  }

  public int getTransferFailedReason()
  {
    return this.mTransferFailedReason;
  }

  public long getTransferToken()
  {
    return this.mTransferToken;
  }

  public boolean isCallEncrypted()
  {
    return (0x1 & this.mSecureState) > 0;
  }

  public boolean isCallEnded()
  {
    return this.mCallEnded;
  }

  public boolean isCallerBlocked()
  {
    return this.mIsBlockedCaller;
  }

  public boolean isConferenceSupported()
  {
    return this.mIsConferenceSupported;
  }

  public boolean isDataInterrupted()
  {
    return this.mIsDataInterrupted;
  }

  public boolean isDestinationBlocked()
  {
    return this.mIsBlockedDestination;
  }

  public boolean isEndCallReasonFailed()
  {
    return (this.mIsFailed) || ((this.mEndReason != 3) && (this.mEndReason != 11) && (this.mEndReason != 10) && (this.mEndReason != 9));
  }

  @Deprecated
  public boolean isFailed()
  {
    return this.mIsFailed;
  }

  public boolean isHeadphonesEnabled()
  {
    return this.mIsHeadphonesEnabled;
  }

  public boolean isHoldEnabled()
  {
    return this.mIsHoldEnabled;
  }

  public boolean isHoldInitiator()
  {
    return this.mIsHoldInitiator;
  }

  public boolean isLocalVideoStarted()
  {
    return this.mIsLocalVideoStarted;
  }

  public boolean isMuteEnabled()
  {
    return this.mIsMuteEnabled;
  }

  public boolean isOnGSMInterruption()
  {
    return this.mState == 2;
  }

  public boolean isPeerOnHold()
  {
    return this.mIsPeerOnHold;
  }

  public boolean isPeerRinging()
  {
    return this.mIsPeerRinging;
  }

  public boolean isRemoteVideoStarted()
  {
    return this.mIsRemoteVideoStarted;
  }

  public boolean isSpeakerEnabled()
  {
    return this.mIsSpeakerEnabled;
  }

  public boolean isTransferFailed()
  {
    return this.mIsTransferFailed;
  }

  public boolean isTransferring()
  {
    return this.mIsTransferring;
  }

  public boolean isTrustPeerChanged()
  {
    return (0x2 & this.mSecureState) > 0;
  }

  public boolean isTrustedNumber()
  {
    return (0x4 & this.mSecureState) > 0;
  }

  public boolean isUserReaction()
  {
    return this.mIsUserReaction;
  }

  public void notifyObservers()
  {
    notifyObservers(clone());
  }

  public InCallState onVideoCompatibility(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.canSendVideo != paramBoolean1)
    {
      this.canSendVideo = paramBoolean1;
      setChanged();
    }
    if (this.canReceiveVideo != paramBoolean2)
    {
      this.canReceiveVideo = paramBoolean2;
      setChanged();
    }
    return this;
  }

  public InCallState setCallQuality(int paramInt)
  {
    if (this.mCallQuality != paramInt)
    {
      this.mCallQuality = paramInt;
      setChanged();
    }
    return this;
  }

  public InCallState setCallToken(long paramLong)
  {
    if (this.mToken != paramLong)
    {
      this.mToken = paramLong;
      setChanged();
    }
    return this;
  }

  public InCallState setCallerBlocked(boolean paramBoolean)
  {
    if (paramBoolean != this.mIsBlockedCaller)
    {
      this.mIsBlockedCaller = paramBoolean;
      setChanged();
    }
    return this;
  }

  public void setConferenceSupported(boolean paramBoolean)
  {
    if (this.mIsConferenceSupported != paramBoolean)
    {
      this.mIsConferenceSupported = paramBoolean;
      setChanged();
    }
  }

  public InCallState setDataInterrupted(boolean paramBoolean)
  {
    if (paramBoolean != this.mIsDataInterrupted)
    {
      this.mIsDataInterrupted = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setDestinationBlocked(boolean paramBoolean)
  {
    if (paramBoolean != this.mIsBlockedDestination)
    {
      this.mIsBlockedDestination = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setDisconnectStatus(int paramInt)
  {
    if (this.mDisconnectStatus != paramInt)
    {
      this.mDisconnectStatus = paramInt;
      setChanged();
    }
    return this;
  }

  public InCallState setEndReason(int paramInt)
  {
    if (this.mEndReason != paramInt)
    {
      this.mEndReason = paramInt;
      setChanged();
    }
    return this;
  }

  public InCallState setEndTime(long paramLong)
  {
    if (this.mEndTimeMillis != paramLong)
    {
      this.mEndTimeMillis = paramLong;
      this.mCallEnded = true;
      setChanged();
    }
    return this;
  }

  public InCallState setHeadphonesEnabled(boolean paramBoolean)
  {
    if (this.mIsHeadphonesEnabled != paramBoolean)
    {
      this.mIsHeadphonesEnabled = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setHoldEnabled(boolean paramBoolean)
  {
    if (this.mIsHoldEnabled != paramBoolean)
    {
      this.mIsHoldEnabled = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setIsHoldInitiator(boolean paramBoolean)
  {
    if (this.mIsHoldInitiator != paramBoolean)
    {
      this.mIsHoldInitiator = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setLocalVideoStarted(boolean paramBoolean)
  {
    if (paramBoolean != this.mIsLocalVideoStarted)
    {
      this.mIsLocalVideoStarted = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setMuteEnabled(boolean paramBoolean)
  {
    if (this.mIsMuteEnabled != paramBoolean)
    {
      this.mIsMuteEnabled = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setPeerOnHold(boolean paramBoolean)
  {
    if (this.mIsPeerOnHold != paramBoolean)
    {
      this.mIsPeerOnHold = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setPeerRinging(boolean paramBoolean)
  {
    if (this.mIsPeerRinging != paramBoolean)
    {
      this.mIsPeerRinging = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setRemoteVideoStarted(boolean paramBoolean)
  {
    if (paramBoolean != this.mIsRemoteVideoStarted)
    {
      this.mIsRemoteVideoStarted = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setSecureState(int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2)
  {
    if (this.mSecureState != paramInt2)
    {
      this.mSecureState = paramInt2;
      setChanged();
    }
    if (this.mPeerCid != paramInt1)
    {
      this.mPeerCid = paramInt1;
      setChanged();
    }
    if ((this.mSharedSecret != paramArrayOfByte) && (!Arrays.equals(this.mSharedSecret, paramArrayOfByte)))
    {
      this.mSharedSecret = paramArrayOfByte;
      this.mSharedSecretString = paramString;
      setChanged();
    }
    return this;
  }

  public InCallState setSpeakerEnabled(boolean paramBoolean)
  {
    if (this.mIsSpeakerEnabled != paramBoolean)
    {
      this.mIsSpeakerEnabled = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setState(int paramInt)
  {
    if (this.mState != paramInt)
    {
      this.mState = paramInt;
      if (10 == paramInt)
        this.mIsFailed = true;
      setChanged();
    }
    return this;
  }

  public InCallState setTransferFailed(boolean paramBoolean)
  {
    if (this.mIsTransferFailed != paramBoolean)
    {
      this.mIsTransferFailed = paramBoolean;
      setChanged();
    }
    return this;
  }

  public InCallState setTransferFailedReason(int paramInt)
  {
    if (this.mTransferFailedReason != paramInt)
    {
      this.mTransferFailedReason = paramInt;
      setChanged();
    }
    return this;
  }

  public InCallState setTransferToken(long paramLong)
  {
    if (this.mTransferToken != paramLong)
    {
      this.mTransferToken = paramLong;
      setChanged();
    }
    return this;
  }

  public InCallState setTransferring(boolean paramBoolean)
  {
    if (this.mIsTransferring != paramBoolean)
    {
      this.mIsTransferring = paramBoolean;
      if (paramBoolean)
      {
        this.mIsTransferFailed = false;
        this.mTransferToken = 0L;
        this.mTransferFailedReason = 0;
      }
      setChanged();
    }
    return this;
  }

  public void setUserReaction(boolean paramBoolean)
  {
    this.mIsUserReaction = paramBoolean;
  }

  public String toString()
  {
    return "InCallState{createTime=" + this.mCreatedTime + '\n' + ", mEndTimeMillis=" + this.mEndTimeMillis + '\n' + ", mEndReason=" + this.mEndReason + '\n' + ", mDisconnectStatus=" + this.mDisconnectStatus + '\n' + ", mIsMuteEnabled=" + this.mIsMuteEnabled + '\n' + ", mIsHoldEnabled=" + this.mIsHoldEnabled + '\n' + ", mIsSpeakerEnabled=" + this.mIsSpeakerEnabled + '\n' + ", mIsDataInterrupted=" + this.mIsDataInterrupted + '\n' + ", mIsBlockedCaller=" + this.mIsBlockedCaller + '\n' + ", mIsBlockedDestination=" + this.mIsBlockedDestination + '\n' + ", mCallQuality=" + this.mCallQuality + '\n' + ", mState=" + this.mState + '\n' + ", mSecureState=" + this.mSecureState + '\n' + ", secureNumber=" + (0x4 & this.mSecureState) + '\n' + ", secureEncripted=" + (0x1 & this.mSecureState) + '\n' + ", secureBreach=" + (0x2 & this.mSecureState) + '\n' + ", mIsRemoteVideoStarted=" + this.mIsRemoteVideoStarted + '\n' + ", mIsLocalVideoStarted=" + this.mIsLocalVideoStarted + '\n' + ", canSendVideo=" + this.canSendVideo + '\n' + ", canReceiveVideo=" + this.canReceiveVideo + '\n' + ", mIsFailed=" + this.mIsFailed + '\n' + ", mIsConferenceSupported=" + this.mIsConferenceSupported + '\n' + ", reference = " + super.toString() + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.InCallState
 * JD-Core Version:    0.6.2
 */