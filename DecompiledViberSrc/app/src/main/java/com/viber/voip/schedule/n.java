package com.viber.voip.schedule;

import android.app.Application;
import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;

public class n
  implements f
{
  private static final Logger a = ViberEnv.getLogger();

  public static Bundle a(long paramLong1, long paramLong2)
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putLong("CONVERSATION_ID_EXTRA", paramLong1);
    localBundle.putLong("CONTACT_ID_EXTRA", paramLong2);
    return p.a(localBundle);
  }

  public int a(Bundle paramBundle)
  {
    int i;
    if ((paramBundle == null) || (paramBundle.isEmpty()))
      i = 2;
    long l2;
    Application localApplication;
    boolean bool;
    do
    {
      return i;
      long l1 = paramBundle.getLong("CONVERSATION_ID_EXTRA", -1L);
      l2 = paramBundle.getLong("CONTACT_ID_EXTRA", -1L);
      localApplication = ViberApplication.getApplication();
      if ((l1 > 0L) && (ab.b().f(l1) != null))
        new bs(localApplication).h(l1, false);
      bool = l2 < 0L;
      i = 0;
    }
    while (!bool);
    g.a(localApplication).a().a(l2);
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.n
 * JD-Core Version:    0.6.2
 */