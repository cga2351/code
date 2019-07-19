package com.google.android.gms.common.api.internal;

import android.os.Handler;

final class zabi
  implements BackgroundDetector.BackgroundStateChangeListener
{
  zabi(GoogleApiManager paramGoogleApiManager)
  {
  }

  public final void onBackgroundStateChanged(boolean paramBoolean)
  {
    GoogleApiManager.zaa(this.zail).sendMessage(GoogleApiManager.zaa(this.zail).obtainMessage(1, Boolean.valueOf(paramBoolean)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zabi
 * JD-Core Version:    0.6.2
 */