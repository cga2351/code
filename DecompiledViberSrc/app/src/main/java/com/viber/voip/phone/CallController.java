package com.viber.voip.phone;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerCallInterruption;
import com.viber.jni.dialer.DialerControllerDelegate.DialerCallback;
import com.viber.jni.dialer.DialerControllerDelegate.DialerHoldState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerIncomingScreen;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerMuteState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerOutgoingScreen;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerRemoteCallState;
import com.viber.jni.dialer.DialerControllerDelegate.DialerTransferCall;
import com.viber.jni.dialer.DialerControllerDelegate.DialerVideo;
import com.viber.jni.secure.TrustPeerDelegate.CallsDelegate;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.a.i;
import com.viber.voip.analytics.a.j;
import com.viber.voip.analytics.g;
import com.viber.voip.i.c.q;
import com.viber.voip.i.f;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInfo.CallType;
import com.viber.voip.phone.call.CallStats;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.controller.SecureCallListener;
import com.viber.voip.settings.d.aj;
import com.viber.voip.sound.ISoundService.SpeakerStateListener;
import com.viber.voip.util.cs;
import dagger.a;
import java.util.Map;
import org.webrtc.videoengine.VideoCaptureDeviceInfo;

public class CallController
  implements DialerControllerDelegate.DialerCallInterruption, DialerControllerDelegate.DialerCallback, DialerControllerDelegate.DialerHoldState, DialerControllerDelegate.DialerIncomingScreen, DialerControllerDelegate.DialerLocalCallState, DialerControllerDelegate.DialerMuteState, DialerControllerDelegate.DialerOutgoingScreen, DialerControllerDelegate.DialerPhoneState, DialerControllerDelegate.DialerRemoteCallState, DialerControllerDelegate.DialerTransferCall, DialerControllerDelegate.DialerVideo, TrustPeerDelegate.CallsDelegate, ISoundService.SpeakerStateListener
{
  private static final Logger L = ViberEnv.getLogger();
  private volatile CallInfo mCallInfo;
  private final DialerController mDialerController;
  private volatile CallInfo mLastCallInfo;
  private final a<com.viber.common.permission.c> mPermissionManager;
  private int mPhoneState;
  private SecureCallState mSecureCallState;
  private final Handler mSoundServiceHandler;
  private int videoCaptureDeviceIndex = 0;

  public CallController(DialerController paramDialerController, Handler paramHandler, a<com.viber.common.permission.c> parama)
  {
    this.mDialerController = paramDialerController;
    this.mSoundServiceHandler = paramHandler;
    this.mPermissionManager = parama;
  }

  private CallInfo startCall(CallInfo paramCallInfo)
  {
    this.mCallInfo = null;
    this.mLastCallInfo = null;
    if (this.mSecureCallState != null)
    {
      paramCallInfo.getInCallState().setSecureState(this.mSecureCallState.mPeerCID, this.mSecureCallState.mSharedSecret, this.mSecureCallState.mSharedSecretString, this.mSecureCallState.mState);
      this.mSecureCallState = null;
    }
    paramCallInfo.getInCallState().setState(this.mPhoneState);
    return paramCallInfo;
  }

  public CallInfo getCurrentCall()
  {
    return this.mCallInfo;
  }

  public InCallState getCurrentInCallState()
  {
    if (this.mCallInfo != null)
      return this.mCallInfo.getInCallState();
    return null;
  }

  public CallInfo getLastCallInfo()
  {
    if (this.mCallInfo != null)
      return this.mCallInfo;
    return this.mLastCallInfo;
  }

  public void handleCameraFlip()
  {
    InCallState localInCallState = getCurrentInCallState();
    if ((localInCallState == null) || (!localInCallState.isLocalVideoStarted()));
    VideoCaptureDeviceInfo localVideoCaptureDeviceInfo;
    int i;
    do
    {
      do
      {
        return;
        localVideoCaptureDeviceInfo = VideoCaptureDeviceInfo.getInstance();
      }
      while (localVideoCaptureDeviceInfo == null);
      i = localVideoCaptureDeviceInfo.NumberOfDevices();
    }
    while (1 >= i);
    this.videoCaptureDeviceIndex = VideoCaptureDeviceInfo.getCaptureDeviceIndex(localVideoCaptureDeviceInfo);
    int j = 1 + this.videoCaptureDeviceIndex;
    this.videoCaptureDeviceIndex = j;
    this.videoCaptureDeviceIndex = (j % i);
    this.mDialerController.setCaptureDeviceName(localVideoCaptureDeviceInfo.GetDeviceUniqueName(this.videoCaptureDeviceIndex));
  }

  public void hideCall(String paramString, boolean paramBoolean)
  {
  }

  public void hideCallBack()
  {
  }

  public void hideReception()
  {
  }

  public void localHold()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().setIsHoldInitiator(true).setHoldEnabled(true).notifyObservers();
  }

  public void localUnhold()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    boolean bool = localCallInfo.getInCallState().isPeerOnHold();
    localCallInfo.getInCallState().setHoldEnabled(bool).setIsHoldInitiator(false).notifyObservers();
  }

  public void mute()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().setMuteEnabled(true).notifyObservers();
  }

  public void onCallEnded(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      CallInfo localCallInfo = this.mCallInfo;
      if (localCallInfo == null);
      while (true)
      {
        return;
        this.mCallInfo = null;
        this.mLastCallInfo = localCallInfo;
        localCallInfo.getInCallState().getCallStats().stopCall();
        localCallInfo.getInCallState().setCallToken(paramLong).setEndReason(paramInt1).setEndTime(System.currentTimeMillis()).notifyObservers();
        localCallInfo.getInCallState().deleteObservers();
      }
    }
    finally
    {
    }
  }

  public void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().getCallStats().startCall();
  }

  public void onDataInterruption(boolean paramBoolean)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    if (paramBoolean)
      localCallInfo.getInCallState().getCallStats().startDataInterruption();
    while (true)
    {
      localCallInfo.getInCallState().setDataInterrupted(paramBoolean).notifyObservers();
      return;
      localCallInfo.getInCallState().getCallStats().stopDataInterruption();
    }
  }

  public void onHangup()
  {
  }

  public void onHeadphonesConnected(final boolean paramBoolean)
  {
    final CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    this.mSoundServiceHandler.post(new Runnable()
    {
      public void run()
      {
        localCallInfo.getInCallState().setHeadphonesEnabled(paramBoolean).notifyObservers();
      }
    });
  }

  public void onPeerBusy()
  {
  }

  public void onPeerRinging()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().setPeerRinging(true).notifyObservers();
  }

  public int onPeerVideoEnded(int paramInt)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return 0;
    localCallInfo.getInCallState().getCallStats().stopRemoteVideo();
    localCallInfo.getInCallState().setRemoteVideoStarted(false).notifyObservers();
    return 0;
  }

  public int onPeerVideoStarted()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return 0;
    localCallInfo.getInCallState().getCallStats().startRemoteVideo();
    localCallInfo.getInCallState().setRemoteVideoStarted(true).notifyObservers();
    return 0;
  }

  public void onPhoneStateChanged(int paramInt)
  {
    if (this.mCallInfo != null);
    for (CallInfo localCallInfo = this.mCallInfo; ; localCallInfo = this.mLastCallInfo)
    {
      if (10 != paramInt)
        this.mPhoneState = paramInt;
      if (localCallInfo != null)
        break;
      return;
    }
    localCallInfo.getInCallState().setState(paramInt).notifyObservers();
  }

  public void onSecureCallStateChange(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (localCallInfo != null)
    {
      localCallInfo.getInCallState().setSecureState(paramInt1, paramArrayOfByte, paramString, paramInt2).notifyObservers();
      int i = SecureCallListener.SECURITY_TRUST_STATE_SELECTOR.a(paramInt2);
      if (i >= 0);
      for (PeerTrustState.PeerTrustEnum localPeerTrustEnum = PeerTrustState.PeerTrustEnum.values()[i]; ; localPeerTrustEnum = PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED)
      {
        if ((localCallInfo.getCallerInfo().getPeerTrustState() != localPeerTrustEnum) && (PeerTrustState.PeerTrustEnum.SECURE_TRUSTED == localPeerTrustEnum))
        {
          Application localApplication = ViberApplication.getApplication();
          String str = localCallInfo.getCallerInfo().getNameOrPhoneNumber();
          Toast.makeText(localApplication, com.viber.common.d.c.a(localApplication.getResources(), R.string.secure_call_contact_trusted, new Object[] { str }), 0).show();
        }
        localCallInfo.getCallerInfo().setPeerTrustState(localPeerTrustEnum);
        this.mSecureCallState = null;
        return;
      }
    }
    try
    {
      this.mSecureCallState = new SecureCallState();
      SecureCallState.access$402(this.mSecureCallState, paramLong);
      SecureCallState.access$002(this.mSecureCallState, paramInt1);
      SecureCallState.access$102(this.mSecureCallState, paramArrayOfByte);
      SecureCallState.access$202(this.mSecureCallState, paramString);
      SecureCallState.access$302(this.mSecureCallState, paramInt2);
      return;
    }
    finally
    {
    }
  }

  public void onSelfVideoEnded(int paramInt)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().getCallStats().stopLocalVideo();
    localCallInfo.getInCallState().setLocalVideoStarted(false).notifyObservers();
  }

  public void onSelfVideoStarted()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null);
    do
    {
      return;
      localCallInfo.getInCallState().setLocalVideoStarted(true).notifyObservers();
      localCallInfo.getInCallState().getCallStats().startLocalVideo();
    }
    while ((localCallInfo.isOutgoingVideoCall()) || (localCallInfo.getType() != CallInfo.CallType.OUTGOING) || (!j.a(localCallInfo)));
    g.a().a(i.e);
  }

  public void onSpeakerStateChanged(final boolean paramBoolean)
  {
    final CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    this.mSoundServiceHandler.post(new Runnable()
    {
      public void run()
      {
        localCallInfo.getInCallState().setSpeakerEnabled(paramBoolean).notifyObservers();
      }
    });
  }

  public void onSpeakerStatePreChanged(boolean paramBoolean)
  {
  }

  public void onStartRingback(String paramString)
  {
  }

  public void onTransferFailed(int paramInt)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().getCallStats().stopCallTransfer();
    localCallInfo.getInCallState().setTransferring(false).setTransferFailed(true).setTransferFailedReason(paramInt).notifyObservers();
  }

  public void onTransferReplyOK(long paramLong)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null);
    InCallState localInCallState;
    do
    {
      return;
      localInCallState = localCallInfo.getInCallState();
    }
    while ((paramLong == localInCallState.getTransferToken()) || (!localInCallState.isTransferring()));
    localInCallState.setTransferToken(paramLong);
    localInCallState.notifyObservers();
  }

  public void onVideoCallEnded()
  {
  }

  public void onVideoCompatibility(boolean paramBoolean1, boolean paramBoolean2)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    if (paramBoolean1)
      if (!((com.viber.common.permission.c)this.mPermissionManager.get()).a(new String[] { "android.permission.CAMERA" }))
        if (d.aj.b.d())
          break label73;
    label73: for (boolean bool = true; ; bool = false)
    {
      paramBoolean1 = bool;
      localCallInfo.getInCallState().onVideoCompatibility(paramBoolean1, paramBoolean2).notifyObservers();
      return;
    }
  }

  public void peerHold()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().setHoldEnabled(true).setPeerOnHold(true).notifyObservers();
  }

  public void peerUnhold()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    boolean bool = localCallInfo.getInCallState().isHoldInitiator();
    localCallInfo.getInCallState().setHoldEnabled(bool).setPeerOnHold(false).notifyObservers();
  }

  public void showCall(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public void showCallBack(int paramInt1, int paramInt2)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().setDisconnectStatus(paramInt1).notifyObservers();
  }

  public void showCallBlocked(int paramInt1, int paramInt2)
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null);
    while (!c.q.c.e())
      return;
    switch (paramInt1)
    {
    default:
      localCallInfo.getInCallState().setCallerBlocked(false).notifyObservers();
      localCallInfo.getInCallState().setDestinationBlocked(false).notifyObservers();
      return;
    case 1:
      localCallInfo.getInCallState().setCallerBlocked(true).notifyObservers();
      return;
    case 2:
    }
    localCallInfo.getInCallState().setDestinationBlocked(true).notifyObservers();
  }

  public void showDialog(int paramInt, String paramString)
  {
  }

  public void showReception(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
  }

  public CallInfo startInCall(CallerInfo paramCallerInfo, int paramInt, boolean paramBoolean, String paramString1, long paramLong, String paramString2)
  {
    try
    {
      this.mCallInfo = startCall(new CallInfo(paramCallerInfo, paramInt, paramBoolean, paramString1, paramLong, paramString2));
      CallInfo localCallInfo = this.mCallInfo;
      return localCallInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public CallInfo startOutCall(CallerInfo paramCallerInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, long paramLong)
  {
    try
    {
      this.mCallInfo = startCall(new CallInfo(paramCallerInfo, paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramLong));
      CallInfo localCallInfo = this.mCallInfo;
      return localCallInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void switchToGSM(String paramString)
  {
  }

  public void unmute()
  {
    CallInfo localCallInfo = this.mCallInfo;
    if (this.mCallInfo == null)
      return;
    localCallInfo.getInCallState().setMuteEnabled(false).notifyObservers();
  }

  public class SecureCallState
  {
    private long mCt;
    private int mPeerCID;
    private byte[] mSharedSecret;
    private String mSharedSecretString;
    private int mState;

    public SecureCallState()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.CallController
 * JD-Core Version:    0.6.2
 */