package com.viber.voip.contacts.c.d.b;

import android.content.Context;
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
import java.util.Map.Entry;
import java.util.Set;

public class a
  implements f
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private Map<g.a, a> c = new HashMap();

  public a(Context paramContext, j paramj)
  {
    this.b = paramContext;
  }

  public void a()
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a())
        locala.b();
    }
  }

  public void a(g.a parama)
  {
    try
    {
      this.c.remove(parama);
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
    a locala = new a(this.b, parama, params.a(), params.c(), params.d(), params.e());
    this.c.put(parama, locala);
    locala.b();
  }

  public void a(Set<Member> paramSet1, Set<Member> paramSet2, Set<Member> paramSet3)
  {
    try
    {
      Iterator localIterator = this.c.values().iterator();
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

  private class a extends r
  {
    private long d = -1L;

    public a(Context parama, g.a paramLong, long arg4, String paramString2, String paramBoolean, boolean arg8)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 12	com/viber/voip/contacts/c/d/b/a$a:c	Lcom/viber/voip/contacts/c/d/b/a;
      //   5: aload_0
      //   6: aload_2
      //   7: aload_3
      //   8: aload 6
      //   10: aload 7
      //   12: iload 8
      //   14: invokespecial 15	com/viber/voip/contacts/c/d/r:<init>	(Landroid/content/Context;Lcom/viber/voip/contacts/c/d/g$a;Ljava/lang/String;Ljava/lang/String;Z)V
      //   17: aload_0
      //   18: ldc2_w 16
      //   21: putfield 19	com/viber/voip/contacts/c/d/b/a$a:d	J
      //   24: lconst_0
      //   25: lload 4
      //   27: lcmp
      //   28: ifne +8 -> 36
      //   31: ldc2_w 16
      //   34: lstore 4
      //   36: aload_0
      //   37: lload 4
      //   39: putfield 19	com/viber/voip/contacts/c/d/b/a$a:d	J
      //   42: return
    }

    protected g e()
    {
      boolean bool = this.d < -1L;
      Object localObject = null;
      if (bool)
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(this.d);
        g localg = a("phonebookcontact._id=?", arrayOfString);
        if (localg != null)
        {
          Map localMap = localg.d();
          if (localMap.size() > 0)
          {
            Map.Entry localEntry = (Map.Entry)localMap.entrySet().iterator().next();
            this.a = ((String)localEntry.getKey());
            Member localMember = (Member)localEntry.getValue();
            if (localMember != null)
              this.b = localMember.getId();
          }
        }
        this.d = -1L;
        localObject = localg;
      }
      return localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.b.a
 * JD-Core Version:    0.6.2
 */