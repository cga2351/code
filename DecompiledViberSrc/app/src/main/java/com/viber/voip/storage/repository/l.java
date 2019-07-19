package com.viber.voip.storage.repository;

import com.viber.provider.d;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.model.entity.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

class l extends j
  implements bv.n
{
  l(d<?> paramd)
  {
    super(paramd);
  }

  public void onChange(Set<Long> paramSet, Set<String> paramSet1, boolean paramBoolean)
  {
  }

  public void onContactStatusChanged(Map<Long, bv.n.a> paramMap)
  {
  }

  public void onInitCache()
  {
    this.b.l();
  }

  public void onNewInfo(List<m> paramList, boolean paramBoolean)
  {
  }

  public void onParticipantDeleted(m paramm)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.l
 * JD-Core Version:    0.6.2
 */