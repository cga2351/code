package com.viber.voip.messages.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.messages.conversation.ui.ax;
import com.viber.voip.messages.m;
import com.viber.voip.util.dj;
import dagger.android.c;
import javax.inject.Inject;

public class ConversationGalleryActivity extends ViberSingleFragmentActivity
  implements dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  public static Intent a(long paramLong, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent("com.viber.voip.action.messages.ui.GALLERY_ACTION");
    localIntent.putExtra("conversation_id", paramLong);
    localIntent.putExtra("conversation_type", paramInt1);
    localIntent.putExtra("is_share_and_forward_available", paramBoolean1);
    localIntent.putExtra("navigate_up", paramBoolean2);
    localIntent.putExtra("conversation_name", paramString);
    localIntent.putExtra("group_role", paramInt2);
    return localIntent;
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    dj.c(this, false);
    getSupportActionBar().e(true);
    getSupportActionBar().a(false);
    getSupportActionBar().b(true);
    setDefaultTitle(R.string.media);
  }

  protected Fragment onCreatePane()
  {
    ax localax = new ax();
    localax.setArguments(getIntent().getExtras());
    return localax;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    Intent localIntent = getIntent();
    long l = localIntent.getLongExtra("conversation_id", 0L);
    if ((l > 0L) && (localIntent.getBooleanExtra("navigate_up", false)))
      startActivity(m.a(l, localIntent.getIntExtra("conversation_type", 0), false, false, false, false));
    finish();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ConversationGalleryActivity
 * JD-Core Version:    0.6.2
 */