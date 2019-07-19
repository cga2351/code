package com.viber.voip.util.upload;

import android.graphics.Bitmap;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.at;
import com.viber.voip.util.de;
import com.viber.voip.util.dq;
import com.viber.voip.util.e.j;
import com.viber.voip.util.e.j.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class h extends b
{
  private static final Logger p = ViberEnv.getLogger();
  private boolean q;
  private boolean r;
  private int s;
  private int t;

  public h(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString4)
  {
    super(paramString1 + "&key=" + paramString4, paramString2, paramString3);
    this.q = paramBoolean1;
    this.r = paramBoolean2;
    this.s = paramInt1;
    this.t = paramInt2;
  }

  private void a(Bitmap paramBitmap, InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramBitmap != null)
    {
      byte[] arrayOfByte = j.b(paramBitmap);
      paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      paramOutputStream.flush();
      paramOutputStream.close();
    }
    paramInputStream.close();
  }

  private void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException, b.a
  {
    o();
    Bitmap localBitmap1 = dq.a(paramInputStream);
    if (this.q)
    {
      Bitmap localBitmap2 = null;
      if (localBitmap1 != null)
        localBitmap2 = new j.c(R.drawable._ics_location_point, this.s, this.t).a(localBitmap1);
      a(localBitmap2, paramInputStream, paramOutputStream);
      return;
    }
    a(localBitmap1, paramInputStream, paramOutputStream);
  }

  private void b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException, b.a
  {
    o();
    Bitmap localBitmap1 = dq.a(paramInputStream);
    if (this.q)
    {
      Bitmap localBitmap2 = null;
      if (localBitmap1 != null)
        localBitmap2 = new j.c(R.drawable._ics_location_point, this.s, this.t).a(localBitmap1);
      a(localBitmap2, paramInputStream, paramOutputStream);
      return;
    }
    a(localBitmap1, paramInputStream, paramOutputStream);
  }

  private void o()
    throws IOException
  {
    if (!"mounted".equals(o.e()))
      throw new IOException("sdcard unmounted");
  }

  protected void b(URL paramURL)
    throws IOException, b.a
  {
    a(paramURL);
    if (this.m != null);
    try
    {
      OutputStream localOutputStream = a(Uri.fromFile(this.m));
      de.a(paramURL.toString(), this.k.available());
      if (this.r)
        a(this.k, localOutputStream);
      while (true)
      {
        this.k = null;
        a(this.m);
        return;
        b(this.k, localOutputStream);
      }
    }
    finally
    {
      if (!b)
        at.f(this.m);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.h
 * JD-Core Version:    0.6.2
 */