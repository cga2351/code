package com.android.camera.a;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.android.camera.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.at;
import java.io.File;
import java.io.FileNotFoundException;

class j
  implements c
{
  private static final Logger a = ViberEnv.getLogger();
  private final Uri b;
  private final d c;
  private final Context d;
  private final ContentResolver e;
  private int f = -2147483648;

  j(d paramd, Context paramContext, ContentResolver paramContentResolver, Uri paramUri)
  {
    this.c = paramd;
    this.d = paramContext;
    this.e = paramContentResolver;
    this.b = paramUri;
  }

  private ParcelFileDescriptor c()
  {
    try
    {
      if (this.b.getScheme().equals("file"))
        return ParcelFileDescriptor.open(new File(this.b.getPath()), 268435456);
      ParcelFileDescriptor localParcelFileDescriptor = this.e.openFileDescriptor(this.b, "r");
      return localParcelFileDescriptor;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
    return null;
  }

  public long a()
  {
    return 0L;
  }

  public Bitmap a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, true, false);
  }

  public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramBoolean, false);
  }

  public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Object localObject = e.a(paramInt1, paramInt2, c(), paramBoolean2);
      if ((localObject != null) && (paramBoolean1))
      {
        Bitmap localBitmap = e.a((Bitmap)localObject, b());
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (Exception localException)
    {
      a.a(localException, "got exception decoding bitmap ", new Object[0]);
    }
    return null;
  }

  public Bitmap a(boolean paramBoolean)
  {
    return a(320, 196608, paramBoolean);
  }

  public int b()
  {
    if (this.f == -2147483648)
      this.f = com.viber.voip.util.e.j.a(at.b(this.d, this.b));
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.a.j
 * JD-Core Version:    0.6.2
 */