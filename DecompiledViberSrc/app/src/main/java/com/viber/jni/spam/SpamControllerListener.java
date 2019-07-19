package com.viber.jni.spam;

import com.viber.common.b.b;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.voip.settings.d.r;

public class SpamControllerListener extends ControllerListener<SpamControllerDelegate>
  implements SpamControllerDelegate
{
  public void onEnableSHICReport(final boolean paramBoolean)
  {
    d.r.j.a(paramBoolean);
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SpamControllerDelegate paramAnonymousSpamControllerDelegate)
      {
        paramAnonymousSpamControllerDelegate.onEnableSHICReport(paramBoolean);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.spam.SpamControllerListener
 * JD-Core Version:    0.6.2
 */