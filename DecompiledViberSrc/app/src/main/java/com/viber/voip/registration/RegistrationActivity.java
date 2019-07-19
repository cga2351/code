package com.viber.voip.registration;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.backup.ui.a.c.g;
import com.viber.voip.settings.d.b;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.user.editinfo.EditInfoFragment;
import com.viber.voip.util.dj;
import com.viber.voip.widget.MessageBar;
import dagger.android.c;
import javax.inject.Inject;

public class RegistrationActivity extends ViberFragmentActivity
  implements ActivationController.a, dagger.android.support.b
{
  private static final Logger d = ViberEnv.getLogger();
  protected Fragment a;

  @Inject
  dagger.a<com.viber.voip.analytics.story.f.d> b;

  @Inject
  c<Fragment> c;
  private MessageBar e;
  private e f;
  private b g;
  private TextView h;
  private int i = -1;
  private View j;
  private View k;
  private FrameLayout l;
  private FrameLayout m;

  private int a(a parama)
  {
    boolean bool1 = true;
    if (getWindow().getAttributes().softInputMode != parama.c())
      getWindow().setSoftInputMode(parama.c());
    dj.b(this.k, parama.a());
    int n;
    boolean bool2;
    label75: FrameLayout localFrameLayout2;
    if ((parama.b()) && (this.m != null))
    {
      n = R.id.fragment_container_overlay;
      FrameLayout localFrameLayout1 = this.l;
      if (R.id.fragment_container != n)
        break label110;
      bool2 = bool1;
      dj.b(localFrameLayout1, bool2);
      localFrameLayout2 = this.m;
      if (R.id.fragment_container_overlay != n)
        break label116;
    }
    while (true)
    {
      dj.b(localFrameLayout2, bool1);
      return n;
      n = R.id.fragment_container;
      break;
      label110: bool2 = false;
      break label75;
      label116: bool1 = false;
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(paramInt1);
    if (localFragment != null)
      localFragment.onActivityResult(paramInt2, paramInt3, paramIntent);
  }

  private void a(Intent paramIntent)
  {
    if (paramIntent.hasExtra("registration_reminder_message"))
    {
      paramIntent.removeExtra("registration_reminder_message");
      d.b.e.d();
    }
  }

  private void a(Bundle paramBundle)
  {
    int n = a().getStep();
    if (n == this.i)
    {
      g();
      return;
    }
    switch (n)
    {
    case 2:
    case 3:
    case 6:
    case 8:
    case 10:
    case 12:
    case 13:
    case 14:
    case 16:
    case 17:
    default:
    case 18:
    case 0:
    case 1:
    case 9:
    case 5:
    case 11:
    case 7:
    case 15:
    case 19:
    case 20:
    case 4:
    }
    while (true)
    {
      finish();
      while (true)
      {
        this.i = n;
        com.viber.voip.rakuten.a.a().a(this);
        return;
        h();
        continue;
        b(getIntent());
        b();
        continue;
        b(paramBundle);
        continue;
        i();
        continue;
        k();
        continue;
        c();
        j();
        continue;
        b(true);
        continue;
        f();
      }
      a().resumeActivation();
    }
  }

  private void a(Fragment paramFragment, String paramString)
  {
    b(paramFragment, paramString, l());
  }

  private void b(Intent paramIntent)
  {
    d locald = new d();
    updateFragmentArgumentsFromIntent(paramIntent, locald);
    a(locald, null);
  }

  private void b(Bundle paramBundle)
  {
    al localal1 = new al();
    if ((this.a instanceof al))
    {
      al localal2 = (al)this.a;
      Bundle localBundle2 = new Bundle(2);
      localBundle2.putLong("delay_time", localal2.c());
      localBundle2.putString("secure_key_extra", localal2.d());
      localal1.setArguments(localBundle2);
    }
    while (true)
    {
      a(localal1, null);
      return;
      if (paramBundle != null)
      {
        Bundle localBundle1 = paramBundle.getBundle("extra_fragment_state");
        if ((localBundle1 != null) && (localal1.getClass().getName().equals(localBundle1.getString("extra_fragment_name"))))
          localBundle1.remove("extra_fragment_name");
        localal1.setArguments(localBundle1);
      }
    }
  }

  private void b(Fragment paramFragment, String paramString, a parama)
  {
    runOnUiThread(new z(this, paramFragment, paramString, parama));
  }

  private void b(boolean paramBoolean)
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (com.viber.common.dialogs.z.c(localFragmentManager, DialogCode.D_PROGRESS) != null);
    for (boolean bool = true; paramBoolean == bool; bool = false)
      return;
    if (paramBoolean)
    {
      ad.b().b(false).a(this).a(localFragmentManager);
      return;
    }
    com.viber.common.dialogs.z.b(localFragmentManager, DialogCode.D_PROGRESS);
  }

  private int c(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int n = 32; ; n = 16)
      return n | 0x3;
  }

  private void c(Fragment paramFragment, String paramString, a parama)
  {
    int n = a(parama);
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.a != null)
      localFragmentTransaction.remove(this.a);
    localFragmentTransaction.replace(n, paramFragment, paramString);
    localFragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
    localFragmentTransaction.commitAllowingStateLoss();
    this.a = paramFragment;
  }

  private void f()
  {
    b(false);
    runOnUiThread(new y(this));
  }

  private void g()
  {
    if (this.i == 1)
    {
      ActivationController.ActivationCode localActivationCode = (ActivationController.ActivationCode)getIntent().getParcelableExtra("activation_code");
      if ((!ActivationController.ActivationCode.isEmpty(localActivationCode)) && ((this.a instanceof h)))
        ((h)this.a).c(localActivationCode);
    }
  }

  private void h()
  {
    a(new ab(), null);
  }

  private void i()
  {
    a(new t(), null);
  }

  private void j()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag("user_data_fragment");
    if (localFragment == null)
      b(EditInfoFragment.newInstance(1), "user_data_fragment", m());
    while (this.a != null)
      return;
    a(m());
    this.a = localFragment;
  }

  private void k()
  {
    a(new am(), null);
  }

  private a l()
  {
    return a.d().a(c(this.mIsTablet)).a();
  }

  private a m()
  {
    return a.d().b(true).a(false).a(35).a();
  }

  protected ActivationController a()
  {
    return ViberApplication.getInstance().getActivationController();
  }

  public void a(ActivationController.ActivationCode paramActivationCode)
  {
    c();
    if (this.a != null)
      ((j)this.a).a(paramActivationCode);
  }

  void a(boolean paramBoolean)
  {
    dj.b(this.j, paramBoolean);
  }

  protected void b()
  {
    if (this.f == null)
    {
      this.f = new e(this, com.viber.voip.h.a.b(), this);
      this.f.a();
    }
    if ((ActivationController.IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE) && (this.g == null))
    {
      this.g = new b(this, getApplicationContext(), true);
      this.g.a();
      this.g.a(a().isAutoDismissTzintukCall());
    }
  }

  protected void c()
  {
    if (this.f != null)
    {
      this.f.b();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.b();
      this.g = null;
    }
  }

  public MessageBar d()
  {
    return this.e;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ViberApplication.getInstance().getFacebookManager().a(this, paramInt1, paramInt2, paramIntent);
    ViberApplication.getInstance().getVKManager().a(paramInt1, paramInt2, paramIntent);
    a(R.id.fragment_container, paramInt1, paramInt2, paramIntent);
    a(R.id.fragment_container_overlay, paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if (!(this.a instanceof EditInfoFragment))
      super.onBackPressed();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    ImageView localImageView = (ImageView)findViewById(R.id.bg_image);
    if (localImageView != null)
      localImageView.setImageDrawable(getResources().getDrawable(R.drawable.welcome_tablet_bg));
    if ((this.a instanceof EditInfoFragment))
      j();
    do
    {
      return;
      if ((this.a instanceof am))
      {
        k();
        return;
      }
      if ((this.a instanceof al))
      {
        b(null);
        return;
      }
    }
    while (!(this.a instanceof g));
    f();
  }

  public void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    getWindow().setSoftInputMode(c(ViberApplication.isTablet(this)));
    super.onCreate(paramBundle);
    setContentView(R.layout.registration_main);
    this.k = findViewById(R.id.layout_policy);
    this.l = ((FrameLayout)findViewById(R.id.fragment_container));
    this.m = ((FrameLayout)findViewById(R.id.fragment_container_overlay));
    this.j = findViewById(R.id.no_connectivity_banner);
    this.j.setClickable(true);
    this.h = ((TextView)findViewById(R.id.policy));
    this.h.setOnClickListener(new x(this));
    if (getIntent().hasExtra("registration_reminder_message"))
    {
      d.b.e.g();
      com.viber.voip.api.a.a().d();
    }
    a(paramBundle);
    a(getIntent());
    if (ViberApplication.isTablet(this))
      this.e = new MessageBar(this);
  }

  protected void onDestroy()
  {
    c();
    super.onDestroy();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (getIntent().hasExtra("registration_reminder_message"))
    {
      d.b.e.g();
      com.viber.voip.api.a.a().d();
    }
    a(null);
    a(paramIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    finish();
    return true;
  }

  public void onPause()
  {
    if (this.g != null)
      this.g.c();
    super.onPause();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.a != null)
    {
      Bundle localBundle = new Bundle();
      this.a.onSaveInstanceState(localBundle);
      localBundle.putString("extra_fragment_name", this.a.getClass().getName());
      paramBundle.putBundle("extra_fragment_state", localBundle);
    }
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.c;
  }

  private static class a
  {
    private boolean a;
    private boolean b;
    private int c;

    public static a d()
    {
      return new a(null);
    }

    public boolean a()
    {
      return this.a;
    }

    public boolean b()
    {
      return this.b;
    }

    public int c()
    {
      return this.c;
    }

    public a e()
    {
      return new a(this);
    }

    public static final class a
    {
      private RegistrationActivity.a a = new RegistrationActivity.a(null);

      private a()
      {
        a(true);
        b(false);
        a(0);
      }

      public a(RegistrationActivity.a parama)
      {
        a(RegistrationActivity.a.a(parama));
        b(RegistrationActivity.a.b(parama));
        a(RegistrationActivity.a.c(parama));
      }

      public a a(int paramInt)
      {
        RegistrationActivity.a.a(this.a, paramInt);
        return this;
      }

      public a a(boolean paramBoolean)
      {
        RegistrationActivity.a.a(this.a, paramBoolean);
        return this;
      }

      public RegistrationActivity.a a()
      {
        RegistrationActivity.a locala = this.a;
        this.a = new RegistrationActivity.a(null);
        return locala;
      }

      public a b(boolean paramBoolean)
      {
        RegistrationActivity.a.b(this.a, paramBoolean);
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.RegistrationActivity
 * JD-Core Version:    0.6.2
 */