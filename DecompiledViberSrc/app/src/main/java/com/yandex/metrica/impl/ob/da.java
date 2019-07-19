package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.s;
import com.yandex.metrica.impl.s.a;
import java.util.List;

public class da extends db<ci>
{
  public da(dk paramdk)
  {
    super(paramdk);
  }

  public void a(s.a parama, List<ci> paramList)
  {
    if (s.b(parama))
      paramList.add(a().j());
    if (s.a(parama))
      paramList.add(a().e());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.da
 * JD-Core Version:    0.6.2
 */