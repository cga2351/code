package com.viber.voip.messages.conversation.ui.b;

import java.util.ArrayList;
import java.util.List;

public class e
{
  private final List<a> a = new ArrayList();

  public void a(a parama)
  {
    this.a.add(parama);
  }

  public void a(boolean paramBoolean)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((a)this.a.get(j)).a(paramBoolean);
  }

  public void b(a parama)
  {
    this.a.remove(parama);
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.e
 * JD-Core Version:    0.6.2
 */