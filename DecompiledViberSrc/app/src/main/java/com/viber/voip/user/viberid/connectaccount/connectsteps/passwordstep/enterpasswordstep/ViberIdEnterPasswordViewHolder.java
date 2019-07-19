package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.enterpasswordstep;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.dialogs.ae;
import com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordPresenter;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdConnectStep;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdPasswordStepRouter;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.PasswordContentAnimatorProvider;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.StepsAnimator.ContentAnimatorProvider;
import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordViewHolder;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;

public class ViberIdEnterPasswordViewHolder extends ViberIdPasswordViewHolder<ViberIdEnterPasswordStepView, ViberIdEnterPasswordStepPresenter>
  implements ViberIdEnterPasswordStepView
{
  private final Logger L = ViberEnv.getLogger(getClass());
  private final ForgotPasswordPresenter mForgotPasswordPresenter;
  private TextView mForgotPasswordText;
  private final ViberIdEnterPasswordStepPresenter mPresenter;
  private final String mWrongPasswordErrorMessage;

  public ViberIdEnterPasswordViewHolder(ViberFragmentActivity paramViberFragmentActivity, ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdPasswordStepRouter paramViberIdPasswordStepRouter, cj paramcj)
  {
    super(paramViberFragmentActivity);
    this.mPresenter = new ViberIdEnterPasswordStepPresenter(paramViberIdController, paramViberIdPasswordStepRouter, paramcj);
    this.mForgotPasswordPresenter = new ForgotPasswordPresenter(paramViberIdController, paramcj);
    this.mWrongPasswordErrorMessage = this.mActivity.getString(R.string.viber_id_enter_password_text_error);
  }

  public void attach(ViewGroup paramViewGroup, View paramView, Parcelable paramParcelable)
  {
    this.mForgotPasswordText = ((TextView)paramViewGroup.findViewById(R.id.forgot_password_text));
    this.mForgotPasswordText.setOnClickListener(this);
    dj.a(this.mForgotPasswordText, true);
    super.attach(paramViewGroup, paramView, paramParcelable);
    this.mPasswordWrapper.getEditText().setHint(R.string.viber_id_enter_password_hint);
    this.mForgotPasswordPresenter.attachView(this);
  }

  public void detach()
  {
    super.detach();
    this.mForgotPasswordText = null;
    this.mForgotPasswordPresenter.detachView();
  }

  protected ViberIdEnterPasswordStepPresenter getPresenter()
  {
    return this.mPresenter;
  }

  public StepsAnimator.ContentAnimatorProvider getViewContentAnimator()
  {
    ViewGroup localViewGroup = this.mParentView;
    View localView1 = this.mBottomDivider;
    View localView2 = this.mCheckboxContent;
    View[] arrayOfView = new View[3];
    arrayOfView[0] = this.mPasswordTitle;
    arrayOfView[1] = this.mPasswordWrapper.getView();
    arrayOfView[2] = this.mForgotPasswordText;
    return new PasswordContentAnimatorProvider(localViewGroup, localView1, localView2, arrayOfView);
  }

  public void handleOutsideClick()
  {
    super.handleOutsideClick();
    if (this.mPasswordWrapper != null)
      this.mPresenter.validatePasswordOnFocusLost();
  }

  public void hideWrongPasswordError()
  {
    this.mPasswordWrapper.setError(null);
  }

  public void initViewState(String paramString, boolean paramBoolean)
  {
    initBaseViewState(paramString, paramBoolean);
  }

  public void onClick(View paramView)
  {
    if (R.id.forgot_password_text == paramView.getId())
    {
      this.mForgotPasswordPresenter.onForgotPassword();
      return;
    }
    super.onClick(paramView);
  }

  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
    String str = paramBundle.getString(ViberIdConnectStep.EMAIL_EXTRA);
    this.mForgotPasswordPresenter.setEmail(str);
  }

  public void showGenericError()
  {
    showRegistrationGeneralError();
  }

  public void showTooManyRequestsError()
  {
    ae.h().a(this.mActivity);
  }

  public void showWrongPasswordError()
  {
    this.mPasswordWrapper.setError(this.mWrongPasswordErrorMessage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.enterpasswordstep.ViberIdEnterPasswordViewHolder
 * JD-Core Version:    0.6.2
 */