package com.viber.jni.dialer;

import com.viber.jni.CallStatistics;
import com.viber.jni.ConferenceMembers;

public abstract interface DialerController
{
  public abstract void answerCreated(String paramString);

  public abstract int getPhoneState();

  public abstract void handleAnswer(boolean paramBoolean);

  public abstract void handleCallMissed(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, boolean paramBoolean);

  public abstract void handleCallReceived(long paramLong1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, String paramString4, String paramString5, String paramString6, ConferenceMembers paramConferenceMembers);

  public abstract void handleCallStarted();

  public abstract void handleClose();

  public abstract void handleDecline();

  public abstract void handleDial(String paramString, boolean paramBoolean);

  public abstract void handleDialViberOut(String paramString);

  public abstract void handleDialogReply(int paramInt, String paramString);

  public abstract long handleGetCallToken();

  public abstract void handleHangup();

  public abstract void handleHangupReply(boolean paramBoolean, long paramLong, int paramInt);

  public abstract void handleLocalHold();

  public abstract void handleLocalUnhold();

  public abstract void handleMute();

  public abstract void handleRedial(String paramString);

  public abstract void handleReportStatistics(CallStatistics paramCallStatistics);

  public abstract void handleSwitchToGSM(String paramString);

  public abstract void handleSwitchedToConference(long paramLong);

  public abstract void handleTransfer(boolean paramBoolean);

  public abstract void handleUnmute();

  public abstract boolean isVideoSupported();

  public abstract void setCaptureDeviceName(String paramString);

  public abstract void setEnableVideo(boolean paramBoolean);

  public abstract void setupVoiceQuality(int paramInt);

  public abstract int startRecvVideo();

  public abstract int startSendVideo();

  public abstract int stopRecvVideo();

  public abstract int stopSendVideo();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerController
 * JD-Core Version:    0.6.2
 */