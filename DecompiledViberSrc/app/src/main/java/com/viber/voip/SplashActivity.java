package com.viber.voip;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.c.a;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.ViberActionRunner.bd;
import com.viber.voip.util.ViberActionRunner.bl;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.dz;

public class SplashActivity extends ViberFragmentActivity
  implements View.OnClickListener
{
  private static final Logger a = ViberEnv.getLogger();
  private Button b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;

  private void a()
  {
    Resources localResources = getResources();
    String str1 = localResources.getString(R.string.agree_text_terms);
    int i = str1.length();
    String str2 = String.format(localResources.getString(R.string.agree_text), new Object[] { str1 });
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str2);
    int j = str2.indexOf(str1);
    int k = i + j;
    if ((j >= 0) && (k <= str2.length()))
    {
      localSpannableStringBuilder.setSpan(new ClickableSpan()
      {
        public void onClick(View paramAnonymousView)
        {
          SplashActivity.a(SplashActivity.this);
        }
      }
      , j, k, 33);
      this.f.setText(localSpannableStringBuilder);
      this.f.setMovementMethod(new LinkMovementMethod());
      return;
    }
    this.f.setText(localSpannableStringBuilder);
  }

  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (!paramIntent.getBooleanExtra("go_to_splash", false))
      return false;
    ViberActionRunner.bd.a(paramContext);
    return true;
  }

  private void b()
  {
    SpannableString localSpannableString = new SpannableString(getString(R.string.transfer_history));
    localSpannableString.setSpan(new UnderlineSpan(), 0, localSpannableString.length(), 17);
    this.g.setMovementMethod(new LinkMovementMethod());
    this.g.setText(localSpannableString);
    this.g.setOnClickListener(this);
  }

  private void c()
  {
    Intent localIntent = new Intent(this, GenericWebViewActivity.class);
    localIntent.putExtra("extra_url", ap.c().f());
    localIntent.putExtra("extra_title", getString(R.string.t_and_p_text));
    localIntent.putExtra("go_to_splash", true);
    dz.a(this, localIntent);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.policy)
      ViberActionRunner.bl.a(this);
    do
    {
      return;
      if (i == R.id.okBtn)
      {
        if (cj.b(this))
        {
          ViberApplication.getInstance().getActivationController().setStep(0, true);
          finish();
          return;
        }
        showDialog(1001);
        return;
      }
    }
    while (i != R.id.transfer_history);
    ViberActionRunner.bl.d(this);
  }

  @SuppressLint({"InlinedApi"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getResources().getBoolean(R.bool.splash_translucent_status))
      dj.f(this);
    setContentView(R.layout.splash);
    this.b = ((Button)findViewById(R.id.okBtn));
    this.b.setOnClickListener(this);
    this.c = ((TextView)findViewById(R.id.policy));
    this.c.setOnClickListener(this);
    this.f = ((TextView)findViewById(R.id.t_and_p));
    this.d = ((TextView)findViewById(R.id.welcome_item));
    this.e = ((TextView)findViewById(R.id.first_item));
    this.g = ((TextView)findViewById(R.id.transfer_history));
    a();
    b();
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1001:
    }
    return new c.a(this).a(true).a(R.string.dialog_c20_title).b(R.string.dialog_c20_message).a(R.string.ok_btn_text, null).b();
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      if (this.d.getLineCount() > 2)
        this.d.setTextSize(2, 28.0F);
      da.a(this.e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.SplashActivity
 * JD-Core Version:    0.6.2
 */