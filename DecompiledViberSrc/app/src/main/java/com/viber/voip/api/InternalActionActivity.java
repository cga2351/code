package com.viber.voip.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.viber.common.dialogs.h.a;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.Action.ExecuteListener;
import com.viber.voip.messages.orm.entity.json.action.Action.ExecuteStatus;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.m;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;

public class InternalActionActivity extends ViberFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean b;
  private Action c;
  private Action.ExecuteListener d;
  private boolean e;
  private c f;
  private b g = new f(this, new Pair[0])
  {
    public int[] acceptOnly()
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = InternalActionActivity.a(InternalActionActivity.this).getPermissionRequestCode();
      return arrayOfInt;
    }

    protected m getDialog(int paramAnonymousInt)
    {
      return (m)m.a(InternalActionActivity.a(InternalActionActivity.this).getPermissionRequestCode()).second;
    }

    public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
    {
      if (DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString))
        InternalActionActivity.this.a();
      while ((!DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)) || (paramAnonymousInt2 == -1))
        return;
      InternalActionActivity.this.a();
    }

    public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
    {
      InternalActionActivity.a(InternalActionActivity.this).execute(InternalActionActivity.this, InternalActionActivity.b(InternalActionActivity.this));
    }
  };

  void a()
  {
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
      this.e = paramBundle.getBoolean("permission_requested", false);
    this.f = c.a(this);
    Intent localIntent = getIntent();
    this.c = ((Action)localIntent.getParcelableExtra("internal_action"));
    this.b = localIntent.getBooleanExtra("is_hidden", false);
    if (this.c != null)
    {
      if (this.c.isPermissionsRequired())
        this.f.a(this.g);
      this.d = new Action.ExecuteListener()
      {
        public void onFinish(Action.ExecuteStatus paramAnonymousExecuteStatus)
        {
          if (paramAnonymousExecuteStatus == Action.ExecuteStatus.OK);
          while (true)
          {
            InternalActionActivity.this.a();
            return;
            if (Action.ExecuteStatus.NO_CONNECTION == paramAnonymousExecuteStatus)
              ad.a().d();
          }
        }
      };
      String[] arrayOfString = this.c.getRequiredPermissions();
      if ((this.c.isPermissionsRequired()) && (!this.f.a(arrayOfString)))
      {
        if (!this.e)
        {
          this.e = true;
          this.f.a(this, this.c.getPermissionRequestCode(), arrayOfString);
        }
        return;
      }
      this.c.execute(this, this.d);
      return;
    }
    a();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c.isPermissionsRequired())
      this.f.b(this.g);
  }

  protected void onPause()
  {
    super.onPause();
    if (isFinishing())
      overridePendingTransition(0, 0);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("permission_requested", this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.InternalActionActivity
 * JD-Core Version:    0.6.2
 */