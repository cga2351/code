package com.viber.voip.viberout.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.viber.voip.R.string;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.ViberWebApiActivity.b;
import com.viber.voip.market.WebTokenBasedWebActivity;
import com.viber.voip.util.dl;

public class CallingPlansSuggestionWebActivity extends WebTokenBasedWebActivity
{
  private boolean a;
  private String b;
  private String c;

  public static void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(b(paramBoolean, paramString1, paramString2));
  }

  public static Intent b(boolean paramBoolean, String paramString1, String paramString2)
  {
    Intent localIntent = a(CallingPlansSuggestionWebActivity.class);
    localIntent.putExtra("suggestion", paramBoolean);
    if (!TextUtils.isEmpty(paramString1))
      localIntent.putExtra("plan_id", paramString1);
    if (!TextUtils.isEmpty(paramString2))
      localIntent.putExtra("origin", paramString2);
    return localIntent;
  }

  protected String a(String paramString)
  {
    String str = dl.j(dl.b(paramString));
    if (!TextUtils.isEmpty(this.b))
      str = dl.f(str, this.b);
    if (!TextUtils.isEmpty(this.c))
      str = dl.g(str, this.c);
    return str;
  }

  protected String d()
  {
    if (this.a)
      return getString(R.string.calling_plans_suggestion_title);
    return getString(R.string.viberout_web_title_calling_plans);
  }

  protected ViberWebApiActivity.b j()
  {
    if (this.a)
      return ViberWebApiActivity.b.h;
    return ViberWebApiActivity.b.g;
  }

  protected String l()
  {
    String str = ap.c().aa;
    if (this.a)
      str = str + "suggestion";
    return str;
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.a = getIntent().getBooleanExtra("suggestion", false);
    this.b = getIntent().getStringExtra("plan_id");
    this.c = getIntent().getStringExtra("origin");
    super.onCreate(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.CallingPlansSuggestionWebActivity
 * JD-Core Version:    0.6.2
 */