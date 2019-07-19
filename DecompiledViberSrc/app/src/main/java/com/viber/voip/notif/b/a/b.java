package com.viber.voip.notif.b.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.p;

public class b extends com.viber.voip.notif.b.b
{
  private final String a;
  private final String b;
  private final boolean c;
  private final ConferenceInfo h;
  private final int i;

  public b(String paramString1, String paramString2, boolean paramBoolean, ConferenceInfo paramConferenceInfo, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.h = paramConferenceInfo;
    this.i = paramInt;
  }

  private CharSequence c(Context paramContext)
  {
    switch (this.i)
    {
    default:
      return "";
    case 0:
      if (this.c);
      for (int j = R.string.call_notify_status_incoming_viber_in; ; j = R.string.call_notify_status_incoming)
        return paramContext.getString(j);
    case 1:
    }
    return paramContext.getString(R.string.call_notify_status_outgoing);
  }

  public int a()
  {
    return 201;
  }

  protected void a(Context paramContext, o paramo)
  {
    Intent localIntent = ViberActionRunner.r.a();
    a(paramo.b(paramContext, a(), localIntent, 0));
    a(paramo.b(true));
    a(paramo.a(false));
    if (this.i == 0)
    {
      a(paramo.c("tel:" + this.b));
      a(paramo.b("call"));
    }
  }

  public int b()
  {
    if (this.i == 0)
      return R.drawable.ic_incoming_call;
    return R.drawable.ic_outgoing_call;
  }

  public CharSequence b(Context paramContext)
  {
    return c(paramContext);
  }

  public CharSequence b_(Context paramContext)
  {
    if (this.h != null)
      return p.a(this.h, false);
    return this.a;
  }

  public c d()
  {
    return c.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.a.b
 * JD-Core Version:    0.6.2
 */