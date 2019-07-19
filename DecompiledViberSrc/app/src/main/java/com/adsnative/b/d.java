package com.adsnative.b;

import android.content.Context;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import com.adsnative.c.i;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private b a;
  private com.adsnative.c.b b;
  private Context c;
  private String d;
  private String e;

  public d(b paramb, String paramString1, String paramString2, com.adsnative.c.b paramb1, Context paramContext)
  {
    this.a = paramb;
    this.d = paramString1;
    this.e = paramString2;
    this.b = paramb1;
    this.c = paramContext;
  }

  private JSONObject b()
    throws UnknownHostException, JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    String str1 = this.a.e();
    String str2 = this.b.b();
    String str3 = this.b.d();
    String str4 = this.b.g();
    this.b.c();
    this.b.a();
    String str5 = this.c.getPackageName();
    String str6 = this.b.f();
    String str7 = Formatter.formatIpAddress(((WifiManager)this.c.getSystemService("wifi")).getConnectionInfo().getIpAddress());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("ua", str2);
    localJSONObject2.put("al", str3);
    localJSONObject2.put("ct", str4);
    localJSONObject2.put("ip", str7);
    JSONObject localJSONObject3 = new JSONObject();
    localJSONObject3.put("bnid", str5);
    localJSONObject3.put("app_id", str6);
    localJSONObject3.put("ver", str6);
    JSONObject localJSONObject4 = new JSONObject();
    Location localLocation = this.a.b();
    if (localLocation != null)
    {
      double d1 = localLocation.getLatitude();
      double d2 = localLocation.getLongitude();
      float f = localLocation.getAccuracy();
      localJSONObject4.put("lat", String.valueOf(d1));
      localJSONObject4.put("lon", String.valueOf(d2));
      localJSONObject4.put("lla", String.valueOf(f));
    }
    JSONObject localJSONObject5 = new JSONObject();
    localJSONObject5.put("uuid", this.d);
    localJSONObject5.put("gaid", this.d);
    localJSONObject5.put("dnt", this.e);
    localJSONObject1.put("device", localJSONObject2);
    localJSONObject1.put("geo", localJSONObject4);
    localJSONObject1.put("user", localJSONObject5);
    localJSONObject1.put("app", localJSONObject3);
    localJSONObject1.put("zid", str1);
    localJSONObject1.put("sdkv", "3.1.9");
    localJSONObject1.put("fetch_num", String.valueOf(1));
    JSONObject localJSONObject6 = new JSONObject();
    if (this.a.h() != null)
    {
      Iterator localIterator2 = this.a.h().entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        String[] arrayOfString = new String[((ArrayList)localEntry2.getValue()).size()];
        JSONArray localJSONArray = new JSONArray(Arrays.asList((String[])((ArrayList)localEntry2.getValue()).toArray(arrayOfString)));
        localJSONObject6.put((String)localEntry2.getKey(), localJSONArray);
      }
    }
    localJSONObject1.put("ck", localJSONObject6);
    int i = this.a.g();
    int j = 0;
    if (i > 0)
    {
      Iterator localIterator1 = this.a.f().entrySet().iterator();
      if (localIterator1.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        if ((((String)localEntry1.getKey()).equals("IMA")) && (((String)localEntry1.getValue()).equals("TRUE")));
        for (int k = 1; ; k = j)
        {
          j = k;
          break;
          localJSONObject1.put((String)localEntry1.getKey(), localEntry1.getValue());
        }
      }
    }
    if (j == 0)
      localJSONObject1.put("is_sdk", 1);
    localJSONObject1.put("hb", 1);
    return localJSONObject1;
  }

  private String c()
    throws UnsupportedEncodingException
  {
    i.b("Fetching url: " + "https://api.adsnative.com/v1/ad.json");
    return "https://api.adsnative.com/v1/ad.json";
  }

  public String a()
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL(c()).openConnection();
    localHttpsURLConnection.setRequestProperty("Content-Type", "application/json");
    localHttpsURLConnection.setRequestProperty("Accept", "*/*");
    localHttpsURLConnection.setRequestProperty("Content-Type", "application/json");
    localHttpsURLConnection.setRequestProperty("Accept-Language", "en/us");
    localHttpsURLConnection.setRequestProperty("Accept-Encoding", "gzip/deflate");
    localHttpsURLConnection.setRequestMethod("POST");
    localHttpsURLConnection.setDoInput(true);
    localHttpsURLConnection.setDoOutput(true);
    OutputStream localOutputStream = localHttpsURLConnection.getOutputStream();
    BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localOutputStream));
    try
    {
      i.a("Post Body: " + b());
      localBufferedWriter.write(b().toString());
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localOutputStream.close();
      if (localHttpsURLConnection.getResponseCode() == 200)
      {
        localBufferedReader = new BufferedReader(new InputStreamReader(localHttpsURLConnection.getInputStream()));
        while (true)
        {
          String str = localBufferedReader.readLine();
          if (str == null)
            break;
          localStringBuilder.append(str);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      BufferedReader localBufferedReader;
      while (true)
        localJSONException.printStackTrace();
      localBufferedReader.close();
      localHttpsURLConnection.disconnect();
      return localStringBuilder.toString();
    }
    i.e(localHttpsURLConnection.getResponseMessage());
    throw new IOException(localHttpsURLConnection.getResponseMessage());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.b.d
 * JD-Core Version:    0.6.2
 */