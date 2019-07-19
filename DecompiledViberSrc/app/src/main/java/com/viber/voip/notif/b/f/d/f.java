package com.viber.voip.notif.b.f.d;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.c.t;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;

public class f extends d
{
  private final String h;
  private final String i;

  public f(m paramm, String paramString1, String paramString2)
  {
    super(paramm);
    this.h = paramString1;
    this.i = paramString2;
  }

  private CharSequence i(Context paramContext)
  {
    if (this.a.c().isPublicGroupBehavior())
    {
      int k = R.string.message_notification_group_renamed_full_ticker;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = this.h;
      arrayOfObject2[1] = this.i;
      arrayOfObject2[2] = this.c;
      return paramContext.getString(k, arrayOfObject2);
    }
    int j = R.string.message_notification_group_renamed_full_ticker;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = b_(paramContext);
    arrayOfObject1[1] = this.i;
    arrayOfObject1[2] = this.c;
    return paramContext.getString(j, arrayOfObject1);
  }

  public String R_()
  {
    return "rename";
  }

  protected t b(Context paramContext, o paramo)
  {
    return paramo.b(i(paramContext));
  }

  public CharSequence b(Context paramContext)
  {
    if (this.a.c().isPublicGroupBehavior())
    {
      int k = R.string.message_notification_public_group_renamed_full;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = this.h;
      arrayOfObject2[1] = this.i;
      arrayOfObject2[2] = this.c;
      return paramContext.getString(k, arrayOfObject2);
    }
    int j = R.string.message_notification_group_renamed_full;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.i;
    arrayOfObject1[1] = this.c;
    return paramContext.getString(j, arrayOfObject1);
  }

  public CharSequence b_(Context paramContext)
  {
    if (this.a.c().isPublicGroupBehavior())
      return paramContext.getString(R.string.message_notification_group_renamed);
    return dg.b(this.h);
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getString(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.f
 * JD-Core Version:    0.6.2
 */