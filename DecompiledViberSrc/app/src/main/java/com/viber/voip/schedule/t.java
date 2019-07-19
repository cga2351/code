package com.viber.voip.schedule;

import android.os.Bundle;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.h;
import com.viber.voip.analytics.g.i;
import com.viber.voip.analytics.g.i.a;
import com.viber.voip.settings.d.bn;

public class t
  implements f
{
  private static final e a = ViberEnv.getLogger();

  private void a()
  {
    long l = System.currentTimeMillis();
    i.a locala = new i.a(d.bn.a);
    if (new i(locala).a(l))
    {
      g.a().b().b(false);
      locala.a(l);
    }
  }

  public int a(Bundle paramBundle)
  {
    a();
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.t
 * JD-Core Version:    0.6.2
 */