package com.viber.voip.schedule;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
import com.viber.common.app.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class ViberGcmTaskService extends GcmTaskService
{
  private static final Logger a = ViberEnv.getLogger();

  public static Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("operation_id", paramInt);
    return localBundle;
  }

  public static Bundle a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = a(paramInt);
    if (paramBundle != null)
      localBundle.putAll(paramBundle);
    return localBundle;
  }

  public void onInitializeTasks()
  {
    super.onInitializeTasks();
    p.a(getApplicationContext());
  }

  public int onRunTask(TaskParams paramTaskParams)
  {
    int i = 2;
    Bundle localBundle = paramTaskParams.getExtras();
    if (localBundle != null)
    {
      f localf = p.a(localBundle.getInt("operation_id", -1), this);
      if (localf != null)
      {
        localBundle.remove("operation_id");
        i = localf.a(localBundle);
      }
    }
    return i;
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    return 2;
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new s(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new r(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.ViberGcmTaskService
 * JD-Core Version:    0.6.2
 */