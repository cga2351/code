package com.viber.voip.user.editinfo.changeemail;

import android.app.Application;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.ae;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.editinfo.EditInfoRouter;
import com.viber.voip.user.editinfo.diconnectaccount.DisconnectAccountPresenter;
import com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordPresenter;
import com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordView;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper.TextChangeListener;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;

public class ChangeEmailFragment extends aq
  implements View.OnClickListener, View.OnFocusChangeListener, m.c, ChangeEmailView, ForgotPasswordView
{
  private ChangeEmailPresenter mChangeEmailPresenter;
  private View mDisconnectAccountButton;
  private DisconnectAccountPresenter mDisconnectAccountPresenter;
  private Button mDoneButton;
  private ViewWithErrorStatusWrapper mEmailViewWrapper;
  private ForgotPasswordPresenter mForgotPasswordPresenter;
  private TextView mForgotPwdBtn;
  private ViewWithErrorStatusWrapper mPasswordViewWrapper;
  private EditInfoRouter mRouter;

  public static ChangeEmailFragment createInstance(EditInfoRouter paramEditInfoRouter)
  {
    ChangeEmailFragment localChangeEmailFragment = new ChangeEmailFragment();
    localChangeEmailFragment.setRouter(paramEditInfoRouter);
    return localChangeEmailFragment;
  }

  private void setupActionBar()
  {
    a locala = ((AppCompatActivity)getActivity()).getSupportActionBar();
    if (locala != null)
      locala.b(R.string.viber_id_change_email_title);
  }

  public void hideDisconnectAccountProgress()
  {
    hideProgress();
  }

  public void hideProgress()
  {
    this.mEmailViewWrapper.hideLoadding();
    this.mDisconnectAccountButton.setEnabled(true);
    this.mDoneButton.setEnabled(true);
    this.mForgotPwdBtn.setEnabled(true);
    this.mPasswordViewWrapper.getEditText().setEnabled(true);
  }

  public void hideSoftKeyboard()
  {
    dj.a(getView(), false);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.done_btn)
      this.mChangeEmailPresenter.onFinish();
    do
    {
      return;
      if (i == R.id.disconnect_btn)
      {
        this.mChangeEmailPresenter.onDisconnect();
        return;
      }
      if (i == R.id.forgot_pwd)
      {
        this.mForgotPasswordPresenter.onForgotPassword();
        return;
      }
    }
    while (i != R.id.root_layout);
    this.mChangeEmailPresenter.onFocusOutClick();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    cj localcj = cj.a(localApplication);
    this.mChangeEmailPresenter = new ChangeEmailPresenter(localViberApplication.getUserManager().getUserData(), this.mRouter, localViberApplication.getViberIdController(), localcj);
    this.mForgotPasswordPresenter = new ForgotPasswordPresenter(localViberApplication.getViberIdController(), localcj);
    this.mDisconnectAccountPresenter = new DisconnectAccountPresenter(localViberApplication.getViberIdController(), this.mRouter, localcj);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setupActionBar();
    View localView = paramLayoutInflater.inflate(R.layout.fragment_edit_info_change_email, paramViewGroup, false);
    localView.setOnClickListener(this);
    this.mEmailViewWrapper = new ViewWithErrorStatusWrapper((TextInputLayout)localView.findViewById(R.id.email_view_layout));
    this.mEmailViewWrapper.getEditText().setOnFocusChangeListener(this);
    this.mEmailViewWrapper.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
    {
      public void onTextChanged(String paramAnonymousString)
      {
        ChangeEmailFragment.this.mChangeEmailPresenter.onEmailTextChanged(paramAnonymousString);
      }
    });
    this.mEmailViewWrapper.getEditText().setHint(getString(R.string.viber_id_change_email_hint));
    this.mPasswordViewWrapper = new ViewWithErrorStatusWrapper((TextInputLayout)localView.findViewById(R.id.password_view_layout));
    this.mPasswordViewWrapper.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
    {
      public void onTextChanged(String paramAnonymousString)
      {
        ChangeEmailFragment.this.mChangeEmailPresenter.onPasswordTextChanged(paramAnonymousString);
      }
    });
    this.mPasswordViewWrapper.getEditText().setHint(getString(R.string.viber_id_change_email_password_hint));
    this.mDoneButton = ((Button)localView.findViewById(R.id.done_btn));
    this.mDoneButton.setOnClickListener(this);
    this.mDisconnectAccountButton = localView.findViewById(R.id.disconnect_btn);
    this.mDisconnectAccountButton.setOnClickListener(this);
    this.mForgotPwdBtn = ((TextView)localView.findViewById(R.id.forgot_pwd));
    dj.a(this.mForgotPwdBtn, true);
    dj.a(this.mForgotPwdBtn, j.a(10.0F));
    this.mForgotPwdBtn.setOnClickListener(this);
    if (paramBundle != null);
    for (Parcelable localParcelable = paramBundle.getParcelable("change_email_state"); ; localParcelable = null)
    {
      this.mChangeEmailPresenter.attachView(this, localParcelable);
      this.mForgotPasswordPresenter.attachView(this);
      this.mDisconnectAccountPresenter.attach(this);
      return localView;
    }
  }

  public void onDestroyView()
  {
    this.mChangeEmailPresenter.detachView();
    this.mForgotPasswordPresenter.detachView();
    this.mDisconnectAccountPresenter.detach();
    super.onDestroyView();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D4003))
      if (paramInt == -2)
        this.mDisconnectAccountPresenter.disconnectAccount();
    while (!paramm.a(DialogCode.D4011))
      return;
    this.mChangeEmailPresenter.onSuccessDialogDismiss();
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.mEmailViewWrapper.getEditText() == paramView)
      this.mChangeEmailPresenter.onEmailFocusedChanged(paramBoolean);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.putParcelable("change_email_state", this.mChangeEmailPresenter.getState());
    super.onSaveInstanceState(paramBundle);
  }

  public void renderCurrentEmail(String paramString)
  {
    this.mEmailViewWrapper.getEditText().setText(paramString);
  }

  public void setDoneButtonState(boolean paramBoolean)
  {
    this.mDoneButton.setEnabled(paramBoolean);
  }

  void setRouter(EditInfoRouter paramEditInfoRouter)
  {
    this.mRouter = paramEditInfoRouter;
  }

  public void showDisconnectAccountError()
  {
    showGenericError();
  }

  public void showDisconnectAccountProgress()
  {
    showProgress();
  }

  public void showDisconnectConfirmationDialog()
  {
    ae.d().a(this).b(this);
  }

  public void showEmailWasSentDialog()
  {
    ae.a().b(this);
  }

  public void showGenericError()
  {
    ae.g().b(this);
  }

  public void showInvalidEmailError()
  {
    this.mEmailViewWrapper.setError(getString(R.string.viber_id_change_email_invalid));
  }

  public void showNoConnectionError()
  {
    ad.a().b(this);
  }

  public void showPasswordNotMatchedError()
  {
    this.mPasswordViewWrapper.setError(getString(R.string.viber_id_change_email_password_not_matched));
  }

  public void showProgress()
  {
    this.mEmailViewWrapper.showLoading();
    this.mDisconnectAccountButton.setEnabled(false);
    this.mDoneButton.setEnabled(false);
    this.mForgotPwdBtn.setEnabled(false);
    this.mPasswordViewWrapper.getEditText().setEnabled(false);
  }

  public void showSuccessDialog()
  {
    ae.j().a(this).b(this);
  }

  public void showTooManyRequestsError()
  {
    ae.h().b(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.changeemail.ChangeEmailFragment
 * JD-Core Version:    0.6.2
 */