package com.viber.voip.model.entity;

import android.content.Context;
import android.text.TextUtils;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.a.a;
import com.viber.voip.model.b;
import com.viber.voip.model.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class g extends d
  implements b
{
  public static final Creator a = new com.viber.voip.contacts.b.a.d();
  private Set<k> F = new HashSet();
  private Map<Member, Boolean> G = new HashMap();
  private Map<String, Member> H = new HashMap();

  public Collection<k> a()
  {
    return this.F;
  }

  public void a(Context paramContext, a.a parama)
  {
    if (getId() > 0L)
    {
      super.a(paramContext, parama);
      return;
    }
    parama.a(new ArrayList(this.F));
  }

  public void a(k paramk, x paramx, c paramc)
  {
    boolean bool1 = true;
    String str = paramk.b();
    this.F.add(paramk);
    if (this.i == null)
      this.i = new TreeSet();
    this.i.add(str);
    if (this.k == null)
      this.k = new HashSet();
    this.k.add(str);
    if (this.j == null)
      this.j = new TreeMap();
    this.j.put(str, paramk);
    if ((paramx != null) && (!TextUtils.isEmpty(paramx.a())))
    {
      if (this.h == null)
        this.h = new d.a((TreeSet)null);
      this.h.a(paramx);
      this.H.put(str, Member.from(paramx));
      Map localMap2 = this.G;
      Member localMember2 = Member.from(paramx);
      if ((paramc != null) && (!TextUtils.isEmpty(paramc.a())));
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        localMap2.put(localMember2, Boolean.valueOf(bool2));
        return;
      }
    }
    this.H.put(str, null);
    Map localMap1 = this.G;
    Member localMember1 = Member.fromVln(str);
    if ((paramc != null) && (!TextUtils.isEmpty(paramc.a())));
    while (true)
    {
      localMap1.put(localMember1, Boolean.valueOf(bool1));
      return;
      bool1 = false;
    }
  }

  public String b()
  {
    j localj = n();
    String str = null;
    if (localj != null)
      str = localj.d();
    return str;
  }

  public Map<Member, Boolean> c()
  {
    return this.G;
  }

  public Map<String, Member> d()
  {
    return this.H;
  }

  public String toString()
  {
    return "ContactInfoEntityImpl [id=" + this.id + ", displayName=" + this.o + ", starred=" + this.r + ", viber=" + this.s + ", lookupKey=" + this.t + ", contactHash=" + this.u + ", hasNumbers=" + this.v + ", viberData=" + this.h + ", mBlockedNumbers=" + this.G + ", flags=" + this.A + "], " + super.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.g
 * JD-Core Version:    0.6.2
 */