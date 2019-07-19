package com.viber.voip.market;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.a;
import android.view.MenuItem;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class MarketSettingsActivity extends ViberSingleFragmentActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a locala = getSupportActionBar();
    locala.e(true);
    locala.a(false);
    locala.b(true);
  }

  protected Fragment onCreatePane()
  {
    return new h();
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
 * Qualified Name:     com.viber.voip.market.MarketSettingsActivity
 * JD-Core Version:    0.6.2
 */