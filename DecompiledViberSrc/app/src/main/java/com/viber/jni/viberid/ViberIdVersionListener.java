package com.viber.jni.viberid;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class ViberIdVersionListener extends ControllerListener<ViberIdVersionDelegate>
  implements ViberIdVersionDelegate
{
  public void onUpdateViberIdVersion(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(ViberIdVersionDelegate paramAnonymousViberIdVersionDelegate)
      {
        paramAnonymousViberIdVersionDelegate.onUpdateViberIdVersion(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.viberid.ViberIdVersionListener
 * JD-Core Version:    0.6.2
 */