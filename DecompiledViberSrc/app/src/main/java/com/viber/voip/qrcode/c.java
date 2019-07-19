package com.viber.voip.qrcode;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.google.e.k;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ad;
import java.io.IOException;

public final class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final b c;
  private Camera d;
  private a e;
  private Rect f;
  private Rect g;
  private boolean h;
  private boolean i;
  private int j = -1;
  private int k;
  private int l;
  private final g m;

  public c(Context paramContext)
  {
    this.b = paramContext;
    this.c = new b(paramContext);
    this.m = new g(this.c);
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int n = paramInt1 * 5 / 8;
    if (n < paramInt2)
      return paramInt2;
    if (n > paramInt3)
      return paramInt3;
    return n;
  }

  public k a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Rect localRect = f();
    if (localRect == null)
      return null;
    return new k(paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height(), false);
  }

  public void a(int paramInt)
  {
    try
    {
      this.j = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.h)
      {
        Point localPoint = this.c.b();
        if (paramInt1 > localPoint.x)
          paramInt1 = localPoint.x;
        if (paramInt2 > localPoint.y)
          paramInt2 = localPoint.y;
        int n = (localPoint.x - paramInt1) / 2;
        int i1 = (localPoint.y - paramInt2) / 2;
        this.f = new Rect(n, i1, n + paramInt1, i1 + paramInt2);
        this.g = null;
      }
      while (true)
      {
        return;
        this.k = paramInt1;
        this.l = paramInt2;
      }
    }
    finally
    {
    }
  }

  public void a(Handler paramHandler, int paramInt)
  {
    try
    {
      Camera localCamera = this.d;
      if ((localCamera != null) && (this.i))
      {
        this.m.a(paramHandler, paramInt);
        localCamera.setOneShotPreviewCallback(this.m);
      }
      return;
    }
    finally
    {
    }
  }

  public void a(SurfaceHolder paramSurfaceHolder)
    throws IOException
  {
    Camera localCamera1;
    while (true)
    {
      try
      {
        localCamera1 = this.d;
        if (localCamera1 != null)
          break label57;
        if (this.j >= 0)
        {
          localCamera1 = com.viber.voip.qrcode.a.a.a(this.j);
          if (localCamera1 != null)
            break;
          throw new IOException("Unable to open camera.");
        }
      }
      finally
      {
      }
      localCamera1 = com.viber.voip.qrcode.a.a.a();
    }
    this.d = localCamera1;
    label57: Camera localCamera2 = localCamera1;
    if (this.j >= 0)
      this.c.a(this.j, localCamera2);
    while (true)
    {
      localCamera2.setPreviewDisplay(paramSurfaceHolder);
      if (!this.h)
      {
        this.h = true;
        this.c.a(localCamera2);
        if ((this.k > 0) && (this.l > 0))
        {
          a(this.k, this.l);
          this.k = 0;
          this.l = 0;
        }
      }
      Camera.Parameters localParameters1 = localCamera2.getParameters();
      String str;
      if (localParameters1 == null)
        str = null;
      try
      {
        while (true)
        {
          this.c.a(localCamera2, false);
          return;
          this.c.a(com.viber.voip.qrcode.a.a.b(), localCamera2);
          break;
          str = localParameters1.flatten();
        }
      }
      catch (RuntimeException localRuntimeException1)
      {
        while (true)
          if (str != null)
          {
            Camera.Parameters localParameters2 = localCamera2.getParameters();
            localParameters2.unflatten(str);
            try
            {
              localCamera2.setParameters(localParameters2);
              this.c.a(localCamera2, true);
            }
            catch (RuntimeException localRuntimeException2)
            {
            }
          }
      }
    }
  }

  public boolean a()
  {
    try
    {
      Camera localCamera = this.d;
      if (localCamera != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public void b()
  {
    try
    {
      if (this.d != null)
      {
        this.d.release();
        this.d = null;
        this.f = null;
        this.g = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(SurfaceHolder paramSurfaceHolder)
  {
    int n = Camera.getNumberOfCameras();
    if (n <= 1);
    int i1;
    do
    {
      return;
      i1 = d.ad.J.d();
    }
    while (i1 == -1);
    Rect localRect = this.f;
    d();
    b();
    this.h = false;
    this.f = localRect;
    int i2 = (i1 + 1) % n;
    a(i2);
    try
    {
      a(paramSurfaceHolder);
      c();
      return;
    }
    catch (IOException localIOException)
    {
      a.a(localIOException, "flipCamera(): unable to flip the camera to camera id = " + i2);
    }
  }

  public void c()
  {
    try
    {
      Camera localCamera = this.d;
      if ((localCamera != null) && (!this.i))
      {
        localCamera.startPreview();
        this.i = true;
        this.e = new a(this.b, this.d);
      }
      return;
    }
    finally
    {
    }
  }

  public void d()
  {
    try
    {
      if (this.e != null)
      {
        this.e.b();
        this.e = null;
      }
      if ((this.d != null) && (this.i))
      {
        this.d.stopPreview();
        this.m.a(null, 0);
        this.i = false;
      }
      return;
    }
    finally
    {
    }
  }

  public Rect e()
  {
    try
    {
      Rect localRect;
      if (this.f == null)
      {
        Camera localCamera = this.d;
        localRect = null;
        if (localCamera != null);
      }
      while (true)
      {
        return localRect;
        Point localPoint = this.c.b();
        localRect = null;
        if (localPoint != null)
        {
          int n = a(localPoint.x, 240, 1200);
          int i1 = a(localPoint.y, 240, 675);
          int i2 = (localPoint.x - n) / 2;
          int i3 = (localPoint.y - i1) / 2;
          this.f = new Rect(i2, i3, n + i2, i1 + i3);
          localRect = this.f;
        }
      }
    }
    finally
    {
    }
  }

  public Rect f()
  {
    try
    {
      Rect localRect2;
      Rect localRect1;
      if (this.g == null)
      {
        localRect2 = e();
        localRect1 = null;
        if (localRect2 != null);
      }
      while (true)
      {
        return localRect1;
        Rect localRect3 = new Rect(localRect2);
        Point localPoint1 = this.c.a();
        Point localPoint2 = this.c.b();
        localRect1 = null;
        if (localPoint1 != null)
        {
          localRect1 = null;
          if (localPoint2 != null)
          {
            localRect3.left = (localRect2.top * localPoint1.x / localPoint2.y);
            localRect3.right = (localRect2.bottom * localPoint1.x / localPoint2.y);
            localRect3.top = ((localPoint2.x - localRect2.right) * localPoint1.y / localPoint2.x);
            localRect3.bottom = ((localPoint2.x - localRect2.left) * localPoint1.y / localPoint2.x);
            this.g = localRect3;
            localRect1 = this.g;
          }
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.c
 * JD-Core Version:    0.6.2
 */