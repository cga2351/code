package com.viber.voip.registration.changephonenumber;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.i.c.a;
import com.viber.voip.i.f;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.a;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.l;
import com.viber.voip.util.cg;
import com.viber.voip.util.co;
import com.viber.voip.util.da;

public class CarrierChangedSplashActivity extends ViberFragmentActivity
  implements View.OnClickListener
{
  private static final Logger a = ViberEnv.getLogger();

  private String a()
  {
    return UserManager.from(ViberApplication.getApplication()).getRegistrationValues().h();
  }

  private static void a(String paramString1, String paramString2)
  {
    if (da.a(paramString1));
    for (String str = ""; ; str = paramString1 + "/")
    {
      d.a.d.a(str + paramString2);
      return;
    }
  }

  public static boolean a(Context paramContext)
  {
    if (c.a.a.e())
    {
      if (com.viber.common.permission.c.a(paramContext).a(new String[] { "android.permission.READ_PHONE_STATE" }));
    }
    else
      return false;
    String str1 = cg.a(paramContext);
    if (da.a(str1))
      return false;
    String str2 = d.a.d.d();
    if (str2 == null)
      str2 = "";
    if (!str2.contains(str1))
    {
      a(str2, str1);
      if (!da.a(str2))
      {
        paramContext.startActivity(new Intent(paramContext, CarrierChangedSplashActivity.class));
        return true;
      }
    }
    return false;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.change_number_btn)
      startActivity(ViberActionRunner.l.a(this, "New Sim detected"));
    while (i != R.id.keep_number_btn)
      return;
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.carrier_changed_splash);
    TextView localTextView = (TextView)findViewById(R.id.keep_number_btn);
    if (com.viber.common.d.c.a())
      ((TextView)findViewById(R.id.new_sim_detected_title)).setText(co.a(getString(R.string.new_sim_detected_title)));
    String str = a();
    localTextView.setText(getString(R.string.new_sim_detected_keep_btn, new Object[] { str }));
    localTextView.setOnClickListener(this);
    ((TextView)findViewById(R.id.change_number_btn)).setOnClickListener(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.CarrierChangedSplashActivity
 * JD-Core Version:    0.6.2
 */