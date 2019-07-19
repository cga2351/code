package com.viber.voip.messages.conversation.a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

abstract class a
  implements h
{
  private Set<h.a> b;

  final void a()
  {
    if (this.b == null);
    while (true)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        ((h.a)localIterator.next()).G();
    }
  }

  public void a(h.a parama)
  {
    if (this.b == null)
      this.b = new HashSet(1);
    this.b.add(parama);
    if (1 == this.b.size())
      b();
  }

  protected void b()
  {
  }

  public void b(h.a parama)
  {
    if (this.b == null);
    do
    {
      return;
      this.b.remove(parama);
    }
    while (!this.b.isEmpty());
    c();
  }

  protected void c()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.a.a
 * JD-Core Version:    0.6.2
 */