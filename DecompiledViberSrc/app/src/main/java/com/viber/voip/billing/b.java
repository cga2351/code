package com.viber.voip.billing;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.support.v4.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.contacts.c.d.m.b;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.market.MarketApi.f;
import com.viber.voip.market.MarketApi.m;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.o;
import com.viber.voip.settings.d.ah;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.f;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bj;
import com.viber.voip.util.cg;
import com.viber.voip.util.da;
import com.viber.voip.util.dl;
import com.viber.voip.util.dr;
import com.viber.voip.util.http.OkHttpClientFactory;
import com.viber.voip.util.z;
import com.viber.voip.wallet.a.a;
import com.viber.voip.wallet.a.b;
import com.viber.voip.wallet.a.c;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.FormBody.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.QueryProductDetailsFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile b b;
  private g c;
  private long d;
  private Map<String, u> e = new HashMap();
  private Map<String, List<v>> f = new HashMap();

  public static Logger a(Class paramClass)
  {
    return ViberEnv.getLogger("release-tag");
  }

  public static Logger a(String paramString)
  {
    return ViberEnv.getLogger("release-tag");
  }

  @Deprecated
  public static b a()
  {
    if ((b == null) && (com.viber.voip.o.a.a() == com.viber.voip.o.a.a))
      b = new b();
    return b;
  }

  private void a(g paramg, f[] paramArrayOff)
  {
    int i = 0;
    if (paramg.c() != null)
      ViberApplication.getInstance().logToCrashlytics(paramg.c().toString());
    for (int j = 1; ; j = 0)
    {
      int k = paramArrayOff.length;
      while (i < k)
      {
        f localf = paramArrayOff[i];
        if (da.a(localf.b().getProviderId(), "google_play"))
        {
          ViberApplication.getInstance().logToCrashlytics(localf.b().toString());
          j = 1;
        }
        i++;
      }
      if (j != 0)
        a.a(new RuntimeException("ReportVO"), paramg.b);
      return;
    }
  }

  private static void a(n paramn)
  {
    g.a().a(new ad()
    {
      public void a(ac paramAnonymousac)
      {
        av.a(av.e.g).post(new c(paramAnonymousac, this.a));
      }

      public void a(ae paramAnonymousae)
      {
        this.a.a(b.h.b);
      }
    });
  }

  public static void a(o paramo)
  {
    new p(paramo).execute(new Void[0]);
  }

  private static c b(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    String str;
    try
    {
      OkHttpClient localOkHttpClient = ViberEnv.getOkHttpClientFactory().createBuilder().connectTimeout(paramInt, TimeUnit.MILLISECONDS).writeTimeout(paramInt, TimeUnit.MILLISECONDS).readTimeout(paramInt, TimeUnit.MILLISECONDS).build();
      localBuilder = new Request.Builder().url(paramString3);
      if (paramString1 != null)
        localBuilder.method("POST", new RequestBody()
        {
          public long contentLength()
          {
            return this.b.length;
          }

          public MediaType contentType()
          {
            return MediaType.parse(this.a);
          }

          public void writeTo(f.d paramAnonymousd)
            throws IOException
          {
            paramAnonymousd.c(this.b);
          }
        });
      while (paramMap == null)
      {
        Response localResponse = localOkHttpClient.newCall(localBuilder.build()).execute();
        str = localResponse.body().string();
        if (!localResponse.isSuccessful())
          break label271;
        if (!paramBoolean1)
          break;
        return new c(str, paramString3);
      }
      localBuilder1 = new FormBody.Builder();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBuilder1.add((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Request.Builder localBuilder;
        FormBody.Builder localBuilder1;
        return new c(localIOException);
        localBuilder.method("POST", localBuilder1.build());
      }
    }
    catch (JSONException localJSONException)
    {
      return new c(h.b);
    }
    return new c(new JSONObject(str), paramString3, paramBoolean2);
    label271: c localc = new c(new JSONObject(str), paramString3);
    return localc;
  }

  private static c b(String paramString, Map<String, String> paramMap, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return b(null, null, paramString, paramMap, paramBoolean1, paramInt, paramBoolean2);
  }

  private static c b(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return b(paramString, null, paramBoolean1, paramInt, paramBoolean2);
  }

  public static String b()
  {
    return cg.a();
  }

  private String b(String paramString)
  {
    if (da.a(paramString))
      return null;
    try
    {
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("destinations");
      int i = localJSONArray.length();
      StringBuilder localStringBuilder = new StringBuilder(i * 3);
      for (int j = 0; j < i; j++)
      {
        if (j > 0)
          localStringBuilder.append(',');
        localStringBuilder.append(localJSONArray.getString(j));
      }
      String str = localStringBuilder.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private static String b(String paramString, int paramInt)
    throws IOException
  {
    return bj.a(ViberEnv.getOkHttpClientFactory().createBuilder().connectTimeout(paramInt, TimeUnit.MILLISECONDS).readTimeout(paramInt, TimeUnit.MILLISECONDS).build().newCall(new Request.Builder().url(paramString).build()).execute().body().byteStream());
  }

  public static boolean d()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)ViberApplication.getApplication().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }

  public f a(IabProductId paramIabProductId)
  {
    if ((paramIabProductId != null) && (this.c != null) && (this.c.a != null))
      for (f localf : this.c.a)
        if (paramIabProductId.equals(localf.b()))
          return localf;
    return null;
  }

  public String a(int paramInt, String paramString)
  {
    String str1 = dl.h(dl.b(dl.j(ap.c().ar + "apps/" + paramInt + "/open")));
    try
    {
      AdvertisingIdClient.Info localInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(ViberApplication.getApplication());
      localInfo1 = localInfo2;
      if (!d.f.d.d());
      for (str2 = ""; ; str2 = localInfo1.getId())
      {
        Uri.Builder localBuilder = Uri.parse(str1).buildUpon().appendQueryParameter("google_ad_id", str2);
        if (paramString != null)
          localBuilder.appendQueryParameter("origin", paramString);
        return localBuilder.toString();
        if (localInfo1 == null)
          break;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        AdvertisingIdClient.Info localInfo1 = null;
        continue;
        String str2 = "";
      }
    }
  }

  public String a(t paramt)
  {
    String str1 = ap.c().ad;
    String str2 = str1 + "phone=" + paramt.c();
    return dl.j(dl.b(str2 + "&src_phone=" + b()));
  }

  public void a(final int paramInt, final String paramString, final m paramm)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        final String str = b.this.a(paramInt, paramString);
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            b.3.this.c.a(str);
          }
        });
      }
    });
  }

  public void a(IabProductId paramIabProductId, String paramString)
  {
    l.a().a(paramIabProductId, paramString);
  }

  public void a(IabProductId paramIabProductId, String paramString, Bundle paramBundle)
  {
    l.a().a(paramIabProductId, paramString, null, paramBundle);
  }

  public void a(IabProductId paramIabProductId, String paramString1, String paramString2, Bundle paramBundle)
  {
    l.a().a(paramIabProductId, paramString1, paramString2, paramBundle);
  }

  public void a(final ProductId paramProductId, final String paramString, final f paramf)
  {
    new s(paramProductId)
    {
      public String a()
      {
        return ap.c().ar + "products/add";
      }

      public void a(b.c paramAnonymousc)
      {
        paramf.a(paramAnonymousc);
      }

      public void a(Map<String, String> paramAnonymousMap)
      {
        com.viber.voip.registration.af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
        paramAnonymousMap.put("product_id", paramProductId.toString());
        paramAnonymousMap.put("udid", ViberApplication.getInstance().getHardwareParameters().getUdid());
        paramAnonymousMap.put("phone_country", UserManager.from(ViberApplication.getApplication()).getRegistrationValues().e());
        paramAnonymousMap.put("mcc", ViberApplication.getInstance().getHardwareParameters().getMCC());
        paramAnonymousMap.put("mnc", ViberApplication.getInstance().getHardwareParameters().getMNC());
        paramAnonymousMap.put("scid", String.valueOf(d.ax.t.d()));
        if (!da.a(paramString))
          paramAnonymousMap.put("custom_data", paramString);
        paramAnonymousMap.put("vv", p.d());
        paramAnonymousMap.put("uid", localaf.n());
        paramAnonymousMap.put("sid", Integer.toString(o.b()));
        paramAnonymousMap.put("lang", Locale.getDefault().getLanguage());
        paramAnonymousMap.put("privacy_flags", String.valueOf(com.viber.voip.gdpr.d.a()));
        paramAnonymousMap.put("member_id", localaf.l());
        paramAnonymousMap.put("phone_number", b.b());
      }
    }
    .c();
  }

  public void a(final ProductId paramProductId, final String paramString, final MarketApi.m paramm)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        try
        {
          AdvertisingIdClient.Info localInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(ViberApplication.getApplication());
          localInfo1 = localInfo2;
          if (localInfo1 != null);
          new b.s(localInfo1)
          {
            private String a(String paramAnonymous2String)
            {
              if (paramAnonymous2String == null)
                return "";
              try
              {
                String str = z.a(paramAnonymous2String);
                return str;
              }
              catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
              {
              }
              return paramAnonymous2String;
            }

            private String d()
            {
              return ((WifiManager)ViberApplication.getApplication().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            }

            public String a()
            {
              return ap.c().ar + "products/list_sponsored";
            }

            public void a(b.c paramAnonymous2c)
            {
              b.2.this.c.a(b.c.a(paramAnonymous2c));
            }

            public void a(Map<String, String> paramAnonymous2Map)
            {
              com.viber.voip.registration.af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
              paramAnonymous2Map.put("product_id", b.2.this.a.toString());
              paramAnonymous2Map.put("provider_id", b.2.this.b);
              paramAnonymous2Map.put("udid", ViberApplication.getInstance().getHardwareParameters().getUdid());
              paramAnonymous2Map.put("system", Integer.toString(o.b()));
              paramAnonymous2Map.put("phone_country", localaf.e());
              paramAnonymous2Map.put("language", Locale.getDefault().toString());
              paramAnonymous2Map.put("device_type", ViberApplication.getInstance().getHardwareParameters().getDeviceType());
              String str1;
              String str2;
              label224: String str3;
              if (ViberApplication.isTablet(ViberApplication.getApplication()))
              {
                str1 = "tablet";
                paramAnonymous2Map.put("device", str1);
                paramAnonymous2Map.put("device_id", ViberApplication.getInstance().getHardwareParameters().getIMEI());
                paramAnonymous2Map.put("android_id", Settings.Secure.getString(ViberApplication.getApplication().getContentResolver(), "android_id"));
                paramAnonymous2Map.put("os_version", Build.VERSION.RELEASE);
                if (!d.f.d.d())
                  break label400;
                if (localInfo1 != null)
                  break label388;
                str2 = "";
                paramAnonymous2Map.put("google_ad_id", str2);
                if (localInfo1 != null)
                  break label407;
                str3 = "";
              }
              while (true)
              {
                paramAnonymous2Map.put("google_ad_id_limited_tracking_enabled", str3);
                paramAnonymous2Map.put("viber_version", p.d());
                paramAnonymous2Map.put("sponsored_api_ver", "1");
                paramAnonymous2Map.put("mcc", ViberApplication.getInstance().getHardwareParameters().getMCC());
                paramAnonymous2Map.put("mnc", ViberApplication.getInstance().getHardwareParameters().getMNC());
                paramAnonymous2Map.put("sha1_mac", a(d()));
                paramAnonymous2Map.put("privacy_flags", String.valueOf(com.viber.voip.gdpr.d.a()));
                paramAnonymous2Map.put("member_id", localaf.l());
                paramAnonymous2Map.put("phone_number", b.b());
                return;
                str1 = "phone";
                break;
                label388: str2 = localInfo1.getId();
                break label224;
                label400: str2 = "";
                break label224;
                label407: if (localInfo1.isLimitAdTrackingEnabled())
                  str3 = "true";
                else
                  str3 = "false";
              }
            }

            protected boolean b()
            {
              return true;
            }
          }
          .c();
          return;
        }
        catch (Exception localException)
        {
          while (true)
            final AdvertisingIdClient.Info localInfo1 = null;
        }
      }
    });
  }

  public void a(final Purchase paramPurchase, final ProductDetails paramProductDetails, final y paramy)
  {
    new b(paramPurchase)
    {
      public String a()
      {
        return ap.c().ag + b.b() + "/products/" + paramPurchase.getStore() + "/purchase";
      }

      public void a(b.c paramAnonymousc)
      {
        paramy.a(paramAnonymousc);
      }

      public void a(Map<String, String> paramAnonymousMap)
      {
        if (paramPurchase.getStore().equals("amazon"))
        {
          paramAnonymousMap.put("receipt", paramPurchase.getToken());
          paramAnonymousMap.put("user_id", paramPurchase.getUserId());
        }
        while (true)
        {
          paramAnonymousMap.put("vv", p.d());
          paramAnonymousMap.put("sid", Integer.toString(o.b()));
          paramAnonymousMap.put("mnc", ViberApplication.getInstance().getHardwareParameters().getMNC());
          paramAnonymousMap.put("mcc", ViberApplication.getInstance().getHardwareParameters().getMCC());
          paramAnonymousMap.put("lang", Locale.getDefault().getLanguage());
          paramAnonymousMap.put("uid", UserManager.from(ViberApplication.getApplication()).getRegistrationValues().n());
          paramAnonymousMap.put("cc", UserManager.from(ViberApplication.getApplication()).getRegistrationValues().e());
          paramAnonymousMap.put("udid", ViberApplication.getInstance().getHardwareParameters().getUdid());
          paramAnonymousMap.put("privacy_flags", String.valueOf(com.viber.voip.gdpr.d.a()));
          return;
          String str = paramPurchase.getOriginalJson();
          paramAnonymousMap.put("tss", x.a(str, paramProductDetails.getPriceString()));
          paramAnonymousMap.put("receipt", str);
          paramAnonymousMap.put("signature", paramPurchase.getSignature());
        }
      }
    }
    .c();
  }

  public void a(final Purchase paramPurchase, final String paramString, final ProductDetails paramProductDetails, final boolean paramBoolean, final x paramx)
  {
    new s(paramPurchase)
    {
      public String a()
      {
        return ap.c().ar + "products/" + paramPurchase.getStore() + "/purchase";
      }

      public void a(b.c paramAnonymousc)
      {
        paramx.a(paramAnonymousc);
      }

      public void a(Map<String, String> paramAnonymousMap)
      {
        String str1;
        label99: com.viber.voip.registration.af localaf;
        if (paramPurchase.getStore().equals("amazon"))
        {
          paramAnonymousMap.put("receipt", paramPurchase.getToken());
          paramAnonymousMap.put("user_id", paramPurchase.getUserId());
          paramAnonymousMap.put("udid", ViberApplication.getInstance().getHardwareParameters().getUdid());
          paramAnonymousMap.put("phone_country", UserManager.from(ViberApplication.getApplication()).getRegistrationValues().e());
          if (paramProductDetails != null)
            break label359;
          str1 = "";
          paramAnonymousMap.put("price_string", str1);
          paramAnonymousMap.put("mcc", ViberApplication.getInstance().getHardwareParameters().getMCC());
          paramAnonymousMap.put("mnc", ViberApplication.getInstance().getHardwareParameters().getMNC());
          paramAnonymousMap.put("scid", String.valueOf(d.ax.t.d()));
          if (!da.a(paramString))
            paramAnonymousMap.put("custom_data", paramString);
          localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
          if (!paramBoolean)
            break label371;
        }
        label359: label371: for (String str2 = String.valueOf(1); ; str2 = String.valueOf(0))
        {
          paramAnonymousMap.put("restore", str2);
          paramAnonymousMap.put("vv", p.d());
          paramAnonymousMap.put("uid", localaf.n());
          paramAnonymousMap.put("sid", Integer.toString(o.b()));
          paramAnonymousMap.put("lang", Locale.getDefault().getLanguage());
          paramAnonymousMap.put("privacy_flags", String.valueOf(com.viber.voip.gdpr.d.a()));
          paramAnonymousMap.put("phone_number", b.b());
          paramAnonymousMap.put("member_id", localaf.l());
          return;
          paramAnonymousMap.put("receipt", paramPurchase.getOriginalJson());
          paramAnonymousMap.put("signature", paramPurchase.getSignature());
          break;
          str1 = paramProductDetails.getPriceString();
          break label99;
        }
      }
    }
    .c();
  }

  public void a(d paramd)
  {
    new e(paramd).execute(new Void[0]);
  }

  public void a(final g paramg, final j paramj)
  {
    ArrayList localArrayList = new ArrayList();
    f[] arrayOff = paramg.a;
    int i = arrayOff.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(arrayOff[j].b());
    l.a().c().queryProductDetailsAsync(localArrayList, new InAppBillingHelper.QueryProductDetailsFinishedListener()
    {
      public void onQueryProductDetailsFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        ArrayList localArrayList1 = new ArrayList(Arrays.asList(paramg.a));
        if (paramAnonymousIabResult.isSuccess())
        {
          ArrayList localArrayList2 = new ArrayList();
          for (f localf : paramg.a)
          {
            ProductDetails localProductDetails = paramAnonymousIabInventory.getProductDetails(localf.b());
            if (localProductDetails != null)
            {
              localf.b(localProductDetails.getPriceString());
              localf.a(localProductDetails.getPriceCurrencyCode());
              localArrayList2.add(localf);
              if (localArrayList1.contains(localf))
                localArrayList1.remove(localf);
            }
          }
          paramg.a = ((f[])localArrayList2.toArray(new f[localArrayList2.size()]));
        }
        while (true)
        {
          b.a(b.this, paramg, (f[])localArrayList1.toArray(new f[localArrayList1.size()]));
          paramj.a(paramg);
          return;
          b.g.a(paramg, paramAnonymousIabResult);
        }
      }
    });
  }

  public void a(final i parami)
  {
    a(new n()
    {
      public void a(com.viber.voip.api.a.b.a.e paramAnonymouse)
      {
        b.a locala = new b.a(paramAnonymouse, null);
        parami.a(locala);
      }

      public void a(b.h paramAnonymoush)
      {
        b.a locala = new b.a(null, paramAnonymoush);
        parami.a(locala);
      }
    });
  }

  public void a(j paramj)
  {
    a(true, null, paramj);
  }

  public void a(t paramt, v paramv)
  {
    String str = paramt.c();
    if (str != null)
    {
      u localu = (u)this.e.get(str);
      long l = SystemClock.elapsedRealtime();
      if ((localu == null) || (l - localu.a > 60000L))
      {
        localObject = (List)this.f.get(str);
        if (localObject == null)
        {
          localObject = new ArrayList();
          this.f.put(str, localObject);
          new l().execute(new t[] { paramt });
        }
        if (paramv != null)
          ((List)localObject).add(paramv);
      }
      while (paramv == null)
      {
        Object localObject;
        return;
      }
      paramv.a(paramt, localu);
      return;
    }
    paramv.a(paramt, null);
  }

  public void a(final w paramw)
  {
    new s(paramw)
    {
      public String a()
      {
        return ap.c().ar + "products/get";
      }

      public void a(b.c paramAnonymousc)
      {
        paramw.a(paramAnonymousc);
      }

      public void a(Map<String, String> paramAnonymousMap)
      {
        com.viber.voip.registration.af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
        paramAnonymousMap.put("phone_country", localaf.e());
        paramAnonymousMap.put("member_id", localaf.l());
        paramAnonymousMap.put("phone_number", b.b());
        paramAnonymousMap.put("include_free_desktop", String.valueOf(0));
      }
    }
    .c();
  }

  public void a(final Set<ParticipantSelector.Participant> paramSet, final q paramq)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        final ArrayList localArrayList = new ArrayList(paramSet.size());
        com.viber.voip.wallet.a locala = ViberApplication.getInstance().getWalletController();
        final CountDownLatch localCountDownLatch = new CountDownLatch(paramSet.size());
        final SparseArray localSparseArray = new SparseArray();
        Iterator localIterator = paramSet.iterator();
        while (localIterator.hasNext())
        {
          ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localIterator.next();
          localSparseArray.put(locala.a(localParticipant.getDisplayName(), localParticipant.getNumber(), new a.a()
          {
            public void a(int paramAnonymous2Int, a.c paramAnonymous2c, String paramAnonymous2String, a.b paramAnonymous2b)
            {
              String str = (String)localSparseArray.get(paramAnonymous2Int);
              if ((str != null) && (paramAnonymous2c == a.c.a))
              {
                localSparseArray.remove(paramAnonymous2Int);
                Pair localPair = new Pair(str, paramAnonymous2String);
                localArrayList.add(localPair);
              }
              localCountDownLatch.countDown();
            }
          }), localParticipant.getNumber());
        }
        try
        {
          localCountDownLatch.await(10000L, TimeUnit.MILLISECONDS);
          label133: if (localArrayList.size() > 0)
          {
            new b.r(b.this, paramq, localArrayList).execute(new Void[0]);
            return;
          }
          paramq.a(null);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label133;
        }
      }
    });
  }

  public void a(boolean paramBoolean, final String paramString, final j paramj)
  {
    if ((this.c != null) && (paramBoolean))
    {
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          paramj.a(b.a(b.this));
        }
      });
      return;
    }
    new com.viber.voip.market.b.e().a(2147483647, new MarketApi.f()
    {
      public void a(String paramAnonymousString)
      {
        b.k localk = new b.k(new b.j()
        {
          public void a(final b.g paramAnonymous2g)
          {
            if ((paramAnonymous2g != null) && (paramAnonymous2g.a()))
            {
              av.a(av.e.g).post(new Runnable()
              {
                public void run()
                {
                  b.this.a(paramAnonymous2g, new b.j()
                  {
                    public void a(b.g paramAnonymous4g)
                    {
                      b.a(b.this, paramAnonymous4g);
                      b.a(b.this, SystemClock.elapsedRealtime());
                      av.a(av.e.a).post(new Runnable()
                      {
                        public void run()
                        {
                          b.8.this.a.a(b.a(b.this));
                        }
                      });
                    }
                  });
                }
              });
              return;
            }
            b.8.this.a.a(paramAnonymous2g);
          }
        }
        , paramString);
        localk.a(b.a(b.this, paramAnonymousString));
        localk.execute(new Void[0]);
      }
    });
  }

  public String c()
  {
    String str = ap.c().ad;
    return dl.j(dl.b(str + "src_phone=" + b()));
  }

  public static class a
  {
    private final com.viber.voip.api.a.b.a.e a;
    private b.h b;
    private int c;
    private double d;
    private String e;
    private boolean f;

    public a(com.viber.voip.api.a.b.a.e parame, b.h paramh)
    {
      this.a = parame;
      this.b = paramh;
      if (parame != null)
      {
        if (parame.a() == 1)
        {
          this.d = parame.b().a();
          this.e = parame.b().b();
          this.c = this.a.c().length;
        }
      }
      else
        return;
      if (parame.a() == 102)
      {
        this.f = true;
        this.b = null;
        return;
      }
      this.b = b.h.b;
    }

    public b.h a()
    {
      return this.b;
    }

    public boolean b()
    {
      return this.b == null;
    }

    public boolean c()
    {
      return this.f;
    }

    public boolean d()
    {
      return this.d >= 0.005D;
    }

    public int e()
    {
      return this.c;
    }

    public double f()
    {
      return this.d;
    }

    public String g()
    {
      return this.e;
    }

    public String toString()
    {
      return "BalanceInfo{mError=" + this.b + ", mCallingPlansCount=" + this.c + ", mBalance=" + this.d + ", mBalanceString='" + this.e + '\'' + ", mIsInvalidUser=" + this.f + ", mResponse=" + this.a + '}';
    }
  }

  public abstract class b extends AsyncTask<Void, Void, b.c>
  {
    protected b.h g;

    public b()
    {
    }

    protected b.c a(Void[] paramArrayOfVoid)
    {
      String str = a();
      try
      {
        HashMap localHashMap = new HashMap();
        b(localHashMap);
        a(localHashMap);
        if (this.g == null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = localHashMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (localStringBuilder.length() > 0)
              localStringBuilder.append('&');
            if (localEntry.getValue() != null)
              localStringBuilder.append((String)localEntry.getKey()).append('=').append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
          }
          return b.a(str, localHashMap, b(), 30000, true);
        }
        b.c localc = new b.c(this.g);
        return localc;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
      }
      return null;
    }

    public abstract String a();

    public abstract void a(b.c paramc);

    protected void a(b.h paramh)
    {
      this.g = paramh;
    }

    public abstract void a(Map<String, String> paramMap);

    protected void b(b.c paramc)
    {
      a(paramc);
    }

    protected void b(Map<String, String> paramMap)
    {
    }

    protected boolean b()
    {
      return false;
    }

    public void c()
    {
      super.execute(new Void[0]);
    }
  }

  public static class c
  {
    JSONObject a;
    private String b;
    private int c = -1;
    private String d;
    private b.h e;

    public c(b.h paramh)
    {
      this.e = paramh;
    }

    public c(IOException paramIOException)
    {
      if (b.d())
      {
        this.e = b.h.c;
        return;
      }
      this.e = b.h.a;
    }

    public c(String paramString1, String paramString2)
    {
      this.b = paramString1;
      this.d = paramString2;
    }

    public c(JSONObject paramJSONObject, String paramString)
    {
      this(paramJSONObject, paramString, true);
    }

    public c(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
    {
      this.a = paramJSONObject;
      this.b = paramJSONObject.toString();
      this.d = paramString;
      if ((paramJSONObject != null) && (paramBoolean));
      try
      {
        if (paramJSONObject.has("status"))
        {
          this.c = paramJSONObject.getInt("status");
          if (this.c != i);
        }
        while (true)
        {
          if (i == 0)
            this.e = b.h.b;
          return;
          i = 0;
          continue;
          i = 0;
        }
      }
      catch (JSONException localJSONException)
      {
        this.e = b.h.b;
      }
    }

    public boolean a()
    {
      return this.e == null;
    }

    public b.h b()
    {
      return this.e;
    }

    public int c()
    {
      return this.c;
    }

    public JSONObject d()
    {
      return this.a;
    }

    public String e()
    {
      return "Error: " + this.e + ", Status: " + this.c;
    }
  }

  public static abstract interface d
  {
    public abstract void onBillingHealthIssues(int paramInt);

    public abstract void onBillingHealthOk();
  }

  public class e extends AsyncTask<Void, Void, Integer>
  {
    private b.d b;

    public e(b.d arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    protected Integer a(Void[] paramArrayOfVoid)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(b.a(ap.c().af + b.b(), 30000));
        if (localJSONObject.getBoolean("success"))
          return null;
        Integer localInteger = Integer.valueOf(localJSONObject.getInt("error_code"));
        return localInteger;
      }
      catch (Exception localException)
      {
      }
      return Integer.valueOf(-1);
    }

    protected void a(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        this.b.onBillingHealthOk();
        return;
      }
      this.b.onBillingHealthIssues(paramInteger.intValue());
    }
  }

  public static abstract interface f
  {
    public abstract void a(b.c paramc);
  }

  public static class g
  {
    public f[] a;
    public String b;
    private IabResult c;
    private b.h d;
    private Carrier e;

    // ERROR //
    @Deprecated
    public g(b.c paramc)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 24	java/lang/Object:<init>	()V
      //   4: aload_0
      //   5: aload_1
      //   6: invokevirtual 29	com/viber/voip/billing/b$c:b	()Lcom/viber/voip/billing/b$h;
      //   9: putfield 31	com/viber/voip/billing/b$g:d	Lcom/viber/voip/billing/b$h;
      //   12: aload_1
      //   13: invokevirtual 34	com/viber/voip/billing/b$c:a	()Z
      //   16: ifeq +279 -> 295
      //   19: aload_0
      //   20: aload_1
      //   21: invokestatic 37	com/viber/voip/billing/b$c:a	(Lcom/viber/voip/billing/b$c;)Ljava/lang/String;
      //   24: putfield 39	com/viber/voip/billing/b$g:b	Ljava/lang/String;
      //   27: aload_1
      //   28: getfield 42	com/viber/voip/billing/b$c:a	Lorg/json/JSONObject;
      //   31: ldc 44
      //   33: invokevirtual 50	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   36: astore_3
      //   37: new 52	java/util/ArrayList
      //   40: dup
      //   41: aload_3
      //   42: invokevirtual 58	org/json/JSONArray:length	()I
      //   45: invokespecial 61	java/util/ArrayList:<init>	(I)V
      //   48: astore 4
      //   50: new 63	android/support/v4/util/ArrayMap
      //   53: dup
      //   54: invokespecial 64	android/support/v4/util/ArrayMap:<init>	()V
      //   57: astore 5
      //   59: iconst_0
      //   60: istore 6
      //   62: iload 6
      //   64: aload_3
      //   65: invokevirtual 58	org/json/JSONArray:length	()I
      //   68: if_icmpge +228 -> 296
      //   71: aload_3
      //   72: iload 6
      //   74: invokevirtual 68	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
      //   77: astore 13
      //   79: aload 13
      //   81: invokevirtual 72	org/json/JSONObject:toString	()Ljava/lang/String;
      //   84: invokestatic 78	com/viber/voip/billing/IabProductId:fromString	(Ljava/lang/String;)Lcom/viber/voip/billing/IabProductId;
      //   87: astore 14
      //   89: aload 13
      //   91: ldc 80
      //   93: invokevirtual 84	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   96: astore 15
      //   98: aload 13
      //   100: ldc 86
      //   102: invokevirtual 84	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   105: astore 16
      //   107: aload 13
      //   109: ldc 88
      //   111: ldc 90
      //   113: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   116: astore 17
      //   118: aload 13
      //   120: ldc 96
      //   122: invokevirtual 100	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   125: ifeq +316 -> 441
      //   128: aload 13
      //   130: ldc 96
      //   132: invokevirtual 84	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   135: astore 23
      //   137: aload 23
      //   139: ifnull +302 -> 441
      //   142: aload 23
      //   144: invokestatic 106	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   147: istore 25
      //   149: iload 25
      //   151: istore 18
      //   153: aload 4
      //   155: iload 6
      //   157: new 108	com/viber/voip/billing/f
      //   160: dup
      //   161: aload 14
      //   163: new 110	java/lang/StringBuilder
      //   166: dup
      //   167: invokespecial 111	java/lang/StringBuilder:<init>	()V
      //   170: aload 16
      //   172: invokestatic 115	com/viber/voip/util/da:a	(Ljava/lang/String;)Ljava/lang/String;
      //   175: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: aload 15
      //   180: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   183: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   186: aload 15
      //   188: invokestatic 126	java/lang/Double:parseDouble	(Ljava/lang/String;)D
      //   191: aload 16
      //   193: iload 18
      //   195: aload 17
      //   197: invokespecial 129	com/viber/voip/billing/f:<init>	(Lcom/viber/voip/billing/IabProductId;Ljava/lang/String;DLjava/lang/String;ILjava/lang/String;)V
      //   200: invokeinterface 135 3 0
      //   205: aload 5
      //   207: iload 18
      //   209: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   212: invokeinterface 145 2 0
      //   217: ifnonnull +42 -> 259
      //   220: new 52	java/util/ArrayList
      //   223: dup
      //   224: invokespecial 146	java/util/ArrayList:<init>	()V
      //   227: astore 19
      //   229: aload 19
      //   231: aload_3
      //   232: iload 6
      //   234: invokevirtual 149	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   237: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   240: pop
      //   241: aload 5
      //   243: iload 18
      //   245: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   248: aload 19
      //   250: invokeinterface 156 3 0
      //   255: pop
      //   256: goto +191 -> 447
      //   259: aload 5
      //   261: iload 18
      //   263: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   266: invokeinterface 145 2 0
      //   271: checkcast 52	java/util/ArrayList
      //   274: aload_3
      //   275: iload 6
      //   277: invokevirtual 149	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   280: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   283: pop
      //   284: goto +163 -> 447
      //   287: astore_2
      //   288: aload_0
      //   289: getstatic 160	com/viber/voip/billing/b$h:b	Lcom/viber/voip/billing/b$h;
      //   292: putfield 31	com/viber/voip/billing/b$g:d	Lcom/viber/voip/billing/b$h;
      //   295: return
      //   296: aload_0
      //   297: aload 4
      //   299: invokespecial 163	com/viber/voip/billing/b$g:a	(Ljava/util/List;)V
      //   302: aload_0
      //   303: aload 4
      //   305: invokeinterface 166 1 0
      //   310: anewarray 108	com/viber/voip/billing/f
      //   313: putfield 168	com/viber/voip/billing/b$g:a	[Lcom/viber/voip/billing/f;
      //   316: aload 4
      //   318: aload_0
      //   319: getfield 168	com/viber/voip/billing/b$g:a	[Lcom/viber/voip/billing/f;
      //   322: invokeinterface 172 2 0
      //   327: pop
      //   328: aload_0
      //   329: getfield 168	com/viber/voip/billing/b$g:a	[Lcom/viber/voip/billing/f;
      //   332: astore 8
      //   334: aload 8
      //   336: arraylength
      //   337: istore 9
      //   339: iconst_0
      //   340: istore 10
      //   342: iload 10
      //   344: iload 9
      //   346: if_icmpge +39 -> 385
      //   349: aload 8
      //   351: iload 10
      //   353: aaload
      //   354: astore 11
      //   356: aload 11
      //   358: aload 5
      //   360: aload 11
      //   362: invokevirtual 175	com/viber/voip/billing/f:f	()I
      //   365: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   368: invokeinterface 145 2 0
      //   373: checkcast 52	java/util/ArrayList
      //   376: invokevirtual 178	com/viber/voip/billing/f:a	(Ljava/util/ArrayList;)V
      //   379: iinc 10 1
      //   382: goto -40 -> 342
      //   385: aload_1
      //   386: getfield 42	com/viber/voip/billing/b$c:a	Lorg/json/JSONObject;
      //   389: ldc 180
      //   391: invokevirtual 184	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   394: astore 12
      //   396: aload 12
      //   398: ifnull -103 -> 295
      //   401: aload_0
      //   402: new 186	com/viber/voip/billing/Carrier
      //   405: dup
      //   406: invokespecial 187	com/viber/voip/billing/Carrier:<init>	()V
      //   409: putfield 189	com/viber/voip/billing/b$g:e	Lcom/viber/voip/billing/Carrier;
      //   412: aload_0
      //   413: getfield 189	com/viber/voip/billing/b$g:e	Lcom/viber/voip/billing/Carrier;
      //   416: aload 12
      //   418: ldc 191
      //   420: invokevirtual 84	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   423: invokevirtual 195	com/viber/voip/billing/Carrier:setName	(Ljava/lang/String;)V
      //   426: aload_0
      //   427: getfield 189	com/viber/voip/billing/b$g:e	Lcom/viber/voip/billing/Carrier;
      //   430: aload 12
      //   432: ldc 197
      //   434: invokevirtual 84	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   437: invokevirtual 200	com/viber/voip/billing/Carrier:setImage	(Ljava/lang/String;)V
      //   440: return
      //   441: iconst_0
      //   442: istore 18
      //   444: goto -291 -> 153
      //   447: iinc 6 1
      //   450: goto -388 -> 62
      //   453: astore 24
      //   455: iconst_0
      //   456: istore 18
      //   458: goto -305 -> 153
      //
      // Exception table:
      //   from	to	target	type
      //   19	59	287	org/json/JSONException
      //   62	137	287	org/json/JSONException
      //   142	149	287	org/json/JSONException
      //   153	256	287	org/json/JSONException
      //   259	284	287	org/json/JSONException
      //   296	339	287	org/json/JSONException
      //   349	379	287	org/json/JSONException
      //   385	396	287	org/json/JSONException
      //   401	440	287	org/json/JSONException
      //   142	149	453	java/lang/NumberFormatException
    }

    public g(ArrayList<String> paramArrayList)
    {
      this.b = Arrays.toString(paramArrayList.toArray());
      f[] arrayOff = new f[paramArrayList.size()];
      for (int i = 0; i < paramArrayList.size(); i++)
        arrayOff[i] = new f(IabProductId.fromString((String)paramArrayList.get(i)));
      this.a = arrayOff;
    }

    private void a(List<f> paramList)
    {
      Collections.sort(paramList, new Comparator()
      {
        public int a(f paramAnonymousf1, f paramAnonymousf2)
        {
          return Integer.valueOf(this.a.indexOf(paramAnonymousf1.b().getProviderId())).compareTo(Integer.valueOf(this.a.indexOf(paramAnonymousf2.b().getProviderId())));
        }
      });
    }

    public void a(Carrier paramCarrier)
    {
      this.e = paramCarrier;
    }

    public boolean a()
    {
      return this.d == null;
    }

    public b.h b()
    {
      return this.d;
    }

    public IabResult c()
    {
      return this.c;
    }

    public f[] d()
    {
      return this.a;
    }
  }

  public static enum h
  {
    static
    {
      h[] arrayOfh = new h[3];
      arrayOfh[0] = a;
      arrayOfh[1] = b;
      arrayOfh[2] = c;
    }
  }

  public static abstract interface i
  {
    public abstract void a(b.a parama);
  }

  public static abstract interface j
  {
    public abstract void a(b.g paramg);
  }

  @Deprecated
  private static class k extends AsyncTask<Void, Void, b.g>
  {
    private b.j a;
    private String b;
    private String c;

    public k(b.j paramj, String paramString)
    {
      this.a = paramj;
      this.b = paramString;
    }

    protected b.g a(Void[] paramArrayOfVoid)
    {
      try
      {
        String str1 = ap.c().ab;
        String str2 = dl.b(dl.i(dl.h(str1 + b.b() + "/products/android/list")));
        if (!da.a(this.b))
          str2 = Uri.parse(str2).buildUpon().appendQueryParameter("referral", this.b).build().toString();
        if (!da.a(this.c))
          str2 = Uri.parse(str2).buildUpon().appendQueryParameter("top_countries", this.c).build().toString();
        if (d.ah.e.d())
          str2 = Uri.parse(str2).buildUpon().appendQueryParameter("googleplay_subscription", "1").build().toString();
        b.g localg = new b.g(b.a(str2, new HashMap(), false, 30000, false));
        return localg;
      }
      catch (Exception localException)
      {
      }
      return null;
    }

    protected void a(b.g paramg)
    {
      this.a.a(paramg);
    }

    public void a(String paramString)
    {
      this.c = paramString;
    }
  }

  public class l extends AsyncTask<b.t, Void, b.u>
  {
    private b.t b;

    public l()
    {
    }

    protected b.u a(b.t[] paramArrayOft)
    {
      int i = 1;
      this.b = paramArrayOft[0];
      label214: label221: label232: label235: 
      while (true)
      {
        String str3;
        String str5;
        try
        {
          StringBuilder localStringBuilder1 = new StringBuilder(ap.c().ac);
          String str1 = b.b();
          localStringBuilder1.append("format=json&src=").append(str1).append("&target=").append(this.b.c());
          JSONObject localJSONObject = new JSONObject(b.a(localStringBuilder1.toString(), 30000));
          if (localJSONObject.getBoolean("success"))
          {
            String str2 = localJSONObject.getString("src_region");
            if ("EU".equals(str2))
              break label232;
            break label221;
            double d = localJSONObject.getDouble(str3);
            String str4 = da.a(str2);
            StringBuilder localStringBuilder2 = new StringBuilder().append(str4);
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Double.valueOf(d);
            str5 = String.format("%.3f", arrayOfObject);
            if (!str5.endsWith("0"))
              break label214;
            str6 = str5.substring(0, -1 + str5.length());
            return new b.u(str6);
            str3 = "eur";
            continue;
          }
        }
        catch (Exception localException)
        {
        }
        return null;
        String str6 = str5;
        continue;
        while (true)
        {
          if (i == 0)
            break label235;
          str3 = "usd";
          break;
          i = 0;
        }
      }
    }

    protected void a(b.u paramu)
    {
      if (paramu != null)
        b.b(b.this).put(this.b.c(), paramu);
      List localList = (List)b.c(b.this).get(this.b.c());
      if (localList != null)
      {
        Iterator localIterator = new ArrayList(localList).iterator();
        while (localIterator.hasNext())
          ((b.v)localIterator.next()).a(this.b, paramu);
      }
      b.c(b.this).remove(this.b.c());
    }
  }

  public static abstract interface m
  {
    public abstract void a(String paramString);
  }

  private static abstract interface n
  {
    public abstract void a(com.viber.voip.api.a.b.a.e parame);

    public abstract void a(b.h paramh);
  }

  public static abstract interface o
  {
    public abstract void a(b.c paramc);
  }

  private static class p extends AsyncTask<Void, Void, b.c>
  {
    b.o a;

    p(b.o paramo)
    {
      this.a = paramo;
    }

    protected b.c a(Void[] paramArrayOfVoid)
    {
      try
      {
        String str = ap.c().Z;
        b.c localc = b.a(dl.a(str + b.b() + "/referral/settings", g.a().b()), false, 30000, true);
        return localc;
      }
      catch (Exception localException)
      {
      }
      return null;
    }

    protected void a(b.c paramc)
    {
      if (this.a != null)
        this.a.a(paramc);
    }
  }

  public static abstract interface q
  {
    public abstract void a(b.c paramc);
  }

  private class r extends AsyncTask<Void, Void, b.c>
  {
    b.q a;
    List<Pair<String, String>> b;

    r(List<Pair<String, String>> arg2)
    {
      Object localObject1;
      this.a = localObject1;
      Object localObject2;
      this.b = localObject2;
    }

    protected b.c a(Void[] paramArrayOfVoid)
    {
      try
      {
        String str1 = ap.c().Z;
        String str2 = str1 + b.b() + "/referral/invite";
        ac localac = g.a().b();
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("token", localac.b);
        localJSONObject1.put("ts", localac.a);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          try
          {
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("phone_number", cg.b((String)localPair.first));
            localJSONObject2.put("service_token", localPair.second);
            localJSONArray.put(localJSONObject2);
          }
          catch (JSONException localJSONException)
          {
          }
        }
        localJSONObject1.put("invites", localJSONArray);
        b.c localc = b.a(localJSONObject1.toString(), "application/json", str2, null, false, 30000, false);
        return localc;
      }
      catch (Exception localException)
      {
        b.e().a(localException, "BillingServerResponse, error");
      }
      return null;
    }

    protected void a(b.c paramc)
    {
      if (this.a != null)
        this.a.a(paramc);
    }
  }

  public abstract class s extends b.b
  {
    ac i;
    ac j;

    public s()
    {
      super();
    }

    protected void b(Map<String, String> paramMap)
    {
      if ((this.i != null) && (this.j != null))
      {
        paramMap.put("token", this.i.b);
        paramMap.put("ts", Long.toString(this.i.a));
        paramMap.put("m_token", this.j.b);
        paramMap.put("m_ts", Long.toString(this.j.a));
        return;
      }
      a(b.h.b);
    }

    public void c()
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(2);
      i.a().a(new ad()
      {
        public void a(ac paramAnonymousac)
        {
          b.s.this.j = paramAnonymousac;
          localCountDownLatch.countDown();
        }

        public void a(ae paramAnonymousae)
        {
          localCountDownLatch.countDown();
        }
      });
      g.a().a(new ad()
      {
        public void a(ac paramAnonymousac)
        {
          b.s.this.i = paramAnonymousac;
          localCountDownLatch.countDown();
        }

        public void a(ae paramAnonymousae)
        {
          localCountDownLatch.countDown();
        }
      });
      try
      {
        localCountDownLatch.await();
        label43: a(this);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label43;
      }
    }
  }

  public static class t
    implements Serializable
  {
    private String a;
    private String b;
    private String c;

    public t(String paramString)
    {
      this.a = paramString;
      this.b = dr.a(ViberApplication.getInstance(), paramString, null);
    }

    public String a()
    {
      return this.a;
    }

    public void a(final a parama)
    {
      if (this.c != null)
      {
        parama.a(this.c);
        return;
      }
      if (this.b != null);
      for (String str = this.b; ; str = this.a)
      {
        ViberApplication.getInstance().getContactManager().c().a(str, new m.b()
        {
          public void a(String paramAnonymousString, Set<com.viber.voip.model.a> paramAnonymousSet)
          {
            if (paramAnonymousSet != null)
            {
              Iterator localIterator = paramAnonymousSet.iterator();
              if (localIterator.hasNext())
              {
                com.viber.voip.model.a locala = (com.viber.voip.model.a)localIterator.next();
                b.t.a(b.t.this, locala.k());
                parama.a(b.t.a(b.t.this));
                return;
              }
            }
            parama.a(null);
          }
        });
        return;
      }
    }

    public String b()
    {
      return this.b;
    }

    public String c()
    {
      if (this.b != null)
        return this.b.substring(1);
      return null;
    }

    public static abstract interface a
    {
      public abstract void a(String paramString);
    }
  }

  public static class u
  {
    public long a;
    public String b;

    public u(String paramString)
    {
      this.b = paramString;
      this.a = SystemClock.elapsedRealtime();
    }
  }

  public static abstract interface v
  {
    public abstract void a(b.t paramt, b.u paramu);
  }

  public static abstract interface w
  {
    public abstract void a(b.c paramc);
  }

  public static abstract interface x
  {
    public abstract void a(b.c paramc);
  }

  public static abstract interface y
  {
    public abstract void a(b.c paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.b
 * JD-Core Version:    0.6.2
 */