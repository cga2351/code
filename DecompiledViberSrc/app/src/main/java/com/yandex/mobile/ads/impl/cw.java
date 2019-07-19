package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class cw
{
  public static final long a = ()(1.0D + Math.floor(4294967295.0D * Math.random()));

  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    int i = paramJSONObject.optInt(paramString, paramInt);
    if (i >= 0)
      paramInt = i;
    return paramInt;
  }

  public static Bitmap a(String paramString)
  {
    try
    {
      String str = paramString.substring(1 + paramString.indexOf(","));
      if (!TextUtils.isEmpty(str))
      {
        byte[] arrayOfByte = Base64.decode(str, 0);
        Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        return localBitmap;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static ResultReceiver a(ResultReceiver paramResultReceiver)
  {
    ResultReceiver localResultReceiver = null;
    if (paramResultReceiver != null)
    {
      Parcel localParcel = Parcel.obtain();
      paramResultReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      localResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
    }
    return localResultReceiver;
  }

  public static Long a(String paramString, Long paramLong)
  {
    if (paramString != null);
    try
    {
      Long localLong = Long.valueOf(paramString);
      paramLong = localLong;
      return paramLong;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramLong;
  }

  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("YadPreferenceFile", 0).getString("SessionData", null);
  }

  public static <T> String a(T paramT)
  {
    return paramT.toString();
  }

  private static String a(String paramString, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      Uri.Builder localBuilder = Uri.parse(paramString).buildUpon();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBuilder.appendQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      paramString = localBuilder.build().toString();
    }
    return paramString;
  }

  public static List<bd> a(v paramv, Map<String, String> paramMap)
  {
    List localList1 = paramv.f();
    List localList2 = paramv.i();
    List localList3 = paramv.j();
    ArrayList localArrayList = new ArrayList();
    if (localList1 != null)
    {
      int i = 0;
      if (i < localList1.size())
      {
        String str = a((String)localList1.get(i), paramMap);
        long l;
        if (localList2.size() > i)
        {
          l = ((Long)localList2.get(i)).longValue();
          label87: if (localList3.size() <= i)
            break label168;
        }
        label168: for (int j = ((Integer)localList3.get(i)).intValue(); ; j = 0)
        {
          bd localbd = new bd();
          localbd.a(str);
          localbd.a(l);
          localbd.a(j);
          localArrayList.add(localbd);
          i++;
          break;
          l = 0L;
          break label87;
        }
      }
    }
    return localArrayList;
  }

  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("YadPreferenceFile", 0).edit().putString("SessionData", paramString).apply();
  }

  public static void a(WebView paramWebView)
  {
    try
    {
      WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null);
    try
    {
      paramHttpURLConnection.disconnect();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean a(aa paramaa)
  {
    return (paramaa == null) || (paramaa.a_());
  }

  public static int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  public static void b(WebView paramWebView)
  {
    try
    {
      WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean b(Context paramContext)
  {
    try
    {
      WebViewDatabase localWebViewDatabase = WebViewDatabase.getInstance(paramContext);
      boolean bool = false;
      if (localWebViewDatabase != null)
        bool = true;
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static Integer c(String paramString)
  {
    try
    {
      Integer localInteger = Integer.valueOf(paramString);
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cw
 * JD-Core Version:    0.6.2
 */