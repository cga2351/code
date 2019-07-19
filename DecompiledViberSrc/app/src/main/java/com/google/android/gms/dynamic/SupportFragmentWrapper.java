package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub
{
  private Fragment zzic;

  private SupportFragmentWrapper(Fragment paramFragment)
  {
    this.zzic = paramFragment;
  }

  @KeepForSdk
  public static SupportFragmentWrapper wrap(Fragment paramFragment)
  {
    if (paramFragment != null)
      return new SupportFragmentWrapper(paramFragment);
    return null;
  }

  public final Bundle getArguments()
  {
    return this.zzic.getArguments();
  }

  public final int getId()
  {
    return this.zzic.getId();
  }

  public final boolean getRetainInstance()
  {
    return this.zzic.getRetainInstance();
  }

  public final String getTag()
  {
    return this.zzic.getTag();
  }

  public final int getTargetRequestCode()
  {
    return this.zzic.getTargetRequestCode();
  }

  public final boolean getUserVisibleHint()
  {
    return this.zzic.getUserVisibleHint();
  }

  public final boolean isAdded()
  {
    return this.zzic.isAdded();
  }

  public final boolean isDetached()
  {
    return this.zzic.isDetached();
  }

  public final boolean isHidden()
  {
    return this.zzic.isHidden();
  }

  public final boolean isInLayout()
  {
    return this.zzic.isInLayout();
  }

  public final boolean isRemoving()
  {
    return this.zzic.isRemoving();
  }

  public final boolean isResumed()
  {
    return this.zzic.isResumed();
  }

  public final boolean isVisible()
  {
    return this.zzic.isVisible();
  }

  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzic.setHasOptionsMenu(paramBoolean);
  }

  public final void setMenuVisibility(boolean paramBoolean)
  {
    this.zzic.setMenuVisibility(paramBoolean);
  }

  public final void setRetainInstance(boolean paramBoolean)
  {
    this.zzic.setRetainInstance(paramBoolean);
  }

  public final void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzic.setUserVisibleHint(paramBoolean);
  }

  public final void startActivity(Intent paramIntent)
  {
    this.zzic.startActivity(paramIntent);
  }

  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzic.startActivityForResult(paramIntent, paramInt);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper)
  {
    View localView = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzic.registerForContextMenu(localView);
  }

  public final IObjectWrapper zzad()
  {
    return ObjectWrapper.wrap(this.zzic.getActivity());
  }

  public final IFragmentWrapper zzae()
  {
    return wrap(this.zzic.getParentFragment());
  }

  public final IObjectWrapper zzaf()
  {
    return ObjectWrapper.wrap(this.zzic.getResources());
  }

  public final IFragmentWrapper zzag()
  {
    return wrap(this.zzic.getTargetFragment());
  }

  public final IObjectWrapper zzah()
  {
    return ObjectWrapper.wrap(this.zzic.getView());
  }

  public final void zzb(IObjectWrapper paramIObjectWrapper)
  {
    View localView = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzic.unregisterForContextMenu(localView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.SupportFragmentWrapper
 * JD-Core Version:    0.6.2
 */