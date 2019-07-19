package com.viber.voip.engagement.data;

public class d
{
  private int a;
  private final StickersMediaViewData.StickerItem b;
  private final GifsMediaViewData.GifItem c;
  private final String d;

  public d(GifsMediaViewData.GifItem paramGifItem, String paramString)
  {
    this.c = paramGifItem;
    this.a = 0;
    this.b = null;
    this.d = paramString;
  }

  public d(StickersMediaViewData.StickerItem paramStickerItem, String paramString)
  {
    this.b = paramStickerItem;
    this.a = 1;
    this.c = null;
    this.d = paramString;
  }

  public int a()
  {
    return this.a;
  }

  public StickersMediaViewData.StickerItem b()
  {
    return this.b;
  }

  public GifsMediaViewData.GifItem c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public String toString()
  {
    return "SelectedItem{mType=" + this.a + ", mStickerItem=" + this.b + ", mGifItem=" + this.c + ", mRichMessageMsgInfo='" + this.d + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.data.d
 * JD-Core Version:    0.6.2
 */