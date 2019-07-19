package com.viber.voip.messages.conversation.ui.vote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.util.dj;
import dagger.android.a;
import dagger.android.c;
import javax.inject.Inject;

public class VoteActivity extends ViberSingleFragmentActivity
  implements d.a, dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  public void a()
  {
    finish();
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      setResult(-1);
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
    return d.a(getIntent().getBundleExtra("extra_send_message_options"));
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
 * Qualified Name:     com.viber.voip.messages.conversation.ui.vote.VoteActivity
 * JD-Core Version:    0.6.2
 */