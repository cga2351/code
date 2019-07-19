package com.viber.voip.model;

import com.viber.voip.memberid.Member;
import com.viber.voip.model.entity.k;
import java.util.Collection;
import java.util.Map;

public abstract interface b extends a
{
  public abstract Collection<k> a();

  public abstract String b();

  public abstract Map<Member, Boolean> c();

  public abstract Map<String, Member> d();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.b
 * JD-Core Version:    0.6.2
 */