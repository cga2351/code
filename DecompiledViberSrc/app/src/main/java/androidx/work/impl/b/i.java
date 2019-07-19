package androidx.work.impl.b;

import android.arch.persistence.a.f;
import android.arch.persistence.room.b;
import android.arch.persistence.room.e;

public class i
  implements h
{
  private final e a;
  private final b b;

  public i(e parame)
  {
    this.a = parame;
    this.b = new b(parame)
    {
      public String a()
      {
        return "INSERT OR IGNORE INTO `WorkName`(`name`,`work_spec_id`) VALUES (?,?)";
      }

      public void a(f paramAnonymousf, g paramAnonymousg)
      {
        if (paramAnonymousg.a == null)
          paramAnonymousf.a(1);
        while (paramAnonymousg.b == null)
        {
          paramAnonymousf.a(2);
          return;
          paramAnonymousf.a(1, paramAnonymousg.a);
        }
        paramAnonymousf.a(2, paramAnonymousg.b);
      }
    };
  }

  public void a(g paramg)
  {
    this.a.f();
    try
    {
      this.b.a(paramg);
      this.a.h();
      return;
    }
    finally
    {
      this.a.g();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b.i
 * JD-Core Version:    0.6.2
 */