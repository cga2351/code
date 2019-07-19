package com.viber.voip.messages.conversation.ui.b;

import com.viber.voip.messages.conversation.adapter.a.b.f;
import java.util.ArrayList;
import java.util.List;

public class af
  implements ag
{
  private final ag a;
  private final List<ag> b = new ArrayList();

  public af(ag paramag)
  {
    this.a = paramag;
  }

  public void J()
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      ((ag)this.b.get(j)).J();
    this.a.J();
  }

  public void K()
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      ((ag)this.b.get(j)).K();
    this.a.K();
  }

  public void a(f paramf, boolean paramBoolean)
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      ((ag)this.b.get(j)).a(paramf, paramBoolean);
    this.a.a(paramf, paramBoolean);
  }

  public void a(ag paramag)
  {
    this.b.add(paramag);
  }

  public void b(ag paramag)
  {
    this.b.remove(paramag);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.af
 * JD-Core Version:    0.6.2
 */