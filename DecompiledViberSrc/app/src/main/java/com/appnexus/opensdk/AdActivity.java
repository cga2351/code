package com.appnexus.opensdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.Settings;
import com.appnexus.opensdk.utils.StringUtil;
import com.appnexus.opensdk.utils.WebviewUtil;
import java.util.Locale;

public class AdActivity extends Activity
{
  public static final String ACTIVITY_TYPE_BROWSER = "BROWSER";
  public static final String INTENT_KEY_ACTIVITY_TYPE = "ACTIVITY_TYPE";
  static Class a = AdActivity.class;
  private a b;

  protected static void a(Activity paramActivity)
  {
    b(paramActivity, paramActivity.getResources().getConfiguration().orientation);
  }

  protected static void a(Activity paramActivity, int paramInt)
  {
    b(paramActivity, paramInt);
  }

  protected static void a(Activity paramActivity, b paramb)
  {
    int i = paramActivity.getResources().getConfiguration().orientation;
    switch (1.a[paramb.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      b(paramActivity, i);
      return;
      paramActivity.setRequestedOrientation(-1);
      return;
      i = 2;
      continue;
      i = 1;
    }
  }

  protected static void b(Activity paramActivity)
  {
    paramActivity.setRequestedOrientation(-1);
  }

  @TargetApi(9)
  private static void b(Activity paramActivity, int paramInt)
  {
    String str = Settings.getSettings().deviceModel.toUpperCase(Locale.US);
    if ((Settings.getSettings().deviceMake.toUpperCase(Locale.US).equals("AMAZON")) && ((str.equals("KFTT")) || (str.equals("KFJWI")) || (str.equals("KFJWA"))));
    for (int i = 1; ; i = 0)
    {
      int j;
      if ((paramActivity != null) && (!paramActivity.isFinishing()))
      {
        j = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRotation();
        if (paramInt != 1)
          break label130;
        if (Build.VERSION.SDK_INT >= 9)
          break label111;
        paramActivity.setRequestedOrientation(1);
      }
      label111: 
      while (paramInt != 2)
      {
        return;
        if (j == 2)
        {
          paramActivity.setRequestedOrientation(9);
          return;
        }
        paramActivity.setRequestedOrientation(1);
        return;
      }
      label130: if (Build.VERSION.SDK_INT < 9)
      {
        paramActivity.setRequestedOrientation(0);
        return;
      }
      if (i != 0)
      {
        if ((j == 0) || (j == 1))
        {
          paramActivity.setRequestedOrientation(8);
          return;
        }
        paramActivity.setRequestedOrientation(0);
        return;
      }
      if ((j == 0) || (j == 1))
      {
        paramActivity.setRequestedOrientation(0);
        return;
      }
      paramActivity.setRequestedOrientation(8);
      return;
    }
  }

  public static Class getActivityClass()
  {
    return a;
  }

  public void onBackPressed()
  {
    if (this.b != null)
      this.b.backPressed();
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str = getIntent().getStringExtra("ACTIVITY_TYPE");
    if (StringUtil.isEmpty(str))
    {
      Clog.e(Clog.baseLogTag, Clog.getString(R.string.adactivity_no_type));
      finish();
    }
    while (true)
    {
      CookieSyncManager.createInstance(this);
      CookieSyncManager localCookieSyncManager = CookieSyncManager.getInstance();
      if (localCookieSyncManager != null)
        localCookieSyncManager.startSync();
      return;
      if ("INTERSTITIAL".equals(str))
      {
        this.b = new l(this);
        this.b.create();
      }
      else if ("BROWSER".equals(str))
      {
        this.b = new BrowserAdActivity(this);
        this.b.create();
      }
      else if ("MRAID".equals(str))
      {
        this.b = new n(this);
        this.b.create();
      }
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return false;
  }

  protected void onDestroy()
  {
    if (this.b != null)
      this.b.destroy();
    super.onDestroy();
  }

  protected void onPause()
  {
    if (this.b != null)
      WebviewUtil.onPause(this.b.getWebView());
    CookieSyncManager localCookieSyncManager = CookieSyncManager.getInstance();
    if (localCookieSyncManager != null)
      localCookieSyncManager.stopSync();
    super.onPause();
  }

  protected void onResume()
  {
    if (this.b != null)
      WebviewUtil.onResume(this.b.getWebView());
    CookieSyncManager localCookieSyncManager = CookieSyncManager.getInstance();
    if (localCookieSyncManager != null)
      localCookieSyncManager.startSync();
    super.onResume();
  }

  static abstract interface a
  {
    public abstract void backPressed();

    public abstract void browserLaunched();

    public abstract void create();

    public abstract void destroy();

    public abstract WebView getWebView();

    public abstract void interacted();
  }

  static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.AdActivity
 * JD-Core Version:    0.6.2
 */