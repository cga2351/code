package com.viber.jni.viberout;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class ViberOutBalanceListener extends ControllerListener<ViberOutBalanceDelegate>
  implements ViberOutBalanceDelegate
{
  public boolean onViberOutBalanceChange(final long paramLong)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(ViberOutBalanceDelegate paramAnonymousViberOutBalanceDelegate)
      {
        paramAnonymousViberOutBalanceDelegate.onViberOutBalanceChange(paramLong);
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.viberout.ViberOutBalanceListener
 * JD-Core Version:    0.6.2
 */