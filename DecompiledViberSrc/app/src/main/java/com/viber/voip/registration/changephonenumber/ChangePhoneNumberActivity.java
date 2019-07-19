package com.viber.voip.registration.changephonenumber;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.ActivationController.ActivationCode;
import com.viber.voip.registration.ActivationController.a;
import com.viber.voip.registration.CountryCode;
import com.viber.voip.registration.af;
import com.viber.voip.registration.e;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.cg;
import com.viber.voip.util.dj;
import dagger.android.c;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ChangePhoneNumberActivity extends ViberFragmentActivity
  implements m.h, ActivationController.a, a.a, dagger.android.support.b
{
  private static final Logger d = ViberEnv.getLogger();

  @Inject
  c<Fragment> a;

  @Inject
  dagger.a<com.viber.voip.analytics.story.f.d> b;

  @Inject
  dagger.a<com.viber.voip.analytics.story.g.a> c;
  private a.b e;
  private Fragment f;
  private i g;
  private e h;
  private com.viber.voip.registration.b i;
  private View j;
  private h k;

  private void b(boolean paramBoolean)
  {
    if (this.h == null)
    {
      this.h = new e(this, com.viber.voip.h.a.b(), this);
      this.h.a();
    }
    if ((ActivationController.IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE) && (this.i == null))
    {
      this.i = new com.viber.voip.registration.b(this, getApplicationContext(), false);
      this.i.a();
      this.i.a(paramBoolean);
    }
  }

  private void g()
  {
    if (this.h != null)
    {
      this.h.b();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.b();
      this.i = null;
    }
  }

  private void h()
  {
    String str1 = getIntent().getStringExtra("entry_point");
    if (str1 == null);
    for (String str2 = "Change Phone Number"; ; str2 = str1)
    {
      ((com.viber.voip.analytics.story.g.a)this.c.get()).c(str2);
      return;
    }
  }

  public void a(final ActivationController.ActivationCode paramActivationCode)
  {
    g();
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        if ((ChangePhoneNumberActivity.a(ChangePhoneNumberActivity.this) instanceof j))
          ((j)ChangePhoneNumberActivity.a(ChangePhoneNumberActivity.this)).c(paramActivationCode);
      }
    });
  }

  public void a(CountryCode paramCountryCode, String paramString, boolean paramBoolean)
  {
    if (this.g.c())
    {
      this.k.a(this);
      this.g.a(paramCountryCode, paramString, paramBoolean);
    }
  }

  public void a(PhoneNumberInfo paramPhoneNumberInfo)
  {
    this.k.a(paramPhoneNumberInfo);
  }

  public void a(a.b paramb)
  {
    if (this.e != paramb)
      this.e = paramb;
    int m = R.string.change_phone_number;
    this.f = getSupportFragmentManager().findFragmentByTag(this.e.toString());
    switch (3.a[this.e.ordinal()])
    {
    default:
    case 1:
    case 2:
      while (true)
      {
        getSupportActionBar().b(m);
        getSupportFragmentManager().beginTransaction().replace(R.id.root_container, this.f, this.e.toString()).commit();
        return;
        if (this.f == null)
        {
          this.f = new f();
          continue;
          if (this.f == null)
            this.f = new ChangePhoneNumberEnterNewNumberFragment();
        }
      }
    case 3:
    case 4:
    }
    int n = R.string.change_phone_number_verify_title;
    if (this.f == null)
      if (this.e != a.b.c)
        break label196;
    label196: for (Object localObject = new j(); ; localObject = new b())
    {
      this.f = ((Fragment)localObject);
      m = n;
      break;
    }
  }

  public void a(a.b paramb, boolean paramBoolean)
  {
    PhoneNumberInfo localPhoneNumberInfo = this.g.b();
    if (localPhoneNumberInfo == null);
    CountryCode localCountryCode;
    String str;
    do
    {
      return;
      localCountryCode = localPhoneNumberInfo.countryCode;
      str = localPhoneNumberInfo.phoneNumber;
    }
    while ((localCountryCode == null) || (str == null));
    switch (3.a[paramb.ordinal()])
    {
    default:
      return;
    case 3:
      b(localCountryCode, str, paramBoolean);
      return;
    case 4:
    }
    a(localCountryCode, str, paramBoolean);
  }

  public void a(String paramString)
  {
    if (a())
    {
      this.k.a(this);
      this.g.b(paramString);
    }
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.j, paramBoolean);
  }

  public boolean a()
  {
    return this.g.d();
  }

  public void b(CountryCode paramCountryCode, String paramString, boolean paramBoolean)
  {
    if (this.g.c())
    {
      this.k.a(this);
      this.g.b(paramCountryCode, paramString, paramBoolean);
    }
  }

  public void b(String paramString)
  {
    if (b())
    {
      this.k.a(this);
      this.g.a(paramString);
    }
  }

  public boolean b()
  {
    return this.g.e();
  }

  public void c()
  {
    this.k.a(this);
  }

  public void d()
  {
    this.k.a();
  }

  public String e()
  {
    return this.g.b().canonizedPhoneNumber;
  }

  public String f()
  {
    PhoneNumberInfo localPhoneNumberInfo = this.g.b();
    return cg.a(this, localPhoneNumberInfo.getCountyIddCode(), localPhoneNumberInfo.phoneNumber, localPhoneNumberInfo.canonizedPhoneNumber);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onActivatedEvent(com.viber.voip.registration.changephonenumber.a.a parama)
  {
    com.viber.voip.registration.c.h localh = parama.b();
    if ((localh != null) && ((localh.f()) || ("109".equals(localh.g()))))
    {
      com.viber.voip.analytics.story.j localj1 = com.viber.voip.analytics.story.g.g(UserManager.from(getApplication()).getRegistrationValues().e());
      com.viber.voip.analytics.g.a().a(localj1);
      av.a(av.e.a).postDelayed(new Runnable()
      {
        public void run()
        {
          ChangePhoneNumberActivity.this.finish();
          Application localApplication = ViberApplication.getApplication();
          localApplication.startActivity(ViberActionRunner.ab.a(localApplication).addFlags(268435456));
        }
      }
      , 3000L);
    }
    j localj;
    if ((this.f instanceof j))
    {
      localj = (j)this.f;
      if (localh == null)
        localj.p();
    }
    else
    {
      return;
    }
    if (localh.f())
    {
      a(this.g.b());
      return;
    }
    localj.a(parama.a(), localh.h());
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onAuthorizedEvent(com.viber.voip.registration.changephonenumber.a.b paramb)
  {
    this.k.a();
    com.viber.voip.registration.c.i locali = paramb.b();
    if ((locali != null) && (locali.f()))
    {
      b(locali.e());
      if (paramb.c());
      for (a.b localb = a.b.d; ; localb = a.b.c)
      {
        a(localb);
        return;
      }
    }
    if (locali != null);
    for (String str = locali.g(); "104".equals(str); str = null)
    {
      com.viber.voip.ui.dialogs.a.a().a(this);
      return;
    }
    if ("121".equals(str))
    {
      com.viber.voip.ui.dialogs.a.b(paramb.a().getName()).a(this);
      return;
    }
    if ("122".equals(str))
    {
      com.viber.voip.ui.dialogs.a.a(paramb.a().getName()).a(this);
      return;
    }
    h.a locala = k.n();
    int m = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getString(R.string.dialog_339_reason_change_phone_number);
    locala.b(m, arrayOfObject).a(this);
  }

  public void onBackPressed()
  {
    if ((this.e == a.b.c) || (this.e == a.b.d))
    {
      g();
      a(a.b.b);
      return;
    }
    if (this.e == a.b.b)
    {
      dj.d(this);
      a(a.b.a);
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_change_phone_number);
    setActionBarTitle(R.string.change_phone_number);
    a(a.b.a);
    this.g = ViberApplication.getInstance().getChangePhoneNumberController().a();
    this.g.a().register(this);
    this.j = findViewById(R.id.no_connectivity_banner);
    this.j.setClickable(true);
    this.k = new h(this);
    h();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.k.a();
    g();
    this.g.a().unregister(this);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    ActivationController.ActivationCode localActivationCode = (ActivationController.ActivationCode)paramIntent.getParcelableExtra("activation_code");
    if ((!ActivationController.ActivationCode.isEmpty(localActivationCode)) && ((this.f instanceof com.viber.voip.registration.h)))
      ((com.viber.voip.registration.h)this.f).c(localActivationCode);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    onBackPressed();
    return true;
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    this.k.a(paramm, paramView);
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.ChangePhoneNumberActivity
 * JD-Core Version:    0.6.2
 */