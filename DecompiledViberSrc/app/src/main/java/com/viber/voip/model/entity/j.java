package com.viber.voip.model.entity;

import android.content.ContentValues;
import com.viber.voip.messages.orm.entity.impl.LikeEntityHelper;

public class j extends b
{
  private long a;
  private long b;
  private int c;
  private String d;
  private long e;
  private boolean f;
  private boolean g;
  private int h;

  public long a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public long b()
  {
    return this.b;
  }

  public void b(int paramInt)
  {
    this.h = paramInt;
  }

  public void b(long paramLong)
  {
    this.b = paramLong;
  }

  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public int c()
  {
    return this.c;
  }

  public void c(long paramLong)
  {
    this.e = paramLong;
  }

  public String d()
  {
    return this.d;
  }

  public long e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (this == paramObject)
      bool2 = true;
    j localj;
    boolean bool4;
    do
    {
      boolean bool3;
      do
      {
        boolean bool1;
        do
        {
          return bool2;
          bool1 = paramObject instanceof j;
          bool2 = false;
        }
        while (!bool1);
        bool3 = super.equals(paramObject);
        bool2 = false;
      }
      while (!bool3);
      localj = (j)paramObject;
      bool4 = this.a < localj.a;
      bool2 = false;
    }
    while (bool4);
    return this.d.equals(localj.d);
  }

  public boolean f()
  {
    return this.f;
  }

  public boolean g()
  {
    return this.g;
  }

  public ContentValues getContentValues()
  {
    return LikeEntityHelper.getContentValues(this);
  }

  public String getTable()
  {
    return "messages_likes";
  }

  public int h()
  {
    return this.h;
  }

  public int hashCode()
  {
    return 31 * (31 * super.hashCode() + (int)(this.a ^ this.a >>> 32)) + this.d.hashCode();
  }

  public String toString()
  {
    return "MessageLikeEntity{messageToken=" + this.a + ", likeToken=" + this.b + ", seq=" + this.c + ", memberId='" + this.d + '\'' + ", likeDate=" + this.e + ", read=" + this.f + ", syncRead=" + this.g + ", status=" + this.h + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.j
 * JD-Core Version:    0.6.2
 */