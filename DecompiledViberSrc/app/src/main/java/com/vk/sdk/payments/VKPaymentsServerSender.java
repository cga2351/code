package com.vk.sdk.payments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKRequest.VKRequestListener;
import com.vk.sdk.api.VKResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class VKPaymentsServerSender
{
  private static final String APP_ID = "app_id";
  private static final int CHECK_USER_INSTALL_ANSWER_NOT_VK = 0;
  private static final int CHECK_USER_INSTALL_ANSWER_UNKNOWN = -1;
  private static final int CHECK_USER_INSTALL_ANSWER_VK = 1;
  private static final int CHECK_USER_INSTALL_ANSWER_VK_FORCE = 2;
  private static final String DEVICE_ID = "device_id";
  private static final String FORCE = "force";
  private static final String KEY_ANSWER = "VK_SDK_CHECK_USER_INSTALL";
  private static final String METHOD_NAME_CHECK_USER_INSTALL = "apps.checkUserInstall";
  private static final String METHOD_NAME_SAVE_TRANSACTION = "apps.saveTransaction";
  private static final String PLATFORM = "platform";
  private static final String RECEIPT = "receipt";
  private static final String RESPONSE = "response";
  private static VKPaymentsServerSender sInstance = null;
  private final Context mAppCtx;
  private volatile int mCheckUserInstallAnswer = -1;
  Runnable mCheckUserInstallRunnable = new Runnable()
  {
    public void run()
    {
      if ((VKSdk.isIsPaymentsEnable()) && ((VKPaymentsServerSender.this.mCheckUserInstallAnswer == -1) || (VKPaymentsServerSender.this.mCheckUserInstallAnswer == 2)))
      {
        int i = VKPaymentsServerSender.getIntResByName(VKPaymentsServerSender.this.mAppCtx, "com_vk_sdk_AppId").intValue();
        String str = VKPaymentsServerSender.getDeviceId(VKPaymentsServerSender.this.mAppCtx);
        VKRequest localVKRequest = new VKRequest("apps.checkUserInstall");
        localVKRequest.addExtraParameter("platform", "android");
        localVKRequest.addExtraParameter("app_id", Integer.valueOf(i));
        if (VKPaymentsServerSender.this.mCheckUserInstallAnswer == 2)
          localVKRequest.addExtraParameter("force", Integer.valueOf(1));
        if (!TextUtils.isEmpty(str))
          localVKRequest.addExtraParameter("device_id", str);
        localVKRequest.executeSyncWithListener(new VKRequest.VKRequestListener()
        {
          public void onComplete(VKResponse paramAnonymous2VKResponse)
          {
            try
            {
              VKPaymentsServerSender.this.onCheckUserInstallReceive(paramAnonymous2VKResponse.json.getInt("response"));
              VKPaymentsServerSender.log("apps.checkUserInstall successful response=" + paramAnonymous2VKResponse.json);
              return;
            }
            catch (JSONException localJSONException)
            {
              VKPaymentsServerSender.log("error", localJSONException);
            }
          }
        });
      }
    }
  };
  private final Handler mHandler;
  private final List<VKPaymentsCallback> mVkPaymentsCallbacks = new CopyOnWriteArrayList();

  private VKPaymentsServerSender(Context paramContext)
  {
    this.mAppCtx = paramContext;
    this.mCheckUserInstallAnswer = restoreAnswer(paramContext);
    HandlerThread localHandlerThread = new HandlerThread(getClass().getName());
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(1000L);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
  }

  private static String getDeviceId(Context paramContext)
  {
    try
    {
      Class localClass1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      Class localClass2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
      Method localMethod = localClass1.getDeclaredMethod("getAdvertisingIdInfo", new Class[] { Context.class });
      String str = (String)localClass2.getMethod("getId", new Class[0]).invoke(localMethod.invoke(localClass1, new Object[] { paramContext }), new Object[0]);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("vk", "error", localException);
    }
    return null;
  }

  public static VKPaymentsServerSender getInstance(Context paramContext)
  {
    if (sInstance == null);
    try
    {
      if (sInstance == null)
        sInstance = new VKPaymentsServerSender(paramContext.getApplicationContext());
      return sInstance;
    }
    finally
    {
    }
  }

  private static Integer getIntResByName(Context paramContext, String paramString)
  {
    int i = paramContext.getResources().getIdentifier(paramString, "integer", paramContext.getPackageName());
    try
    {
      Integer localInteger = Integer.valueOf(paramContext.getResources().getInteger(i));
      return localInteger;
    }
    catch (Exception localException)
    {
    }
    return Integer.valueOf(0);
  }

  public static boolean isNotVkUser()
  {
    if (!VKSdk.isIsPaymentsEnable());
    Context localContext;
    do
    {
      return true;
      localContext = VKUIHelper.getApplicationContext();
    }
    while ((localContext != null) && (getInstance(localContext).mCheckUserInstallAnswer == 0));
    return false;
  }

  private static void log(String paramString)
  {
  }

  private static void log(String paramString, Exception paramException)
  {
  }

  private void onCheckUserInstallReceive(int paramInt)
  {
    saveAnswer(this.mAppCtx, paramInt);
    while (true)
    {
      VKPaymentsCallback localVKPaymentsCallback;
      try
      {
        Iterator localIterator = this.mVkPaymentsCallbacks.iterator();
        if (!localIterator.hasNext())
          break label96;
        localVKPaymentsCallback = (VKPaymentsCallback)localIterator.next();
        switch (this.mCheckUserInstallAnswer)
        {
        case 0:
          localVKPaymentsCallback.onUserState(false);
          continue;
        case 1:
        case 2:
        }
      }
      finally
      {
      }
      localVKPaymentsCallback.onUserState(true);
      continue;
      label96: this.mVkPaymentsCallbacks.clear();
      return;
    }
  }

  private void request(boolean paramBoolean)
  {
    if (paramBoolean)
      onCheckUserInstallReceive(2);
    if ((this.mCheckUserInstallAnswer == -1) || (this.mCheckUserInstallAnswer == 2))
    {
      this.mHandler.post(this.mCheckUserInstallRunnable);
      requestSaveTransaction();
    }
    while (this.mCheckUserInstallAnswer != 1)
      return;
    requestSaveTransaction();
  }

  private void requestSaveTransaction()
  {
    HashSet localHashSet = VKPaymentsDatabase.getInstance(this.mAppCtx).getPurchases();
    if (localHashSet.size() > 0);
    for (SaveTransactionRunnable localSaveTransactionRunnable = new SaveTransactionRunnable(localHashSet, null); ; localSaveTransactionRunnable = null)
    {
      if (localSaveTransactionRunnable != null)
        this.mHandler.post(localSaveTransactionRunnable);
      return;
    }
  }

  private int restoreAnswer(Context paramContext)
  {
    try
    {
      int i = PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext()).getInt("VK_SDK_CHECK_USER_INSTALL", -1);
      return i;
    }
    finally
    {
    }
  }

  private void saveAnswer(Context paramContext, int paramInt)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext()).edit().putInt("VK_SDK_CHECK_USER_INSTALL", paramInt).apply();
      this.mCheckUserInstallAnswer = paramInt;
      return;
    }
    finally
    {
    }
  }

  public void checkUserInstall(boolean paramBoolean)
  {
    request(paramBoolean);
  }

  public void requestUserState(VKPaymentsCallback paramVKPaymentsCallback)
  {
    while (true)
    {
      try
      {
        switch (this.mCheckUserInstallAnswer)
        {
        default:
          this.mVkPaymentsCallbacks.add(paramVKPaymentsCallback);
          return;
        case 1:
        case 2:
          paramVKPaymentsCallback.onUserState(true);
          continue;
        case 0:
        }
      }
      finally
      {
      }
      paramVKPaymentsCallback.onUserState(false);
    }
  }

  public void saveTransaction(String paramString)
  {
    VKPaymentsDatabase.getInstance(this.mAppCtx).insertPurchase(paramString);
    request(false);
  }

  class SaveTransactionRunnable
    implements Runnable
  {
    final HashSet<String> purchases;

    private SaveTransactionRunnable()
    {
      Object localObject;
      this.purchases = localObject;
    }

    public void run()
    {
      if ((VKPaymentsServerSender.this.mCheckUserInstallAnswer == 1) || (VKPaymentsServerSender.this.mCheckUserInstallAnswer == 2))
      {
        Iterator localIterator = this.purchases.iterator();
        while (localIterator.hasNext())
        {
          final String str1 = (String)localIterator.next();
          int i = VKPaymentsServerSender.getIntResByName(VKPaymentsServerSender.this.mAppCtx, "com_vk_sdk_AppId").intValue();
          String str2 = VKPaymentsServerSender.getDeviceId(VKPaymentsServerSender.this.mAppCtx);
          VKRequest localVKRequest = new VKRequest("apps.saveTransaction");
          localVKRequest.addExtraParameter("platform", "android");
          localVKRequest.addExtraParameter("app_id", Integer.valueOf(i));
          if (!TextUtils.isEmpty(str2))
            localVKRequest.addExtraParameter("device_id", str2);
          localVKRequest.addExtraParameter("receipt", str1);
          localVKRequest.executeSyncWithListener(new VKRequest.VKRequestListener()
          {
            public void onComplete(VKResponse paramAnonymousVKResponse)
            {
              VKPaymentsDatabase.getInstance(VKPaymentsServerSender.this.mAppCtx).deletePurchase(str1);
              VKPaymentsServerSender.log("apps.saveTransaction successful response=" + paramAnonymousVKResponse.json);
            }

            public void onError(VKError paramAnonymousVKError)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("apps.saveTransaction error=");
              if (paramAnonymousVKError.apiError == null);
              for (String str = paramAnonymousVKError.errorMessage; ; str = paramAnonymousVKError.apiError.errorMessage)
              {
                VKPaymentsServerSender.log(str);
                return;
              }
            }
          });
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.payments.VKPaymentsServerSender
 * JD-Core Version:    0.6.2
 */