package com.viber.voip.validation.a;

import android.content.Context;
import android.text.Html;
import com.viber.voip.R.string;

public class a extends c
{
  private Context f;

  public a(Context paramContext)
  {
    this.f = paramContext;
  }

  protected int g()
  {
    return 3;
  }

  protected CharSequence h()
  {
    return Html.fromHtml(this.f.getString(R.string.create_public_account_about_validation_error));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.validation.a.a
 * JD-Core Version:    0.6.2
 */