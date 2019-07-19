package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class zad
  implements DeferredLifecycleHelper.zaa
{
  zad(DeferredLifecycleHelper paramDeferredLifecycleHelper, FrameLayout paramFrameLayout, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
  }

  public final int getState()
  {
    return 2;
  }

  public final void zaa(LifecycleDelegate paramLifecycleDelegate)
  {
    this.zarl.removeAllViews();
    this.zarl.addView(DeferredLifecycleHelper.zab(this.zari).onCreateView(this.zarm, this.val$container, this.zark));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.zad
 * JD-Core Version:    0.6.2
 */