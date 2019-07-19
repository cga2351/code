package com.viber.voip.notif.b.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.viber.voip.R.string;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.j;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.registration.af;
import dagger.a;
import java.util.Arrays;

public class h extends d
{
  private final a<b> h;
  private final af i;
  private final String[] j;
  private CharSequence k;

  public h(com.viber.voip.notif.h.m paramm, a<b> parama, af paramaf, String[] paramArrayOfString)
  {
    super(paramm);
    this.h = parama;
    this.i = paramaf;
    this.j = paramArrayOfString;
  }

  public String R_()
  {
    return "removed_from_group";
  }

  public CharSequence b(Context paramContext)
  {
    if (this.k == null)
      this.k = i(paramContext);
    return this.k.toString();
  }

  CharSequence i(Context paramContext)
  {
    int m = this.a.e().j();
    int n = this.a.e().p();
    String str1 = j.j(this.j[0]);
    String str2 = a(this.i, this.h, paramContext, str1, m, n);
    String[] arrayOfString = (String[])Arrays.copyOfRange(this.j, 1, this.j.length);
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      arrayOfString[i1] = j.j(arrayOfString[i1]);
    if ((arrayOfString.length == 1) && (com.viber.voip.messages.m.a(this.i, arrayOfString[0])))
      return paramContext.getString(R.string.message_notification_group_removed_you, new Object[] { str2 });
    if ((arrayOfString.length == 1) && (com.viber.voip.messages.m.a(this.i, str1)))
      return paramContext.getString(R.string.message_notification_group_you_removed, new Object[] { str2 });
    for (int i2 = 0; i2 < arrayOfString.length; i2++)
      arrayOfString[i2] = a(this.i, this.h, paramContext, arrayOfString[i2], m, n);
    int i3 = R.string.message_notification_group_removed_member;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str2;
    arrayOfObject[1] = TextUtils.join(", ", arrayOfString);
    return paramContext.getString(i3, arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.h
 * JD-Core Version:    0.6.2
 */