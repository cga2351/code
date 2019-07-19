package com.viber.voip.util.upload;

import android.content.Context;
import android.net.Uri;
import com.viber.voip.messages.extras.image.c;
import com.viber.voip.util.at;
import com.viber.voip.util.aw;
import com.viber.voip.util.bg.a;
import com.viber.voip.util.bj;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class f extends b
{
  private Context p;

  public f(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramString1, paramString2, paramString3, paramInt);
    this.p = paramContext;
  }

  private void o()
    throws IOException, b.a
  {
    if ((this.m == null) || (e()));
    while (true)
    {
      return;
      if (this.i)
        throw new b.a(b.b.c);
      if (!"mounted".equals(o.e()))
        throw new IOException("sdcard unmounted");
      InputStream localInputStream = this.k;
      if (localInputStream == null)
        throw new IOException("can't read null input stream!");
      FileOutputStream localFileOutputStream = new FileOutputStream(this.m);
      try
      {
        aw.a(localInputStream, localFileOutputStream);
        c.b(this.p, Uri.fromFile(this.m));
        a(this.m);
        return;
      }
      finally
      {
        bj.a(new Closeable[] { localInputStream, localFileOutputStream });
        if (!b)
          at.f(this.m);
      }
    }
  }

  protected void k()
    throws IOException, b.a
  {
    if (bg.a.d(h()))
    {
      o();
      return;
    }
    super.k();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.f
 * JD-Core Version:    0.6.2
 */