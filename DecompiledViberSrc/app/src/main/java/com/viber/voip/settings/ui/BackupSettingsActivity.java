package com.viber.voip.settings.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.a;
import com.viber.voip.R.string;

public class BackupSettingsActivity extends SettingsActivity
{
  protected Fragment onCreatePane()
  {
    setActionBarTitle(R.string.pref_category_backup_and_restore);
    boolean bool = getIntent().getBooleanExtra("show_restore", true);
    if (!bool)
    {
      a locala = getSupportActionBar();
      if (locala != null)
        locala.b(false);
    }
    return b.a(bool);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.BackupSettingsActivity
 * JD-Core Version:    0.6.2
 */