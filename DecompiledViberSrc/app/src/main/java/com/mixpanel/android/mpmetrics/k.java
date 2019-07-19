package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.mixpanel.android.c.g;
import java.text.NumberFormat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
class k
  implements Application.ActivityLifecycleCallbacks
{
  private static Double e;
  private Handler a = new Handler(Looper.getMainLooper());
  private Runnable b;
  private boolean c = true;
  private boolean d = true;
  private final MixpanelAPI f;
  private final i g;

  public k(MixpanelAPI paramMixpanelAPI, i parami)
  {
    this.f = paramMixpanelAPI;
    this.g = parami;
    if (e == null)
      e = Double.valueOf(System.currentTimeMillis());
  }

  // ERROR //
  private void a(android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: ldc 69
    //   8: invokevirtual 75	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   11: ifeq -7 -> 4
    //   14: aload_1
    //   15: ldc 77
    //   17: invokevirtual 75	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   20: ifeq -16 -> 4
    //   23: aload_1
    //   24: ldc 69
    //   26: invokevirtual 81	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_3
    //   30: aload_1
    //   31: ldc 77
    //   33: invokevirtual 81	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_1
    //   39: ldc 83
    //   41: invokevirtual 81	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +87 -> 135
    //   51: new 85	org/json/JSONObject
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 88	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   60: astore 6
    //   62: aload 6
    //   64: ldc 90
    //   66: aload_3
    //   67: invokestatic 95	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   70: invokevirtual 99	java/lang/Integer:intValue	()I
    //   73: invokevirtual 103	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload 6
    //   79: ldc 105
    //   81: aload 4
    //   83: invokestatic 95	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   86: invokevirtual 99	java/lang/Integer:intValue	()I
    //   89: invokevirtual 103	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   92: pop
    //   93: aload 6
    //   95: ldc 107
    //   97: ldc 109
    //   99: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   102: pop
    //   103: aload_0
    //   104: getfield 46	com/mixpanel/android/mpmetrics/k:f	Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
    //   107: ldc 114
    //   109: aload 6
    //   111: invokevirtual 120	com/mixpanel/android/mpmetrics/MixpanelAPI:track	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   114: aload_1
    //   115: ldc 69
    //   117: invokevirtual 123	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   120: aload_1
    //   121: ldc 77
    //   123: invokevirtual 123	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   126: aload_1
    //   127: ldc 83
    //   129: invokevirtual 123	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   132: return
    //   133: astore_2
    //   134: return
    //   135: new 85	org/json/JSONObject
    //   138: dup
    //   139: invokespecial 124	org/json/JSONObject:<init>	()V
    //   142: astore 6
    //   144: goto -82 -> 62
    //   147: astore 7
    //   149: goto -35 -> 114
    //
    // Exception table:
    //   from	to	target	type
    //   5	46	133	java/lang/Throwable
    //   51	62	133	java/lang/Throwable
    //   62	114	133	java/lang/Throwable
    //   114	132	133	java/lang/Throwable
    //   135	144	133	java/lang/Throwable
    //   51	62	147	org/json/JSONException
    //   62	114	147	org/json/JSONException
    //   135	144	147	org/json/JSONException
  }

  protected boolean a()
  {
    return this.c;
  }

  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityDestroyed(Activity paramActivity)
  {
  }

  public void onActivityPaused(Activity paramActivity)
  {
    this.d = true;
    if (this.b != null)
      this.a.removeCallbacks(this.b);
    Handler localHandler = this.a;
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if ((k.a(k.this)) && (k.b(k.this)))
          k.a(k.this, false);
        try
        {
          double d = System.currentTimeMillis() - k.b().doubleValue();
          if ((d >= k.c(k.this).v()) && (d < k.c(k.this).w()))
          {
            NumberFormat localNumberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
            localNumberFormat.setMaximumFractionDigits(1);
            String str = localNumberFormat.format((System.currentTimeMillis() - k.b().doubleValue()) / 1000.0D);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("$ae_session_length", str);
            k.d(k.this).track("$ae_session", localJSONObject, true);
          }
          k.d(k.this).onBackground();
          return;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            localJSONException.printStackTrace();
        }
      }
    };
    this.b = local1;
    localHandler.postDelayed(local1, 500L);
  }

  public void onActivityResumed(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (this.g.q()))
      this.f.getPeople().e();
    this.d = false;
    boolean bool = this.c;
    int i = 0;
    if (!bool)
      i = 1;
    this.c = true;
    if (this.b != null)
      this.a.removeCallbacks(this.b);
    if (i != 0)
    {
      e = Double.valueOf(System.currentTimeMillis());
      this.f.onForeground();
    }
  }

  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity.getIntent());
    if ((Build.VERSION.SDK_INT >= 16) && (this.g.q()))
      this.f.getPeople().a(paramActivity);
    new g(this.f, paramActivity);
  }

  public void onActivityStopped(Activity paramActivity)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.k
 * JD-Core Version:    0.6.2
 */