package com.viber.voip.messages.extensions;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.SecureTokenDelegate;
import com.viber.jni.secure.SecureTokenListener;
import com.viber.jni.slashkey.SlashKeyAdapterErrorCode;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.k;
import com.viber.voip.messages.extensions.model.b;
import com.viber.voip.messages.extensions.model.b.a;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.registration.af;
import com.viber.voip.stickers.i;
import com.viber.voip.util.bp;
import com.viber.voip.util.da;
import com.viber.voip.util.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class k
  implements bv.k, Runnable
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.MINUTES.toMillis(5L);
  private static Map<String, String> n;
  private static Map<String, String> o;
  private final com.viber.voip.messages.extensions.a.a c;
  private final com.viber.voip.messages.k d;
  private final Handler e;
  private final Engine f;
  private final j g;
  private String h = "";
  private String i = "";
  private com.viber.voip.messages.extensions.model.a j;
  private a k;
  private boolean l = false;
  private long m = 0L;
  private final SecureTokenDelegate p = new SecureTokenDelegate()
  {
    public void onSecureTokenReply(int paramAnonymousInt, long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
    {
      k.a(k.this);
      if (k.a(k.this, paramAnonymousLong, paramAnonymousArrayOfByte))
      {
        k.a(k.this, System.currentTimeMillis());
        k.b(k.this);
      }
    }
  };

  public k(a parama, Handler paramHandler)
  {
    this.k = parama;
    this.e = paramHandler;
    this.d = ViberApplication.getInstance().getMessagesManager();
    this.c = this.d.j();
    this.f = ViberApplication.getInstance().getEngine(false);
    this.g = new j();
    this.h = new af().e();
  }

  private b a(com.viber.voip.messages.extensions.model.a parama)
  {
    boolean bool = d.a(parama.a());
    if ((u.a(o)) && (bool))
    {
      e();
      return null;
    }
    if ((!bool) && (this.l))
      f();
    b.a locala = b.a().a(this.i);
    Locale localLocale = bp.b(ViberApplication.getApplication());
    if (localLocale != null)
      locala.b(localLocale.getLanguage());
    locala.c(this.h);
    if (!bool)
      return locala.a();
    locala.a(d());
    locala.a(o);
    locala.a("user_packs", i.a().b(null));
    return locala.a();
  }

  private boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramLong > 0L) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if (o != null);
      for (Object localObject = o; ; localObject = new HashMap(2))
      {
        o = (Map)localObject;
        this.g.a(o, paramLong, paramArrayOfByte);
        return true;
      }
    }
    return false;
  }

  private void c()
  {
    if (this.j == null);
    b localb;
    do
    {
      return;
      localb = a(this.j);
    }
    while (localb == null);
    this.d.b().a(this);
    this.c.a(this.j.b(), localb);
  }

  private Map<String, String> d()
  {
    if (n == null)
    {
      n = new HashMap(10);
      this.g.a(n);
    }
    return n;
  }

  private void e()
  {
    if (this.l);
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis() - this.m;
    }
    while ((l1 >= 0L) && (l1 <= b));
    this.l = true;
    u.b(o);
    this.f.getDelegatesManager().getSecureTokenListener().registerDelegate(this.p, this.e);
    this.f.getPhoneController().handleSecureTokenRequest(this.f.getPhoneController().generateSequence());
  }

  private void f()
  {
    this.f.getDelegatesManager().getSecureTokenListener().removeDelegate(this.p);
    this.l = false;
  }

  public void a()
  {
    this.j = null;
    this.i = "";
    this.d.b().b(this);
  }

  public void a(com.viber.voip.messages.extensions.model.a parama, String paramString)
  {
    this.i = da.h(paramString);
    this.j = parama;
  }

  public void a(String paramString1, String paramString2, d[] paramArrayOfd, @SlashKeyAdapterErrorCode String paramString3)
  {
    if ((this.j == null) || (!paramString1.equals(this.j.b())) || (!paramString2.equals(this.i)));
    do
    {
      return;
      if (("ERROR_TOKEN_EXPIRED".equals(paramString3)) && (d.a(this.j.a())))
      {
        u.b(o);
        c();
        return;
      }
    }
    while (this.k == null);
    this.k.a(new ArrayList(Arrays.asList(paramArrayOfd)));
  }

  public void b()
  {
    f();
  }

  public void run()
  {
    c();
  }

  public static abstract interface a
  {
    public abstract void a(List<d> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.k
 * JD-Core Version:    0.6.2
 */