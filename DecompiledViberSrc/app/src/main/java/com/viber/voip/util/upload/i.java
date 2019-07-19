package com.viber.voip.util.upload;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Base64;
import com.google.d.f;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.Engine;
import com.viber.jni.GetMD5CryptedFileResult;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.f;
import com.viber.voip.e.a.e;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.p;
import com.viber.voip.pixie.PixieControllerNativeImpl;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.settings.d.ab;
import com.viber.voip.util.ag;
import com.viber.voip.util.as;
import com.viber.voip.util.at;
import com.viber.voip.util.bu;
import com.viber.voip.util.cl;
import com.viber.voip.util.cr;
import com.viber.voip.util.http.OkHttpClientFactory;
import com.viber.voip.util.http.OkHttpClientFactory.Type;
import f.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class i
{
  private static final Logger a = ViberEnv.getLogger();

  public static c a(MessageEntity paramMessageEntity)
  {
    switch (paramMessageEntity.getMimeType())
    {
    default:
      return c.d;
    case 1:
    case 1003:
      return c.b;
    case 3:
    case 1004:
    case 1010:
      return c.a;
    case 2:
    }
    return c.c;
  }

  public static c a(String paramString)
  {
    if (paramString.equals(as.a.a()))
      return c.b;
    if (paramString.equals(as.d.a()))
      return c.a;
    if (paramString.equals(as.n.a()))
      return c.c;
    return c.d;
  }

  public static String a()
  {
    return p.d() + "-" + "c7185bf51d54f48d3bdf4f350beda5a8d0244234".substring(0, 7);
  }

  private static n b(t.d paramd)
  {
    switch (1.a[paramd.ordinal()])
    {
    default:
      return null;
    case 1:
      return n.c;
    case 2:
    case 3:
      return n.a;
    case 4:
    }
    return n.b;
  }

  public static boolean b(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.length() < 30) || (TextUtils.isDigitsOnly(paramString));
  }

  public static boolean c(String paramString)
  {
    if (b(paramString))
    {
      RuntimeException localRuntimeException = new RuntimeException("Download id is invalid: " + paramString);
      a.a(localRuntimeException, "");
      return true;
    }
    return false;
  }

  private static Uri d()
  {
    return Uri.parse(d.ab.c.d());
  }

  private static Uri e()
  {
    return Uri.parse(d.ab.d.d());
  }

  public static class a extends i.j
  {
    a(i.j.a parama)
    {
      super();
      boolean bool = PixieControllerNativeImpl.getInstance().isEnabled();
      if (bool)
        this.b.a("vrs3", Boolean.toString(bool));
    }

    private void b(i.c paramc, long paramLong, String paramString)
    {
      if (paramc.e != null)
        this.b.a("fltp", paramc.e);
      this.b.a("flsz", Long.toString(paramLong));
      this.b.a("cksm", paramString);
    }

    protected String a()
    {
      return i.b().toString() + this.a.g;
    }

    public void a(long paramLong, String paramString, i.c paramc, i.o paramo)
    {
      b(paramc, paramLong, paramString);
      this.b.a("vrnt", Integer.toString(paramo.d));
    }

    public void a(i.c paramc, long paramLong, String paramString)
    {
      b(paramc, paramLong, paramString);
    }

    public void a(boolean paramBoolean)
    {
      b(paramBoolean);
    }

    protected String b()
    {
      return "ALLOC";
    }

    public a c()
      throws IOException
    {
      String str = f();
      return (a)new f().a(str, a.class);
    }

    public static class a
    {

      @com.google.d.a.c(a="Media")
      public a a;

      private static class a
      {

        @com.google.d.a.c(a="ObjectID")
        public String a;

        @com.google.d.a.c(a="Upload")
        public a b;

        @com.google.d.a.c(a="UploadVariant")
        public a c;

        @com.google.d.a.c(a="ConnectTo")
        private String d;

        private static class a
        {

          @com.google.d.a.c(a="Method")
          private String a;

          @com.google.d.a.c(a="Url")
          private String b;

          @com.google.d.a.c(a="Signed")
          private a c;

          private static class a
          {

            @com.google.d.a.c(a="Content-Type")
            public String a;

            @com.google.d.a.c(a="Content-MD5")
            public String b;

            @com.google.d.a.c(a="Custom")
            public LinkedHashMap<String, String> c;
          }
        }
      }
    }
  }

  private static class b
  {
    public final long a;
    public final String b;
    public final byte[] c;

    public b(long paramLong, String paramString, byte[] paramArrayOfByte)
    {
      this.a = paramLong;
      this.b = paramString;
      this.c = paramArrayOfByte;
    }
  }

  public static enum c
  {
    public final String e;

    static
    {
      c[] arrayOfc = new c[4];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
    }

    private c(String paramString)
    {
      this.e = paramString;
    }

    public static c a(String paramString)
    {
      c localc;
      if ((paramString == null) || (paramString.isEmpty()) || ("null".equals(paramString)))
      {
        localc = d;
        return localc;
      }
      c[] arrayOfc = values();
      int i = arrayOfc.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label64;
        localc = arrayOfc[j];
        if (paramString.equals(localc.e))
          break;
      }
      label64: return d;
    }
  }

  public static class d extends i.j
  {
    public d(i.j.a parama, String paramString)
    {
      super();
      this.b.a("dlid", paramString);
    }

    protected String a()
    {
      return i.c().toString() + this.a.g;
    }

    public void a(i.c paramc)
    {
      this.b.a("fltp", paramc.e);
    }

    public void a(i.o paramo)
    {
      this.b.a("vrnt", Integer.toString(paramo.d));
    }

    public void a(boolean paramBoolean)
    {
      b(paramBoolean);
    }

    protected String b()
    {
      return "GET";
    }
  }

  public static class e extends s.e
  {
    protected Boolean p;
    private t.d r;
    private i.c s;
    private i.o t;

    public e(String paramString1, String paramString2, String paramString3, EncryptionParams paramEncryptionParams, t.d paramd, i.c paramc, i.o paramo)
    {
      super(paramString1, paramString2, paramString3, paramEncryptionParams);
      this.r = paramd;
      this.s = paramc;
      this.t = paramo;
    }

    protected String a()
      throws IOException
    {
      if (i.c(this.q))
        throw new IOException("Invalid download id");
      i.d locald = new i.d(i.j.a(this.r), this.q);
      locald.a(this.a);
      if (this.s != i.c.d)
        locald.a(this.s);
      if (this.t != i.o.c)
        locald.a(this.t);
      if (this.p != null)
        locald.a(this.p.booleanValue());
      i.n localn = i.a(this.r);
      if (localn != null)
        locald.a(localn);
      Response localResponse = locald.c(false);
      localResponse.body().string();
      if (!localResponse.isRedirect())
        throw new IOException("Unexpected response code: " + localResponse.code());
      String str = localResponse.header("Location");
      if (str == null)
        throw new IOException("No location response header");
      return str;
    }

    protected void a(OkHttpClient.Builder paramBuilder, Request.Builder paramBuilder1)
    {
      paramBuilder.followRedirects(false);
    }

    public void a(boolean paramBoolean)
    {
      this.p = Boolean.valueOf(paramBoolean);
    }
  }

  public static class f extends i.g
  {
    private static final Executor w = av.f.a;
    protected Uri a;
    protected i.o b;
    protected i.c c;
    protected ObjectId d = ObjectId.EMPTY;
    protected Boolean e;
    protected i.p f;
    private CountDownLatch x;
    private Exception y;

    public f(Uri paramUri1, Uri paramUri2, t.d paramd, boolean paramBoolean, i.c paramc)
    {
      super(paramUri2, paramd, paramBoolean, paramc, null);
    }

    private void i()
    {
      av.f.a.execute(new j(this));
    }

    public f a(Uri paramUri, i.o paramo, i.c paramc)
    {
      this.a = paramUri;
      this.b = paramo;
      this.c = paramc;
      return this;
    }

    protected RequestBody a(MediaType paramMediaType, InputStream paramInputStream, long paramLong)
    {
      return new i.l(paramMediaType, paramInputStream, paramLong, new i.l.a()
      {
        public void a(int paramAnonymousInt)
        {
          i.f.this.onUploadProgress(paramAnonymousInt);
        }

        public boolean a()
        {
          return i.f.this.t;
        }
      });
    }

    protected void a(int paramInt, String paramString)
      throws Exception
    {
      if (this.a != null)
      {
        if (PixieControllerNativeImpl.getInstance().isEnabled())
          i();
        this.x.await();
      }
      if (this.y != null)
        throw this.y;
      if (this.a == null)
      {
        b(this.r, new r(this.d, this.q, this.g, h()));
        return;
      }
      t.e locale = this.r;
      r localr = new r(this.d, this.q, this.g, h(), new r(this.d, this.f.q, this.f.g, this.f.h()));
      b(locale, localr);
    }

    protected void a(Request.Builder paramBuilder)
      throws Exception
    {
      e.b().a("SEND_MESSAGE", "buildRequest");
      i.b localb1 = a(this.l);
      if (this.a != null);
      for (i.b localb2 = a(this.a); ; localb2 = null)
      {
        i.a locala = new i.a(i.j.a(this.p));
        locala.a(this.v);
        locala.a(this.h, localb1.a, localb1.b);
        if (this.a != null)
          locala.a(localb2.a, localb2.b, this.c, this.b);
        if (this.e != null)
          locala.a(this.e.booleanValue());
        i.n localn = i.a(this.p);
        if (localn != null)
          locala.a(localn);
        i.a.a locala1 = locala.c();
        this.j = locala1.a;
        this.i = locala1.a.b;
        this.q = localb1.a;
        this.o = localb1.c;
        this.g = localb1.b;
        boolean bool;
        i.a.a.a.a locala3;
        try
        {
          this.d = ObjectId.fromServerString(locala1.a.a);
          bool = PixieControllerNativeImpl.getInstance().isEnabled();
          if (bool)
          {
            Uri localUri = Uri.parse(i.a.a.a.a.a(this.j.b));
            PixieControllerNativeImpl.getInstance().addRedirect(localUri.getHost(), i.a.a.a.a(this.j));
          }
          if (this.a == null)
            break label385;
          locala3 = locala1.a.c;
          if (locala3 == null)
            throw new IOException("uploadVariantAsync missing");
        }
        catch (ObjectId.a locala2)
        {
          throw new IOException("Invalid objectId format", locala2);
        }
        this.f = new i.p(this.a, this.p, this.m, localb2.a, localb2.b, localb2.c, locala3, this);
        this.x = new CountDownLatch(1);
        if (!bool)
          i();
        if (this.t)
          throw new IOException("CANCELED");
        label385: RequestBody localRequestBody = a(c(), f(), this.q);
        paramBuilder.method(i.a.a.a.a.c(this.i), localRequestBody);
        super.a(paramBuilder);
        e.b().b("SEND_MESSAGE", "buildRequest");
        return;
      }
    }

    public void a(boolean paramBoolean)
    {
      this.e = Boolean.valueOf(paramBoolean);
    }
  }

  private static abstract class g extends t.a
  {
    protected String g;
    protected i.c h;
    protected i.a.a.a.a i;
    protected i.a.a.a j;

    private g(Uri paramUri1, Uri paramUri2, t.d paramd, boolean paramBoolean, i.c paramc)
    {
      super(paramUri2, paramd, paramBoolean);
      this.h = paramc;
    }

    protected i.b a(Uri paramUri)
      throws IOException
    {
      if (this.m)
      {
        File localFile = at.a(ViberApplication.getApplication(), paramUri);
        GetMD5CryptedFileResult localGetMD5CryptedFileResult = cr.a(localFile);
        return new i.b(localFile.length(), localGetMD5CryptedFileResult.getChecksum(), localGetMD5CryptedFileResult.getKey());
      }
      byte[] arrayOfByte = bu.a(ViberApplication.getApplication().getContentResolver().openInputStream(paramUri));
      return new i.b(at.c(ViberApplication.getApplication(), paramUri), Base64.encodeToString(arrayOfByte, 2), null);
    }

    protected void a(Request.Builder paramBuilder)
      throws Exception
    {
      paramBuilder.url(i.a.a.a.a.a(this.i));
      paramBuilder.header("Content-Type", i.a.a.a.a.b(this.i).a);
      paramBuilder.header("Content-MD5", i.a.a.a.a.b(this.i).b);
      Iterator localIterator = i.a.a.a.a.b(this.i).c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramBuilder.header((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }

    protected MediaType c()
    {
      String str = i.a.a.a.a.b(this.i).a;
      if (str == null)
        str = "application/octet-stream";
      return MediaType.parse(str);
    }
  }

  public static class h
    implements Runnable
  {
    private MessageEntity a;
    private n b;
    private Logger c;

    public h(MessageEntity paramMessageEntity, n paramn)
    {
      this.a = paramMessageEntity;
      this.b = paramn;
      this.c = ViberEnv.getLogger();
    }

    private void a(i.o paramo, i.c paramc, n paramn)
    {
      boolean bool;
      i.i locali;
      if ((this.a.isFile()) || (this.a.isVideoPtt()))
      {
        bool = true;
        if (!this.a.getObjectId().isEmpty())
          break label124;
        locali = new i.i(this.a.getDownloadId(), paramc, paramo, bool, paramn);
        label57: if (!bool)
          break label148;
        locali.a(this.a.isForwardedFromPG(), this.a.isPublicGroupBehavior());
      }
      while (true)
      {
        locali.a(ViberEnv.getLogger(this.c, "vrnt:" + paramo));
        locali.run();
        return;
        bool = false;
        break;
        label124: locali = new i.i(this.a.getObjectId(), paramc, paramo, bool, paramn);
        break label57;
        label148: locali.a(this.a.isForwardedFromPG());
      }
    }

    public void run()
    {
      a(i.o.c, i.a(this.a), new n()
      {
        public void a(final n.a paramAnonymousa)
        {
          int i = 1;
          i.c localc;
          if (paramAnonymousa == n.a.a)
            if (i.h.a(i.h.this).isVideoPtt())
              localc = i.c.d;
          while (true)
            if (i != 0)
            {
              i.h.a(i.h.this, i.o.a, localc, new n()
              {
                public void a(n.a paramAnonymous2a)
                {
                  if (paramAnonymous2a != n.a.a);
                  i.h.b(i.h.this).a(paramAnonymousa);
                }
              });
              return;
              if (!i.h.a(i.h.this).isFile())
                localc = i.c.b;
            }
            else
            {
              i.h.b(i.h.this).a(paramAnonymousa);
              return;
              i.h.b(i.h.this).a(paramAnonymousa);
              return;
              localc = null;
              i = 0;
            }
        }
      });
    }
  }

  private static class i extends i.j
    implements Runnable
  {
    private n d;

    public i(ObjectId paramObjectId, i.c paramc, i.o paramo, boolean paramBoolean, n paramn)
    {
      this(paramc, paramo, paramBoolean, paramn);
      this.b.a("otid", paramObjectId.toServerString());
    }

    private i(i.c paramc, i.o paramo, boolean paramBoolean, n paramn)
    {
    }

    public i(String paramString, i.c paramc, i.o paramo, boolean paramBoolean, n paramn)
    {
      this(paramc, paramo, paramBoolean, paramn);
      i.c(paramString);
      this.b.a("dlid", paramString);
    }

    private void a(i.c paramc)
    {
      this.b.a("fltp", paramc.e);
    }

    private void a(i.o paramo)
    {
      this.b.a("vrnt", Integer.toString(paramo.d));
    }

    private boolean c()
      throws Exception
    {
      Response localResponse = c(true);
      localResponse.code();
      String str = localResponse.body().string();
      if (localResponse.isSuccessful())
      {
        new f().a(str, a.class);
        return true;
      }
      return false;
    }

    protected String a()
    {
      return i.b().toString() + this.a.g;
    }

    public void a(boolean paramBoolean)
    {
      b(paramBoolean);
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      b(paramBoolean1);
      b(paramBoolean2);
    }

    protected String b()
    {
      return "RENEW";
    }

    public void run()
    {
      try
      {
        boolean bool = c();
        n localn = this.d;
        if (bool);
        for (n.a locala = n.a.a; ; locala = n.a.b)
        {
          localn.a(locala);
          return;
        }
      }
      catch (Exception localException)
      {
        this.d.a(n.a.c);
      }
    }

    private static class a
    {
    }
  }

  private static abstract class j
  {
    protected final a a;
    protected i.m b = new i.m(null);
    protected Logger c = ViberEnv.getLogger(getClass());

    public j(a parama)
    {
      this.a = parama;
      e();
    }

    public static a a(t.d paramd)
    {
      switch (i.1.a[paramd.ordinal()])
      {
      default:
        throw new RuntimeException("Unexpected type: " + paramd);
      case 5:
        return a.a;
      case 6:
        return a.b;
      case 2:
        return a.d;
      case 3:
        return a.e;
      case 4:
        return a.d;
      case 1:
        return a.d;
      case 7:
        return a.f;
      case 8:
      }
      return a.c;
    }

    private String c()
    {
      return Long.toHexString(0xFFFFFFFF & new SecureRandom().nextInt() | (0xFFFFFFFF & System.currentTimeMillis() / 1000L) << 32);
    }

    protected abstract String a();

    void a(Logger paramLogger)
    {
      this.c = ViberEnv.getLogger();
    }

    protected void a(i.n paramn)
    {
      this.b.a("usag", paramn.d);
    }

    protected String b()
    {
      return "GET";
    }

    protected void b(boolean paramBoolean)
    {
      i.m localm = this.b;
      if (paramBoolean);
      for (String str = "true"; ; str = "false")
      {
        localm.a("ispg", str);
        return;
      }
    }

    protected Response c(boolean paramBoolean)
      throws IOException
    {
      Uri localUri = d();
      OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder(OkHttpClientFactory.Type.MEDIA_SHARE);
      localBuilder.followRedirects(paramBoolean);
      ViberEnv.getOkHttpClientFactory().logRequests(localBuilder, this.c);
      Request.Builder localBuilder1 = new Request.Builder().url(localUri.toString());
      localBuilder1.method(b(), null);
      Request localRequest = localBuilder1.build();
      return localBuilder.build().newCall(localRequest).execute();
    }

    public Uri d()
    {
      Uri.Builder localBuilder = Uri.parse(a()).buildUpon();
      this.b.a(localBuilder);
      return localBuilder.build();
    }

    protected void e()
    {
      if (ViberApplication.isTablet(ViberApplication.getApplication()));
      for (int i = 21; ; i = 1)
      {
        int j = ViberApplication.getInstance().getEngine(true).getPhoneController().getDefaultProtocolVersion();
        this.b.a("rqvr", Integer.toString(1)).a("udid", ViberApplication.getInstance().getHardwareParameters().getUdid()).a("sdcc", Integer.toString(ViberApplication.getInstance().getActivationController().getCountryCodeInt())).a("vcpv", Integer.toString(j)).a("styp", Integer.toString(i)).a("xuav", i.a()).a("xuat", c());
        return;
      }
    }

    protected String f()
      throws IOException
    {
      Response localResponse = c(true);
      int i = localResponse.code();
      String str = localResponse.body().string();
      if (!localResponse.isSuccessful())
      {
        com.viber.voip.util.c.a locala = new com.viber.voip.util.c.a("Unexpected response code: " + i);
        locala.a(i, str);
        throw locala;
      }
      return str;
    }

    public static enum a
    {
      public final String g;

      static
      {
        a[] arrayOfa = new a[6];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
        arrayOfa[3] = d;
        arrayOfa[4] = e;
        arrayOfa[5] = f;
      }

      private a(String paramString)
      {
        this.g = paramString;
      }
    }
  }

  static class k extends i.f
  {
    private final long w = TimeUnit.SECONDS.toMillis(5L);
    private final a x;

    public k(Uri paramUri1, Uri paramUri2, t.d paramd, boolean paramBoolean, i.c paramc, a parama)
    {
      super(paramUri2, paramd, paramBoolean, paramc);
      if (parama != null);
      while (true)
      {
        this.x = parama;
        return;
        parama = a.a;
      }
    }

    protected RequestBody a(MediaType paramMediaType, InputStream paramInputStream, long paramLong)
    {
      return new i.l(paramMediaType, paramInputStream, paramLong, new i.l.a()
      {
        public void a(int paramAnonymousInt)
        {
          i.k.this.onUploadProgress(paramAnonymousInt);
          if (i.k.a(i.k.this).a());
          try
          {
            Thread.sleep(i.k.b(i.k.this));
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
          }
        }

        public boolean a()
        {
          return i.k.this.t;
        }
      });
    }

    static abstract interface a
    {
      public static final a a = (a)cl.b(a.class);

      @ag(a=false)
      public abstract boolean a();
    }
  }

  private static class l extends RequestBody
  {
    private final MediaType a;
    private final InputStream b;
    private final long c;
    private final a d;

    public l(MediaType paramMediaType, InputStream paramInputStream, long paramLong, a parama)
    {
      this.a = paramMediaType;
      this.b = paramInputStream;
      this.c = paramLong;
      this.d = parama;
    }

    public long contentLength()
    {
      return this.c;
    }

    public MediaType contentType()
    {
      return this.a;
    }

    public void writeTo(d paramd)
      throws IOException
    {
      byte[] arrayOfByte = com.viber.voip.b.b.a.a(8192);
      double d1 = this.c;
      int i = 0;
      long l = 0L;
      int j;
      try
      {
        j = this.b.read(arrayOfByte);
        if (j == -1)
          break label135;
        if (this.d.a())
          throw new IOException("CANCELLED");
      }
      finally
      {
        this.b.close();
        paramd.flush();
        com.viber.voip.b.b.a.a(arrayOfByte);
      }
      paramd.c(arrayOfByte, 0, j);
      l += j;
      int k = (int)(100.0D * (l / d1));
      if (k != i)
        this.d.a(k);
      while (true)
      {
        i = k;
        break;
        label135: this.b.close();
        paramd.flush();
        com.viber.voip.b.b.a.a(arrayOfByte);
        return;
        k = i;
      }
    }

    public static abstract interface a
    {
      public abstract void a(int paramInt);

      public abstract boolean a();
    }
  }

  private static class m
    implements Comparator<Map.Entry<String, ArrayList<String>>>
  {
    private LinkedHashMap<String, ArrayList<String>> a = new LinkedHashMap();

    public int a(Map.Entry<String, ArrayList<String>> paramEntry1, Map.Entry<String, ArrayList<String>> paramEntry2)
    {
      return ((String)paramEntry1.getKey()).compareTo((String)paramEntry2.getKey());
    }

    public m a(String paramString1, String paramString2)
    {
      ArrayList localArrayList = (ArrayList)this.a.get(paramString1);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        this.a.put(paramString1, localArrayList);
      }
      localArrayList.add(paramString2);
      return this;
    }

    public void a(Uri.Builder paramBuilder)
    {
      ArrayList localArrayList = new ArrayList(this.a.entrySet());
      Collections.sort(localArrayList, this);
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        String str = (String)localEntry.getKey();
        Iterator localIterator2 = ((ArrayList)localEntry.getValue()).iterator();
        while (localIterator2.hasNext())
          paramBuilder.appendQueryParameter(str, (String)localIterator2.next());
      }
    }
  }

  public static enum n
  {
    public final String d;

    static
    {
      n[] arrayOfn = new n[3];
      arrayOfn[0] = a;
      arrayOfn[1] = b;
      arrayOfn[2] = c;
    }

    private n(String paramString)
    {
      this.d = paramString;
    }
  }

  public static enum o
  {
    public final int d;

    static
    {
      o[] arrayOfo = new o[3];
      arrayOfo[0] = a;
      arrayOfo[1] = b;
      arrayOfo[2] = c;
    }

    private o(int paramInt)
    {
      this.d = paramInt;
    }

    public static o a(int paramInt)
    {
      for (o localo : values())
        if (localo.d == paramInt)
          return localo;
      return c;
    }
  }

  private static class p extends i.g
  {
    private final i.f a;

    p(Uri paramUri, t.d paramd, boolean paramBoolean, long paramLong, String paramString, byte[] paramArrayOfByte, i.a.a.a.a parama, i.f paramf)
    {
      super(null, paramd, paramBoolean, i.c.b, null);
      this.q = paramLong;
      this.g = paramString;
      this.o = paramArrayOfByte;
      this.i = parama;
      this.a = paramf;
    }

    protected void a(Request.Builder paramBuilder)
      throws Exception
    {
      super.a(paramBuilder);
      i.l locall = new i.l(c(), f(), this.q, new i.l.a()
      {
        public void a(int paramAnonymousInt)
        {
        }

        public boolean a()
        {
          return i.p.a(i.p.this).t;
        }
      });
      paramBuilder.method(i.a.a.a.a.c(this.i), locall);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.i
 * JD-Core Version:    0.6.2
 */