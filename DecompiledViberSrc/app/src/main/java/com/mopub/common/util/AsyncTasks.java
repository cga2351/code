package com.mopub.common.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.concurrent.Executor;

public class AsyncTasks
{
  private static Executor a;
  private static Handler b;

  static
  {
    b();
  }

  private static void b()
  {
    a = AsyncTask.THREAD_POOL_EXECUTOR;
    b = new Handler(Looper.getMainLooper());
  }

  public static <P> void safeExecuteOnExecutor(AsyncTask<P, ?, ?> paramAsyncTask, final P[] paramArrayOfP)
  {
    Preconditions.checkNotNull(paramAsyncTask, "Unable to execute null AsyncTask.");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramAsyncTask.executeOnExecutor(a, paramArrayOfP);
      return;
    }
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Posting AsyncTask to main thread for execution." });
    b.post(new Runnable()
    {
      public void run()
      {
        this.a.executeOnExecutor(AsyncTasks.a(), paramArrayOfP);
      }
    });
  }

  @VisibleForTesting
  public static void setExecutor(Executor paramExecutor)
  {
    a = paramExecutor;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.AsyncTasks
 * JD-Core Version:    0.6.2
 */