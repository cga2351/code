package com.viber.voip.contacts.c.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.f;
import com.viber.voip.contacts.c.d.g.a;
import com.viber.voip.contacts.c.d.j;
import com.viber.voip.contacts.c.d.r;
import com.viber.voip.contacts.c.d.s;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.entity.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a
  implements f
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final j c;
  private final Map<g.a, a> d = new HashMap();

  public a(Context paramContext, j paramj)
  {
    this.b = paramContext;
    this.c = paramj;
  }

  public void a()
  {
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).b();
  }

  public void a(g.a parama)
  {
    try
    {
      this.d.remove(parama);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(s params, g.a parama)
  {
    a locala = new a(this.b, parama, params.a(), params.b(), params.c(), params.d(), params.e());
    this.d.put(parama, locala);
    locala.b();
  }

  public void a(Map<String, Long> paramMap)
  {
    try
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a())
          locala.a(paramMap);
      }
    }
    finally
    {
    }
  }

  public void a(Map<Long, Long> paramMap, Set<Long> paramSet)
  {
    try
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        Long localLong = (Long)paramMap.get(Long.valueOf(a.a(locala)));
        if (localLong != null)
          locala.a(localLong.longValue());
      }
    }
    finally
    {
    }
    a(paramSet);
  }

  public void a(Set<Long> paramSet)
  {
    try
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a())
          locala.a(paramSet);
      }
    }
    finally
    {
    }
  }

  public void a(Set<Member> paramSet1, Set<Member> paramSet2, Set<Member> paramSet3)
  {
    try
    {
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a())
          locala.b();
      }
    }
    finally
    {
    }
  }

  public void b()
  {
    try
    {
      a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private class a extends r
  {
    private long d = -1L;
    private String e;

    a(Context parama, g.a paramLong, long arg4, String paramString2, String paramString3, String paramBoolean, boolean arg9)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 14	com/viber/voip/contacts/c/d/a/a$a:c	Lcom/viber/voip/contacts/c/d/a/a;
      //   5: aload_0
      //   6: aload_2
      //   7: aload_3
      //   8: aload 7
      //   10: aload 8
      //   12: iload 9
      //   14: invokespecial 17	com/viber/voip/contacts/c/d/r:<init>	(Landroid/content/Context;Lcom/viber/voip/contacts/c/d/g$a;Ljava/lang/String;Ljava/lang/String;Z)V
      //   17: aload_0
      //   18: ldc2_w 18
      //   21: putfield 21	com/viber/voip/contacts/c/d/a/a$a:d	J
      //   24: lconst_0
      //   25: lload 4
      //   27: lcmp
      //   28: ifne +8 -> 36
      //   31: ldc2_w 18
      //   34: lstore 4
      //   36: aload_0
      //   37: lload 4
      //   39: putfield 21	com/viber/voip/contacts/c/d/a/a$a:d	J
      //   42: aload_0
      //   43: aload 6
      //   45: putfield 23	com/viber/voip/contacts/c/d/a/a$a:e	Ljava/lang/String;
      //   48: return
    }

    private g f()
    {
      boolean bool = this.d < -1L;
      g localg = null;
      if (bool)
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(this.d);
        localg = a("phonebookcontact._id=?", arrayOfString);
      }
      return localg;
    }

    private g g()
    {
      boolean bool = TextUtils.isEmpty(this.e);
      g localg = null;
      if (!bool)
        localg = a("phonebookcontact.contact_lookup_key LIKE '%" + this.e + "%'", new String[0]);
      return localg;
    }

    void a(long paramLong)
    {
      this.d = paramLong;
      this.a = null;
      this.b = null;
    }

    void a(Map<String, Long> paramMap)
    {
      if (this.d == -1L)
      {
        Long localLong = (Long)paramMap.get(this.a);
        if (localLong != null)
        {
          this.d = localLong.longValue();
          b();
        }
      }
    }

    void a(Set<Long> paramSet)
    {
      if (paramSet.contains(Long.valueOf(this.d)))
        b();
    }

    protected g e()
    {
      g localg = f();
      if (localg == null)
      {
        localg = g();
        if (localg != null)
        {
          this.d = localg.getId();
          this.e = localg.q();
        }
      }
      return localg;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.a.a
 * JD-Core Version:    0.6.2
 */