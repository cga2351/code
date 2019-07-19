package com.appboy.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appboy.f.c;

public class AppboyNotificationRoutingActivity extends Activity
{
  private static final String a = c.a(AppboyNotificationRoutingActivity.class);

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent1 = getIntent();
    if (localIntent1 == null)
    {
      c.b(a, "Notification routing activity received null intent. Doing nothing.");
      finish();
      return;
    }
    String str = localIntent1.getAction();
    if (str == null)
    {
      c.b(a, "Notification routing activity received intent with null action. Doing nothing.");
      finish();
      return;
    }
    c.c(a, "Notification routing activity received intent: " + localIntent1.toString());
    Context localContext = getApplicationContext();
    Intent localIntent2 = new Intent(str).setClass(localContext, d.b());
    localIntent2.putExtras(localIntent1.getExtras());
    localContext.sendBroadcast(localIntent2);
    finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.push.AppboyNotificationRoutingActivity
 * JD-Core Version:    0.6.2
 */