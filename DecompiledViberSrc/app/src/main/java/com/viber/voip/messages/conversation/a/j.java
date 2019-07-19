package com.viber.voip.messages.conversation.a;

import com.viber.voip.util.da;

public class j extends a
  implements h.a
{
  private final h[] b;

  public j(h[] paramArrayOfh)
  {
    this.b = paramArrayOfh;
  }

  public void G()
  {
    a();
  }

  public String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    h[] arrayOfh = this.b;
    int i = arrayOfh.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfh[j].a(paramBoolean);
      if (da.a(str));
      while (true)
      {
        j++;
        break;
        if (localStringBuilder.length() > 0)
          localStringBuilder.append(',');
        localStringBuilder.append(str);
      }
    }
    if (localStringBuilder.length() == 0)
      return null;
    return localStringBuilder.toString();
  }

  protected void b()
  {
    super.b();
    h[] arrayOfh = this.b;
    int i = arrayOfh.length;
    for (int j = 0; j < i; j++)
      arrayOfh[j].a(this);
  }

  protected void c()
  {
    super.c();
    h[] arrayOfh = this.b;
    int i = arrayOfh.length;
    for (int j = 0; j < i; j++)
      arrayOfh[j].b(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.a.j
 * JD-Core Version:    0.6.2
 */