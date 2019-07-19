package com.viber.voip.user.editinfo.changepassword;

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
import com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordPresenter;
import com.viber.voip.user.editinfo.forgotpassword.ForgotPasswordView;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper.TextChangeListener;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;

public class ChangePasswordFragment extends aq
  implements View.OnClickListener, m.c, ChangePasswordView, ForgotPasswordView
{
  private ChangePasswordPresenter mChangePasswordPresenter;
  private ViewWithErrorStatusWrapper mCurrentPassword;
  private Button mDoneButton;
  private ForgotPasswordPresenter mForgotPasswordPresenter;
  private ViewWithErrorStatusWrapper mNewPassword;
  private ViewWithErrorStatusWrapper mNewRetypePassword;
  private EditInfoRouter mRouter;

  public static ChangePasswordFragment createInstance(EditInfoRouter paramEditInfoRouter)
  {
    ChangePasswordFragment localChangePasswordFragment = new ChangePasswordFragment();
    localChangePasswordFragment.setRouter(paramEditInfoRouter);
    return localChangePasswordFragment;
  }

  private void setupActionBar()
  {
    a locala = ((AppCompatActivity)getActivity()).getSupportActionBar();
    if (locala != null)
      locala.b(R.string.viber_id_change_password_title);
  }

  public void hideCurrentPasswordIsInvalidError()
  {
    this.mCurrentPassword.setError(null);
  }

  public void hideNewPasswordIsInvalidError()
  {
    this.mNewPassword.setError(null);
  }

  public void hidePasswordNotMatchedError()
  {
    this.mNewRetypePassword.setError(null);
  }

  public void hideProgress()
  {
    this.mNewPassword.hideLoadding();
  }

  public void hideSoftKeyboard()
  {
    dj.a(getView(), false);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.done_btn)
      this.mChangePasswordPresenter.onFinish();
    do
    {
      return;
      if (i == R.id.root_layout)
      {
        this.mChangePasswordPresenter.onFocusOutClick();
        return;
      }
    }
    while (i != R.id.forgot_pwd);
    this.mForgotPasswordPresenter.onForgotPassword();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    cj localcj = cj.a(localApplication);
    this.mChangePasswordPresenter = new ChangePasswordPresenter(this.mRouter, localViberApplication.getUserManager().getUserData(), localViberApplication.getViberIdController(), localcj);
    this.mForgotPasswordPresenter = new ForgotPasswordPresenter(localViberApplication.getViberIdController(), localcj);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setupActionBar();
    View localView = paramLayoutInflater.inflate(R.layout.fragment_edit_info_change_password, paramViewGroup, false);
    localView.setOnClickListener(this);
    this.mCurrentPassword = new ViewWithErrorStatusWrapper((TextInputLayout)localView.findViewById(R.id.current_pwd));
    this.mCurrentPassword.getEditText().setHint(getString(R.string.viber_id_change_password_current_hint));
    this.mCurrentPassword.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
    {
      public void onTextChanged(String paramAnonymousString)
      {
        ChangePasswordFragment.this.mChangePasswordPresenter.onCurrentPasswordTextChanged(paramAnonymousString);
      }
    });
    this.mNewPassword = new ViewWithErrorStatusWrapper((TextInputLayout)localView.findViewById(R.id.new_pwd));
    this.mNewPassword.getEditText().setHint(getString(R.string.viber_id_change_password_new_hint));
    this.mNewPassword.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        ChangePasswordFragment.this.mChangePasswordPresenter.onNewPasswordFocusChanged(paramAnonymousBoolean);
      }
    });
    this.mNewPassword.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
    {
      public void onTextChanged(String paramAnonymousString)
      {
        ChangePasswordFragment.this.mChangePasswordPresenter.onNewPasswordTextChanged(paramAnonymousString);
      }
    });
    this.mNewRetypePassword = new ViewWithErrorStatusWrapper((TextInputLayout)localView.findViewById(R.id.retype_new_pwd));
    this.mNewRetypePassword.getEditText().setHint(getString(R.string.viber_id_change_password_retype_hint));
    this.mNewRetypePassword.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        ChangePasswordFragment.this.mChangePasswordPresenter.onRetypePasswordFocusChanged(paramAnonymousBoolean);
      }
    });
    this.mNewRetypePassword.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
    {
      public void onTextChanged(String paramAnonymousString)
      {
        ChangePasswordFragment.this.mChangePasswordPresenter.onRetypePasswordTextChanged(paramAnonymousString);
      }
    });
    this.mDoneButton = ((Button)localView.findViewById(R.id.done_btn));
    this.mDoneButton.setOnClickListener(this);
    TextView localTextView = (TextView)localView.findViewById(R.id.forgot_pwd);
    dj.a(localTextView, true);
    dj.a(localTextView, j.a(10.0F));
    localTextView.setOnClickListener(this);
    if (paramBundle != null);
    for (Parcelable localParcelable = paramBundle.getParcelable("change_password_state"); ; localParcelable = null)
    {
      this.mChangePasswordPresenter.attachView(this, localParcelable);
      this.mForgotPasswordPresenter.attachView(this);
      return localView;
    }
  }

  public void onDetach()
  {
    this.mChangePasswordPresenter.detachView();
    this.mForgotPasswordPresenter.detachView();
    super.onDetach();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D4011))
      this.mChangePasswordPresenter.onSuccessDialogDismiss();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.putParcelable("change_password_state", this.mChangePasswordPresenter.getState());
    super.onSaveInstanceState(paramBundle);
  }

  public void setCurrentPasswordInputState(boolean paramBoolean)
  {
    this.mCurrentPassword.getEditText().setEnabled(paramBoolean);
  }

  public void setDoneButtonState(boolean paramBoolean)
  {
    this.mDoneButton.setEnabled(paramBoolean);
  }

  public void setNewPasswordInputState(boolean paramBoolean)
  {
    this.mNewPassword.getEditText().setEnabled(paramBoolean);
  }

  public void setRetypePasswordInputState(boolean paramBoolean)
  {
    this.mNewRetypePassword.getEditText().setEnabled(paramBoolean);
  }

  void setRouter(EditInfoRouter paramEditInfoRouter)
  {
    this.mRouter = paramEditInfoRouter;
  }

  public void showCurrentPasswordIsInvalidError()
  {
    this.mCurrentPassword.setError(getString(R.string.viber_id_change_password_current_error));
  }

  public void showEmailWasSentDialog()
  {
    ae.a().b(this);
  }

  public void showGenericError()
  {
    ae.g().b(this);
  }

  public void showNewPasswordIsInvalidError()
  {
    this.mNewPassword.setError(getString(R.string.viber_id_change_password_new_error));
  }

  public void showNoConnectionError()
  {
    ad.a().b(this);
  }

  public void showPasswordNotMatchedError()
  {
    this.mNewRetypePassword.setError(getString(R.string.viber_id_change_password_retype_error));
  }

  public void showProgress()
  {
    this.mNewPassword.showLoading();
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
 * Qualified Name:     com.viber.voip.user.editinfo.changepassword.ChangePasswordFragment
 * JD-Core Version:    0.6.2
 */