package com.e.a.a;

import java.util.Collections;
import java.util.Set;

class c
{
  private Set<String> a = Collections.emptySet();

  public void a(Set<String> paramSet)
  {
    if (paramSet == null)
    {
      this.a = Collections.emptySet();
      return;
    }
    this.a = paramSet;
  }

  public boolean a(com.e.a.c paramc)
  {
    Set localSet = paramc.c();
    if ((localSet == null) || (localSet.isEmpty()));
    while ((this.a != null) && (this.a.containsAll(localSet)))
      return true;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.a.c
 * JD-Core Version:    0.6.2
 */