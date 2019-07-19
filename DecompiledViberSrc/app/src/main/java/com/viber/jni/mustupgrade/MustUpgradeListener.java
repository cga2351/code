package com.viber.jni.mustupgrade;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class MustUpgradeListener extends ControllerListener<MustUpgradeDelegate>
  implements MustUpgradeDelegate
{
  public void onClientUpgrade(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MustUpgradeDelegate paramAnonymousMustUpgradeDelegate)
      {
        paramAnonymousMustUpgradeDelegate.onClientUpgrade(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.mustupgrade.MustUpgradeListener
 * JD-Core Version:    0.6.2
 */