package com.viber.voip.engagement.d;

import android.os.Handler;
import android.os.HandlerThread;

public class o
{
  public Handler a()
  {
    HandlerThread localHandlerThread = new HandlerThread("EngagementSuggestedContactsThread");
    localHandlerThread.setPriority(1);
    localHandlerThread.start();
    return new Handler(localHandlerThread.getLooper());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.o
 * JD-Core Version:    0.6.2
 */