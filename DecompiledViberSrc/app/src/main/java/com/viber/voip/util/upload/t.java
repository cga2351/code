package com.viber.voip.util.upload;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.Engine;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.e.a.c;
import com.viber.voip.e.a.e;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.at;
import com.viber.voip.util.c.a;
import com.viber.voip.util.cr;
import com.viber.voip.util.cr.c;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.dy;
import com.viber.voip.util.http.OkHttpClientFactory;
import com.viber.voip.util.http.OkHttpClientFactory.Type;
import com.viber.voip.util.http.UploadProgressListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class t extends l
{
  public static final long a;
  public static final long b;
  private static final Logger d;
  private static AtomicInteger e;
  private static final Handler f;
  private static final Map<e, Set<q>> g;
  private static final Map<e, b> h;
  private static final Map<e, r> i;

  static
  {
    if (!t.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      c = bool;
      d = ViberEnv.getLogger();
      e = new AtomicInteger(0);
      a = TimeUnit.MINUTES.toMillis(10L);
      b = TimeUnit.MINUTES.toMillis(2L);
      f = av.a(av.e.i);
      g = Collections.synchronizedMap(new HashMap());
      h = Collections.synchronizedMap(new HashMap());
      i = Collections.synchronizedMap(new LinkedHashMap(10));
      return;
    }
  }

  static int a()
  {
    return e.incrementAndGet();
  }

  public static void a(Uri paramUri)
  {
    a(paramUri, true, d.h);
  }

  public static void a(Uri paramUri1, Uri paramUri2, q paramq)
  {
    a(new i.f(paramUri1, null, d.c, false, i.c.b).a(paramUri2, i.o.b, i.c.b), paramq);
  }

  public static void a(MessageEntity paramMessageEntity)
  {
    if (TextUtils.isEmpty(paramMessageEntity.getMediaUri()))
      return;
    d(dx.b(paramMessageEntity));
    boolean bool = bk.a(paramMessageEntity);
    if ((paramMessageEntity.getMediaFlag() == 0) && (paramMessageEntity.isImage()))
    {
      a(dv.h.a(ViberApplication.getApplication(), paramMessageEntity.getMediaUri(), false), bool, paramMessageEntity.isPublicGroupBehavior());
      return;
    }
    if ((paramMessageEntity.isVideo()) && (paramMessageEntity.usesVideoConverter()))
    {
      a(Uri.fromFile(dy.b(Uri.parse(paramMessageEntity.getMediaUri()))), bool, paramMessageEntity.isPublicGroupBehavior());
      dy.a().a(Uri.parse(paramMessageEntity.getMediaUri()));
      return;
    }
    if (paramMessageEntity.isFile())
    {
      a(Uri.parse(paramMessageEntity.getMediaUri()), bool, d.h);
      return;
    }
    a(Uri.parse(paramMessageEntity.getMediaUri()), bool, paramMessageEntity.isPublicGroupBehavior());
  }

  public static void a(MessageEntity paramMessageEntity, Uri paramUri, q paramq)
  {
    com.viber.voip.e.a.d.a("SEND_MESSAGE", paramMessageEntity, "executeUploadMessageMedia ");
    e.b().a("SEND_MESSAGE", "executeUploadMessageMedia");
    Uri localUri = dx.b(paramMessageEntity);
    boolean bool = bk.a(paramMessageEntity);
    int j;
    Object localObject;
    if ((paramMessageEntity.isFile()) || (paramMessageEntity.isVideoPtt()))
    {
      j = 1;
      if (j == 0)
        break label157;
      localObject = d.h;
    }
    while (true)
    {
      i.f localf = new i.f(paramUri, localUri, (d)localObject, bool, i.a(paramMessageEntity));
      if (j != 0)
        localf.a(paramMessageEntity.isPublicGroupBehavior());
      if ((!paramMessageEntity.isFile()) && (paramMessageEntity.getThumbnailUri() != null))
        if (!paramMessageEntity.isVideoPtt())
          break label192;
      label157: d locald;
      label192: for (i.c localc = i.c.d; ; localc = i.c.b)
      {
        localf.a(paramMessageEntity.getThumbnailUri(), i.o.a, localc);
        a(localf, paramq);
        e.b().b("SEND_MESSAGE", "executeUploadMessageMedia");
        return;
        j = 0;
        break;
        if (paramMessageEntity.isPublicGroupBehavior());
        for (locald = d.g; ; locald = d.a)
        {
          if (!paramMessageEntity.isAudioPtt())
            break label200;
          localObject = d.b;
          break;
        }
      }
      label200: localObject = locald;
    }
  }

  public static void a(MessageEntity paramMessageEntity, n paramn)
  {
    a(new i.h(paramMessageEntity, paramn));
  }

  private static void a(b paramb, q paramq)
  {
    a(paramb, paramq, f);
  }

  private static void a(b paramb, q paramq, Handler paramHandler)
  {
    synchronized (i)
    {
      if (i.size() > 10)
      {
        e locale = (e)i.keySet().iterator().next();
        i.remove(locale);
        d(locale.a);
      }
    }
    synchronized (g)
    {
      if (g.containsKey(paramb.r))
      {
        if (paramq != null)
          ((Set)g.get(paramb.r)).add(paramq);
        h.put(paramb.r, paramb);
        if (paramHandler != null)
        {
          paramHandler.post(paramb);
          return;
          localObject1 = finally;
          throw localObject1;
        }
      }
      else
      {
        HashSet localHashSet = new HashSet(1);
        if (paramq != null)
          localHashSet.add(paramq);
        g.put(paramb.r, localHashSet);
      }
    }
    paramb.run();
  }

  @SuppressLint({"Assert"})
  public static void a(d paramd, Uri paramUri, boolean paramBoolean, q paramq)
  {
    if ((!c) && (paramd != d.d) && (paramd != d.e) && (paramd != d.f))
      throw new AssertionError();
    a(new i.f(paramUri, null, paramd, paramBoolean, i.c.b), paramq);
  }

  private static void a(Runnable paramRunnable)
  {
    f.post(paramRunnable);
  }

  private static boolean a(Uri paramUri, boolean paramBoolean, d paramd)
  {
    if (paramUri == null)
      return false;
    e locale = new e(paramUri, paramd, paramBoolean);
    b localb = (b)h.remove(locale);
    if (localb != null)
      localb.a();
    Set localSet = (Set)g.remove(locale);
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        ((q)localIterator.next()).a(paramUri, c.d);
    }
    if (localSet != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private static boolean a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2);
    for (d locald = d.g; ; locald = d.a)
      return a(paramUri, paramBoolean1, locald);
  }

  public static void b(Uri paramUri1, Uri paramUri2, q paramq)
  {
    DialerController localDialerController = ViberApplication.getInstance().getEngine(true).getDialerController();
    i.k localk = new i.k(paramUri1, paramUri2, d.h, true, i.c.d, new i.k.a()
    {
      public boolean a()
      {
        return this.b.getPhoneState() != 0;
      }
    });
    localk.a(false);
    a(localk, paramq, null);
  }

  private static void b(e parame, r paramr, c paramc)
  {
    Uri localUri = parame.a;
    Set localSet;
    synchronized (g)
    {
      localSet = (Set)g.get(parame);
      if (paramc == null)
      {
        if (localSet == null)
          break label127;
        Iterator localIterator2 = localSet.iterator();
        if (!localIterator2.hasNext())
          break label127;
        ((q)localIterator2.next()).a(localUri, paramr);
      }
    }
    if (localSet != null)
    {
      Iterator localIterator1 = localSet.iterator();
      while (localIterator1.hasNext())
        ((q)localIterator1.next()).a(localUri, paramc);
    }
    label127: if (g.remove(parame) != null);
  }

  private static ContentResolver f()
  {
    return ViberApplication.getApplication().getContentResolver();
  }

  static abstract class a extends t.b
  {
    public a(Uri paramUri1, Uri paramUri2, t.d paramd, boolean paramBoolean)
    {
      super(paramUri2, paramd, paramBoolean);
    }

    protected void a(int paramInt, String paramString)
      throws Exception
    {
    }

    protected abstract void a(Request.Builder paramBuilder)
      throws Exception;

    protected void a(Request paramRequest, Response paramResponse)
      throws Exception
    {
      int i = paramResponse.code();
      String str = paramResponse.body().string();
      if (!paramResponse.isSuccessful())
        throw new IOException("Unexpected response code: " + i);
      a(i, str);
    }

    protected Request.Builder d()
      throws Exception
    {
      return new Request.Builder();
    }

    protected void e()
      throws Exception
    {
      e.b().a("SEND_MESSAGE", "performRequest");
      OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder(OkHttpClientFactory.Type.ABSTRACT_OK_HTTP_UPLOAD_TASK);
      ViberEnv.getOkHttpClientFactory().logRequests(localBuilder, this.v);
      Request.Builder localBuilder1 = d();
      a(localBuilder1);
      Request localRequest = localBuilder1.build();
      Response localResponse = localBuilder.build().newCall(localRequest).execute();
      if (this.t)
        throw new IOException("CANCELED");
      a(localRequest, localResponse);
      e.b().b("SEND_MESSAGE", "performRequest");
    }
  }

  static abstract class b
    implements UploadProgressListener, Runnable
  {
    public Uri k;
    public Uri l;
    protected boolean m;
    protected cr.c n;
    protected byte[] o;
    protected final t.d p;
    protected long q;
    protected final t.e r;
    protected volatile InputStream s;
    protected volatile boolean t;
    protected final int u = t.a();
    protected final Logger v = ViberEnv.getLogger();

    public b(Uri paramUri1, Uri paramUri2, t.d paramd, boolean paramBoolean)
    {
      this.l = paramUri1;
      if (paramUri2 != null);
      while (true)
      {
        this.k = paramUri2;
        this.p = paramd;
        this.r = new t.e(paramUri1, paramd, paramBoolean);
        this.m = paramBoolean;
        return;
        paramUri2 = paramUri1;
      }
    }

    public void a()
    {
      this.t = true;
    }

    protected void a(t.e parame, r paramr)
    {
      synchronized (t.c())
      {
        t.c().put(parame, paramr);
        return;
      }
    }

    protected void a(t.e parame, t.c paramc)
    {
      t.a(parame, null, paramc);
    }

    protected void b(t.e parame, r paramr)
    {
      a(parame, paramr);
      t.a(parame, paramr, null);
    }

    protected abstract void e()
      throws Exception;

    protected final InputStream f()
      throws IOException
    {
      InputStream localInputStream = g();
      this.s = localInputStream;
      return localInputStream;
    }

    protected InputStream g()
      throws IOException
    {
      Object localObject = t.b().openInputStream(this.l);
      if (this.m)
      {
        if (this.o != null)
        {
          localObject = cr.a((InputStream)localObject, this.o);
          this.n = ((cr.c)localObject);
        }
      }
      else
        return localObject;
      cr.c localc = cr.a((InputStream)localObject);
      this.n = localc;
      return localc;
    }

    protected EncryptionParams h()
    {
      if (this.n != null)
        return this.n.b();
      return null;
    }

    public void onUploadProgress(int paramInt)
    {
      if (this.k != null);
      switch (t.2.a[this.p.ordinal()])
      {
      default:
        return;
      case 4:
      case 5:
      case 6:
      }
      l.b(this.k, paramInt);
    }

    public void run()
    {
      if (!t.d().containsKey(this.r));
      for (int i = 1; (i != 0) && (this.l != null); i = 0)
        return;
      synchronized (t.c())
      {
        r localr = (r)t.c().get(this.r);
        if (localr != null)
        {
          t.a(this.r, localr, null);
          return;
        }
      }
      this.q = at.c(ViberApplication.getApplication(), this.l);
      try
      {
        e();
        return;
      }
      catch (TimeoutException localTimeoutException)
      {
        a(this.r, t.c.f);
        g.a().a(com.viber.voip.analytics.story.l.d.b("TimeoutException", localTimeoutException.getMessage()));
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        a(this.r, t.c.b);
        g.a().a(com.viber.voip.analytics.story.l.d.b("FileNotFoundException", localFileNotFoundException.getMessage()));
        return;
      }
      catch (a locala)
      {
        a(this.r, t.c.a);
        g.a().a(com.viber.voip.analytics.story.l.d.b("MediaIOException", locala.getMessage()));
        return;
      }
      catch (Exception localException)
      {
        a(this.r, t.c.a);
        g.a().a(com.viber.voip.analytics.story.l.d.b(localException.getClass().getName(), localException.getMessage()));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        a(this.r, t.c.a);
        g.a().a(com.viber.voip.analytics.story.l.d.b("OutOfMemoryError", localOutOfMemoryError.getMessage()));
        return;
      }
      finally
      {
        t.e().remove(this);
      }
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[6];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
      arrayOfc[4] = e;
      arrayOfc[5] = f;
    }
  }

  public static enum d
  {
    static
    {
      d[] arrayOfd = new d[8];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
      arrayOfd[2] = c;
      arrayOfd[3] = d;
      arrayOfd[4] = e;
      arrayOfd[5] = f;
      arrayOfd[6] = g;
      arrayOfd[7] = h;
    }
  }

  public static class e
  {
    public Uri a;
    public t.d b;
    public boolean c;

    public e(Uri paramUri, t.d paramd, boolean paramBoolean)
    {
      this.a = paramUri;
      this.b = paramd;
      this.c = paramBoolean;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = true;
      boolean bool2;
      if (this == paramObject)
        bool2 = bool1;
      e locale;
      boolean bool5;
      do
      {
        boolean bool3;
        boolean bool4;
        do
        {
          Class localClass1;
          Class localClass2;
          do
          {
            do
            {
              return bool2;
              bool2 = false;
            }
            while (paramObject == null);
            localClass1 = getClass();
            localClass2 = paramObject.getClass();
            bool2 = false;
          }
          while (localClass1 != localClass2);
          locale = (e)paramObject;
          bool3 = this.c;
          bool4 = locale.c;
          bool2 = false;
        }
        while (bool3 != bool4);
        if (this.a == null)
          break;
        bool5 = this.a.equals(locale.a);
        bool2 = false;
      }
      while (!bool5);
      if (this.b == locale.b);
      while (true)
      {
        return bool1;
        if (locale.a == null)
          break;
        return false;
        bool1 = false;
      }
    }

    public int hashCode()
    {
      int i;
      int j;
      if (this.a != null)
      {
        i = this.a.hashCode();
        j = i * 31;
        if (this.b == null)
          break label71;
      }
      label71: for (int k = this.b.hashCode(); ; k = 0)
      {
        int m = 31 * (k + j);
        boolean bool = this.c;
        int n = 0;
        if (bool)
          n = 1;
        return m + n;
        i = 0;
        break;
      }
    }

    public String toString()
    {
      return "UploadedRequest{uploadedUri=" + this.a + ", uploadedType=" + this.b + ", mEncrypt=" + this.c + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.t
 * JD-Core Version:    0.6.2
 */