package com.viber.voip.messages.conversation.ui.edit.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.a;
import android.support.v7.widget.Toolbar;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.util.dj;

public class GroupAddDetailsActivity extends ViberFragmentActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mIsTablet)
      dj.a(this, 20, 36);
    setContentView(R.layout.activity_add_group_details);
    if (this.mIsTablet)
      dj.a(this, 0.65F, 0.75F, 0.65F, 0.75F, true);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    getSupportActionBar().b(true);
    setActionBarTitle(R.string.add_details_title);
    if (paramBundle == null)
    {
      d locald = new d();
      locald.setArguments(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction().add(R.id.root_container, locald, "add_details_fragment").commit();
    }
  }

  public boolean onSupportNavigateUp()
  {
    if (!super.onSupportNavigateUp())
      onBackPressed();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.edit.group.GroupAddDetailsActivity
 * JD-Core Version:    0.6.2
 */