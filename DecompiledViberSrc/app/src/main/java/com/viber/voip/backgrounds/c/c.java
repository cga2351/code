package com.viber.voip.backgrounds.c;

import android.os.Handler;
import android.util.SparseArray;
import com.viber.voip.backgrounds.b.a;
import com.viber.voip.backgrounds.f;
import com.viber.voip.backgrounds.l;
import com.viber.voip.util.bj;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c
{
  private com.viber.voip.backgrounds.b a;
  private f b;
  private SparseArray<h> c = new SparseArray();
  private b d;
  private Handler e;
  private a f;

  public c(Handler paramHandler, com.viber.voip.backgrounds.b paramb, f paramf, a parama)
  {
    this.e = paramHandler;
    this.a = paramb;
    this.b = paramf;
    this.f = parama;
  }

  static void a(String paramString, InputStream paramInputStream)
    throws IOException
  {
    String str = paramString + ".tmp";
    File localFile = new File(str);
    FileOutputStream localFileOutputStream = new FileOutputStream(str);
    bj.b(paramInputStream, localFileOutputStream);
    localFileOutputStream.close();
    localFile.renameTo(new File(paramString));
  }

  public void a()
  {
    int i = 0;
    try
    {
      while (i < this.c.size())
      {
        ((h)this.c.valueAt(i)).b();
        i++;
      }
      this.c.clear();
      return;
    }
    finally
    {
    }
  }

  public boolean a(l paraml)
  {
    try
    {
      if (this.c.size() == 0)
      {
        h local1 = new h(paraml, this.a, this.b, this.f)
        {
          public void a(int paramAnonymousInt)
          {
            synchronized (c.this)
            {
              c.a(c.this).remove(paramAnonymousInt);
              return;
            }
          }
        };
        this.c.put(paraml.a, local1);
        this.e.post(local1);
        return true;
      }
      return false;
    }
    finally
    {
    }
  }

  public void b()
  {
    try
    {
      this.d = new b(this.b, this.a);
      this.e.post(this.d);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.c.c
 * JD-Core Version:    0.6.2
 */