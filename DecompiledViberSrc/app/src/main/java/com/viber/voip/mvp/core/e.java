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
import com.viber.voip.banner.view.b;
import java.util.ArrayList;
import java.util.List;

public class e<VIEW extends d>
{
  protected final List<VIEW> a = new ArrayList();

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void a(Configuration paramConfiguration)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onConfigurationChanged(paramConfiguration);
  }

  public void a(m paramm)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onDialogShow(paramm);
  }

  public void a(m paramm, int paramInt)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onDialogAction(paramm, paramInt);
  }

  public void a(m paramm, int paramInt, Object paramObject)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onDialogDataListAction(paramm, paramInt, paramObject);
  }

  public void a(m paramm, View paramView, int paramInt)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onPrepareDialogView(paramm, paramView, paramInt);
  }

  public void a(m paramm, i.a parama)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onDialogDataListBind(paramm, parama);
  }

  void a(VIEW paramVIEW)
  {
    this.a.add(paramVIEW);
  }

  public void a(boolean paramBoolean, c paramc, b paramb)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onRemoteBannerVisibilityChange(paramBoolean, paramc, paramb);
  }

  public boolean a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int i = this.a.size();
    int j = 0;
    boolean bool = false;
    while (j < i)
    {
      bool |= ((d)this.a.get(j)).onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      j++;
    }
    return bool;
  }

  public boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i = this.a.size();
    int j = 0;
    boolean bool = false;
    while (j < i)
    {
      bool |= ((d)this.a.get(j)).onCreateOptionsMenu(paramMenu, paramMenuInflater);
      j++;
    }
    return bool;
  }

  public boolean a(MenuItem paramMenuItem)
  {
    int i = this.a.size();
    int j = 0;
    boolean bool1 = false;
    if (j < i)
      if (!((d)this.a.get(j)).onContextItemSelected(paramMenuItem))
        break label56;
    label56: for (boolean bool2 = true; ; bool2 = bool1)
    {
      j++;
      bool1 = bool2;
      break;
      return bool1;
    }
  }

  public void b(boolean paramBoolean)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((d)this.a.get(j)).onFragmentVisibilityChanged(paramBoolean);
  }

  public boolean b(MenuItem paramMenuItem)
  {
    int i = this.a.size();
    int j = 0;
    boolean bool1 = false;
    if (j < i)
      if (!((d)this.a.get(j)).onOptionsItemSelected(paramMenuItem))
        break label56;
    label56: for (boolean bool2 = true; ; bool2 = bool1)
    {
      j++;
      bool1 = bool2;
      break;
      return bool1;
    }
  }

  public boolean c()
  {
    int i = this.a.size();
    int j = 0;
    boolean bool1 = false;
    if (j < i)
      if (!((d)this.a.get(j)).onBackPressed())
        break label52;
    label52: for (boolean bool2 = true; ; bool2 = bool1)
    {
      j++;
      bool1 = bool2;
      break;
      return bool1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.mvp.core.e
 * JD-Core Version:    0.6.2
 */