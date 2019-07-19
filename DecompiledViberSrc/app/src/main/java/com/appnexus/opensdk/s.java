package com.appnexus.opensdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.view.View;
import com.appnexus.opensdk.utils.Clog;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class s
{
  private static final Uri a = Uri.parse("appnexuspb://app?");
  private static LinkedHashMap<String, String> b = new LinkedHashMap();

  private static void a()
  {
    if (b.size() > 10)
    {
      String str = (String)b.keySet().iterator().next();
      b.remove(str);
    }
  }

  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", a);
    localIntent.setFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Clog.w(Clog.baseLogTag, Clog.getString(R.string.opening_url_failed, a.toString()));
    }
  }

  private static void a(final Context paramContext, View paramView, final String paramString)
  {
    Executors.newSingleThreadScheduledExecutor().schedule(new Runnable()
    {
      public void run()
      {
        byte[] arrayOfByte = s.a(s.a(this.a));
        if (arrayOfByte == null)
        {
          Clog.e(Clog.baseLogTag, "PBImplementation.captureImage(:::) -- imageBytes is NULL.");
          return;
        }
        Clog.d(Clog.baseLogTag, "PITBULL image size: " + arrayOfByte.length + " bytes");
        s.a(paramContext, paramString, arrayOfByte);
      }
    }
    , 1000L, TimeUnit.MILLISECONDS);
  }

  static void a(f paramf, String paramString)
  {
    if ((paramf == null) || (paramf.getContext() == null));
    Context localContext;
    String str3;
    do
    {
      Uri localUri;
      String str1;
      do
      {
        do
        {
          return;
          localContext = paramf.getContext();
          localUri = Uri.parse(paramString);
          str1 = localUri.getHost();
          if (!"web".equals(str1))
            break;
        }
        while (!paramf.d());
        a(localContext);
        return;
        if ("app".equals(str1))
        {
          a(localUri.getQueryParameter("auction_info"));
          return;
        }
      }
      while (!"capture".equals(str1));
      String str2 = localUri.getQueryParameter("auction_id");
      str3 = (String)b.get(str2);
    }
    while (str3 == null);
    a(localContext, paramf, str3);
  }

  private static void a(String paramString)
  {
    try
    {
      String str = new JSONObject(paramString).getString("auction_id");
      a();
      b.put(str, paramString);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private static Bitmap b(View paramView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    return localBitmap;
  }

  private static void b(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("com.appnexus.opensdk.BROADCAST", Uri.parse("appnexuspb://app?auction_info=" + Uri.encode(paramString)));
    localIntent.putExtra("image", paramArrayOfByte);
    paramContext.sendBroadcast(localIntent);
  }

  private static byte[] b(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramBitmap.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream))
      return localByteArrayOutputStream.toByteArray();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.s
 * JD-Core Version:    0.6.2
 */