package com.viber.voip.notif.b.f.a;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.messages.m;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.h.c;
import com.viber.voip.util.ca;
import com.viber.voip.util.da;

public class b extends com.viber.voip.notif.b.b
{
  private final c a;
  private final String b;

  public b(c paramc, String paramString)
  {
    this.a = paramc;
    this.b = da.d(paramString);
  }

  private Intent e()
  {
    return m.a(this.a.a(), 0L, 0L, this.a.b(), null, null, 5, null, null, this.a.c(), 0, false, true, false, false, false);
  }

  public String R_()
  {
    return "you_joined_as_member";
  }

  public int a()
  {
    return (int)this.a.a();
  }

  protected void a(Context paramContext, o paramo)
  {
    int i = (int)this.a.a();
    Intent localIntent = e();
    n[] arrayOfn = new n[2];
    arrayOfn[0] = paramo.b(paramContext, i, localIntent, 134217728);
    arrayOfn[1] = paramo.b("msg");
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    int i = R.string.invited_you_to_community_title;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b;
    return Html.fromHtml(paramContext.getString(i, arrayOfObject));
  }

  public CharSequence b_(Context paramContext)
  {
    return ca.a(this.a.c(), "");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.a.b
 * JD-Core Version:    0.6.2
 */