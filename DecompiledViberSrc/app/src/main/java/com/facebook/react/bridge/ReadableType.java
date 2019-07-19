package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum ReadableType
{
  static
  {
    Boolean = new ReadableType("Boolean", 1);
    Number = new ReadableType("Number", 2);
    String = new ReadableType("String", 3);
    Map = new ReadableType("Map", 4);
    Array = new ReadableType("Array", 5);
    ReadableType[] arrayOfReadableType = new ReadableType[6];
    arrayOfReadableType[0] = Null;
    arrayOfReadableType[1] = Boolean;
    arrayOfReadableType[2] = Number;
    arrayOfReadableType[3] = String;
    arrayOfReadableType[4] = Map;
    arrayOfReadableType[5] = Array;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableType
 * JD-Core Version:    0.6.2
 */