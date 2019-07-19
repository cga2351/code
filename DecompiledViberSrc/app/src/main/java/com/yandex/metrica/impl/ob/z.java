package com.yandex.metrica.impl.ob;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class z<CU extends ax>
{
  private final List<CU> a = new CopyOnWriteArrayList();
  private boolean b;

  public List<CU> a()
  {
    return this.a;
  }

  public void a(CU paramCU)
  {
    this.a.add(paramCU);
  }

  public void b(CU paramCU)
  {
    this.a.remove(paramCU);
    if (this.a.isEmpty())
      this.b = true;
  }

  public boolean b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.z
 * JD-Core Version:    0.6.2
 */