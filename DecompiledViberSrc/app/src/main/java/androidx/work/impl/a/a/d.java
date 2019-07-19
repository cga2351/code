package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.impl.a.b;
import androidx.work.impl.a.b.g;

public class d extends c<b>
{
  public d(Context paramContext)
  {
    super(g.a(paramContext).c());
  }

  boolean a(b paramb)
  {
    boolean bool1 = true;
    if (Build.VERSION.SDK_INT >= 26)
    {
      boolean bool2;
      if (paramb.a())
      {
        boolean bool3 = paramb.b();
        bool2 = false;
        if (bool3);
      }
      else
      {
        bool2 = bool1;
      }
      return bool2;
    }
    if (!paramb.a());
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  boolean a(androidx.work.impl.b.j paramj)
  {
    return paramj.j.a() == androidx.work.j.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.a.d
 * JD-Core Version:    0.6.2
 */