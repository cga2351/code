package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class MustSecureListener extends ControllerListener<MustSecureDelegate>
  implements MustSecureDelegate
{
  public void onMustSecure()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MustSecureDelegate paramAnonymousMustSecureDelegate)
      {
        paramAnonymousMustSecureDelegate.onMustSecure();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.MustSecureListener
 * JD-Core Version:    0.6.2
 */