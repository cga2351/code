package com.viber.common.wear;

public enum CallState
{
  static
  {
    IN_PROGRESS = new CallState("IN_PROGRESS", 3);
    CallState[] arrayOfCallState = new CallState[4];
    arrayOfCallState[0] = IDLE;
    arrayOfCallState[1] = INCOMING;
    arrayOfCallState[2] = OUTGOING;
    arrayOfCallState[3] = IN_PROGRESS;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.wear.CallState
 * JD-Core Version:    0.6.2
 */