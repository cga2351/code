package com.viber.voip.phone;

import android.os.Handler;
import android.os.HandlerThread;

public class PeerConnectionTrackerFactory
{
  private static Handler mHandler;

  private static Handler getHandler()
  {
    if (mHandler == null);
    try
    {
      if (mHandler == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("PeerConnectionTracker");
        localHandlerThread.setDaemon(true);
        localHandlerThread.start();
        mHandler = new Handler(localHandlerThread.getLooper());
      }
      return mHandler;
    }
    finally
    {
    }
  }

  public static IPeerConnectionTracker newPeerConnectionTracker(boolean paramBoolean)
  {
    if (paramBoolean)
      return new PeerConnectionNullTrackerImpl();
    return new PeerConnectionTrackerProxy(getHandler(), new PeerConnectionTrackerImpl());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PeerConnectionTrackerFactory
 * JD-Core Version:    0.6.2
 */