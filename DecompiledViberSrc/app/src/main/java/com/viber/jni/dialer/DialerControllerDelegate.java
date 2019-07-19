package com.viber.jni.dialer;

import java.util.Map;

public abstract interface DialerControllerDelegate
{
  public static class DialType
  {
    public static final int DIALTYPE_CONFERENCE_ADHOC = 4;
    public static final int DIALTYPE_CONFERENCE_GROUP = 3;
    public static final int DIALTYPE_DEFAULT = 0;
    public static final int DIALTYPE_VIBER_OUT = 1;
    public static final int DIALTYPE_VIBER_OUT_TRIAL = 2;
    public static final int DIALTYPE_VIDEO_CALL = 5;
    public static final int DIALTYPE_VLN_CALL = 6;
  }

  public static abstract interface DialerCallInterruption
  {
    public abstract void onDataInterruption(boolean paramBoolean);
  }

  public static abstract interface DialerCallback
  {
    public abstract void hideCallBack();

    public abstract void showCallBack(int paramInt1, int paramInt2);

    public abstract void showCallBlocked(int paramInt1, int paramInt2);

    public abstract void showDialog(int paramInt, String paramString);

    public abstract void switchToGSM(String paramString);
  }

  public static abstract interface DialerDelegate extends DialerControllerDelegate.DialerCallInterruption, DialerControllerDelegate.DialerCallback, DialerControllerDelegate.DialerEndScreen, DialerControllerDelegate.DialerHoldState, DialerControllerDelegate.DialerIncomingScreen, DialerControllerDelegate.DialerLocalCallState, DialerControllerDelegate.DialerMuteState, DialerControllerDelegate.DialerOutgoingScreen, DialerControllerDelegate.DialerPhoneState, DialerControllerDelegate.DialerRemoteCallState, DialerControllerDelegate.DialerTransferCall, DialerControllerDelegate.DialerVideo
  {
  }

  public static abstract interface DialerEndScreen
  {
    public abstract void hideEndCall();

    public abstract void showEndCall();
  }

  public static abstract interface DialerHoldState
  {
    public abstract void localHold();

    public abstract void localUnhold();

    public abstract void peerHold();

    public abstract void peerUnhold();
  }

  public static abstract interface DialerIncomingScreen
  {
    public abstract void hideReception();

    public abstract void showReception(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap);
  }

  public static abstract interface DialerLocalCallState
  {
    public abstract void onCallEnded(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2);

    public abstract void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt);

    public abstract void onHangup();
  }

  public static abstract interface DialerMuteState
  {
    public abstract void mute();

    public abstract void unmute();
  }

  public static abstract interface DialerOutgoingScreen
  {
    public abstract void hideCall(String paramString, boolean paramBoolean);

    public abstract void showCall(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  }

  public static abstract interface DialerPhoneState
  {
    public abstract void onPhoneStateChanged(int paramInt);
  }

  public static abstract interface DialerRemoteCallState
  {
    public abstract void onPeerBusy();

    public abstract void onPeerRinging();

    public abstract void onStartRingback(String paramString);
  }

  public static abstract interface DialerTransferCall
  {
    public abstract void onTransferFailed(int paramInt);

    public abstract void onTransferReplyOK(long paramLong);
  }

  public static abstract interface DialerVideo
  {
    public abstract int onPeerVideoEnded(int paramInt);

    public abstract int onPeerVideoStarted();

    public abstract void onSelfVideoEnded(int paramInt);

    public abstract void onSelfVideoStarted();

    public abstract void onVideoCallEnded();

    public abstract void onVideoCompatibility(boolean paramBoolean1, boolean paramBoolean2);
  }

  public static class ECallbackType
  {
    public static final int CALLBACK_TYPE_BUSY = 2;
    public static final int CALLBACK_TYPE_DISCONNECTED = 3;
    public static final int CALLBACK_TYPE_FAILED = 1;
    public static final int CALLBACK_TYPE_INVALID_NUMBER = 4;
    public static final int CALLBACK_TYPE_NO_ANSWER = 7;
    public static final int CALLBACK_TYPE_NO_CREDIT = 6;
    public static final int CALLBACK_TYPE_UNAVAILABLE = 8;
    public static final int CALLBACK_TYPE_UNKNOWN = 0;
    public static final int CALLBACK_TYPE_VIBER_OUT_NOT_SUPPORTED = 5;
  }

  public static class EHangupReason
  {
    public static final int HANGUP_ANSWERED_ON_ANOTHER_DEVICE = 10;
    public static final int HANGUP_BUSY = 1;
    public static final int HANGUP_CALL_CANCELLED = 11;
    public static final int HANGUP_CALL_ENDED = 3;
    public static final int HANGUP_FAILED = 2;
    public static final int HANGUP_INVALID_NUMBER = 16;
    public static final int HANGUP_NETWORK_ERROR = 4;
    public static final int HANGUP_NO_ACCOUNT = 15;
    public static final int HANGUP_NO_CREDIT = 12;
    public static final int HANGUP_SWITCH_TO_GSM = 5;
    public static final int HANGUP_TEXT_ONLY = 7;
    public static final int HANGUP_TIMEOUT = 6;
    public static final int HANGUP_TRANSFERRED_OUT = 9;
    public static final int HANGUP_TRIAL_ENDED = 14;
    public static final int HANGUP_UNKNOWN = 0;
    public static final int HANGUP_UNSUPPORTED = 13;
    public static final int HANGUP_VERSION_MISMATCH = 8;
  }

  public static class EOnTransferFailedReasons
  {
    public static final int BUSY = 2;
    public static final int FAIL = 3;
    public static final int NO_OTHER_CAPABLE_DEVICES = 7;
    public static final int NO_OTHER_DEVICES = 1;
    public static final int OK = 0;
    public static final int OTHER_DEVICE_OFFLINE = 6;
    public static final int PEER_HAS_OLDER_VERSION = 4;
    public static final int TIMEOUT = 5;
  }

  public static class IncomingCallType
  {
    public static final int VIBER_CALL = 0;
    public static final int VIBER_IN = 1;
    public static final int VIBER_VIDEO_CALL = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerControllerDelegate
 * JD-Core Version:    0.6.2
 */