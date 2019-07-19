package com.viber.voip.ui.doodle.extras;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class f
  implements g
{
  public static final long a = i.a;
  private static final Logger b = ViberEnv.getLogger();
  private long c = 0L;

  public f(Bundle paramBundle)
  {
    if (paramBundle != null)
      this.c = paramBundle.getLong("current_id_extra", 0L);
  }

  public long a()
  {
    this.c = (1L + this.c);
    return this.c;
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putLong("current_id_extra", this.c);
  }

  public long b()
  {
    return a;
  }

  public String toString()
  {
    return "ObjectIdGenerator{mCurrentId=" + this.c + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.extras.f
 * JD-Core Version:    0.6.2
 */