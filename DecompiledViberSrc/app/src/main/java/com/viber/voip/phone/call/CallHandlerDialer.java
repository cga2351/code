package com.viber.voip.phone.call;

import android.os.Handler;
import android.os.SystemClock;
import com.viber.jni.CallStatistics;
import com.viber.jni.ConferenceMembers;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.av.e;
import com.viber.voip.phone.call.filters.ViberOutCallFilter;

public class CallHandlerDialer
  implements DialerController, DialerPendingController
{
  private static final long PENDING_DIAL_TIMEOUT_MILIS = 5000L;
  private CallHandler mCallHandler;
  private DialerController mDialerController;
  private Engine mEngine;
  private ViberOutCallFilter mVODialFilter;

  public CallHandlerDialer(Engine paramEngine, DialerController paramDialerController, CallHandler paramCallHandler)
  {
    this.mEngine = paramEngine;
    this.mDialerController = paramDialerController;
    this.mCallHandler = paramCallHandler;
    this.mVODialFilter = new ViberOutCallFilter(this.mCallHandler);
  }

  public void answerCreated(String paramString)
  {
    this.mDialerController.answerCreated(paramString);
  }

  public int getPhoneState()
  {
    return this.mDialerController.getPhoneState();
  }

  public void handleAnswer(boolean paramBoolean)
  {
    this.mDialerController.handleAnswer(paramBoolean);
  }

  public void handleCallMissed(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, boolean paramBoolean)
  {
    this.mDialerController.handleCallMissed(paramLong, paramString1, paramInt1, paramInt2, paramString2, paramInt3, paramBoolean);
  }

  public void handleCallReceived(long paramLong1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, String paramString4, String paramString5, String paramString6, ConferenceMembers paramConferenceMembers)
  {
    this.mDialerController.handleCallReceived(paramLong1, paramString1, paramString2, paramBoolean1, paramBoolean2, paramString3, paramLong2, paramInt1, paramInt2, paramInt3, paramLong3, paramString4, paramString5, paramString6, paramConferenceMembers);
  }

  public void handleCallStarted()
  {
    this.mDialerController.handleCallStarted();
  }

  public void handleClose()
  {
    this.mDialerController.handleClose();
  }

  public void handleDecline()
  {
    this.mDialerController.handleDecline();
  }

  public void handleDial(String paramString, boolean paramBoolean)
  {
    this.mCallHandler.handleDial(paramString, paramBoolean);
  }

  public void handleDialViberOut(String paramString)
  {
    if (!this.mVODialFilter.handleDialViberOut(paramString))
      this.mCallHandler.handleDialViberOut(paramString);
  }

  public void handleDialogReply(int paramInt, String paramString)
  {
    this.mDialerController.handleDialogReply(paramInt, paramString);
  }

  public long handleGetCallToken()
  {
    return this.mDialerController.handleGetCallToken();
  }

  public void handleHangup()
  {
    this.mCallHandler.handleHangup();
  }

  public void handleHangupReply(boolean paramBoolean, long paramLong, int paramInt)
  {
    this.mDialerController.handleHangupReply(paramBoolean, paramLong, paramInt);
  }

  public void handleLocalHold()
  {
    this.mCallHandler.handleLocalHold();
  }

  public void handleLocalUnhold()
  {
    this.mCallHandler.handleLocalUnhold();
  }

  public void handleMute()
  {
    this.mCallHandler.handleMute();
  }

  public void handlePendingDial(final String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    if (this.mEngine.getConnectionController().isConnected())
    {
      this.mCallHandler.handleDial(paramString, paramBoolean1, paramBoolean2);
      return;
    }
    final Handler localHandler = av.e.f.a();
    final Object localObject = new Object();
    final ConnectionListener local1 = new ConnectionListener()
    {
      public void onConnect()
      {
        localHandler.removeCallbacksAndMessages(localObject);
        CallHandlerDialer.this.mEngine.getDelegatesManager().getConnectionListener().removeDelegate(this);
        CallHandlerDialer.this.mCallHandler.handleDial(paramString, paramBoolean1, paramBoolean2);
      }
    };
    localHandler.postAtTime(new Runnable()
    {
      public void run()
      {
        CallHandlerDialer.this.mEngine.getDelegatesManager().getConnectionListener().removeDelegate(local1);
        CallHandlerDialer.this.mCallHandler.handleDial(paramString, paramBoolean1, paramBoolean2);
      }
    }
    , localObject, 5000L + SystemClock.uptimeMillis());
    this.mEngine.getDelegatesManager().getConnectionListener().registerDelegate(local1, localHandler);
  }

  public void handleRedial(String paramString)
  {
    this.mDialerController.handleRedial(paramString);
  }

  public void handleReportStatistics(CallStatistics paramCallStatistics)
  {
  }

  public void handleSwitchToGSM(String paramString)
  {
    this.mDialerController.handleSwitchToGSM(paramString);
  }

  public void handleSwitchedToConference(long paramLong)
  {
  }

  public void handleTransfer(boolean paramBoolean)
  {
    this.mCallHandler.handleTransfer(paramBoolean);
  }

  public void handleUnmute()
  {
    this.mCallHandler.handleUnmute();
  }

  public boolean isVideoSupported()
  {
    return this.mDialerController.isVideoSupported();
  }

  public void setCaptureDeviceName(String paramString)
  {
    this.mDialerController.setCaptureDeviceName(paramString);
  }

  public void setEnableVideo(boolean paramBoolean)
  {
    this.mDialerController.setEnableVideo(paramBoolean);
  }

  public void setupVoiceQuality(int paramInt)
  {
    this.mDialerController.setupVoiceQuality(paramInt);
  }

  public int startRecvVideo()
  {
    return 0;
  }

  public int startSendVideo()
  {
    return 0;
  }

  public int stopRecvVideo()
  {
    return 0;
  }

  public int stopSendVideo()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.CallHandlerDialer
 * JD-Core Version:    0.6.2
 */