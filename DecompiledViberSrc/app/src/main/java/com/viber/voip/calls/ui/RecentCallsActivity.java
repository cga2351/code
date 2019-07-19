package com.viber.voip.calls.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;
import dagger.android.a;
import dagger.android.c;
import javax.inject.Inject;

public class RecentCallsActivity extends ViberSingleFragmentActivity
  implements RecentCallsFragment.a, dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void h(Intent paramIntent)
  {
    startActivity(paramIntent);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    a.a(this);
    super.onCreate(paramBundle);
    setDefaultTitle(R.string.bottom_tab_calls);
  }

  protected Fragment onCreatePane()
  {
    return new RecentCallsFragment();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    if (!isFinishing())
      finish();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.RecentCallsActivity
 * JD-Core Version:    0.6.2
 */