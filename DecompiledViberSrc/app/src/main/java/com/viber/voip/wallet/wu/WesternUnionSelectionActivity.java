package com.viber.voip.wallet.wu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.contacts.ui.ContactsFragment.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.s.a;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.l;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.util.ViberActionRunner.br;
import com.viber.voip.util.ViberActionRunner.br.a;
import com.viber.voip.util.cj;
import com.viber.voip.wallet.a.b;
import com.viber.voip.wallet.a.c;

public class WesternUnionSelectionActivity extends ViberFragmentActivity
  implements ContactsFragment.a, s.a, l, com.viber.voip.wallet.a.a, a.a, c.a
{
  private boolean a;
  private com.viber.voip.wallet.a b;
  private m c;

  public void a()
  {
    getSupportFragmentManager().popBackStack();
  }

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a(int paramInt, a.c paramc, String paramString, a.b paramb)
  {
    if (this.c != null)
      this.c.dismiss();
    if (a.c.a != paramc)
    {
      f.d().a(this);
      return;
    }
    switch (1.a[paramb.ordinal()])
    {
    default:
      return;
    case 1:
      ViberActionRunner.br.a(this, paramString, ViberActionRunner.br.a.c);
      return;
    case 2:
      ViberActionRunner.br.a(this, paramString, ViberActionRunner.br.a.b);
      return;
    case 3:
      ViberActionRunner.br.a(this, paramString, ViberActionRunner.br.a.a);
      return;
    case 4:
    }
    ViberActionRunner.br.a(this, paramString, ViberActionRunner.br.a.e);
  }

  public void a(Intent paramIntent)
  {
  }

  public void a(boolean paramBoolean, Intent paramIntent)
  {
    ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)paramIntent.getParcelableExtra("selected_participant");
    if ((localParticipant != null) && (this.b.a(localParticipant.getNumber())))
    {
      this.c = ad.b().a(this);
      this.b.a(localParticipant.getNumber(), localParticipant.getDisplayName(), a.b.a, this);
    }
  }

  public void b()
  {
    if (!cj.b(this))
    {
      f.b().a(this);
      return;
    }
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new a()).addToBackStack(null).commit();
  }

  public void b(Intent paramIntent)
  {
  }

  public void c()
  {
    if (!cj.b(this))
    {
      f.b().a(this);
      return;
    }
    this.c = ad.b().a(this);
    this.b.b(this);
  }

  public void d()
  {
    if (!cj.b(this))
    {
      f.b().a(this);
      return;
    }
    this.c = ad.b().a(this);
    this.b.c(this);
  }

  public void e()
  {
    if (!cj.b(this))
    {
      f.b().a(this);
      return;
    }
    this.c = ad.b().a(this);
    this.b.a(this);
  }

  public k getPermissionConfigForFragment(Fragment paramFragment)
  {
    k localk = new k();
    localk.a(0, 90);
    return localk;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ViberApplication.getInstance().getWalletController();
    setContentView(R.layout.activity_wallet_wu_selection);
    if (getSupportFragmentManager().findFragmentById(R.id.fragment) == null)
    {
      c localc = new c();
      getSupportFragmentManager().beginTransaction().add(R.id.fragment, localc).commit();
    }
    this.a = getIntent().getBooleanExtra("extra_analytics_first_time", false);
    getSupportActionBar().b(true);
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.wallet.wu.WesternUnionSelectionActivity
 * JD-Core Version:    0.6.2
 */