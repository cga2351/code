package com.viber.voip.contacts.c.d;

import android.accounts.Account;
import android.content.ContentProviderResult;
import android.graphics.Bitmap;
import com.viber.voip.contacts.c.a.a;
import com.viber.voip.contacts.c.f.b.c;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.entity.x;
import com.viber.voip.model.i;
import java.util.Map;
import java.util.Set;

public abstract interface g
{
  public abstract void a();

  public abstract void a(long paramLong);

  public abstract void a(long paramLong, String paramString);

  public abstract void a(long paramLong, String paramString, boolean paramBoolean);

  public abstract void a(Account paramAccount, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, h paramh);

  public abstract void a(a parama);

  public abstract void a(b paramb);

  public abstract void a(c paramc);

  public abstract void a(d paramd);

  public abstract void a(f paramf);

  public abstract void a(i parami);

  public abstract void a(s params, a parama);

  public abstract void a(Member paramMember);

  public abstract void a(Set<x> paramSet);

  public abstract void b();

  public abstract void b(b paramb);

  public abstract void b(c paramc);

  public abstract void b(f paramf);

  @Deprecated
  public abstract m c();

  public abstract c d();

  public abstract n e();

  public abstract a f();

  public abstract void g();

  public abstract com.viber.voip.contacts.adapters.b h();

  public abstract void i();

  public abstract void j();

  public static abstract interface a
  {
    public abstract void a(com.viber.voip.model.b paramb, int paramInt);
  }

  public static abstract interface b
  {
    public abstract void a();
  }

  public static abstract interface c
  {
    public abstract void b(int paramInt);

    public abstract void c_(int paramInt);

    public abstract void d();
  }

  public static abstract interface d
  {
    public abstract void a(Map<Long, Long> paramMap, Set<Long> paramSet);

    public abstract void a(Set<Long> paramSet);
  }

  public static abstract interface e
  {
    public abstract void a(int paramInt, Set<i> paramSet);
  }

  public static abstract interface f
  {
    public abstract void a(Map<String, Long> paramMap);
  }

  public static enum g
  {
    static
    {
      g[] arrayOfg = new g[3];
      arrayOfg[0] = a;
      arrayOfg[1] = b;
      arrayOfg[2] = c;
    }
  }

  public static abstract interface h
  {
    public abstract void a(Exception paramException);

    public abstract void a(ContentProviderResult[] paramArrayOfContentProviderResult);
  }

  public static abstract interface i
  {
    public abstract void a(Map<Member, com.viber.voip.contacts.c.f.b.g.a> paramMap);

    public abstract void a(Set<Member> paramSet1, Set<Member> paramSet2, Set<Member> paramSet3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.g
 * JD-Core Version:    0.6.2
 */