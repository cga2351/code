package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepName
public class GoogleApiActivity extends Activity
  implements DialogInterface.OnCancelListener
{

  @VisibleForTesting
  private int zabp = 0;

  public static PendingIntent zaa(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    return PendingIntent.getActivity(paramContext, 0, zaa(paramContext, paramPendingIntent, paramInt, true), 134217728);
  }

  public static Intent zaa(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, GoogleApiActivity.class);
    localIntent.putExtra("pending_intent", paramPendingIntent);
    localIntent.putExtra("failing_client_id", paramInt);
    localIntent.putExtra("notify_manager", paramBoolean);
    return localIntent;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    GoogleApiManager localGoogleApiManager;
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      this.zabp = 0;
      setResult(paramInt2, paramIntent);
      if (bool)
      {
        localGoogleApiManager = GoogleApiManager.zab(this);
        switch (paramInt2)
        {
        default:
        case 0:
        case -1:
        }
      }
    }
    while (true)
    {
      finish();
      return;
      localGoogleApiManager.zaa(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
      continue;
      localGoogleApiManager.zao();
      continue;
      if (paramInt1 == 2)
      {
        this.zabp = 0;
        setResult(paramInt2, paramIntent);
      }
    }
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.zabp = 0;
    setResult(0);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
      this.zabp = paramBundle.getInt("resolution");
    Bundle localBundle;
    if (this.zabp != 1)
    {
      localBundle = getIntent().getExtras();
      if (localBundle == null)
      {
        Log.e("GoogleApiActivity", "Activity started without extras");
        finish();
      }
    }
    else
    {
      return;
    }
    PendingIntent localPendingIntent = (PendingIntent)localBundle.get("pending_intent");
    Integer localInteger = (Integer)localBundle.get("error_code");
    if ((localPendingIntent == null) && (localInteger == null))
    {
      Log.e("GoogleApiActivity", "Activity started without resolution");
      finish();
      return;
    }
    if (localPendingIntent != null)
      try
      {
        startIntentSenderForResult(localPendingIntent.getIntentSender(), 1, null, 0, 0, 0);
        this.zabp = 1;
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", localSendIntentException);
        finish();
        return;
      }
    GoogleApiAvailability.getInstance().showErrorDialogFragment(this, localInteger.intValue(), 2, this);
    this.zabp = 1;
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("resolution", this.zabp);
    super.onSaveInstanceState(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiActivity
 * JD-Core Version:    0.6.2
 */