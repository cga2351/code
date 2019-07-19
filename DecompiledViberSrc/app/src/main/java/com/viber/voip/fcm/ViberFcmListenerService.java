package com.viber.voip.fcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager.WakeLock;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.as;
import com.viber.voip.util.ViberActionRunner.av;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import java.util.Map;

public class ViberFcmListenerService extends FirebaseMessagingService
{
  private static final Logger b = ViberEnv.getLogger();

  private void a(com.viber.voip.c.a parama, Engine paramEngine, Map<String, String> paramMap, String paramString)
  {
    if ((!cj.b(getApplicationContext())) && (cj.f(getApplicationContext())));
    for (int i = 1; i != 0; i = 0)
    {
      paramMap.put("373969298204", paramString);
      ViberActionRunner.av.a(parama, paramMap);
      return;
    }
    paramEngine.getPhoneController().testConnection(0);
    parama.a(this, paramMap);
  }

  private void a(Map<String, String> paramMap)
  {
    try
    {
      int j = Integer.parseInt((String)paramMap.get("op"));
      i = j;
      if (i == 1)
        l1 = ViberApplication.getInstance().getEngine(false).getServerDeltaTime();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        long l1;
        long l2 = Long.parseLong((String)paramMap.get("time"));
        if (com.viber.voip.c.a.a(l2 * 1000L, l1))
        {
          Context localContext = getApplicationContext();
          dj.a(localContext, "com.viber.voip:PushWakeLock").acquire(5000L);
          ViberActionRunner.as.a(localContext);
        }
        return;
        localNumberFormatException = localNumberFormatException;
        int i = -1;
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void a()
  {
  }

  public void a(RemoteMessage paramRemoteMessage)
  {
    String str = paramRemoteMessage.getFrom();
    Map localMap = paramRemoteMessage.getData();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    if (localViberApplication.shouldBlockAllActivities());
    do
    {
      return;
      com.viber.voip.analytics.g localg = com.viber.voip.analytics.g.a();
      if (localg.a(paramRemoteMessage))
      {
        localViberApplication.initApplication();
        localViberApplication.getEngine(false).addInitializedListener(new i(localg, paramRemoteMessage));
      }
    }
    while (!"373969298204".equalsIgnoreCase(str));
    com.viber.voip.c.a locala = new com.viber.voip.c.a(localViberApplication.getEngine(false), localViberApplication.getUserManager().getRegistrationValues(), localViberApplication.getNotifier().a(), localViberApplication.getHandledCloudMessagesHolder(), localViberApplication.getRecentCallsManager(), localViberApplication.getAppBackgroundChecker());
    if (!com.viber.voip.c.a.a)
    {
      a(localMap);
      localViberApplication.initApplication();
      localViberApplication.getEngine(false).addInitializedListener(new j(this, locala, localMap, str));
      return;
    }
    locala.a(this, localMap);
    localViberApplication.initApplication();
    localViberApplication.getEngine(false).addInitializedListener(k.a);
  }

  public void a(String paramString)
  {
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new h(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new g(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.fcm.ViberFcmListenerService
 * JD-Core Version:    0.6.2
 */