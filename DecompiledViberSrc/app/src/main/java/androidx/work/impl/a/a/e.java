package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.i;
import androidx.work.impl.a.b;
import androidx.work.impl.a.b.g;

public class e extends c<b>
{
  private static final String a = i.a("NetworkMeteredCtrlr");

  public e(Context paramContext)
  {
    super(g.a(paramContext).c());
  }

  boolean a(b paramb)
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      i.a().b(a, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
      return !paramb.a();
    }
    boolean bool1;
    if (paramb.a())
    {
      boolean bool2 = paramb.c();
      bool1 = false;
      if (bool2);
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  boolean a(androidx.work.impl.b.j paramj)
  {
    return paramj.j.a() == androidx.work.j.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.a.e
 * JD-Core Version:    0.6.2
 */