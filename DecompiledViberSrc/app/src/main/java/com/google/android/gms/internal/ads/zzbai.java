package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzare
public final class zzbai
  implements zzazx
{
  private final String zzapq;

  public zzbai()
  {
    this(null);
  }

  public zzbai(String paramString)
  {
    this.zzapq = paramString;
  }

  public final void zzed(String paramString)
  {
    try
    {
      String str4 = String.valueOf(paramString);
      if (str4.length() != 0)
      {
        str5 = "Pinging URL: ".concat(str4);
        zzbae.zzdp(str5);
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      try
      {
        while (true)
        {
          zzyr.zzpa();
          zzazu.zza(true, localHttpURLConnection, this.zzapq);
          zzazy localzzazy = new zzazy();
          localzzazy.zza(localHttpURLConnection, null);
          int i = localHttpURLConnection.getResponseCode();
          localzzazy.zza(localHttpURLConnection, i);
          if ((i < 200) || (i >= 300))
            zzbae.zzep(65 + String.valueOf(paramString).length() + "Received non-success response code " + i + " from pinging URL: " + paramString);
          return;
          String str5 = new String("Pinging URL: ");
        }
        localIndexOutOfBoundsException = localIndexOutOfBoundsException;
        String str3 = localIndexOutOfBoundsException.getMessage();
        zzbae.zzep(32 + String.valueOf(paramString).length() + String.valueOf(str3).length() + "Error while parsing ping URL: " + paramString + ". " + str3);
        return;
      }
      finally
      {
        HttpURLConnection localHttpURLConnection;
        localHttpURLConnection.disconnect();
      }
    }
    catch (IOException localIOException)
    {
      String str2 = localIOException.getMessage();
      zzbae.zzep(27 + String.valueOf(paramString).length() + String.valueOf(str2).length() + "Error while pinging URL: " + paramString + ". " + str2);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      String str1 = localRuntimeException.getMessage();
      zzbae.zzep(27 + String.valueOf(paramString).length() + String.valueOf(str1).length() + "Error while pinging URL: " + paramString + ". " + str1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbai
 * JD-Core Version:    0.6.2
 */