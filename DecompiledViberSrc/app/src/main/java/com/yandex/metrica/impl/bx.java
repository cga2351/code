package com.yandex.metrica.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.yandex.metrica.impl.ob.iv;
import com.yandex.metrica.impl.ob.iw;
import com.yandex.metrica.impl.ob.jb;
import com.yandex.metrica.impl.ob.ml;
import com.yandex.metrica.impl.ob.mw;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bx
  implements d
{

  @SuppressLint({"StaticFieldLeak"})
  private static volatile bx e;
  private static final Object f = new Object();
  private final Context a;
  private final WifiManager b;
  private iv c;
  private jb d = new jb();
  private d.a<JSONArray> g = new d.a();
  private d.a<List<a>> h = new d.a();
  private mw i;
  private final iw j;

  private bx(Context paramContext)
  {
    this(paramContext, (WifiManager)paramContext.getApplicationContext().getSystemService("wifi"), new jb());
  }

  private bx(Context paramContext, WifiManager paramWifiManager, jb paramjb)
  {
    this(paramContext, paramWifiManager, paramjb, new iv(paramjb.a()));
  }

  bx(Context paramContext, WifiManager paramWifiManager, jb paramjb, iv paramiv)
  {
    this.a = paramContext;
    this.b = paramWifiManager;
    this.d = paramjb;
    this.c = paramiv;
    Object localObject;
    if (bw.a(28))
      localObject = new iw()
      {
        public boolean a(Context paramAnonymousContext)
        {
          return (bx.a(bx.this).c(paramAnonymousContext)) && (bx.a(bx.this).e(paramAnonymousContext));
        }
      };
    while (true)
    {
      this.j = ((iw)localObject);
      return;
      if (bw.a(26))
        localObject = new iw()
        {
          public boolean a(Context paramAnonymousContext)
          {
            return (bx.a(bx.this).c(paramAnonymousContext)) || (bx.a(bx.this).f(paramAnonymousContext));
          }
        };
      else
        localObject = new iw()
        {
          public boolean a(Context paramAnonymousContext)
          {
            return bx.a(bx.this).c(paramAnonymousContext);
          }
        };
    }
  }

  public static bx a(Context paramContext)
  {
    if (e == null);
    synchronized (f)
    {
      if (e == null)
        e = new bx(paramContext.getApplicationContext());
      return e;
    }
  }

  private static String a(String paramString)
  {
    if (paramString == null)
      return null;
    return paramString.toUpperCase(Locale.US).replace(":", "");
  }

  private static JSONObject a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("mac", paramString1).put("ssid", paramString2).put("signal_strength", paramInt).put("is_connected", paramBoolean);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private void a(List<a> paramList)
  {
    if (g())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        Iterator localIterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (localIterator.hasNext())
        {
          NetworkInterface localNetworkInterface = (NetworkInterface)localIterator.next();
          byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
          if (arrayOfByte != null)
          {
            int k = arrayOfByte.length;
            for (int m = 0; m < k; m++)
            {
              byte b1 = arrayOfByte[m];
              Locale localLocale = Locale.US;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Byte.valueOf(b1);
              localStringBuilder.append(String.format(localLocale, "%02X:", arrayOfObject));
            }
            if (localStringBuilder.length() > 0)
            {
              localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
              paramList.add(new a(localNetworkInterface.getName(), localStringBuilder.toString()));
              localStringBuilder.setLength(0);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  private List<ScanResult> c()
  {
    try
    {
      List localList = this.b.getScanResults();
      return localList;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private JSONArray d()
  {
    if ((i()) && (this.j.a(this.a)));
    for (List localList = c(); ; localList = null)
    {
      WifiInfo localWifiInfo2;
      if ((h()) && (this.c.e(this.a)))
      {
        localWifiInfo2 = this.b.getConnectionInfo();
        if ((localWifiInfo2 != null) && (("00:00:00:00:00:00".equals(localWifiInfo2.getBSSID())) || (localWifiInfo2.getIpAddress() == 0)))
          localWifiInfo2 = null;
      }
      for (WifiInfo localWifiInfo1 = localWifiInfo2; ; localWifiInfo1 = null)
      {
        Object localObject;
        if (localWifiInfo1 == null)
          localObject = null;
        JSONArray localJSONArray;
        while (true)
        {
          localJSONArray = new JSONArray();
          if (localList != null)
          {
            Iterator localIterator = localList.iterator();
            label118: ScanResult localScanResult;
            do
            {
              if (!localIterator.hasNext())
                break;
              localScanResult = (ScanResult)localIterator.next();
            }
            while (localScanResult == null);
            boolean bool = false;
            try
            {
              String str5 = localScanResult.BSSID;
              bool = false;
              if (str5 != null)
              {
                bool = str5.equals(localObject);
                String str6 = a(str5);
                str4 = str6;
                JSONObject localJSONObject2 = a(str4, localScanResult.SSID, bool, localScanResult.level);
                if (localJSONObject2 == null)
                  break label118;
                localJSONArray.put(localJSONObject2);
                break label118;
                localObject = localWifiInfo1.getBSSID();
              }
            }
            catch (NoSuchFieldError localNoSuchFieldError)
            {
              while (true)
                String str4 = null;
            }
          }
        }
        String str1;
        String str2;
        String str3;
        if (localWifiInfo1 != null)
        {
          str1 = a((String)localObject);
          str2 = localWifiInfo1.getSSID();
          str3 = null;
          if (str2 != null)
            break label287;
        }
        while (true)
        {
          JSONObject localJSONObject1 = a(str1, str3, true, localWifiInfo1.getRssi());
          if (localJSONObject1 != null)
            localJSONArray.put(localJSONObject1);
          return localJSONArray;
          label287: str3 = str2.replace("\"", "");
        }
      }
    }
  }

  private boolean e()
  {
    try
    {
      boolean bool = this.b.isWifiEnabled();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private boolean f()
  {
    try
    {
      if (j())
      {
        boolean bool2 = this.i.n.k;
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  private boolean g()
  {
    try
    {
      if (j())
      {
        boolean bool2 = this.i.n.j;
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  private boolean h()
  {
    try
    {
      if (j())
      {
        boolean bool2 = this.i.n.i;
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  private boolean i()
  {
    try
    {
      if (j())
      {
        boolean bool2 = this.i.n.h;
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  private boolean j()
  {
    try
    {
      mw localmw = this.i;
      if (localmw != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public JSONArray a()
  {
    try
    {
      if (!e());
      for (JSONArray localJSONArray = new JSONArray(); ; localJSONArray = (JSONArray)this.g.a())
      {
        return localJSONArray;
        if ((this.g.b()) || (this.g.c()))
          this.g.a(d());
      }
    }
    finally
    {
    }
  }

  public void a(mw parammw)
  {
    this.i = parammw;
    this.d.a(parammw);
    this.c.a(this.d.a());
  }

  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
    this.c.a(this.d.a());
  }

  public String b(Context paramContext)
  {
    if (f())
      try
      {
        if (this.c.e(paramContext))
        {
          WifiConfiguration localWifiConfiguration = (WifiConfiguration)this.b.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(this.b, new Object[0]);
          if (localWifiConfiguration != null)
          {
            String str = localWifiConfiguration.SSID;
            return str;
          }
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
      }
    return null;
  }

  public List<a> b()
  {
    if ((this.h.b()) || (this.h.c()))
    {
      ArrayList localArrayList = new ArrayList();
      a(localArrayList);
      this.h.a(localArrayList);
    }
    return (List)this.h.a();
  }

  public int c(Context paramContext)
  {
    int k = -1;
    if (f());
    while (true)
    {
      try
      {
        if (this.c.e(paramContext))
        {
          int n = ((Integer)this.b.getClass().getMethod("getWifiApState", new Class[0]).invoke(this.b, new Object[0])).intValue();
          m = n;
          if (m > 10)
            m -= 10;
          k = m;
          return k;
        }
      }
      catch (Throwable localThrowable)
      {
        return k;
      }
      int m = k;
    }
  }

  public static final class a
  {
    public final String a;
    public final String b;

    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bx
 * JD-Core Version:    0.6.2
 */