package com.viber.voip.ui;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Window;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;
import com.viber.voip.util.dj;

public class KeyguardUnlockWaitActivity extends ViberFragmentActivity
{
  private static final e a = ViberEnv.getLogger();
  private PendingIntent b;
  private a c = null;

  private void a()
  {
    getWindow().addFlags(4196314);
    if (!dj.h(this))
      getWindow().addFlags(2097152);
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Intent localIntent = new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    getApplicationContext().sendBroadcast(localIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    this.b = ((PendingIntent)localIntent.getParcelableExtra("pending_intent"));
    if (this.b == null)
    {
      finish();
      return;
    }
    long l1 = localIntent.getLongExtra("conversation_id", -1L);
    if (l1 > 0L)
      g.a(this).a(l1);
    long l2 = localIntent.getLongExtra("contact_id", -1L);
    if (l2 > 0L)
      g.a(this).a().a(l2);
    a();
    this.c = new a();
    registerReceiver(this.c, new IntentFilter("android.intent.action.USER_PRESENT"));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.c);
  }

  class a extends BroadcastReceiver
  {
    a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (KeyguardUnlockWaitActivity.a(KeyguardUnlockWaitActivity.this) != null);
      try
      {
        KeyguardUnlockWaitActivity.a(KeyguardUnlockWaitActivity.this).send();
        label20: KeyguardUnlockWaitActivity.this.finish();
        return;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        break label20;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.KeyguardUnlockWaitActivity
 * JD-Core Version:    0.6.2
 */