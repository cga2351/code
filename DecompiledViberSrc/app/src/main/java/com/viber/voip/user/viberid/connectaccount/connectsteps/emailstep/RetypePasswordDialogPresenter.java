package com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.user.actions.Action;
import com.viber.voip.user.actions.ConnectionAwareAction;
import com.viber.voip.user.editinfo.diconnectaccount.DisconnectAccountPresenter;
import com.viber.voip.user.editinfo.diconnectaccount.DisconnectAccountRouter;
import com.viber.voip.user.viberid.ViberIdConnectValidator;
import com.viber.voip.user.viberid.ViberIdConnectValidator.PasswordValidationStrategy;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdRetypePasswordActionEvent;
import com.viber.voip.user.viberid.ViberIdInfo;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdBaseStepRouter;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class RetypePasswordDialogPresenter extends DisconnectAccountPresenter
{
  private static final Logger L = ViberEnv.getLogger();
  private static RetypePasswordDialogView STUB_VIEW = (RetypePasswordDialogView)cl.b(RetypePasswordDialogView.class);
  private ConnectionAwareAction<Void> mAction;
  private String mEmail = "";
  private String mPassword = "";
  private final ViberIdStepRouters.ViberIdBaseStepRouter mStepRouter;
  private RetypePasswordDialogView mView = STUB_VIEW;

  RetypePasswordDialogPresenter(ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdBaseStepRouter paramViberIdBaseStepRouter, DisconnectAccountRouter paramDisconnectAccountRouter, cj paramcj)
  {
    super(paramViberIdController, paramDisconnectAccountRouter, paramcj);
    this.mStepRouter = paramViberIdBaseStepRouter;
  }

  private void handleWrongPasswordError()
  {
    this.mView.showWrongPasswordError();
  }

  private boolean isValidPassword()
  {
    return ViberIdConnectValidator.isValidPassword(this.mController.getViberIdInfo().getEmail(), this.mPassword, this.mPassword, ViberIdConnectValidator.PasswordValidationStrategy.ENTER) == 0;
  }

  private void showRetypePasswordDialogIfNeeded()
  {
    ViberIdInfo localViberIdInfo = this.mController.getViberIdInfo();
    if ((localViberIdInfo.isAccountExist()) && (!localViberIdInfo.isRegisteredOnCurrentDevice()))
      this.mView.showRetypePasswordDialog(localViberIdInfo.getEmail());
  }

  void attach(RetypePasswordDialogView paramRetypePasswordDialogView, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof RetypePasswordSavedState))
    {
      RetypePasswordSavedState localRetypePasswordSavedState = (RetypePasswordSavedState)paramParcelable;
      this.mEmail = localRetypePasswordSavedState.email;
      this.mPassword = localRetypePasswordSavedState.password;
    }
    super.attach(paramRetypePasswordDialogView);
    this.mView = paramRetypePasswordDialogView;
    this.mAction = new ConnectionAwareAction(new Action()
    {
      public void execute(Void paramAnonymousVoid)
      {
        RetypePasswordDialogPresenter.this.mView.showPasswordDialogProgress();
        RetypePasswordDialogPresenter.this.mView.setRetypeDialogCancelableState(false);
        RetypePasswordDialogPresenter.this.mController.retypePassword(RetypePasswordDialogPresenter.this.mPassword);
      }
    }
    , this.mView, this.mReachability);
    if (TextUtils.isEmpty(this.mEmail))
      showRetypePasswordDialogIfNeeded();
  }

  public void detach()
  {
    super.detach();
    this.mAction = null;
  }

  Parcelable getSavedState()
  {
    return new RetypePasswordSavedState(this.mPassword, this.mEmail);
  }

  void onDialogPasswordTextChanged(String paramString)
  {
    if (this.mPassword.equals(paramString))
      return;
    if (paramString == null)
      paramString = "";
    this.mPassword = paramString;
    this.mView.hideWrongPasswordError();
    updateDialogButtonsState();
  }

  void onRetypePasswordDialogCanceled()
  {
    this.mPassword = "";
    this.mStepRouter.closeViberIdConnect();
  }

  void onRetypePasswordDialogClosed()
  {
    this.mPassword = "";
  }

  void onRetypePasswordDialogConnect(String paramString)
  {
    this.mPassword = paramString;
    if (isValidPassword())
    {
      this.mAction.execute(null);
      return;
    }
    handleWrongPasswordError();
  }

  void onRetypePasswordDialogShowed()
  {
    if (!TextUtils.isEmpty(this.mPassword))
      this.mView.setDialogPassword(this.mPassword);
    updateDialogButtonsState();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onViberIdPasswordActionReceived(ViberIdEvents.ViberIdRetypePasswordActionEvent paramViberIdRetypePasswordActionEvent)
  {
    this.mView.hidePasswordDialogProgress();
    this.mView.setRetypeDialogCancelableState(true);
    if (paramViberIdRetypePasswordActionEvent.status == 0)
    {
      this.mStepRouter.openEditInfo();
      return;
    }
    if (5 == paramViberIdRetypePasswordActionEvent.status)
    {
      handleWrongPasswordError();
      return;
    }
    if (4 == paramViberIdRetypePasswordActionEvent.status)
    {
      this.mView.showRetypePasswordAttemptsExceededError();
      return;
    }
    this.mView.showRetypePasswordGeneralError();
  }

  void setEmail(String paramString)
  {
    if (paramString != null)
      this.mEmail = paramString;
  }

  void updateDialogButtonsState()
  {
    RetypePasswordDialogView localRetypePasswordDialogView = this.mView;
    if (this.mPassword.length() >= ViberIdConnectValidator.PasswordValidationStrategy.ENTER.getMinPasswordLength());
    for (boolean bool = true; ; bool = false)
    {
      localRetypePasswordDialogView.setDialogButtonsState(bool, true, true);
      return;
    }
  }

  static class RetypePasswordSavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<RetypePasswordSavedState> CREATOR = new Parcelable.Creator()
    {
      public RetypePasswordDialogPresenter.RetypePasswordSavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new RetypePasswordDialogPresenter.RetypePasswordSavedState(paramAnonymousParcel);
      }

      public RetypePasswordDialogPresenter.RetypePasswordSavedState[] newArray(int paramAnonymousInt)
      {
        return new RetypePasswordDialogPresenter.RetypePasswordSavedState[paramAnonymousInt];
      }
    };
    final String email;
    final String password;

    RetypePasswordSavedState(Parcel paramParcel)
    {
      this.password = paramParcel.readString();
      this.email = paramParcel.readString();
    }

    RetypePasswordSavedState(String paramString1, String paramString2)
    {
      this.password = paramString1;
      this.email = paramString2;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.password);
      paramParcel.writeString(this.email);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.emailstep.RetypePasswordDialogPresenter
 * JD-Core Version:    0.6.2
 */