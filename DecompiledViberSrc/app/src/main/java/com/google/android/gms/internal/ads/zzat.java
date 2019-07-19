package com.google.android.gms.internal.ads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;

public final class zzat extends zzaj
{
  private final zzav zzcj = null;
  private final SSLSocketFactory zzck = null;

  public zzat()
  {
    this(null);
  }

  private zzat(zzav paramzzav)
  {
    this(null, null);
  }

  private zzat(zzav paramzzav, SSLSocketFactory paramSSLSocketFactory)
  {
  }

  private static InputStream zza(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      return localInputStream;
    }
    catch (IOException localIOException)
    {
    }
    return paramHttpURLConnection.getErrorStream();
  }

  private static List<zzl> zza(Map<String, List<String>> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (localEntry.getKey() != null)
      {
        Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          localArrayList.add(new zzl((String)localEntry.getKey(), str));
        }
      }
    }
    return localArrayList;
  }

  private static void zza(HttpURLConnection paramHttpURLConnection, zzr<?> paramzzr)
    throws IOException, zza
  {
    byte[] arrayOfByte = paramzzr.zzg();
    String str1;
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      if (!paramHttpURLConnection.getRequestProperties().containsKey("Content-Type"))
      {
        str1 = String.valueOf("UTF-8");
        if (str1.length() == 0)
          break label82;
      }
    }
    label82: for (String str2 = "application/x-www-form-urlencoded; charset=".concat(str1); ; str2 = new String("application/x-www-form-urlencoded; charset="))
    {
      paramHttpURLConnection.setRequestProperty("Content-Type", str2);
      DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      localDataOutputStream.write(arrayOfByte);
      localDataOutputStream.close();
      return;
    }
  }

  public final zzar zza(zzr<?> paramzzr, Map<String, String> paramMap)
    throws IOException, zza
  {
    String str1 = paramzzr.getUrl();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    localHashMap.putAll(paramzzr.getHeaders());
    String str2;
    if (this.zzcj != null)
    {
      str2 = this.zzcj.zzg(str1);
      if (str2 == null)
      {
        String str4 = String.valueOf(str1);
        if (str4.length() != 0);
        for (String str5 = "URL blocked by rewriter: ".concat(str4); ; str5 = new String("URL blocked by rewriter: "))
          throw new IOException(str5);
      }
    }
    else
    {
      str2 = str1;
    }
    URL localURL = new URL(str2);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
    localHttpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    int i = paramzzr.zzi();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    "https".equals(localURL.getProtocol());
    int j;
    try
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        localHttpURLConnection.setRequestProperty(str3, (String)localHashMap.get(str3));
      }
    }
    finally
    {
      j = 0;
    }
    if (j == 0)
      localHttpURLConnection.disconnect();
    throw localObject1;
    switch (paramzzr.getMethod())
    {
    default:
      throw new IllegalStateException("Unknown method type.");
    case 0:
      localHttpURLConnection.setRequestMethod("GET");
    case -1:
    case 3:
    case 1:
    case 2:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    int k;
    while (true)
    {
      k = localHttpURLConnection.getResponseCode();
      if (k != -1)
        break;
      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      localHttpURLConnection.setRequestMethod("DELETE");
      continue;
      localHttpURLConnection.setRequestMethod("POST");
      zza(localHttpURLConnection, paramzzr);
      continue;
      localHttpURLConnection.setRequestMethod("PUT");
      zza(localHttpURLConnection, paramzzr);
      continue;
      localHttpURLConnection.setRequestMethod("HEAD");
      continue;
      localHttpURLConnection.setRequestMethod("OPTIONS");
      continue;
      localHttpURLConnection.setRequestMethod("TRACE");
      continue;
      localHttpURLConnection.setRequestMethod("PATCH");
      zza(localHttpURLConnection, paramzzr);
    }
    if (paramzzr.getMethod() != 4)
    {
      if (100 > k)
        break label536;
      if (k >= 200)
        break label536;
    }
    while (true)
    {
      label454: if (m == 0)
      {
        zzar localzzar1 = new zzar(k, zza(localHttpURLConnection.getHeaderFields()));
        localHttpURLConnection.disconnect();
        return localzzar1;
      }
      label536: 
      do
      {
        m = 0;
        break label454;
        try
        {
          zzar localzzar2 = new zzar(k, zza(localHttpURLConnection.getHeaderFields()), localHttpURLConnection.getContentLength(), new zzau(localHttpURLConnection));
          return localzzar2;
        }
        finally
        {
          j = 1;
        }
        break;
      }
      while ((k == 204) || (k == 304));
      int m = 1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzat
 * JD-Core Version:    0.6.2
 */