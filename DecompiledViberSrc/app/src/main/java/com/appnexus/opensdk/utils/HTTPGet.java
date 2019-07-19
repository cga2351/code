package com.appnexus.opensdk.utils;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.appnexus.opensdk.R.string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public abstract class HTTPGet extends AsyncTask<Void, Void, HTTPResponse>
{
  private HttpURLConnection a(URL paramURL)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setDoOutput(false);
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setRequestMethod("GET");
    return localHttpURLConnection;
  }

  private void a(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    paramHttpURLConnection.setRequestProperty("User-Agent", Settings.getSettings().ua);
    String str = WebviewUtil.getCookie();
    if (!TextUtils.isEmpty(str))
      paramHttpURLConnection.setRequestProperty("Cookie", str);
    paramHttpURLConnection.setConnectTimeout(15000);
    paramHttpURLConnection.setReadTimeout(20000);
  }

  protected HTTPResponse a(Void[] paramArrayOfVoid)
  {
    HTTPResponse localHTTPResponse = new HTTPResponse();
    try
    {
      URL localURL = new URL(a());
      if (localURL.getHost() == null)
      {
        Clog.w(Clog.httpReqLogTag, "An HTTP request with an invalid URL was attempted.", new IllegalStateException("An HTTP request with an invalid URL was attempted."));
        localHTTPResponse.setSucceeded(false);
        return localHTTPResponse;
      }
      Clog.i(Clog.httpReqLogTag, "HTTPGet ReqURL - " + localURL);
      localHttpURLConnection = a(localURL);
      a(localHttpURLConnection);
      localHttpURLConnection.connect();
      localStringBuilder = new StringBuilder();
      localInputStream = localHttpURLConnection.getInputStream();
      localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream, "utf-8"));
      while (true)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null)
          break;
        localStringBuilder.append(str1);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      HttpURLConnection localHttpURLConnection;
      StringBuilder localStringBuilder;
      InputStream localInputStream;
      BufferedReader localBufferedReader;
      localHTTPResponse.setSucceeded(false);
      localHTTPResponse.setErrorCode(HttpErrorCode.URI_SYNTAX_ERROR);
      Clog.e(Clog.httpReqLogTag, Clog.getString(R.string.http_get_url_malformed));
      return localHTTPResponse;
      localBufferedReader.close();
      localInputStream.close();
      String str2 = localStringBuilder.toString();
      localHTTPResponse.setHeaders(localHttpURLConnection.getHeaderFields());
      localHTTPResponse.setResponseBody(str2);
      if (localHttpURLConnection.getResponseCode() == 200)
      {
        bool = true;
        localHTTPResponse.setSucceeded(bool);
        return localHTTPResponse;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        localHTTPResponse.setSucceeded(false);
        localHTTPResponse.setErrorCode(HttpErrorCode.TRANSPORT_ERROR);
        Clog.e(Clog.httpReqLogTag, Clog.getString(R.string.http_get_io));
        return localHTTPResponse;
        boolean bool = false;
      }
    }
    catch (Exception localException)
    {
      localHTTPResponse.setSucceeded(false);
      localHTTPResponse.setErrorCode(HttpErrorCode.UNKNOWN_ERROR);
      localException.printStackTrace();
      Clog.e(Clog.httpReqLogTag, Clog.getString(R.string.http_get_unknown_exception));
    }
    return localHTTPResponse;
  }

  protected abstract String a();

  protected abstract void a(HTTPResponse paramHTTPResponse);

  @TargetApi(11)
  protected void b(HTTPResponse paramHTTPResponse)
  {
    super.onCancelled(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.HTTPGet
 * JD-Core Version:    0.6.2
 */