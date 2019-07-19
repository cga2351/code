package com.viber.voip.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArraySet;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberAppCompatActivity;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.b.m;
import com.viber.voip.analytics.story.o;
import com.viber.voip.e.a.h;
import com.viber.voip.messages.o.a;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.ViberActionRunner.aa;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import java.util.Iterator;

public class ViberFragmentActivity extends ViberAppCompatActivity
  implements m, com.viber.voip.ui.c.a
{
  public static final com.viber.voip.e.a.c BT = com.viber.voip.e.a.e.b();
  public static final String EXTRA_PIN_DIALOG_BUNDLE = "extra_pin_dialog_bundle";
  public static final String EXTRA_PIN_DIALOG_DATA = "pin_dialog_data";
  public static final String EXTRA_PIN_DIALOG_MODE = "pin_dialog_mode";
  private static final Logger L = ViberEnv.getLogger();
  private com.viber.voip.ui.c.c mActivityDecorator;
  private final com.viber.voip.e.a.a mBenchmarkAndroidLifecycleDelegate = new h();
  private final ArraySet<a> mFragmentBridges = new ArraySet();
  private boolean mInAppCampaignSupported;

  @Deprecated
  protected boolean mIsTablet;
  protected boolean mMainProcess;
  private Bundle mPinDialogData;
  private com.viber.voip.banner.e mRemoteBannerDisplayController;

  private boolean notifyBackPressed()
  {
    Iterator localIterator = this.mFragmentBridges.iterator();
    boolean bool1 = false;
    if (localIterator.hasNext())
      if (!((a)localIterator.next()).onBackPressed())
        break label45;
    label45: for (boolean bool2 = true; ; bool2 = bool1)
    {
      bool1 = bool2;
      break;
      return bool1;
    }
  }

  private void notifyContextMenuClosed(Menu paramMenu)
  {
    Iterator localIterator = this.mFragmentBridges.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).onContextMenuClosed(paramMenu);
  }

  public static void updateFragmentArgumentsFromIntent(Intent paramIntent, Fragment paramFragment)
  {
    if (paramIntent == null)
      return;
    Bundle localBundle = paramFragment.getArguments();
    if (localBundle == null)
      localBundle = new Bundle();
    Uri localUri = paramIntent.getData();
    if (localUri != null)
      localBundle.putParcelable("_uri", localUri);
    if (paramIntent.getExtras() != null)
      localBundle.putAll(paramIntent.getExtras());
    paramFragment.setArguments(localBundle);
  }

  protected com.viber.voip.ui.c.c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.g(this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  public AppCompatActivity getActivity()
  {
    return this;
  }

  public int getDefaultTheme()
  {
    return dj.c(this);
  }

  public boolean isInAppCampaignSupported()
  {
    return this.mInAppCampaignSupported;
  }

  public boolean isSwitchingThemeSupported()
  {
    return com.viber.voip.ui.c.b.a(this);
  }

  public void onBackPressed()
  {
    try
    {
      if (!notifyBackPressed())
        super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public void onContextMenuClosed(Menu paramMenu)
  {
    super.onContextMenuClosed(paramMenu);
    notifyContextMenuClosed(paramMenu);
  }

  protected void onCreate(Bundle paramBundle)
  {
    BT.a("APP START", "ViberFragmentActivity onCreate");
    this.mBenchmarkAndroidLifecycleDelegate.a();
    this.mIsTablet = ViberApplication.isTablet(this);
    this.mActivityDecorator = createActivityDecorator();
    this.mActivityDecorator.b(getIntent());
    super.onCreate(paramBundle);
    if ((!isSwitchingThemeSupported()) || (dc.b()));
    for (boolean bool = true; ; bool = false)
    {
      dj.c(this, bool);
      dc.a(this);
      this.mMainProcess = com.viber.voip.o.a.b();
      if (this.mMainProcess)
      {
        this.mRemoteBannerDisplayController = com.viber.voip.banner.f.a(this, new com.viber.voip.g.b.b()
        {
          protected com.viber.voip.analytics.story.g.a a()
          {
            return com.viber.voip.analytics.g.a().c().c();
          }
        }
        , this.mIsTablet);
        this.mRemoteBannerDisplayController.m();
      }
      if (paramBundle != null)
        this.mPinDialogData = paramBundle.getBundle("extra_pin_dialog_bundle");
      BT.b("APP START", "ViberFragmentActivity onCreate");
      return;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mMainProcess)
      this.mRemoteBannerDisplayController.n();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.mActivityDecorator.a(paramIntent, null);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.mActivityDecorator.a(getIntent(), paramBundle);
    this.mBenchmarkAndroidLifecycleDelegate.b();
  }

  protected void onPostResume()
  {
    super.onPostResume();
    this.mBenchmarkAndroidLifecycleDelegate.e();
  }

  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    com.viber.common.permission.c.a(this).a(this, paramInt, paramArrayOfString, paramArrayOfInt);
  }

  protected void onResume()
  {
    this.mBenchmarkAndroidLifecycleDelegate.d();
    this.mActivityDecorator.a();
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      super.onSaveInstanceState(paramBundle);
      label5: if (this.mPinDialogData != null)
        paramBundle.putBundle("extra_pin_dialog_bundle", this.mPinDialogData);
      this.mActivityDecorator.a(paramBundle);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label5;
    }
  }

  protected void onStart()
  {
    super.onStart();
    if (this.mMainProcess)
      this.mRemoteBannerDisplayController.c();
    this.mBenchmarkAndroidLifecycleDelegate.c();
  }

  protected void onStop()
  {
    try
    {
      super.onStop();
      label4: if (this.mMainProcess)
        this.mRemoteBannerDisplayController.d();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label4;
    }
  }

  public void registerFragmentBridge(a parama)
  {
    this.mFragmentBridges.add(parama);
  }

  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
  }

  public void setInAppCampaignSupported(boolean paramBoolean)
  {
    this.mInAppCampaignSupported = paramBoolean;
  }

  public void setPinDialogData(Bundle paramBundle)
  {
    this.mPinDialogData = paramBundle;
  }

  public void setupAndShowPinDialog(Fragment paramFragment)
  {
    if (this.mPinDialogData == null)
      return;
    o.a locala = o.a.a(this.mPinDialogData.getInt("pin_dialog_mode", -1));
    Bundle localBundle = this.mPinDialogData.getBundle("pin_dialog_data");
    if ((locala != null) && (localBundle != null))
      ViberActionRunner.aa.a(paramFragment, paramFragment.getChildFragmentManager(), locala, localBundle);
    this.mPinDialogData = null;
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new g(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new e(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    com.viber.common.app.a.a(new f(this, paramIntent, paramInt), new Intent[] { paramIntent });
  }

  @SuppressLint({"RestrictedApi"})
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    try
    {
      super.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void unregisterFragmentBridge(a parama)
  {
    this.mFragmentBridges.remove(parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.app.ViberFragmentActivity
 * JD-Core Version:    0.6.2
 */