package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";

  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 0;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }

  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramActivity, paramInt1))
      paramInt1 = 18;
    return GoogleApiAvailability.getInstance().getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }

  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return GooglePlayServicesUtilLight.getErrorPendingIntent(paramInt1, paramContext, paramInt2);
  }

  @Deprecated
  @VisibleForTesting
  public static String getErrorString(int paramInt)
  {
    return GooglePlayServicesUtilLight.getErrorString(paramInt);
  }

  public static Context getRemoteContext(Context paramContext)
  {
    return GooglePlayServicesUtilLight.getRemoteContext(paramContext);
  }

  public static Resources getRemoteResource(Context paramContext)
  {
    return GooglePlayServicesUtilLight.getRemoteResource(paramContext);
  }

  @Deprecated
  @HideFirstParty
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext);
  }

  @Deprecated
  @KeepForSdk
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext, paramInt);
  }

  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    return GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
  }

  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }

  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }

  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramActivity, paramInt1))
      paramInt1 = 18;
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    if (paramFragment == null)
      return localGoogleApiAvailability.showErrorDialogFragment(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    Dialog localDialog = GoogleApiAvailability.zaa(paramActivity, paramInt1, DialogRedirect.getInstance(paramFragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
    if (localDialog == null)
      return false;
    GoogleApiAvailability.zaa(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }

  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    if ((GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt)) || (GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt)))
    {
      localGoogleApiAvailability.zaa(paramContext);
      return;
    }
    localGoogleApiAvailability.showErrorNotification(paramContext, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * JD-Core Version:    0.6.2
 */