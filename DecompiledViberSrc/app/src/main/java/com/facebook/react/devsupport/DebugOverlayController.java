package com.facebook.react.devsupport;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;

class DebugOverlayController
{

  @Nullable
  private FrameLayout mFPSDebugViewContainer;
  private final ReactContext mReactContext;
  private final WindowManager mWindowManager;

  public DebugOverlayController(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
    this.mWindowManager = ((WindowManager)paramReactContext.getSystemService("window"));
  }

  private static boolean canHandleIntent(Context paramContext, Intent paramIntent)
  {
    return paramIntent.resolveActivity(paramContext.getPackageManager()) != null;
  }

  private static boolean hasPermission(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096);
      String[] arrayOfString1 = localPackageInfo.requestedPermissions;
      boolean bool1 = false;
      String[] arrayOfString2;
      int i;
      if (arrayOfString1 != null)
      {
        arrayOfString2 = localPackageInfo.requestedPermissions;
        i = arrayOfString2.length;
      }
      for (int j = 0; ; j++)
      {
        bool1 = false;
        if (j < i)
        {
          boolean bool2 = arrayOfString2[j].equals(paramString);
          if (bool2)
            bool1 = true;
        }
        else
        {
          return bool1;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      FLog.e("ReactNative", "Error while retrieving package info", localNameNotFoundException);
    }
    return false;
  }

  private static boolean permissionCheck(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return Settings.canDrawOverlays(paramContext);
    return hasPermission(paramContext, "android.permission.SYSTEM_ALERT_WINDOW");
  }

  public static void requestPermission(Context paramContext)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(paramContext)))
    {
      Intent localIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + paramContext.getPackageName()));
      localIntent.setFlags(268435456);
      FLog.w("ReactNative", "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
      if (canHandleIntent(paramContext, localIntent))
        paramContext.startActivity(localIntent);
    }
  }

  public void setFpsDebugViewVisible(final boolean paramBoolean)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if ((paramBoolean) && (DebugOverlayController.this.mFPSDebugViewContainer == null))
          if (!DebugOverlayController.permissionCheck(DebugOverlayController.this.mReactContext))
            FLog.d("ReactNative", "Wait for overlay permission to be set");
        while ((paramBoolean) || (DebugOverlayController.this.mFPSDebugViewContainer == null))
        {
          return;
          DebugOverlayController.access$002(DebugOverlayController.this, new FpsView(DebugOverlayController.this.mReactContext));
          WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, WindowOverlayCompat.TYPE_SYSTEM_OVERLAY, 24, -3);
          DebugOverlayController.this.mWindowManager.addView(DebugOverlayController.this.mFPSDebugViewContainer, localLayoutParams);
          return;
        }
        DebugOverlayController.this.mFPSDebugViewContainer.removeAllViews();
        DebugOverlayController.this.mWindowManager.removeView(DebugOverlayController.this.mFPSDebugViewContainer);
        DebugOverlayController.access$002(DebugOverlayController.this, null);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DebugOverlayController
 * JD-Core Version:    0.6.2
 */