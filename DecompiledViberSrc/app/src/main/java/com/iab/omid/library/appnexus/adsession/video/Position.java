package com.iab.omid.library.appnexus.adsession.video;

public enum Position
{
  private final String a;

  static
  {
    MIDROLL = new Position("MIDROLL", 1, "midroll");
    POSTROLL = new Position("POSTROLL", 2, "postroll");
    STANDALONE = new Position("STANDALONE", 3, "standalone");
    Position[] arrayOfPosition = new Position[4];
    arrayOfPosition[0] = PREROLL;
    arrayOfPosition[1] = MIDROLL;
    arrayOfPosition[2] = POSTROLL;
    arrayOfPosition[3] = STANDALONE;
  }

  private Position(String paramString)
  {
    this.a = paramString;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.video.Position
 * JD-Core Version:    0.6.2
 */