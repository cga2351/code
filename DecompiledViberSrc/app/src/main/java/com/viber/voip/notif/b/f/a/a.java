package com.viber.voip.notif.b.f.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.m;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.h;
import com.viber.voip.notif.h.d;
import com.viber.voip.util.ViberActionRunner.am;

public class a extends b
{
  private final d a;
  private final com.viber.voip.notif.b.f.b.e b;

  public a(d paramd, com.viber.voip.notif.b.f.b.e parame)
  {
    this.a = paramd;
    this.b = parame;
  }

  private Intent e()
  {
    return m.a(this.a.a(), 0L, 0L, this.a.b(), null, null, 5, null, null, this.a.d(), this.a.f(), false, true, false, false, false);
  }

  public String R_()
  {
    return "community_message";
  }

  public int a()
  {
    return (int)this.a.a();
  }

  protected void a(Context paramContext, o paramo)
  {
    int i = (int)this.a.a();
    Intent localIntent = e();
    n[] arrayOfn = new n[3];
    arrayOfn[0] = paramo.b(paramContext, i, localIntent, 134217728);
    arrayOfn[1] = paramo.a(paramContext, this.a.hashCode(), ViberActionRunner.am.a(paramContext, this.a.c(), this.a.a(), this.a.l()), 134217728);
    arrayOfn[2] = paramo.b("msg");
    a(arrayOfn);
  }

  protected void a(Context paramContext, o paramo, com.viber.voip.notif.f.e parame)
  {
    if (TextUtils.isEmpty(this.a.e()));
    for (Uri localUri = null; ; localUri = Uri.parse(this.a.e()))
    {
      a(paramo.a(((h)parame.a(2)).a(localUri, R.drawable.ic_community_default)));
      return;
    }
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return this.b.b();
  }

  public CharSequence b_(Context paramContext)
  {
    return this.b.a();
  }

  public c d()
  {
    return c.a;
  }

  public String toString()
  {
    return "CommunityMessageCreator{mItem=" + this.a + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.a.a
 * JD-Core Version:    0.6.2
 */