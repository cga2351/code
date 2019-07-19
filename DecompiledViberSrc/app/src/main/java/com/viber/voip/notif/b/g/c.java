package com.viber.voip.notif.b.g;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.e;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.bl;

public class c extends b
{
  private static final Logger a = ViberEnv.getLogger();
  private final String b;
  private final String c;
  private final String h;
  private final String i;
  private Uri j;

  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.h = paramString3;
    this.i = paramString4;
  }

  private com.viber.voip.notif.c.h b(Context paramContext, o paramo)
  {
    if (TextUtils.isEmpty(this.h));
    Intent localIntent;
    do
    {
      return null;
      localIntent = ViberActionRunner.bl.a(this.h);
    }
    while (!ViberActionRunner.a(localIntent, paramContext));
    return paramo.b(paramContext, 0, localIntent, 268435456);
  }

  private Uri e()
  {
    if (this.j == null)
      if (TextUtils.isEmpty(this.i))
        break label35;
    label35: for (Uri localUri = Uri.parse(this.i); ; localUri = null)
    {
      this.j = localUri;
      return this.j;
    }
  }

  public int a()
  {
    return -120;
  }

  protected void a(Context paramContext, o paramo)
  {
    a(paramo.a(this.b, this.c));
    com.viber.voip.notif.c.h localh = b(paramContext, paramo);
    if (localh != null)
      a(localh);
  }

  protected void a(Context paramContext, o paramo, e parame)
  {
    com.viber.voip.notif.f.h localh = (com.viber.voip.notif.f.h)parame.a(2);
    n[] arrayOfn = new n[1];
    arrayOfn[0] = paramo.a(localh.a(e(), null, R.drawable.icon_viber_message, R.drawable.ic_wear_system_message));
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return this.c;
  }

  public CharSequence b_(Context paramContext)
  {
    return this.b;
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.g.c
 * JD-Core Version:    0.6.2
 */