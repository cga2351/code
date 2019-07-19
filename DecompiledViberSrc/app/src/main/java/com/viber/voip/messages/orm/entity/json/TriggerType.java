package com.viber.voip.messages.orm.entity.json;

public enum TriggerType
{
  private final String mTrigger;

  static
  {
    TriggerType[] arrayOfTriggerType = new TriggerType[1];
    arrayOfTriggerType[0] = VIEW_PG_FROM_FORWARDED_PG_CONTENT;
  }

  private TriggerType(String paramString)
  {
    this.mTrigger = paramString;
  }

  public static TriggerType toEnum(String paramString)
  {
    for (TriggerType localTriggerType : values())
      if (localTriggerType.mTrigger.equalsIgnoreCase(paramString))
        return localTriggerType;
    return null;
  }

  public String getTrigger()
  {
    return this.mTrigger;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.TriggerType
 * JD-Core Version:    0.6.2
 */