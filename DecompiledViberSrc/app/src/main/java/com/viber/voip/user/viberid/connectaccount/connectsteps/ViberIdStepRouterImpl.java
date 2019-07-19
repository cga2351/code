package com.viber.voip.user.viberid.connectaccount.connectsteps;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

class ViberIdStepRouterImpl
  implements ViberIdStepRouters.ViberIdStepRouter
{
  private static final Logger L = ViberEnv.getLogger();
  private final ViberIdStepRouters.ViberIdBaseStepRouter mRouterDelegate;
  private final ViberIdStepViewController mViberIdStepViewController;

  public ViberIdStepRouterImpl(ViberIdStepRouters.ViberIdBaseStepRouter paramViberIdBaseStepRouter, ViberIdStepViewController paramViberIdStepViewController)
  {
    this.mRouterDelegate = paramViberIdBaseStepRouter;
    this.mViberIdStepViewController = paramViberIdStepViewController;
  }

  public void closeViberIdConnect()
  {
    this.mRouterDelegate.closeViberIdConnect();
  }

  public void openEditInfo()
  {
    this.mRouterDelegate.openEditInfo();
  }

  public void showEmailStep(String paramString)
  {
    ViberIdStepViewController localViberIdStepViewController = this.mViberIdStepViewController;
    ViberIdConnectStep localViberIdConnectStep = ViberIdConnectStep.ENTER_EMAIL;
    if (paramString == null);
    for (Bundle localBundle = null; ; localBundle = ViberIdConnectStep.createParamsForEmailStep(paramString))
    {
      localViberIdStepViewController.switchStep(localViberIdConnectStep, localBundle);
      return;
    }
  }

  public void showEnterPasswordStep(String paramString, boolean paramBoolean)
  {
    showEnterPasswordStep(paramString, paramBoolean, null);
  }

  public void showEnterPasswordStep(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mViberIdStepViewController.switchStep(ViberIdConnectStep.ENTER_PASSWORD, ViberIdConnectStep.createParamsForPasswordStep(paramString1, paramBoolean, paramString2));
  }

  public void showSetPasswordStep(String paramString, boolean paramBoolean)
  {
    showSetPasswordStep(paramString, paramBoolean, null);
  }

  public void showSetPasswordStep(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mViberIdStepViewController.switchStep(ViberIdConnectStep.SET_PASSWORD, ViberIdConnectStep.createParamsForPasswordStep(paramString1, paramBoolean, paramString2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouterImpl
 * JD-Core Version:    0.6.2
 */