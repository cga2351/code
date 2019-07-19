package com.my.target;

import android.content.Context;
import android.os.Looper;
import java.lang.reflect.Method;

public class an extends al
{
  private boolean a = false;

  private void b(Context paramContext)
  {
    dp.a("send google AId");
    try
    {
      Class localClass = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      int i;
      StringBuilder localStringBuilder2;
      if (localClass != null)
      {
        Method localMethod1 = localClass.getMethod("getAdvertisingIdInfo", new Class[] { Context.class });
        if (localMethod1 != null)
        {
          Object localObject = localMethod1.invoke(null, new Object[] { paramContext });
          if (localObject != null)
          {
            Method localMethod2 = localObject.getClass().getMethod("getId", new Class[0]);
            if (localMethod2 != null)
            {
              String str = (String)localMethod2.invoke(localObject, new Object[0]);
              a("advertising_id", str);
              dp.a("google AId: " + str);
            }
            Method localMethod3 = localObject.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
            if (localMethod3 != null)
            {
              boolean bool1 = ((Boolean)localMethod3.invoke(localObject, new Object[0])).booleanValue();
              StringBuilder localStringBuilder1 = new StringBuilder();
              if (!bool1)
                break label242;
              i = 0;
              a("advertising_tracking_enabled", i + "");
              localStringBuilder2 = new StringBuilder().append("ad tracking enabled: ");
              if (bool1)
                break label248;
            }
          }
        }
      }
      label242: label248: for (boolean bool2 = true; ; bool2 = false)
      {
        dp.a(bool2);
        return;
        i = 1;
        break;
      }
    }
    catch (Throwable localThrowable)
    {
      dp.a(localThrowable.toString());
      dp.a("failed to send google AId");
    }
  }

  public void a(Context paramContext)
  {
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper())
        dp.a("You must not call collectData method from main thread");
      while (true)
      {
        return;
        if (!this.a)
        {
          b(paramContext);
          this.a = true;
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.an
 * JD-Core Version:    0.6.2
 */