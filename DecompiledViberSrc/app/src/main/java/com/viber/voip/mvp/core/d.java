package com.viber.voip.mvp.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.viber.common.dialogs.i.a;
import com.viber.common.dialogs.m;
import com.viber.voip.banner.d.c;

public abstract class d<PRESENTER extends BaseMvpPresenter>
  implements h
{
  protected final PRESENTER mPresenter;
  protected View mRootView;

  protected d(PRESENTER paramPRESENTER, View paramView)
  {
    this.mRootView = paramView;
    this.mPresenter = paramPRESENTER;
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return b.a(this, paramInt1, paramInt2, paramIntent);
  }

  public boolean onBackPressed()
  {
    return b.a(this);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    b.a(this, paramConfiguration);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return b.a(this, paramMenuItem);
  }

  public boolean onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    return b.a(this, paramContextMenu, paramView, paramContextMenuInfo);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    return b.a(this, paramMenu, paramMenuInflater);
  }

  public void onDestroy()
  {
    k.e(this);
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    return b.a(this, paramm, paramInt);
  }

  public void onDialogDataListAction(m paramm, int paramInt, Object paramObject)
  {
    b.a(this, paramm, paramInt, paramObject);
  }

  public void onDialogDataListBind(m paramm, i.a parama)
  {
    b.a(this, paramm, parama);
  }

  public void onDialogShow(m paramm)
  {
    b.a(this, paramm);
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    b.a(this, paramBoolean);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return b.b(this, paramMenuItem);
  }

  public void onPause()
  {
    k.c(this);
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    b.a(this, paramm, paramView, paramInt);
  }

  public void onRemoteBannerVisibilityChange(boolean paramBoolean, c paramc, com.viber.voip.banner.view.b paramb)
  {
    b.a(this, paramBoolean, paramc, paramb);
  }

  public void onResume()
  {
    k.b(this);
  }

  public void onStart()
  {
    k.a(this);
  }

  public void onStop()
  {
    k.d(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.d
 * JD-Core Version:    0.6.2
 */