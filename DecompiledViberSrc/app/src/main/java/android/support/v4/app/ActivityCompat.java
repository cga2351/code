package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.a.a.a;
import android.support.v4.content.ContextCompat;
import android.view.DragEvent;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat
{
  private static PermissionCompatDelegate sDelegate;

  public static void finishAffinity(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.finish();
  }

  public static void finishAfterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      return;
    }
    paramActivity.finish();
  }

  public static PermissionCompatDelegate getPermissionCompatDelegate()
  {
    return sDelegate;
  }

  public static Uri getReferrer(Activity paramActivity)
  {
    Uri localUri;
    if (Build.VERSION.SDK_INT >= 22)
      localUri = paramActivity.getReferrer();
    Intent localIntent;
    do
    {
      return localUri;
      localIntent = paramActivity.getIntent();
      localUri = (Uri)localIntent.getParcelableExtra("android.intent.extra.REFERRER");
    }
    while (localUri != null);
    String str = localIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
    if (str != null)
      return Uri.parse(str);
    return null;
  }

  @Deprecated
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    paramActivity.invalidateOptionsMenu();
    return true;
  }

  public static void postponeEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramActivity.postponeEnterTransition();
  }

  public static a requestDragAndDropPermissions(Activity paramActivity, DragEvent paramDragEvent)
  {
    return a.a(paramActivity, paramDragEvent);
  }

  public static void requestPermissions(final Activity paramActivity, String[] paramArrayOfString, final int paramInt)
  {
    if ((sDelegate != null) && (sDelegate.requestPermissions(paramActivity, paramArrayOfString, paramInt)));
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((paramActivity instanceof RequestPermissionsRequestCodeValidator))
          ((RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt);
        paramActivity.requestPermissions(paramArrayOfString, paramInt);
        return;
      }
    }
    while (!(paramActivity instanceof OnRequestPermissionsResultCallback));
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        int[] arrayOfInt = new int[this.val$permissions.length];
        PackageManager localPackageManager = paramActivity.getPackageManager();
        String str = paramActivity.getPackageName();
        int i = this.val$permissions.length;
        for (int j = 0; j < i; j++)
          arrayOfInt[j] = localPackageManager.checkPermission(this.val$permissions[j], str);
        ((ActivityCompat.OnRequestPermissionsResultCallback)paramActivity).onRequestPermissionsResult(paramInt, this.val$permissions, arrayOfInt);
      }
    });
  }

  public static <T extends View> T requireViewById(Activity paramActivity, int paramInt)
  {
    View localView;
    if (Build.VERSION.SDK_INT >= 28)
      localView = paramActivity.requireViewById(paramInt);
    do
    {
      return localView;
      localView = paramActivity.findViewById(paramInt);
    }
    while (localView != null);
    throw new IllegalArgumentException("ID does not reference a View inside this Activity");
  }

  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
      if (paramSharedElementCallback == null)
        break label27;
    label27: for (SharedElementCallback21Impl localSharedElementCallback21Impl = new SharedElementCallback21Impl(paramSharedElementCallback); ; localSharedElementCallback21Impl = null)
    {
      paramActivity.setEnterSharedElementCallback(localSharedElementCallback21Impl);
      return;
    }
  }

  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
      if (paramSharedElementCallback == null)
        break label27;
    label27: for (SharedElementCallback21Impl localSharedElementCallback21Impl = new SharedElementCallback21Impl(paramSharedElementCallback); ; localSharedElementCallback21Impl = null)
    {
      paramActivity.setExitSharedElementCallback(localSharedElementCallback21Impl);
      return;
    }
  }

  public static void setPermissionCompatDelegate(PermissionCompatDelegate paramPermissionCompatDelegate)
  {
    sDelegate = paramPermissionCompatDelegate;
  }

  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramActivity.shouldShowRequestPermissionRationale(paramString);
    return false;
  }

  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }

  public static void startIntentSenderForResult(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }

  public static void startPostponedEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramActivity.startPostponedEnterTransition();
  }

  public static abstract interface OnRequestPermissionsResultCallback
  {
    public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }

  public static abstract interface PermissionCompatDelegate
  {
    public abstract boolean onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);

    public abstract boolean requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt);
  }

  public static abstract interface RequestPermissionsRequestCodeValidator
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }

  private static class SharedElementCallback21Impl extends android.app.SharedElementCallback
  {
    private final SharedElementCallback mCallback;

    SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback)
    {
      this.mCallback = paramSharedElementCallback;
    }

    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return this.mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
    }

    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return this.mCallback.onCreateSnapshotView(paramContext, paramParcelable);
    }

    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap)
    {
      this.mCallback.onMapSharedElements(paramList, paramMap);
    }

    public void onRejectSharedElements(List<View> paramList)
    {
      this.mCallback.onRejectSharedElements(paramList);
    }

    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementEnd(paramList, paramList1, paramList2);
    }

    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementStart(paramList, paramList1, paramList2);
    }

    public void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final android.app.SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
    {
      this.mCallback.onSharedElementsArrived(paramList, paramList1, new SharedElementCallback.OnSharedElementsReadyListener()
      {
        public void onSharedElementsReady()
        {
          paramOnSharedElementsReadyListener.onSharedElementsReady();
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat
 * JD-Core Version:    0.6.2
 */