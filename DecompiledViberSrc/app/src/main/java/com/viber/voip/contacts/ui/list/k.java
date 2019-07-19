package com.viber.voip.contacts.ui.list;

import com.viber.voip.ui.h.a;
import java.util.ArrayList;
import java.util.List;

public class k
  implements j.a, a
{
  private List<n> a = new ArrayList();

  public int a()
  {
    return this.a.size();
  }

  public void a(List<n> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }

  public boolean a(int paramInt)
  {
    return paramInt == 0;
  }

  public Object b(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public boolean c(int paramInt)
  {
    return paramInt == -1 + a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.k
 * JD-Core Version:    0.6.2
 */