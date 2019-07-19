package com.viber.voip.notif.b.b;

import android.content.Context;
import android.content.Intent;
import com.viber.common.d.c;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.m;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.e;
import com.viber.voip.notif.f.h;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.da;

public class a extends b
{
  private final com.viber.voip.model.a a;
  private final Member b;
  private final int c;

  public a(com.viber.voip.model.a parama, Member paramMember, int paramInt)
  {
    this.a = parama;
    this.b = paramMember;
    this.c = paramInt;
  }

  private String a(Context paramContext, String paramString)
  {
    return c.a(paramContext, e(), new Object[] { paramString });
  }

  private n b(Context paramContext, o paramo)
  {
    switch (this.c)
    {
    case 3:
    default:
    case 2:
    case 4:
    }
    for (Intent localIntent = ViberActionRunner.o.a(false, this.a.getId(), this.a.k(), this.a.q(), this.a.o(), this.b.getPhoneNumber(), this.b.getPhoneNumber(), this.b.getId()); ; localIntent = m.a(0L, 0L, this.b.getId(), this.b.getPhoneNumber(), 0, this.a.k(), true, false, false, false, false))
      return paramo.b(paramContext, a(), localIntent, 134217728);
  }

  private int e()
  {
    switch (this.c)
    {
    default:
      return R.string.push_notification_joined;
    case 4:
      return R.string.user_engagement_back_preview_text;
    case 2:
      return R.string.user_engagement_new_preview_text;
    case 3:
    }
    return R.string.push_notification_user_engagement_without_offer_v1;
  }

  public String R_()
  {
    return "recent_contact";
  }

  public int a()
  {
    return (int)this.a.getId();
  }

  protected void a(Context paramContext, g paramg)
  {
    String str = this.b.getPhoneNumber();
    if (!da.a(str))
    {
      com.viber.voip.notif.a.a.a[] arrayOfa = new com.viber.voip.notif.a.a.a[2];
      arrayOfa[0] = paramg.a(this.b, this.a);
      arrayOfa[1] = paramg.b(this.a.getId(), str, false);
      a(arrayOfa);
    }
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[1];
    arrayOfn[0] = b(paramContext, paramo);
    a(arrayOfn);
  }

  protected void a(Context paramContext, o paramo, e parame)
  {
    h localh = (h)parame.a(2);
    n[] arrayOfn = new n[1];
    arrayOfn[0] = paramo.a(localh.a(this.a.o(), this.a.k(), R.drawable.generic_image_thirty_x_thirty));
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return a(paramContext, this.a.k());
  }

  public CharSequence b_(Context paramContext)
  {
    return c.a(this.a.k());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.b.a
 * JD-Core Version:    0.6.2
 */