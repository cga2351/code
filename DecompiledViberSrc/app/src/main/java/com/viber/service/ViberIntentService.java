package com.viber.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.viber.common.app.a;

public abstract class ViberIntentService extends IntentService
{
  public ViberIntentService(String paramString)
  {
    super(paramString);
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new e(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new d(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.ViberIntentService
 * JD-Core Version:    0.6.2
 */