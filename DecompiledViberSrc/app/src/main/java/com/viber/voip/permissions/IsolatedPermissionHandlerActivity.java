package com.viber.voip.permissions;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.dialogs.DialogCode;

public class IsolatedPermissionHandlerActivity extends ViberFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private String[] b;
  private int c;
  private PendingIntent d;
  private c e;
  private b f;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = c.a(this);
    Intent localIntent = getIntent();
    this.b = localIntent.getStringArrayExtra("permissions");
    this.c = localIntent.getIntExtra("request_code", 0);
    this.d = ((PendingIntent)localIntent.getParcelableExtra("on_permission_granted_intent"));
    if ((this.b == null) || (this.c == 0) || (this.d == null))
      finish();
    do
    {
      return;
      Pair[] arrayOfPair = new Pair[1];
      arrayOfPair[0] = m.a(this.c);
      this.f = new f(this, arrayOfPair)
      {
        public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
        {
          if ((DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)) && (paramAnonymousInt2 == -1))
            return;
          IsolatedPermissionHandlerActivity.this.finish();
        }

        public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
        {
          try
          {
            IsolatedPermissionHandlerActivity.a(IsolatedPermissionHandlerActivity.this).send();
            label10: IsolatedPermissionHandlerActivity.this.finish();
            return;
          }
          catch (PendingIntent.CanceledException localCanceledException)
          {
            break label10;
          }
        }
      };
    }
    while (paramBundle != null);
    this.e.a(this, this.c, this.b);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.e.a(this, this.c, this.b);
  }

  protected void onStart()
  {
    super.onStart();
    this.e.a(this.f);
  }

  protected void onStop()
  {
    super.onStop();
    this.e.b(this.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.IsolatedPermissionHandlerActivity
 * JD-Core Version:    0.6.2
 */