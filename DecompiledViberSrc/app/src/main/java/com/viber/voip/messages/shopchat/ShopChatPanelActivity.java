package com.viber.voip.messages.shopchat;

import android.support.v4.app.Fragment;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class ShopChatPanelActivity extends ViberSingleFragmentActivity
  implements b.a
{
  public void F()
  {
    finish();
  }

  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected Fragment onCreatePane()
  {
    return new b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.shopchat.ShopChatPanelActivity
 * JD-Core Version:    0.6.2
 */