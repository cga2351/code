package com.viber.voip.notif.b.a;

import android.content.Context;
import android.content.Intent;
import com.viber.jni.Engine;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.ae;
import com.viber.voip.util.p;

public class a extends b
{
  private final Engine a;
  private final long b;
  private final boolean c;
  private final boolean h;

  public a(Engine paramEngine, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramEngine;
    this.b = paramLong;
    this.c = paramBoolean1;
    this.h = paramBoolean2;
  }

  private int a(boolean paramBoolean)
  {
    if (paramBoolean)
      return R.drawable.status_hold;
    return R.drawable.status_call;
  }

  private String a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
      return paramContext.getString(R.string.on_hold);
    int i = R.string.call_notify_status_call;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ae.g(paramLong / 1000L);
    return paramContext.getString(i, arrayOfObject);
  }

  private String e()
  {
    CallInfo localCallInfo = this.a.getCurrentCall();
    if ((localCallInfo != null) && (localCallInfo.isCalling()))
    {
      CallerInfo localCallerInfo = localCallInfo.getCallerInfo();
      ConferenceInfo localConferenceInfo = localCallerInfo.getConferenceInfo();
      if (localConferenceInfo != null)
        return p.a(localConferenceInfo, false);
      return localCallerInfo.getName();
    }
    return "";
  }

  public int a()
  {
    return 201;
  }

  protected void a(Context paramContext, o paramo)
  {
    Intent localIntent = ViberActionRunner.r.a();
    n[] arrayOfn = new n[3];
    arrayOfn[0] = paramo.b(paramContext, a(), localIntent, 0);
    arrayOfn[1] = paramo.b(true);
    arrayOfn[2] = paramo.a(false);
    a(arrayOfn);
  }

  public int b()
  {
    return a(this.c);
  }

  public CharSequence b(Context paramContext)
  {
    if (this.h)
      return a(paramContext, this.b, this.c);
    int i = R.string.call_notify_status_call;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ae.g(0L);
    return paramContext.getString(i, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    return e();
  }

  public c d()
  {
    return c.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.a.a
 * JD-Core Version:    0.6.2
 */