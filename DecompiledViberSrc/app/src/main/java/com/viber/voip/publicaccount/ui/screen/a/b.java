package com.viber.voip.publicaccount.ui.screen.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.chatsolution.create.a;
import com.viber.voip.publicaccount.ui.holders.chatsolution.create.a.a;
import com.viber.voip.publicaccount.wizard.a.e;
import com.viber.voip.publicaccount.wizard.a.e.a;
import com.viber.voip.util.ViberActionRunner.aq;

public final class b extends e
  implements a.a
{
  private MenuItem f;
  private a g;

  public static b a(Bundle paramBundle)
  {
    b localb = new b();
    localb.setArguments(b(paramBundle));
    return localb;
  }

  private void b(boolean paramBoolean)
  {
    this.f.setVisible(paramBoolean);
  }

  private void j()
  {
    if ((e.a.a == this.e) && (this.c != null))
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPACreationStartAndLeaveProcess(this.d, System.currentTimeMillis(), 3, false, this.c.getName(), this.c.getCategoryId(), this.c.getSubCategoryId(), this.c.getTagLines(), this.c.getCountryCode(), this.c.getLocation(), this.c.getWebsite(), this.c.getEmail(), this.c.getGroupUri(), this.c.isAgeRestricted(), 0);
  }

  public void U_()
  {
    j();
    ViberActionRunner.aq.b(getContext(), this.c);
    this.a.e();
  }

  public void V_()
  {
    a();
  }

  protected void a()
  {
    if (this.g != null)
      this.g.b(this.c);
    d(g());
  }

  public void a(com.viber.voip.publicaccount.ui.holders.c paramc, boolean paramBoolean)
  {
  }

  public int b()
  {
    return R.string.create_public_account_chat_solution_title;
  }

  public Bundle c()
  {
    return g();
  }

  protected boolean d()
  {
    return false;
  }

  public boolean e()
  {
    if (e.a.a == this.e)
    {
      U_();
      return true;
    }
    return super.e();
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(R.menu.menu_create_pa_chat_solution, paramMenu);
    this.f = paramMenu.findItem(R.id.menu_skip_choose_chat_solution);
    if (e.a.a == this.e);
    for (boolean bool = true; ; bool = false)
    {
      b(bool);
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.create_public_account_chat_solution_layout, paramViewGroup, false);
    this.g = new a(this, this, av.a(av.e.a), av.a(av.e.f));
    this.g.a(localView);
    this.g.b();
    setHasOptionsMenu(true);
    return localView;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_skip_choose_chat_solution == paramMenuItem.getItemId())
    {
      U_();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.g != null)
      this.g.a(paramBundle);
  }

  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if ((paramBundle != null) && (this.g != null))
      this.g.b(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.a.b
 * JD-Core Version:    0.6.2
 */