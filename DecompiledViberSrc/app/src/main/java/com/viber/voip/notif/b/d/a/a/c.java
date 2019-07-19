package com.viber.voip.notif.b.d.a.a;

import android.content.Context;
import com.viber.voip.R.string;

public class c extends a
{
  private final String a;
  private final int b;

  public c(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1);
    this.a = paramString;
    this.b = paramInt2;
  }

  public String R_()
  {
    return "delete_user_data_limit_error_gdpr";
  }

  public CharSequence b(Context paramContext)
  {
    int i = R.string.dialog_455_body;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = String.valueOf(this.b);
    return paramContext.getString(i, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.d.a.a.c
 * JD-Core Version:    0.6.2
 */