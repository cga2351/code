package com.appnexus.opensdk.ut;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.appnexus.opensdk.R.string;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.SharedNetworkManager;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.WebviewUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public class UTAdRequest extends AsyncTask<Void, Integer, UTAdResponse>
{
  private WeakReference<UTAdRequester> a;
  private UTRequestParameters b;

  public UTAdRequest(UTAdRequester paramUTAdRequester)
  {
    this.a = new WeakReference(paramUTAdRequester);
    this.b = paramUTAdRequester.getRequestParams();
    if (this.b != null)
    {
      if (!SharedNetworkManager.getInstance(this.b.getContext()).isConnected(this.b.getContext()))
      {
        a(ResultCode.NETWORK_ERROR);
        Clog.i(Clog.httpReqLogTag, "Connection Error");
        cancel(true);
      }
      return;
    }
    Clog.i(Clog.httpReqLogTag, "Internal Error");
    a(ResultCode.INTERNAL_ERROR);
    cancel(true);
  }

  private void a(ResultCode paramResultCode)
  {
    UTAdRequester localUTAdRequester = (UTAdRequester)this.a.get();
    if (localUTAdRequester != null)
      localUTAdRequester.failed(paramResultCode);
    Clog.clearLastResponse();
  }

  protected UTAdResponse a(Void[] paramArrayOfVoid)
  {
    UTAdRequester localUTAdRequester = (UTAdRequester)this.a.get();
    if (localUTAdRequester != null);
    try
    {
      if (localUTAdRequester.isHttpsEnabled())
      {
        str1 = UTConstants.REQUEST_BASE_URL_UT_V2.replace("http:", "https:");
        localHttpURLConnection = (HttpURLConnection)new URL(str1).openConnection();
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setRequestProperty("Content-Type", "application/json");
        localHttpURLConnection.setRequestProperty("Accept", "application/json");
        localHttpURLConnection.setRequestProperty("User-Agent", Settings.getSettings().ua);
        String str2 = WebviewUtil.getCookie();
        if (!TextUtils.isEmpty(str2))
          localHttpURLConnection.setRequestProperty("Cookie", str2);
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setConnectTimeout(15000);
        localHttpURLConnection.setReadTimeout(20000);
        String str3 = this.b.a();
        Clog.setLastRequest(str3);
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localHttpURLConnection.getOutputStream());
        localOutputStreamWriter.write(str3);
        localOutputStreamWriter.flush();
        localHttpURLConnection.connect();
        i = localHttpURLConnection.getResponseCode();
        if (i != 200)
          break label365;
        localStringBuilder = new StringBuilder();
        localInputStream = localHttpURLConnection.getInputStream();
        localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream, "utf-8"));
        while (true)
        {
          String str4 = localBufferedReader.readLine();
          if (str4 == null)
            break;
          localStringBuilder.append(str4);
        }
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      HttpURLConnection localHttpURLConnection;
      int i;
      StringBuilder localStringBuilder;
      InputStream localInputStream;
      BufferedReader localBufferedReader;
      while (true)
      {
        Clog.e(Clog.httpReqLogTag, Clog.getString(R.string.http_timeout));
        return null;
        String str1 = UTConstants.REQUEST_BASE_URL_UT_V2;
      }
      localBufferedReader.close();
      localInputStream.close();
      String str5 = localStringBuilder.toString();
      Clog.i(Clog.httpRespLogTag, "RESPONSE - " + str5);
      WebviewUtil.cookieSync(localHttpURLConnection.getHeaderFields());
      return new UTAdResponse(str5, localHttpURLConnection.getHeaderFields(), this.b.getMediaType(), this.b.getOrientation());
      Clog.d(Clog.httpRespLogTag, Clog.getString(R.string.http_bad_status, i));
      UTAdResponse localUTAdResponse = new UTAdResponse(true);
      return localUTAdResponse;
    }
    catch (IOException localIOException)
    {
      while (true)
        Clog.e(Clog.httpReqLogTag, Clog.getString(R.string.http_io));
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        Clog.e(Clog.httpReqLogTag, Clog.getString(R.string.permissions_internet));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        Clog.e(Clog.httpReqLogTag, Clog.getString(R.string.http_unknown));
    }
    catch (Exception localException)
    {
      while (true)
      {
        label365: localException.printStackTrace();
        Clog.e(Clog.httpReqLogTag, Clog.getString(R.string.unknown_exception));
      }
    }
  }

  protected void a(UTAdResponse paramUTAdResponse)
  {
    if (paramUTAdResponse == null)
    {
      Clog.i(Clog.httpRespLogTag, Clog.getString(R.string.no_response));
      a(ResultCode.NETWORK_ERROR);
    }
    UTAdRequester localUTAdRequester;
    do
    {
      return;
      if (paramUTAdResponse.a())
      {
        a(ResultCode.NETWORK_ERROR);
        return;
      }
      localUTAdRequester = (UTAdRequester)this.a.get();
    }
    while (localUTAdRequester == null);
    localUTAdRequester.onReceiveUTResponse(paramUTAdResponse);
  }

  @TargetApi(11)
  protected void b(UTAdResponse paramUTAdResponse)
  {
    super.onCancelled(paramUTAdResponse);
    Clog.w(Clog.httpRespLogTag, Clog.getString(R.string.cancel_request));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.UTAdRequest
 * JD-Core Version:    0.6.2
 */