package com.viber.voip.ui.doodle.scene;

import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.StickerBitmapObject;
import com.viber.voip.ui.doodle.objects.c.a;
import java.util.Iterator;
import java.util.List;

public class c
{
  private a a;
  private List<Long> b;
  private int c;
  private int d;
  private int e;
  private int f;
  private long g;
  private long h;
  private long i;
  private String j;

  public c()
  {
  }

  c(a parama, List<Long> paramList)
  {
    this.a = parama;
    this.b = paramList;
    i();
  }

  private void i()
  {
    StringBuilder localStringBuilder = new StringBuilder(7 * this.b.size());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      BaseObject localBaseObject = this.a.a(localLong.longValue());
      if (localBaseObject != null)
      {
        long l = localBaseObject.getSavedStateSizeInBytes();
        switch (1.a[localBaseObject.getType().ordinal()])
        {
        default:
          break;
        case 1:
          this.c = (1 + this.c);
          this.g = (l + this.g);
          break;
        case 2:
          StickerBitmapObject localStickerBitmapObject = (StickerBitmapObject)localBaseObject;
          if (143700 == localStickerBitmapObject.getPackageId())
            this.f = (1 + this.f);
          while (true)
          {
            if (localStringBuilder.length() != 0)
              localStringBuilder.append(',');
            localStringBuilder.append("stickers.").append(localStickerBitmapObject.getStickerId());
            this.h = (l + this.h);
            break;
            this.d = (1 + this.d);
          }
        case 3:
          this.e = (1 + this.e);
          this.i = (l + this.i);
        }
      }
    }
    this.j = localStringBuilder.toString();
  }

  public int a()
  {
    return this.c;
  }

  public int b()
  {
    return this.d;
  }

  public int c()
  {
    return this.e;
  }

  public long d()
  {
    return this.g;
  }

  public long e()
  {
    return this.h;
  }

  public long f()
  {
    return this.i;
  }

  public int g()
  {
    return this.f;
  }

  public String h()
  {
    return this.j;
  }

  public String toString()
  {
    return "SceneStatistics (doodles count: " + this.c + ", texts count: " + this.e + ", stickers count: " + this.d + ", emoticons count: " + this.f + ", doodles size: " + this.g + ", texts size: " + this.i + ", stickers size: " + this.h + ")";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.scene.c
 * JD-Core Version:    0.6.2
 */