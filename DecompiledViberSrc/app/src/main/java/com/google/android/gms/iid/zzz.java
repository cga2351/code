package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzz<T>
{
  final int what;
  final int zzcp;
  final TaskCompletionSource<T> zzcq = new TaskCompletionSource();
  final Bundle zzcr;

  zzz(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.zzcp = paramInt1;
    this.what = paramInt2;
    this.zzcr = paramBundle;
  }

  public String toString()
  {
    int i = this.what;
    int j = this.zzcp;
    zzw();
    return 55 + "Request { what=" + i + " id=" + j + " oneWay=false}";
  }

  final void zzd(zzaa paramzzaa)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramzzaa);
      Log.d("MessengerIpcClient", 14 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Failing " + str1 + " with " + str2);
    }
    this.zzcq.setException(paramzzaa);
  }

  abstract void zzh(Bundle paramBundle);

  abstract boolean zzw();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzz
 * JD-Core Version:    0.6.2
 */