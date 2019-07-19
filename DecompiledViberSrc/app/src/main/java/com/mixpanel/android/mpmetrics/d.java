package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Handler;
import com.mixpanel.android.b.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

class d
{
  private final MixpanelAPI a;
  private Context b;
  private String c;
  private int d;

  public d(MixpanelAPI paramMixpanelAPI, Context paramContext)
  {
    this.a = paramMixpanelAPI;
    this.b = paramContext;
  }

  private void b()
  {
    try
    {
      Object localObject1 = Class.forName("com.urbanairship.UAirship").getMethod("shared", null).invoke(null, new Object[0]);
      Object localObject2 = localObject1.getClass().getMethod("getPushManager", null).invoke(localObject1, new Object[0]);
      String str = (String)localObject2.getClass().getMethod("getChannelId", null).invoke(localObject2, new Object[0]);
      if ((str != null) && (!str.isEmpty()))
      {
        this.d = 0;
        if ((this.c == null) || (!this.c.equals(str)))
        {
          this.a.getPeople().a("$android_urban_airship_channel_id", str);
          this.c = str;
        }
      }
      else
      {
        this.d = (1 + this.d);
        if (this.d <= 3)
        {
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              d.a(d.this);
            }
          }
          , 2000L);
          return;
        }
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      f.d("MixpanelAPI.CnctInts", "Urban Airship SDK not found but Urban Airship is integrated on Mixpanel", localClassNotFoundException);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      f.e("MixpanelAPI.CnctInts", "Urban Airship SDK class exists but methods do not", localNoSuchMethodException);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      f.e("MixpanelAPI.CnctInts", "method invocation failed", localInvocationTargetException);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      f.e("MixpanelAPI.CnctInts", "method invocation failed", localIllegalAccessException);
    }
  }

  public void a()
  {
    this.c = null;
    this.d = 0;
  }

  public void a(Set<String> paramSet)
  {
    if (paramSet.contains("urbanairship"))
      b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.d
 * JD-Core Version:    0.6.2
 */