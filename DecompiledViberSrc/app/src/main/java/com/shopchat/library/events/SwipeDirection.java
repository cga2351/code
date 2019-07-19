package com.shopchat.library.events;

public enum SwipeDirection
{
  static
  {
    NEXT = new SwipeDirection("NEXT", 1);
    SwipeDirection[] arrayOfSwipeDirection = new SwipeDirection[2];
    arrayOfSwipeDirection[0] = PREVIOUS;
    arrayOfSwipeDirection[1] = NEXT;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.SwipeDirection
 * JD-Core Version:    0.6.2
 */