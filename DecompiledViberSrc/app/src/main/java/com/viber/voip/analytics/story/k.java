package com.viber.voip.analytics.story;

import android.content.Context;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.CountryNameInfo;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.calls.d.b;
import com.viber.voip.market.MarketApi.f;
import com.viber.voip.model.Call;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.p;
import com.viber.voip.stickers.entity.c.a;
import com.viber.voip.stickers.i;
import com.viber.voip.util.cd;
import com.viber.voip.util.cg;
import com.viber.voip.util.ci;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
{
  static ci<com.viber.voip.stickers.entity.a> a = l.a;
  static ci<com.viber.voip.stickers.entity.a> b = m.a;
  private static final Logger c = ViberEnv.getLogger();
  private static final long d = TimeUnit.SECONDS.toMillis(10L);
  private static final Runnable e = new Runnable()
  {
    public void run()
    {
      k.i();
    }
  };

  public static String a(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
    if (TextUtils.isEmpty(str))
      return null;
    if (str.length() >= 3)
      return str.substring(0, 3);
    return null;
  }

  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str1 = com.viber.voip.model.e.c("analytics", paramString1);
    String str2 = com.viber.voip.model.e.c("analytics", paramString2);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString3)))
    {
      String[] arrayOfString = str1.split(",", -1);
      int i = arrayOfString.length;
      for (int j = 0; ; j++)
      {
        int k = 0;
        if (j < i)
        {
          if (arrayOfString[j].equals(paramString3))
            k = 1;
        }
        else
        {
          if (k == 0)
            break;
          return str2;
        }
      }
      if (TextUtils.isEmpty(str2));
      for (String str3 = paramString3; ; str3 = str2 + "," + paramString3)
      {
        com.viber.voip.model.e.a("analytics", paramString1, str1 + "," + paramString3);
        com.viber.voip.model.e.a("analytics", paramString2, str3);
        return str3;
      }
    }
    if ((TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString3)))
    {
      com.viber.voip.model.e.a("analytics", paramString1, paramString3);
      com.viber.voip.model.e.a("analytics", paramString2, paramString3);
    }
    while (true)
    {
      return paramString3;
      paramString3 = str2;
    }
  }

  public static String a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    if (paramArrayOfString == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str2 = paramArrayOfString[j];
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(str2);
    }
    String str1 = localStringBuilder.toString();
    com.viber.voip.model.e.a("analytics", paramString1, str1);
    com.viber.voip.model.e.a("analytics", paramString2, str1);
    return str1;
  }

  public static void a(int paramInt)
  {
    int i = com.viber.voip.util.av.e(d.f.p.d(), paramInt);
    d.f.p.a(i);
    if (com.viber.voip.util.av.g(i, 15))
      b(g.a(new Date()));
  }

  public static void a(com.viber.voip.stickers.entity.a parama)
  {
    com.viber.voip.av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        if (c.a.b == this.a.r())
        {
          String str2 = k.a("paid_stickers_exs_key", "paid stickers ids", String.valueOf(this.a.e()));
          if (!TextUtils.isEmpty(str2))
            k.a(g.d(str2));
        }
        String str1;
        do
        {
          return;
          str1 = k.a("free_stickers_exs_key", "free stickers ids", String.valueOf(this.a.e()));
        }
        while (TextUtils.isEmpty(str1));
        k.a(g.c(str1));
      }
    });
  }

  public static void a(String paramString)
  {
    if ((!cd.c(paramString)) && (cg.a(paramString)))
    {
      CountryNameInfo localCountryNameInfo = ViberApplication.getInstance().getEngine(true).getPhoneController().getCountryName(paramString);
      if (localCountryNameInfo != null)
        a("inter_msg_destinations_key", "international sending destination", localCountryNameInfo.countryShortName);
    }
  }

  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramString4, true);
  }

  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a locala = new a(paramString1, paramString2, paramString3, paramString4);
    b(g.a(locala, paramBoolean));
    com.viber.voip.analytics.g.a().c().b().a(locala, paramBoolean);
  }

  public static boolean a()
  {
    return com.viber.voip.viberout.a.a().e();
  }

  public static String b(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
    if (TextUtils.isEmpty(str))
      return null;
    if (str.length() > 3)
      return str.substring(3);
    return null;
  }

  public static void b()
  {
    if (ao.f())
      return;
    b(g.a(d.p.v.d()));
  }

  private static void b(j paramj)
  {
    com.viber.voip.analytics.g.a().a(paramj);
  }

  public static void b(String paramString)
  {
    if (cg.a(paramString))
    {
      CountryNameInfo localCountryNameInfo = ViberApplication.getInstance().getEngine(true).getPhoneController().getCountryName(paramString);
      if (localCountryNameInfo != null)
        a("inter_call_destinations_key", "international calling destinations", localCountryNameInfo.countryShortName);
    }
  }

  public static void c()
  {
    com.viber.voip.av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        String str1 = com.viber.voip.model.e.c("analytics", "international calling destinations");
        String str2 = com.viber.voip.model.e.c("analytics", "international sending destination");
        if (!TextUtils.isEmpty(str1))
          k.a(g.h(str1));
        if (!TextUtils.isEmpty(str2))
          k.a(g.i(str2));
      }
    });
  }

  public static void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      d(a("vo_destinations_exs_key", "vo destinations", paramString));
  }

  public static void d()
  {
    com.viber.voip.av.a(av.e.g).post(new Runnable()
    {
      private void a()
      {
        com.viber.voip.calls.e.a(ViberApplication.getInstance()).a(new d.b()
        {
          public void a(long paramAnonymous2Long, Collection<Call> paramAnonymous2Collection)
          {
            if (paramAnonymous2Collection.size() > 0)
            {
              HashSet localHashSet = new HashSet(paramAnonymous2Collection.size());
              Iterator localIterator1 = paramAnonymous2Collection.iterator();
              while (localIterator1.hasNext())
              {
                Call localCall = (Call)localIterator1.next();
                CountryNameInfo localCountryNameInfo = ViberApplication.getInstance().getEngine(true).getPhoneController().getCountryName(localCall.getCanonizedNumber());
                if (localCountryNameInfo != null)
                  localHashSet.add(localCountryNameInfo.countryShortName);
              }
              StringBuilder localStringBuilder = new StringBuilder();
              Iterator localIterator2 = localHashSet.iterator();
              while (localIterator2.hasNext())
              {
                String str2 = (String)localIterator2.next();
                if (localStringBuilder.length() > 0)
                  localStringBuilder.append(',');
                localStringBuilder.append(str2);
              }
              String str1 = localStringBuilder.toString();
              com.viber.voip.model.e.a("analytics", "vo_destinations_exs_key", str1);
              com.viber.voip.model.e.a("analytics", "vo destinations", str1);
              k.d(str1);
            }
          }
        });
      }

      public void run()
      {
        if (com.viber.voip.model.e.c("analytics", "vo_destinations_exs_key") == null)
        {
          a();
          return;
        }
        k.d(com.viber.voip.model.e.c("analytics", "vo destinations"));
      }
    });
  }

  static void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      b(g.a(paramString));
  }

  public static void e()
  {
    if (d.f.o.d())
      return;
    new com.viber.voip.market.b.e().a(5, new MarketApi.f()
    {
      public void a(String paramAnonymousString)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramAnonymousString);
          if (localJSONObject.has("destinations"))
          {
            JSONArray localJSONArray = localJSONObject.getJSONArray("destinations");
            if (localJSONArray != null)
            {
              if (localJSONArray.length() == 0)
                return;
              int i = localJSONArray.length();
              ArrayList localArrayList = new ArrayList(i);
              for (int j = 0; j < i; j++)
                localArrayList.add((String)localJSONArray.get(j));
              k.e(TextUtils.join(",", localArrayList));
              return;
            }
          }
        }
        catch (JSONException localJSONException)
        {
        }
      }
    });
  }

  static void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      b(g.b(paramString));
      d.f.o.a(true);
    }
  }

  public static ci<com.viber.voip.stickers.entity.a> f()
  {
    return a;
  }

  public static ci<com.viber.voip.stickers.entity.a> g()
  {
    return b;
  }

  public static void h()
  {
    com.viber.voip.av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        i locali = i.a();
        if (com.viber.voip.model.e.c("analytics", "paid_stickers_exs_key") == null)
        {
          String str4 = k.a(locali.a(null, k.f()), "paid_stickers_exs_key", "paid stickers ids");
          if (!TextUtils.isEmpty(str4))
            k.a(g.d(str4));
          if (com.viber.voip.model.e.c("analytics", "free_stickers_exs_key") != null)
            break label116;
          String str3 = k.a(locali.a(null, k.g()), "free_stickers_exs_key", "free stickers ids");
          if (!TextUtils.isEmpty(str3))
            k.a(g.c(str3));
        }
        label116: String str2;
        do
        {
          return;
          String str1 = com.viber.voip.model.e.c("analytics", "paid stickers ids");
          if (TextUtils.isEmpty(str1))
            break;
          k.a(g.d(str1));
          break;
          str2 = com.viber.voip.model.e.c("analytics", "free stickers ids");
        }
        while (TextUtils.isEmpty(str2));
        k.a(g.c(str2));
      }
    });
  }

  public static void i()
  {
    AdjustAttribution localAdjustAttribution = Adjust.getAttribution();
    if (localAdjustAttribution != null)
    {
      a(localAdjustAttribution.network, localAdjustAttribution.campaign, localAdjustAttribution.adgroup, localAdjustAttribution.creative, false);
      return;
    }
    Handler localHandler = av.e.g.a();
    localHandler.removeCallbacks(e);
    localHandler.postDelayed(e, d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.k
 * JD-Core Version:    0.6.2
 */