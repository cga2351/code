package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.f.ac;
import com.google.android.exoplayer2.extractor.f.u;
import com.google.android.exoplayer2.extractor.mp4.h;
import java.lang.reflect.Constructor;

public final class e
  implements j
{
  private static final Constructor<? extends g> a;
  private boolean b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i = 1;
  private int j;

  static
  {
    try
    {
      Constructor localConstructor2 = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(g.class).getConstructor(new Class[0]);
      localConstructor1 = localConstructor2;
      a = localConstructor1;
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Error instantiating FLAC extension", localException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        Constructor localConstructor1 = null;
    }
  }

  public g[] createExtractors()
  {
    int k = 12;
    int m = 1;
    try
    {
      if (a == null);
      while (true)
      {
        g[] arrayOfg = new g[k];
        arrayOfg[0] = new com.google.android.exoplayer2.extractor.c.d(this.e);
        arrayOfg[1] = new com.google.android.exoplayer2.extractor.mp4.e(this.g);
        arrayOfg[2] = new h(this.f);
        int n = this.h;
        int i1;
        label80: int i3;
        if (this.b)
        {
          i1 = m;
          arrayOfg[3] = new com.google.android.exoplayer2.extractor.d.c(i1 | n);
          int i2 = this.c;
          if (!this.b)
            break label282;
          i3 = m;
          label112: arrayOfg[4] = new com.google.android.exoplayer2.extractor.f.d(0L, i3 | i2);
          arrayOfg[5] = new com.google.android.exoplayer2.extractor.f.a();
          arrayOfg[6] = new ac(this.i, this.j);
          arrayOfg[7] = new b();
          arrayOfg[8] = new com.google.android.exoplayer2.extractor.e.c();
          arrayOfg[9] = new u();
          arrayOfg[10] = new com.google.android.exoplayer2.extractor.g.a();
          int i4 = this.d;
          if (!this.b)
            break label288;
          arrayOfg[11] = new com.google.android.exoplayer2.extractor.a.a(m | i4);
          Constructor localConstructor = a;
          if (localConstructor == null);
        }
        try
        {
          arrayOfg[12] = ((g)a.newInstance(new Object[0]));
          return arrayOfg;
          k = 13;
          continue;
          i1 = 0;
          break label80;
          label282: i3 = 0;
          break label112;
          label288: m = 0;
        }
        catch (Exception localException)
        {
          throw new IllegalStateException("Unexpected error creating FLAC extractor", localException);
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e
 * JD-Core Version:    0.6.2
 */