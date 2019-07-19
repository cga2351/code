package com.viber.voip.settings.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backup.b.h;
import com.viber.voip.backup.p;
import com.viber.voip.registration.af;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.j;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;

public class b extends com.viber.voip.backup.ui.a.c.f<com.viber.voip.backup.ui.a.c.c>
{
  private static final Logger a = ViberEnv.getLogger();

  public static b a(boolean paramBoolean)
  {
    b localb = new b();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("show_restore", paramBoolean);
    localb.setArguments(localBundle);
    return localb;
  }

  private boolean a()
  {
    return getArguments().getBoolean("show_restore", true);
  }

  protected com.viber.voip.backup.ui.a.a.d<com.viber.voip.backup.ui.a.c.c> a(com.viber.voip.backup.ui.a.c.c paramc, com.viber.voip.backup.ui.a.b.b paramb)
  {
    cj localcj = cj.a(getActivity());
    com.viber.voip.backup.auto.b localb = new com.viber.voip.backup.auto.b(d.j.k);
    com.viber.voip.backup.auto.d locald = new com.viber.voip.backup.auto.d(d.j.j);
    com.viber.voip.backup.b localb1 = new com.viber.voip.backup.b(requireContext(), d.j.g, localb, locald, p.a.a);
    ViberApplication localViberApplication = ViberApplication.getInstance();
    com.viber.voip.analytics.g localg = com.viber.voip.analytics.g.a();
    af localaf = UserManager.from(getContext()).getRegistrationValues();
    com.viber.voip.backup.f.g localg1 = new com.viber.voip.backup.f.g(localaf.l(), localaf.g(), paramb.f(), com.viber.voip.backup.f.b(), new h());
    com.viber.voip.backup.f.f localf = new com.viber.voip.backup.f.f(localaf.l(), localaf.g(), paramb.f(), com.viber.voip.backup.f.b());
    com.viber.voip.backup.g.b localb2 = new com.viber.voip.backup.g.b();
    com.viber.voip.backup.ui.a.b.c localc = new com.viber.voip.backup.ui.a.b.c(getContext(), localViberApplication.getEngine(false), av.a(av.e.a), com.viber.voip.backup.g.a(), localg1, localb2, new com.viber.voip.backup.d.a.d().a(), localg, localg.c().c(), localViberApplication.getBackupBackgroundListener());
    com.viber.voip.backup.ui.a.b.d locald1 = new com.viber.voip.backup.ui.a.b.d(av.a(av.e.a), new com.viber.voip.util.i.c(), com.viber.voip.backup.g.a(), localf, com.viber.voip.backup.f.b());
    return new com.viber.voip.backup.ui.a.a.c(getContext(), paramc, localaf, localc, locald1, localcj, paramb, localb1, localg.c().c());
  }

  protected com.viber.voip.backup.ui.a.c.c c(View paramView)
  {
    FragmentActivity localFragmentActivity = getActivity();
    return new com.viber.voip.backup.ui.a.c.c(localFragmentActivity, this, paramView, getResources(), new p(localFragmentActivity), a());
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    MenuItem localMenuItem = paramMenu.add(0, R.id.menu_close, 0, R.string.dialog_button_close);
    localMenuItem.setIcon(R.drawable.close_internal_browser_icon);
    localMenuItem.setShowAsAction(2);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_backup, paramViewGroup, false);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_close == paramMenuItem.getItemId())
    {
      getActivity().onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!a());
    for (boolean bool = true; ; bool = false)
    {
      setHasOptionsMenu(bool);
      ((TextView)paramView.findViewById(R.id.backup_description)).setText(Html.fromHtml(getResources().getString(R.string.backup_description)));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.b
 * JD-Core Version:    0.6.2
 */