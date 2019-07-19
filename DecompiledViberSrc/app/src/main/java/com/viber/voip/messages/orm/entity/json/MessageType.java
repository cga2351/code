package com.viber.voip.messages.orm.entity.json;

public enum MessageType
{
  private final String mValue;

  static
  {
    IMAGE = new MessageType("IMAGE", 1, "img");
    VIDEO = new MessageType("VIDEO", 2, "vdo");
    BUTTON = new MessageType("BUTTON", 3, "btn");
    STICKER = new MessageType("STICKER", 4, "stk");
    INFO = new MessageType("INFO", 5, "info");
    COMMAND = new MessageType("COMMAND", 6, "cmd");
    SEPARATOR = new MessageType("SEPARATOR", 7, "sep");
    GIF = new MessageType("GIF", 8, "gif");
    MessageType[] arrayOfMessageType = new MessageType[9];
    arrayOfMessageType[0] = TEXT;
    arrayOfMessageType[1] = IMAGE;
    arrayOfMessageType[2] = VIDEO;
    arrayOfMessageType[3] = BUTTON;
    arrayOfMessageType[4] = STICKER;
    arrayOfMessageType[5] = INFO;
    arrayOfMessageType[6] = COMMAND;
    arrayOfMessageType[7] = SEPARATOR;
    arrayOfMessageType[8] = GIF;
  }

  private MessageType(String paramString)
  {
    this.mValue = paramString;
  }

  public static MessageType toEnum(String paramString)
  {
    for (MessageType localMessageType : values())
      if (localMessageType.mValue.equalsIgnoreCase(paramString))
        return localMessageType;
    return null;
  }

  public String getValue()
  {
    return this.mValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.MessageType
 * JD-Core Version:    0.6.2
 */