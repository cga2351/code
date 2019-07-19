package com.viber.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.viber.common.app.a;

public abstract class ViberService extends Service
{
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new h(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new g(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.ViberService
 * JD-Core Version:    0.6.2
 */