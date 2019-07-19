package com.viber.jni.desktop;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class HasDesktopListener extends ControllerListener<HasDesktopDelegate>
  implements HasDesktopDelegate
{
  public void onHasDesktop(final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(HasDesktopDelegate paramAnonymousHasDesktopDelegate)
      {
        paramAnonymousHasDesktopDelegate.onHasDesktop(paramBoolean);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.desktop.HasDesktopListener
 * JD-Core Version:    0.6.2
 */