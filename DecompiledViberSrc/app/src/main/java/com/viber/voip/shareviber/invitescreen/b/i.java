package com.viber.voip.shareviber.invitescreen.b;

import android.database.Cursor;
import android.telephony.PhoneNumberUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.b.a.b;
import com.viber.voip.contacts.b.a.g;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.entity.e;
import com.viber.voip.model.f;

public class i extends com.viber.voip.model.entity.d
{
  private static final Logger F = ViberEnv.getLogger();
  private static final b G = new b()
  {
    public e a()
    {
      return new i();
    }
  };
  public static final a a = new a(null);
  private int H;

  public static String a(long paramLong, String paramString)
  {
    return String.valueOf(paramLong) + "/" + PhoneNumberUtils.stripSeparators(paramString);
  }

  public int a()
  {
    return this.H;
  }

  void a(int paramInt)
  {
    this.H = (paramInt + this.H);
  }

  public a b()
  {
    return a;
  }

  public String c()
  {
    long l = getId();
    if (w() != null);
    for (String str = w().a(); ; str = null)
      return a(l, str);
  }

  public String toString()
  {
    return super.toString() + " SingleNumberSuggestedContactEntity{id=" + this.id + ", mScore=" + this.H + ", uniqueKey=" + c() + '}';
  }

  private static final class a extends g
  {
    protected Creator b()
    {
      return i.d();
    }

    public i c()
    {
      return new i();
    }

    public com.viber.voip.model.d createInstance(Cursor paramCursor)
    {
      return createInstance(paramCursor, 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.i
 * JD-Core Version:    0.6.2
 */