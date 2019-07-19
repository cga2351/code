package com.viber.voip.messages.ui.popup;

import com.viber.voip.messages.controller.ai;
import com.viber.voip.user.UserManager;
import dagger.b;

public final class c
  implements b<PopupMessageActivity>
{
  public static void a(PopupMessageActivity paramPopupMessageActivity, ai paramai)
  {
    paramPopupMessageActivity.c = paramai;
  }

  public static void a(PopupMessageActivity paramPopupMessageActivity, UserManager paramUserManager)
  {
    paramPopupMessageActivity.b = paramUserManager;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.c
 * JD-Core Version:    0.6.2
 */