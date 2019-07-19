package com.viber.voip.contacts.ui;

import android.os.Bundle;
import android.support.v7.app.a;
import android.view.MenuItem;
import com.viber.voip.app.b;
import com.viber.voip.util.dj;

public class ContactDetailsDialogActivity extends ContactDetailsActivity
{
  protected void a()
  {
    if (this.b.a(this))
      dj.a(this, true, true);
    super.a();
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.b.a(this))
    {
      a locala = getSupportActionBar();
      if (locala != null)
        locala.b(true);
    }
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
 * Qualified Name:     com.viber.voip.contacts.ui.ContactDetailsDialogActivity
 * JD-Core Version:    0.6.2
 */