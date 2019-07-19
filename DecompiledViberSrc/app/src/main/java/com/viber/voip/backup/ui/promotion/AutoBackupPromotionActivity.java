package com.viber.voip.backup.ui.promotion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class AutoBackupPromotionActivity extends ViberSingleFragmentActivity
{
  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.viber.voip.n.a.a(this.mIsTablet, this, 1);
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.e(false);
    setActionBarTitle(R.string.pref_category_backup_and_restore);
  }

  protected Fragment onCreatePane()
  {
    return b.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.promotion.AutoBackupPromotionActivity
 * JD-Core Version:    0.6.2
 */