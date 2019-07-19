package com.viber.voip.util;

import android.app.Application;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class bs
{
  private static final Logger a = ViberEnv.getLogger();
  private static final boolean b = "googleplay".equals("amazon");
  private static final boolean c = "googleplay".equals("googleplay");

  public static boolean a()
  {
    return b;
  }

  private static boolean a(String paramString)
    throws IOException
  {
    String str1 = "https://play.google.com/store/search?q=" + paramString;
    OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder().connectTimeout(60000L, TimeUnit.MILLISECONDS);
    Request.Builder localBuilder1 = new Request.Builder().url(str1);
    Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
    if (!localResponse.isSuccessful())
      return false;
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localResponse.body().byteStream()));
    String str2 = "details?id=" + paramString;
    String str3;
    do
    {
      str3 = localBufferedReader.readLine();
      if (str3 == null)
        break;
    }
    while (str3.indexOf(str2) == -1);
    return true;
  }

  public static boolean b()
    throws IOException
  {
    String str = ViberApplication.getApplication().getPackageName();
    return (b(str)) && (a(str));
  }

  private static boolean b(String paramString)
    throws IOException
  {
    String str = "https://play.google.com/store/apps/details?id=" + paramString;
    OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder().connectTimeout(60000L, TimeUnit.MILLISECONDS);
    Request.Builder localBuilder1 = new Request.Builder().url(str);
    return localBuilder.build().newCall(localBuilder1.build()).execute().isSuccessful();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bs
 * JD-Core Version:    0.6.2
 */