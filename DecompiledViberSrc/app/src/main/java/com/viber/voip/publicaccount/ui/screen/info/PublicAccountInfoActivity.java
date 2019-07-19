package com.viber.voip.publicaccount.ui.screen.info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.ui.style.InternalURLSpan;
import com.viber.voip.ui.style.InternalURLSpan.a;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.dj;
import com.viber.voip.util.links.e;
import dagger.android.a;
import dagger.android.c;
import javax.inject.Inject;

public class PublicAccountInfoActivity extends ViberFragmentActivity
  implements a.a, dagger.android.support.b
{
  private static final Logger b = ViberEnv.getLogger();

  @Inject
  c<Fragment> a;
  private InternalURLSpan.a c;

  private PublicAccountInfoFragment a()
  {
    return (PublicAccountInfoFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_public_account_info);
  }

  private void a(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("thread_id", -1L);
    String str = paramIntent.getStringExtra("extra_public_account_uri");
    PublicAccount localPublicAccount = (PublicAccount)paramIntent.getParcelableExtra("extra_public_account");
    boolean bool = paramIntent.getBooleanExtra("publish_action", false);
    long l2 = paramIntent.getLongExtra("notif_extra_token", 0L);
    if (l1 > 0L)
    {
      a(l1, bool, l2);
      return;
    }
    d locald = new d(this, bool, l2);
    if (localPublicAccount != null)
    {
      ViberApplication.getInstance().getMessagesManager().c().a(3, localPublicAccount.getGroupID(), localPublicAccount, locald);
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      ViberApplication.getInstance().getMessagesManager().c().a(str, locald);
      return;
    }
    finish();
  }

  protected void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    PublicAccountInfoFragment localPublicAccountInfoFragment = a();
    if (localPublicAccountInfoFragment != null)
    {
      localPublicAccountInfoFragment.a(paramLong1, paramBoolean, paramLong2);
      localPublicAccountInfoFragment.k(true);
    }
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    startActivity(m.a(new PublicGroupConversationData(paramPublicGroupConversationItemLoaderEntity.getGroupId(), paramPublicGroupConversationItemLoaderEntity.getPublicAccountGroupUri()), false));
  }

  public void i()
  {
    if (!super.onSupportNavigateUp())
      onBackPressed();
  }

  public boolean j()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_public_account_info);
    dj.c(this, false);
    this.c = new InternalURLSpan.a()
    {
      public void a(String paramAnonymousString, aa paramAnonymousaa)
      {
        ViberActionRunner.be.a(PublicAccountInfoActivity.this, paramAnonymousString, true);
      }
    };
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    long l = paramIntent.getLongExtra("notif_extra_token", 0L);
    if (l > 0L)
    {
      PublicAccountInfoFragment localPublicAccountInfoFragment = a();
      if (localPublicAccountInfoFragment != null)
        localPublicAccountInfoFragment.d(l);
    }
    a(paramIntent);
  }

  protected void onPause()
  {
    super.onPause();
    InternalURLSpan.removeClickListener(this.c);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    a(getIntent());
  }

  protected void onResume()
  {
    super.onResume();
    e.a().a(true, hashCode());
    InternalURLSpan.addClickListener(this.c);
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.info.PublicAccountInfoActivity
 * JD-Core Version:    0.6.2
 */