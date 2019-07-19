package com.viber.voip.fcm;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.viber.common.app.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;

public class ViberInstanceIDListenerService extends FirebaseInstanceIdService
{
  private static final Logger b = ViberEnv.getLogger();

  public void a()
  {
    ViberApplication.getInstance().getFcmTokenController().a();
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new m(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new l(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.fcm.ViberInstanceIDListenerService
 * JD-Core Version:    0.6.2
 */