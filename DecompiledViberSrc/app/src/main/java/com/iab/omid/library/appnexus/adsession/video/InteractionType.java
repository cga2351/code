package com.iab.omid.library.appnexus.adsession.video;

public enum InteractionType
{
  String a;

  static
  {
    InteractionType[] arrayOfInteractionType = new InteractionType[2];
    arrayOfInteractionType[0] = CLICK;
    arrayOfInteractionType[1] = INVITATION_ACCEPTED;
  }

  private InteractionType(String paramString)
  {
    this.a = paramString;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.video.InteractionType
 * JD-Core Version:    0.6.2
 */