package com.viber.voip.viberout.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.billing.b;
import com.viber.voip.billing.b.c;
import com.viber.voip.billing.b.o;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.af;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.io.Serializable;
import java.util.Locale;
import org.json.JSONObject;

public class ViberOutReferralActivity extends ViberFragmentActivity
  implements m.c
{
  a a;
  View b;
  View c;
  View d;
  TextView e;
  View f;
  TextView g;
  TextView h;
  View.OnClickListener i = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView.getId() != R.id.btn_invite_friends) || (!ViberOutReferralActivity.a(ViberOutReferralActivity.this)))
        return;
      Intent localIntent = new Intent("com.viber.voip.action.FREE_CREDIT_FRIENDS_SELECT");
      localIntent.putExtra("max_participant_count", ViberOutReferralActivity.this.a.b);
      ViberOutReferralActivity.this.startActivityForResult(localIntent, 1);
    }
  };

  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, ViberOutReferralActivity.class));
  }

  private void a(b.c paramc)
  {
    boolean bool;
    if (com.viber.common.d.a.b())
      if ((isFinishing()) || (isDestroyed()))
        bool = true;
    while (bool)
    {
      return;
      bool = false;
      continue;
      bool = isFinishing();
    }
    if ((paramc == null) || (!paramc.a()))
    {
      this.d.setVisibility(4);
      f.d().a(this).a(this);
      return;
    }
    a locala = new a(null);
    JSONObject localJSONObject = paramc.d();
    if (localJSONObject != null)
    {
      locala.a = localJSONObject.optString("referral_amount");
      locala.b = localJSONObject.optInt("invite_num_left");
      a(locala);
      return;
    }
    f.d().a(this);
  }

  private void a(a parama)
  {
    int j = 8;
    this.a = parama;
    boolean bool;
    int k;
    label38: View localView;
    if (parama.b > 0)
    {
      bool = true;
      this.b.setEnabled(bool);
      TextView localTextView1 = this.e;
      if (!bool)
        break label159;
      k = 0;
      localTextView1.setVisibility(k);
      localView = this.f;
      if (!bool)
        break label165;
    }
    while (true)
    {
      localView.setVisibility(j);
      TextView localTextView2 = this.g;
      int m = R.string.free_credit_title;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = parama.a;
      localTextView2.setText(c.a(this, m, arrayOfObject1));
      TextView localTextView3 = this.h;
      int n = R.string.free_credit_subtitle;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = parama.a;
      localTextView3.setText(c.a(this, n, arrayOfObject2));
      this.d.setVisibility(4);
      this.c.setVisibility(0);
      return;
      bool = false;
      break;
      label159: k = j;
      break label38;
      label165: j = 0;
    }
  }

  private boolean a()
  {
    if (!b.d())
    {
      f.b().a(this).a(this);
      return false;
    }
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
      af.f().a(this).a(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.viberout_free_credit);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    getSupportActionBar().b(true);
    setTitle(R.string.free_credit_header);
    if (ViberApplication.isTablet(this))
      dj.a(this, 0.6F, 0.6F, 0.4F, 0.9F, false);
    this.b = findViewById(R.id.btn_invite_friends);
    this.b.setOnClickListener(this.i);
    this.b.setEnabled(false);
    this.c = findViewById(R.id.content);
    this.d = findViewById(R.id.loading);
    this.e = ((TextView)findViewById(R.id.offer_requirements));
    this.f = findViewById(R.id.already_sent_max_number);
    String str = Locale.getDefault().getLanguage();
    da.a(this.e, getString(R.string.free_credit_offer_requirements_link, new Object[] { str }), getString(R.string.viber_out_referral_program_terms), true);
    this.e.setMovementMethod(LinkMovementMethod.getInstance());
    this.g = ((TextView)findViewById(R.id.free_credit_title));
    this.h = ((TextView)findViewById(R.id.free_credit_subtitle));
    this.h = ((TextView)findViewById(R.id.free_credit_subtitle));
    if ((ViberApplication.isTablet(this)) || (dj.c(this)))
    {
      this.h.setGravity(17);
      ((TextView)findViewById(R.id.vo_description)).setGravity(17);
    }
    this.a = null;
    if (paramBundle != null)
    {
      Serializable localSerializable = paramBundle.getSerializable("referral_settings");
      if (localSerializable != null)
        this.a = ((a)localSerializable);
    }
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (((paramm.a(DialogCode.D201)) || (paramm.a(DialogCode.D3011)) || (paramm.a(DialogCode.D204))) && (paramInt == -1))
      finish();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.a != null)
      paramBundle.putSerializable("referral_settings", this.a);
  }

  protected void onStart()
  {
    super.onStart();
    if (this.a == null)
    {
      b.a(new b.o()
      {
        public void a(b.c paramAnonymousc)
        {
          ViberOutReferralActivity.a(ViberOutReferralActivity.this, paramAnonymousc);
        }
      });
      return;
    }
    a(this.a);
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return true;
  }

  private static class a
    implements Serializable
  {
    String a;
    int b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.ViberOutReferralActivity
 * JD-Core Version:    0.6.2
 */