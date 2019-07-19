package com.viber.voip.user.viberid.connectaccount.connectsteps;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.ae;

public abstract class StepViewHolderBase<V extends StepView, Router extends ViberIdStepRouters.ViberIdBaseStepRouter, P extends ViberIdStepPresenter<V, Router>>
  implements View.OnClickListener, StepView, StepViewHolder
{
  private final Logger L = ViberEnv.getLogger(getClass());
  protected final ViberFragmentActivity mActivity;
  protected View mBottomDivider;
  private Button mContinueButton;
  protected ViewGroup mParentView;

  public StepViewHolderBase(ViberFragmentActivity paramViberFragmentActivity)
  {
    this.mActivity = paramViberFragmentActivity;
  }

  public void attach(ViewGroup paramViewGroup, View paramView, Parcelable paramParcelable)
  {
    this.mParentView = paramViewGroup;
    this.mContinueButton = ((Button)paramView);
    this.mContinueButton.setText(getContinueButtonText());
    this.mContinueButton.setOnClickListener(this);
    this.mBottomDivider = paramViewGroup.findViewById(R.id.bottom_divider);
    getPresenter().attach(this, paramParcelable);
  }

  public void detach()
  {
    getPresenter().detach();
    if (this.mContinueButton != null)
    {
      this.mContinueButton.setOnClickListener(null);
      this.mContinueButton.setEnabled(true);
      this.mContinueButton = null;
    }
    if (this.mParentView != null)
      this.mParentView = null;
  }

  protected abstract String getContinueButtonText();

  protected abstract P getPresenter();

  public Parcelable getSavedState()
  {
    return getPresenter().getSavedState();
  }

  public void handleFocusOutClick()
  {
    getPresenter().handleFocusOutClick();
  }

  public void handleOutsideClick()
  {
  }

  public void hideProgress()
  {
    this.mContinueButton.setEnabled(true);
  }

  public boolean onBackPressed()
  {
    return false;
  }

  public void onClick(View paramView)
  {
    if (this.mContinueButton == paramView)
      getPresenter().onContinueButtonClick();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
  }

  public void onDialogShow(m paramm)
  {
  }

  public void setArguments(Bundle paramBundle)
  {
    String str = paramBundle.getString(ViberIdConnectStep.EMAIL_EXTRA);
    getPresenter().setEmail(str);
  }

  public void setContinueButtonState(boolean paramBoolean)
  {
    this.mContinueButton.setEnabled(paramBoolean);
  }

  public void showNoConnectionError()
  {
    ad.a().a(this.mActivity);
  }

  public void showProgress()
  {
    this.mContinueButton.setEnabled(false);
  }

  public void showRegistrationGeneralError()
  {
    ae.g().a(this.mActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.StepViewHolderBase
 * JD-Core Version:    0.6.2
 */