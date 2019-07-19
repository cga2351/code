package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.a;

public class c extends f
{
  private final a c;

  c(Member paramMember, a parama)
  {
    super(paramMember, null);
    this.c = parama;
  }

  protected Intent a(Context paramContext)
  {
    Intent localIntent = super.a(paramContext);
    localIntent.putExtra("contact_id", this.c.getId());
    return localIntent;
  }

  protected Intent b(Context paramContext)
  {
    Intent localIntent = super.b(paramContext);
    localIntent.putExtra("contact_id", this.c.getId());
    return localIntent;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.c
 * JD-Core Version:    0.6.2
 */