package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zan
  implements Runnable
{
  private final zam zadi;

  zan(zal paramzal, zam paramzam)
  {
    this.zadi = paramzam;
  }

  public final void run()
  {
    if (!this.zadj.mStarted)
      return;
    ConnectionResult localConnectionResult = this.zadi.getConnectionResult();
    if (localConnectionResult.hasResolution())
    {
      this.zadj.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(this.zadj.getActivity(), localConnectionResult.getResolution(), this.zadi.zar(), false), 1);
      return;
    }
    if (this.zadj.zacc.isUserResolvableError(localConnectionResult.getErrorCode()))
    {
      this.zadj.zacc.zaa(this.zadj.getActivity(), this.zadj.mLifecycleFragment, localConnectionResult.getErrorCode(), 2, this.zadj);
      return;
    }
    if (localConnectionResult.getErrorCode() == 18)
    {
      Dialog localDialog = GoogleApiAvailability.zaa(this.zadj.getActivity(), this.zadj);
      this.zadj.zacc.zaa(this.zadj.getActivity().getApplicationContext(), new zao(this, localDialog));
      return;
    }
    this.zadj.zaa(localConnectionResult, this.zadi.zar());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zan
 * JD-Core Version:    0.6.2
 */