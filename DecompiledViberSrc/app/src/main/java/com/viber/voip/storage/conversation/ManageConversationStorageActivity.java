package com.viber.voip.storage.conversation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.settings.ui.ManageStorageActivity;

public class ManageConversationStorageActivity extends ManageStorageActivity
{
  protected boolean a()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.b(true);
  }

  protected Fragment onCreatePane()
  {
    a locala = new a();
    Bundle localBundle = new Bundle(1);
    Intent localIntent = getIntent();
    localBundle.putLong("extra_conversation_id", localIntent.getLongExtra("extra_conversation_id", -1L));
    localBundle.putInt("extra_source", a(localIntent));
    locala.setArguments(localBundle);
    return locala;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
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
 * Qualified Name:     com.viber.voip.storage.conversation.ManageConversationStorageActivity
 * JD-Core Version:    0.6.2
 */