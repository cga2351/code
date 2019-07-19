package com.viber.voip.phone;

import android.support.v4.app.Fragment;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.phone.viber.VideoCallCallbacks;
import com.viber.voip.phone.viber.VideoCallFragment;

public class TabletVideoCallActivity extends ViberSingleFragmentActivity
  implements VideoCallCallbacks
{
  private static final Logger L = ViberEnv.getLogger();

  protected Fragment onCreatePane()
  {
    VideoCallFragment localVideoCallFragment = new VideoCallFragment();
    localVideoCallFragment.setVideoCallCallbacks(this);
    return localVideoCallFragment;
  }

  public void onVideoClosed()
  {
    finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.TabletVideoCallActivity
 * JD-Core Version:    0.6.2
 */