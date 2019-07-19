package com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep;

import android.accounts.Account;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ae;
import com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordPresenter;
import com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordView;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper.TextChangeListener;
import com.viber.voip.user.viberid.connectaccount.ViewWithProgressWrapper;
import com.viber.voip.user.viberid.connectaccount.connectsteps.StepViewHolderBase;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdConnectStep;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdEmailStepRouter;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.EmailContentAnimatorProvider;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.StepsAnimator.ContentAnimatorProvider;
import com.viber.voip.util.ax;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import com.viber.voip.util.n;

public class ViberIdEmailViewHolder extends StepViewHolderBase<ViberIdEmailStepView, ViberIdStepRouters.ViberIdEmailStepRouter, ViberIdEmailStepPresenter>
  implements View.OnFocusChangeListener, ForgotPasswordView, RetypePasswordDialogView, ViberIdEmailStepView
{
  private static final Logger L = ViberEnv.getLogger();
  private View mDialogConnectButton;
  private View mDialogDisconnectAccountButton;
  private ViewWithProgressWrapper mDialogDisconnectAccountButtonWithProgressWrapper;
  private TextView mDialogForgotPasswordView;
  private ViewWithErrorStatusWrapper mDialogPasswordViewWrapper;
  private final String mEmailErrorMessage;
  private View mEmailTitle;
  private ViewWithErrorStatusWrapper mEmailViewWrapper;
  private final ForgotPasswordPresenter mForgotPasswordPresenter;
  private final ViberIdEmailStepPresenter mPresenter;
  private final RetypePasswordDialogPresenter mRetypePasswordDialogPresenter;
  private final String mWrongPasswordErrorMessage;

  public ViberIdEmailViewHolder(ViberFragmentActivity paramViberFragmentActivity, ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdEmailStepRouter paramViberIdEmailStepRouter, cj paramcj)
  {
    super(paramViberFragmentActivity);
    this.mEmailErrorMessage = paramViberFragmentActivity.getString(R.string.viber_id_email_text_error);
    this.mWrongPasswordErrorMessage = this.mActivity.getString(R.string.viber_id_enter_password_text_error);
    this.mPresenter = new ViberIdEmailStepPresenter(paramViberIdController, paramViberIdEmailStepRouter, paramcj);
    this.mForgotPasswordPresenter = new ForgotPasswordPresenter(paramViberIdController, paramcj);
    this.mRetypePasswordDialogPresenter = new RetypePasswordDialogPresenter(paramViberIdController, paramViberIdEmailStepRouter, new EmailStepDisconnectAccountRouter(this), paramcj);
  }

  private String getEmailFromGoogleAccount()
  {
    Account[] arrayOfAccount = ax.c(this.mActivity);
    if (n.a(arrayOfAccount))
      return null;
    return arrayOfAccount[0].name;
  }

  private void setEmailTextAndSelection(String paramString)
  {
    this.mEmailViewWrapper.getEditText().setText(paramString);
    this.mEmailViewWrapper.getEditText().setSelection(this.mEmailViewWrapper.getEditText().getText().length());
  }

  public void attach(ViewGroup paramViewGroup, View paramView, Parcelable paramParcelable)
  {
    Parcelable localParcelable2;
    Parcelable localParcelable1;
    if ((paramParcelable instanceof EmailStepStateContainer))
    {
      EmailStepStateContainer localEmailStepStateContainer = (EmailStepStateContainer)paramParcelable;
      Parcelable localParcelable3 = localEmailStepStateContainer.emailState;
      Parcelable localParcelable4 = localEmailStepStateContainer.retypePasswordState;
      localParcelable2 = localParcelable3;
      localParcelable1 = localParcelable4;
    }
    while (true)
    {
      this.mEmailTitle = paramViewGroup.findViewById(R.id.email_title);
      this.mEmailViewWrapper = new ViewWithErrorStatusWrapper((TextInputLayout)paramViewGroup.findViewById(R.id.email_view_layout), false);
      this.mEmailViewWrapper.getEditText().setOnFocusChangeListener(this);
      this.mEmailViewWrapper.getEditText().setHint(R.string.viber_id_email_text_hint);
      this.mEmailViewWrapper.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
      {
        public void onTextChanged(String paramAnonymousString)
        {
          ViberIdEmailViewHolder.this.mPresenter.onEmailTextChanged(paramAnonymousString);
        }
      });
      this.mForgotPasswordPresenter.attachView(this);
      this.mRetypePasswordDialogPresenter.attach(this, localParcelable1);
      super.attach(paramViewGroup, paramView, localParcelable2);
      return;
      localParcelable1 = null;
      localParcelable2 = null;
    }
  }

  public void closeRetypePasswordDialog()
  {
    m localm = z.c(this.mActivity.getSupportFragmentManager(), DialogCode.D4006);
    if (localm != null)
    {
      localm.dismiss();
      this.mRetypePasswordDialogPresenter.onRetypePasswordDialogClosed();
    }
  }

  public void detach()
  {
    super.detach();
    this.mEmailViewWrapper.getEditText().setOnFocusChangeListener(null);
    this.mEmailViewWrapper.setTextChangeListener(null);
    this.mEmailViewWrapper.setError(null);
    if (this.mDialogPasswordViewWrapper != null)
    {
      this.mDialogPasswordViewWrapper.setTextChangeListener(null);
      this.mDialogPasswordViewWrapper = null;
      this.mDialogForgotPasswordView.setOnClickListener(null);
      this.mDialogForgotPasswordView = null;
    }
    this.mEmailTitle = null;
    this.mForgotPasswordPresenter.detachView();
    this.mRetypePasswordDialogPresenter.detach();
  }

  protected String getContinueButtonText()
  {
    return this.mActivity.getString(R.string.btn_continue);
  }

  protected ViberIdEmailStepPresenter getPresenter()
  {
    return this.mPresenter;
  }

  public Parcelable getSavedState()
  {
    return new EmailStepStateContainer(super.getSavedState(), this.mRetypePasswordDialogPresenter.getSavedState());
  }

  public StepsAnimator.ContentAnimatorProvider getViewContentAnimator()
  {
    ViewGroup localViewGroup = this.mParentView;
    View localView = this.mBottomDivider;
    View[] arrayOfView = new View[2];
    arrayOfView[0] = this.mEmailTitle;
    arrayOfView[1] = this.mEmailViewWrapper.getView();
    return new EmailContentAnimatorProvider(localViewGroup, localView, arrayOfView);
  }

  public void handleOutsideClick()
  {
    super.handleOutsideClick();
    this.mPresenter.onEmailFieldFocusChanged(false);
  }

  public void hideDisconnectAccountProgress()
  {
    this.mDialogDisconnectAccountButtonWithProgressWrapper.hideLoadding();
    this.mDialogPasswordViewWrapper.setEnabled(true);
    this.mRetypePasswordDialogPresenter.updateDialogButtonsState();
  }

  public void hideEmailNotValidMessage()
  {
    this.mEmailViewWrapper.setError(null);
  }

  public void hidePasswordDialogProgress()
  {
    if (this.mDialogPasswordViewWrapper != null)
    {
      this.mDialogPasswordViewWrapper.hideLoadding();
      setDialogButtonsState(true, true, true);
    }
  }

  public void hideProgress()
  {
    super.hideProgress();
    this.mEmailViewWrapper.hideLoadding();
  }

  public void hideWrongPasswordError()
  {
    if (this.mDialogPasswordViewWrapper != null)
      this.mDialogPasswordViewWrapper.setError(null);
  }

  public void initEmail()
  {
    setEmailTextAndSelection(getEmailFromGoogleAccount());
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D4006)) && (this.mDialogPasswordViewWrapper != null))
    {
      if (-2 == paramInt)
        this.mRetypePasswordDialogPresenter.disconnectAccount();
      do
      {
        return;
        if (-1 == paramInt)
        {
          this.mRetypePasswordDialogPresenter.onRetypePasswordDialogConnect(this.mDialogPasswordViewWrapper.getEditText().getText().toString());
          return;
        }
      }
      while (-1000 != paramInt);
      this.mRetypePasswordDialogPresenter.onRetypePasswordDialogCanceled();
      return;
    }
    super.onDialogAction(paramm, paramInt);
  }

  public void onDialogShow(m paramm)
  {
    if (paramm.a(DialogCode.D4006))
    {
      this.mDialogPasswordViewWrapper = new ViewWithErrorStatusWrapper((TextInputLayout)paramm.getDialog().findViewById(R.id.password_layout), false);
      this.mDialogConnectButton = paramm.getDialog().findViewById(R.id.connect_email_btn);
      this.mDialogDisconnectAccountButton = paramm.getDialog().findViewById(R.id.disconnect_account_btn);
      this.mDialogDisconnectAccountButtonWithProgressWrapper = new ViewWithProgressWrapper((TextView)this.mDialogDisconnectAccountButton, true);
      this.mDialogPasswordViewWrapper.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
      {
        public void onTextChanged(String paramAnonymousString)
        {
          ViberIdEmailViewHolder.this.mRetypePasswordDialogPresenter.onDialogPasswordTextChanged(paramAnonymousString);
        }
      });
      this.mDialogForgotPasswordView = ((TextView)paramm.getDialog().findViewById(R.id.forgot_password_text));
      dj.a(this.mDialogForgotPasswordView, true);
      this.mDialogForgotPasswordView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ViberIdEmailViewHolder.this.mForgotPasswordPresenter.onForgotPassword();
        }
      });
      this.mRetypePasswordDialogPresenter.onRetypePasswordDialogShowed();
      return;
    }
    super.onDialogShow(paramm);
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.mEmailViewWrapper.getEditText() == paramView)
      this.mPresenter.onEmailFieldFocusChanged(paramBoolean);
  }

  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
    this.mRetypePasswordDialogPresenter.setEmail(paramBundle.getString(ViberIdConnectStep.EMAIL_EXTRA));
  }

  public void setDialogButtonsState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.mDialogConnectButton != null) && (this.mDialogDisconnectAccountButton != null) && (this.mDialogForgotPasswordView != null))
    {
      this.mDialogConnectButton.setEnabled(paramBoolean1);
      this.mDialogDisconnectAccountButton.setEnabled(paramBoolean2);
      this.mDialogForgotPasswordView.setEnabled(paramBoolean3);
    }
  }

  public void setDialogPassword(String paramString)
  {
    if (this.mDialogPasswordViewWrapper != null)
    {
      this.mDialogPasswordViewWrapper.getEditText().setText(paramString);
      this.mDialogPasswordViewWrapper.getEditText().setSelection(paramString.length());
    }
  }

  public void setEmail(String paramString)
  {
    setEmailTextAndSelection(paramString);
  }

  public void setRetypeDialogCancelableState(boolean paramBoolean)
  {
    m localm = z.c(this.mActivity.getSupportFragmentManager(), DialogCode.D4006);
    if (localm != null)
      localm.setCancelable(paramBoolean);
  }

  public void showDisconnectAccountError()
  {
    ae.g().a(this.mActivity);
  }

  public void showDisconnectAccountProgress()
  {
    this.mDialogDisconnectAccountButtonWithProgressWrapper.showLoading();
    this.mDialogPasswordViewWrapper.setEnabled(false);
    setDialogButtonsState(false, false, false);
  }

  public void showEmailAttemptsExceededError()
  {
    ae.h().a(this.mActivity);
  }

  public void showEmailNotValidMessage()
  {
    this.mEmailViewWrapper.setError(this.mEmailErrorMessage);
  }

  public void showEmailStatusErrorDialog()
  {
    ae.g().a(this.mActivity);
  }

  public void showEmailWasSentDialog()
  {
    ae.a().a(this.mActivity).a(this.mActivity);
  }

  public void showGenericError()
  {
    ae.g().a(this.mActivity);
  }

  public void showPasswordDialogProgress()
  {
    if (this.mDialogPasswordViewWrapper != null)
    {
      this.mDialogPasswordViewWrapper.showLoading();
      setDialogButtonsState(false, false, false);
    }
  }

  public void showProgress()
  {
    super.showProgress();
    this.mEmailViewWrapper.showLoading();
  }

  public void showRetypePasswordAttemptsExceededError()
  {
    ae.f().a(this.mActivity);
  }

  public void showRetypePasswordDialog(String paramString)
  {
    ae.a(paramString).a(this.mActivity).a(this.mActivity);
  }

  public void showRetypePasswordGeneralError()
  {
    showRegistrationGeneralError();
  }

  public void showTooManyRequestsError()
  {
    ae.h().a(this.mActivity);
  }

  public void showWrongPasswordError()
  {
    if (this.mDialogPasswordViewWrapper != null)
      this.mDialogPasswordViewWrapper.setError(this.mWrongPasswordErrorMessage);
  }

  static class EmailStepStateContainer
    implements Parcelable
  {
    public static final Parcelable.Creator<EmailStepStateContainer> CREATOR = new Parcelable.Creator()
    {
      public ViberIdEmailViewHolder.EmailStepStateContainer createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ViberIdEmailViewHolder.EmailStepStateContainer(paramAnonymousParcel);
      }

      public ViberIdEmailViewHolder.EmailStepStateContainer[] newArray(int paramAnonymousInt)
      {
        return new ViberIdEmailViewHolder.EmailStepStateContainer[paramAnonymousInt];
      }
    };
    private Parcelable emailState;
    private Parcelable retypePasswordState;

    EmailStepStateContainer(Parcel paramParcel)
    {
      try
      {
        this.emailState = paramParcel.readParcelable(Class.forName(paramParcel.readString()).getClassLoader());
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          while (true)
          {
            this.retypePasswordState = paramParcel.readParcelable(Class.forName(paramParcel.readString()).getClassLoader());
            return;
            localClassNotFoundException1 = localClassNotFoundException1;
            this.emailState = null;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          this.retypePasswordState = null;
        }
      }
    }

    EmailStepStateContainer(Parcelable paramParcelable1, Parcelable paramParcelable2)
    {
      this.emailState = paramParcelable1;
      this.retypePasswordState = paramParcelable2;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.emailState.getClass().getName());
      paramParcel.writeParcelable(this.emailState, paramInt);
      paramParcel.writeString(this.retypePasswordState.getClass().getName());
      paramParcel.writeParcelable(this.retypePasswordState, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep.ViberIdEmailViewHolder
 * JD-Core Version:    0.6.2
 */