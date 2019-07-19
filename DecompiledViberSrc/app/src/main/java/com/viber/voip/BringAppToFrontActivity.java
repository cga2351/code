package com.viber.voip;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.viber.common.app.a;
import com.viber.dexshared.Logger;
import com.viber.voip.messages.controller.manager.at;
import com.viber.voip.messages.controller.manager.au;
import com.viber.voip.messages.k;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ab;

public class BringAppToFrontActivity extends ViberAppCompatActivity
{
  private static final Logger a = ViberEnv.getLogger();

  private static boolean a(Intent paramIntent)
  {
    return (d(paramIntent)) && (ViberApplication.getInstance().getMessagesManager().v().a().a());
  }

  private static boolean b(Intent paramIntent)
  {
    if ((e(paramIntent)) || (f(paramIntent)))
    {
      ViberApplication.getInstance().getMessagesManager().v().a().a(1);
      return true;
    }
    return false;
  }

  private static boolean c(Intent paramIntent)
  {
    if ((e(paramIntent)) || (f(paramIntent)))
    {
      ViberApplication.getInstance().getMessagesManager().v().a().a(4);
      return true;
    }
    return false;
  }

  private static boolean d(Intent paramIntent)
  {
    boolean bool1 = false;
    if (paramIntent != null)
    {
      boolean bool2 = paramIntent.getBooleanExtra("approve_sync_history_to_desktop_notification", false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  private static boolean e(Intent paramIntent)
  {
    boolean bool1 = false;
    if (paramIntent != null)
    {
      boolean bool2 = paramIntent.getBooleanExtra("syncing_history_to_desktop_minimized_window", false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  private static boolean f(Intent paramIntent)
  {
    boolean bool1 = false;
    if (paramIntent != null)
    {
      boolean bool2 = paramIntent.getBooleanExtra("syncing_history_to_desktop_notification", false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool = isTaskRoot();
    Intent localIntent = getIntent();
    b(localIntent);
    if (bool)
      av.a(av.e.a).post(new a(localIntent, ViberApplication.getApplication()));
    while (true)
    {
      finish();
      return;
      if (!a(localIntent))
        c(localIntent);
    }
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new n(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new l(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    a.a(new m(this, paramIntent, paramInt), new Intent[] { paramIntent });
  }

  private static class a
    implements Runnable
  {
    private final Intent a;
    private final Context b;

    a(Intent paramIntent, Context paramContext)
    {
      this.a = paramIntent;
      this.b = paramContext;
    }

    public void run()
    {
      ViberActionRunner.b(this.b, ViberActionRunner.ab.a(this.b));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.BringAppToFrontActivity
 * JD-Core Version:    0.6.2
 */