package com.viber.voip.messages.conversation.ui.b;

import com.viber.voip.messages.conversation.ac;
import com.viber.voip.model.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class n
  implements o
{
  private final o a;
  private int b = 0;
  private final List<o> c = new ArrayList();

  public n(o paramo)
  {
    this.a = paramo;
  }

  public int a()
  {
    return this.b;
  }

  public void a(ac paramac, boolean paramBoolean)
  {
    this.b = paramac.getCount();
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((o)this.c.get(j)).a(paramac, paramBoolean);
    this.a.a(paramac, paramBoolean);
  }

  public void a(o paramo)
  {
    this.c.add(paramo);
  }

  public void a(h paramh)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      ((o)localIterator.next()).b(paramh);
  }

  public void b(o paramo)
  {
    this.c.remove(paramo);
  }

  public void b(h paramh)
  {
    p.a(this, paramh);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.n
 * JD-Core Version:    0.6.2
 */