package com.viber.voip.shareviber.invitescreen.b;

import android.os.Handler;
import android.os.HandlerThread;

public class l
{
  public Handler a()
  {
    HandlerThread localHandlerThread = new HandlerThread("SuggestedContactsThread");
    localHandlerThread.setPriority(1);
    localHandlerThread.start();
    return new Handler(localHandlerThread.getLooper());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.l
 * JD-Core Version:    0.6.2
 */