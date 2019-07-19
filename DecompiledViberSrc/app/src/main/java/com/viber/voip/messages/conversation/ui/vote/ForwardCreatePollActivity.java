package com.viber.voip.messages.conversation.ui.vote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.contacts.ui.an;
import com.viber.voip.messages.ui.bk.a;
import com.viber.voip.util.dj;
import dagger.android.c;
import javax.inject.Inject;

public class ForwardCreatePollActivity extends ViberSingleFragmentActivity
  implements bk.a, dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a_(Intent paramIntent)
  {
    if (!paramIntent.getBooleanExtra("clicked", false))
      return;
    paramIntent.putExtra("create_poll", true);
    startActivity(paramIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    if (ViberApplication.isTablet(this))
      dj.b(this);
    super.onCreate(paramBundle);
    getSupportActionBar().b(true);
    getSupportActionBar().a(false);
    getSupportActionBar().b(R.string.vote_create_poll);
  }

  protected Fragment onCreatePane()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("show_secret_chats_extra", false);
    localBundle.putBoolean("enable_communities_extra", true);
    localBundle.putBoolean("show_writable_conversations_only", true);
    localBundle.putIntArray("group_roles", new int[] { 2, 1 });
    an localan = new an();
    localan.setArguments(localBundle);
    return localan;
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
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.vote.ForwardCreatePollActivity
 * JD-Core Version:    0.6.2
 */