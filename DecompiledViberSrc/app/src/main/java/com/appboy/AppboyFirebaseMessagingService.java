package com.appboy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appboy.f.c;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AppboyFirebaseMessagingService extends FirebaseMessagingService
{
  private static final String b = c.a(AppboyFirebaseMessagingService.class);
  private static final AppboyFcmReceiver c = new AppboyFcmReceiver();

  public static boolean a(Context paramContext, RemoteMessage paramRemoteMessage)
  {
    if (paramRemoteMessage == null)
    {
      c.d(b, "Remote message from FCM was null. Remote message did not originate from Braze.");
      return false;
    }
    if (!b(paramRemoteMessage))
    {
      c.c(b, "Remote message did not originate from Braze. Not consuming remote message: " + paramRemoteMessage);
      return false;
    }
    Map localMap = paramRemoteMessage.getData();
    c.c(b, "Got remote message from FCM: " + localMap);
    Intent localIntent = new Intent("firebase_messaging_service_routing_action");
    Bundle localBundle = new Bundle();
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      String str2 = (String)localEntry.getValue();
      c.a(b, "Adding bundle item from FCM remote data with key: " + str1 + " and value: " + str2);
      localBundle.putString(str1, str2);
    }
    localIntent.putExtras(localBundle);
    c.onReceive(paramContext, localIntent);
    return true;
  }

  public static boolean b(RemoteMessage paramRemoteMessage)
  {
    Map localMap = paramRemoteMessage.getData();
    if (localMap == null)
    {
      c.d(b, "Remote message data from FCM was null. Returning false for Braze push check. Remote message: " + paramRemoteMessage);
      return false;
    }
    return "true".equals(localMap.get("_ab"));
  }

  public void a(RemoteMessage paramRemoteMessage)
  {
    super.a(paramRemoteMessage);
    a(this, paramRemoteMessage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.AppboyFirebaseMessagingService
 * JD-Core Version:    0.6.2
 */