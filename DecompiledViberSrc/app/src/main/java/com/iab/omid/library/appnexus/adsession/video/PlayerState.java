package com.iab.omid.library.appnexus.adsession.video;

public enum PlayerState
{
  private final String a;

  static
  {
    COLLAPSED = new PlayerState("COLLAPSED", 1, "collapsed");
    NORMAL = new PlayerState("NORMAL", 2, "normal");
    EXPANDED = new PlayerState("EXPANDED", 3, "expanded");
    FULLSCREEN = new PlayerState("FULLSCREEN", 4, "fullscreen");
    PlayerState[] arrayOfPlayerState = new PlayerState[5];
    arrayOfPlayerState[0] = MINIMIZED;
    arrayOfPlayerState[1] = COLLAPSED;
    arrayOfPlayerState[2] = NORMAL;
    arrayOfPlayerState[3] = EXPANDED;
    arrayOfPlayerState[4] = FULLSCREEN;
  }

  private PlayerState(String paramString)
  {
    this.a = paramString;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.video.PlayerState
 * JD-Core Version:    0.6.2
 */