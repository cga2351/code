package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.a.a;

public class ProxyBillingActivity extends Activity
{
  private ResultReceiver a;

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Bundle localBundle;
    if (paramInt1 == 100)
    {
      int i = a.a(paramIntent, "ProxyBillingActivity");
      if ((paramInt2 != -1) || (i != 0))
        a.b("ProxyBillingActivity", "Activity finished with resultCode " + paramInt2 + " and billing's responseCode: " + i);
      ResultReceiver localResultReceiver = this.a;
      if (paramIntent == null)
      {
        localBundle = null;
        localResultReceiver.send(i, localBundle);
      }
    }
    while (true)
    {
      finish();
      return;
      localBundle = paramIntent.getExtras();
      break;
      a.b("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + paramInt1 + "; skipping...");
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      a.a("ProxyBillingActivity", "Launching Play Store billing flow");
      this.a = ((ResultReceiver)getIntent().getParcelableExtra("result_receiver"));
      if (!getIntent().hasExtra("BUY_INTENT"));
    }
    for (PendingIntent localPendingIntent = (PendingIntent)getIntent().getParcelableExtra("BUY_INTENT"); ; localPendingIntent = null)
    {
      try
      {
        while (true)
        {
          startIntentSenderForResult(localPendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
          return;
          if (!getIntent().hasExtra("SUBS_MANAGEMENT_INTENT"))
            break;
          localPendingIntent = (PendingIntent)getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
        }
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        a.b("ProxyBillingActivity", "Got exception while trying to start a purchase flow: " + localSendIntentException);
        this.a.send(6, null);
        finish();
        return;
      }
      a.a("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
      this.a = ((ResultReceiver)paramBundle.getParcelable("result_receiver"));
      return;
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("result_receiver", this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.ProxyBillingActivity
 * JD-Core Version:    0.6.2
 */