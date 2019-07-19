package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

class c extends b
{
  private int a = 0;
  private final Handler b = new Handler(Looper.getMainLooper());
  private final a c;
  private final Context d;
  private final int e;
  private final int f;
  private IInAppBillingService g;
  private ServiceConnection h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private ExecutorService m;
  private final ResultReceiver n = new BillingClientImpl.1(this, this.b);

  c(Context paramContext, int paramInt1, int paramInt2, i parami)
  {
    this.d = paramContext.getApplicationContext();
    this.e = paramInt1;
    this.f = paramInt2;
    this.c = new a(this.d, parami);
  }

  private int a(int paramInt)
  {
    this.c.b().onPurchasesUpdated(paramInt, null);
    return paramInt;
  }

  private Bundle a(e parame)
  {
    Bundle localBundle = new Bundle();
    if (parame.g() != 0)
      localBundle.putInt("prorationMode", parame.g());
    if (parame.e() != null)
      localBundle.putString("accountId", parame.e());
    if (parame.f())
      localBundle.putBoolean("vr", true);
    if (parame.d() != null)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = parame.d();
      localBundle.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList(arrayOfString)));
    }
    return localBundle;
  }

  private h.a a(String paramString, boolean paramBoolean)
  {
    com.android.billingclient.a.a.a("BillingClient", "Querying owned items, item type: " + paramString + "; history: " + paramBoolean);
    String str1 = null;
    ArrayList localArrayList1 = new ArrayList();
    do
    {
      if (paramBoolean);
      Object localObject;
      try
      {
        if (!this.k)
        {
          com.android.billingclient.a.a.b("BillingClient", "getPurchaseHistory is not supported on current device");
          return new h.a(-2, null);
        }
        Bundle localBundle2 = this.g.getPurchaseHistory(6, this.d.getPackageName(), paramString, str1, null);
        Bundle localBundle1;
        for (localObject = localBundle2; localObject == null; localObject = localBundle1)
        {
          com.android.billingclient.a.a.b("BillingClient", "queryPurchases got null owned items list");
          return new h.a(6, null);
          localBundle1 = this.g.getPurchases(3, this.d.getPackageName(), paramString, str1);
        }
      }
      catch (Exception localException)
      {
        com.android.billingclient.a.a.b("BillingClient", "Got exception trying to get purchases: " + localException + "; try to reconnect");
        return new h.a(-1, null);
      }
      int i1 = com.android.billingclient.a.a.a((Bundle)localObject, "BillingClient");
      if (i1 != 0)
      {
        com.android.billingclient.a.a.b("BillingClient", "getPurchases() failed. Response code: " + i1);
        return new h.a(i1, null);
      }
      if ((!((Bundle)localObject).containsKey("INAPP_PURCHASE_ITEM_LIST")) || (!((Bundle)localObject).containsKey("INAPP_PURCHASE_DATA_LIST")) || (!((Bundle)localObject).containsKey("INAPP_DATA_SIGNATURE_LIST")))
      {
        com.android.billingclient.a.a.b("BillingClient", "Bundle returned from getPurchases() doesn't contain required fields.");
        return new h.a(6, null);
      }
      ArrayList localArrayList2 = ((Bundle)localObject).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      ArrayList localArrayList3 = ((Bundle)localObject).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      ArrayList localArrayList4 = ((Bundle)localObject).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
      if (localArrayList2 == null)
      {
        com.android.billingclient.a.a.b("BillingClient", "Bundle returned from getPurchases() contains null SKUs list.");
        return new h.a(6, null);
      }
      if (localArrayList3 == null)
      {
        com.android.billingclient.a.a.b("BillingClient", "Bundle returned from getPurchases() contains null purchases list.");
        return new h.a(6, null);
      }
      if (localArrayList4 == null)
      {
        com.android.billingclient.a.a.b("BillingClient", "Bundle returned from getPurchases() contains null signatures list.");
        return new h.a(6, null);
      }
      int i2 = 0;
      while (i2 < localArrayList3.size())
      {
        String str2 = (String)localArrayList3.get(i2);
        String str3 = (String)localArrayList4.get(i2);
        String str4 = (String)localArrayList2.get(i2);
        com.android.billingclient.a.a.a("BillingClient", "Sku is owned: " + str4);
        try
        {
          h localh = new h(str2, str3);
          if (TextUtils.isEmpty(localh.b()))
            com.android.billingclient.a.a.b("BillingClient", "BUG: empty/null token!");
          localArrayList1.add(localh);
          i2++;
        }
        catch (JSONException localJSONException)
        {
          com.android.billingclient.a.a.b("BillingClient", "Got an exception trying to decode the purchase: " + localJSONException);
          return new h.a(6, null);
        }
      }
      str1 = ((Bundle)localObject).getString("INAPP_CONTINUATION_TOKEN");
      com.android.billingclient.a.a.a("BillingClient", "Continuation token: " + str1);
    }
    while (!TextUtils.isEmpty(str1));
    return new h.a(0, localArrayList1);
  }

  private <T> Future<T> a(Callable<T> paramCallable, long paramLong, final Runnable paramRunnable)
  {
    long l1 = ()(0.95D * paramLong);
    if (this.m == null)
      this.m = Executors.newFixedThreadPool(com.android.billingclient.a.a.a);
    try
    {
      final Future localFuture = this.m.submit(paramCallable);
      this.b.postDelayed(new Runnable()
      {
        public void run()
        {
          if ((!localFuture.isDone()) && (!localFuture.isCancelled()))
          {
            localFuture.cancel(true);
            com.android.billingclient.a.a.b("BillingClient", "Async task is taking too long, cancel it!");
            if (paramRunnable != null)
              paramRunnable.run();
          }
        }
      }
      , l1);
      return localFuture;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private void a(Runnable paramRunnable)
  {
    if (Thread.interrupted())
      return;
    this.b.post(paramRunnable);
  }

  private void b(final String paramString, final f paramf)
  {
    try
    {
      com.android.billingclient.a.a.a("BillingClient", "Consuming purchase with token: " + paramString);
      final int i1 = this.g.consumePurchase(3, this.d.getPackageName(), paramString);
      if (i1 == 0)
      {
        a(new Runnable()
        {
          public void run()
          {
            com.android.billingclient.a.a.a("BillingClient", "Successfully consumed purchase.");
            paramf.onConsumeResponse(i1, paramString);
          }
        });
        return;
      }
      a(new Runnable()
      {
        public void run()
        {
          com.android.billingclient.a.a.b("BillingClient", "Error consuming purchase with token. Response code: " + i1);
          paramf.onConsumeResponse(i1, paramString);
        }
      });
      return;
    }
    catch (Exception localException)
    {
      a(new Runnable()
      {
        public void run()
        {
          com.android.billingclient.a.a.b("BillingClient", "Error consuming purchase; ex: " + localException);
          paramf.onConsumeResponse(-1, paramString);
        }
      });
    }
  }

  private int c(final String paramString)
  {
    Future localFuture = a(new Callable()
    {
      public Integer a()
        throws Exception
      {
        return Integer.valueOf(c.c(c.this).isBillingSupportedExtraParams(7, c.b(c.this).getPackageName(), paramString, c.d(c.this)));
      }
    }
    , 5000L, null);
    try
    {
      int i1 = ((Integer)localFuture.get(5000L, TimeUnit.MILLISECONDS)).intValue();
      if (i1 == 0)
        return 0;
      return -2;
    }
    catch (Exception localException)
    {
      com.android.billingclient.a.a.b("BillingClient", "Exception while checking if billing is supported; try to reconnect");
    }
    return -1;
  }

  private Bundle c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("vr", true);
    return localBundle;
  }

  public int a(Activity paramActivity, final e parame)
  {
    if (!a())
      return a(-1);
    final String str1 = parame.b();
    final String str2 = parame.a();
    j localj = parame.c();
    if ((localj != null) && (localj.h()));
    for (int i1 = 1; str2 == null; i1 = 0)
    {
      com.android.billingclient.a.a.b("BillingClient", "Please fix the input params. SKU can't be null.");
      return a(5);
    }
    if (str1 == null)
    {
      com.android.billingclient.a.a.b("BillingClient", "Please fix the input params. SkuType can't be null.");
      return a(5);
    }
    if ((str1.equals("subs")) && (!this.i))
    {
      com.android.billingclient.a.a.b("BillingClient", "Current client doesn't support subscriptions.");
      return a(-2);
    }
    if (parame.d() != null);
    for (int i2 = 1; (i2 != 0) && (!this.j); i2 = 0)
    {
      com.android.billingclient.a.a.b("BillingClient", "Current client doesn't support subscriptions update.");
      return a(-2);
    }
    if ((parame.h()) && (!this.k))
    {
      com.android.billingclient.a.a.b("BillingClient", "Current client doesn't support extra params for buy intent.");
      return a(-2);
    }
    if ((i1 != 0) && (!this.k))
    {
      com.android.billingclient.a.a.b("BillingClient", "Current client doesn't support extra params for buy intent.");
      return a(-2);
    }
    com.android.billingclient.a.a.a("BillingClient", "Constructing buy intent for " + str2 + ", item type: " + str1);
    final Bundle localBundle2;
    final int i5;
    if (this.k)
    {
      localBundle2 = a(parame);
      localBundle2.putString("libraryVersion", "1.2.2");
      if (i1 != 0)
      {
        localBundle2.putString("rewardToken", localj.i());
        if (this.e != 0)
          localBundle2.putInt("childDirected", this.e);
        if (this.f != 0)
          localBundle2.putInt("underAgeOfConsent", this.f);
      }
      if (parame.f())
        i5 = 7;
    }
    while (true)
    {
      Future localFuture = a(new Callable()
      {
        public Bundle a()
          throws Exception
        {
          return c.c(c.this).getBuyIntentExtraParams(i5, c.b(c.this).getPackageName(), str2, str1, null, localBundle2);
        }
      }
      , 5000L, null);
      try
      {
        Bundle localBundle1;
        while (true)
        {
          localBundle1 = (Bundle)localFuture.get(5000L, TimeUnit.MILLISECONDS);
          int i3 = com.android.billingclient.a.a.a(localBundle1, "BillingClient");
          if (i3 == 0)
            break label502;
          com.android.billingclient.a.a.b("BillingClient", "Unable to buy item, Error response code: " + i3);
          int i4 = a(i3);
          return i4;
          i5 = 6;
          break;
          if (i2 != 0)
            localFuture = a(new Callable()
            {
              public Bundle a()
                throws Exception
              {
                IInAppBillingService localIInAppBillingService = c.c(c.this);
                String str = c.b(c.this).getPackageName();
                String[] arrayOfString = new String[1];
                arrayOfString[0] = parame.d();
                return localIInAppBillingService.getBuyIntentToReplaceSkus(5, str, Arrays.asList(arrayOfString), str2, "subs", null);
              }
            }
            , 5000L, null);
          else
            localFuture = a(new Callable()
            {
              public Bundle a()
                throws Exception
              {
                return c.c(c.this).getBuyIntent(3, c.b(c.this).getPackageName(), str2, str1, null);
              }
            }
            , 5000L, null);
        }
        label502: Intent localIntent = new Intent(paramActivity, ProxyBillingActivity.class);
        localIntent.putExtra("result_receiver", this.n);
        localIntent.putExtra("BUY_INTENT", (PendingIntent)localBundle1.getParcelable("BUY_INTENT"));
        paramActivity.startActivity(localIntent);
        return 0;
      }
      catch (CancellationException localCancellationException)
      {
        com.android.billingclient.a.a.b("BillingClient", "Time out while launching billing flow: ; for sku: " + str2 + "; try to reconnect");
        return a(-3);
      }
      catch (Exception localException)
      {
        com.android.billingclient.a.a.b("BillingClient", "Exception while launching billing flow: ; for sku: " + str2 + "; try to reconnect");
        return a(-1);
      }
      catch (TimeoutException localTimeoutException)
      {
        label558: break label558;
      }
    }
  }

  public int a(String paramString)
  {
    int i1 = -1;
    int i2;
    if (!a())
      i2 = i1;
    boolean bool1;
    do
    {
      boolean bool2;
      do
      {
        boolean bool3;
        do
        {
          return i2;
          switch (paramString.hashCode())
          {
          default:
          case 1987365622:
          case -422092961:
          case 292218239:
          case 1219490065:
          case 207616302:
          }
          while (true)
            switch (i1)
            {
            default:
              com.android.billingclient.a.a.b("BillingClient", "Unsupported feature: " + paramString);
              return 5;
              if (paramString.equals("subscriptions"))
              {
                i1 = 0;
                continue;
                if (paramString.equals("subscriptionsUpdate"))
                {
                  i1 = 1;
                  continue;
                  if (paramString.equals("inAppItemsOnVr"))
                  {
                    i1 = 2;
                    continue;
                    if (paramString.equals("subscriptionsOnVr"))
                    {
                      i1 = 3;
                      continue;
                      if (paramString.equals("priceChangeConfirmation"))
                        i1 = 4;
                    }
                  }
                }
              }
              break;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            }
          bool3 = this.i;
          i2 = 0;
        }
        while (bool3);
        return -2;
        bool2 = this.j;
        i2 = 0;
      }
      while (bool2);
      return -2;
      return c("inapp");
      return c("subs");
      bool1 = this.l;
      i2 = 0;
    }
    while (bool1);
    return -2;
  }

  j.a a(String paramString, List<String> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i1 = paramList.size();
    for (int i2 = 0; i2 < i1; i2 += 20)
    {
      int i3 = i2 + 20;
      if (i3 > i1)
        i3 = i1;
      ArrayList localArrayList2 = new ArrayList(paramList.subList(i2, i3));
      Bundle localBundle1 = new Bundle();
      localBundle1.putStringArrayList("ITEM_ID_LIST", localArrayList2);
      localBundle1.putString("libraryVersion", "1.2.2");
      Bundle localBundle2;
      try
      {
        localBundle2 = this.g.getSkuDetails(3, this.d.getPackageName(), paramString, localBundle1);
        if (localBundle2 == null)
        {
          com.android.billingclient.a.a.b("BillingClient", "querySkuDetailsAsync got null sku details list");
          return new j.a(4, null);
        }
      }
      catch (Exception localException)
      {
        com.android.billingclient.a.a.b("BillingClient", "Got exception trying to query skuDetails: " + localException + "; try to reconnect");
        return new j.a(-1, null);
      }
      if (!localBundle2.containsKey("DETAILS_LIST"))
      {
        int i5 = com.android.billingclient.a.a.a(localBundle2, "BillingClient");
        if (i5 != 0)
        {
          com.android.billingclient.a.a.b("BillingClient", "getSkuDetails() failed. Response code: " + i5);
          return new j.a(i5, localArrayList1);
        }
        com.android.billingclient.a.a.b("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
        return new j.a(6, localArrayList1);
      }
      ArrayList localArrayList3 = localBundle2.getStringArrayList("DETAILS_LIST");
      if (localArrayList3 == null)
      {
        com.android.billingclient.a.a.b("BillingClient", "querySkuDetailsAsync got null response list");
        return new j.a(4, null);
      }
      int i4 = 0;
      while (i4 < localArrayList3.size())
      {
        String str = (String)localArrayList3.get(i4);
        try
        {
          j localj = new j(str);
          com.android.billingclient.a.a.a("BillingClient", "Got sku details: " + localj);
          localArrayList1.add(localj);
          i4++;
        }
        catch (JSONException localJSONException)
        {
          com.android.billingclient.a.a.b("BillingClient", "Got a JSON exception trying to decode SkuDetails");
          return new j.a(6, null);
        }
      }
    }
    return new j.a(0, localArrayList1);
  }

  public void a(d paramd)
  {
    if (a())
    {
      com.android.billingclient.a.a.a("BillingClient", "Service connection is valid. No need to re-initialize.");
      paramd.onBillingSetupFinished(0);
      return;
    }
    if (this.a == 1)
    {
      com.android.billingclient.a.a.b("BillingClient", "Client is already in the process of connecting to billing service.");
      paramd.onBillingSetupFinished(5);
      return;
    }
    if (this.a == 3)
    {
      com.android.billingclient.a.a.b("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
      paramd.onBillingSetupFinished(5);
      return;
    }
    this.a = 1;
    this.c.a();
    com.android.billingclient.a.a.a("BillingClient", "Starting in-app billing setup.");
    this.h = new a(paramd, null);
    Intent localIntent1 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent1.setPackage("com.android.vending");
    List localList = this.d.getPackageManager().queryIntentServices(localIntent1, 0);
    if ((localList != null) && (!localList.isEmpty()))
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localList.get(0);
      if (localResolveInfo.serviceInfo != null)
      {
        String str1 = localResolveInfo.serviceInfo.packageName;
        String str2 = localResolveInfo.serviceInfo.name;
        if ((!"com.android.vending".equals(str1)) || (str2 == null))
          break label308;
        ComponentName localComponentName = new ComponentName(str1, str2);
        Intent localIntent2 = new Intent(localIntent1);
        localIntent2.setComponent(localComponentName);
        localIntent2.putExtra("libraryVersion", "1.2.2");
        if (this.d.bindService(localIntent2, this.h, 1))
        {
          com.android.billingclient.a.a.a("BillingClient", "Service was bonded successfully.");
          return;
        }
        com.android.billingclient.a.a.b("BillingClient", "Connection to Billing service is blocked.");
      }
    }
    while (true)
    {
      this.a = 0;
      com.android.billingclient.a.a.a("BillingClient", "Billing service unavailable on device.");
      paramd.onBillingSetupFinished(3);
      return;
      label308: com.android.billingclient.a.a.b("BillingClient", "The device doesn't have valid Play Store.");
    }
  }

  public void a(k paramk, final l paraml)
  {
    if (!a())
    {
      paraml.onSkuDetailsResponse(-1, null);
      return;
    }
    final String str = paramk.a();
    final List localList = paramk.b();
    if (TextUtils.isEmpty(str))
    {
      com.android.billingclient.a.a.b("BillingClient", "Please fix the input params. SKU type can't be empty.");
      paraml.onSkuDetailsResponse(5, null);
      return;
    }
    if (localList == null)
    {
      com.android.billingclient.a.a.b("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
      paraml.onSkuDetailsResponse(5, null);
      return;
    }
    a(new Callable()
    {
      public Void a()
      {
        final j.a locala = c.this.a(str, localList);
        c.a(c.this, new Runnable()
        {
          public void run()
          {
            c.12.this.c.onSkuDetailsResponse(locala.b(), locala.a());
          }
        });
        return null;
      }
    }
    , 30000L, new Runnable()
    {
      public void run()
      {
        paraml.onSkuDetailsResponse(-3, null);
      }
    });
  }

  public void a(final String paramString, final f paramf)
  {
    if (!a())
    {
      paramf.onConsumeResponse(-1, null);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      com.android.billingclient.a.a.b("BillingClient", "Please provide a valid purchase token got from queryPurchases result.");
      paramf.onConsumeResponse(5, paramString);
      return;
    }
    a(new Callable()
    {
      public Void a()
      {
        c.a(c.this, paramString, paramf);
        return null;
      }
    }
    , 30000L, new Runnable()
    {
      public void run()
      {
        paramf.onConsumeResponse(-3, paramString);
      }
    });
  }

  public boolean a()
  {
    return (this.a == 2) && (this.g != null) && (this.h != null);
  }

  public h.a b(final String paramString)
  {
    if (!a())
      return new h.a(-1, null);
    if (TextUtils.isEmpty(paramString))
    {
      com.android.billingclient.a.a.b("BillingClient", "Please provide a valid SKU type.");
      return new h.a(5, null);
    }
    Future localFuture = a(new Callable()
    {
      public h.a a()
        throws Exception
      {
        return c.a(c.this, paramString, false);
      }
    }
    , 5000L, null);
    try
    {
      h.a locala = (h.a)localFuture.get(5000L, TimeUnit.MILLISECONDS);
      return locala;
    }
    catch (CancellationException localCancellationException)
    {
      return new h.a(-3, null);
    }
    catch (Exception localException)
    {
      return new h.a(6, null);
    }
    catch (TimeoutException localTimeoutException)
    {
      label82: break label82;
    }
  }

  public void b()
  {
    try
    {
      this.c.c();
      if ((this.h != null) && (this.g != null))
      {
        com.android.billingclient.a.a.a("BillingClient", "Unbinding from service.");
        this.d.unbindService(this.h);
        this.h = null;
      }
      this.g = null;
      if (this.m != null)
      {
        this.m.shutdownNow();
        this.m = null;
      }
      return;
    }
    catch (Exception localException)
    {
      com.android.billingclient.a.a.b("BillingClient", "There was an exception while ending connection: " + localException);
      return;
    }
    finally
    {
      this.a = 3;
    }
  }

  private final class a
    implements ServiceConnection
  {
    private final d b;

    private a(d arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    private void a(final int paramInt)
    {
      c.a(c.this, new Runnable()
      {
        public void run()
        {
          c.a.a(c.a.this).onBillingSetupFinished(paramInt);
        }
      });
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      com.android.billingclient.a.a.a("BillingClient", "Billing service connected.");
      c.a(c.this, IInAppBillingService.Stub.asInterface(paramIBinder));
      c.a(c.this, new Callable()
      {
        public Void a()
        {
          boolean bool1 = true;
          try
          {
            String str = c.b(c.this).getPackageName();
            int j = 8;
            i = 3;
            while (true)
              if (j >= 3)
                try
                {
                  i = c.c(c.this).isBillingSupported(j, str, "subs");
                  boolean bool2;
                  label77: boolean bool3;
                  label103: label127: boolean bool4;
                  if (i == 0)
                  {
                    k = j;
                    c localc1 = c.this;
                    if (k < 5)
                      break label258;
                    bool2 = bool1;
                    c.a(localc1, bool2);
                    c localc2 = c.this;
                    if (k < 3)
                      break label264;
                    bool3 = bool1;
                    c.b(localc2, bool3);
                    if (k >= 3)
                      break label368;
                    com.android.billingclient.a.a.a("BillingClient", "In-app billing API does not support subscription on this device.");
                    break label368;
                    if (m < 3)
                      break label356;
                    i = c.c(c.this).isBillingSupported(m, str, "inapp");
                    if (i != 0)
                      break label270;
                    n = m;
                    c localc3 = c.this;
                    if (n < 8)
                      break label276;
                    bool4 = bool1;
                    label182: c.c(localc3, bool4);
                    c localc4 = c.this;
                    if (n < 6)
                      break label282;
                    label206: c.d(localc4, bool1);
                    if (n < 3)
                      com.android.billingclient.a.a.b("BillingClient", "In-app billing API version 3 is not supported on this device.");
                    if (i != 0)
                      break label287;
                    c.a(c.this, 2);
                  }
                  while (true)
                  {
                    c.a.a(c.a.this, i);
                    return null;
                    j--;
                    break;
                    label258: bool2 = false;
                    break label77;
                    label264: bool3 = false;
                    break label103;
                    label270: m--;
                    break label127;
                    label276: bool4 = false;
                    break label182;
                    label282: bool1 = false;
                    break label206;
                    label287: c.a(c.this, 0);
                    c.a(c.this, null);
                  }
                }
                catch (Exception localException2)
                {
                  while (true)
                  {
                    com.android.billingclient.a.a.b("BillingClient", "Exception while checking if billing is supported; try to reconnect");
                    c.a(c.this, 0);
                    c.a(c.this, null);
                  }
                }
          }
          catch (Exception localException1)
          {
            while (true)
            {
              int i = 3;
              continue;
              label356: int n = 0;
              continue;
              int k = 0;
              continue;
              label368: int m = 8;
            }
          }
        }
      }
      , 30000L, new Runnable()
      {
        public void run()
        {
          c.a(c.this, 0);
          c.a(c.this, null);
          c.a.a(c.a.this, -3);
        }
      });
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      com.android.billingclient.a.a.b("BillingClient", "Billing service disconnected.");
      c.a(c.this, null);
      c.a(c.this, 0);
      this.b.onBillingServiceDisconnected();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.c
 * JD-Core Version:    0.6.2
 */