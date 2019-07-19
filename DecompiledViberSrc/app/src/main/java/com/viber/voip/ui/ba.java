package com.viber.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.g;
import android.support.v7.preference.j;
import android.support.v7.view.d;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.h;
import com.viber.common.dialogs.m.i;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.b;
import com.viber.voip.settings.ui.an;
import com.viber.voip.ui.c.i;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cj;

public abstract class ba extends g
  implements ActivityCompat.OnRequestPermissionsResultCallback, m.h, m.i, com.viber.voip.app.a, b
{
  private static final Logger b = ViberEnv.getLogger();
  private a c;

  public final void a(Bundle paramBundle, String paramString)
  {
    j localj = a();
    localj.a("com.viber.voip.ViberPrefs");
    localj.a(0);
    localj.c();
    b(paramBundle, paramString);
  }

  protected abstract void b(Bundle paramBundle, String paramString);

  public void b(Preference paramPreference)
  {
    if ((paramPreference instanceof EditTextPreference))
    {
      an localan = an.b(paramPreference.C());
      localan.setTargetFragment(this, 0);
      localan.show(getFragmentManager(), "ViberPreferenceFragment.EDIT_TEXT_DIALOG");
      return;
    }
    super.b(paramPreference);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(null);
  }

  public boolean onActivitySearchRequested()
  {
    return false;
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof ViberFragmentActivity))
      ((ViberFragmentActivity)localFragmentActivity).registerFragmentBridge(this);
    if ((paramContext instanceof a))
    {
      this.c = ((a)paramContext);
      return;
    }
    throw new ClassCastException(paramContext.toString() + " must implement OnPreferenceAttachedListener");
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
    if (this.c != null)
      this.c.a(b());
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void onDetach()
  {
    super.onDetach();
    this.c = null;
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
  }

  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    int i = i.a(this);
    FragmentActivity localFragmentActivity = getActivity();
    if ((i != 0) && (localFragmentActivity != null))
      return super.onGetLayoutInflater(paramBundle).cloneInContext(new d(localFragmentActivity, i));
    return super.onGetLayoutInflater(paramBundle);
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    ViberDialogHandlers.cj.a(paramm, paramView);
  }

  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      c.a(localFragmentActivity).a(this, paramInt, paramArrayOfString, paramArrayOfInt);
  }

  public void onTabReselected()
  {
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new bb(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new bc(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }

  public static abstract interface a
  {
    public abstract void a(PreferenceScreen paramPreferenceScreen);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ba
 * JD-Core Version:    0.6.2
 */