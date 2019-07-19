package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.block.n;
import com.viber.voip.phone.conf.ConferenceParticipantsSelectFragment;
import com.viber.voip.ui.c.d;
import com.viber.voip.ui.c.k;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import javax.inject.Inject;

public class ContactsComposeListActivity extends ViberSingleFragmentActivity
  implements s.a, dagger.android.support.b
{
  private a a = a.a;

  @Inject
  dagger.android.c<Fragment> b;

  @Inject
  dagger.a<av> c;

  private void a()
  {
    if (ViberApplication.isTablet(this))
      dj.a(this, 0.65F, 0.75F, 0.65F, 0.75F, true);
  }

  public void a(Intent paramIntent)
  {
    if ((getIntent() != null) && (getIntent().getBooleanExtra("extra_forward_compose", true)))
      paramIntent.putExtras(getIntent().getExtras());
    setResult(-1, getIntent());
    finish();
    startActivity(paramIntent);
  }

  public void b(Intent paramIntent)
  {
    startActivityForResult(paramIntent, 1021);
  }

  protected com.viber.voip.ui.c.c createActivityDecorator()
  {
    return new d(new k(), this, (av)this.c.get());
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (1021 == paramInt1)
      switch (paramInt2)
      {
      default:
      case -1:
      }
    while (100 != paramInt1)
    {
      return;
      setResult(-1);
      finish();
      startActivity(paramIntent);
      return;
    }
    switch (paramInt2)
    {
    default:
      return;
    case -1:
    }
    finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (ViberApplication.isTablet(this))
      dj.b(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    a();
    if ((getIntent().getBooleanExtra("is_public_group_compose", false)) || ("com.viber.voip.action.PUBLIC_GROUP_ADD_PARTICIPANTS".equals(getIntent().getAction())))
      this.a = a.b;
    while (true)
    {
      super.onCreate(paramBundle);
      findViewById(R.id.root_container).setBackgroundColor(dc.d(this, R.attr.mainBackgroundColor));
      getSupportActionBar().a(false);
      getSupportActionBar().b(true);
      String str = getIntent().getStringExtra("title");
      if (str == null)
        break;
      getSupportActionBar().a(str);
      return;
      if ("com.viber.voip.action.BLOCK_NUMBERS_SELECT".equals(getIntent().getAction()))
        this.a = a.c;
      else if ("com.viber.voip.action.FREE_CREDIT_FRIENDS_SELECT".equals(getIntent().getAction()))
        this.a = a.d;
      else if (("com.viber.voip.action.CREATE_CONFERENCE_WITH_1ON1_PARTICIPANTS".equals(getIntent().getAction())) || ("com.viber.voip.action.ADD_PARTICIPANTS_TO_CONFERENCE".equals(getIntent().getAction())))
        this.a = a.e;
    }
    getSupportActionBar().b(R.string.select_contacts);
  }

  protected Fragment onCreatePane()
  {
    switch (1.a[this.a.ordinal()])
    {
    default:
      Bundle localBundle = new Bundle();
      localBundle.putString("extra_create_chat_origin", "Chat Menu");
      s locals = new s();
      locals.setArguments(localBundle);
      return locals;
    case 1:
      return ay.a("com.viber.voip.action.PUBLIC_GROUP_ADD_PARTICIPANTS".equals(getIntent().getAction()));
    case 2:
      return new n();
    case 3:
      return new com.viber.voip.viberout.ui.c();
    case 4:
    }
    return new ConferenceParticipantsSelectFragment();
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
    return this.b;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ContactsComposeListActivity
 * JD-Core Version:    0.6.2
 */