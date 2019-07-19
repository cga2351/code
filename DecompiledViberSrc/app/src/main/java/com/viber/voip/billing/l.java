package com.viber.voip.billing;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.StoryConstants.y.a;
import com.viber.voip.analytics.story.l.c;
import com.viber.voip.analytics.story.l.f;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.d.j;
import com.viber.voip.contacts.c.d.n.a;
import com.viber.voip.o.a;
import com.viber.voip.settings.d.z;
import com.viber.voip.ui.dialogs.af;
import com.viber.voip.util.bu;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;
import java.util.zip.Adler32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.ActivityListener;
import org.onepf.oms.InAppBillingHelper.OnConsumeFinishedListener;
import org.onepf.oms.InAppBillingHelper.OnConsumeMultiFinishedListener;
import org.onepf.oms.InAppBillingHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.InAppBillingHelper.OnIabSetupFinishedListener;
import org.onepf.oms.InAppBillingHelper.QueryInventoryFinishedListener;
import org.onepf.oms.InAppBillingHelper.QueryProductDetailsFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;

public class l
{
  private static final Logger a = b.a(l.class);
  private static volatile l b;
  private Context c;
  private InAppBillingHelper d;
  private s e;
  private ArrayList<u> f = new ArrayList(2);
  private Handler g = av.a(av.e.a);
  private boolean h;
  private w i;
  private u j;
  private e k;
  private String l;
  private Runnable m = new Runnable()
  {
    public void run()
    {
      if (!l.this.e().a())
        l.c(l.this);
    }
  };
  private v n = new v()
  {
    public void a()
    {
      PurchaseSupportActivity.a();
    }

    public void a(final IabProductId paramAnonymousIabProductId)
    {
      l.a().c().queryProductDetailsAsync(paramAnonymousIabProductId, new InAppBillingHelper.QueryProductDetailsFinishedListener()
      {
        public void onQueryProductDetailsFinished(IabResult paramAnonymous2IabResult, IabInventory paramAnonymous2IabInventory)
        {
          Purchase localPurchase = paramAnonymous2IabInventory.getPurchase(paramAnonymousIabProductId);
          if (localPurchase != null)
          {
            l.6.this.a(localPurchase);
            return;
          }
          l.j().a(new Exception("Consume owned item " + paramAnonymousIabProductId.getMerchantProductId() + " failed: " + paramAnonymous2IabResult.getResponse()), paramAnonymous2IabResult.getMessage());
        }
      });
    }

    public void a(Purchase paramAnonymousPurchase)
    {
      l.this.c().consumeAsync(paramAnonymousPurchase, new InAppBillingHelper.OnConsumeFinishedListener()
      {
        public void onConsumeFinished(Purchase paramAnonymous2Purchase, IabResult paramAnonymous2IabResult)
        {
          boolean bool = paramAnonymous2IabResult.isSuccess();
          if ((!bool) && (paramAnonymous2IabResult.getResponse() == 8))
            bool = true;
          if (bool)
          {
            l.a(l.this, paramAnonymous2Purchase).b(paramAnonymous2Purchase);
            if (paramAnonymous2Purchase.isRetrying())
              l.this.e().b(paramAnonymous2Purchase);
            return;
          }
          l.this.e().a(paramAnonymous2Purchase);
        }
      });
    }

    public void a(final Purchase paramAnonymousPurchase, String paramAnonymousString)
    {
      final u localu = l.a(l.this, paramAnonymousPurchase);
      localu.a(paramAnonymousPurchase, paramAnonymousString, new u.a()
      {
        public void a(z paramAnonymous2z)
        {
          localu.a(paramAnonymousPurchase, paramAnonymous2z);
        }
      });
    }

    public void a(String paramAnonymousString)
    {
      PurchaseSupportActivity.a(paramAnonymousString);
    }

    public void b()
    {
      l.this.f();
    }

    public void b(Purchase paramAnonymousPurchase)
    {
      av.a(av.e.f).post(new r(this, paramAnonymousPurchase));
    }

    public void c()
    {
      PurchaseSupportActivity.b();
    }

    public void c(Purchase paramAnonymousPurchase)
    {
      l.this.e().a(paramAnonymousPurchase);
    }

    public Context d()
    {
      return l.f(l.this);
    }
  };

  private l(Context paramContext, com.viber.voip.analytics.g paramg)
  {
    this.c = paramContext;
    this.j = new u(this.n);
    this.f.add(new ab(this.n));
    this.f.add(new y(this.n));
    this.e = new t();
    this.i = new w(this);
    this.i.a(new w.a()
    {
      public void a()
      {
        l.a(l.this);
      }
    });
    this.k = new com.viber.voip.analytics.story.m.g(paramg);
  }

  private b.c a(Purchase paramPurchase, ProductDetails paramProductDetails)
  {
    final SynchronousQueue localSynchronousQueue = new SynchronousQueue();
    b.a().a(paramPurchase, null, paramProductDetails, true, new b.x()
    {
      public void a(b.c paramAnonymousc)
      {
        try
        {
          localSynchronousQueue.put(paramAnonymousc);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    });
    try
    {
      b.c localc = (b.c)localSynchronousQueue.take();
      return localc;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    return null;
  }

  private c<IabInventory> a(ArrayList<IabProductId> paramArrayList)
  {
    final SynchronousQueue localSynchronousQueue = new SynchronousQueue();
    a().c().queryInventoryAsync(true, paramArrayList, new InAppBillingHelper.QueryInventoryFinishedListener()
    {
      public void onQueryInventoryFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        l.c localc = new l.c(paramAnonymousIabResult.isSuccess(), paramAnonymousIabInventory);
        try
        {
          localSynchronousQueue.put(localc);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    });
    try
    {
      c localc = (c)localSynchronousQueue.take();
      return localc;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    return null;
  }

  private e a(d paramd, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    c localc1 = p();
    localArrayList1.addAll(((IabInventory)localc1.a()).getAllOwnedProductIds());
    if (!localc1.a)
      return new e(false, 0);
    if (paramd == d.b)
    {
      b.c localc = q();
      if (localc.c() == 1);
      for (int i4 = 1; i4 == 0; i4 = 0)
        return new e(false, 0);
      localArrayList4 = a(localc);
      Iterator localIterator3 = new ArrayList(localArrayList1).iterator();
      while (localIterator3.hasNext())
      {
        IabProductId localIabProductId3 = (IabProductId)localIterator3.next();
        Iterator localIterator4 = localArrayList4.iterator();
        while (localIterator4.hasNext())
        {
          IabProductId localIabProductId4 = (IabProductId)localIterator4.next();
          if (localIabProductId3.getProductId().equals(localIabProductId4.getProductId()))
            localArrayList1.remove(localIabProductId3);
        }
      }
    }
    ArrayList localArrayList4 = localArrayList2;
    if ((localArrayList1.isEmpty()) && (localArrayList4.isEmpty()))
      return new e(true, 0);
    if (!localArrayList1.isEmpty())
    {
      c localc2 = a(localArrayList1);
      if (!localc2.a)
        return new e(false, 0);
      Map localMap = a(localc2);
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        IabProductId localIabProductId2 = (IabProductId)localIterator2.next();
        if (((b.c)localMap.get(localIabProductId2)).a())
          localArrayList3.add(localIabProductId2);
      }
    }
    localArrayList3.addAll(localArrayList4);
    int i1 = localArrayList3.size();
    Iterator localIterator1 = localArrayList3.iterator();
    int i2 = i1;
    if (localIterator1.hasNext())
    {
      IabProductId localIabProductId1 = (IabProductId)localIterator1.next();
      if (b(localIabProductId1).a(localIabProductId1, paramBoolean))
        break label431;
    }
    label431: for (int i3 = i2 - 1; ; i3 = i2)
    {
      i2 = i3;
      break;
      return new e(true, i2);
    }
  }

  public static l a()
  {
    if (a.a() != a.a)
      return null;
    if (b == null)
      b = new l(ViberApplication.getApplication(), com.viber.voip.analytics.g.a());
    return b;
  }

  private ArrayList<IabProductId> a(b.c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramc.c() != 1);
    while (true)
    {
      return localArrayList;
      if (paramc.d() != null)
        try
        {
          JSONArray localJSONArray = paramc.d().getJSONObject("products").getJSONArray("stickers");
          int i1 = 0;
          while (i1 < localJSONArray.length())
          {
            IabProductId localIabProductId = IabProductId.fromString(localJSONArray.getJSONObject(i1).toString());
            try
            {
              localArrayList.add(localIabProductId);
              i1++;
            }
            finally
            {
            }
          }
        }
        catch (JSONException localJSONException)
        {
        }
    }
    return localArrayList;
  }

  private Map<IabProductId, b.c> a(c<IabInventory> paramc)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = ((IabInventory)paramc.a()).getAllOwnedProductIds().iterator();
    while (localIterator.hasNext())
    {
      IabProductId localIabProductId = (IabProductId)localIterator.next();
      localArrayMap.put(localIabProductId, a(((IabInventory)paramc.a()).getPurchase(localIabProductId), ((IabInventory)paramc.a()).getProductDetails(localIabProductId)));
    }
    return localArrayMap;
  }

  private Map<IabProductId, b.c> a(c<IabInventory> paramc, List<IabProductId> paramList)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IabProductId localIabProductId = (IabProductId)localIterator.next();
      localArrayMap.put(localIabProductId, b(((IabInventory)paramc.a()).getPurchase(localIabProductId), ((IabInventory)paramc.a()).getProductDetails(localIabProductId)));
    }
    return localArrayMap;
  }

  private void a(int paramInt, final IabProductId paramIabProductId, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramIabProductId);
    c().queryProductDetailsAsync(localArrayList, new InAppBillingHelper.QueryProductDetailsFinishedListener()
    {
      public void onQueryProductDetailsFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        if ((paramAnonymousIabResult.isSuccess()) && (paramAnonymousIabInventory.getProductDetails(paramIabProductId) == null));
      }
    });
  }

  private void a(IabProductId paramIabProductId, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    l();
    PurchaseSupportActivity.a(paramIabProductId, paramString1, paramString2, paramString3, s(), paramBundle);
  }

  private void a(final Purchase paramPurchase, final String paramString, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPurchase.getProductId());
    c().queryProductDetailsAsync(localArrayList, new InAppBillingHelper.QueryProductDetailsFinishedListener()
    {
      public void onQueryProductDetailsFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        if (paramAnonymousIabResult.isSuccess())
        {
          ProductDetails localProductDetails = paramAnonymousIabInventory.getProductDetails(paramPurchase.getProductId());
          String str1;
          if (localProductDetails != null)
          {
            str1 = h.a(localProductDetails.getPriceAmountMicros(), 2);
            switch (l.7.a[localProductDetails.getProductId().getProductId().getCategory().ordinal()])
            {
            default:
            case 1:
            case 2:
            case 3:
            }
          }
          while (true)
          {
            com.viber.voip.analytics.g.a().a(c.a(localProductDetails.getProductId().getProductId().getStringId(), localProductDetails.getTitle()));
            String str2 = localProductDetails.parsePrice().a();
            if (TextUtils.isEmpty(str2))
              str2 = localProductDetails.getPriceString();
            ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPurchaseStatusStatistics(localProductDetails.getProductId().getMerchantProductId(), paramAnonymousIabResult.getResponse(), str2, localProductDetails.getPriceCurrencyCode());
            return;
            com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.h.a(str1, localProductDetails.getPriceCurrencyCode(), localProductDetails.getTitle()));
            continue;
            com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.a(str1, localProductDetails.getPriceCurrencyCode(), localProductDetails.getTitle()));
            l.d(l.this).b(str1, localProductDetails.getPriceCurrencyCode(), localProductDetails.getTitle());
            String str3 = StoryConstants.y.a.a(paramString, localProductDetails.mItemType);
            if (!da.a(str3))
            {
              l.d(l.this).d(str3);
              continue;
              com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.b(str1, localProductDetails.getPriceCurrencyCode(), localProductDetails.getTitle()));
              com.viber.voip.analytics.g.a().a(f.a(str1, localProductDetails.getPriceCurrencyCode(), paramPurchase.getProductId().getProductId().getPackageId(), localProductDetails.getTitle()));
            }
          }
        }
        com.viber.voip.banner.i locali = com.viber.voip.banner.i.a();
        j[] arrayOfj = new j[1];
        arrayOfj[0] = j.h;
        locali.a(arrayOfj);
      }
    });
  }

  public static void a(a parama, boolean paramBoolean)
  {
    b(parama, d.b, paramBoolean);
  }

  public static void a(b paramb)
  {
    av.a(av.e.g).post(new m(paramb));
  }

  private void a(final InAppBillingHelper paramInAppBillingHelper)
  {
    paramInAppBillingHelper.startSetup(new InAppBillingHelper.OnIabSetupFinishedListener()
    {
      public void onIabSetupFinished(IabResult paramAnonymousIabResult)
      {
        if (paramAnonymousIabResult.isFailure())
          paramInAppBillingHelper.dispose();
      }
    });
  }

  private b.c b(Purchase paramPurchase, ProductDetails paramProductDetails)
  {
    SynchronousQueue localSynchronousQueue = new SynchronousQueue();
    b.a().a(paramPurchase, paramProductDetails, new o(localSynchronousQueue));
    try
    {
      b.c localc = (b.c)localSynchronousQueue.take();
      return localc;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    return null;
  }

  private u b(IabProductId paramIabProductId)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      if (localu.a(paramIabProductId))
        return localu;
    }
    return this.j;
  }

  private u b(Purchase paramPurchase)
  {
    return b(paramPurchase.getProductId());
  }

  private static void b(a parama, d paramd, boolean paramBoolean)
  {
    av.a(av.e.g).post(new n(parama, paramd, paramBoolean));
  }

  public static void b(a parama, boolean paramBoolean)
  {
    b(parama, d.a, paramBoolean);
  }

  private void c(a parama, d paramd, boolean paramBoolean)
  {
    e locale;
    if (cj.b(this.c))
    {
      locale = a(paramd, paramBoolean);
      d.z.a.a(true);
    }
    while (true)
    {
      if (parama != null)
        this.g.post(new p(parama, locale));
      return;
      locale = new e(false, 0);
    }
  }

  private void c(b paramb)
  {
    if (cj.b(this.c));
    for (e locale = r(); ; locale = new e(false, 0))
    {
      if (paramb != null)
        this.g.post(new q(paramb, locale));
      return;
    }
  }

  public static String d()
  {
    try
    {
      String str = OpenIabHelperWrapper.getPreferredStore();
      boolean bool = da.a(str);
      if (!bool)
        return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "google";
  }

  // ERROR //
  private InAppBillingHelper k()
  {
    // Byte code:
    //   0: new 492	com/viber/voip/billing/OpenIabHelperWrapper
    //   3: dup
    //   4: aload_0
    //   5: getfield 79	com/viber/voip/billing/l:c	Landroid/content/Context;
    //   8: invokespecial 508	com/viber/voip/billing/OpenIabHelperWrapper:<init>	(Landroid/content/Context;)V
    //   11: astore_1
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 510	com/viber/voip/billing/l:a	(Lorg/onepf/oms/InAppBillingHelper;)V
    //   17: aload_1
    //   18: ifnull +8 -> 26
    //   21: aload_1
    //   22: areturn
    //   23: astore_3
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull -6 -> 21
    //   30: invokestatic 514	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   33: new 516	java/lang/RuntimeException
    //   36: dup
    //   37: ldc_w 518
    //   40: invokespecial 521	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 525	com/viber/voip/ViberApplication:logToCrashlytics	(Ljava/lang/Throwable;)V
    //   46: aload_1
    //   47: areturn
    //   48: astore_2
    //   49: goto -23 -> 26
    //
    // Exception table:
    //   from	to	target	type
    //   0	12	23	java/lang/Throwable
    //   12	17	48	java/lang/Throwable
  }

  private void l()
  {
    this.h = true;
    this.g.removeCallbacks(this.m);
  }

  private void m()
  {
    this.h = false;
    n();
  }

  private void n()
  {
    this.g.removeCallbacks(this.m);
    if (!this.h)
      this.g.postDelayed(this.m, 30000L);
  }

  private void o()
  {
    try
    {
      if (this.d != null)
      {
        this.d.setActivityListener(null);
        this.d.dispose();
        this.d = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private c<IabInventory> p()
  {
    final SynchronousQueue localSynchronousQueue = new SynchronousQueue();
    a().c().queryInventoryAsync(true, null, new InAppBillingHelper.QueryInventoryFinishedListener()
    {
      public void onQueryInventoryFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        l.c localc = new l.c(paramAnonymousIabResult.isSuccess(), paramAnonymousIabInventory);
        try
        {
          localSynchronousQueue.put(localc);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    });
    try
    {
      c localc = (c)localSynchronousQueue.take();
      return localc;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    return null;
  }

  private b.c q()
  {
    final SynchronousQueue localSynchronousQueue = new SynchronousQueue();
    b.a().a(new b.w()
    {
      public void a(b.c paramAnonymousc)
      {
        try
        {
          localSynchronousQueue.put(paramAnonymousc);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    });
    try
    {
      b.c localc = (b.c)localSynchronousQueue.take();
      return localc;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    return null;
  }

  private e r()
  {
    ArrayList localArrayList = new ArrayList();
    c localc1 = p();
    if (localc1.a)
    {
      Iterator localIterator = ((IabInventory)localc1.a()).getAllOwnedProductIds("subs").iterator();
      while (localIterator.hasNext())
        localArrayList.add(IabProductId.fromStringAndType(((IabProductId)localIterator.next()).getMerchantProductId(), "subs"));
      if (!localArrayList.isEmpty())
      {
        c localc2 = a(localArrayList);
        if (!localc2.a)
          return new e(false, 0);
        return new e(true, a(localc2, localArrayList).size());
      }
      return new e(true, 0);
    }
    return new e(false, 0);
  }

  private String s()
  {
    try
    {
      if (this.l == null)
      {
        this.l = Settings.Secure.getString(this.c.getContentResolver(), "android_id");
        if (this.l != null)
          this.l = bu.a(this.l);
      }
      String str = this.l;
      return str;
    }
    finally
    {
    }
  }

  public Purchase a(String paramString)
  {
    return this.e.a(paramString);
  }

  public void a(IabProductId paramIabProductId)
  {
    a(paramIabProductId, null, null, null, null);
  }

  public void a(IabProductId paramIabProductId, String paramString)
  {
    a(paramIabProductId, paramString, null, null, null);
  }

  public void a(IabProductId paramIabProductId, String paramString, Bundle paramBundle)
  {
    a(paramIabProductId, null, null, paramString, paramBundle);
  }

  public void a(IabProductId paramIabProductId, String paramString1, String paramString2)
  {
    a(paramIabProductId, paramString1, paramString2, null, null);
  }

  public void a(IabProductId paramIabProductId, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramIabProductId, paramString1, paramString2, null, paramBundle);
  }

  void a(Purchase paramPurchase)
  {
    paramPurchase.setRetrying(true);
    b(paramPurchase).a(paramPurchase);
    if (!paramPurchase.isPending())
      e().b(paramPurchase);
  }

  public void a(final Runnable paramRunnable)
  {
    l();
    c().queryInventoryAsync(true, null, new InAppBillingHelper.QueryInventoryFinishedListener()
    {
      public void onQueryInventoryFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        ArrayList localArrayList;
        if (paramAnonymousIabResult.isSuccess())
        {
          localArrayList = new ArrayList();
          Iterator localIterator = paramAnonymousIabInventory.getAllOwnedProductIds().iterator();
          while (localIterator.hasNext())
          {
            IabProductId localIabProductId = (IabProductId)localIterator.next();
            Purchase localPurchase = paramAnonymousIabInventory.getPurchase(localIabProductId);
            if ((localPurchase != null) && ("inapp".equals(localIabProductId.getItemType())))
              localArrayList.add(localPurchase);
          }
          if (localArrayList.size() != 0)
            break label115;
          l.b(l.this);
          if (paramRunnable != null)
            paramRunnable.run();
        }
        return;
        label115: l.this.c().consumeAsync(localArrayList, new InAppBillingHelper.OnConsumeMultiFinishedListener()
        {
          public void onConsumeMultiFinished(List<Purchase> paramAnonymous2List, List<IabResult> paramAnonymous2List1)
          {
            Iterator localIterator = paramAnonymous2List1.iterator();
            while (localIterator.hasNext())
              ((IabResult)localIterator.next());
            l.b(l.this);
            if (l.9.this.a != null)
              l.9.this.a.run();
          }
        });
      }
    });
  }

  public void a(IabResult paramIabResult, String paramString)
  {
    switch (paramIabResult.getResponse())
    {
    default:
      af.a(paramIabResult.toString()).d(true).a(PurchaseSupportActivity.class);
      return;
    case 3:
    }
    af.b().d(true).a(PurchaseSupportActivity.class);
  }

  InAppBillingHelper.OnIabPurchaseFinishedListener b(final IabProductId paramIabProductId, final String paramString1, final String paramString2, final Bundle paramBundle)
  {
    return new InAppBillingHelper.OnIabPurchaseFinishedListener()
    {
      public void onIabPurchaseFinished(IabResult paramAnonymousIabResult, Purchase paramAnonymousPurchase)
      {
        l.b(l.this);
        l locall = l.this;
        if (paramAnonymousPurchase != null);
        u localu;
        for (IabProductId localIabProductId = paramAnonymousPurchase.getProductId(); ; localIabProductId = paramIabProductId)
        {
          localu = l.a(locall, localIabProductId);
          switch (paramAnonymousIabResult.getResponse())
          {
          default:
            ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPurchaseStatusStatistics(paramIabProductId.getMerchantProductId(), paramAnonymousIabResult.getResponse(), "", "");
            l.a(l.this, paramAnonymousIabResult.getResponse(), paramIabProductId, paramString1);
            if (paramAnonymousPurchase == null)
              break label208;
            localu.a(paramAnonymousIabResult, paramAnonymousPurchase);
            return;
          case 0:
          case -1005:
          case 1:
          }
        }
        l.a(l.this, paramAnonymousPurchase, paramString1, paramBundle);
        paramAnonymousPurchase.setPending(true);
        localu.a(paramAnonymousPurchase, paramString1, paramString2, paramBundle);
        return;
        l.a(l.this, paramAnonymousIabResult.getResponse(), paramIabProductId, paramString1);
        localu.b(paramIabProductId);
        return;
        label208: localu.a(paramAnonymousIabResult, paramIabProductId);
      }
    };
  }

  public void b()
  {
    e();
    if (!d.z.a.d())
      ViberApplication.getInstance().getContactManager().e().a(new n.a()
      {
        public void onSyncStateChanged(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (ViberApplication.isActivated());
          switch (paramAnonymousInt)
          {
          default:
            return;
          case 3:
          case 4:
          }
          l.b(null, false);
        }
      });
  }

  public InAppBillingHelper c()
  {
    try
    {
      n();
      if ((this.d == null) && (a.a() == a.a))
      {
        InAppBillingHelper localInAppBillingHelper2 = k();
        this.d = localInAppBillingHelper2;
        localInAppBillingHelper2.setActivityListener(new InAppBillingHelper.ActivityListener()
        {
          public void onIabActivity()
          {
            l.a(l.this);
          }
        });
      }
      InAppBillingHelper localInAppBillingHelper1 = this.d;
      return localInAppBillingHelper1;
    }
    finally
    {
    }
  }

  public w e()
  {
    return this.i;
  }

  public void f()
  {
    af.a().d(true).a(PurchaseSupportActivity.class);
  }

  public void g()
  {
    af.b(this.c.getString(R.string.dialog_620_message)).d(true).a(PurchaseSupportActivity.class);
  }

  Purchase[] h()
  {
    return this.e.a();
  }

  public boolean i()
  {
    Iterator localIterator = this.c.getPackageManager().getInstalledApplications(128).iterator();
    while (localIterator.hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
      Adler32 localAdler32 = new Adler32();
      localAdler32.update(localApplicationInfo.packageName.getBytes());
      long l1 = localAdler32.getValue();
      if ((l1 == 1419053039L) || (l1 == 1069942500L) || (l1 == 3379956861L) || (l1 == 207491948L))
        return false;
    }
    return true;
  }

  public static abstract interface a
  {
    public abstract void a(l.e parame);
  }

  public static abstract interface b
  {
    public abstract void a(l.e parame);
  }

  static class c<D>
  {
    boolean a;
    D b;

    public c(boolean paramBoolean, D paramD)
    {
      this.a = paramBoolean;
      this.b = paramD;
    }

    public D a()
    {
      return this.b;
    }
  }

  static enum d
  {
    static
    {
      d[] arrayOfd = new d[2];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
    }
  }

  public static class e
  {
    public final boolean a;
    public final int b;

    public e(boolean paramBoolean, int paramInt)
    {
      this.a = paramBoolean;
      this.b = paramInt;
    }

    public String toString()
    {
      return "SynchronizeProductsResult{success=" + this.a + ", productCount=" + this.b + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.l
 * JD-Core Version:    0.6.2
 */