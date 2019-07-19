package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

final class zaf
  implements BaseGmsClient.BaseConnectionCallbacks
{
  zaf(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
  }

  public final void onConnected(Bundle paramBundle)
  {
    this.zaoi.onConnected(paramBundle);
  }

  public final void onConnectionSuspended(int paramInt)
  {
    this.zaoi.onConnectionSuspended(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zaf
 * JD-Core Version:    0.6.2
 */