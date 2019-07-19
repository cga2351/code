package com.viber.voip.messages.conversation.ui.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private final List<c> a = new ArrayList();

  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((c)localIterator.next()).a();
  }

  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((c)localIterator.next()).a(paramInt);
  }

  public void a(c paramc)
  {
    this.a.add(paramc);
  }

  public void b(c paramc)
  {
    this.a.remove(paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.b
 * JD-Core Version:    0.6.2
 */