package com.viber.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.view.d;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.h;
import com.viber.common.dialogs.m.i;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.o;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.banner.e.a;
import com.viber.voip.banner.e.b;
import com.viber.voip.banner.f;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cj;

public class aq extends Fragment
  implements ActivityCompat.OnRequestPermissionsResultCallback, m.h, m.i, com.viber.voip.app.a, com.viber.voip.b, e.a, e.b
{
  public static final com.viber.voip.e.a.c BT = com.viber.voip.e.a.e.b();
  private static final Logger L = ViberEnv.getLogger();
  private final com.viber.voip.e.a.g mBenchmarkAndroidLifecycleDelegate = new com.viber.voip.e.a.i();
  protected boolean mIsTablet;
  protected com.viber.voip.banner.e mRemoteBannerDisplayController;

  protected final void finish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.finish();
  }

  public boolean onActivitySearchRequested()
  {
    return false;
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.mIsTablet = ViberApplication.isTablet(paramContext);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof ViberFragmentActivity))
      ((ViberFragmentActivity)localFragmentActivity).registerFragmentBridge(this);
    this.mBenchmarkAndroidLifecycleDelegate.a();
  }

  public boolean onBackPressed()
  {
    return false;
  }

  public void onContextMenuClosed(Menu paramMenu)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRemoteBannerDisplayController = f.a(this, new com.viber.voip.g.b.b()
    {
      protected com.viber.voip.analytics.story.g.a a()
      {
        return com.viber.voip.analytics.g.a().c().c();
      }
    }
    , this.mIsTablet);
    this.mRemoteBannerDisplayController.a(this);
    this.mRemoteBannerDisplayController.a(this);
    this.mRemoteBannerDisplayController.m();
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.mRemoteBannerDisplayController.n();
    this.mRemoteBannerDisplayController = null;
  }

  public void onDetach()
  {
    super.onDetach();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof ViberFragmentActivity))
      ((ViberFragmentActivity)localFragmentActivity).unregisterFragmentBridge(this);
  }

  public void onDialogRestoreState(m paramm, Bundle paramBundle)
  {
  }

  public void onDialogSaveState(m paramm, Bundle paramBundle)
  {
    ViberDialogHandlers.cj.a(paramm, paramBundle);
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    if (this.mRemoteBannerDisplayController != null)
    {
      if (paramBoolean)
        this.mRemoteBannerDisplayController.c();
    }
    else
      return;
    this.mRemoteBannerDisplayController.d();
  }

  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    int i = com.viber.voip.ui.c.i.a(this);
    FragmentActivity localFragmentActivity = getActivity();
    if ((i != 0) && (localFragmentActivity != null))
      return super.onGetLayoutInflater(paramBundle).cloneInContext(new d(localFragmentActivity, i));
    return super.onGetLayoutInflater(paramBundle);
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    ViberDialogHandlers.cj.a(paramm, paramView);
  }

  public void onRemoteBannerAction(com.viber.voip.banner.view.b paramb)
  {
  }

  public void onRemoteBannerVisibilityChange(boolean paramBoolean, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.view.b paramb)
  {
  }

  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      com.viber.common.permission.c.a(localFragmentActivity).a(this, paramInt, paramArrayOfString, paramArrayOfInt);
  }

  public void onStart()
  {
    super.onStart();
    this.mRemoteBannerDisplayController.c();
  }

  public void onStop()
  {
    super.onStop();
    this.mRemoteBannerDisplayController.d();
  }

  public void onTabReselected()
  {
  }

  protected void runOnUiThread(Runnable paramRunnable)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.runOnUiThread(paramRunnable);
  }

  public boolean shouldDisplayBanner(com.viber.voip.banner.d.g paramg, com.viber.voip.banner.d.c paramc, com.viber.voip.banner.d.b paramb)
  {
    return true;
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new ar(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new as(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.aq
 * JD-Core Version:    0.6.2
 */