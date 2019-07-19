package com.viber.voip.model;

import android.os.Parcelable;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;

public abstract interface Call extends Parcelable, d
{
  public abstract long getAggregatedHash();

  public abstract String getCanonizedNumber();

  public abstract ConferenceInfo getConferenceInfo();

  public abstract long getDate();

  public abstract long getDuration();

  public abstract long getNativeCallId();

  public abstract String getNumber();

  public abstract long getToken();

  public abstract int getType();

  public abstract int getViberCallType();

  public abstract boolean hasConferenceInfo();

  public abstract boolean isAnswerredOnAnotherDevice();

  public abstract boolean isIncoming();

  public abstract boolean isLooked();

  public abstract boolean isMissed();

  public abstract boolean isOutgoing();

  public abstract boolean isPrivateNumber();

  public abstract boolean isTransferredIn();

  public abstract boolean isTypeViberGroup();

  public abstract boolean isTypeViberOut();

  public abstract boolean isTypeViberVideo();

  public abstract boolean isTypeVln();

  public abstract boolean isViberCall();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.Call
 * JD-Core Version:    0.6.2
 */