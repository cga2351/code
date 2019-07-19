package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.d;
import com.viber.voip.ui.c.k;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.dj;

public class AdminSelectorActivity extends ViberSingleFragmentActivity
  implements s.a
{
  public void a(Intent paramIntent)
  {
  }

  public void b(Intent paramIntent)
  {
  }

  protected c createActivityDecorator()
  {
    return new d(new k(), this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (ViberApplication.isTablet(this))
      dj.b(this);
    super.onCreate(paramBundle);
    getSupportActionBar().a(false);
    getSupportActionBar().b(true);
    setDefaultTitle(R.string.select_admins);
  }

  protected Fragment onCreatePane()
  {
    return new a();
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.AdminSelectorActivity
 * JD-Core Version:    0.6.2
 */