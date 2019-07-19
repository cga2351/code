package com.viber.voip.notif.b.d.a.b;

import android.content.Context;
import com.viber.voip.R.string;

public class c extends a
{
  private final int a;
  private final String b;

  public c(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1);
    this.b = paramString;
    this.a = paramInt2;
  }

  public String R_()
  {
    return "request_user_data_limit_error_gdpr";
  }

  public CharSequence b(Context paramContext)
  {
    int i = R.string.dialog_451_message;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = String.valueOf(this.a);
    return paramContext.getString(i, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.d.a.b.c
 * JD-Core Version:    0.6.2
 */