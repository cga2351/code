package com.viber.voip.backgrounds.c;

import android.app.Application;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backgrounds.f;
import com.viber.voip.backgrounds.l;
import com.viber.voip.backgrounds.p;
import com.viber.voip.util.ap;
import com.viber.voip.util.at;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public abstract class h
  implements com.viber.voip.util.upload.m, Runnable
{
  private static final Logger a = ViberEnv.getLogger();
  protected f b = new f()
  {
    public void a(final com.viber.voip.backgrounds.a paramAnonymousa)
    {
      h.b(h.this).post(new Runnable()
      {
        public void run()
        {
          h.a(h.this).a(paramAnonymousa);
        }
      });
    }

    public void a(final l paramAnonymousl)
    {
      h.b(h.this).post(new Runnable()
      {
        public void run()
        {
          h.a(h.this).a(paramAnonymousl);
        }
      });
    }

    public void a(final l paramAnonymousl, final int paramAnonymousInt)
    {
      h.b(h.this).post(new Runnable()
      {
        public void run()
        {
          h.a(h.this).a(paramAnonymousl, paramAnonymousInt);
        }
      });
    }

    public void a(final l paramAnonymousl, final p paramAnonymousp)
    {
      h.b(h.this).post(new Runnable()
      {
        public void run()
        {
          h.a(h.this).a(paramAnonymousl, paramAnonymousp);
        }
      });
    }

    public void b(final l paramAnonymousl)
    {
      h.b(h.this).post(new Runnable()
      {
        public void run()
        {
          h.a(h.this).b(paramAnonymousl);
        }
      });
    }
  };
  private File c;
  private File d;
  private String e;
  private com.viber.voip.util.upload.b f;
  private l g;
  private Handler h = av.a(av.e.a);
  private f i;
  private com.viber.voip.backgrounds.b j;
  private com.viber.voip.backgrounds.b.a k;

  public h(l paraml, com.viber.voip.backgrounds.b paramb, f paramf, com.viber.voip.backgrounds.b.a parama)
  {
    this.i = paramf;
    this.j = paramb;
    this.k = parama;
    this.g = paraml;
    this.e = com.viber.voip.backgrounds.m.a();
    this.c = com.viber.voip.backgrounds.m.a(this.e, ViberApplication.getApplication());
    this.d = at.g(this.c);
    this.f = new com.viber.voip.util.upload.b(this.e, this.c.getPath(), this.d.getPath());
    this.f.a(this);
  }

  private l a(InputStream paramInputStream)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    ZipInputStream localZipInputStream = new ZipInputStream(paramInputStream);
    List localList = this.k.a();
    p localp1 = com.viber.voip.backgrounds.m.a(this.g.a, localList);
    com.viber.voip.backgrounds.m.a(this.g.a, localp1, true);
    ZipEntry localZipEntry = localZipInputStream.getNextEntry();
    int m = 0;
    int i1;
    label97: int i4;
    boolean bool2;
    String str3;
    label222: p localp2;
    if (localZipEntry != null)
    {
      int n = localZipEntry.getName().lastIndexOf("/");
      String str1 = localZipEntry.getName();
      if (n > 0)
      {
        i1 = n + 1;
        String str2 = str1.substring(i1);
        if (localZipEntry.isDirectory())
          break label507;
        int i3 = com.viber.voip.backgrounds.m.a(str2);
        if ((i3 < 0) || (a(localArrayList, i3)))
          break label507;
        i4 = m + 1;
        boolean bool1 = str2.startsWith("c");
        if ((!str2.startsWith("t")) && (!bool1))
          break label356;
        bool2 = true;
        if (!bool1)
          break label501;
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          p localp3 = (p)localIterator.next();
          if (localp3.a == i3)
          {
            str3 = localp3.c;
            localp2 = new p(i3, this.g.a, bool2, str3);
          }
        }
      }
    }
    while (true)
    {
      try
      {
        c.a(localp2.h.getPath(), localZipInputStream);
        this.j.a(localp2);
        if (localp2.a != localp1.a)
          at.f(new File(localp2.h.getPath()));
        com.viber.voip.backgrounds.m.b(this.g.a);
        this.b.a(this.g, localp2);
        localArrayList.add(localp2);
        i2 = i4;
        localZipInputStream.closeEntry();
        localZipEntry = localZipInputStream.getNextEntry();
        m = i2;
        break;
        i1 = 0;
        break label97;
        label356: bool2 = false;
      }
      catch (com.viber.voip.backgrounds.b.a locala)
      {
        throw new IOException("Low storage during deployment! Aborting");
      }
      localZipInputStream.close();
      if ((localp1.a >= 0) && (!a(localArrayList, localp1.a)) && (at.a(new File(localp1.i.getPath()))))
      {
        localArrayList.add(0, localp1);
        m++;
      }
      if (m == 0)
        throw new IOException("Unzip, no backgrounds unzipped, generating an exception");
      this.g.a(true);
      this.g.a(localArrayList);
      this.j.a(this.g.a());
      this.b.a(this.g);
      localZipInputStream.close();
      paramInputStream.close();
      return this.g;
      label501: str3 = null;
      break label222;
      label507: int i2 = m;
    }
  }

  private void a(Throwable paramThrowable)
  {
    this.b.b(this.g);
    if (this.f.j())
      c();
  }

  private boolean a(ArrayList<p> paramArrayList, int paramInt)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
      if (((p)localIterator.next()).a == paramInt)
        return true;
    return false;
  }

  private void c()
  {
    if ("mounted".equals(o.e()))
      ViberApplication.getInstance().getDownloadValve().b(this.e);
  }

  // ERROR //
  public l a()
    throws com.viber.voip.util.upload.b.a
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/viber/voip/backgrounds/c/h:g	Lcom/viber/voip/backgrounds/l;
    //   4: pop
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 106	com/viber/voip/backgrounds/c/h:f	Lcom/viber/voip/util/upload/b;
    //   11: invokevirtual 311	com/viber/voip/util/upload/b:n	()Lcom/viber/voip/util/upload/e;
    //   14: astore 6
    //   16: new 313	com/viber/voip/backgrounds/c/h$2
    //   19: dup
    //   20: aload_0
    //   21: aload 6
    //   23: invokespecial 316	com/viber/voip/backgrounds/c/h$2:<init>	(Lcom/viber/voip/backgrounds/c/h;Ljava/io/InputStream;)V
    //   26: invokevirtual 319	com/viber/voip/backgrounds/c/h$2:start	()V
    //   29: aload_0
    //   30: aload 6
    //   32: invokespecial 321	com/viber/voip/backgrounds/c/h:a	(Ljava/io/InputStream;)Lcom/viber/voip/backgrounds/l;
    //   35: astore 9
    //   37: aload_0
    //   38: invokevirtual 324	java/lang/Object:wait	()V
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_0
    //   44: getfield 87	com/viber/voip/backgrounds/c/h:c	Ljava/io/File;
    //   47: invokestatic 221	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   50: pop
    //   51: aload_0
    //   52: getfield 106	com/viber/voip/backgrounds/c/h:f	Lcom/viber/voip/util/upload/b;
    //   55: invokevirtual 326	com/viber/voip/util/upload/b:g	()V
    //   58: aload 9
    //   60: areturn
    //   61: astore 7
    //   63: aload_0
    //   64: invokevirtual 324	java/lang/Object:wait	()V
    //   67: aload 7
    //   69: athrow
    //   70: astore 5
    //   72: aload_0
    //   73: monitorexit
    //   74: aload 5
    //   76: athrow
    //   77: astore 4
    //   79: aload_0
    //   80: aload 4
    //   82: invokespecial 271	com/viber/voip/backgrounds/c/h:a	(Ljava/lang/Throwable;)V
    //   85: aload 4
    //   87: athrow
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 106	com/viber/voip/backgrounds/c/h:f	Lcom/viber/voip/util/upload/b;
    //   93: invokevirtual 326	com/viber/voip/util/upload/b:g	()V
    //   96: aload_3
    //   97: athrow
    //   98: astore_2
    //   99: aload_0
    //   100: aload_2
    //   101: invokespecial 271	com/viber/voip/backgrounds/c/h:a	(Ljava/lang/Throwable;)V
    //   104: new 305	com/viber/voip/util/upload/b$a
    //   107: dup
    //   108: aload_2
    //   109: invokespecial 328	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;)V
    //   112: athrow
    //   113: astore 10
    //   115: goto -74 -> 41
    //   118: astore 8
    //   120: goto -53 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   29	37	61	finally
    //   7	29	70	finally
    //   37	41	70	finally
    //   41	43	70	finally
    //   63	67	70	finally
    //   67	70	70	finally
    //   72	74	70	finally
    //   5	7	77	com/viber/voip/util/upload/b$a
    //   43	51	77	com/viber/voip/util/upload/b$a
    //   74	77	77	com/viber/voip/util/upload/b$a
    //   5	7	88	finally
    //   43	51	88	finally
    //   74	77	88	finally
    //   79	88	88	finally
    //   99	113	88	finally
    //   5	7	98	java/io/IOException
    //   43	51	98	java/io/IOException
    //   74	77	98	java/io/IOException
    //   37	41	113	java/lang/InterruptedException
    //   63	67	118	java/lang/InterruptedException
  }

  public abstract void a(int paramInt);

  public void a(Uri paramUri, int paramInt)
  {
    this.b.a(this.g, paramInt);
  }

  public void b()
  {
    this.f.g();
  }

  public void run()
  {
    try
    {
      new p(this.g.a, this.g.a).e();
      if (this.g.a == 0)
        a(ViberApplication.getApplication().getAssets().open("bg/default_bg_thumbs.zip"));
      while (true)
      {
        return;
        a();
        ViberApplication.getInstance().getDownloadValve().d(this.f.b());
      }
    }
    catch (com.viber.voip.util.upload.b.a locala)
    {
    }
    catch (IOException localIOException)
    {
    }
    finally
    {
      a(this.g.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.c.h
 * JD-Core Version:    0.6.2
 */