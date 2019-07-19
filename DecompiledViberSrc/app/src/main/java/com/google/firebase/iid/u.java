package com.google.firebase.iid;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class u
{
  private final Executor a;

  @GuardedBy("this")
  private final Map<Pair<String, String>, Task<a>> b = new ArrayMap();

  u(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }

  final Task<a> a(String paramString1, String paramString2, w paramw)
  {
    try
    {
      Pair localPair = new Pair(paramString1, paramString2);
      Task localTask = (Task)this.b.get(localPair);
      if (localTask != null)
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          String str1 = String.valueOf(localPair);
          Log.d("FirebaseInstanceId", 29 + String.valueOf(str1).length() + "Joining ongoing request for: " + str1);
        }
      while (true)
      {
        return localTask;
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          String str2 = String.valueOf(localPair);
          Log.d("FirebaseInstanceId", 24 + String.valueOf(str2).length() + "Making new request for: " + str2);
        }
        localTask = paramw.a().continueWithTask(this.a, new t(this, localPair));
        this.b.put(localPair, localTask);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.u
 * JD-Core Version:    0.6.2
 */