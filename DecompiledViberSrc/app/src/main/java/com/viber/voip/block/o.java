package com.viber.voip.block;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.orm.entity.json.action.BlockPublicGroupAction;
import com.viber.voip.widget.c.a;
import com.viber.voip.widget.c.a.a;

public class o
{
  private View a;

  public o(View paramView)
  {
    this.a = paramView;
  }

  public static void a(View paramView, String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 1;
    Resources localResources = b();
    int j = R.string.block_app_undo_text;
    Object[] arrayOfObject = new Object[i];
    arrayOfObject[0] = paramString;
    String str = localResources.getString(j, arrayOfObject);
    int k = R.string.subscribe;
    if (paramBoolean);
    while (true)
    {
      com.viber.voip.widget.c.b localb = new com.viber.voip.widget.c.b(-1, k, 4000L, i);
      a.a(paramView, str, new a.a()
      {
        public void a(Parcelable paramAnonymousParcelable)
        {
          b.a().b(this.a);
        }
      }
      , localb);
      return;
      i = 0;
    }
  }

  private static Resources b()
  {
    return ViberApplication.getLocalizedResources();
  }

  private static void b(k.b paramb)
  {
    b.a().b().a(paramb);
  }

  private static void c(k.b paramb)
  {
    b.a().b().b(paramb);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, 0);
  }

  public void a(final int paramInt1, final boolean paramBoolean, int paramInt2)
  {
    b(new a(paramInt1)
    {
      public void a(int paramAnonymousInt, final String paramAnonymousString)
      {
        if (paramAnonymousInt != paramInt1)
          return;
        o.a(this);
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            o.a(o.a(o.this), paramAnonymousString, o.3.this.a, o.3.this.b);
          }
        });
      }
    });
    b.a().a(paramInt1, paramInt2);
  }

  public void a(final long paramLong, boolean paramBoolean)
  {
    b(new b(paramLong)
    {
      public void b(long paramAnonymousLong, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        if (paramAnonymousLong != paramLong)
          return;
        o.a(this);
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            int i = 1;
            Resources localResources = o.a();
            int j = R.string.unblock_pg_invite_undo_text;
            Object[] arrayOfObject = new Object[i];
            arrayOfObject[0] = paramAnonymousString1;
            String str = localResources.getString(j, arrayOfObject);
            int k = R.string.reblock;
            if (o.2.this.b);
            while (true)
            {
              com.viber.voip.widget.c.b localb = new com.viber.voip.widget.c.b(-1, k, 4000L, i);
              a.a(o.a(o.this), str, new a.a()
              {
                public void a(Parcelable paramAnonymous3Parcelable)
                {
                  b.a().a(o.2.this.a, o.2.1.this.a, o.2.1.this.b);
                }
              }
              , localb);
              return;
              i = 0;
            }
          }
        });
      }
    });
    b.a().a(paramLong);
  }

  public void a(final BlockPublicGroupAction paramBlockPublicGroupAction, final boolean paramBoolean)
  {
    b(new b(paramBlockPublicGroupAction)
    {
      public void a(long paramAnonymousLong, final String paramAnonymousString1, String paramAnonymousString2)
      {
        if (paramAnonymousLong != paramBlockPublicGroupAction.getGroupId())
          return;
        o.a(this);
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            int i = 1;
            Resources localResources = o.a();
            int j = R.string.block_pg_invite_undo_text;
            Object[] arrayOfObject = new Object[i];
            arrayOfObject[0] = paramAnonymousString1;
            String str = localResources.getString(j, arrayOfObject);
            int k = R.string.unblock;
            if (o.1.this.b);
            while (true)
            {
              com.viber.voip.widget.c.b localb = new com.viber.voip.widget.c.b(-1, k, 4000L, i);
              a.a(o.a(o.this), str, new a.a()
              {
                public void a(Parcelable paramAnonymous3Parcelable)
                {
                  b.a().a(o.1.this.a.getGroupId());
                }
              }
              , localb);
              return;
              i = 0;
            }
          }
        });
      }
    });
    b.a().a(paramBlockPublicGroupAction);
  }

  public void b(final int paramInt, final boolean paramBoolean)
  {
    b(new a(paramInt)
    {
      public void b(int paramAnonymousInt, final String paramAnonymousString)
      {
        if (paramAnonymousInt != paramInt)
          return;
        o.a(this);
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            int i = 1;
            Resources localResources = o.a();
            int j = R.string.unblock_app_undo_text;
            Object[] arrayOfObject = new Object[i];
            arrayOfObject[0] = paramAnonymousString;
            String str = localResources.getString(j, arrayOfObject);
            int k = R.string.unsubscribe;
            if (o.5.this.b);
            while (true)
            {
              com.viber.voip.widget.c.b localb = new com.viber.voip.widget.c.b(-1, k, 4000L, i);
              a.a(o.a(o.this), str, new a.a()
              {
                public void a(Parcelable paramAnonymous3Parcelable)
                {
                  b.a().a(o.5.this.a);
                }
              }
              , localb);
              return;
              i = 0;
            }
          }
        });
      }
    });
    b.a().b(paramInt);
  }

  private static class a
    implements k.a
  {
    public void a(int paramInt, String paramString)
    {
    }

    public void b(int paramInt, String paramString)
    {
    }
  }

  private static class b
    implements k.d
  {
    public void a(long paramLong, String paramString1, String paramString2)
    {
    }

    public void b(long paramLong, String paramString1, String paramString2)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.o
 * JD-Core Version:    0.6.2
 */