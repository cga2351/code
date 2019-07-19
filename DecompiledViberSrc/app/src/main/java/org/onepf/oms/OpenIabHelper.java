package org.onepf.oms;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import org.onepf.oms.appstore.AmazonAppstore;
import org.onepf.oms.appstore.GooglePlay;
import org.onepf.oms.appstore.GooglePlayClient;
import org.onepf.oms.appstore.NokiaStore;
import org.onepf.oms.appstore.OpenAppstore;
import org.onepf.oms.appstore.SamsungApps;
import org.onepf.oms.appstore.SkubitAppstore;
import org.onepf.oms.appstore.SkubitTestAppstore;
import org.onepf.oms.appstore.googleUtils.IabException;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnConsumeFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnConsumeMultiFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.QueryInventoryFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.appstore.googleUtils.Purchase;
import org.onepf.oms.appstore.googleUtils.Security;
import org.onepf.oms.util.Utils;

public class OpenIabHelper
{
  public static final String AMAZON_PROVIDER = "amazon";
  public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
  public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
  public static final int BILLING_RESPONSE_RESULT_OK = 0;
  private static final String BIND_INTENT = "org.onepf.oms.openappstore.BIND";
  public static final String CREDIT_CARD_PROVIDER = "credit_card";
  public static final String GOOGLE_PROVIDER = "google_play";
  public static final String ITEM_TYPE_INAPP = "inapp";
  public static final String ITEM_TYPE_SUBS = "subs";
  private static final Logger L = ViberEnv.getLogger();
  public static final String NAME_AMAZON = "com.amazon.apps";
  public static final String NAME_APPLAND = "Appland";
  public static final String NAME_APTOIDE = "cm.aptoide.pt";
  public static final String NAME_CREDIT_CARD = "credit.card";
  public static final String NAME_GOOGLE = "com.google.play";
  public static final String NAME_GOOGLE_CLIENT = "com.google.play.client";
  public static final String NAME_NOKIA = "com.nokia.nstore";
  public static final String NAME_SAMSUNG = "com.samsung.apps";
  public static final String NAME_SKUBIT = "com.skubit.android";
  public static final String NAME_SKUBIT_TEST = "net.skubit.android";
  public static final String NAME_SLIDEME = "SlideME";
  public static final String NAME_YANDEX = "com.yandex.store";
  public static final int SETUP_DISPOSED = 2;
  public static final int SETUP_IN_PROGRESS = 3;
  public static final int SETUP_RESULT_FAILED = 1;
  public static final int SETUP_RESULT_NOT_STARTED = -1;
  public static final int SETUP_RESULT_SUCCESSFUL;
  private Activity activity;
  private final Map<String, Appstore> appReadyStores = new HashMap();
  private final Map<String, AppstoreFactory> appstoreFactoryMap = new HashMap();
  private volatile Appstore appstoreInSetup;
  private final Map<String, String> appstorePackageMap = new HashMap();
  private final Context context;
  private final Handler handler = new Handler(Looper.getMainLooper());
  private Appstore mAppstore;
  private AppstoreInAppBillingService mAppstoreBillingService;
  private volatile boolean mAsyncInProgress = false;
  private volatile String mAsyncOperation = "";
  private final Options options;
  private final PackageManager packageManager;
  private ExecutorService setupExecutorService;
  private volatile int setupState = -1;
  private final Map<String, String> viberToOIABProviderMap = new HashMap();

  public OpenIabHelper(Context paramContext, Map<String, String> paramMap)
  {
    this(paramContext, new OpenIabHelper.Options.Builder().addStoreKeys(paramMap).build());
  }

  public OpenIabHelper(Context paramContext, Map<String, String> paramMap, String[] paramArrayOfString)
  {
    this(paramContext, new OpenIabHelper.Options.Builder().addStoreKeys(paramMap).addPreferredStoreName(paramArrayOfString).build());
  }

  public OpenIabHelper(Context paramContext, Map<String, String> paramMap, String[] paramArrayOfString, Appstore[] paramArrayOfAppstore)
  {
    this(paramContext, new OpenIabHelper.Options.Builder().addStoreKeys(paramMap).addPreferredStoreName(paramArrayOfString).addAvailableStores(paramArrayOfAppstore).build());
  }

  public OpenIabHelper(Context paramContext, Options paramOptions)
  {
    this.viberToOIABProviderMap.put("google_play", "com.google.play.client");
    this.appstorePackageMap.put("com.yandex.store", "com.yandex.store");
    this.appstorePackageMap.put("cm.aptoide.pt", "cm.aptoide.pt");
    this.appstoreFactoryMap.put("credit.card", new AppstoreFactory()
    {
      public Appstore get()
      {
        return new CreditCardStore(OpenIabHelper.this.context);
      }
    });
    this.appstorePackageMap.put("com.android.vending", "com.google.play.client");
    this.appstoreFactoryMap.put("com.google.play", new AppstoreFactory()
    {
      public Appstore get()
      {
        if (OpenIabHelper.this.options.getVerifyMode() != 1);
        for (String str = (String)OpenIabHelper.this.options.getStoreKeys().get("com.google.play"); ; str = null)
          return new GooglePlay(OpenIabHelper.this.context, str);
      }
    });
    this.appstoreFactoryMap.put("com.google.play.client", new AppstoreFactory()
    {
      public Appstore get()
      {
        if (OpenIabHelper.this.options.getVerifyMode() != 1);
        for (String str = (String)OpenIabHelper.this.options.getStoreKeys().get("com.google.play.client"); ; str = null)
          return new GooglePlayClient(OpenIabHelper.this.context, str);
      }
    });
    this.appstorePackageMap.put("com.amazon.venezia", "com.amazon.apps");
    this.appstoreFactoryMap.put("com.amazon.apps", new AppstoreFactory()
    {
      public Appstore get()
      {
        return new AmazonAppstore(OpenIabHelper.this.context);
      }
    });
    this.appstorePackageMap.put("com.sec.android.app.samsungapps", "com.samsung.apps");
    this.appstoreFactoryMap.put("com.samsung.apps", new AppstoreFactory()
    {
      public Appstore get()
      {
        return new SamsungApps(OpenIabHelper.this.activity, OpenIabHelper.this.options);
      }
    });
    this.appstorePackageMap.put("com.nokia.payment.iapenabler", "com.nokia.nstore");
    this.appstoreFactoryMap.put("com.nokia.nstore", new AppstoreFactory()
    {
      public Appstore get()
      {
        return new NokiaStore(OpenIabHelper.this.context);
      }
    });
    this.appstorePackageMap.put("com.skubit.android", "com.skubit.android");
    this.appstoreFactoryMap.put("com.skubit.android", new AppstoreFactory()
    {
      public Appstore get()
      {
        return new SkubitAppstore(OpenIabHelper.this.context);
      }
    });
    this.appstorePackageMap.put("net.skubit.android", "net.skubit.android");
    this.appstoreFactoryMap.put("net.skubit.android", new AppstoreFactory()
    {
      public Appstore get()
      {
        return new SkubitTestAppstore(OpenIabHelper.this.context);
      }
    });
    this.context = paramContext.getApplicationContext();
    this.packageManager = paramContext.getPackageManager();
    this.options = paramOptions;
    if ((paramContext instanceof Activity))
      this.activity = ((Activity)paramContext);
    checkOptions();
  }

  private void checkAmazon()
  {
    try
    {
      OpenIabHelper.class.getClassLoader().loadClass("com.amazon.device.iap.PurchasingService");
      i = 1;
      if (i != 0)
        return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        int i = 0;
      int j;
      if (this.options.getAvailableStoreWithName("com.amazon.apps") == null)
      {
        boolean bool = this.options.getPreferredStoreNames().contains("com.amazon.apps");
        j = 0;
        if (!bool);
      }
      else
      {
        j = 1;
      }
      if (j != 0)
        throw new IllegalStateException("You must satisfy amazon sdk dependency.");
      this.appstoreFactoryMap.remove("com.amazon.apps");
    }
  }

  private void checkBillingAndFinish(final IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener, final Collection<Appstore> paramCollection)
  {
    if (this.setupState != 3)
      throw new IllegalStateException("Can't check billing. Current state: " + setupStateToString(this.setupState));
    final String str = this.context.getPackageName();
    if (paramCollection.isEmpty())
    {
      finishSetup(paramOnIabSetupFinishedListener);
      return;
    }
    if (this.options.isCheckInventory());
    for (Object localObject = new Runnable()
    {
      public void run()
      {
        final ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext())
        {
          Appstore localAppstore2 = (Appstore)localIterator.next();
          OpenIabHelper.access$902(OpenIabHelper.this, localAppstore2);
          if ((localAppstore2.isBillingAvailable(str)) && (OpenIabHelper.this.versionOk(localAppstore2)))
            localArrayList1.add(localAppstore2);
        }
        final Appstore localAppstore1 = OpenIabHelper.this.checkInventory(new HashSet(localArrayList1));
        if (localAppstore1 == null)
          if (!localArrayList1.isEmpty())
            break label171;
        label171: for (localAppstore1 = null; ; localAppstore1 = (Appstore)localArrayList1.get(0))
        {
          final ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localAppstore1);
          final IabHelper.OnIabSetupFinishedListener local1 = new IabHelper.OnIabSetupFinishedListener()
          {
            public void onIabSetupFinished(IabResult paramAnonymous2IabResult)
            {
              ArrayList localArrayList = new ArrayList(localArrayList1);
              if (localAppstore1 != null)
                localArrayList.remove(localAppstore1);
              OpenIabHelper.this.dispose(localArrayList);
              OpenIabHelper.11.this.val$listener.onIabSetupFinished(paramAnonymous2IabResult);
            }
          };
          OpenIabHelper.this.handler.post(new Runnable()
          {
            public void run()
            {
              OpenIabHelper.this.finishSetup(local1, localArrayList2);
            }
          });
          return;
        }
      }
    }
    ; ; localObject = new Runnable()
    {
      public void run()
      {
        final ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator1 = paramCollection.iterator();
        while (localIterator1.hasNext())
        {
          Appstore localAppstore2 = (Appstore)localIterator1.next();
          OpenIabHelper.access$902(OpenIabHelper.this, localAppstore2);
          if ((localAppstore2.isBillingAvailable(str)) && (OpenIabHelper.this.versionOk(localAppstore2)))
            localArrayList1.add(localAppstore2);
        }
        ArrayList localArrayList2 = new ArrayList(paramCollection);
        if ((localArrayList1 != null) && (localArrayList1.size() > 0))
          localArrayList2.removeAll(localArrayList1);
        OpenIabHelper.this.dispose(localArrayList2);
        final CountDownLatch localCountDownLatch;
        if ((localArrayList1 != null) && (localArrayList1.size() > 0))
        {
          localCountDownLatch = new CountDownLatch(localArrayList1.size());
          IabHelper.OnIabSetupFinishedListener local1 = new IabHelper.OnIabSetupFinishedListener()
          {
            public void onIabSetupFinished(IabResult paramAnonymous2IabResult)
            {
              localCountDownLatch.countDown();
            }
          };
          Iterator localIterator2 = localArrayList1.iterator();
          while (localIterator2.hasNext())
          {
            Appstore localAppstore1 = (Appstore)localIterator2.next();
            if (localAppstore1 != null)
              localAppstore1.getInAppBillingService().startSetup(local1);
          }
        }
        try
        {
          localCountDownLatch.await();
          label214: final IabHelper.OnIabSetupFinishedListener local2 = new IabHelper.OnIabSetupFinishedListener()
          {
            public void onIabSetupFinished(IabResult paramAnonymous2IabResult)
            {
              OpenIabHelper.12.this.val$listener.onIabSetupFinished(paramAnonymous2IabResult);
            }
          };
          OpenIabHelper.this.handler.post(new Runnable()
          {
            public void run()
            {
              OpenIabHelper.this.finishSetup(local2, localArrayList1);
            }
          });
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label214;
        }
      }
    })
    {
      this.setupExecutorService.execute((Runnable)localObject);
      return;
    }
  }

  private void checkBillingAndFinish(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener, Appstore paramAppstore)
  {
    if (paramAppstore == null)
    {
      finishSetup(paramOnIabSetupFinishedListener);
      return;
    }
    checkBillingAndFinish(paramOnIabSetupFinishedListener, Arrays.asList(new Appstore[] { paramAppstore }));
  }

  private void checkGoogle()
  {
    int i = 1;
    String str;
    if ((this.options.getAvailableStoreWithName("com.google.play.client") != null) || (this.options.getPreferredStoreNames().contains("com.google.play.client")))
    {
      this.viberToOIABProviderMap.put("google_play", "com.google.play.client");
      this.appstoreFactoryMap.remove("com.google.play");
      this.appstorePackageMap.put("com.android.vending", "com.google.play.client");
      str = "com.google.play.client";
      if (this.options.getVerifyMode() != i)
        break label134;
    }
    label134: 
    while (this.options.getStoreKeys().containsKey(str))
    {
      return;
      this.viberToOIABProviderMap.put("google_play", "com.google.play");
      this.appstoreFactoryMap.remove("com.google.play.client");
      this.appstorePackageMap.put("com.android.vending", "com.google.play");
      str = "com.google.play";
      break;
    }
    if ((this.options.getAvailableStoreWithName(str) != null) || (this.options.getPreferredStoreNames().contains(str)));
    while ((i != 0) && (this.options.getVerifyMode() == 0))
    {
      throw new IllegalStateException("You must supply Google verification key");
      i = 0;
    }
    this.appstoreFactoryMap.remove(str);
  }

  private Appstore checkInventory(Set<Appstore> paramSet)
  {
    if (Utils.uiThread())
      throw new IllegalStateException("Must not be called from UI thread");
    final Semaphore localSemaphore = new Semaphore(0);
    final ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    final Appstore[] arrayOfAppstore = new Appstore[1];
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      final Appstore localAppstore = (Appstore)localIterator.next();
      final AppstoreInAppBillingService localAppstoreInAppBillingService = localAppstore.getInAppBillingService();
      final IabHelper.OnIabSetupFinishedListener local15 = new IabHelper.OnIabSetupFinishedListener()
      {
        public void onIabSetupFinished(IabResult paramAnonymousIabResult)
        {
          if (!paramAnonymousIabResult.isSuccess())
          {
            localSemaphore.release();
            return;
          }
          Runnable local1 = new Runnable()
          {
            public void run()
            {
              try
              {
                Inventory localInventory = OpenIabHelper.15.this.val$billingService.queryInventory(false, null, null);
                if ((localInventory != null) && (!localInventory.getAllPurchases().isEmpty()))
                  OpenIabHelper.15.this.val$inventoryAppstore[0] = OpenIabHelper.15.this.val$appstore;
                label48: OpenIabHelper.15.this.val$inventorySemaphore.release();
                return;
              }
              catch (IabException localIabException)
              {
                break label48;
              }
            }
          };
          localExecutorService.execute(local1);
        }
      };
      this.handler.post(new Runnable()
      {
        public void run()
        {
          localAppstoreInAppBillingService.startSetup(local15);
        }
      });
      try
      {
        localSemaphore.acquire();
        if (arrayOfAppstore[0] != null)
        {
          localExecutorService.shutdownNow();
          return arrayOfAppstore[0];
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        return null;
      }
    }
    localExecutorService.shutdownNow();
    return null;
  }

  private void checkNokia()
  {
    if (Utils.hasRequestedPermission(this.context, "com.nokia.payment.BILLING"))
      return;
    if ((this.options.getAvailableStoreWithName("com.nokia.nstore") != null) || (this.options.getPreferredStoreNames().contains("com.nokia.nstore")))
      throw new IllegalStateException("Nokia permission \"com.nokia.payment.BILLING\" NOT REQUESTED");
    this.appstoreFactoryMap.remove("com.nokia.nstore");
  }

  private void checkSamsung()
  {
    if (this.activity != null)
      return;
    if ((this.options.getAvailableStoreWithName("com.samsung.apps") != null) || (this.options.getPreferredStoreNames().contains("com.samsung.apps")))
      throw new IllegalArgumentException("You must supply Activity object as context in order to use com.samsung.apps store");
    this.appstoreFactoryMap.remove("com.samsung.apps");
  }

  @Deprecated
  public static List<Appstore> discoverOpenStores(Context paramContext, List<Appstore> paramList, Options paramOptions)
  {
    throw new UnsupportedOperationException("This action is no longer supported.");
  }

  private void discoverOpenStores(final OpenStoresDiscoveredListener paramOpenStoresDiscoveredListener, final Queue<Intent> paramQueue, final List<Appstore> paramList)
  {
    while (!paramQueue.isEmpty())
    {
      Intent localIntent = (Intent)paramQueue.poll();
      ServiceConnection local14 = new ServiceConnection()
      {
        public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
        {
          try
          {
            OpenAppstore localOpenAppstore2 = OpenIabHelper.this.getOpenAppstore(paramAnonymousComponentName, paramAnonymousIBinder, this);
            localOpenAppstore1 = localOpenAppstore2;
            if (localOpenAppstore1 != null)
              paramList.add(localOpenAppstore1);
            OpenIabHelper.this.discoverOpenStores(paramOpenStoresDiscoveredListener, paramQueue, paramList);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            while (true)
              OpenAppstore localOpenAppstore1 = null;
          }
        }

        public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
        }
      };
      try
      {
        if (this.context.bindService(localIntent, local14, 1))
          return;
        this.context.unbindService(local14);
      }
      catch (SecurityException localSecurityException)
      {
      }
    }
    paramOpenStoresDiscoveredListener.openStoresDiscovered(Collections.unmodifiableList(paramList));
  }

  private void dispose(Collection<Appstore> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      ((Appstore)localIterator.next()).getInAppBillingService().dispose();
  }

  private void finishSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    finishSetup(paramOnIabSetupFinishedListener, null);
  }

  private void finishSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener, Collection<Appstore> paramCollection)
  {
    if (paramCollection == null);
    for (IabResult localIabResult = new IabResult(3, "No suitable appstore was found"); ; localIabResult = new IabResult(0, "Setup ok"))
    {
      finishSetup(paramOnIabSetupFinishedListener, localIabResult, paramCollection);
      return;
    }
  }

  private void finishSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener, IabResult paramIabResult, Collection<Appstore> paramCollection)
  {
    if (!Utils.uiThread())
      throw new IllegalStateException("Must be called from UI thread.");
    this.activity = null;
    this.appstoreInSetup = null;
    this.setupExecutorService.shutdownNow();
    this.setupExecutorService = null;
    if (this.setupState == 2)
    {
      if (paramCollection != null)
        dispose(paramCollection);
      return;
    }
    if (this.setupState != 3)
      throw new IllegalStateException("Setup is not started or already finished.");
    boolean bool = paramIabResult.isSuccess();
    if (bool);
    for (int i = 0; ; i = 1)
    {
      this.setupState = i;
      if (!bool)
        break label331;
      if (paramCollection != null)
        break;
      throw new IllegalStateException("Appstore can't be null if setup is successful");
    }
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
    {
      Appstore localAppstore2 = (Appstore)localIterator1.next();
      if ((localAppstore2 instanceof GooglePlay))
        this.appReadyStores.put("google_play", localAppstore2);
      else if ((localAppstore2 instanceof GooglePlayClient))
        this.appReadyStores.put("google_play", localAppstore2);
      else if ((localAppstore2 instanceof AmazonAppstore))
        this.appReadyStores.put("amazon", localAppstore2);
      else if ((localAppstore2 instanceof CreditCardStore))
        this.appReadyStores.put("credit_card", localAppstore2);
    }
    if (this.mAppstore == null)
    {
      Iterator localIterator2 = this.appReadyStores.values().iterator();
      while (localIterator2.hasNext())
      {
        Appstore localAppstore1 = (Appstore)localIterator2.next();
        if (localAppstore1 != null)
          this.mAppstore = localAppstore1;
      }
    }
    if (this.mAppstore != null)
      this.mAppstoreBillingService = this.mAppstore.getInAppBillingService();
    label331: paramOnIabSetupFinishedListener.onIabSetupFinished(paramIabResult);
  }

  private void finishSetupWithError(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    finishSetupWithError(paramOnIabSetupFinishedListener, null);
  }

  private void finishSetupWithError(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener, Exception paramException)
  {
    finishSetup(paramOnIabSetupFinishedListener, new IabResult(6, "Error occured, setup failed"), null);
  }

  public static List<String> getAllStoreSkus(String paramString)
  {
    List localList = SkuManager.getInstance().getAllStoreSkus(paramString);
    if (localList == null)
      return Collections.emptyList();
    return new ArrayList(localList);
  }

  private Intent getBindServiceIntent(ServiceInfo paramServiceInfo)
  {
    Intent localIntent = new Intent("org.onepf.oms.openappstore.BIND");
    localIntent.setClassName(paramServiceInfo.packageName, paramServiceInfo.name);
    return localIntent;
  }

  private OpenAppstore getOpenAppstore(ComponentName paramComponentName, IBinder paramIBinder, ServiceConnection paramServiceConnection)
    throws RemoteException
  {
    IOpenAppstore localIOpenAppstore = IOpenAppstore.Stub.asInterface(paramIBinder);
    String str1 = localIOpenAppstore.getAppstoreName();
    Intent localIntent = localIOpenAppstore.getBillingServiceIntent();
    int i = this.options.getVerifyMode();
    String str2;
    if (i == 1)
    {
      str2 = null;
      if (!TextUtils.isEmpty(str1))
        break label74;
    }
    label74: 
    while ((localIntent == null) || ((i == 0) && (TextUtils.isEmpty(str2))))
    {
      return null;
      str2 = (String)this.options.getStoreKeys().get(str1);
      break;
    }
    OpenAppstore localOpenAppstore = new OpenAppstore(this.context, str1, localIOpenAppstore, localIntent, str2, paramServiceConnection);
    localOpenAppstore.componentName = paramComponentName;
    return localOpenAppstore;
  }

  public static String getSku(String paramString1, String paramString2)
  {
    return SkuManager.getInstance().getSku(paramString1, paramString2);
  }

  public static String getStoreSku(String paramString1, String paramString2)
  {
    return SkuManager.getInstance().getStoreSku(paramString1, paramString2);
  }

  public static void mapSku(String paramString1, String paramString2, String paramString3)
  {
    SkuManager.getInstance().mapSku(paramString1, paramString2, paramString3);
  }

  private List<ServiceInfo> queryOpenStoreServices()
  {
    Intent localIntent = new Intent("org.onepf.oms.openappstore.BIND");
    List localList = this.context.getPackageManager().queryIntentServices(localIntent, 0);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((ResolveInfo)localIterator.next()).serviceInfo);
    return Collections.unmodifiableList(localArrayList);
  }

  private void setup(final IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    final LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Set localSet = this.options.getAvailableStores();
    if (!localSet.isEmpty())
    {
      Iterator localIterator = this.options.getPreferredStoreNames().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Appstore localAppstore = this.options.getAvailableStoreWithName(str);
        if (localAppstore != null)
          localLinkedHashSet.add(localAppstore);
      }
      localLinkedHashSet.addAll(localSet);
      checkBillingAndFinish(paramOnIabSetupFinishedListener, localLinkedHashSet);
      return;
    }
    discoverOpenStores(new OpenStoresDiscoveredListener()
    {
      public void openStoresDiscovered(List<Appstore> paramAnonymousList)
      {
        ArrayList localArrayList = new ArrayList(paramAnonymousList);
        Iterator localIterator1 = OpenIabHelper.this.appstorePackageMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str3 = (String)localIterator1.next();
          String str4 = (String)OpenIabHelper.this.appstorePackageMap.get(str3);
          if ((!TextUtils.isEmpty(str4)) && (OpenIabHelper.this.appstoreFactoryMap.containsKey(str4)) && (Utils.packageInstalled(OpenIabHelper.this.context, str3)))
            localArrayList.add(((OpenIabHelper.AppstoreFactory)OpenIabHelper.this.appstoreFactoryMap.get(str4)).get());
        }
        Iterator localIterator2 = OpenIabHelper.this.appstoreFactoryMap.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          if (!OpenIabHelper.this.appstorePackageMap.values().contains(str2))
            localArrayList.add(((OpenIabHelper.AppstoreFactory)OpenIabHelper.this.appstoreFactoryMap.get(str2)).get());
        }
        Iterator localIterator3 = OpenIabHelper.this.options.getPreferredStoreNames().iterator();
        while (true)
        {
          if (!localIterator3.hasNext())
            break label332;
          String str1 = (String)localIterator3.next();
          Iterator localIterator4 = localArrayList.iterator();
          if (localIterator4.hasNext())
          {
            Appstore localAppstore = (Appstore)localIterator4.next();
            if (!TextUtils.equals(localAppstore.getAppstoreName(), str1))
              break;
            localLinkedHashSet.add(localAppstore);
          }
        }
        label332: localLinkedHashSet.addAll(localArrayList);
        OpenIabHelper.this.checkBillingAndFinish(paramOnIabSetupFinishedListener, localLinkedHashSet);
      }
    });
  }

  private void setupForPackage(final IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener, String paramString, final boolean paramBoolean)
  {
    if (!Utils.packageInstalled(this.context, paramString))
    {
      if (paramBoolean)
      {
        setup(paramOnIabSetupFinishedListener);
        return;
      }
      finishSetup(paramOnIabSetupFinishedListener);
      return;
    }
    String str;
    Appstore localAppstore;
    if (this.appstorePackageMap.containsKey(paramString))
    {
      str = (String)this.appstorePackageMap.get(paramString);
      if (this.options.getAvailableStores().isEmpty())
      {
        if (!this.appstoreFactoryMap.containsKey(str))
          break label259;
        localAppstore = ((AppstoreFactory)this.appstoreFactoryMap.get(str)).get();
      }
    }
    while (true)
      if (localAppstore != null)
      {
        checkBillingAndFinish(paramOnIabSetupFinishedListener, localAppstore);
        return;
        localAppstore = this.options.getAvailableStoreWithName(str);
        if (localAppstore == null)
          finishSetup(paramOnIabSetupFinishedListener);
      }
      else
      {
        Iterator localIterator = queryOpenStoreServices().iterator();
        ServiceInfo localServiceInfo;
        do
        {
          if (!localIterator.hasNext())
            break;
          localServiceInfo = (ServiceInfo)localIterator.next();
        }
        while (!TextUtils.equals(localServiceInfo.packageName, paramString));
        for (Intent localIntent = getBindServiceIntent(localServiceInfo); ; localIntent = null)
        {
          if (localIntent == null)
          {
            if (paramBoolean)
            {
              setup(paramOnIabSetupFinishedListener);
              return;
            }
            finishSetup(paramOnIabSetupFinishedListener);
            return;
          }
          if (this.context.bindService(localIntent, new ServiceConnection()
          {
            public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
            {
              while (true)
              {
                try
                {
                  Object localObject = OpenIabHelper.this.getOpenAppstore(paramAnonymousComponentName, paramAnonymousIBinder, this);
                  if (localObject != null)
                  {
                    String str = ((Appstore)localObject).getAppstoreName();
                    boolean bool = OpenIabHelper.this.options.getAvailableStores().isEmpty();
                    if (bool)
                    {
                      if ((localObject == null) && (paramBoolean))
                        OpenIabHelper.this.setup(paramOnIabSetupFinishedListener);
                    }
                    else
                    {
                      Appstore localAppstore = OpenIabHelper.this.options.getAvailableStoreWithName(str);
                      localObject = localAppstore;
                      continue;
                    }
                  }
                }
                catch (RemoteException localRemoteException)
                {
                  localObject = null;
                  continue;
                  OpenIabHelper.this.checkBillingAndFinish(paramOnIabSetupFinishedListener, (Appstore)localObject);
                  return;
                }
                localObject = null;
              }
            }

            public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
            {
            }
          }
          , 1))
            break;
          if (paramBoolean)
          {
            setup(paramOnIabSetupFinishedListener);
            return;
          }
          finishSetupWithError(paramOnIabSetupFinishedListener);
          return;
        }
        label259: localAppstore = null;
      }
  }

  private static String setupStateToString(int paramInt)
  {
    if (paramInt == -1)
      return " IAB helper is not set up.";
    if (paramInt == 2)
      return "IAB helper was disposed of.";
    if (paramInt == 0)
      return "IAB helper is set up.";
    if (paramInt == 1)
      return "IAB helper setup failed.";
    if (paramInt == 3)
      return "IAB helper setup is in progress.";
    throw new IllegalStateException("Wrong setup state: " + paramInt);
  }

  private boolean versionOk(Appstore paramAppstore)
  {
    String str = this.context.getPackageName();
    try
    {
      label24: return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label24;
    }
  }

  public void checkOptions()
  {
    checkGoogle();
    checkSamsung();
    checkNokia();
    checkAmazon();
  }

  void checkSetupDone(String paramString)
  {
    if (!setupSuccessful())
    {
      String str = setupStateToString(this.setupState);
      throw new IllegalStateException(str + " Can't perform operation: " + paramString);
    }
  }

  public void consume(Purchase paramPurchase)
    throws IabException
  {
    checkSetupDone("consume");
    Purchase localPurchase = (Purchase)paramPurchase.clone();
    localPurchase.setSku(paramPurchase.getSku());
    this.mAppstoreBillingService.consume(localPurchase);
  }

  public void consumeAsync(List<Purchase> paramList, IabHelper.OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    if (paramOnConsumeMultiFinishedListener == null)
      throw new IllegalArgumentException("Consume listener must be not null!");
    consumeAsyncInternal(paramList, null, paramOnConsumeMultiFinishedListener);
  }

  public void consumeAsync(Purchase paramPurchase, IabHelper.OnConsumeFinishedListener paramOnConsumeFinishedListener)
  {
    consumeAsyncInternal(Arrays.asList(new Purchase[] { paramPurchase }), paramOnConsumeFinishedListener, null);
  }

  void consumeAsyncInternal(final List<Purchase> paramList, final IabHelper.OnConsumeFinishedListener paramOnConsumeFinishedListener, final IabHelper.OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    checkSetupDone("consume");
    if (paramList.isEmpty())
      throw new IllegalArgumentException("Nothing to consume.");
    new Thread(new Runnable()
    {
      public void run()
      {
        final ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Purchase localPurchase = (Purchase)localIterator.next();
          try
          {
            OpenIabHelper.this.consume(localPurchase);
            localArrayList.add(new IabResult(0, "Successful consume of sku " + localPurchase.getSku()));
          }
          catch (IabException localIabException)
          {
            localArrayList.add(localIabException.getResult());
            OpenIabHelper.L.a(new Exception("Consume " + localPurchase.getSku() + " failed: " + localIabException.getResult().getResponse()), localIabException.getResult().getMessage());
          }
        }
        if ((OpenIabHelper.this.setupState != 2) && (paramOnConsumeFinishedListener != null))
          OpenIabHelper.this.handler.post(new Runnable()
          {
            public void run()
            {
              OpenIabHelper.18.this.val$singleListener.onConsumeFinished((Purchase)OpenIabHelper.18.this.val$purchases.get(0), (IabResult)localArrayList.get(0));
            }
          });
        if ((OpenIabHelper.this.setupState != 2) && (paramOnConsumeMultiFinishedListener != null))
          OpenIabHelper.this.handler.post(new Runnable()
          {
            public void run()
            {
              OpenIabHelper.18.this.val$multiListener.onConsumeMultiFinished(OpenIabHelper.18.this.val$purchases, localArrayList);
            }
          });
      }
    }).start();
  }

  public List<Appstore> discoverOpenStores()
  {
    if (Utils.uiThread())
      throw new IllegalStateException("Must not be called from UI thread");
    final ArrayList localArrayList = new ArrayList();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    discoverOpenStores(new OpenStoresDiscoveredListener()
    {
      public void openStoresDiscovered(List<Appstore> paramAnonymousList)
      {
        localArrayList.addAll(paramAnonymousList);
        localCountDownLatch.notify();
      }
    });
    try
    {
      localCountDownLatch.await();
      return localArrayList;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    return null;
  }

  public void discoverOpenStores(OpenStoresDiscoveredListener paramOpenStoresDiscoveredListener)
  {
    List localList = queryOpenStoreServices();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localLinkedList.add(getBindServiceIntent((ServiceInfo)localIterator.next()));
    discoverOpenStores(paramOpenStoresDiscoveredListener, localLinkedList, new ArrayList());
  }

  public void dispose()
  {
    if (this.mAppstoreBillingService != null)
      this.mAppstoreBillingService.dispose();
    this.mAppstore = null;
    this.mAppstoreBillingService = null;
    this.activity = null;
    this.setupState = 2;
  }

  public String getConnectedAppstoreName()
  {
    if (this.mAppstore == null)
      return null;
    return this.mAppstore.getAppstoreName();
  }

  public int getSetupState()
  {
    return this.setupState;
  }

  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == this.options.samsungCertificationRequestCode) && (this.appstoreInSetup != null))
      return this.appstoreInSetup.getInAppBillingService().handleActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.setupState != 0)
      return false;
    return this.mAppstoreBillingService.handleActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchPurchaseFlow(paramActivity, paramString1, paramInt, paramString2, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
  {
    launchPurchaseFlow(paramActivity, paramString1, "inapp", paramInt, paramString2, paramOnIabPurchaseFinishedListener, paramString3);
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4)
  {
    checkSetupDone("launchPurchaseFlow");
    this.mAppstoreBillingService.launchPurchaseFlow(paramActivity, paramString1, paramString2, paramInt, paramString3, paramOnIabPurchaseFinishedListener, paramString4);
  }

  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchSubscriptionPurchaseFlow(paramActivity, paramString1, paramInt, paramString2, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
  {
    launchPurchaseFlow(paramActivity, paramString1, "subs", paramInt, paramString2, paramOnIabPurchaseFinishedListener, paramString3);
  }

  public Inventory queryInventory(boolean paramBoolean, List<String> paramList)
    throws IabException
  {
    return queryInventory(paramBoolean, paramList, null);
  }

  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException
  {
    if (Utils.uiThread())
      throw new IllegalStateException("Must not be called from UI thread");
    checkSetupDone("queryInventory");
    return this.mAppstoreBillingService.queryInventory(paramBoolean, paramList1, paramList2);
  }

  public void queryInventoryAsync(IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(true, paramQueryInventoryFinishedListener);
  }

  public void queryInventoryAsync(final boolean paramBoolean, final List<String> paramList1, final List<String> paramList2, final IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    checkSetupDone("queryInventory");
    if (paramQueryInventoryFinishedListener == null)
      throw new IllegalArgumentException("Inventory listener must be not null");
    new Thread(new Runnable()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 24	org/onepf/oms/OpenIabHelper$17:this$0	Lorg/onepf/oms/OpenIabHelper;
        //   4: aload_0
        //   5: getfield 26	org/onepf/oms/OpenIabHelper$17:val$querySkuDetails	Z
        //   8: aload_0
        //   9: getfield 28	org/onepf/oms/OpenIabHelper$17:val$moreItemSkus	Ljava/util/List;
        //   12: aload_0
        //   13: getfield 30	org/onepf/oms/OpenIabHelper$17:val$moreSubsSkus	Ljava/util/List;
        //   16: invokevirtual 42	org/onepf/oms/OpenIabHelper:queryInventory	(ZLjava/util/List;Ljava/util/List;)Lorg/onepf/oms/appstore/googleUtils/Inventory;
        //   19: astore 6
        //   21: aload 6
        //   23: astore_2
        //   24: new 44	org/onepf/oms/appstore/googleUtils/IabResult
        //   27: dup
        //   28: iconst_0
        //   29: ldc 46
        //   31: invokespecial 49	org/onepf/oms/appstore/googleUtils/IabResult:<init>	(ILjava/lang/String;)V
        //   34: astore 4
        //   36: aload_0
        //   37: getfield 24	org/onepf/oms/OpenIabHelper$17:this$0	Lorg/onepf/oms/OpenIabHelper;
        //   40: invokestatic 53	org/onepf/oms/OpenIabHelper:access$1600	(Lorg/onepf/oms/OpenIabHelper;)I
        //   43: ifne +25 -> 68
        //   46: aload_0
        //   47: getfield 24	org/onepf/oms/OpenIabHelper$17:this$0	Lorg/onepf/oms/OpenIabHelper;
        //   50: invokestatic 57	org/onepf/oms/OpenIabHelper:access$1400	(Lorg/onepf/oms/OpenIabHelper;)Landroid/os/Handler;
        //   53: new 59	org/onepf/oms/OpenIabHelper$17$1
        //   56: dup
        //   57: aload_0
        //   58: aload 4
        //   60: aload_2
        //   61: invokespecial 62	org/onepf/oms/OpenIabHelper$17$1:<init>	(Lorg/onepf/oms/OpenIabHelper$17;Lorg/onepf/oms/appstore/googleUtils/IabResult;Lorg/onepf/oms/appstore/googleUtils/Inventory;)V
        //   64: invokevirtual 68	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   67: pop
        //   68: return
        //   69: astore_1
        //   70: aconst_null
        //   71: astore_2
        //   72: aload_1
        //   73: astore_3
        //   74: aload_3
        //   75: invokevirtual 72	org/onepf/oms/appstore/googleUtils/IabException:getResult	()Lorg/onepf/oms/appstore/googleUtils/IabResult;
        //   78: astore 4
        //   80: goto -44 -> 36
        //   83: astore_3
        //   84: goto -10 -> 74
        //
        // Exception table:
        //   from	to	target	type
        //   0	21	69	org/onepf/oms/appstore/googleUtils/IabException
        //   24	36	83	org/onepf/oms/appstore/googleUtils/IabException
      }
    }).start();
  }

  public void queryInventoryAsync(boolean paramBoolean, List<String> paramList, IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(paramBoolean, paramList, null, paramQueryInventoryFinishedListener);
  }

  public void queryInventoryAsync(boolean paramBoolean, IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(paramBoolean, null, paramQueryInventoryFinishedListener);
  }

  public void setProductsData(List<String> paramList)
  {
    checkSetupDone("setProductsData");
    Iterator localIterator = this.appReadyStores.values().iterator();
    while (localIterator.hasNext())
      ((Appstore)localIterator.next()).getInAppBillingService().setProductsData(paramList);
  }

  public boolean setProvider(String paramString)
  {
    try
    {
      checkSetupDone("setProvider");
      if (this.appReadyStores.get(paramString) != null)
      {
        this.mAppstoreBillingService = ((Appstore)this.appReadyStores.get(paramString)).getInAppBillingService();
        return true;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    return false;
  }

  public boolean setupSuccessful()
  {
    return this.setupState == 0;
  }

  public void startSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    if (paramOnIabSetupFinishedListener == null)
      throw new IllegalArgumentException("Setup listener must be not null!");
    if ((this.setupState != -1) && (this.setupState != 1))
      throw new IllegalStateException("Couldn't be set up. Current state: " + setupStateToString(this.setupState));
    this.setupState = 3;
    this.setupExecutorService = Executors.newSingleThreadExecutor();
    int i = this.options.getStoreSearchStrategy();
    String str1 = this.context.getPackageName();
    String str2 = this.packageManager.getInstallerPackageName(str1);
    int j;
    if (!TextUtils.isEmpty(str2))
      j = 1;
    while (i == 0)
      if (j != 0)
      {
        setupForPackage(paramOnIabSetupFinishedListener, str2, false);
        return;
        j = 0;
      }
      else
      {
        finishSetup(paramOnIabSetupFinishedListener);
        return;
      }
    if (i == 2)
    {
      if (j != 0)
      {
        setupForPackage(paramOnIabSetupFinishedListener, str2, true);
        return;
      }
      setup(paramOnIabSetupFinishedListener);
      return;
    }
    setup(paramOnIabSetupFinishedListener);
  }

  public boolean subscriptionsSupported()
  {
    checkSetupDone("subscriptionsSupported");
    return this.mAppstoreBillingService.subscriptionsSupported();
  }

  private static abstract interface AppstoreFactory
  {
    public abstract Appstore get();
  }

  public static abstract interface OnInitListener
  {
    public abstract void onInitFinished();
  }

  public static abstract interface OnOpenIabHelperInitFinished
  {
    public abstract void onOpenIabHelperInitFinished();
  }

  public static abstract interface OpenStoresDiscoveredListener
  {
    public abstract void openStoresDiscovered(List<Appstore> paramList);
  }

  public static class Options
  {
    public static final int SEARCH_STRATEGY_BEST_FIT = 1;
    public static final int SEARCH_STRATEGY_INSTALLER = 0;
    public static final int SEARCH_STRATEGY_INSTALLER_THEN_BEST_FIT = 2;
    public static final int VERIFY_EVERYTHING = 0;
    public static final int VERIFY_ONLY_KNOWN = 2;
    public static final int VERIFY_SKIP = 1;
    public final Set<Appstore> availableStores;
    public final boolean checkInventory;
    public final int checkInventoryTimeoutMs = 0;
    public final int discoveryTimeoutMs = 0;
    public final Set<String> preferredStoreNames;
    public final int samsungCertificationRequestCode;
    private final Map<String, String> storeKeys;
    private final int storeSearchStrategy;
    public final int verifyMode;

    public Options()
    {
      this.checkInventory = false;
      this.availableStores = Collections.emptySet();
      this.storeKeys = Collections.emptyMap();
      this.preferredStoreNames = Collections.emptySet();
      this.verifyMode = 1;
      this.samsungCertificationRequestCode = 899;
      this.storeSearchStrategy = 0;
    }

    private Options(Set<Appstore> paramSet, Map<String, String> paramMap, boolean paramBoolean, int paramInt1, Set<String> paramSet1, int paramInt2, int paramInt3)
    {
      this.checkInventory = paramBoolean;
      this.availableStores = paramSet;
      this.storeKeys = paramMap;
      this.preferredStoreNames = paramSet1;
      this.verifyMode = paramInt1;
      this.samsungCertificationRequestCode = paramInt2;
      this.storeSearchStrategy = paramInt3;
    }

    public Appstore getAvailableStoreWithName(String paramString)
    {
      Iterator localIterator = this.availableStores.iterator();
      while (localIterator.hasNext())
      {
        Appstore localAppstore = (Appstore)localIterator.next();
        if (paramString.equals(localAppstore.getAppstoreName()))
          return localAppstore;
      }
      return null;
    }

    public Set<Appstore> getAvailableStores()
    {
      return this.availableStores;
    }

    @Deprecated
    public long getCheckInventoryTimeout()
    {
      return 0L;
    }

    @Deprecated
    public long getDiscoveryTimeout()
    {
      return 0L;
    }

    public Set<String> getPreferredStoreNames()
    {
      return this.preferredStoreNames;
    }

    public int getSamsungCertificationRequestCode()
    {
      return this.samsungCertificationRequestCode;
    }

    public Map<String, String> getStoreKeys()
    {
      return this.storeKeys;
    }

    public int getStoreSearchStrategy()
    {
      return this.storeSearchStrategy;
    }

    public int getVerifyMode()
    {
      return this.verifyMode;
    }

    public boolean isCheckInventory()
    {
      return this.checkInventory;
    }

    public static final class Builder
    {
      private final Set<Appstore> availableStores = new HashSet();
      private boolean checkInventory = false;
      private final Set<String> preferredStoreNames = new LinkedHashSet();
      private int samsungCertificationRequestCode = 899;
      private final Map<String, String> storeKeys = new HashMap();
      private int storeSearchStrategy = 0;
      private int verifyMode = 0;

      public Builder addAvailableStores(Collection<Appstore> paramCollection)
      {
        this.availableStores.addAll(paramCollection);
        return this;
      }

      public Builder addAvailableStores(Appstore[] paramArrayOfAppstore)
      {
        addAvailableStores(Arrays.asList(paramArrayOfAppstore));
        return this;
      }

      public Builder addPreferredStoreName(Collection<String> paramCollection)
      {
        this.preferredStoreNames.addAll(paramCollection);
        return this;
      }

      public Builder addPreferredStoreName(String[] paramArrayOfString)
      {
        addPreferredStoreName(Arrays.asList(paramArrayOfString));
        return this;
      }

      public Builder addStoreKey(String paramString1, String paramString2)
      {
        try
        {
          Security.generatePublicKey(paramString2);
          this.storeKeys.put(paramString1, paramString2);
          return this;
        }
        catch (Exception localException)
        {
          throw new IllegalArgumentException(String.format("Invalid publicKey for store: %s, key: %s.", new Object[] { paramString1, paramString2 }), localException);
        }
      }

      public Builder addStoreKeys(Map<String, String> paramMap)
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)paramMap.get(str1);
          if (!TextUtils.isEmpty(str2))
            addStoreKey(str1, str2);
        }
        return this;
      }

      public OpenIabHelper.Options build()
      {
        return new OpenIabHelper.Options(Collections.unmodifiableSet(this.availableStores), Collections.unmodifiableMap(this.storeKeys), this.checkInventory, this.verifyMode, Collections.unmodifiableSet(this.preferredStoreNames), this.samsungCertificationRequestCode, this.storeSearchStrategy, null);
      }

      public Builder setCheckInventory(boolean paramBoolean)
      {
        this.checkInventory = paramBoolean;
        return this;
      }

      @Deprecated
      public Builder setCheckInventoryTimeout(int paramInt)
      {
        return this;
      }

      @Deprecated
      public Builder setDiscoveryTimeout(int paramInt)
      {
        return this;
      }

      public Builder setSamsungCertificationRequestCode(int paramInt)
      {
        if (paramInt < 0)
          throw new IllegalArgumentException("Value '" + paramInt + "' can't be request code. Request code must be a positive value.");
        this.samsungCertificationRequestCode = paramInt;
        return this;
      }

      public Builder setStoreSearchStrategy(int paramInt)
      {
        this.storeSearchStrategy = paramInt;
        return this;
      }

      public Builder setVerifyMode(int paramInt)
      {
        this.verifyMode = paramInt;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.OpenIabHelper
 * JD-Core Version:    0.6.2
 */