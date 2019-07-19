package com.viber.voip.viberout.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.j;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.billing.Carrier;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.b;
import com.viber.voip.billing.b.g;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.af;
import java.util.ArrayList;

public class CheckPurchaseActivity extends ViberFragmentActivity
  implements m.c, m.j, e.a
{
  private static final Logger a = b.a(CheckPurchaseActivity.class);
  private a b;
  private boolean c;
  private boolean d;
  private ViewGroup e;
  private Carrier f;
  private boolean g;

  private void a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    this.g = false;
    ad.a(R.string.generic_please_wait_dialog_text).b(true).a(this).a(this);
    b.g localg = new b.g(paramArrayList);
    localg.a(this.f);
    b.a().a(localg, new e(paramBoolean, this.d, this));
  }

  public void a(a parama)
  {
    this.e.addView(parama);
  }

  public boolean a()
  {
    return !isFinishing();
  }

  public void b()
  {
    this.g = true;
    z.a(getSupportFragmentManager(), DialogCode.D_PROGRESS);
  }

  public void c()
  {
    af.b(getString(R.string.dialog_620_message)).d();
    finish();
  }

  public a d()
  {
    if (this.b == null)
    {
      this.b = new a(this);
      this.b.setOnStoreItemSelectedListener(new a.a()
      {
        public void a()
        {
          CheckPurchaseActivity.this.finish();
        }

        public void a(IabProductId paramAnonymousIabProductId)
        {
          CheckPurchaseActivity.this.finish();
        }

        public boolean b()
        {
          return CheckPurchaseActivity.a(CheckPurchaseActivity.this);
        }

        public boolean c()
        {
          return CheckPurchaseActivity.b(CheckPurchaseActivity.this);
        }
      });
    }
    return this.b;
  }

  public void e()
  {
    finish();
  }

  public void f()
  {
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = ((ViewGroup)findViewById(16908290));
    Intent localIntent = getIntent();
    ArrayList localArrayList = localIntent.getStringArrayListExtra("products");
    if (localArrayList != null)
    {
      this.d = localIntent.getBooleanExtra("show_vo_screen_on_complete", false);
      this.f = ((Carrier)localIntent.getParcelableExtra("carrier"));
      this.c = localIntent.getBooleanExtra("show_vo_special_dialog", false);
      a(localArrayList, this.c);
      return;
    }
    finish();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D_PROGRESS)) && (-1000 == paramInt))
      finish();
  }

  public void onDialogShow(m paramm)
  {
    if ((this.g) && (paramm.a(DialogCode.D_PROGRESS)))
      b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.CheckPurchaseActivity
 * JD-Core Version:    0.6.2
 */