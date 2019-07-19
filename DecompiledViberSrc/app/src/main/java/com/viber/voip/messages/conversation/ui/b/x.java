package com.viber.voip.messages.conversation.ui.b;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class x
{
  private final List<y> a = new ArrayList();

  public void a(View paramView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((y)localIterator.next()).a(paramView);
  }

  public void a(y paramy)
  {
    this.a.add(paramy);
  }

  public void b(y paramy)
  {
    this.a.remove(paramy);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.x
 * JD-Core Version:    0.6.2
 */