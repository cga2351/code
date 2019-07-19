package com.viber.voip.messages.conversation.commongroups;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.util.dj;
import javax.inject.Inject;

public class CommonGroupsActivity extends ViberSingleFragmentActivity
  implements dagger.android.support.b
{

  @Inject
  dagger.android.c<Fragment> a;

  @Inject
  com.viber.voip.app.b b;

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.b(true);
    if (this.b.a(this))
      dj.b(this);
  }

  protected Fragment onCreatePane()
  {
    return new c();
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

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.commongroups.CommonGroupsActivity
 * JD-Core Version:    0.6.2
 */