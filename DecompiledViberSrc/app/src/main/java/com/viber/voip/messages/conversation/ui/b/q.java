package com.viber.voip.messages.conversation.ui.b;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

public class q
{
  private final Set<s> a = new HashSet();

  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((s)localIterator.next()).a();
  }

  public void a(s params)
  {
    this.a.add(params);
  }

  public void b(s params)
  {
    this.a.remove(params);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.q
 * JD-Core Version:    0.6.2
 */