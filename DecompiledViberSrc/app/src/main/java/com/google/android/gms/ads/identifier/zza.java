package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class zza extends Thread
{
  zza(AdvertisingIdClient paramAdvertisingIdClient, Map paramMap)
  {
  }

  public final void run()
  {
    new zzc();
    Map localMap = this.zzl;
    Uri.Builder localBuilder = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str4 = (String)localIterator.next();
      localBuilder.appendQueryParameter(str4, (String)localMap.get(str4));
    }
    String str1 = localBuilder.build().toString();
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str1).openConnection();
      try
      {
        int i = localHttpURLConnection.getResponseCode();
        if ((i < 200) || (i >= 300))
          Log.w("HttpUrlPinger", 65 + String.valueOf(str1).length() + "Received non-success response code " + i + " from pinging URL: " + str1);
        return;
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      String str3 = localIndexOutOfBoundsException.getMessage();
      Log.w("HttpUrlPinger", 32 + String.valueOf(str1).length() + String.valueOf(str3).length() + "Error while parsing ping URL: " + str1 + ". " + str3, localIndexOutOfBoundsException);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      String str2 = localRuntimeException.getMessage();
      Log.w("HttpUrlPinger", 27 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Error while pinging URL: " + str1 + ". " + str2, localRuntimeException);
      return;
    }
    catch (IOException localIOException)
    {
      label260: break label260;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.zza
 * JD-Core Version:    0.6.2
 */