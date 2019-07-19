package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.base.R.drawable;
import com.google.android.gms.base.R.string;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final Object mLock = new Object();
  private static final GoogleApiAvailability zaao = new GoogleApiAvailability();
  private String zaap;

  public static GoogleApiAvailability getInstance()
  {
    return zaao;
  }

  public static Dialog zaa(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ProgressBar localProgressBar = new ProgressBar(paramActivity, null, 16842874);
    localProgressBar.setIndeterminate(true);
    localProgressBar.setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView(localProgressBar);
    localBuilder.setMessage(ConnectionErrorMessages.getErrorMessage(paramActivity, 18));
    localBuilder.setPositiveButton("", null);
    AlertDialog localAlertDialog = localBuilder.create();
    zaa(paramActivity, localAlertDialog, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return localAlertDialog;
  }

  static Dialog zaa(Context paramContext, int paramInt, DialogRedirect paramDialogRedirect, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (paramInt == 0)
      return null;
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(16843529, localTypedValue, true);
    boolean bool = "Theme.Dialog.Alert".equals(paramContext.getResources().getResourceEntryName(localTypedValue.resourceId));
    AlertDialog.Builder localBuilder = null;
    if (bool)
      localBuilder = new AlertDialog.Builder(paramContext, 5);
    if (localBuilder == null)
      localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setMessage(ConnectionErrorMessages.getErrorMessage(paramContext, paramInt));
    if (paramOnCancelListener != null)
      localBuilder.setOnCancelListener(paramOnCancelListener);
    String str1 = ConnectionErrorMessages.getErrorDialogButtonMessage(paramContext, paramInt);
    if (str1 != null)
      localBuilder.setPositiveButton(str1, paramDialogRedirect);
    String str2 = ConnectionErrorMessages.getErrorTitle(paramContext, paramInt);
    if (str2 != null)
      localBuilder.setTitle(str2);
    return localBuilder.create();
  }

  static void zaa(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if ((paramActivity instanceof FragmentActivity))
    {
      android.support.v4.app.FragmentManager localFragmentManager1 = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(localFragmentManager1, paramString);
      return;
    }
    android.app.FragmentManager localFragmentManager = paramActivity.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(localFragmentManager, paramString);
  }

  @TargetApi(20)
  private final void zaa(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    if (paramInt == 18)
      zaa(paramContext);
    do
    {
      return;
      if (paramPendingIntent != null)
        break;
    }
    while (paramInt != 6);
    Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
    return;
    String str1 = ConnectionErrorMessages.getErrorNotificationTitle(paramContext, paramInt);
    String str2 = ConnectionErrorMessages.getErrorNotificationMessage(paramContext, paramInt);
    Resources localResources = paramContext.getResources();
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext).setLocalOnly(true).setAutoCancel(true).setContentTitle(str1).setStyle(new NotificationCompat.BigTextStyle().bigText(str2));
    NotificationChannel localNotificationChannel;
    String str4;
    label222: Notification localNotification;
    int i;
    if (DeviceProperties.isWearable(paramContext))
    {
      Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
      localBuilder.setSmallIcon(paramContext.getApplicationInfo().icon).setPriority(2);
      if (DeviceProperties.isWearableWithoutPlayStore(paramContext))
      {
        localBuilder.addAction(R.drawable.common_full_open_on_phone, localResources.getString(R.string.common_open_on_phone), paramPendingIntent);
        if (PlatformVersion.isAtLeastO())
        {
          Preconditions.checkState(PlatformVersion.isAtLeastO());
          String str3 = zag();
          if (str3 == null)
          {
            str3 = "com.google.android.gms.availability";
            localNotificationChannel = localNotificationManager.getNotificationChannel(str3);
            str4 = ConnectionErrorMessages.getDefaultNotificationChannelName(paramContext);
            if (localNotificationChannel != null)
              break label329;
            localNotificationManager.createNotificationChannel(new NotificationChannel(str3, str4, 4));
          }
          localBuilder.setChannelId(str3);
        }
        localNotification = localBuilder.build();
        switch (paramInt)
        {
        default:
          i = 39789;
        case 1:
        case 2:
        case 3:
        }
      }
    }
    while (true)
    {
      localNotificationManager.notify(i, localNotification);
      return;
      localBuilder.setContentIntent(paramPendingIntent);
      break;
      localBuilder.setSmallIcon(17301642).setTicker(localResources.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(paramPendingIntent).setContentText(str2);
      break;
      label329: if (str4.equals(localNotificationChannel.getName()))
        break label222;
      localNotificationChannel.setName(str4);
      localNotificationManager.createNotificationChannel(localNotificationChannel);
      break label222;
      i = 10436;
      GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
    }
  }

  private final String zag()
  {
    synchronized (mLock)
    {
      String str = this.zaap;
      return str;
    }
  }

  public Task<Void> checkApiAvailability(GoogleApi<?> paramGoogleApi, GoogleApi<?>[] paramArrayOfGoogleApi)
  {
    Preconditions.checkNotNull(paramGoogleApi, "Requested API must not be null.");
    int i = paramArrayOfGoogleApi.length;
    for (int j = 0; j < i; j++)
      Preconditions.checkNotNull(paramArrayOfGoogleApi[j], "Requested API must not be null.");
    ArrayList localArrayList = new ArrayList(1 + paramArrayOfGoogleApi.length);
    localArrayList.add(paramGoogleApi);
    localArrayList.addAll(Arrays.asList(paramArrayOfGoogleApi));
    return GoogleApiManager.zabc().zaa(localArrayList).continueWith(new zaa(this));
  }

  @KeepForSdk
  @ShowFirstParty
  public int getClientVersion(Context paramContext)
  {
    return super.getClientVersion(paramContext);
  }

  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }

  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return zaa(paramActivity, paramInt1, DialogRedirect.getInstance(paramActivity, getErrorResolutionIntent(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
  }

  @KeepForSdk
  @ShowFirstParty
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString)
  {
    return super.getErrorResolutionIntent(paramContext, paramInt, paramString);
  }

  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }

  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution())
      return paramConnectionResult.getResolution();
    return getErrorResolutionPendingIntent(paramContext, paramConnectionResult.getErrorCode(), 0);
  }

  public final String getErrorString(int paramInt)
  {
    return super.getErrorString(paramInt);
  }

  @HideFirstParty
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    return super.isGooglePlayServicesAvailable(paramContext);
  }

  @KeepForSdk
  @ShowFirstParty
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    return super.isGooglePlayServicesAvailable(paramContext, paramInt);
  }

  public final boolean isUserResolvableError(int paramInt)
  {
    return super.isUserResolvableError(paramInt);
  }

  public Task<Void> makeGooglePlayServicesAvailable(Activity paramActivity)
  {
    int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
    int j = isGooglePlayServicesAvailable(paramActivity, i);
    if (j == 0)
      return Tasks.forResult(null);
    zabu localzabu = zabu.zac(paramActivity);
    localzabu.zab(new ConnectionResult(j, null), 0);
    return localzabu.getTask();
  }

  @TargetApi(26)
  public void setDefaultNotificationChannelId(Context paramContext, String paramString)
  {
    if (PlatformVersion.isAtLeastO())
      Preconditions.checkNotNull(((NotificationManager)paramContext.getSystemService("notification")).getNotificationChannel(paramString));
    synchronized (mLock)
    {
      this.zaap = paramString;
      return;
    }
  }

  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }

  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (localDialog == null)
      return false;
    zaa(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }

  public void showErrorNotification(Context paramContext, int paramInt)
  {
    zaa(paramContext, paramInt, null, getErrorResolutionPendingIntent(paramContext, paramInt, 0, "n"));
  }

  public void showErrorNotification(Context paramContext, ConnectionResult paramConnectionResult)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    zaa(paramContext, paramConnectionResult.getErrorCode(), null, localPendingIntent);
  }

  public final zabq zaa(Context paramContext, zabr paramzabr)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    zabq localzabq = new zabq(paramzabr);
    paramContext.registerReceiver(localzabq, localIntentFilter);
    localzabq.zac(paramContext);
    if (!isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms"))
    {
      paramzabr.zas();
      localzabq.unregister();
      localzabq = null;
    }
    return localzabq;
  }

  final void zaa(Context paramContext)
  {
    new zaa(paramContext).sendEmptyMessageDelayed(1, 120000L);
  }

  public final boolean zaa(Activity paramActivity, LifecycleFragment paramLifecycleFragment, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = zaa(paramActivity, paramInt1, DialogRedirect.getInstance(paramLifecycleFragment, getErrorResolutionIntent(paramActivity, paramInt1, "d"), 2), paramOnCancelListener);
    if (localDialog == null)
      return false;
    zaa(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }

  public final boolean zaa(Context paramContext, ConnectionResult paramConnectionResult, int paramInt)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (localPendingIntent != null)
    {
      zaa(paramContext, paramConnectionResult.getErrorCode(), null, GoogleApiActivity.zaa(paramContext, localPendingIntent, paramInt));
      return true;
    }
    return false;
  }

  @SuppressLint({"HandlerLeak"})
  private final class zaa extends com.google.android.gms.internal.base.zal
  {
    private final Context zaaq;

    public zaa(Context arg2)
    {
    }

    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        int j = paramMessage.what;
        Log.w("GoogleApiAvailability", 50 + "Don't know how to handle this message: " + j);
      case 1:
      }
      int i;
      do
      {
        return;
        i = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.zaaq);
      }
      while (!GoogleApiAvailability.this.isUserResolvableError(i));
      GoogleApiAvailability.this.showErrorNotification(this.zaaq, i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailability
 * JD-Core Version:    0.6.2
 */