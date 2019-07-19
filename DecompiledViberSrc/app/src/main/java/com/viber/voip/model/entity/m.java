package com.viber.voip.model.entity;

import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.o;
import com.viber.voip.messages.orm.entity.impl.ParticipantInfoEntityHelper;
import com.viber.voip.model.g;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.dg;

public class m extends b
  implements o, g
{
  private static final Logger a = ViberEnv.getLogger();
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private long g;
  private String h;
  private String i;
  private String j;
  private int k;
  private long l;
  private int m;
  private long n;

  public static com.viber.voip.model.h a(final int paramInt, final boolean paramBoolean, m paramm)
  {
    return new com.viber.voip.model.h()
    {
      public int a()
      {
        return paramInt;
      }

      public String a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return dg.b(this.a, paramAnonymousInt1, paramAnonymousInt2);
      }

      public boolean c()
      {
        return paramBoolean;
      }

      public long d()
      {
        return this.a.getId();
      }

      public long g()
      {
        return this.a.i();
      }

      public String getContactName()
      {
        return this.a.getContactName();
      }

      public String getNumber()
      {
        return this.a.getNumber();
      }

      public String getViberName()
      {
        return this.a.getViberName();
      }

      public String h()
      {
        return this.a.a();
      }

      public boolean isOwner()
      {
        return this.a.isOwner();
      }

      public Uri j()
      {
        return cd.a(this.a);
      }

      public boolean n()
      {
        return this.a.q();
      }

      public String p()
      {
        return this.a.b();
      }

      public String toString()
      {
        return "groupRole=" + paramInt + ", " + this.a.toString();
      }
    };
  }

  public String a()
  {
    return this.d;
  }

  public String a(int paramInt1, int paramInt2)
  {
    return dg.a(this, paramInt1, paramInt2);
  }

  public String a(h paramh)
  {
    return dg.a(this, paramh.j(), paramh.p());
  }

  public String a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean);
    for (int i1 = 2; ; i1 = 1)
      return a(i1, paramInt);
  }

  public void a(int paramInt)
  {
    this.k = paramInt;
  }

  public void a(long paramLong)
  {
    this.g = paramLong;
  }

  public void a(Uri paramUri)
  {
    if (paramUri != null);
    for (String str = paramUri.toString(); ; str = "")
    {
      this.j = str;
      return;
    }
  }

  public void a(String paramString)
  {
    this.e = paramString;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m = av.a(this.m, 0);
      return;
    }
    this.m = av.b(this.m, 0);
  }

  public String b()
  {
    if (this.e == null)
      return "";
    return this.e;
  }

  public void b(int paramInt)
  {
    this.m = paramInt;
  }

  public void b(long paramLong)
  {
    this.l = paramLong;
  }

  public void b(String paramString)
  {
    this.f = paramString;
  }

  public String c()
  {
    return this.f;
  }

  public void c(long paramLong)
  {
    this.n = paramLong;
  }

  public void c(String paramString)
  {
    this.b = paramString;
  }

  public String d()
  {
    if (this.c == null)
      return "";
    return this.c;
  }

  public void d(String paramString)
  {
    this.d = paramString;
  }

  public String e()
  {
    if (this.j == null)
      return "";
    return this.j;
  }

  public void e(String paramString)
  {
    this.c = paramString;
  }

  public Uri f()
  {
    if (!TextUtils.isEmpty(e()))
      return Uri.parse(e());
    return null;
  }

  public void f(String paramString)
  {
    this.i = paramString;
  }

  public int g()
  {
    return this.k;
  }

  public void g(String paramString)
  {
    this.j = paramString;
  }

  public String getContactName()
  {
    return this.h;
  }

  public ContentValues getContentValues()
  {
    return ParticipantInfoEntityHelper.getContentValues(this);
  }

  public String getNumber()
  {
    return this.b;
  }

  public String getTable()
  {
    return "participants_info";
  }

  public String getViberName()
  {
    return this.i;
  }

  public void h(String paramString)
  {
    this.h = paramString;
  }

  public boolean h()
  {
    return 2 == g();
  }

  public long i()
  {
    return this.g;
  }

  public boolean isOwner()
  {
    return this.k == 0;
  }

  public boolean j()
  {
    return (!isOwner()) && (cd.a(this.g, this.m));
  }

  public boolean k()
  {
    return cd.i(this.m);
  }

  public long l()
  {
    return this.l;
  }

  public int m()
  {
    return this.m;
  }

  public long n()
  {
    return this.n;
  }

  public String o()
  {
    return a(1, 2);
  }

  public Uri p()
  {
    return cd.a(this);
  }

  public boolean q()
  {
    return av.c(this.m, 0);
  }

  public boolean r()
  {
    return com.viber.voip.messages.m.c(this.b);
  }

  public boolean s()
  {
    if ((TextUtils.isEmpty(this.b)) && (this.d != null) && (!this.d.equals(this.c)) && (!this.d.equals(this.e)));
    for (boolean bool = true; ; bool = false)
    {
      if (bool);
      return bool;
    }
  }

  public String toString()
  {
    return "ParticipantInfoEntity{id='" + getId() + '\'' + ", number='" + this.b + '\'' + ", encryptedPhoneNumber='" + this.c + '\'' + ", memberId='" + this.d + '\'' + ", encryptedMemberId='" + this.e + '\'' + ", viberId='" + this.f + '\'' + ", contactId=" + this.g + ", contactName='" + this.h + '\'' + ", viberName='" + this.i + '\'' + ", viberImage='" + this.j + '\'' + ", participantType=" + this.k + ", nativePhotoId=" + this.l + ", flags=" + this.m + ", lastUpdateTime=" + this.n + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.m
 * JD-Core Version:    0.6.2
 */