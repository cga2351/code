package com.viber.jni.connection;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class ConnectionListener extends ControllerListener<ConnectionDelegate>
  implements ConnectionDelegate
{
  public void onConnect()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(ConnectionDelegate paramAnonymousConnectionDelegate)
      {
        paramAnonymousConnectionDelegate.onConnect();
      }
    });
  }

  public void onConnectionStateChange(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(ConnectionDelegate paramAnonymousConnectionDelegate)
      {
        paramAnonymousConnectionDelegate.onConnectionStateChange(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.connection.ConnectionListener
 * JD-Core Version:    0.6.2
 */