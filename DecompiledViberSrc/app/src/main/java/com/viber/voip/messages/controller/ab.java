package com.viber.voip.messages.controller;

import android.net.Uri;
import android.os.Handler;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.group.participants.settings.b;
import com.viber.voip.publicaccount.entity.PublicAccount;
import java.util.Set;

public class ab
  implements GroupController
{
  private final GroupController a;
  private final Handler b;

  public ab(Handler paramHandler, GroupController paramGroupController)
  {
    this.a = paramGroupController;
    this.b = paramHandler;
  }

  private void a(final a parama)
  {
    this.b.postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        parama.a(ab.a(ab.this));
      }
    });
  }

  public void a(final double paramDouble1, double paramDouble2, final long paramLong1, long paramLong2)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramDouble1, paramLong1, this.c, this.d);
      }
    });
  }

  public void a(final int paramInt1, final int paramInt2, final PublicAccount paramPublicAccount)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramInt1, paramInt2, paramPublicAccount);
      }
    });
  }

  public void a(final int paramInt, final long paramLong)
  {
    av.a(av.e.f).postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramInt, paramLong);
      }
    });
  }

  public void a(final int paramInt1, final long paramLong, int paramInt2, final boolean paramBoolean)
  {
    av.a(av.e.f).postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramInt1, paramLong, paramBoolean, this.d);
      }
    });
  }

  public void a(final int paramInt, final long paramLong, Uri paramUri)
  {
    this.a.c(paramInt);
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramInt, paramLong, this.c);
      }
    });
  }

  public void a(final int paramInt, final long paramLong, String paramString)
  {
    this.a.c(paramInt);
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramInt, paramLong, this.c);
      }
    });
  }

  public void a(final int paramInt1, final long paramLong, String paramString, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, this.f);
      }
    });
  }

  public void a(final int paramInt1, final long paramLong1, String paramString1, final Uri paramUri, final String paramString2, final long paramLong2, final String paramString3, int paramInt2)
  {
    av.a(av.e.f).postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramInt1, paramLong1, paramUri, paramString2, paramLong2, paramString3, this.g, this.h);
      }
    });
  }

  public void a(int paramInt1, long paramLong1, String paramString1, Uri paramUri, String paramString2, long paramLong2, String paramString3, boolean paramBoolean, int paramInt2)
  {
    av.a(av.e.f).postAtFrontOfQueue(new ad(this, paramInt1, paramLong1, paramString1, paramUri, paramString2, paramLong2, paramString3, paramBoolean, paramInt2));
  }

  public void a(final int paramInt, final long paramLong1, String paramString1, final String paramString2, final Uri paramUri, final long paramLong2, final String paramString3, boolean paramBoolean, final com.viber.voip.messages.controller.publicaccount.ae paramae)
  {
    av.a(av.e.f).postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramInt, paramLong1, paramString2, paramUri, paramLong2, paramString3, paramae, this.h, this.i);
      }
    });
  }

  public void a(final int paramInt, final long paramLong1, String paramString1, final String paramString2, final Uri paramUri, final String paramString3, final long paramLong2, final String paramString4, boolean paramBoolean, final com.viber.voip.messages.controller.publicaccount.ae paramae)
  {
    av.a(av.e.f).postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramInt, paramLong1, paramString2, paramUri, paramString3, paramLong2, paramString4, paramae, this.i, this.j);
      }
    });
  }

  public void a(final int paramInt, final long paramLong, GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramInt, paramLong, this.c);
      }
    });
  }

  public void a(final int paramInt1, final long paramLong, GroupController.GroupMember[] paramArrayOfGroupMember, final int paramInt2)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramInt1, paramLong, paramInt2, this.d);
      }
    });
  }

  public void a(final int paramInt, final PublicAccount paramPublicAccount, final String[] paramArrayOfString)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramInt, paramPublicAccount, paramArrayOfString);
      }
    });
  }

  public void a(final int paramInt, final String paramString, final GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramInt, paramString, paramArrayOfGroupMember);
      }
    });
  }

  public void a(final int paramInt, final String paramString1, final GroupController.GroupMember[] paramArrayOfGroupMember, final String paramString2, final Uri paramUri)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramInt, paramString1, paramArrayOfGroupMember, paramString2, paramUri);
      }
    });
  }

  public void a(int paramInt, boolean paramBoolean, String paramString, Uri paramUri, GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    a(new ac(paramInt, paramBoolean, paramString, paramUri, paramArrayOfGroupMember));
  }

  public void a(final long paramLong)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramLong);
      }
    });
  }

  public void a(final long paramLong, int paramInt)
  {
    av.a(av.e.d).post(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    av.a(av.e.f).postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramLong, paramInt2, paramBoolean, this.d);
      }
    });
  }

  public void a(final long paramLong1, int paramInt, final long paramLong2)
  {
    av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramLong1, paramLong2, this.c);
      }
    });
  }

  public void a(final long paramLong, int paramInt, final String paramString1, final String paramString2)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramLong, paramString1, paramString2, this.d);
      }
    });
  }

  public void a(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramLong, paramBoolean, this.c);
      }
    });
  }

  public void a(final long paramLong1, long paramLong2, final int paramInt, long paramLong3, final long paramLong4, final String paramString)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramLong1, paramInt, paramLong4, paramString, this.e, this.f);
      }
    });
  }

  public void a(final long paramLong, b paramb)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, String paramString)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, Set<Long> paramSet1, final Set<Long> paramSet2, final GroupController.a parama)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramLong, paramSet2, parama, this.d);
      }
    });
  }

  public void a(final long paramLong, GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, String[] paramArrayOfString)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, String[] paramArrayOfString, final int paramInt)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        ab.a(ab.this).a(paramLong, paramInt, this.c);
      }
    });
  }

  public boolean a(int paramInt)
  {
    return this.a.a(paramInt);
  }

  public void b(final long paramLong)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.b(paramLong);
      }
    });
  }

  public void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    av.a(av.e.j).postAtFrontOfQueue(new ae(this, paramLong, paramInt, paramString1, paramString2));
  }

  public void b(final long paramLong, String paramString)
  {
    a(new a()
    {
      public void a(GroupController paramAnonymousGroupController)
      {
        paramAnonymousGroupController.b(paramLong, this.b);
      }
    });
  }

  public boolean b(int paramInt)
  {
    return this.a.b(paramInt);
  }

  public void c(int paramInt)
  {
    this.a.c(paramInt);
  }

  public boolean d(int paramInt)
  {
    return this.a.d(paramInt);
  }

  private static abstract interface a
  {
    public abstract void a(GroupController paramGroupController);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.ab
 * JD-Core Version:    0.6.2
 */