package com.viber.voip.gdpr.ui.birthdate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.a;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.util.dj;

public class UserBirthdateActivity extends ViberSingleFragmentActivity
{
  private boolean a;

  public void onBackPressed()
  {
    if (this.a)
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mIsTablet)
      dj.a(this, false, false);
    a locala = getSupportActionBar();
    if (locala != null)
    {
      this.a = getIntent().getBooleanExtra("UserBirthdateActivity.AllowBackNavigation", false);
      locala.e(this.a);
      locala.b(this.a);
    }
    setDefaultTitle(R.string.birthday_screen_header);
  }

  protected Fragment onCreatePane()
  {
    return new b();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    if (NavUtils.getParentActivityIntent(this) != null)
      NavUtils.navigateUpFromSameTask(this);
    while (true)
    {
      return true;
      finish();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.birthdate.UserBirthdateActivity
 * JD-Core Version:    0.6.2
 */