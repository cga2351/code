package com.viber.voip.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.a;
import android.view.MenuItem;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

public abstract class ViberSingleFragmentActivity extends ViberFragmentActivity
{
  protected static final String FRAGMENT_TAG = "single_pane";
  protected Fragment mFragment;

  protected void changeFragment(Fragment paramFragment)
  {
    this.mFragment = paramFragment;
    updateFragmentArgumentsFromIntent(getIntent(), this.mFragment);
    getSupportFragmentManager().beginTransaction().replace(R.id.root_container, this.mFragment, "single_pane").commit();
  }

  public Fragment getFragment()
  {
    return this.mFragment;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout._ics_activity_singlepane_empty);
    a locala = getSupportActionBar();
    if (locala != null)
      locala.e(true);
    if (getIntent().hasExtra("android.intent.extra.TITLE"))
      setTitle(getIntent().getStringExtra("android.intent.extra.TITLE"));
    if (paramBundle == null)
    {
      changeFragment(onCreatePane());
      return;
    }
    this.mFragment = getSupportFragmentManager().findFragmentByTag("single_pane");
  }

  protected abstract Fragment onCreatePane();

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    NavUtils.navigateUpFromSameTask(this);
    return true;
  }

  protected void setDefaultTitle(int paramInt)
  {
    if (!getIntent().hasExtra("android.intent.extra.TITLE"))
      setTitle(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.app.ViberSingleFragmentActivity
 * JD-Core Version:    0.6.2
 */