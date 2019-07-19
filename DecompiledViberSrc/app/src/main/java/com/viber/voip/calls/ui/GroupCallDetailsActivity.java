package com.viber.voip.calls.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.a;
import android.view.MenuItem;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class GroupCallDetailsActivity extends ViberSingleFragmentActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getSupportActionBar().b(true);
  }

  protected Fragment onCreatePane()
  {
    return new GroupCallDetailsFragment();
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

  protected void onStart()
  {
    super.onStart();
    ((GroupCallDetailsFragment)this.mFragment).a(getIntent().getExtras());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.GroupCallDetailsActivity
 * JD-Core Version:    0.6.2
 */