package com.appnexus.opensdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;
import com.appnexus.opensdk.utils.HttpErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SharedNetworkManager
{
  private static SharedNetworkManager a;
  private ArrayList<a> b = new ArrayList();
  private Timer c;
  private boolean d;

  private SharedNetworkManager(Context paramContext)
  {
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      return;
    }
  }

  private void a()
  {
    if (this.c != null)
    {
      this.c.cancel();
      this.c = null;
    }
  }

  private void a(Context paramContext)
  {
    if (this.c == null)
    {
      final WeakReference localWeakReference = new WeakReference(paramContext);
      this.c = new Timer();
      this.c.scheduleAtFixedRate(new TimerTask()
      {
        public void run()
        {
          Context localContext = (Context)localWeakReference.get();
          if (localContext != null)
          {
            while ((!SharedNetworkManager.a(SharedNetworkManager.this).isEmpty()) && (SharedNetworkManager.this.isConnected(localContext)))
            {
              final SharedNetworkManager.a locala = (SharedNetworkManager.a)SharedNetworkManager.a(SharedNetworkManager.this).remove(0);
              if (locala.b < 3)
                new HTTPGet()
                {
                  protected String a()
                  {
                    return locala.a;
                  }

                  protected void a(HTTPResponse paramAnonymous2HTTPResponse)
                  {
                    if ((paramAnonymous2HTTPResponse == null) || ((!paramAnonymous2HTTPResponse.getSucceeded()) && (paramAnonymous2HTTPResponse.getErrorCode() == HttpErrorCode.CONNECTION_FAILURE)))
                    {
                      SharedNetworkManager.a locala = locala;
                      locala.b = (1 + locala.b);
                      SharedNetworkManager.a(SharedNetworkManager.this).add(locala);
                      return;
                    }
                    Clog.d(Clog.baseLogTag, "SharedNetworkManager Retry Successful");
                  }
                }
                .execute(new Void[0]);
            }
            if (SharedNetworkManager.a(SharedNetworkManager.this).isEmpty())
              SharedNetworkManager.b(SharedNetworkManager.this);
            return;
          }
          SharedNetworkManager.b(SharedNetworkManager.this);
        }
      }
      , 10000L, 10000L);
    }
  }

  public static SharedNetworkManager getInstance(Context paramContext)
  {
    if (a == null)
      a = new SharedNetworkManager(paramContext);
    return a;
  }

  void a(String paramString, Context paramContext)
  {
    try
    {
      Clog.d(Clog.baseLogTag, "SharedNetworkManager adding URL for Network Retry");
      this.b.add(new a(paramString));
      a(paramContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isConnected(Context paramContext)
  {
    if (this.d)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
    }
    return true;
  }

  class a
  {
    String a;
    int b;

    a(String arg2)
    {
      Object localObject;
      this.a = localObject;
      this.b = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.SharedNetworkManager
 * JD-Core Version:    0.6.2
 */