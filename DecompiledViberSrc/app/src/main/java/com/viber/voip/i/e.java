package com.viber.voip.i;

import com.viber.common.b.b;
import com.viber.common.permission.c;
import com.viber.voip.ViberApplication;
import com.viber.voip.registration.ao;
import com.viber.voip.util.da;

final class e
{
  private static final d a = new l()
  {
    public boolean a()
    {
      return ViberApplication.isTablet(ViberApplication.getApplication());
    }
  };
  private static final d b = new l()
  {
    public boolean a()
    {
      return ao.f();
    }
  };
  private static final d c = new l()
  {
    public boolean a()
    {
      return false;
    }
  };
  private static final d d = new l()
  {
    public boolean a()
    {
      return com.viber.voip.memberid.d.c();
    }
  };

  public static d a()
  {
    return a;
  }

  public static d a(b paramb)
  {
    return new i(paramb)
    {
      protected boolean a(b paramAnonymousb)
      {
        return paramAnonymousb.d();
      }
    };
  }

  public static d a(com.viber.common.b.h paramh)
  {
    return new i(paramh)
    {
      protected boolean a(com.viber.common.b.h paramAnonymoush)
      {
        return !da.a(paramAnonymoush.d());
      }
    };
  }

  public static d a(d paramd)
  {
    return new d()
    {
      public void a(d.a paramAnonymousa)
      {
        this.a.a(paramAnonymousa);
      }

      public boolean a()
      {
        return (this.a != null) && (!this.a.a());
      }
    };
  }

  public static d a(d paramd1, final d paramd2)
  {
    return new d()
    {
      public void a(d.a paramAnonymousa)
      {
        this.a.a(paramAnonymousa);
        paramd2.a(paramAnonymousa);
      }

      public boolean a()
      {
        return (this.a != null) && (paramd2 != null) && (this.a.a()) && (paramd2.a());
      }
    };
  }

  public static d a(f paramf)
  {
    return new a(paramf, true);
  }

  public static d a(boolean paramBoolean)
  {
    return new l()
    {
      public boolean a()
      {
        return this.a;
      }
    };
  }

  public static d a(String[] paramArrayOfString)
  {
    return new h(c.a(ViberApplication.getApplication()), paramArrayOfString);
  }

  public static d b()
  {
    return b;
  }

  public static d b(d paramd1, final d paramd2)
  {
    return new d()
    {
      public void a(d.a paramAnonymousa)
      {
        this.a.a(paramAnonymousa);
        paramd2.a(paramAnonymousa);
      }

      public boolean a()
      {
        return ((this.a != null) && (this.a.a())) || ((paramd2 != null) && (paramd2.a()));
      }
    };
  }

  public static d b(f paramf)
  {
    return new a(paramf, false);
  }

  public static d c()
  {
    return d;
  }

  public static d d()
  {
    return new d()
    {
      public void a(d.a paramAnonymousa)
      {
      }

      public boolean a()
      {
        return true;
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.e
 * JD-Core Version:    0.6.2
 */