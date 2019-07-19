package com.viber.voip.messages.conversation.chatinfo.presentation;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.MenuItem;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.l;
import com.viber.voip.messages.conversation.l.a;
import com.viber.voip.messages.conversation.publicaccount.n;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.links.e;
import javax.inject.Inject;

public class ChatInfoActivity extends ViberSingleFragmentActivity
  implements d.a, l.a, dagger.android.support.b
{
  private static final Logger e = ViberEnv.getLogger();

  @Inject
  protected dagger.android.c<Fragment> a;

  @Inject
  protected com.viber.voip.app.b b;

  @Inject
  protected dagger.a<com.viber.voip.messages.k> c;

  @Inject
  dagger.a<av> d;
  private int f;
  private l g;

  private boolean a()
  {
    return (this.f != 0) && (this.f != 1) && (this.f != 4);
  }

  private void b()
  {
    dj.a(this, 0.65F, 0.75F, 0.65F, 0.75F, true);
  }

  public void c_(long paramLong)
  {
    if ((this.g != null) && (this.g.r() == paramLong))
      finish();
  }

  protected com.viber.voip.ui.c.c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.d(new com.viber.voip.ui.c.k(), this, (av)this.d.get());
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.b.a(this))
      b();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    long l = getIntent().getLongExtra("conversation_id", -1L);
    this.f = getIntent().getIntExtra("conversation_type", -1);
    if (this.b.a(this))
      b();
    super.onCreate(paramBundle);
    LoaderManager localLoaderManager = getSupportLoaderManager();
    if (a());
    for (this.g = new n(this, localLoaderManager, this.c, this, this); ; this.g = new l(this, localLoaderManager, this.c, this, this))
    {
      this.g.a(l);
      this.g.i();
      this.g.p();
      android.support.v7.app.a locala = getSupportActionBar();
      if (locala != null)
        locala.b(true);
      return;
    }
  }

  protected Fragment onCreatePane()
  {
    int i = this.f;
    Object localObject = null;
    switch (i)
    {
    case 2:
    case 3:
    default:
    case 0:
    case 1:
    case 4:
    case 5:
    }
    while (true)
    {
      ((b)localObject).setHasOptionsMenu(true);
      return localObject;
      localObject = new o();
      continue;
      localObject = new ChatInfoGroupFragment();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.g.q();
    this.g.j();
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.g.e(0);
    if (localConversationItemLoaderEntity != null)
    {
      ((b)getFragment()).a(localConversationItemLoaderEntity, paramBoolean);
      TextView localTextView = dj.f(findViewById(android.support.design.R.id.action_bar));
      if (localTextView != null)
      {
        localTextView.setText(dg.b(localConversationItemLoaderEntity));
        dj.a(localTextView, localConversationItemLoaderEntity);
      }
      if ((localConversationItemLoaderEntity.isConversation1on1()) && (localConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (getSupportActionBar() != null))
        getSupportActionBar().c(R.string.public_account_subtitle);
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 16908332)
    {
      onBackPressed();
      return true;
    }
    if (i == com.viber.voip.R.id.menu_edit_pg)
    {
      this.mFragment.onOptionsItemSelected(paramMenuItem);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    e.a().a(paramBoolean, hashCode());
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.ChatInfoActivity
 * JD-Core Version:    0.6.2
 */