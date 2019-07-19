package com.viber.voip.shareviber.invitescreen.b;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.memberid.Member;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class e
{
  private static final Logger a = ViberEnv.getLogger();
  private final Member b;
  private final m c;

  public e(Member paramMember, m paramm)
  {
    this.b = paramMember;
    this.c = paramm;
  }

  private List<i> a(List<i> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.w() != null)
        localArrayList.add(locali);
    }
    return localArrayList;
  }

  public h a()
  {
    return h.a(a(this.c.d()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.e
 * JD-Core Version:    0.6.2
 */