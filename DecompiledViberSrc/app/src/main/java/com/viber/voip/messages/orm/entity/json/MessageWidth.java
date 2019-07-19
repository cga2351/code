package com.viber.voip.messages.orm.entity.json;

public enum MessageWidth
{
  static
  {
    FULL = new MessageWidth("FULL", 1);
    MessageWidth[] arrayOfMessageWidth = new MessageWidth[2];
    arrayOfMessageWidth[0] = HALF;
    arrayOfMessageWidth[1] = FULL;
  }

  public static MessageWidth toEnum(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < values().length))
      return values()[paramInt];
    return FULL;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.MessageWidth
 * JD-Core Version:    0.6.2
 */