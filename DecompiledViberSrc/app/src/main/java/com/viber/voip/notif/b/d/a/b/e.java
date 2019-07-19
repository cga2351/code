package com.viber.voip.notif.b.d.a.b;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.d.a.a;
import com.viber.voip.util.ViberActionRunner.ay;

public class e extends a
{
  private final int a;

  public e(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.a = paramInt2;
  }

  public String R_()
  {
    return "request_user_data_submitted_gdpr";
  }

  public CharSequence b(Context paramContext)
  {
    int i = R.string.dialog_448_message;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = String.valueOf(this.a);
    return paramContext.getString(i, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.dialog_448_title);
  }

  protected Intent c(Context paramContext)
  {
    return ViberActionRunner.ay.f(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.d.a.b.e
 * JD-Core Version:    0.6.2
 */