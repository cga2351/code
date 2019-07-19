package com.viber.voip.group.participants.ban;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.a;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class BannedParticipantsListActivity extends ViberSingleFragmentActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getSupportActionBar().b(true);
    setDefaultTitle(R.string.banned_users_title);
  }

  protected Fragment onCreatePane()
  {
    return new e();
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.ban.BannedParticipantsListActivity
 * JD-Core Version:    0.6.2
 */