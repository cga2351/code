package com.viber.voip.registration;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.analytics.story.o;
import com.viber.voip.settings.ui.SettingsActivity;

public class DeactivateActivity extends SettingsActivity
{
  private void a()
  {
    g.a().c().c().a("Cancel");
  }

  public void onBackPressed()
  {
    a();
    super.onBackPressed();
  }

  protected Fragment onCreatePane()
  {
    setActionBarTitle(R.string.pref_more_tab_deactivate_account_title);
    return new m();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 16908332:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.DeactivateActivity
 * JD-Core Version:    0.6.2
 */