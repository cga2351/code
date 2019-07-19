package com.mopub.common;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.network.Networking;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public abstract class MoPubHttpUrlConnection extends HttpURLConnection
{
  static boolean a(String paramString)
  {
    try
    {
      URLDecoder.decode(paramString, "UTF-8");
      return false;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Url is improperly encoded: " + paramString);
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return true;
  }

  static boolean b(String paramString)
  {
    try
    {
      new URI(paramString);
      return false;
    }
    catch (URISyntaxException localURISyntaxException)
    {
    }
    return true;
  }

  static URI c(String paramString)
    throws Exception
  {
    try
    {
      URL localURL = new URL(paramString);
      URI localURI = new URI(localURL.getProtocol(), localURL.getUserInfo(), localURL.getHost(), localURL.getPort(), localURL.getPath(), localURL.getQuery(), localURL.getRef());
      return localURI;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Failed to encode url: " + paramString);
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      throw localException;
    }
  }

  public static HttpURLConnection getHttpUrlConnection(String paramString)
    throws IOException
  {
    Preconditions.checkNotNull(paramString);
    if (a(paramString))
      throw new IllegalArgumentException("URL is improperly encoded: " + paramString);
    try
    {
      String str = urlEncode(paramString);
      paramString = str;
      label45: HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setRequestProperty("user-agent", Networking.getCachedUserAgent());
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      return localHttpURLConnection;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }

  public static String urlEncode(String paramString)
    throws Exception
  {
    Preconditions.checkNotNull(paramString);
    if (a(paramString))
      throw new UnsupportedEncodingException("URL is improperly encoded: " + paramString);
    if (b(paramString));
    for (URI localURI = c(paramString); ; localURI = new URI(paramString))
      return localURI.toURL().toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.MoPubHttpUrlConnection
 * JD-Core Version:    0.6.2
 */