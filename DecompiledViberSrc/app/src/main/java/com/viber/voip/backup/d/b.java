package com.viber.voip.backup.d;

import com.viber.voip.backup.d.a.a.a;
import com.viber.voip.backup.d.a.a.c;
import com.viber.voip.backup.o;
import com.viber.voip.backup.r;
import java.util.Iterator;
import java.util.List;

public class b extends com.viber.voip.backup.i<h, e>
{
  public b(int paramInt, r paramr, com.viber.voip.backup.d.a.b paramb)
  {
    super(paramr);
    a(paramb);
    b(paramInt);
  }

  private void a(com.viber.voip.backup.d.a.b paramb)
  {
    a(paramb.a());
    b(paramb.b());
  }

  private void a(List<c> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        ((h)localIterator.next()).a(paramList);
    }
  }

  private void b(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((h)localIterator.next()).a(paramInt);
  }

  private void b(List<a> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        ((h)localIterator.next()).b(paramList);
    }
  }

  protected int a(e parame, List<h> paramList)
    throws com.viber.voip.backup.c.d
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((h)localIterator.next()).f();
    return i;
  }

  protected void a(int paramInt)
    throws com.viber.voip.backup.c.d
  {
    if (paramInt == 0)
      throw new com.viber.voip.backup.c.f();
  }

  protected void a(e parame)
    throws com.viber.voip.backup.c.d
  {
    parame.d();
  }

  protected void a(h paramh, e parame)
    throws com.viber.voip.backup.c.d
  {
    paramh.a(parame);
  }

  protected void a(List<h> paramList, o paramo)
  {
    g localg = new g(paramo);
    f localf = new f(paramo);
    long l = System.currentTimeMillis() - 1209600000L;
    localg.a(new i(10240, l));
    localf.a(new i(10240, l));
    paramList.add(localg);
    paramList.add(localf);
  }

  protected e b(String paramString1, String paramString2)
    throws com.viber.voip.backup.c.d
  {
    return new e(paramString1, paramString2, false, com.viber.voip.memberid.d.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.b
 * JD-Core Version:    0.6.2
 */