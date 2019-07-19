package com.firebase.jobdispatcher;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

@TargetApi(21)
class j extends Handler
{
  private final GooglePlayReceiver a;

  public j(Looper paramLooper, GooglePlayReceiver paramGooglePlayReceiver)
  {
    super(paramLooper);
    this.a = paramGooglePlayReceiver;
  }

  private void a(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    Messenger localMessenger = paramMessage.replyTo;
    String str = localBundle.getString("tag");
    if ((localMessenger == null) || (str == null))
    {
      if (Log.isLoggable("FJD.GooglePlayReceiver", 3))
        Log.d("FJD.GooglePlayReceiver", "Invalid start execution message.");
      return;
    }
    k localk = new k(localMessenger, str);
    o localo = this.a.a(localk, localBundle);
    this.a.a().a(localo);
  }

  private void b(Message paramMessage)
  {
    o.a locala = GooglePlayReceiver.b().b(paramMessage.getData());
    if (locala == null)
    {
      if (Log.isLoggable("FJD.GooglePlayReceiver", 3))
        Log.d("FJD.GooglePlayReceiver", "Invalid stop execution message.");
      return;
    }
    d.a(locala.a(), true);
  }

  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
      return;
    AppOpsManager localAppOpsManager = (AppOpsManager)this.a.getApplicationContext().getSystemService("appops");
    try
    {
      localAppOpsManager.checkPackage(paramMessage.sendingUid, "com.google.android.gms");
      switch (paramMessage.what)
      {
      case 4:
      case 3:
      default:
        Log.e("FJD.GooglePlayReceiver", "Unrecognized message received: " + paramMessage);
        return;
      case 1:
      case 2:
      }
    }
    catch (SecurityException localSecurityException)
    {
      Log.e("FJD.GooglePlayReceiver", "Message was not sent from GCM.");
      return;
    }
    a(paramMessage);
    return;
    b(paramMessage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.j
 * JD-Core Version:    0.6.2
 */