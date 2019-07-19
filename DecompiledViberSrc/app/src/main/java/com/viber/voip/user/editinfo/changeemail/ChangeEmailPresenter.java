package com.viber.voip.user.editinfo.changeemail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.user.UserData;
import com.viber.voip.user.actions.Action;
import com.viber.voip.user.actions.ConnectionAwareAction;
import com.viber.voip.user.editinfo.EditInfoRouter;
import com.viber.voip.user.viberid.ViberIdConnectValidator;
import com.viber.voip.user.viberid.ViberIdConnectValidator.PasswordValidationStrategy;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdEmailChangingEvent;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdInfoChangedEvent;
import com.viber.voip.user.viberid.ViberIdInfo;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ChangeEmailPresenter
{
  public static final String PARCEL_KEY = "change_email_state";
  private static final ChangeEmailView STUB_VIEW = (ChangeEmailView)cl.b(ChangeEmailView.class);
  private ConnectionAwareAction<Void> mChangeEmailAction;
  private final ViberIdController mController;
  private final cj mReachability;
  private final EditInfoRouter mRouter;
  private State mState;
  private final UserData mUserData;
  private ChangeEmailView mView = STUB_VIEW;

  public ChangeEmailPresenter(UserData paramUserData, EditInfoRouter paramEditInfoRouter, ViberIdController paramViberIdController, cj paramcj)
  {
    this.mUserData = paramUserData;
    this.mRouter = paramEditInfoRouter;
    this.mController = paramViberIdController;
    this.mReachability = paramcj;
    this.mState = createState(this.mUserData.getViberIdInfo());
  }

  private State createState(ViberIdInfo paramViberIdInfo)
  {
    return new State(paramViberIdInfo.getEmail(), "");
  }

  private void doChangeEmail()
  {
    setViewInProgress(true);
    this.mController.changeEmail(this.mState.getEmail(), this.mState.getEnteredPassword());
  }

  private void setViewInProgress(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mView.showProgress();
      return;
    }
    this.mView.hideProgress();
  }

  private State updateEmail(String paramString)
  {
    return new State(paramString, this.mState.getEnteredPassword());
  }

  private State updatePassword(String paramString)
  {
    String str = this.mState.getEmail();
    if (da.a(paramString))
      paramString = "";
    return new State(str, paramString);
  }

  public void attachView(ChangeEmailView paramChangeEmailView, Parcelable paramParcelable)
  {
    this.mView = paramChangeEmailView;
    if ((paramParcelable instanceof State))
    {
      this.mState = ((State)paramParcelable);
      this.mView.renderCurrentEmail(this.mState.getEmail());
    }
    this.mView.setDoneButtonState(false);
    this.mController.getEventBus().register(this);
    this.mChangeEmailAction = new ConnectionAwareAction(new Action()
    {
      public void execute(Void paramAnonymousVoid)
      {
        ChangeEmailPresenter.this.doChangeEmail();
      }
    }
    , this.mView, this.mReachability);
  }

  public void detachView()
  {
    this.mView = STUB_VIEW;
    this.mController.getEventBus().unregister(this);
    this.mChangeEmailAction = null;
  }

  public State getState()
  {
    return this.mState;
  }

  public void onDisconnect()
  {
    this.mView.showDisconnectConfirmationDialog();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onEmailChangedReply(ViberIdEvents.ViberIdEmailChangingEvent paramViberIdEmailChangingEvent)
  {
    setViewInProgress(false);
    switch (paramViberIdEmailChangingEvent.status)
    {
    default:
      return;
    case 5:
      this.mView.showPasswordNotMatchedError();
      return;
    case 4:
      this.mView.showInvalidEmailError();
      return;
    case 1:
    case 2:
    case 3:
      this.mView.showGenericError();
      return;
    case 6:
      this.mView.showTooManyRequestsError();
      return;
    case 0:
    }
    this.mView.showSuccessDialog();
  }

  public void onEmailFocusedChanged(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!ViberIdConnectValidator.isValidEmail(this.mState.getEmail())))
      this.mView.showInvalidEmailError();
  }

  public void onEmailTextChanged(String paramString)
  {
    if (paramString == null)
      paramString = "";
    this.mState = updateEmail(paramString);
  }

  public void onFinish()
  {
    if (this.mChangeEmailAction == null)
      return;
    if (ViberIdConnectValidator.isValidEmail(this.mState.getEmail()))
    {
      this.mChangeEmailAction.execute(null);
      return;
    }
    this.mView.showInvalidEmailError();
  }

  public void onFocusOutClick()
  {
    this.mView.hideSoftKeyboard();
    onEmailFocusedChanged(false);
  }

  public void onPasswordTextChanged(String paramString)
  {
    this.mState = updatePassword(paramString);
    if (this.mState.getEnteredPassword().length() >= ViberIdConnectValidator.PasswordValidationStrategy.ENTER.getMinPasswordLength());
    for (boolean bool = true; ; bool = false)
    {
      this.mView.setDoneButtonState(bool);
      return;
    }
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
      public ChangeEmailPresenter.State createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ChangeEmailPresenter.State(paramAnonymousParcel);
      }

      public ChangeEmailPresenter.State[] newArray(int paramAnonymousInt)
      {
        return new ChangeEmailPresenter.State[paramAnonymousInt];
      }
    };
    private final String mEmail;
    private final String mEnteredPassword;

    protected State(Parcel paramParcel)
    {
      this.mEmail = paramParcel.readString();
      this.mEnteredPassword = paramParcel.readString();
    }

    public State(String paramString1, String paramString2)
    {
      this.mEmail = paramString1;
      this.mEnteredPassword = paramString2;
    }

    public int describeContents()
    {
      return 0;
    }

    public String getEmail()
    {
      return this.mEmail;
    }

    public String getEnteredPassword()
    {
      return this.mEnteredPassword;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mEmail);
      paramParcel.writeString(this.mEnteredPassword);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.changeemail.ChangeEmailPresenter
 * JD-Core Version:    0.6.2
 */