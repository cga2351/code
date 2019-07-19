package com.viber.voip.contacts.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.a;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class TrustedContactsActivity extends ViberSingleFragmentActivity
{
  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a locala = getSupportActionBar();
    locala.b(true);
    locala.a(false);
    setDefaultTitle(R.string.trusted_contacts);
  }

  protected Fragment onCreatePane()
  {
    return new bc();
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
 * Qualified Name:     com.viber.voip.contacts.ui.TrustedContactsActivity
 * JD-Core Version:    0.6.2
 */