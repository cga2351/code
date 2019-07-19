package com.viber.voip.notif.receivers;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import com.viber.common.d.g;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public final class PendingIntentBroadcastReceiver extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();

  private void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.sendBroadcast(paramIntent);
      return;
    }
    catch (BadParcelableException localBadParcelableException)
    {
      a.a(localBadParcelableException, "onReceive: unable to send broadcast for action '" + paramIntent.getAction() + "'");
    }
  }

  private void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramIntent.setFlags(268435456);
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null);
    label4: int i;
    Intent localIntent;
    do
    {
      do
      {
        byte[] arrayOfByte;
        do
        {
          break label4;
          do
            return;
          while (!"com.viber.voip.action.NOTIFICATION_INTENT_ACTION".equals(paramIntent.getAction()));
          arrayOfByte = paramIntent.getByteArrayExtra("extra_real_intent");
        }
        while (arrayOfByte == null);
        i = paramIntent.getIntExtra("extra_intent_type", -1);
        localIntent = (Intent)g.a(arrayOfByte, Intent.class.getClassLoader());
      }
      while (localIntent == null);
      if (i == 0)
      {
        localIntent.setClipData(paramIntent.getClipData());
        a(paramContext, localIntent);
        return;
      }
      if (1 == i)
      {
        paramContext.startService(localIntent);
        return;
      }
    }
    while (2 != i);
    b(paramContext, localIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.receivers.PendingIntentBroadcastReceiver
 * JD-Core Version:    0.6.2
 */