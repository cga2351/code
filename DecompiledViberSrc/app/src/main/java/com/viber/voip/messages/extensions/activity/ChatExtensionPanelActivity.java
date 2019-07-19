package com.viber.voip.messages.extensions.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.messages.extensions.b.i;
import com.viber.voip.messages.extensions.b.i.a;
import com.viber.voip.util.dj;
import dagger.android.a;
import dagger.android.c;
import javax.inject.Inject;

public class ChatExtensionPanelActivity extends ViberSingleFragmentActivity
  implements i.a, dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  public void E()
  {
    finish();
  }

  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    a.a(this);
    super.onCreate(paramBundle);
    dj.f(this);
  }

  protected Fragment onCreatePane()
  {
    return new i();
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
 * Qualified Name:     com.viber.voip.messages.extensions.activity.ChatExtensionPanelActivity
 * JD-Core Version:    0.6.2
 */