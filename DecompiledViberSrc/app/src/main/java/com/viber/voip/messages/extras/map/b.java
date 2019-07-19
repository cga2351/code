package com.viber.voip.messages.extras.map;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.maps.model.LatLng;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.settings.d.f;
import com.viber.voip.util.bz;
import com.viber.voip.util.dq;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Pattern b = Pattern.compile("https://maps\\.google\\.com/maps/api/staticmap\\?zoom=\\d*&size=\\d*x\\d*&scale=.*&maptype=roadmap&sensor=true&center=.*");
  private e c;
  private d d;
  private double e;
  private double f;

  public b(e parame, d paramd)
  {
    this.c = parame;
    this.d = paramd;
  }

  public static double a(int paramInt)
  {
    return paramInt / 1000000.0D;
  }

  public static int a()
  {
    int i = 51;
    if (ViberApplication.getApplication() != null)
      i = dq.a(ViberApplication.getApplication().getResources(), R.drawable._ics_location_point).getHeight();
    return i;
  }

  public static int a(double paramDouble)
  {
    return (int)Math.round(1000000.0D * paramDouble);
  }

  public static String a(double paramDouble1, double paramDouble2)
  {
    String[] arrayOfString1 = { "<lat>", "<lng>" };
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = String.valueOf(paramDouble1);
    arrayOfString2[1] = String.valueOf(paramDouble2);
    return TextUtils.replace("https://maps.googleapis.com/maps/api/geocode/json?latlng=<lat>,<lng>&sensor=true", arrayOfString1, arrayOfString2).toString();
  }

  private static String a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3)
  {
    String[] arrayOfString1 = { "<lat>", "<lng>", "<zoom>", "<width>", "<height>" };
    String[] arrayOfString2 = new String[5];
    arrayOfString2[0] = String.valueOf(paramDouble1);
    arrayOfString2[1] = String.valueOf(paramDouble2);
    arrayOfString2[2] = String.valueOf(paramInt1);
    arrayOfString2[3] = String.valueOf(paramInt2);
    arrayOfString2[4] = String.valueOf(paramInt3);
    return TextUtils.replace("https://maps.google.com/maps/api/staticmap?zoom=<zoom>&size=<width>x<height>&scale=<scale>&maptype=roadmap&sensor=true&center=<lat>,<lng>", arrayOfString1, arrayOfString2).toString();
  }

  public static String a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return a(a(paramInt1 / 10), a(paramInt2 / 10), 16, paramResources.getDimensionPixelSize(R.dimen.location_message_width), paramResources.getDimensionPixelSize(R.dimen.location_message_height));
  }

  public static String a(Resources paramResources, MessageEntity paramMessageEntity)
  {
    return a(paramMessageEntity, paramResources.getDimensionPixelSize(R.dimen.location_message_width), paramResources.getDimensionPixelSize(R.dimen.location_message_height));
  }

  public static String a(MessageEntity paramMessageEntity)
  {
    double d1 = a(paramMessageEntity.getLat() / 10);
    double d2 = a(paramMessageEntity.getLng() / 10);
    String[] arrayOfString1 = { "<lat>", "<lng>", "<zoom>" };
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = String.valueOf(d1);
    arrayOfString2[1] = String.valueOf(d2);
    arrayOfString2[2] = String.valueOf(16);
    return TextUtils.replace("geo:0,0?q=<lat>,<lng>&z=<zoom>", arrayOfString1, arrayOfString2).toString();
  }

  public static String a(MessageEntity paramMessageEntity, int paramInt1, int paramInt2)
  {
    return a(a(paramMessageEntity.getLat() / 10), a(paramMessageEntity.getLng() / 10), 16, paramInt1, paramInt2);
  }

  private void a(int paramInt, double paramDouble1, double paramDouble2, boolean paramBoolean, d paramd)
  {
    this.e = com.viber.voip.messages.extras.b.b.a(paramInt, paramDouble1, d.f.e.d());
    this.f = com.viber.voip.messages.extras.b.b.a(paramInt, paramDouble2, d.f.e.d());
    if (paramd != null)
      this.d = paramd;
    av.a(av.e.g).postAtFrontOfQueue(new b(paramInt, paramDouble1, paramDouble2, paramBoolean));
  }

  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://maps.google.com/maps/api/staticmap")) && (b.matcher(paramString).matches());
  }

  public static String b(String paramString)
  {
    return TextUtils.replace("https://maps.googleapis.com/maps/api/geocode/json?address=<address>&sensor=true", new String[] { "<address>" }, new String[] { paramString }).toString();
  }

  public void a(int paramInt, double paramDouble1, double paramDouble2, e parame)
  {
    this.e = com.viber.voip.messages.extras.b.b.a(paramInt, paramDouble1, d.f.e.d());
    this.f = com.viber.voip.messages.extras.b.b.a(paramInt, paramDouble2, d.f.e.d());
    if (parame != null)
      this.c = parame;
    av.a(av.e.g).postAtFrontOfQueue(new c(paramInt, paramDouble1, paramDouble2));
  }

  public void a(int paramInt, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    a(paramInt, paramDouble1, paramDouble2, paramBoolean, null);
  }

  public void a(int paramInt, String paramString, e parame)
  {
    if (parame != null)
      this.c = parame;
    av.a(av.e.g).postAtFrontOfQueue(new c(paramInt, paramString));
  }

  private abstract class a
    implements Runnable
  {
    protected final int a;
    protected double b;
    protected double c;

    public a(int paramDouble1, double arg3, double arg5)
    {
      this.b = com.viber.voip.messages.extras.b.b.a(paramDouble1, ???, d.f.e.d());
      Object localObject;
      this.c = com.viber.voip.messages.extras.b.b.a(paramDouble1, localObject, d.f.e.d());
      this.a = paramDouble1;
    }

    protected boolean a()
    {
      return (bz.a(this.b, b.b(b.this))) && (bz.a(this.c, b.c(b.this)));
    }

    protected abstract void b();

    public void run()
    {
      if (!a())
        return;
      b();
    }
  }

  private class b extends b.a
  {
    private final boolean f;

    public b(int paramDouble1, double arg3, double arg5, boolean arg7)
    {
      super(paramDouble1, ???, localObject);
      boolean bool1;
      this.f = bool1;
    }

    public void b()
    {
      ViberApplication.getInstance().getLocationManager().a(this.a, this.b, this.c, this.f, new c(this));
    }
  }

  private class c extends b.a
  {
    private String f;

    public c(int paramDouble1, double arg3, double arg5)
    {
      super(paramDouble1, ???, localObject);
      this.f = null;
    }

    public c(int paramString, String arg3)
    {
      super(paramString, b.b(b.this), b.c(b.this));
      Object localObject;
      this.f = localObject;
    }

    public void b()
    {
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      try
      {
        if (TextUtils.isEmpty(this.f));
        String str1;
        for (Object localObject2 = b.a(this.b, this.c); ; localObject2 = str1)
        {
          String str2 = ((String)localObject2).replaceAll("[' ']", "+");
          OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
          Request.Builder localBuilder1 = new Request.Builder().url(str2);
          JSONObject localJSONObject1 = new JSONObject(localBuilder.build().newCall(localBuilder1.build()).execute().body().string());
          if (!"OK".equalsIgnoreCase(localJSONObject1.getString("status")))
            break;
          JSONArray localJSONArray = localJSONObject1.getJSONArray("results");
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
            b.f localf = new b.f();
            String str3 = localJSONObject2.getString("formatted_address");
            localf.d(str3);
            localf.e(str3);
            Double localDouble1 = Double.valueOf(localJSONObject2.getJSONObject("geometry").getJSONObject("location").getDouble("lng"));
            Double localDouble2 = Double.valueOf(localJSONObject2.getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
            localf.a(new a((int)(1000000.0D * localDouble2.doubleValue()), (int)(1000000.0D * localDouble1.doubleValue())));
            localf.a(new LatLng(localDouble2.doubleValue(), localDouble1.doubleValue()));
            localf.a(localJSONObject2.getJSONArray("types").getString(0));
            localArrayList.add(localf);
            i++;
          }
          str1 = b.b(URLEncoder.encode(this.f, "UTF-8"));
        }
        return;
      }
      catch (Exception localException)
      {
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
      }
      finally
      {
        b.d(b.this).a((b.f[])localArrayList.toArray(new b.f[localArrayList.size()]));
      }
    }
  }

  public static abstract interface d
  {
    public abstract void a(b.f paramf);
  }

  public static abstract interface e
  {
    public abstract void a(b.f[] paramArrayOff);
  }

  public static class f
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private a f;
    private LatLng g;

    public String a()
    {
      return this.a;
    }

    public void a(LatLng paramLatLng)
    {
      this.g = paramLatLng;
    }

    public void a(a parama)
    {
      this.f = parama;
    }

    public void a(String paramString)
    {
      this.a = paramString;
    }

    public a b()
    {
      return this.f;
    }

    public void b(String paramString)
    {
      this.b = paramString;
    }

    public LatLng c()
    {
      return this.g;
    }

    public void c(String paramString)
    {
      this.e = paramString;
    }

    public String d()
    {
      return this.d;
    }

    public void d(String paramString)
    {
      this.d = paramString;
    }

    public String e()
    {
      return this.e;
    }

    public void e(String paramString)
    {
      this.c = paramString;
    }

    public String f()
    {
      return this.c;
    }

    public String g()
    {
      return f();
    }

    public String toString()
    {
      return "PlaceItem{mFullVicinity='" + this.d + '\'' + ", mPoint=" + this.f + ", mName=" + this.a + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.map.b
 * JD-Core Version:    0.6.2
 */