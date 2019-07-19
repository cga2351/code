package com.viber.voip.notif.b.d.a.a;

import android.content.Context;
import com.viber.voip.R.string;

public class d extends a
{
  private final String a;

  public d(int paramInt, String paramString)
  {
    super(paramInt);
    this.a = paramString;
  }

  public String R_()
  {
    return "delete_user_data_processing_error_gdpr";
  }

  public CharSequence b(Context paramContext)
  {
    int i = R.string.dialog_450_message;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a;
    return paramContext.getString(i, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.dialog_450_title);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.d.a.a.d
 * JD-Core Version:    0.6.2
 */