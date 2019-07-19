package com.viber.voip.news;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class ViberNewsWebActivity extends ViberSingleFragmentActivity
{
  public boolean isSwitchingThemeSupported()
  {
    return true;
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
 * Qualified Name:     com.viber.voip.news.ViberNewsWebActivity
 * JD-Core Version:    0.6.2
 */