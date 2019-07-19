package com.viber.voip.shareviber.invitescreen.b;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class g
{
  private static final Logger a = ViberEnv.getLogger();
  private final e b;
  private final d c;
  private final List<j> d;

  public g(e parame, d paramd, j[] paramArrayOfj)
  {
    this.b = parame;
    this.c = paramd;
    this.d = Arrays.asList(paramArrayOfj);
  }

  public List<a> a()
  {
    h localh = this.b.a();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      ((j)localIterator.next()).a(localh);
    return this.c.a(localh);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.g
 * JD-Core Version:    0.6.2
 */