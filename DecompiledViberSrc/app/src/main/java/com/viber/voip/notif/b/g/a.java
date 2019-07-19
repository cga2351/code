package com.viber.voip.notif.b.g;

import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.entity.q;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.aq;

public class a extends b
{
  private static final Logger a = ViberEnv.getLogger();
  private final q b;
  private final boolean c;
  private String h;
  private String i;

  public a(q paramq, boolean paramBoolean)
  {
    this.b = paramq;
    this.c = paramBoolean;
  }

  private String a(q paramq, Context paramContext)
  {
    switch (paramq.d)
    {
    default:
      if (this.c)
        throw new IllegalArgumentException("getPublicAccountAttributeName unknown attribute : " + paramq.d);
      break;
    case 1:
      return paramContext.getString(R.string.public_account_updated_info_button);
    case 3:
      return paramContext.getString(R.string.public_account_updated_1_on_1_chat);
    case 2:
      return paramContext.getString(R.string.public_account_updated_public_chat);
    }
    return "";
  }

  private CharSequence c(Context paramContext)
  {
    if (this.h == null)
    {
      int j = R.string.public_account_updated_notification_title;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b.c;
      this.h = com.viber.common.d.c.a(paramContext, j, arrayOfObject);
    }
    return this.h;
  }

  private CharSequence h(Context paramContext)
  {
    if (this.i == null)
      if (!this.b.e)
        break label53;
    label53: for (int j = R.string.public_account_updated_notification_removed_body; ; j = R.string.public_account_updated_notification_added_body)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a(this.b, paramContext);
      this.i = com.viber.common.d.c.a(paramContext, j, arrayOfObject);
      return this.i;
    }
  }

  public String R_()
  {
    return "update_pa" + this.b.d;
  }

  public int a()
  {
    return (int)this.b.a;
  }

  protected void a(Context paramContext, o paramo)
  {
    Intent localIntent = ViberActionRunner.aq.c(paramContext, this.b.b);
    n[] arrayOfn = new n[2];
    arrayOfn[0] = paramo.b(paramContext, -200, localIntent, 134217728);
    arrayOfn[1] = paramo.b(b_(paramContext));
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return h(paramContext);
  }

  public CharSequence b_(Context paramContext)
  {
    return c(paramContext);
  }

  public com.viber.voip.notif.c d()
  {
    return com.viber.voip.notif.c.a;
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.g.a
 * JD-Core Version:    0.6.2
 */