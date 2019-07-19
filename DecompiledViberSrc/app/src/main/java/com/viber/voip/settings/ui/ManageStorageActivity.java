package com.viber.voip.settings.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.app.b;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import javax.inject.Inject;

public class ManageStorageActivity extends ViberSingleFragmentActivity
{

  @Inject
  b a;

  protected int a(Intent paramIntent)
  {
    return new com.viber.voip.storage.model.a().a(paramIntent, "extra_source");
  }

  protected boolean a()
  {
    return a(getIntent()) != 0;
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setDefaultTitle(R.string.manage_storage);
    if (this.a.a(this))
    {
      if (a())
        dj.a(this, false, true);
    }
    else
      return;
    findViewById(R.id.root_container).setBackgroundColor(dc.d(this, R.attr.mainBackgroundColor));
  }

  protected Fragment onCreatePane()
  {
    return new com.viber.voip.storage.overall.a();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.a.a(this));
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    if (!onSupportNavigateUp())
      onBackPressed();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ManageStorageActivity
 * JD-Core Version:    0.6.2
 */