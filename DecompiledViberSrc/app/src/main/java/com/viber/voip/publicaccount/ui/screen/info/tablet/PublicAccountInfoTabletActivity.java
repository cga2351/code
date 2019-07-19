package com.viber.voip.publicaccount.ui.screen.info.tablet;

import android.content.res.Configuration;
import android.os.Bundle;
import com.viber.voip.publicaccount.ui.screen.info.PublicAccountInfoActivity;
import com.viber.voip.util.dj;

public class PublicAccountInfoTabletActivity extends PublicAccountInfoActivity
{
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    dj.a(this, 0.65F, 0.75F, 0.5F, 0.9F, true, paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dj.a(this, 0.65F, 0.75F, 0.5F, 0.9F, true);
    super.onCreate(paramBundle);
  }

  public boolean onSupportNavigateUp()
  {
    i();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.info.tablet.PublicAccountInfoTabletActivity
 * JD-Core Version:    0.6.2
 */