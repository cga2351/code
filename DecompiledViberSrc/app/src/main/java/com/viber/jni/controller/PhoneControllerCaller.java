package com.viber.jni.controller;

import com.viber.jni.PhoneControllerReadyListener;
import com.viber.jni.connection.ConnectionController;

public class PhoneControllerCaller<P>
  implements PhoneControllerReadyListener
{
  private static final int METHOD_CALL_COUNT = 1;
  private ConnectionController mConnection;
  private P mController;
  private boolean mReady = false;

  public PhoneControllerCaller(P paramP, ConnectionController paramConnectionController)
  {
    this.mController = paramP;
    this.mConnection = paramConnectionController;
  }

  protected boolean multyMethodCall(MultiCallerCallback<P> paramMultiCallerCallback)
  {
    for (int i = 0; ; i++)
    {
      if ((i >= 1) || (!this.mReady));
      do
      {
        return false;
        if (paramMultiCallerCallback.call(this.mController))
          return true;
      }
      while (!this.mConnection.isConnected());
    }
  }

  public void ready(PhoneController paramPhoneController)
  {
    this.mReady = true;
  }

  public static abstract interface MultiCallerCallback<T>
  {
    public abstract boolean call(T paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.controller.PhoneControllerCaller
 * JD-Core Version:    0.6.2
 */