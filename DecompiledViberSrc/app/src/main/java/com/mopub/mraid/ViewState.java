package com.mopub.mraid;

import java.util.Locale;

public enum ViewState
{
  static
  {
    DEFAULT = new ViewState("DEFAULT", 1);
    RESIZED = new ViewState("RESIZED", 2);
    EXPANDED = new ViewState("EXPANDED", 3);
    HIDDEN = new ViewState("HIDDEN", 4);
    ViewState[] arrayOfViewState = new ViewState[5];
    arrayOfViewState[0] = LOADING;
    arrayOfViewState[1] = DEFAULT;
    arrayOfViewState[2] = RESIZED;
    arrayOfViewState[3] = EXPANDED;
    arrayOfViewState[4] = HIDDEN;
  }

  public String toJavascriptString()
  {
    return toString().toLowerCase(Locale.US);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.ViewState
 * JD-Core Version:    0.6.2
 */