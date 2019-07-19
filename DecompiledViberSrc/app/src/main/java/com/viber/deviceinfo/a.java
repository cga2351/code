package com.viber.deviceinfo;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.e;
import com.viber.voip.settings.d.f;
import com.viber.voip.util.da;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a
{
  private static final a a = new a();
  private static volatile boolean b = false;
  private static Logger c = ViberEnv.getLogger();
  private Context d = null;
  private a e = a.c;
  private CountDownLatch f = null;

  public static a a()
  {
    return a;
  }

  private String a(boolean paramBoolean)
  {
    if ((!d.f.d.d()) && (!paramBoolean))
      return "";
    if (!b)
    {
      c.a(new RuntimeException("AdvertisingIdInfoController not initialized "), "Ask for SyncAdvertisingID without initialization");
      return d.e.a.d();
    }
    if ((g() == a.b) && (this.f != null));
    try
    {
      this.f.await(3L, TimeUnit.SECONDS);
      this.f.countDown();
      while (true)
      {
        label86: return d.e.a.d();
        if ((g() == a.d) && (da.a(d.e.a.d())))
          f();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label86;
    }
  }

  public static void a(Context paramContext)
  {
    try
    {
      if (!b)
      {
        b = true;
        a.d = paramContext.getApplicationContext();
        if (a.g() == a.c)
          a.f();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(a parama)
  {
    this.e = parama;
  }

  private void f()
  {
    a(a.b);
    this.f = new CountDownLatch(1);
    new b(null).start();
  }

  private a g()
  {
    return this.e;
  }

  public String b()
  {
    String str;
    if (!d.f.d.d())
      str = "";
    do
    {
      return str;
      str = d.e.a.d();
    }
    while (!da.a(str));
    return d();
  }

  public boolean c()
  {
    return d.e.b.d();
  }

  public String d()
  {
    return a(false);
  }

  public String e()
  {
    return a(true);
  }

  static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }
  }

  private class b extends Thread
  {
    private b()
    {
    }

    public void run()
    {
      a.a locala1 = a.a.a;
      while (true)
      {
        try
        {
          AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.a(a.this));
          String str;
          if (localInfo != null)
          {
            str = localInfo.getId();
            if (localInfo == null)
              break label280;
            if (localInfo.isLimitAdTrackingEnabled())
            {
              break label280;
              d.e.a.a(str);
              d.e.b.a(bool);
            }
          }
          else
          {
            str = "";
            continue;
          }
          bool = false;
          continue;
        }
        catch (IOException localIOException)
        {
          a.a locala5 = a.a.d;
          return;
        }
        catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
        {
          a.a locala4 = a.a.e;
          return;
        }
        catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
        {
          a.a locala3 = a.a.d;
          return;
        }
        catch (Exception localException)
        {
          a.a locala2 = a.a.d;
          return;
        }
        finally
        {
          a.a(a.this, locala1);
          if (a.b(a.this) != null)
            a.b(a.this).countDown();
        }
        label280: boolean bool = true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.deviceinfo.a
 * JD-Core Version:    0.6.2
 */