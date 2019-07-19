package com.viber.voip.contacts.c.d;

import com.viber.voip.memberid.Member;
import com.viber.voip.model.a;
import com.viber.voip.model.entity.g;
import com.viber.voip.model.entity.x;
import com.viber.voip.model.j;
import com.viber.voip.shareviber.invitescreen.b.i;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface m
{
  public abstract g a(String paramString);

  public abstract Set<String> a();

  public abstract Set<a> a(Member paramMember);

  public abstract Set<a> a(Set<Member> paramSet);

  public abstract void a(int paramInt, d paramd);

  public abstract void a(long paramLong, a parama);

  public abstract void a(long paramLong, String paramString, j.c paramc);

  public abstract void a(a parama);

  public abstract void a(String paramString, long paramLong, a parama);

  public abstract void a(String paramString, b paramb);

  public abstract void a(Set<String> paramSet, c paramc);

  public abstract void a(Set<String> paramSet1, Set<String> paramSet2, e parame);

  public abstract a b(String paramString);

  public abstract Collection<a> b(Member paramMember);

  public abstract Map<String, a> b(Set<Member> paramSet);

  public abstract Set<x> b();

  public abstract g c(Member paramMember);

  public abstract List<com.viber.voip.engagement.d.m> c();

  public abstract Set<a> c(String paramString);

  public abstract List<i> d();

  public abstract int e();

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, a parama);
  }

  public static abstract interface b
  {
    public abstract void a(String paramString, Set<a> paramSet);
  }

  public static abstract interface c
  {
    public abstract void a(Map<String, List<a>> paramMap, Map<Long, a> paramMap1);
  }

  public static abstract interface d
  {
    public abstract void a(Set<a> paramSet);
  }

  public static abstract interface e
  {
    public abstract void a(Set<j> paramSet);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.m
 * JD-Core Version:    0.6.2
 */