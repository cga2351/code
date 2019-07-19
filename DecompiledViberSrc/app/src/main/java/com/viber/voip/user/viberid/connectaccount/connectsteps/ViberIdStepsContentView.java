package com.viber.voip.user.viberid.connectaccount.connectsteps;

import android.os.Bundle;
import android.os.Parcelable;

abstract interface ViberIdStepsContentView
{
  public abstract void attachStep(ViberIdConnectStep paramViberIdConnectStep, Parcelable paramParcelable);

  public abstract void handleDialogAction(ViberIdConnectStep paramViberIdConnectStep, DialogContainer paramDialogContainer);

  public abstract void handleDialogShow(ViberIdConnectStep paramViberIdConnectStep, DialogContainer paramDialogContainer);

  public abstract void handleFocusOutClick(ViberIdConnectStep paramViberIdConnectStep);

  public abstract void onBackPressed(ViberIdConnectStep paramViberIdConnectStep);

  public abstract void openLearnMore();

  public abstract void openStep(ViberIdConnectStep paramViberIdConnectStep1, ViberIdConnectStep paramViberIdConnectStep2, Bundle paramBundle);

  public abstract void openTermsAndPrivacy();

  public abstract void saveStepState(ViberIdConnectStep paramViberIdConnectStep, ViberIdStepsContentPresenter.StepStateContainer paramStepStateContainer);

  public abstract void setStepArguments(ViberIdConnectStep paramViberIdConnectStep, Bundle paramBundle);

  public static abstract interface DialogContainer
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepsContentView
 * JD-Core Version:    0.6.2
 */