package com.viber.voip.user.editinfo.changepassword;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.voip.user.UserData;
import com.viber.voip.user.actions.Action;
import com.viber.voip.user.actions.ConnectionAwareAction;
import com.viber.voip.user.editinfo.EditInfoRouter;
import com.viber.voip.user.viberid.ViberIdConnectValidator;
import com.viber.voip.user.viberid.ViberIdConnectValidator.PasswordValidationStrategy;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdChangePasswordActionEvent;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdInfoChangedEvent;
import com.viber.voip.user.viberid.ViberIdInfo;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ChangePasswordPresenter
{
  public static final String PARCEL_KEY = "change_password_state";
  private static ChangePasswordView STUB_VIEW = (ChangePasswordView)cl.b(ChangePasswordView.class);
  private ConnectionAwareAction<Void> mChangePasswordAction;
  private final ViberIdController mController;
  private final cj mReachability;
  private final EditInfoRouter mRouter;
  private State mState;
  private final UserData mUserData;
  private ChangePasswordView mView = STUB_VIEW;

  public ChangePasswordPresenter(EditInfoRouter paramEditInfoRouter, UserData paramUserData, ViberIdController paramViberIdController, cj paramcj)
  {
    this.mRouter = paramEditInfoRouter;
    this.mUserData = paramUserData;
    this.mController = paramViberIdController;
    this.mReachability = paramcj;
    this.mState = new State("", "", "");
  }

  private boolean areAllValid(int paramInt)
  {
    return paramInt == 0;
  }

  private void doChangePassword()
  {
    setViewInProgress(true);
    this.mController.changePassword(this.mState.getCurrentPassword(), this.mState.getNewPassword());
  }

  private int getValidationResultForCurrentState()
  {
    return ViberIdConnectValidator.isValidPassword(this.mUserData.getViberIdInfo().getEmail(), this.mState.getNewPassword(), this.mState.getPasswordRetype(), ViberIdConnectValidator.PasswordValidationStrategy.CREATE);
  }

  private boolean isNewPasswordValid(int paramInt)
  {
    return (paramInt != 2) && (paramInt != 1);
  }

  private void setPasswordInputsState(boolean paramBoolean)
  {
    this.mView.setCurrentPasswordInputState(paramBoolean);
    this.mView.setNewPasswordInputState(paramBoolean);
    this.mView.setRetypePasswordInputState(paramBoolean);
  }

  private void setViewInProgress(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mView.showProgress();
      if (paramBoolean)
        break label37;
    }
    label37: for (boolean bool = true; ; bool = false)
    {
      setPasswordInputsState(bool);
      return;
      this.mView.hideProgress();
      break;
    }
  }

  private void switchValidationErrorsVisibility(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
    case 2:
      if (!da.b(this.mState.getNewPassword()))
      {
        this.mView.showNewPasswordIsInvalidError();
        return;
      }
      this.mView.hideNewPasswordIsInvalidError();
      return;
    case 3:
      if (!da.b(this.mState.getPasswordRetype()))
      {
        this.mView.showPasswordNotMatchedError();
        return;
      }
      this.mView.hidePasswordNotMatchedError();
      return;
    case 0:
    }
    this.mView.hideNewPasswordIsInvalidError();
    this.mView.hidePasswordNotMatchedError();
  }

  private void updateFieldsState()
  {
    int i = getValidationResultForCurrentState();
    switchValidationErrorsVisibility(i);
    updateRetypeFieldState(i);
    this.mView.setDoneButtonState(areAllValid(i));
  }

  private void updateRetypeFieldState(int paramInt)
  {
    ChangePasswordView localChangePasswordView = this.mView;
    if ((isNewPasswordValid(paramInt)) || (!da.b(this.mState.getPasswordRetype())));
    for (boolean bool = true; ; bool = false)
    {
      localChangePasswordView.setRetypePasswordInputState(bool);
      return;
    }
  }

  public void attachView(ChangePasswordView paramChangePasswordView, Parcelable paramParcelable)
  {
    this.mView = paramChangePasswordView;
    if ((paramParcelable instanceof State))
    {
      this.mState = ((State)paramParcelable);
      updateFieldsState();
    }
    this.mView.setDoneButtonState(false);
    this.mView.setRetypePasswordInputState(false);
    this.mController.getEventBus().register(this);
    this.mChangePasswordAction = new ConnectionAwareAction(new Action()
    {
      public void execute(Void paramAnonymousVoid)
      {
        ChangePasswordPresenter.this.doChangePassword();
      }
    }
    , this.mView, this.mReachability);
  }

  public void detachView()
  {
    this.mView = STUB_VIEW;
    this.mController.getEventBus().unregister(this);
    this.mChangePasswordAction = null;
  }

  public State getState()
  {
    return this.mState;
  }

  public void onCurrentPasswordTextChanged(String paramString)
  {
    if (da.a(paramString))
      paramString = "";
    this.mState = new State(paramString, this.mState.getNewPassword(), this.mState.getPasswordRetype());
    this.mView.hideCurrentPasswordIsInvalidError();
    this.mView.setDoneButtonState(this.mState.allNotNullOrEmpty());
  }

  public void onFinish()
  {
    if (this.mChangePasswordAction == null)
      return;
    String str = this.mState.getCurrentPassword();
    if ((TextUtils.isEmpty(str)) || (ViberIdConnectValidator.PasswordValidationStrategy.ENTER.getMinPasswordLength() > str.length()))
    {
      this.mView.showCurrentPasswordIsInvalidError();
      return;
    }
    int i = getValidationResultForCurrentState();
    if (areAllValid(i))
    {
      this.mChangePasswordAction.execute(null);
      return;
    }
    this.mView.setDoneButtonState(false);
    switchValidationErrorsVisibility(i);
  }

  public void onFocusOutClick()
  {
    this.mView.hideSoftKeyboard();
    updateFieldsState();
  }

  public void onNewPasswordFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mView.hideNewPasswordIsInvalidError();
      return;
    }
    updateFieldsState();
  }

  public void onNewPasswordTextChanged(String paramString)
  {
    String str = this.mState.getCurrentPassword();
    if (da.a(paramString))
      paramString = "";
    this.mState = new State(str, paramString, this.mState.getPasswordRetype());
    updateRetypeFieldState(getValidationResultForCurrentState());
    this.mView.setDoneButtonState(this.mState.allNotNullOrEmpty());
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onPasswordActionReply(ViberIdEvents.ViberIdChangePasswordActionEvent paramViberIdChangePasswordActionEvent)
  {
    setViewInProgress(false);
    switch (paramViberIdChangePasswordActionEvent.status)
    {
    default:
      return;
    case 0:
      this.mView.showSuccessDialog();
      return;
    case 5:
      this.mView.showCurrentPasswordIsInvalidError();
      return;
    case 6:
      this.mView.showNewPasswordIsInvalidError();
      return;
    case 4:
      this.mView.showTooManyRequestsError();
      return;
    case 1:
    case 2:
    case 3:
    }
    this.mView.showGenericError();
  }

  public void onRetypePasswordFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mView.hidePasswordNotMatchedError();
      return;
    }
    updateFieldsState();
  }

  public void onRetypePasswordTextChanged(String paramString)
  {
    String str1 = this.mState.getCurrentPassword();
    String str2 = this.mState.getNewPassword();
    if (da.a(paramString))
      paramString = "";
    this.mState = new State(str1, str2, paramString);
    this.mView.setDoneButtonState(this.mState.allNotNullOrEmpty());
  }

  public void onSuccessDialogDismiss()
  {
    this.mRouter.tryGoBack();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onViberIdInfoChanged(ViberIdEvents.ViberIdInfoChangedEvent paramViberIdInfoChangedEvent)
  {
    if (!paramViberIdInfoChangedEvent.viberIdInfo.isAccountExist())
      this.mRouter.tryGoBack();
  }

  static class State
    implements Parcelable
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ChangePasswordPresenter.State createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ChangePasswordPresenter.State(paramAnonymousParcel);
      }

      public ChangePasswordPresenter.State[] newArray(int paramAnonymousInt)
      {
        return new ChangePasswordPresenter.State[paramAnonymousInt];
      }
    };
    private final String mCurrentPassword;
    private final String mNewPassword;
    private final String mPasswordRetype;

    protected State(Parcel paramParcel)
    {
      this.mCurrentPassword = paramParcel.readString();
      this.mNewPassword = paramParcel.readString();
      this.mPasswordRetype = paramParcel.readString();
    }

    State(String paramString1, String paramString2, String paramString3)
    {
      this.mCurrentPassword = paramString1;
      this.mNewPassword = paramString2;
      this.mPasswordRetype = paramString3;
    }

    public boolean allNotNullOrEmpty()
    {
      return (!da.b(this.mCurrentPassword)) && (!da.b(this.mNewPassword)) && (!da.b(this.mPasswordRetype));
    }

    public int describeContents()
    {
      return 0;
    }

    public String getCurrentPassword()
    {
      return this.mCurrentPassword;
    }

    public String getNewPassword()
    {
      return this.mNewPassword;
    }

    public String getPasswordRetype()
    {
      return this.mPasswordRetype;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mCurrentPassword);
      paramParcel.writeString(this.mNewPassword);
      paramParcel.writeString(this.mPasswordRetype);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.changepassword.ChangePasswordPresenter
 * JD-Core Version:    0.6.2
 */