package com.viber.voip.user.more;

import android.os.Bundle;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.dj;

public class MoreDialogActivity extends MoreActivity
{
  public boolean isSwitchingThemeSupported()
  {
    return false;
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (ViberApplication.isTablet(this))
      dj.a(this, true, true);
    super.onCreate(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreDialogActivity
 * JD-Core Version:    0.6.2
 */