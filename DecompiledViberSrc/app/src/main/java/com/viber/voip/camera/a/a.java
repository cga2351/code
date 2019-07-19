package com.viber.voip.camera.a;

import android.graphics.Rect;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import java.util.List;
import java.util.Locale;

public abstract class a
{
  private static final String c = com.viber.voip.camera.e.a.a(a.class);
  int a = 0;
  public int b = 0;

  public a(int paramInt)
  {
    this.a = paramInt;
  }

  public abstract int A();

  public abstract int B();

  public abstract boolean C();

  public abstract void D();

  public abstract String E();

  public abstract i a(String paramString);

  protected i a(List<String> paramList, String paramString1, String paramString2)
  {
    if ((paramList != null) && (paramList.size() > 1))
    {
      if (paramList.contains(paramString1))
        break label61;
      if (!paramList.contains(paramString2));
    }
    while (true)
    {
      return new i(paramList, paramString2);
      paramString2 = (String)paramList.get(0);
      continue;
      return null;
      label61: paramString2 = paramString1;
    }
  }

  public abstract void a();

  public abstract void a(int paramInt1, int paramInt2);

  public abstract void a(MediaRecorder paramMediaRecorder);

  public abstract void a(SurfaceHolder paramSurfaceHolder)
    throws b;

  public abstract void a(b paramb);

  public abstract void a(f paramf);

  public abstract void a(boolean paramBoolean);

  public abstract void a(boolean paramBoolean, g paramg1, g paramg2, d paramd);

  public abstract boolean a(float paramFloat);

  public abstract boolean a(int paramInt);

  public abstract boolean a(long paramLong);

  public abstract boolean a(List<a> paramList);

  public abstract i b(String paramString);

  public abstract String b();

  public abstract void b(int paramInt);

  public abstract void b(int paramInt1, int paramInt2);

  public abstract void b(MediaRecorder paramMediaRecorder)
    throws b;

  public abstract void b(boolean paramBoolean);

  public abstract c c();

  public abstract i c(String paramString);

  public abstract void c(int paramInt);

  public abstract void c(int paramInt1, int paramInt2);

  public abstract void c(boolean paramBoolean);

  public int d()
  {
    return this.a;
  }

  public abstract i d(String paramString);

  public abstract boolean d(int paramInt);

  public abstract String e();

  public abstract void e(int paramInt);

  public abstract void e(String paramString);

  public abstract String f();

  public abstract void f(int paramInt);

  public abstract void f(String paramString);

  public abstract int g();

  public abstract long h();

  public abstract h i();

  public abstract int j();

  public abstract int k();

  public abstract List<int[]> l();

  public String m()
  {
    return "auto";
  }

  public String n()
  {
    return "none";
  }

  public String o()
  {
    return "auto";
  }

  public String p()
  {
    return "auto";
  }

  public abstract float q();

  public abstract String r();

  public abstract void s();

  public abstract boolean t();

  public abstract boolean u();

  public abstract void v()
    throws b;

  public abstract void w()
    throws b;

  public abstract void x();

  public abstract boolean y();

  public abstract void z();

  public static class a
  {
    public Rect a = null;
    public int b = 0;

    public a(Rect paramRect, int paramInt)
    {
      this.a = paramRect;
      this.b = paramInt;
    }
  }

  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }

  public static class c
  {
    public boolean a = false;
    public int b = 0;
    public List<Integer> c = null;
    public boolean d = false;
    public List<a.h> e = null;
    public List<a.h> f = null;
    public List<a.h> g = null;
    public List<String> h = null;
    public List<String> i = null;
    public int j = 0;
    public float k = 0.0F;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public int o = 0;
    public int p = 0;
    public boolean q = false;
    public long r = 0L;
    public long s = 0L;
    public int t = 0;
    public int u = 0;
    public float v = 0.0F;
    public boolean w = false;
  }

  public static abstract interface d
  {
    public abstract void a();
  }

  public static class e
  {
    public int a = 0;
    public Rect b = null;

    e(int paramInt, Rect paramRect)
    {
      this.a = paramInt;
      this.b = paramRect;
    }
  }

  public static abstract interface f
  {
    public abstract void a(a.e[] paramArrayOfe);
  }

  public static abstract interface g
  {
    public abstract void a(byte[] paramArrayOfByte);
  }

  public static class h
  {
    public int a = 0;
    public int b = 0;

    public h(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    public String toString()
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.a);
      arrayOfObject[1] = Integer.valueOf(this.b);
      return String.format(localLocale, "Size [W x H] : [%d x %d]", arrayOfObject);
    }
  }

  public class i
  {
    public List<String> a = null;
    public String b = null;

    i(String arg2)
    {
      Object localObject1;
      this.a = localObject1;
      Object localObject2;
      this.b = localObject2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.a.a
 * JD-Core Version:    0.6.2
 */