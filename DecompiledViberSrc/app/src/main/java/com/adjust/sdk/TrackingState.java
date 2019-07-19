package com.adjust.sdk;

public enum TrackingState
{
  private int value;

  static
  {
    TrackingState[] arrayOfTrackingState = new TrackingState[1];
    arrayOfTrackingState[0] = OPTED_OUT;
  }

  private TrackingState(int paramInt)
  {
    this.value = paramInt;
  }

  public int getValue()
  {
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.TrackingState
 * JD-Core Version:    0.6.2
 */