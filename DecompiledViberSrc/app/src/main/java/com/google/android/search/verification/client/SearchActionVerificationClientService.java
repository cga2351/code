package com.google.android.search.verification.client;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.android.search.verification.a.a;
import com.google.android.search.verification.a.a.a;
import java.util.Iterator;
import java.util.Set;

public abstract class SearchActionVerificationClientService extends IntentService
{
  private final boolean a = c();
  private final long b;
  private final Intent c = new Intent("com.google.android.googlequicksearchbox.SEARCH_ACTION_VERIFICATION_SERVICE").setPackage("com.google.android.googlequicksearchbox");
  private a d;
  private a e = null;

  public SearchActionVerificationClientService()
  {
    super("SearchActionVerificationClientService");
    if (b())
      this.c.setPackage("com.google.verificationdemo.fakeverification");
    this.b = a();
  }

  private static void a(Intent paramIntent)
  {
    Log.d("SAVerificationClientS", "Intent:");
    String str1 = String.valueOf(paramIntent);
    Log.d("SAVerificationClientS", 1 + String.valueOf(str1).length() + "\t" + str1);
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle != null)
    {
      Log.d("SAVerificationClientS", "Extras:");
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str2;
        arrayOfObject[1] = localBundle.get(str2);
        Log.d("SAVerificationClientS", String.format("\t%s: %s", arrayOfObject));
      }
    }
  }

  private boolean c()
  {
    return (b()) || (!"user".equals(Build.TYPE));
  }

  private boolean d()
  {
    return this.e != null;
  }

  private boolean e()
  {
    try
    {
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo("com.google.android.googlequicksearchbox", 64);
      if ((localPackageInfo.signatures == null) || (localPackageInfo.signatures.length != 1))
      {
        if (this.a)
        {
          Log.d("SAVerificationClientS", "Wrong number of signatures returned");
          return false;
        }
      }
      else
      {
        boolean bool = Base64.encodeToString(localPackageInfo.signatures[0].toByteArray(), 2).equals("MIIEQzCCAyugAwIBAgIJAMLgh0ZkSjCNMA0GCSqGSIb3DQEBBAUAMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDAeFw0wODA4MjEyMzEzMzRaFw0zNjAxMDcyMzEzMzRaMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBAKtWLgDYO6IIrgqWbxJOKdoR8qtW0I9Y4sypEwPpt1TTcvZApxsdyxMJZ2JORland2qSGT2y5b+3JKkedxiLDmpHpDsz2WCbdxgxRczfey5YZnTJ4VZbH0xqWVW/8lGmPav5xVwnIiJS6HXk+BVKZF+JcWjAsb/GEuq/eFdpuzSqeYTcfi6idkyugwfYwXFU1+5fZKUaRKYCwkkFQVfcAs1fXA5V+++FGfvjJ/CxURaSxaBvGdGDhfXE28LWuT9ozCl5xw4Yq5OGazvV24mZVSoOO0yZ31j7kYvtwYK6NeADwbSxDdJEqO4k//0zOHKrUiGYXtqw/A0LFFtqoZKFjnkCAQOjgdkwgdYwHQYDVR0OBBYEFMd9jMIhF1Ylmn/Tgt9r45jk14alMIGmBgNVHSMEgZ4wgZuAFMd9jMIhF1Ylmn/Tgt9r45jk14aloXikdjB0MQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEUMBIGA1UEChMLR29vZ2xlIEluYy4xEDAOBgNVBAsTB0FuZHJvaWQxEDAOBgNVBAMTB0FuZHJvaWSCCQDC4IdGZEowjTAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBAUAA4IBAQBt0lLO74UwLDYKqs6Tm8/yzKkEu116FmH4rkaymUIE0P9KaMftGlMexFlaYjzmB2OxZyl6euNXEsQH8gjwyxCUKRJNexBiGcCEyj6z+a1fuHHvkiaai+KL8W1EyNmgjmyy8AW7P+LLlkR+ho5zEHatRbM/YAnqGcFh5iZBqpknHf1SKMXFh4dd239FJ1jWYfbMDMy3NS5CTMQ2XFI1MvcyUTdZPErjQfTbQe3aDQsQcafEQPD+nqActifKZ0Np0IS9L9kR/wbNvyz6ENwPiTrjV2KRkEjH78ZMcUQXg0L3BYHJ3lc69Vs5Ddf9uUGGMYldX3WfMBEmh/9iFBDAaTCK");
        return bool;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (this.a)
      {
        String str = String.valueOf(localNameNotFoundException);
        Log.d("SAVerificationClientS", 34 + String.valueOf(str).length() + "Unexpected NameNotFoundException: " + str);
      }
    }
    return false;
  }

  public long a()
  {
    return 1000L;
  }

  public abstract boolean a(Intent paramIntent, boolean paramBoolean, Bundle paramBundle);

  public boolean b()
  {
    return false;
  }

  public final void onCreate()
  {
    if (this.a)
      Log.d("SAVerificationClientS", "onCreate");
    super.onCreate();
    this.d = new a();
    bindService(this.c, this.d, 1);
  }

  public final void onDestroy()
  {
    if (this.a)
      Log.d("SAVerificationClientS", "onDestroy");
    super.onDestroy();
    unbindService(this.d);
  }

  protected final void onHandleIntent(Intent paramIntent)
  {
    boolean bool1 = true;
    if (paramIntent == null)
      if (this.a)
        Log.d("SAVerificationClientS", "Unable to verify null intent");
    do
    {
      return;
      if ((c()) || (e()));
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        long l = System.nanoTime();
        while ((!d()) && (System.nanoTime() - l < 1000000L * this.b))
        {
          try
          {
            Thread.sleep(50L);
          }
          catch (InterruptedException localInterruptedException)
          {
          }
          if (this.a)
          {
            String str5 = String.valueOf(localInterruptedException);
            Log.d("SAVerificationClientS", 33 + String.valueOf(str5).length() + "Unexpected InterruptedException: " + str5);
          }
        }
      }
      if (!d())
        break;
      if (paramIntent.hasExtra("SearchActionVerificationClientExtraIntent"))
      {
        Intent localIntent = (Intent)paramIntent.getParcelableExtra("SearchActionVerificationClientExtraIntent");
        if (this.a)
          a(localIntent);
        String str3;
        try
        {
          int i = this.e.a();
          Log.i("SAVerificationClientS", 24 + "API version: " + i);
          Bundle localBundle = new Bundle();
          if ((bool2) && (this.e.a(localIntent, localBundle)))
          {
            a(localIntent, bool1, localBundle);
            return;
          }
        }
        catch (RemoteException localRemoteException)
        {
          str3 = String.valueOf(localRemoteException.getMessage());
          if (str3.length() == 0);
        }
        for (String str4 = "Remote exception: ".concat(str3); ; str4 = new String("Remote exception: "))
        {
          Log.e("SAVerificationClientS", str4);
          return;
          bool1 = false;
          break;
        }
      }
    }
    while (!this.a);
    String str2 = String.valueOf(paramIntent);
    Log.d("SAVerificationClientS", 28 + String.valueOf(str2).length() + "No extra, nothing to check: " + str2);
    return;
    String str1 = String.valueOf(paramIntent);
    Log.e("SAVerificationClientS", 62 + String.valueOf(str1).length() + "VerificationService is not connected, unable to check intent: " + str1);
  }

  class a
    implements ServiceConnection
  {
    a()
    {
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (SearchActionVerificationClientService.a(SearchActionVerificationClientService.this))
        Log.d("SAVerificationClientS", "onServiceConnected");
      SearchActionVerificationClientService.a(SearchActionVerificationClientService.this, a.a.a(paramIBinder));
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      SearchActionVerificationClientService.a(SearchActionVerificationClientService.this, null);
      if (SearchActionVerificationClientService.a(SearchActionVerificationClientService.this))
        Log.d("SAVerificationClientS", "onServiceDisconnected");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.search.verification.client.SearchActionVerificationClientService
 * JD-Core Version:    0.6.2
 */