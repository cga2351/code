package com.viber.voip.user.viberid.connectaccount.connectsteps;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.j;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.StepsAnimator.ContentAnimatorProvider;

abstract interface StepViewHolder extends m.c, m.j
{
  public abstract void attach(ViewGroup paramViewGroup, View paramView, Parcelable paramParcelable);

  public abstract void detach();

  public abstract Parcelable getSavedState();

  public abstract StepsAnimator.ContentAnimatorProvider getViewContentAnimator();

  public abstract void handleFocusOutClick();

  public abstract boolean onBackPressed();

  public abstract void setArguments(Bundle paramBundle);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.StepViewHolder
 * JD-Core Version:    0.6.2
 */