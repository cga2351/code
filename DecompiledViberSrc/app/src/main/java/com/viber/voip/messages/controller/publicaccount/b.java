package com.viber.voip.messages.controller.publicaccount;

import android.content.Context;
import android.util.Pair;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.n;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.ui.dialogs.a.a.b;
import com.viber.voip.ui.dialogs.a.a.b.a;
import java.util.concurrent.TimeUnit;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private com.viber.common.permission.c c;
  private final com.viber.common.permission.b d;
  private ConversationItemLoaderEntity e;
  private b f;
  private final com.viber.voip.messages.extras.b.a g;
  private com.viber.voip.messages.extensions.c h;

  public b(Context paramContext, com.viber.common.permission.c paramc, com.viber.voip.messages.extensions.c paramc1)
  {
    this.b = paramContext;
    this.c = paramc;
    this.h = paramc1;
    Context localContext = this.b;
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(68);
    this.d = new c(localContext, arrayOfPair);
    this.g = ViberApplication.getInstance().getLocationManager();
  }

  private void b(String paramString1, String paramString2)
  {
    if (this.e == null)
      return;
    com.viber.voip.bot.a locala = e.a(this.e, paramString1, paramString2);
    ViberApplication.getInstance().getMessagesManager().h().a(locala);
  }

  private void c(String paramString1, String paramString2)
  {
    if (this.g.a("network"))
    {
      d(paramString1, paramString2);
      return;
    }
    com.viber.voip.ui.dialogs.m.a().a(false).a(new a.b(new a(paramString1, paramString2, null))).a(this.b);
  }

  private boolean c()
  {
    return this.e == null;
  }

  private void d(String paramString1, String paramString2)
  {
    if (c())
      return;
    this.g.b(2, TimeUnit.SECONDS.toMillis(5L), new c(this, paramString1, paramString2));
  }

  private void e(String paramString1, String paramString2)
  {
    if (this.e == null)
      return;
    com.viber.voip.bot.a locala = e.a(this.e, paramString1, paramString2);
    ViberApplication.getInstance().getMessagesManager().h().a(locala, a.a);
  }

  public void a()
  {
    this.c.a(this.d);
    if (this.f != null)
    {
      String str1 = this.f.a;
      String str2 = this.f.b;
      this.f = null;
      a(str1, str2);
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.e = paramConversationItemLoaderEntity;
  }

  public void a(String paramString1, String paramString2)
  {
    if (c())
      return;
    if (this.h.h(paramString1))
    {
      if (ViberApplication.getInstance().getMessagesManager().h().b(paramString1))
      {
        b(paramString1, paramString2);
        return;
      }
      if (this.c.a(n.l))
      {
        c(paramString1, paramString2);
        return;
      }
      this.f = new b(paramString1, paramString2);
      this.c.a(this.b, 68, n.l);
      return;
    }
    b(paramString1, paramString2);
  }

  public void b()
  {
    this.c.b(this.d);
  }

  private class a
    implements a.b.a
  {
    private final String b;
    private final String c;

    private a(String paramString1, String arg3)
    {
      this.b = paramString1;
      Object localObject;
      this.c = localObject;
    }

    public void a()
    {
      b.a(b.this, new b.b(b.this, this.b, this.c));
    }

    public void b()
    {
      b.a(b.this, null);
      b.b(b.this, this.b, this.c);
    }
  }

  private class b
  {
    public final String a;
    public final String b;

    b(String paramString1, String arg3)
    {
      this.a = paramString1;
      Object localObject;
      this.b = localObject;
    }
  }

  private class c extends f
  {
    @SafeVarargs
    c(Pair<Integer, com.viber.voip.permissions.m>[] arg2)
    {
      super(arrayOfPair);
    }

    public void onPermissionsDenied(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, Object paramObject)
    {
      if ((paramInt != 68) || (b.b(b.this)));
      while (b.a(b.this) == null)
        return;
      String str1 = b.a(b.this).a;
      String str2 = b.a(b.this).b;
      b.a(b.this, null);
      b.b(b.this, str1, str2);
    }

    public void onPermissionsGranted(int paramInt, String[] paramArrayOfString, Object paramObject)
    {
      if ((paramInt == 68) && (b.a(b.this) != null))
      {
        String str1 = b.a(b.this).a;
        String str2 = b.a(b.this).b;
        b.a(b.this, null);
        b.a(b.this, str1, str2);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.b
 * JD-Core Version:    0.6.2
 */