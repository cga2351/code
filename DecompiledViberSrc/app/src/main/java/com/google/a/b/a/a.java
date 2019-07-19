package com.google.a.b.a;

import com.google.a.a.c.ac;
import com.google.a.a.c.h;
import com.google.a.a.c.r;
import com.google.a.a.c.s;
import com.google.a.a.c.w;
import com.google.a.a.d.c;
import com.google.a.a.f.q;
import com.google.a.a.f.z;
import java.io.IOException;

public class a extends com.google.a.a.b.d.a.a
{
  static
  {
    if ((com.google.a.a.b.a.a.intValue() == 1) && (com.google.a.a.b.a.b.intValue() >= 15));
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = com.google.a.a.b.a.d;
      z.b(bool, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.23.0 of the Drive API library.", arrayOfObject);
      return;
    }
  }

  a(a parama)
  {
    super(parama);
  }

  protected void a(com.google.a.a.b.d.b<?> paramb)
    throws IOException
  {
    super.a(paramb);
  }

  public b j()
  {
    return new b();
  }

  public static final class a extends com.google.a.a.b.d.a.a.a
  {
    public a(w paramw, c paramc, r paramr)
    {
      super(paramc, "https://www.googleapis.com/", "drive/v3/", paramr, false);
      j("batch/drive/v3");
    }

    public a a()
    {
      return new a(this);
    }

    public a h(String paramString)
    {
      return (a)super.e(paramString);
    }

    public a i(String paramString)
    {
      return (a)super.f(paramString);
    }

    public a j(String paramString)
    {
      return (a)super.c(paramString);
    }

    public a k(String paramString)
    {
      return (a)super.g(paramString);
    }
  }

  public class b
  {
    public b()
    {
    }

    public a a(com.google.a.b.a.a.a parama, com.google.a.a.c.b paramb)
      throws IOException
    {
      a locala = new a(parama, paramb);
      a.this.a(locala);
      return locala;
    }

    public b a(String paramString)
      throws IOException
    {
      b localb = new b(paramString);
      a.this.a(localb);
      return localb;
    }

    public d a()
      throws IOException
    {
      d locald = new d();
      a.this.a(locald);
      return locald;
    }

    public e a(String paramString, com.google.a.b.a.a.a parama)
      throws IOException
    {
      e locale = new e(paramString, parama);
      a.this.a(locale);
      return locale;
    }

    public e a(String paramString, com.google.a.b.a.a.a parama, com.google.a.a.c.b paramb)
      throws IOException
    {
      e locale = new e(paramString, parama, paramb);
      a.this.a(locale);
      return locale;
    }

    public c b(String paramString)
      throws IOException
    {
      c localc = new c(paramString);
      a.this.a(localc);
      return localc;
    }

    public class a extends b<com.google.a.b.a.a.a>
    {

      @q
      private Boolean ignoreDefaultVisibility;

      @q
      private Boolean keepRevisionForever;

      @q
      private String ocrLanguage;

      @q
      private Boolean supportsTeamDrives;

      @q
      private Boolean useContentAsIndexableText;

      protected a(com.google.a.b.a.a.a paramb, com.google.a.a.c.b arg3)
      {
        super("POST", "/upload/" + a.this.b() + "files", paramb, com.google.a.b.a.a.a.class);
        com.google.a.a.c.b localb;
        a(localb);
      }

      public a a(String paramString)
      {
        return (a)super.b(paramString);
      }

      public a e(String paramString, Object paramObject)
      {
        return (a)super.f(paramString, paramObject);
      }
    }

    public class b extends b<Void>
    {

      @q
      private String fileId;

      @q
      private Boolean supportsTeamDrives;

      protected b(String arg2)
      {
        super("DELETE", "files/{fileId}", null, Void.class);
        Object localObject;
        this.fileId = ((String)z.a(localObject, "Required parameter fileId must be specified."));
      }

      public b a(String paramString)
      {
        return (b)super.b(paramString);
      }

      public b e(String paramString, Object paramObject)
      {
        return (b)super.f(paramString, paramObject);
      }
    }

    public class c extends b<com.google.a.b.a.a.a>
    {

      @q
      private Boolean acknowledgeAbuse;

      @q
      private String fileId;

      @q
      private Boolean supportsTeamDrives;

      protected c(String arg2)
      {
        super("GET", "files/{fileId}", null, com.google.a.b.a.a.a.class);
        Object localObject;
        this.fileId = ((String)z.a(localObject, "Required parameter fileId must be specified."));
        e();
      }

      public c a(String paramString)
      {
        return (c)super.b(paramString);
      }

      public c e(String paramString, Object paramObject)
      {
        return (c)super.f(paramString, paramObject);
      }

      public h f()
      {
        if (("media".equals(get("alt"))) && (d() == null));
        for (String str = a.this.a() + "download/" + a.this.b(); ; str = a.this.c())
          return new h(ac.a(str, a(), this, true));
      }

      public s h()
        throws IOException
      {
        return super.h();
      }
    }

    public class d extends b<com.google.a.b.a.a.b>
    {

      @q
      private String corpora;

      @q
      private String corpus;

      @q
      private Boolean includeTeamDriveItems;

      @q
      private String orderBy;

      @q
      private Integer pageSize;

      @q
      private String pageToken;

      @q
      private String q;

      @q
      private String spaces;

      @q
      private Boolean supportsTeamDrives;

      @q
      private String teamDriveId;

      protected d()
      {
        super("GET", "files", null, com.google.a.b.a.a.b.class);
      }

      public d a(Integer paramInteger)
      {
        this.pageSize = paramInteger;
        return this;
      }

      public d a(String paramString)
      {
        return (d)super.b(paramString);
      }

      public d c(String paramString)
      {
        this.q = paramString;
        return this;
      }

      public d d(String paramString)
      {
        this.spaces = paramString;
        return this;
      }

      public d e(String paramString, Object paramObject)
      {
        return (d)super.f(paramString, paramObject);
      }
    }

    public class e extends b<com.google.a.b.a.a.a>
    {

      @q
      private String addParents;

      @q
      private String fileId;

      @q
      private Boolean keepRevisionForever;

      @q
      private String ocrLanguage;

      @q
      private String removeParents;

      @q
      private Boolean supportsTeamDrives;

      @q
      private Boolean useContentAsIndexableText;

      protected e(String parama, com.google.a.b.a.a.a arg3)
      {
        super("PATCH", "files/{fileId}", localObject, com.google.a.b.a.a.a.class);
        this.fileId = ((String)z.a(parama, "Required parameter fileId must be specified."));
      }

      protected e(String parama, com.google.a.b.a.a.a paramb, com.google.a.a.c.b arg4)
      {
        super("PATCH", "/upload/" + a.this.b() + "files/{fileId}", paramb, com.google.a.b.a.a.a.class);
        this.fileId = ((String)z.a(parama, "Required parameter fileId must be specified."));
        com.google.a.a.c.b localb;
        a(localb);
      }

      public e a(String paramString)
      {
        return (e)super.b(paramString);
      }

      public e c(String paramString)
      {
        this.addParents = paramString;
        return this;
      }

      public e e(String paramString, Object paramObject)
      {
        return (e)super.f(paramString, paramObject);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.b.a.a
 * JD-Core Version:    0.6.2
 */