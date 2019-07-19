package com.viber.voip.phone;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.viber.common.a.e;
import com.viber.jni.webrtc.IceCandidate;
import com.viber.voip.ViberEnv;
import org.webrtc.SurfaceViewRenderer;

public final class RTCCallProxy
  implements RTCCall
{
  private static e L = ViberEnv.getLogger();
  private final Handler handler;
  private final RTCCall impl;

  public RTCCallProxy(RTCCall paramRTCCall, Handler paramHandler)
  {
    this.impl = paramRTCCall;
    this.handler = paramHandler;
  }

  private void executeOrPostToHandler(Runnable paramRunnable)
  {
    if (Thread.currentThread() != this.handler.getLooper().getThread())
    {
      this.handler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }

  public void addPeerIceCandidate(final IceCandidate paramIceCandidate)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.addPeerIceCandidate(paramIceCandidate);
      }
    });
  }

  public void applyPeerAnswer(final String paramString, final int paramInt, final BasicRTCCall.Completion paramCompletion)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.applyPeerAnswer(paramString, paramInt, paramCompletion);
      }
    });
  }

  public void applyPeerOffer(final String paramString, final int paramInt, final boolean paramBoolean, final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.applyPeerOffer(paramString, paramInt, paramBoolean, paramSdpCallback);
      }
    });
  }

  public void applySdpAnswer(final String paramString1, final String paramString2, final BasicRTCCall.Completion paramCompletion)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.applySdpAnswer(paramString1, paramString2, paramCompletion);
      }
    });
  }

  public void applySdpOffer(final String paramString, final int paramInt, final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.applySdpOffer(paramString, paramInt, paramSdpCallback);
      }
    });
  }

  public void deinitCall()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.deinitCall();
      }
    });
  }

  public void finalizeTransfer(final BasicRTCCall.Completion paramCompletion)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.finalizeTransfer(paramCompletion);
      }
    });
  }

  public int getCameraCount(Context paramContext)
  {
    return this.impl.getCameraCount(paramContext);
  }

  public SurfaceViewRenderer getLocalVideo(Context paramContext)
  {
    return this.impl.getLocalVideo(paramContext);
  }

  public void getOffer(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.getOffer(paramSdpCallback);
      }
    });
  }

  public SurfaceViewRenderer getRemoteVideo(Context paramContext)
  {
    return this.impl.getRemoteVideo(paramContext);
  }

  public void localHoldWithCompletion(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.localHoldWithCompletion(paramSdpCallback);
      }
    });
  }

  public void localUnholdWithCompletion(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.localUnholdWithCompletion(paramSdpCallback);
      }
    });
  }

  public void mute()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.mute();
      }
    });
  }

  public void peerHoldWithCompletion(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.peerHoldWithCompletion(paramSdpCallback);
      }
    });
  }

  public void peerUnholdWithCompletion(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.peerUnholdWithCompletion(paramSdpCallback);
      }
    });
  }

  public void sendDtmf(final String paramString, final int paramInt)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.sendDtmf(paramString, paramInt);
      }
    });
  }

  public void startCall(final int paramInt)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.startCall(paramInt);
      }
    });
  }

  public void startOutgoingCall(final boolean paramBoolean1, final boolean paramBoolean2, final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.startOutgoingCall(paramBoolean1, paramBoolean2, paramSdpCallback);
      }
    });
  }

  public void startRecvVideo(final Context paramContext)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.startRecvVideo(paramContext);
      }
    });
  }

  public void startSendVideoWithCompletion(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.startSendVideoWithCompletion(paramSdpCallback);
      }
    });
  }

  public void stopRecvVideo()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.stopRecvVideo();
      }
    });
  }

  public void stopSendVideoWithCompletion(final BasicRTCCall.SdpCallback paramSdpCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.stopSendVideoWithCompletion(paramSdpCallback);
      }
    });
  }

  public void switchCamera()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.switchCamera();
      }
    });
  }

  public void unmute()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCCallProxy.this.impl.unmute();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.RTCCallProxy
 * JD-Core Version:    0.6.2
 */