package com.viber.voip.mvp.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import com.viber.common.dialogs.i.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.d;
import com.viber.common.dialogs.m.e;
import com.viber.common.dialogs.m.h;
import com.viber.common.dialogs.m.j;
import com.viber.voip.app.ViberFragmentActivity;

public abstract class BaseMvpActivity<VIEW extends d, COMPOSITE_VIEW extends e<VIEW>> extends ViberFragmentActivity
  implements m.c, m.d, m.e, m.h, m.j
{
  private final i<VIEW, COMPOSITE_VIEW> a = new i(d(), getLifecycle());

  protected abstract void a(Bundle paramBundle);

  public final void a(VIEW paramVIEW, BaseMvpPresenter paramBaseMvpPresenter, Bundle paramBundle)
  {
    this.a.a(paramVIEW, paramBaseMvpPresenter, paramBundle);
  }

  protected abstract void b(Bundle paramBundle);

  protected abstract COMPOSITE_VIEW d();

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.a(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if (!this.a.a())
      super.onBackPressed();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.a(paramConfiguration);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    super.onContextItemSelected(paramMenuItem);
    return this.a.a(paramMenuItem);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    this.a.a(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    this.a.a(paramm, paramInt);
  }

  public void onDialogDataListAction(m paramm, int paramInt, Object paramObject)
  {
    this.a.a(paramm, paramInt, paramObject);
  }

  public void onDialogDataListBind(m paramm, i.a parama)
  {
    this.a.a(paramm, parama);
  }

  public void onDialogShow(m paramm)
  {
    this.a.a(paramm);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    a(paramBundle);
    b(paramBundle);
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    this.a.a(paramm, paramView, paramInt);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.a.a(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.BaseMvpActivity
 * JD-Core Version:    0.6.2
 */