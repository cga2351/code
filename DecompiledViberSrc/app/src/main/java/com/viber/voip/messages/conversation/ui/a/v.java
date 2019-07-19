package com.viber.voip.messages.conversation.ui.a;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v
  implements ad
{
  private List<ad> a = new ArrayList(4);

  public void a(aa paramaa, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((ad)localIterator.next()).a(paramaa, paramInt);
  }

  public void a(ad paramad)
  {
    this.a.add(paramad);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.a.v
 * JD-Core Version:    0.6.2
 */