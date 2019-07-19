package com.viber.voip.messages.conversation.ui.b;

import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.az;
import java.util.ArrayList;
import java.util.List;

public class i
  implements l
{
  private final l a;
  private final ab b;
  private final az c;
  private boolean d;
  private final List<l> e = new ArrayList();

  public i(l paraml, ab paramab, az paramaz)
  {
    this.a = paraml;
    this.b = paramab;
    this.c = paramaz;
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((l)this.e.get(j)).a(paramLong1, paramInt, paramLong2);
  }

  public void a(long paramLong, a parama)
  {
    this.c.a(new j(this, paramLong, parama));
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = 0;
    this.a.a(paramq, paramBoolean1, paramInt, paramBoolean2);
    int j = this.e.size();
    for (int k = 0; k < j; k++)
      ((l)this.e.get(k)).a(paramq, paramBoolean1, paramInt, paramBoolean2);
    this.a.j();
    int m = this.e.size();
    while (i < m)
    {
      ((l)this.e.get(i)).j();
      i++;
    }
  }

  public void a(l paraml)
  {
    this.e.add(paraml);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt, String paramString)
  {
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((l)this.e.get(j)).a(paramMessageEntity, paramInt, paramString);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    m.a(this, paramBoolean1, paramBoolean2);
  }

  public boolean a()
  {
    return this.d;
  }

  public void b(l paraml)
  {
    this.e.remove(paraml);
  }

  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean1;
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((l)this.e.get(j)).a(paramBoolean1, paramBoolean2);
  }

  public void j()
  {
    m.a(this);
  }

  public static abstract interface a
  {
    public abstract void a(MessageEntity paramMessageEntity, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.i
 * JD-Core Version:    0.6.2
 */