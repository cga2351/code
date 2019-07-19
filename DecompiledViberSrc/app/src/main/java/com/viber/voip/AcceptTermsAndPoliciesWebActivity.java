package com.viber.voip;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.viber.dexshared.Logger;
import com.viber.voip.notif.h;
import com.viber.voip.ui.GenericWebViewActivity;

public class AcceptTermsAndPoliciesWebActivity extends GenericWebViewActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private h b;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ViberApplication.getInstance().getUpdateViberManager();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_terms_and_policies, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_accept_and_close)
    {
      this.b.a(true, true);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onResume()
  {
    super.onResume();
    if (!this.b.d())
      finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.AcceptTermsAndPoliciesWebActivity
 * JD-Core Version:    0.6.2
 */