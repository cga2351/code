package com.viber.voip.util.upload;

import android.content.Context;
import android.net.Uri;
import com.viber.jni.EncryptionParams;
import com.viber.voip.messages.extras.image.c;
import com.viber.voip.util.at;
import com.viber.voip.util.aw;
import com.viber.voip.util.bj;
import com.viber.voip.util.cr;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class d extends i.e
{
  private final Context r;
  private final EncryptionParams s;

  d(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3, EncryptionParams paramEncryptionParams)
  {
    super(paramString2, paramString3, paramString1, null, t.d.h, i.c.d, i.o.c);
    a(paramBoolean);
    this.r = paramContext;
    this.s = paramEncryptionParams;
  }

  protected void k()
    throws IOException, b.a
  {
    if ((this.m == null) || (e()))
      return;
    if (this.i)
      throw new b.a(b.b.c);
    if (!"mounted".equals(o.e()))
      throw new IOException("sdcard unmounted");
    InputStream localInputStream1 = this.k;
    if (EncryptionParams.contentIsEncrypted(this.s));
    for (InputStream localInputStream2 = cr.a(localInputStream1, this.s); ; localInputStream2 = localInputStream1)
      while (true)
      {
        if (localInputStream2 == null)
          throw new IOException("can't read null input stream!");
        FileOutputStream localFileOutputStream = new FileOutputStream(this.m);
        try
        {
          aw.a(localInputStream2, localFileOutputStream);
          c.b(this.r, Uri.fromFile(this.m));
          a(this.m);
          return;
        }
        finally
        {
          bj.a(new Closeable[] { localInputStream2, localFileOutputStream });
          if (!b)
            at.f(this.m);
        }
      }
  }

  protected boolean o()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.d
 * JD-Core Version:    0.6.2
 */