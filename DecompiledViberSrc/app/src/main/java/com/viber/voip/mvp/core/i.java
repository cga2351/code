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
import com.viber.voip.banner.d.c;
import com.viber.voip.banner.view.b;

class i<VIEW extends d, COMPOSITE_VIEW extends e<VIEW>>
{
  private final f a = new f();
  private final COMPOSITE_VIEW b;
  private l c = new l();
  private final android.arch.lifecycle.e d;

  i(COMPOSITE_VIEW paramCOMPOSITE_VIEW, android.arch.lifecycle.e parame)
  {
    this.b = paramCOMPOSITE_VIEW;
    this.d = parame;
  }

  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.a(paramInt1, paramInt2, paramIntent);
  }

  void a(Configuration paramConfiguration)
  {
    this.b.a(paramConfiguration);
  }

  void a(Bundle paramBundle)
  {
    this.a.a(paramBundle, this.c);
  }

  void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.b.a(paramContextMenu, paramView, paramContextMenuInfo);
  }

  void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    this.b.a(paramMenu, paramMenuInflater);
  }

  void a(m paramm)
  {
    this.b.a(paramm);
  }

  void a(m paramm, int paramInt)
  {
    this.b.a(paramm, paramInt);
  }

  void a(m paramm, int paramInt, Object paramObject)
  {
    this.b.a(paramm, paramInt, paramObject);
  }

  void a(m paramm, View paramView, int paramInt)
  {
    this.b.a(paramm, paramView, paramInt);
  }

  void a(m paramm, i.a parama)
  {
    this.b.a(paramm, parama);
  }

  void a(VIEW paramVIEW, BaseMvpPresenter paramBaseMvpPresenter, Bundle paramBundle)
  {
    this.b.a(paramVIEW);
    this.a.a(paramBaseMvpPresenter);
    paramBaseMvpPresenter.attachView(paramVIEW, this.d, this.c.b(paramBaseMvpPresenter, paramBundle));
  }

  void a(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
  }

  void a(boolean paramBoolean, c paramc, b paramb)
  {
    this.b.a(paramBoolean, paramc, paramb);
  }

  boolean a()
  {
    return this.b.c();
  }

  boolean a(MenuItem paramMenuItem)
  {
    return this.b.a(paramMenuItem);
  }

  COMPOSITE_VIEW b()
  {
    return this.b;
  }

  boolean b(MenuItem paramMenuItem)
  {
    return this.b.b(paramMenuItem);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.i
 * JD-Core Version:    0.6.2
 */