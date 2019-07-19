package com.vk.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;

public class VKPaymentsReceiver extends BroadcastReceiver
{
  private static VKAccessTokenTracker tracker = new VKAccessTokenTracker()
  {
    public void onVKAccessTokenChanged(VKAccessToken paramAnonymousVKAccessToken1, VKAccessToken paramAnonymousVKAccessToken2)
    {
      VKPaymentsReceiver.checkUserInstall(VKUIHelper.getApplicationContext(), false);
    }
  };

  private static boolean checkAccessNetworkStatePermission(Context paramContext)
  {
    return paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
  }

  private static void checkUserInstall(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
      VKPaymentsServerSender.getInstance(paramContext).checkUserInstall(paramBoolean);
  }

  private static boolean isActiveNetwork(Context paramContext)
  {
    if (checkAccessNetworkStatePermission(paramContext))
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
    }
    return true;
  }

  private static boolean isNeedForceOurUser(Intent paramIntent)
  {
    if (paramIntent == null);
    for (String str = null; (paramIntent != null) && ("com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())) && (str != null) && (str.startsWith("utm_source=vk")); str = paramIntent.getStringExtra("referrer"))
      return true;
    return false;
  }

  public static void onReceiveStatic(Context paramContext)
  {
    onReceiveStatic(paramContext, false);
  }

  private static void onReceiveStatic(Context paramContext, boolean paramBoolean)
  {
    if ((isActiveNetwork(paramContext)) && (VKSdk.isIsPaymentsEnable()))
    {
      if ((VKAccessToken.currentToken() == null) && (!tracker.isTracking()))
        tracker.startTracking();
      checkUserInstall(paramContext, paramBoolean);
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    onReceiveStatic(paramContext, isNeedForceOurUser(paramIntent));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.payments.VKPaymentsReceiver
 * JD-Core Version:    0.6.2
 */