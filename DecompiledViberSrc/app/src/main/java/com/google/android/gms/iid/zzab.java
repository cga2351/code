package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzab extends zzz<Bundle>
{
  zzab(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 1, paramBundle);
  }

  final void zzh(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle.getBundle("data");
    if (localBundle == null)
      localBundle = Bundle.EMPTY;
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(localBundle);
      Log.d("MessengerIpcClient", 16 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Finishing " + str1 + " with " + str2);
    }
    this.zzcq.setResult(localBundle);
  }

  final boolean zzw()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzab
 * JD-Core Version:    0.6.2
 */