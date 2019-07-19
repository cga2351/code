package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.setpasswordstep;

import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper.TextChangeListener;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdPasswordStepRouter;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.PasswordContentAnimatorProvider;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.StepsAnimator.ContentAnimatorProvider;
import com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordViewHolder;
import com.viber.voip.util.cj;

public class ViberIdSetPasswordViewHolder extends ViberIdPasswordViewHolder<ViberIdSetPasswordStepView, ViberIdSetPasswordStepPresenter>
  implements View.OnFocusChangeListener, ViberIdSetPasswordStepView
{
  private final Logger L = ViberEnv.getLogger();
  private final String mInvalidPasswordErrorMessage;
  private final String mPasswordMustMatchErrorMessage;
  private final ViberIdSetPasswordStepPresenter mPresenter;
  private ViewWithErrorStatusWrapper mRetypedPasswordWrapper;

  public ViberIdSetPasswordViewHolder(ViberFragmentActivity paramViberFragmentActivity, ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdPasswordStepRouter paramViberIdPasswordStepRouter, cj paramcj)
  {
    super(paramViberFragmentActivity);
    this.mPresenter = new ViberIdSetPasswordStepPresenter(paramViberIdController, paramViberIdPasswordStepRouter, paramcj);
    this.mInvalidPasswordErrorMessage = this.mActivity.getString(R.string.viber_id_set_password_invalid_error_text);
    this.mPasswordMustMatchErrorMessage = this.mActivity.getString(R.string.viber_id_set_password_must_match_error_text);
  }

  public void attach(ViewGroup paramViewGroup, View paramView, Parcelable paramParcelable)
  {
    this.mRetypedPasswordWrapper = new ViewWithErrorStatusWrapper((TextInputLayout)paramViewGroup.findViewById(R.id.retype_password_layout), false);
    this.mRetypedPasswordWrapper.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
    {
      public void onTextChanged(String paramAnonymousString)
      {
        ViberIdSetPasswordViewHolder.this.mPresenter.onRetypedPasswordTextChanged(paramAnonymousString);
      }
    });
    super.attach(paramViewGroup, paramView, paramParcelable);
    this.mRetypedPasswordWrapper.getEditText().setOnFocusChangeListener(this);
    this.mRetypedPasswordWrapper.getEditText().setHint(R.string.viber_id_set_password_retyped_hint);
    this.mPasswordWrapper.getEditText().setOnFocusChangeListener(this);
    this.mPasswordWrapper.getEditText().setHint(R.string.viber_id_set_password_hint);
  }

  public void detach()
  {
    if (this.mPasswordWrapper != null)
      this.mPasswordWrapper.getEditText().setOnFocusChangeListener(null);
    super.detach();
    if (this.mRetypedPasswordWrapper != null)
    {
      this.mRetypedPasswordWrapper.setTextChangeListener(null);
      this.mRetypedPasswordWrapper.getEditText().setOnFocusChangeListener(null);
      this.mRetypedPasswordWrapper.setError(null);
      this.mRetypedPasswordWrapper = null;
    }
  }

  protected ViberIdSetPasswordStepPresenter getPresenter()
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
    arrayOfView[2] = this.mRetypedPasswordWrapper.getView();
    return new PasswordContentAnimatorProvider(localViewGroup, localView1, localView2, arrayOfView);
  }

  public void handleOutsideClick()
  {
    super.handleOutsideClick();
    if ((this.mPasswordWrapper != null) && (this.mPasswordWrapper.getEditText().isFocused()))
      this.mPresenter.onPasswordFieldFocusChanged(false);
    while ((this.mRetypedPasswordWrapper == null) || (!this.mRetypedPasswordWrapper.getEditText().isFocused()))
      return;
    this.mPresenter.onRetypedPasswordFieldFocusChanged(false);
  }

  public void hidePasswordInvalidError()
  {
    this.mPasswordWrapper.setError(null);
  }

  public void hidePasswordMustMatchError()
  {
    this.mRetypedPasswordWrapper.setError(null);
  }

  public void hideProgress()
  {
    super.hideProgress();
    this.mRetypedPasswordWrapper.getEditText().setEnabled(true);
  }

  public void initViewState(String paramString1, String paramString2, boolean paramBoolean)
  {
    super.initBaseViewState(paramString1, paramBoolean);
    this.mRetypedPasswordWrapper.getEditText().setText(paramString2);
    this.mRetypedPasswordWrapper.getEditText().setSelection(this.mRetypedPasswordWrapper.getEditText().getText().length());
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.mPasswordWrapper.getEditText())
      this.mPresenter.onPasswordFieldFocusChanged(paramBoolean);
    while (paramView != this.mRetypedPasswordWrapper.getEditText())
      return;
    this.mPresenter.onRetypedPasswordFieldFocusChanged(paramBoolean);
  }

  public void setRetypePasswordFieldState(boolean paramBoolean)
  {
    this.mRetypedPasswordWrapper.setEnabled(paramBoolean);
  }

  public void showPasswordInvalidError()
  {
    this.mPasswordWrapper.setError(this.mInvalidPasswordErrorMessage);
  }

  public void showPasswordMustMatchError()
  {
    this.mRetypedPasswordWrapper.setError(this.mPasswordMustMatchErrorMessage);
  }

  public void showProgress()
  {
    super.showProgress();
    this.mRetypedPasswordWrapper.getEditText().setEnabled(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.setpasswordstep.ViberIdSetPasswordViewHolder
 * JD-Core Version:    0.6.2
 */