package com.mopub.mraid;

import java.util.Locale;

public enum PlacementType
{
  static
  {
    PlacementType[] arrayOfPlacementType = new PlacementType[2];
    arrayOfPlacementType[0] = INLINE;
    arrayOfPlacementType[1] = INTERSTITIAL;
  }

  String a()
  {
    return toString().toLowerCase(Locale.US);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.PlacementType
 * JD-Core Version:    0.6.2
 */