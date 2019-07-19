package com.viber.voip.user.viberid.connectaccount.connectsteps;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdController.PendingRegistrationRequest;
import com.viber.voip.util.cl;

class ViberIdStepsContentPresenter
{
  private static final Logger L = ViberEnv.getLogger();
  private final ViberIdController mController;
  private ViberIdConnectStep mCurrentStep = ViberIdConnectStep.ENTER_EMAIL;
  private boolean mIsAttached = false;
  private final ViberIdStepRouters.ViberIdStepRouter mRouter;
  private ViberIdStepsContentView mView = (ViberIdStepsContentView)cl.b(ViberIdStepsContentView.class);

  ViberIdStepsContentPresenter(ViberIdController paramViberIdController, ViberIdStepRouters.ViberIdStepRouter paramViberIdStepRouter)
  {
    this.mController = paramViberIdController;
    this.mRouter = paramViberIdStepRouter;
  }

  private boolean openRegistrationStepIfNeeded()
  {
    ViberIdController.PendingRegistrationRequest localPendingRegistrationRequest = this.mController.getPendingRegistrationRequest();
    if (localPendingRegistrationRequest == null)
      return false;
    if (localPendingRegistrationRequest.existingEmail)
      this.mRouter.showEnterPasswordStep(localPendingRegistrationRequest.email, localPendingRegistrationRequest.promotionsAgreed, localPendingRegistrationRequest.password);
    while (true)
    {
      return true;
      this.mRouter.showSetPasswordStep(localPendingRegistrationRequest.email, localPendingRegistrationRequest.promotionsAgreed, localPendingRegistrationRequest.password);
    }
  }

  void attach(ViberIdStepsContentView paramViberIdStepsContentView, Parcelable paramParcelable)
  {
    this.mIsAttached = true;
    SavedState localSavedState;
    if ((paramParcelable instanceof SavedState))
    {
      localSavedState = (SavedState)paramParcelable;
      this.mCurrentStep = ViberIdConnectStep.values()[localSavedState.step];
    }
    for (Parcelable localParcelable = localSavedState.currentStepState.stepState; ; localParcelable = null)
    {
      this.mView = paramViberIdStepsContentView;
      if (!openRegistrationStepIfNeeded())
        this.mView.attachStep(this.mCurrentStep, localParcelable);
      return;
    }
  }

  void detach()
  {
    this.mIsAttached = false;
    this.mView = ((ViberIdStepsContentView)cl.b(ViberIdStepsContentView.class));
  }

  Parcelable getSavedState()
  {
    StepStateContainer localStepStateContainer = new StepStateContainer();
    this.mView.saveStepState(this.mCurrentStep, localStepStateContainer);
    return new SavedState(this.mCurrentStep.ordinal(), localStepStateContainer);
  }

  void onBackPressNotHandled()
  {
    this.mRouter.closeViberIdConnect();
  }

  void onBackPressed()
  {
    if (this.mController.getPendingRegistrationRequest() != null)
    {
      this.mRouter.closeViberIdConnect();
      return;
    }
    this.mView.onBackPressed(this.mCurrentStep);
  }

  void onBackgroundPressed()
  {
    this.mView.handleFocusOutClick(this.mCurrentStep);
  }

  void onDialogAction(ViberIdStepsContentView.DialogContainer paramDialogContainer)
  {
    this.mView.handleDialogAction(this.mCurrentStep, paramDialogContainer);
  }

  void onDialogShow(ViberIdStepsContentView.DialogContainer paramDialogContainer)
  {
    this.mView.handleDialogShow(this.mCurrentStep, paramDialogContainer);
  }

  void onLearnMoreLinkPressed()
  {
    this.mView.openLearnMore();
    this.mView.handleFocusOutClick(this.mCurrentStep);
  }

  void onTermsAndPrivacyClicked()
  {
    this.mView.openTermsAndPrivacy();
    this.mView.handleFocusOutClick(this.mCurrentStep);
  }

  void setArguments(Bundle paramBundle)
  {
    if (this.mIsAttached)
      this.mView.setStepArguments(this.mCurrentStep, paramBundle);
  }

  void switchStep(ViberIdConnectStep paramViberIdConnectStep, Bundle paramBundle)
  {
    ViberIdConnectStep localViberIdConnectStep = this.mCurrentStep;
    this.mCurrentStep = paramViberIdConnectStep;
    this.mView.openStep(this.mCurrentStep, localViberIdConnectStep, paramBundle);
  }

  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ViberIdStepsContentPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ViberIdStepsContentPresenter.SavedState(paramAnonymousParcel);
      }

      public ViberIdStepsContentPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ViberIdStepsContentPresenter.SavedState[paramAnonymousInt];
      }
    };
    ViberIdStepsContentPresenter.StepStateContainer currentStepState;
    final int step;

    public SavedState(int paramInt, ViberIdStepsContentPresenter.StepStateContainer paramStepStateContainer)
    {
      this.step = paramInt;
      this.currentStepState = paramStepStateContainer;
    }

    protected SavedState(Parcel paramParcel)
    {
      this.step = paramParcel.readInt();
      if (paramParcel.readInt() > 0)
      {
        this.currentStepState = ((ViberIdStepsContentPresenter.StepStateContainer)paramParcel.readParcelable(ViberIdStepsContentPresenter.StepStateContainer.class.getClassLoader()));
        return;
      }
      this.currentStepState = null;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.step);
      if (this.currentStepState != null)
      {
        paramParcel.writeInt(1);
        paramParcel.writeParcelable(this.currentStepState, paramInt);
        return;
      }
      paramParcel.writeInt(0);
    }
  }

  static class StepStateContainer
    implements Parcelable
  {
    public static final Parcelable.Creator<StepStateContainer> CREATOR = new Parcelable.Creator()
    {
      public ViberIdStepsContentPresenter.StepStateContainer createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ViberIdStepsContentPresenter.StepStateContainer(paramAnonymousParcel);
      }

      public ViberIdStepsContentPresenter.StepStateContainer[] newArray(int paramAnonymousInt)
      {
        return new ViberIdStepsContentPresenter.StepStateContainer[paramAnonymousInt];
      }
    };
    private Parcelable stepState;

    StepStateContainer()
    {
    }

    StepStateContainer(Parcel paramParcel)
    {
      if (paramParcel.readInt() > 0)
        try
        {
          this.stepState = paramParcel.readParcelable(Class.forName(paramParcel.readString()).getClassLoader());
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          this.stepState = null;
          return;
        }
      this.stepState = null;
    }

    public int describeContents()
    {
      return 0;
    }

    void setStepState(Parcelable paramParcelable)
    {
      this.stepState = paramParcelable;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (this.stepState != null)
      {
        paramParcel.writeInt(1);
        paramParcel.writeString(this.stepState.getClass().getName());
        paramParcel.writeParcelable(this.stepState, paramInt);
        return;
      }
      paramParcel.writeInt(0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepsContentPresenter
 * JD-Core Version:    0.6.2
 */