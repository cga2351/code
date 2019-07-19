package com.viber.voip.backup.ui.a.c;

import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backup.p;
import com.viber.voip.messages.k;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.i.c;

public class g extends f<h>
{
  public static g a()
  {
    return new g();
  }

  protected com.viber.voip.backup.ui.a.a.d<h> a(h paramh, com.viber.voip.backup.ui.a.b.b paramb)
  {
    cj localcj = cj.a(getActivity());
    com.viber.voip.analytics.g localg = com.viber.voip.analytics.g.a();
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    af localaf = UserManager.from(getContext()).getRegistrationValues();
    com.viber.voip.backup.f.f localf = new com.viber.voip.backup.f.f(localaf.l(), localaf.g(), paramb.f(), com.viber.voip.backup.f.b());
    com.viber.voip.backup.g.b localb = new com.viber.voip.backup.g.b();
    com.viber.voip.backup.ui.a.b.e locale = new com.viber.voip.backup.ui.a.b.e(localApplication, localViberApplication, av.a(av.e.a), com.viber.voip.backup.g.a(), localViberApplication.getMessagesManager().k(), localb);
    com.viber.voip.backup.ui.a.b.d locald = new com.viber.voip.backup.ui.a.b.d(av.a(av.e.a), new c(), com.viber.voip.backup.g.a(), localf, com.viber.voip.backup.f.b());
    return new com.viber.voip.backup.ui.a.a.e(getContext(), paramh, ViberApplication.getInstance().getActivationController(), localaf, locald, locale, localcj, paramb, localg.c().b(), localg.c().c());
  }

  protected h c(View paramView)
  {
    FragmentActivity localFragmentActivity = getActivity();
    return new h(localFragmentActivity, this, paramView, getResources(), new p(localFragmentActivity));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_restore_backup, paramViewGroup, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.c.g
 * JD-Core Version:    0.6.2
 */