package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class o<T>
{
  final int a;
  final TaskCompletionSource<T> b = new TaskCompletionSource();
  final int c;
  final Bundle d;

  o(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramBundle;
  }

  abstract void a(Bundle paramBundle);

  final void a(n paramn)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramn);
      Log.d("MessengerIpcClient", 14 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Failing " + str1 + " with " + str2);
    }
    this.b.setException(paramn);
  }

  final void a(T paramT)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramT);
      Log.d("MessengerIpcClient", 16 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Finishing " + str1 + " with " + str2);
    }
    this.b.setResult(paramT);
  }

  abstract boolean a();

  public String toString()
  {
    int i = this.c;
    int j = this.a;
    boolean bool = a();
    return 55 + "Request { what=" + i + " id=" + j + " oneWay=" + bool + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.o
 * JD-Core Version:    0.6.2
 */