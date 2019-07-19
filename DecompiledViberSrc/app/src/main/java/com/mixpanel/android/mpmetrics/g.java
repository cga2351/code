package com.mixpanel.android.mpmetrics;

import android.os.Process;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  implements Thread.UncaughtExceptionHandler
{
  private static g a;
  private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

  public g()
  {
    Thread.setDefaultUncaughtExceptionHandler(this);
  }

  public static void a()
  {
    if (a == null)
      try
      {
        if (a == null)
          a = new g();
        return;
      }
      finally
      {
      }
  }

  private void b()
  {
    try
    {
      Thread.sleep(400L);
      Process.killProcess(Process.myPid());
      System.exit(10);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        localInterruptedException.printStackTrace();
    }
  }

  public void uncaughtException(Thread paramThread, final Throwable paramThrowable)
  {
    MixpanelAPI.allInstances(new MixpanelAPI.a()
    {
      public void a(MixpanelAPI paramAnonymousMixpanelAPI)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("$ae_crashed_reason", paramThrowable.toString());
          paramAnonymousMixpanelAPI.track("$ae_crashed", localJSONObject, true);
          return;
        }
        catch (JSONException localJSONException)
        {
        }
      }
    });
    MixpanelAPI.allInstances(new MixpanelAPI.a()
    {
      public void a(MixpanelAPI paramAnonymousMixpanelAPI)
      {
        paramAnonymousMixpanelAPI.flushNoDecideCheck();
      }
    });
    if (this.b != null)
    {
      this.b.uncaughtException(paramThread, paramThrowable);
      return;
    }
    b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.g
 * JD-Core Version:    0.6.2
 */