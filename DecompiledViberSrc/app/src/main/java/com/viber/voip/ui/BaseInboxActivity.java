package com.viber.voip.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.Window;
import com.viber.voip.R.attr;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.y;
import dagger.android.c;
import javax.inject.Inject;

public abstract class BaseInboxActivity extends ViberSingleFragmentActivity
  implements dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  private void a()
  {
    if (isTaskRoot())
    {
      Intent localIntent = getParentActivityIntent();
      if (localIntent != null)
        startActivity(localIntent);
    }
  }

  private Intent b()
  {
    Intent localIntent = new Intent(this, y.a());
    localIntent.setFlags(603979776);
    return localIntent;
  }

  public Intent getParentActivityIntent()
  {
    return b();
  }

  public Intent getSupportParentActivityIntent()
  {
    return b();
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    a();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    dj.c(this, false);
    if ((com.viber.common.d.a.h()) && (dc.a()))
      getWindow().setNavigationBarColor(getResources().getColor(dc.a(this, R.attr.primaryDarkColor)));
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.b(true);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    finish();
    a();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.BaseInboxActivity
 * JD-Core Version:    0.6.2
 */