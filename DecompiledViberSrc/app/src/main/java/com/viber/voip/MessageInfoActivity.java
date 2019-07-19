package com.viber.voip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.contacts.ui.bh;
import com.viber.voip.contacts.ui.bj;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.d;
import com.viber.voip.ui.c.k;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.dj;

public class MessageInfoActivity extends ViberSingleFragmentActivity
{
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
    android.support.v7.app.a locala = getSupportActionBar();
    locala.a(true);
    locala.b(true);
    setActionBarTitle(R.string.message_info_title);
  }

  protected Fragment onCreatePane()
  {
    if (getIntent().getIntExtra("view_likes_mode", 1) == 2)
      return new bj();
    return new bh();
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
 * Qualified Name:     com.viber.voip.MessageInfoActivity
 * JD-Core Version:    0.6.2
 */