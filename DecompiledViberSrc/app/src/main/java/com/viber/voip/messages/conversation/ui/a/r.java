package com.viber.voip.messages.conversation.ui.a;

import com.viber.voip.widget.b.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r
  implements b.a
{
  private List<b.a> a = new ArrayList(4);

  public void a(b.a parama)
  {
    this.a.add(parama);
  }

  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b.a)localIterator.next()).a(paramBoolean);
  }

  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b.a)localIterator.next()).b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.a.r
 * JD-Core Version:    0.6.2
 */