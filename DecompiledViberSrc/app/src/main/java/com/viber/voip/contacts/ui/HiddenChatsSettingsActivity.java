package com.viber.voip.contacts.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.a;
import android.support.v7.preference.PreferenceScreen;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.messages.controller.cd;
import com.viber.voip.messages.controller.cd.a;
import com.viber.voip.messages.k;
import com.viber.voip.ui.ba.a;

public class HiddenChatsSettingsActivity extends ViberSingleFragmentActivity
  implements ba.a
{
  public void a(PreferenceScreen paramPreferenceScreen)
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a locala = getSupportActionBar();
    locala.b(true);
    locala.a(false);
    setDefaultTitle(R.string.hidden_chats_title);
    ViberApplication.getInstance().getMessagesManager().g().a(new cd.a()
    {
      public void a(String paramAnonymousString)
      {
        ao localao = (ao)HiddenChatsSettingsActivity.this.getFragment();
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0));
        for (boolean bool = true; ; bool = false)
        {
          localao.a(bool);
          return;
        }
      }
    });
  }

  protected Fragment onCreatePane()
  {
    return new ao();
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.HiddenChatsSettingsActivity
 * JD-Core Version:    0.6.2
 */