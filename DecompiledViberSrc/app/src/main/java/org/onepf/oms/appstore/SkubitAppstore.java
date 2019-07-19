package org.onepf.oms.appstore;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.DefaultAppstore;
import org.onepf.oms.appstore.skubitUtils.SkubitIabHelper;
import org.onepf.oms.util.CollectionUtils;
import org.onepf.oms.util.Utils;

public class SkubitAppstore extends DefaultAppstore
{
  private static final Logger L = ViberEnv.getLogger();
  public static final String SKUBIT_INSTALLER = "com.skubit.android";
  public static final int TIMEOUT_BILLING_SUPPORTED = 2000;
  public static final String VENDING_ACTION = "com.skubit.android.billing.IBillingService.BIND";
  private volatile Boolean billingAvailable = null;
  protected final Context context;
  protected final boolean isDebugMode = false;
  protected AppstoreInAppBillingService mBillingService;

  public SkubitAppstore(Context paramContext)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context is null");
    this.context = paramContext;
  }

  private boolean packageExists(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public String getAction()
  {
    return "com.skubit.android.billing.IBillingService.BIND";
  }

  public String getAppstoreName()
  {
    return "com.skubit.android";
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    try
    {
      if (this.mBillingService == null)
        this.mBillingService = new SkubitIabHelper(this.context, null, this);
      AppstoreInAppBillingService localAppstoreInAppBillingService = this.mBillingService;
      return localAppstoreInAppBillingService;
    }
    finally
    {
    }
  }

  public String getInstaller()
  {
    return "com.skubit.android";
  }

  public int getPackageVersion(String paramString)
  {
    return -1;
  }

  public boolean isBillingAvailable(final String paramString)
  {
    if (this.billingAvailable != null)
      return this.billingAvailable.booleanValue();
    if (Utils.uiThread())
      throw new IllegalStateException("Must no be called from UI thread.");
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("packageName is null");
    this.billingAvailable = Boolean.valueOf(false);
    final CountDownLatch localCountDownLatch;
    if (packageExists(this.context, "com.skubit.android"))
    {
      Intent localIntent = new Intent(getAction());
      localIntent.setPackage(getInstaller());
      if (!CollectionUtils.isEmpty(this.context.getPackageManager().queryIntentServices(localIntent, 0)))
      {
        localCountDownLatch = new CountDownLatch(1);
        ServiceConnection local1 = new ServiceConnection()
        {
          // ERROR //
          public void onServiceConnected(ComponentName paramAnonymousComponentName, android.os.IBinder paramAnonymousIBinder)
          {
            // Byte code:
            //   0: aload_2
            //   1: invokestatic 38	com/g/a/a/a$a:a	(Landroid/os/IBinder;)Lcom/g/a/a/a;
            //   4: astore_3
            //   5: aload_3
            //   6: iconst_1
            //   7: aload_0
            //   8: getfield 23	org/onepf/oms/appstore/SkubitAppstore$1:val$packageName	Ljava/lang/String;
            //   11: ldc 40
            //   13: invokeinterface 45 4 0
            //   18: ifne +15 -> 33
            //   21: aload_0
            //   22: getfield 21	org/onepf/oms/appstore/SkubitAppstore$1:this$0	Lorg/onepf/oms/appstore/SkubitAppstore;
            //   25: iconst_1
            //   26: invokestatic 51	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
            //   29: invokestatic 55	org/onepf/oms/appstore/SkubitAppstore:access$002	(Lorg/onepf/oms/appstore/SkubitAppstore;Ljava/lang/Boolean;)Ljava/lang/Boolean;
            //   32: pop
            //   33: aload_0
            //   34: getfield 25	org/onepf/oms/appstore/SkubitAppstore$1:val$latch	Ljava/util/concurrent/CountDownLatch;
            //   37: invokevirtual 60	java/util/concurrent/CountDownLatch:countDown	()V
            //   40: aload_0
            //   41: getfield 21	org/onepf/oms/appstore/SkubitAppstore$1:this$0	Lorg/onepf/oms/appstore/SkubitAppstore;
            //   44: getfield 64	org/onepf/oms/appstore/SkubitAppstore:context	Landroid/content/Context;
            //   47: aload_0
            //   48: invokevirtual 70	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
            //   51: return
            //   52: astore 5
            //   54: aload_0
            //   55: getfield 25	org/onepf/oms/appstore/SkubitAppstore$1:val$latch	Ljava/util/concurrent/CountDownLatch;
            //   58: invokevirtual 60	java/util/concurrent/CountDownLatch:countDown	()V
            //   61: aload_0
            //   62: getfield 21	org/onepf/oms/appstore/SkubitAppstore$1:this$0	Lorg/onepf/oms/appstore/SkubitAppstore;
            //   65: getfield 64	org/onepf/oms/appstore/SkubitAppstore:context	Landroid/content/Context;
            //   68: aload_0
            //   69: invokevirtual 70	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
            //   72: return
            //   73: astore 4
            //   75: aload_0
            //   76: getfield 25	org/onepf/oms/appstore/SkubitAppstore$1:val$latch	Ljava/util/concurrent/CountDownLatch;
            //   79: invokevirtual 60	java/util/concurrent/CountDownLatch:countDown	()V
            //   82: aload_0
            //   83: getfield 21	org/onepf/oms/appstore/SkubitAppstore$1:this$0	Lorg/onepf/oms/appstore/SkubitAppstore;
            //   86: getfield 64	org/onepf/oms/appstore/SkubitAppstore:context	Landroid/content/Context;
            //   89: aload_0
            //   90: invokevirtual 70	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
            //   93: aload 4
            //   95: athrow
            //
            // Exception table:
            //   from	to	target	type
            //   5	33	52	android/os/RemoteException
            //   5	33	73	finally
          }

          public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
          }
        };
        if (!this.context.bindService(localIntent, local1, 1));
      }
    }
    try
    {
      localCountDownLatch.await(2000L, TimeUnit.MILLISECONDS);
      label157: return this.billingAvailable.booleanValue();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label157;
    }
  }

  public boolean isPackageInstaller(String paramString)
  {
    return Utils.isPackageInstaller(this.context, "com.skubit.android");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.SkubitAppstore
 * JD-Core Version:    0.6.2
 */