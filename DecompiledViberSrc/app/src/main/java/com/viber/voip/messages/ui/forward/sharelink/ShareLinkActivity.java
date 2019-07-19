package com.viber.voip.messages.ui.forward.sharelink;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.util.dj;
import dagger.android.c;
import javax.inject.Inject;

public class ShareLinkActivity extends ViberSingleFragmentActivity
  implements dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setActionBarTitle(R.string.join_community_link_msg_title);
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().a(false);
      getSupportActionBar().b(true);
    }
  }

  protected Fragment onCreatePane()
  {
    return new b();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    dj.d(this);
    finish();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.sharelink.ShareLinkActivity
 * JD-Core Version:    0.6.2
 */