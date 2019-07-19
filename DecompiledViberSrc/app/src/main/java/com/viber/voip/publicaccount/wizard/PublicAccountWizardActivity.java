package com.viber.voip.publicaccount.wizard;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.publicaccount.wizard.a.b;
import com.viber.voip.publicaccount.wizard.a.c;
import com.viber.voip.publicaccount.wizard.a.d;

public abstract class PublicAccountWizardActivity extends ViberFragmentActivity
  implements c, d
{
  private final int a = R.id.fragment_container;
  private FragmentManager b;
  private com.viber.voip.publicaccount.wizard.a.a c;

  private void c(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      b localb = (b)this.b.findFragmentByTag(paramBundle.getString("current_fragment_identifier"));
      this.c.a(paramBundle, localb);
    }
  }

  protected abstract com.viber.voip.publicaccount.wizard.a.a a();

  public void a(Bundle paramBundle)
  {
    if (this.c != null)
      this.c.a(paramBundle);
  }

  public void a(b paramb, boolean paramBoolean)
  {
    setTitle(paramb.b());
    FragmentTransaction localFragmentTransaction = this.b.beginTransaction();
    localFragmentTransaction.replace(this.a, paramb.h(), paramb.f());
    if (paramBoolean)
      localFragmentTransaction.addToBackStack(paramb.f());
    localFragmentTransaction.commit();
  }

  public void b(Bundle paramBundle)
  {
    if (this.c != null)
      this.c.b(paramBundle);
  }

  public boolean b()
  {
    return (this.c != null) && (this.c.b());
  }

  public boolean c()
  {
    return (this.c != null) && (this.c.c());
  }

  public void d()
  {
    finish();
  }

  public void e()
  {
    d();
  }

  public void onBackPressed()
  {
    if (!c())
      finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    com.viber.voip.n.a.a(ViberApplication.isTablet(this), this, 1);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_fragment_with_toolbar);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    getSupportActionBar().b(true);
    this.b = getSupportFragmentManager();
    if (this.c == null)
      this.c = a();
    c(paramBundle);
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    c(paramBundle);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.c.c(paramBundle);
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.wizard.PublicAccountWizardActivity
 * JD-Core Version:    0.6.2
 */