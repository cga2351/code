package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.Collections;
import java.util.List;

public abstract interface ae
{
  public abstract void a();

  public abstract void a(ad paramad, i parami, d paramd);

  public abstract void a(r paramr, int paramInt)
    throws w;

  public static final class a
  {
    public final String a;
    public final int b;
    public final byte[] c;

    public a(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramString;
      this.b = paramInt;
      this.c = paramArrayOfByte;
    }
  }

  public static final class b
  {
    public final int a;
    public final String b;
    public final List<ae.a> c;
    public final byte[] d;

    public b(int paramInt, String paramString, List<ae.a> paramList, byte[] paramArrayOfByte)
    {
      this.a = paramInt;
      this.b = paramString;
      if (paramList == null);
      for (List localList = Collections.emptyList(); ; localList = Collections.unmodifiableList(paramList))
      {
        this.c = localList;
        this.d = paramArrayOfByte;
        return;
      }
    }
  }

  public static abstract interface c
  {
    public abstract SparseArray<ae> a();

    public abstract ae a(int paramInt, ae.b paramb);
  }

  public static final class d
  {
    private final String a;
    private final int b;
    private final int c;
    private int d;
    private String e;

    public d(int paramInt1, int paramInt2)
    {
      this(-2147483648, paramInt1, paramInt2);
    }

    public d(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 != -2147483648);
      for (String str = paramInt1 + "/"; ; str = "")
      {
        this.a = str;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = -2147483648;
        return;
      }
    }

    private void d()
    {
      if (this.d == -2147483648)
        throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }

    public void a()
    {
      if (this.d == -2147483648);
      for (int i = this.b; ; i = this.d + this.c)
      {
        this.d = i;
        this.e = (this.a + this.d);
        return;
      }
    }

    public int b()
    {
      d();
      return this.d;
    }

    public String c()
    {
      d();
      return this.e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.ae
 * JD-Core Version:    0.6.2
 */