package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.messages.ui.bj;
import com.viber.voip.messages.ui.bk.a;
import com.viber.voip.messages.ui.forward.e;
import com.viber.voip.messages.ui.forward.f;
import com.viber.voip.messages.ui.h;
import com.viber.voip.mvp.core.DefaultMvpActivity;
import com.viber.voip.settings.d.ad;
import com.viber.voip.util.dj;
import dagger.android.c;
import javax.inject.Inject;

public abstract class MultiTabsParticipantSelectorActivity extends DefaultMvpActivity<com.viber.voip.mvp.core.d>
  implements View.OnClickListener, s.a, bk.a, f, dagger.android.support.b
{
  protected static final Logger a = ViberEnv.getLogger();
  protected int b = 0;

  @Inject
  c<Fragment> c;
  private Fragment d;
  private Fragment e;
  private Fragment f;
  private String g;

  private void a(int paramInt, View paramView)
  {
    paramView.setOnClickListener(this);
    if (this.b == paramInt);
    for (boolean bool = true; ; bool = false)
    {
      paramView.setSelected(bool);
      return;
    }
  }

  private void a(boolean paramBoolean, Fragment paramFragment)
  {
    if ((paramFragment instanceof h))
      ((h)paramFragment).c(paramBoolean);
  }

  private void c(int paramInt)
  {
    boolean bool = d(paramInt);
    Fragment localFragment = a(this.b);
    if (localFragment != null)
    {
      ((e)localFragment).setSearchQuery(this.g);
      a(bool, localFragment);
      getSupportFragmentManager().beginTransaction().replace(R.id.content, localFragment, "forward_content").commit();
    }
  }

  private boolean d(int paramInt)
  {
    Fragment localFragment = e(paramInt);
    if ((localFragment != null) && ((localFragment instanceof h)))
    {
      h localh = (h)localFragment;
      if ((localh.w() != null) && (localh.w().k()))
        return true;
    }
    return false;
  }

  private Fragment e(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return this.d;
    case 0:
      return this.e;
    case 2:
    }
    return this.f;
  }

  private void e()
  {
    a(0, findViewById(R.id.recents));
    a(1, findViewById(R.id.contacts));
    if (b())
      a(2, findViewById(R.id.groups));
  }

  private void f()
  {
    c(this.b);
  }

  private void f(int paramInt)
  {
    if (this.b == paramInt)
      return;
    int i = this.b;
    this.b = paramInt;
    d.ad.h.a(paramInt);
    e();
    c(i);
  }

  private void g()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag("forward_content");
    switch (this.b)
    {
    default:
      return;
    case 1:
      this.d = localFragment;
      return;
    case 0:
      this.e = localFragment;
      return;
    case 2:
    }
    this.f = localFragment;
  }

  protected Fragment a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("open_for_forward", true);
    switch (paramInt)
    {
    default:
      finish();
      return null;
    case 0:
      if (this.e == null)
        if (b())
          break label239;
      for (boolean bool = true; ; bool = false)
      {
        localBundle.putBoolean("forward_formatted_message_extra", bool);
        localBundle.putBoolean("show_public_accounts_extra", getIntent().getBooleanExtra("show_public_accounts_extra", false));
        localBundle.putBoolean("show_secret_chats_extra", getIntent().getBooleanExtra("show_secret_chats_extra", true));
        localBundle.putBoolean("show_broadcast_list_extra", getIntent().getBooleanExtra("show_broadcast_list_extra", true));
        localBundle.putBoolean("show_broadcast_list_w_p_extra", getIntent().getBooleanExtra("show_broadcast_list_w_p_extra", false));
        localBundle.putBoolean("show_public_groups_extra", getIntent().getBooleanExtra("show_public_groups_extra", true));
        localBundle.putBoolean("enable_communities_extra", getIntent().getBooleanExtra("enable_communities_extra", true));
        localBundle.putBoolean("show_writable_conversations_only", true);
        localBundle.putBoolean("hide_sms_inbox_extra", true);
        localBundle.putBoolean("hide_anonymous_extra", getIntent().getBooleanExtra("hide_anonymous_extra", false));
        localBundle.putBoolean("show_middle_state_communities_extra", getIntent().getBooleanExtra("show_middle_state_communities_extra", false));
        this.e = new bj();
        this.e.setArguments(localBundle);
        return this.e;
      }
    case 1:
      label239: if (this.d == null)
      {
        this.d = c();
        this.d.setArguments(localBundle);
      }
      return this.d;
    case 2:
    }
    if (this.f == null)
    {
      localBundle.putBoolean("show_secret_chats_extra", getIntent().getBooleanExtra("show_secret_chats_extra", true));
      localBundle.putBoolean("show_public_groups_extra", getIntent().getBooleanExtra("show_public_groups_extra", true));
      localBundle.putBoolean("enable_communities_extra", getIntent().getBooleanExtra("enable_communities_extra", true));
      localBundle.putBoolean("show_writable_conversations_only", true);
      localBundle.putBoolean("show_middle_state_communities_extra", getIntent().getBooleanExtra("show_middle_state_communities_extra", false));
      this.f = new an();
      this.f.setArguments(localBundle);
    }
    return this.f;
  }

  public void a()
  {
    this.g = "";
  }

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a(Intent paramIntent)
  {
    c(paramIntent);
  }

  protected void a(Bundle paramBundle)
  {
  }

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      a();
  }

  public void a_(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("clicked", false))
      c(paramIntent);
  }

  protected void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt > 2));
    this.b = paramInt;
    d.ad.h.a(paramInt);
  }

  public void b(Intent paramIntent)
  {
  }

  protected void b(Bundle paramBundle)
  {
  }

  protected abstract boolean b();

  protected abstract Fragment c();

  protected abstract void c(Intent paramIntent);

  public void onBackPressed()
  {
    Fragment localFragment = a(this.b);
    if (((localFragment instanceof com.viber.voip.app.a)) && (localFragment.isAdded()) && (((com.viber.voip.app.a)localFragment).onBackPressed()))
      return;
    if (getIntent().hasExtra("back_intent"))
      startActivity((Intent)getIntent().getParcelableExtra("back_intent"));
    super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.contacts)
      f(1);
    do
    {
      return;
      if (i == R.id.recents)
      {
        f(0);
        return;
      }
    }
    while (i != R.id.groups);
    f(2);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (ViberApplication.isTablet(this))
      dj.b(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    if (ViberApplication.isTablet(this))
      dj.b(this);
    setContentView(R.layout.forward_activity);
    android.support.v7.app.a locala = getSupportActionBar();
    locala.a(true);
    locala.b(true);
    if (paramBundle != null)
    {
      this.b = paramBundle.getInt("current_mode");
      g();
    }
    while (true)
    {
      e();
      if (!b())
      {
        ViewGroup localViewGroup = (ViewGroup)findViewById(R.id.filter_container);
        localViewGroup.removeView(localViewGroup.findViewById(R.id.groups));
        localViewGroup.findViewById(R.id.contacts).setBackgroundResource(R.drawable.filter_right_btn);
      }
      return;
      this.b = d.ad.h.d();
      if ((!b()) && (2 == this.b))
        this.b = 0;
      f();
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    if (getIntent().hasExtra("back_intent"))
      startActivity((Intent)getIntent().getParcelableExtra("back_intent"));
    finish();
    return true;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("current_mode", this.b);
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.MultiTabsParticipantSelectorActivity
 * JD-Core Version:    0.6.2
 */