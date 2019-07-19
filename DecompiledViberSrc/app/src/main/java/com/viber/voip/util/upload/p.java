package com.viber.voip.util.upload;

import android.content.Context;
import android.net.Uri;
import com.viber.voip.messages.extras.image.c;
import com.viber.voip.util.da;
import java.io.File;
import java.io.IOException;

public class p extends b
{
  private final Context p;
  private final int q;
  private final File r;

  public p(Context paramContext, int paramInt, String paramString, File paramFile)
  {
    super(paramString, paramFile.getPath(), "", -1);
    this.p = paramContext;
    this.q = paramInt;
    this.r = paramFile;
  }

  private void b(File paramFile)
  {
    if (!paramFile.exists());
    try
    {
      paramFile.createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public void f()
    throws b.a
  {
    if (this.i)
      throw new b.a(b.b.c);
    String str = b();
    if ((!da.a(str)) && (this.q != -1))
    {
      b(this.r);
      if (c.a(this.p, Uri.parse(str), Uri.fromFile(this.r), this.q, false) == null)
        throw new b.a(b.b.j);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.p
 * JD-Core Version:    0.6.2
 */