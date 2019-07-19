package com.viber.voip.rakuten;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.k;

public class RakutenRegistrationActivity extends ViberFragmentActivity
  implements m.c
{
  private static final Logger a = ViberEnv.getLogger("RakutenRegistrationActivity");
  private DialogFragment b;
  private Handler c = new Handler();
  private a.d d = new a.d()
  {
    public void a()
    {
      RakutenRegistrationActivity.b(RakutenRegistrationActivity.this);
    }

    public void a(String paramAnonymousString1, String paramAnonymousString2)
    {
      RakutenRegistrationActivity.a(RakutenRegistrationActivity.this, paramAnonymousString2);
    }

    public void b()
    {
      RakutenRegistrationActivity.c(RakutenRegistrationActivity.this);
    }

    public void c()
    {
      RakutenRegistrationActivity.this.a();
    }

    public void d()
    {
      RakutenRegistrationActivity.this.b();
    }

    public void e()
    {
      RakutenRegistrationActivity.this.finish();
    }
  };

  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, RakutenRegistrationActivity.class));
  }

  private void a(String paramString)
  {
    e();
    this.b = k.v().b(-1, new Object[] { paramString }).a(this).a(this);
  }

  private void c()
  {
    e();
    this.b = ad.a(R.string.rakuten_progress).b(false).a(this);
  }

  private void d()
  {
    e();
    this.b = k.u().a(this).a(this);
  }

  private void e()
  {
    if (this.b != null)
    {
      this.b.dismiss();
      this.b = null;
    }
  }

  protected void a()
  {
    e();
    this.b = k.x().a(this).a(this);
  }

  protected void b()
  {
    e();
    this.b = k.w().a(this).a(this);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(null);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D389))
      switch (paramInt)
      {
      default:
      case -1:
      case -1000:
      }
    do
    {
      do
      {
        return;
        a.a().f();
        return;
        a.a().g();
        return;
        if ((!paramm.a(DialogCode.D394)) && (!paramm.a(DialogCode.D395)))
          break;
      }
      while ((paramInt != -1) && (paramInt != -1000));
      a.a().h();
      return;
    }
    while (!paramm.a(DialogCode.D393));
    switch (paramInt)
    {
    default:
      return;
    case -1000:
    case -2:
      a.a().e();
      return;
    case -1:
    }
    a.a().d();
  }

  public void onPause()
  {
    super.onPause();
    this.c.post(new Runnable()
    {
      public void run()
      {
        a.a().b(RakutenRegistrationActivity.a(RakutenRegistrationActivity.this));
      }
    });
  }

  public void onResume()
  {
    super.onResume();
    this.c.post(new Runnable()
    {
      public void run()
      {
        a.a().a(RakutenRegistrationActivity.a(RakutenRegistrationActivity.this));
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.rakuten.RakutenRegistrationActivity
 * JD-Core Version:    0.6.2
 */