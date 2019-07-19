package com.viber.voip.publicaccount.ui.screen.info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import dagger.android.c;
import javax.inject.Inject;

public class PublicAccountEditActivity extends ViberFragmentActivity
  implements a.a, dagger.android.support.b
{
  private static final Logger b = ViberEnv.getLogger();

  @Inject
  c<Fragment> a;

  private void a(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("thread_id", -1L);
    if (l >= 0L)
    {
      PublicAccountEditFragment localPublicAccountEditFragment = a();
      if (localPublicAccountEditFragment != null)
      {
        localPublicAccountEditFragment.c(l);
        return;
      }
      finish();
      return;
    }
    finish();
  }

  private void b()
  {
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    getSupportActionBar().b(true);
    getSupportActionBar().b(R.string.public_account_edit_title);
  }

  protected final PublicAccountEditFragment a()
  {
    return (PublicAccountEditFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_edit_public_account);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
  }

  public void i()
  {
    onSupportNavigateUp();
  }

  public boolean j()
  {
    return true;
  }

  public void onBackPressed()
  {
    PublicAccountEditFragment localPublicAccountEditFragment = a();
    if ((localPublicAccountEditFragment == null) || (!localPublicAccountEditFragment.onBackPressed()))
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_public_account_edit);
    b();
  }

  protected void onPostResume()
  {
    super.onPostResume();
    a(getIntent());
  }

  public boolean onSupportNavigateUp()
  {
    if (!super.onSupportNavigateUp())
      onBackPressed();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.info.PublicAccountEditActivity
 * JD-Core Version:    0.6.2
 */