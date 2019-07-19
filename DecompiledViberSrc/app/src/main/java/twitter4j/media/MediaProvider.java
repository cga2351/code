package twitter4j.media;

public enum MediaProvider
{
  static
  {
    IMG_LY = new MediaProvider("IMG_LY", 1);
    PLIXI = new MediaProvider("PLIXI", 2);
    LOCKERZ = new MediaProvider("LOCKERZ", 3);
    TWIPPLE = new MediaProvider("TWIPPLE", 4);
    TWITGOO = new MediaProvider("TWITGOO", 5);
    TWITPIC = new MediaProvider("TWITPIC", 6);
    YFROG = new MediaProvider("YFROG", 7);
    MOBYPICTURE = new MediaProvider("MOBYPICTURE", 8);
    POSTEROUS = new MediaProvider("POSTEROUS", 9);
    MediaProvider[] arrayOfMediaProvider = new MediaProvider[10];
    arrayOfMediaProvider[0] = TWITTER;
    arrayOfMediaProvider[1] = IMG_LY;
    arrayOfMediaProvider[2] = PLIXI;
    arrayOfMediaProvider[3] = LOCKERZ;
    arrayOfMediaProvider[4] = TWIPPLE;
    arrayOfMediaProvider[5] = TWITGOO;
    arrayOfMediaProvider[6] = TWITPIC;
    arrayOfMediaProvider[7] = YFROG;
    arrayOfMediaProvider[8] = MOBYPICTURE;
    arrayOfMediaProvider[9] = POSTEROUS;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.media.MediaProvider
 * JD-Core Version:    0.6.2
 */