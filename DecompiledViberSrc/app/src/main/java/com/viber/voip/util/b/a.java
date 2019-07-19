package com.viber.voip.util.b;

import com.google.d.a.c;
import java.util.List;

public class a
{

  @c(a="gifs")
  private List<String> a;

  @c(a="stickers")
  private List<a> b;

  @c(a="gif_width")
  private int c;

  @c(a="gif_height")
  private int d;

  @c(a="stickers_colunms")
  private int e;

  @c(a="stickers_rows")
  private int f;
  private transient String g;

  public List<String> a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public List<a> b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public int f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public String toString()
  {
    return "EngagementMediaData{mGifs=" + this.a + ", mStickers=" + this.b + ", mGifWidth=" + this.c + ", mGifHeight=" + this.d + ", mStickerColumns=" + this.e + ", mStickerRows=" + this.f + ", mRichMessageMsgInfo='" + this.g + '\'' + '}';
  }

  public static class a
  {

    @c(a="id")
    private int a;

    @c(a="animated")
    private boolean b;

    public int a()
    {
      return this.a;
    }

    public boolean b()
    {
      return this.b;
    }

    public String toString()
    {
      return "Sticker{mId=" + this.a + ", mAnimated=" + this.b + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.b.a
 * JD-Core Version:    0.6.2
 */