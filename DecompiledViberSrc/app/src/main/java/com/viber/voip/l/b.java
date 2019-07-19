package com.viber.voip.l;

import android.content.Context;
import android.content.res.Resources;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;
import java.text.SimpleDateFormat;

public class b
{
  private static final Logger d = ViberEnv.getLogger();
  public final String a;
  public final String b;
  public final String c;
  private java.text.DateFormat e;
  private Context f;

  public b(Context paramContext)
  {
    this.f = paramContext;
    Resources localResources = this.f.getResources();
    this.a = localResources.getString(R.string.msg_today_txt);
    this.b = localResources.getString(R.string.msg_yesterday_txt);
    this.c = localResources.getString(R.string.liked_at);
  }

  public Context a()
  {
    return this.f;
  }

  public java.text.DateFormat b()
  {
    Object localObject = this.e;
    String str;
    if (localObject == null)
    {
      str = this.f.getResources().getString(R.string.forced_date_format).trim();
      if (!da.a(str))
        break label48;
    }
    label48: for (localObject = android.text.format.DateFormat.getDateFormat(this.f); ; localObject = new SimpleDateFormat(str))
    {
      this.e = ((java.text.DateFormat)localObject);
      return localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.l.b
 * JD-Core Version:    0.6.2
 */