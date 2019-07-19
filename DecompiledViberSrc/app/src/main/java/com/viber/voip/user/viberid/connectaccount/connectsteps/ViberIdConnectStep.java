package com.viber.voip.user.viberid.connectaccount.connectsteps;

import android.os.Bundle;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep.ViberIdEmailViewHolder;
import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.enterpasswordstep.ViberIdEnterPasswordViewHolder;
import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.setpasswordstep.ViberIdSetPasswordViewHolder;
import com.viber.voip.util.cj;

public enum ViberIdConnectStep
{
  public static String EMAIL_EXTRA = "EMAIL_EXTRA";
  public static String PASSWORD_EXTRA = "PASSWORD_EXTRA";
  public static String PROMOTIONS_AGREED_EXTRA = "PROMOTIONS_AGREED_EXTRA";
  public final ViewHolderCreator creator;

  static
  {
    ENTER_PASSWORD = new ViberIdConnectStep("ENTER_PASSWORD", 2, new ViewHolderCreator()
    {
      public StepViewHolder create(ViberFragmentActivity paramAnonymousViberFragmentActivity, ViberIdController paramAnonymousViberIdController, ViberIdStepRouters.ViberIdStepRouter paramAnonymousViberIdStepRouter, cj paramAnonymouscj)
      {
        return new ViberIdEnterPasswordViewHolder(paramAnonymousViberFragmentActivity, paramAnonymousViberIdController, paramAnonymousViberIdStepRouter, paramAnonymouscj);
      }
    });
    ViberIdConnectStep[] arrayOfViberIdConnectStep = new ViberIdConnectStep[3];
    arrayOfViberIdConnectStep[0] = ENTER_EMAIL;
    arrayOfViberIdConnectStep[1] = SET_PASSWORD;
    arrayOfViberIdConnectStep[2] = ENTER_PASSWORD;
  }

  private ViberIdConnectStep(ViewHolderCreator paramViewHolderCreator)
  {
    this.creator = paramViewHolderCreator;
  }

  public static Bundle createParamsForEmailStep(String paramString)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putString(EMAIL_EXTRA, paramString);
    return localBundle;
  }

  public static Bundle createParamsForPasswordStep(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramString2 == null);
    for (int i = 2; ; i = 3)
    {
      Bundle localBundle = new Bundle(i);
      localBundle.putString(EMAIL_EXTRA, paramString1);
      if (paramString2 != null)
        localBundle.putString(PASSWORD_EXTRA, paramString2);
      localBundle.putBoolean(PROMOTIONS_AGREED_EXTRA, paramBoolean);
      return localBundle;
    }
  }

  static abstract interface ViewHolderCreator
  {
    public abstract StepViewHolder create(ViberFragmentActivity paramViberFragmentActivity, ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdStepRouter paramViberIdStepRouter, cj paramcj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdConnectStep
 * JD-Core Version:    0.6.2
 */