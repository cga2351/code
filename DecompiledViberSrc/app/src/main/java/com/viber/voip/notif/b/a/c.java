package com.viber.voip.notif.b.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.p;

public class c extends b
{
  private final String a;
  private final String b;
  private final boolean c;
  private final boolean h;
  private final boolean i;
  private final ConferenceInfo j;

  public c(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ConferenceInfo paramConferenceInfo)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean1;
    this.h = paramBoolean2;
    this.i = paramBoolean3;
    this.j = paramConferenceInfo;
  }

  private CharSequence c(Context paramContext)
  {
    if (this.c);
    for (int k = R.string.call_notify_status_incoming_viber_in; ; k = R.string.call_notify_status_incoming)
      return paramContext.getString(k);
  }

  public int a()
  {
    return 203;
  }

  protected void a(Context paramContext, g paramg)
  {
    a(paramg.a());
    boolean bool1 = this.h;
    if (this.j != null);
    for (boolean bool2 = true; ; bool2 = false)
    {
      a(paramg.a(bool1, bool2));
      return;
    }
  }

  protected void a(Context paramContext, o paramo)
  {
    Intent localIntent = ViberActionRunner.r.a(paramContext, this.i);
    a(paramo.b(paramContext, a(), localIntent, 134217728));
    a(paramo.b(true));
    a(paramo.a(false));
    a(paramo.c("tel:" + this.b));
    a(paramo.b("call"));
    a(paramo.a(paramContext, a(), localIntent, 134217728, true));
  }

  public int b()
  {
    return R.drawable.ic_incoming_call;
  }

  public CharSequence b(Context paramContext)
  {
    return c(paramContext);
  }

  public CharSequence b_(Context paramContext)
  {
    if (this.j != null)
      return p.a(this.j, false);
    return this.a;
  }

  public com.viber.voip.notif.c d()
  {
    return com.viber.voip.notif.c.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.a.c
 * JD-Core Version:    0.6.2
 */