package com.viber.voip.messages.translation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;
import dagger.android.c;
import javax.inject.Inject;

public class SelectUiLanguageActivity extends ViberSingleFragmentActivity
  implements dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    getSupportActionBar().b(true);
    setDefaultTitle(R.string.pref_ui_language_title);
  }

  protected Fragment onCreatePane()
  {
    return new f();
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

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.translation.SelectUiLanguageActivity
 * JD-Core Version:    0.6.2
 */