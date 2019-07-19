package com.viber.voip.model.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.u;
import java.util.List;

class c
{
  private static final Logger a = ViberEnv.getLogger();

  static void a(d paramd1, d paramd2)
  {
    a(paramd1, paramd2, paramd1.d("VLIB_INNER_"));
    paramd2.a(5);
  }

  private static void a(d paramd1, d paramd2, List<d.a> paramList)
  {
    if (!u.a(paramList))
    {
      paramd2.a(paramList);
      paramd1.c(paramList);
    }
  }

  static boolean a(d paramd)
  {
    return paramd.c() == -2147483648;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.a.c
 * JD-Core Version:    0.6.2
 */