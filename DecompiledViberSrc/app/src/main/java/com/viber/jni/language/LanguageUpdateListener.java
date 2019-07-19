package com.viber.jni.language;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class LanguageUpdateListener extends ControllerListener<LanguageUpdateDelegate>
  implements LanguageUpdateDelegate
{
  public void onUpdateLanguage(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(LanguageUpdateDelegate paramAnonymousLanguageUpdateDelegate)
      {
        paramAnonymousLanguageUpdateDelegate.onUpdateLanguage(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.language.LanguageUpdateListener
 * JD-Core Version:    0.6.2
 */