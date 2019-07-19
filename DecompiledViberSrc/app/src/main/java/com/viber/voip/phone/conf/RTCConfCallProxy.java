package com.viber.voip.phone.conf;

import android.os.Handler;
import android.os.Looper;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.BasicRTCCall.Completion;
import com.viber.voip.phone.BasicRTCCall.DataChannelCallback;
import com.viber.voip.phone.BasicRTCCall.SdpExtendedCallback;
import org.webrtc.DataChannel.Init;
import org.webrtc.PeerConnection.Observer;

public final class RTCConfCallProxy
  implements RTCConfCall
{
  private static e L = ViberEnv.getLogger();
  private final Handler handler;
  private final RTCConfCall impl;

  public RTCConfCallProxy(RTCConfCall paramRTCConfCall, Handler paramHandler)
  {
    this.impl = paramRTCConfCall;
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

  public void addPcObserver(PeerConnection.Observer paramObserver)
  {
    this.impl.addPcObserver(paramObserver);
  }

  public void applySdpAnswer(final String paramString1, final String paramString2, final BasicRTCCall.Completion paramCompletion)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.applySdpAnswer(paramString1, paramString2, paramCompletion);
      }
    });
  }

  public void applySdpOffer(final String paramString, final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback, final boolean paramBoolean)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.applySdpOffer(paramString, paramSdpExtendedCallback, paramBoolean);
      }
    });
  }

  public void createDataChannel(final String paramString, final DataChannel.Init paramInit, final BasicRTCCall.DataChannelCallback paramDataChannelCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.createDataChannel(paramString, paramInit, paramDataChannelCallback);
      }
    });
  }

  public void deinitCall()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.deinitCall();
      }
    });
  }

  public void generateOffer(final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.generateOffer(paramSdpExtendedCallback);
      }
    });
  }

  public void localHoldWithCompletion(final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.localHoldWithCompletion(paramSdpExtendedCallback);
      }
    });
  }

  public void localUnholdWithCompletion(final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.localUnholdWithCompletion(paramSdpExtendedCallback);
      }
    });
  }

  public void mute()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.mute();
      }
    });
  }

  public void startGatherStats()
  {
    this.impl.startGatherStats();
  }

  public void startOutgoingCall(final BasicRTCCall.SdpExtendedCallback paramSdpExtendedCallback)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.startOutgoingCall(paramSdpExtendedCallback);
      }
    });
  }

  public void unmute()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        RTCConfCallProxy.this.impl.unmute();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.RTCConfCallProxy
 * JD-Core Version:    0.6.2
 */