package com.viber.voip.backup.f;

import android.net.Uri;
import com.viber.jni.EncryptionParams;
import com.viber.voip.backup.c.b;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.util.upload.m;
import com.viber.voip.util.upload.q;
import com.viber.voip.util.upload.t;
import com.viber.voip.util.upload.t.c;
import java.io.File;

public class d
  implements c
{
  private a a;
  private volatile File b;

  public d(a parama)
  {
    this.a = parama;
  }

  public void a()
  {
    File localFile = this.b;
    if (localFile != null)
      t.a(Uri.fromFile(localFile));
  }

  public void a(File paramFile, com.viber.voip.backup.r paramr)
    throws com.viber.voip.backup.c.d
  {
    b localb = new b(paramr, null);
    c localc = new c(null);
    t.a(localb);
    this.b = paramFile;
    t.b(Uri.fromFile(paramFile), dx.a, localc);
    t.b(localb);
    this.b = null;
    t.c localc1 = localc.a();
    if (localc1 != null)
    {
      if (t.c.d == localc1)
        throw new b();
      throw new com.viber.voip.backup.c.d(localc.a().name());
    }
  }

  public static abstract interface a
  {
    public abstract void a(a parama);

    public static class a
    {
      public static final a a = new a(0L, "");
      public final String b;
      public final long c;

      public a(long paramLong, String paramString)
      {
        this.c = paramLong;
        this.b = paramString;
      }

      public String toString()
      {
        return "BackupResult{objectId=" + this.c + ", encryptionParams='" + this.b + '\'' + '}';
      }
    }
  }

  private final class b
    implements m
  {
    private final com.viber.voip.backup.r b;

    private b(com.viber.voip.backup.r arg2)
    {
      com.viber.voip.backup.r localr;
      if (localr != null);
      while (true)
      {
        this.b = localr;
        return;
        localr = com.viber.voip.backup.r.j;
      }
    }

    public void a(Uri paramUri, int paramInt)
    {
      if (dx.a.equals(paramUri))
        this.b.a(paramInt);
    }
  }

  private final class c
    implements q
  {
    private volatile t.c b;

    private c()
    {
    }

    public t.c a()
    {
      return this.b;
    }

    public void a(Uri paramUri, com.viber.voip.util.upload.r paramr)
    {
      d.a(d.this).a(new d.a.a(paramr.a.toLong(), EncryptionParams.serializeEncryptionParams(paramr.d)));
    }

    public void a(Uri paramUri, t.c paramc)
    {
      this.b = paramc;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.f.d
 * JD-Core Version:    0.6.2
 */