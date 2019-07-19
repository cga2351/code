package com.viber.voip.mvp.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.viber.common.dialogs.i.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.d;
import com.viber.common.dialogs.m.e;
import com.viber.common.dialogs.m.j;
import com.viber.voip.banner.view.b;
import com.viber.voip.ui.aq;

public abstract class c<VIEW extends d, COMPOSITE_VIEW extends e<VIEW>> extends aq
  implements m.c, m.d, m.e, m.j
{
  private final i<VIEW, COMPOSITE_VIEW> mMvpProcessor = new i(createCompositeView(), getLifecycle());

  public final void addMvpView(VIEW paramVIEW, BaseMvpPresenter paramBaseMvpPresenter, Bundle paramBundle)
  {
    this.mMvpProcessor.a(paramVIEW, paramBaseMvpPresenter, paramBundle);
  }

  protected abstract COMPOSITE_VIEW createCompositeView();

  protected abstract void createViewPresenters(View paramView, Bundle paramBundle);

  protected final COMPOSITE_VIEW getCompositeView()
  {
    return this.mMvpProcessor.b();
  }

  protected abstract void initModelComponent(View paramView, Bundle paramBundle);

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    View localView = getView();
    initModelComponent(localView, paramBundle);
    createViewPresenters(localView, paramBundle);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mMvpProcessor.a(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public boolean onBackPressed()
  {
    return (this.mMvpProcessor.a()) || (super.onBackPressed());
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mMvpProcessor.a(paramConfiguration);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    super.onContextItemSelected(paramMenuItem);
    return this.mMvpProcessor.a(paramMenuItem);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    this.mMvpProcessor.a(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    this.mMvpProcessor.a(paramMenu, paramMenuInflater);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    this.mMvpProcessor.a(paramm, paramInt);
  }

  public void onDialogDataListAction(m paramm, int paramInt, Object paramObject)
  {
    this.mMvpProcessor.a(paramm, paramInt, paramObject);
  }

  public void onDialogDataListBind(m paramm, i.a parama)
  {
    this.mMvpProcessor.a(paramm, parama);
  }

  public void onDialogShow(m paramm)
  {
    this.mMvpProcessor.a(paramm);
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    this.mMvpProcessor.a(paramBoolean);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.mMvpProcessor.b(paramMenuItem);
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    this.mMvpProcessor.a(paramm, paramView, paramInt);
    super.onPrepareDialogView(paramm, paramView, paramInt);
  }

  public void onRemoteBannerVisibilityChange(boolean paramBoolean, com.viber.voip.banner.d.c paramc, b paramb)
  {
    super.onRemoteBannerVisibilityChange(paramBoolean, paramc, paramb);
    this.mMvpProcessor.a(paramBoolean, paramc, paramb);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mMvpProcessor.a(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.c
 * JD-Core Version:    0.6.2
 */