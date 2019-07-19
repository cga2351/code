package com.viber.voip.calls.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class KeypadActivity extends ViberSingleFragmentActivity
  implements KeypadFragment.b
{
  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void i(Intent paramIntent)
  {
    startActivity(paramIntent);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected Fragment onCreatePane()
  {
    return new KeypadFragment();
  }

  public void r()
  {
    finish();
    overridePendingTransition(0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.KeypadActivity
 * JD-Core Version:    0.6.2
 */