package com.viber.voip.user.viberid.connectaccount.connectsteps;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.StepsAnimator;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.StepsAnimator.ContentAnimatorProvider;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ViberIdStepViewController
  implements StepViewHolder, ViberIdStepsContentView
{
  private static final Logger L = ViberEnv.getLogger();
  private final ViberFragmentActivity mActivity;
  private final g mAnalyticsManager;
  private View mContinueButton;
  private final ViberIdController mController;
  private final ViberIdStepsContentPresenter mPresenter;
  private final cj mReachability;
  private final ViberIdStepRouters.ViberIdStepRouter mRouter;
  private EnumMap<ViberIdConnectStep, StepViewHolder> mStepViewHolders = new EnumMap(ViberIdConnectStep.class);
  private EnumMap<ViberIdConnectStep, ViewGroup> mStepViewParents = new EnumMap(ViberIdConnectStep.class);
  private final StepsAnimator mStepsAnimator;
  private ViewGroup mStepsContent;
  private final String mViberIdConnectTitle;

  public ViberIdStepViewController(ViberFragmentActivity paramViberFragmentActivity, ViberIdStepRouters.ViberIdBaseStepRouter paramViberIdBaseStepRouter, ViberIdController paramViberIdController, StepsAnimator paramStepsAnimator, cj paramcj, g paramg)
  {
    this.mActivity = paramViberFragmentActivity;
    this.mController = paramViberIdController;
    this.mReachability = paramcj;
    this.mAnalyticsManager = paramg;
    this.mStepsAnimator = paramStepsAnimator;
    this.mRouter = new ViberIdStepRouterImpl(paramViberIdBaseStepRouter, this);
    this.mPresenter = new ViberIdStepsContentPresenter(paramViberIdController, this.mRouter);
    this.mViberIdConnectTitle = this.mActivity.getString(R.string.viber_id_connect_title);
  }

  private ViewGroup getStepParentLayout(ViberIdConnectStep paramViberIdConnectStep)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mStepViewParents.get(paramViberIdConnectStep);
    if (localViewGroup == null)
      switch (1.$SwitchMap$com$viber$voip$user$viberid$connectaccount$connectsteps$ViberIdConnectStep[paramViberIdConnectStep.ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      }
    while (true)
    {
      if (localViewGroup != null)
        this.mStepViewParents.put(paramViberIdConnectStep, localViewGroup);
      return localViewGroup;
      localViewGroup = initStepViewParent(R.id.email_step_stub, R.id.email_step);
      continue;
      localViewGroup = initStepViewParent(R.id.enter_password_step_stub, R.id.enter_password_step);
      continue;
      localViewGroup = initStepViewParent(R.id.set_password_step_stub, R.id.set_password_step);
    }
  }

  private StepViewHolder getViewHolderForStep(ViberIdConnectStep paramViberIdConnectStep)
  {
    StepViewHolder localStepViewHolder = (ViberIdStepsContentView)this.mStepViewHolders.get(paramViberIdConnectStep);
    if (localStepViewHolder == null)
    {
      localStepViewHolder = paramViberIdConnectStep.creator.create(this.mActivity, this.mController, this.mRouter, this.mReachability);
      this.mStepViewHolders.put(paramViberIdConnectStep, localStepViewHolder);
    }
    return localStepViewHolder;
  }

  private ViewGroup initStepViewParent(int paramInt1, int paramInt2)
  {
    ViewStub localViewStub = (ViewStub)this.mStepsContent.findViewById(paramInt1);
    if (localViewStub == null)
      return (ViewGroup)this.mStepsContent.findViewById(paramInt2);
    return (ViewGroup)localViewStub.inflate();
  }

  private boolean isAttached()
  {
    return this.mStepsContent != null;
  }

  private ViewGroup prepareStepsContentAndGet(ViberIdConnectStep paramViberIdConnectStep)
  {
    Iterator localIterator = this.mStepViewParents.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      View localView = (View)localEntry.getValue();
      if (paramViberIdConnectStep == localEntry.getKey());
      for (boolean bool = true; ; bool = false)
      {
        dj.b(localView, bool);
        break;
      }
    }
    return getStepParentLayout(paramViberIdConnectStep);
  }

  public void attach(ViewGroup paramViewGroup, View paramView, Parcelable paramParcelable)
  {
    this.mContinueButton = paramView;
    this.mStepsContent = paramViewGroup;
    this.mPresenter.attach(this, paramParcelable);
  }

  public void attachStep(ViberIdConnectStep paramViberIdConnectStep, Parcelable paramParcelable)
  {
    getViewHolderForStep(paramViberIdConnectStep).attach(prepareStepsContentAndGet(paramViberIdConnectStep), this.mContinueButton, paramParcelable);
  }

  public void detach()
  {
    if (!isAttached())
      return;
    this.mStepsContent = null;
    this.mPresenter.detach();
    Iterator localIterator = this.mStepViewHolders.values().iterator();
    while (localIterator.hasNext())
      ((ViberIdStepsContentView)localIterator.next()).detach();
    this.mStepViewHolders.clear();
    this.mStepViewParents.clear();
    dj.d(this.mActivity);
  }

  public Parcelable getSavedState()
  {
    return this.mPresenter.getSavedState();
  }

  public StepsAnimator.ContentAnimatorProvider getViewContentAnimator()
  {
    throw new IllegalStateException("steps controller doesn't work with animation");
  }

  public void handleDialogAction(ViberIdConnectStep paramViberIdConnectStep, ViberIdStepsContentView.DialogContainer paramDialogContainer)
  {
    StepDialogContainer localStepDialogContainer = (StepDialogContainer)paramDialogContainer;
    getViewHolderForStep(paramViberIdConnectStep).onDialogAction(localStepDialogContainer.dialog, localStepDialogContainer.requestCode);
  }

  public void handleDialogShow(ViberIdConnectStep paramViberIdConnectStep, ViberIdStepsContentView.DialogContainer paramDialogContainer)
  {
    StepDialogContainer localStepDialogContainer = (StepDialogContainer)paramDialogContainer;
    getViewHolderForStep(paramViberIdConnectStep).onDialogShow(localStepDialogContainer.dialog);
  }

  public void handleFocusOutClick()
  {
    dj.a(this.mActivity, false);
  }

  public void handleFocusOutClick(ViberIdConnectStep paramViberIdConnectStep)
  {
    handleFocusOutClick();
    getViewHolderForStep(paramViberIdConnectStep).handleFocusOutClick();
  }

  public void onBackPressed(ViberIdConnectStep paramViberIdConnectStep)
  {
    if ((!this.mStepsAnimator.isAnimating()) && (!getViewHolderForStep(paramViberIdConnectStep).onBackPressed()))
      this.mPresenter.onBackPressNotHandled();
  }

  public boolean onBackPressed()
  {
    this.mPresenter.onBackPressed();
    return true;
  }

  public void onBackgroundPressed()
  {
    this.mPresenter.onBackgroundPressed();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    this.mPresenter.onDialogAction(new StepDialogContainer(paramInt, paramm));
  }

  public void onDialogShow(m paramm)
  {
    this.mPresenter.onDialogShow(new StepDialogContainer(0, paramm));
  }

  public void onLearnMoreLinkPressed()
  {
    this.mPresenter.onLearnMoreLinkPressed();
  }

  public void onTermsAndPrivacyClicked()
  {
    this.mPresenter.onTermsAndPrivacyClicked();
  }

  public void openLearnMore()
  {
    GenericWebViewActivity.a(this.mActivity, ap.c().O, this.mViberIdConnectTitle);
  }

  public void openStep(ViberIdConnectStep paramViberIdConnectStep1, ViberIdConnectStep paramViberIdConnectStep2, Bundle paramBundle)
  {
    dj.d(this.mActivity);
    StepViewHolder localStepViewHolder1 = (ViberIdStepsContentView)this.mStepViewHolders.get(paramViberIdConnectStep2);
    StepsAnimator.ContentAnimatorProvider localContentAnimatorProvider1;
    if (localStepViewHolder1 != null)
    {
      localContentAnimatorProvider1 = localStepViewHolder1.getViewContentAnimator();
      localStepViewHolder1.detach();
    }
    while (true)
    {
      StepViewHolder localStepViewHolder2 = getViewHolderForStep(paramViberIdConnectStep1);
      if (paramBundle != null)
        localStepViewHolder2.setArguments(paramBundle);
      localStepViewHolder2.attach(prepareStepsContentAndGet(paramViberIdConnectStep1), this.mContinueButton, null);
      StepsAnimator.ContentAnimatorProvider localContentAnimatorProvider2 = localStepViewHolder2.getViewContentAnimator();
      StepsAnimator localStepsAnimator;
      if (localStepViewHolder1 != null)
      {
        localStepsAnimator = this.mStepsAnimator;
        if (ViberIdConnectStep.ENTER_EMAIL != paramViberIdConnectStep2)
          break label120;
      }
      label120: for (boolean bool = true; ; bool = false)
      {
        localStepsAnimator.startAnimation(localContentAnimatorProvider1, localContentAnimatorProvider2, bool);
        return;
      }
      localContentAnimatorProvider1 = null;
    }
  }

  public void openTermsAndPrivacy()
  {
    GenericWebViewActivity.a(this.mActivity, ap.c().g(), this.mViberIdConnectTitle);
  }

  public void saveStepState(ViberIdConnectStep paramViberIdConnectStep, ViberIdStepsContentPresenter.StepStateContainer paramStepStateContainer)
  {
    paramStepStateContainer.setStepState(getViewHolderForStep(paramViberIdConnectStep).getSavedState());
  }

  public void setArguments(Bundle paramBundle)
  {
    this.mPresenter.setArguments(paramBundle);
  }

  public void setStepArguments(ViberIdConnectStep paramViberIdConnectStep, Bundle paramBundle)
  {
    getViewHolderForStep(paramViberIdConnectStep).setArguments(paramBundle);
  }

  void switchStep(ViberIdConnectStep paramViberIdConnectStep, Bundle paramBundle)
  {
    if (!isAttached())
      return;
    this.mPresenter.switchStep(paramViberIdConnectStep, paramBundle);
  }

  static class StepDialogContainer
    implements ViberIdStepsContentView.DialogContainer
  {
    final m dialog;
    final int requestCode;

    StepDialogContainer(int paramInt, m paramm)
    {
      this.requestCode = paramInt;
      this.dialog = paramm;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepViewController
 * JD-Core Version:    0.6.2
 */