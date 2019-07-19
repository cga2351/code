package com.viber.jni.cdr.entity;

import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.ci;
import com.viber.voip.util.d.b;

public class SendMessageMediaTypeFactory
{
  public static SendMessageMediaTypeData createMediaTypeData(int paramInt)
  {
    return new SendMessageMediaTypeData(paramInt);
  }

  public static SendMessageMediaTypeData createMediaTypeData(int paramInt, MessageEntity paramMessageEntity)
  {
    for (SendMessageCdrMediaType localSendMessageCdrMediaType : SendMessageCdrMediaType.getCachedValues())
      if (localSendMessageCdrMediaType.canHandle(paramMessageEntity))
        return localSendMessageCdrMediaType.createMediaTypeData(paramInt, paramMessageEntity);
    return createMediaTypeData(paramInt);
  }

  private static enum SendMessageCdrMediaType
  {
    private static final SendMessageCdrMediaType[] sCachedValues = values();
    private final int mCdrExtraTypeId;
    private final b<MessageEntity, String> mExtraDataCreator;
    private final ci<MessageEntity> mHandlingChecker;

    static
    {
      SendMessageCdrMediaType[] arrayOfSendMessageCdrMediaType = new SendMessageCdrMediaType[1];
      arrayOfSendMessageCdrMediaType[0] = INSTANT_VIDEO;
    }

    private SendMessageCdrMediaType(int paramInt, ci<MessageEntity> paramci, b<MessageEntity, String> paramb)
    {
      this.mCdrExtraTypeId = paramInt;
      this.mHandlingChecker = paramci;
      this.mExtraDataCreator = paramb;
    }

    static SendMessageCdrMediaType[] getCachedValues()
    {
      return sCachedValues;
    }

    boolean canHandle(MessageEntity paramMessageEntity)
    {
      return this.mHandlingChecker.apply(paramMessageEntity);
    }

    SendMessageMediaTypeFactory.SendMessageMediaTypeData createMediaTypeData(int paramInt, MessageEntity paramMessageEntity)
    {
      return new SendMessageMediaTypeFactory.SendMessageMediaTypeData(paramInt, this.mCdrExtraTypeId, (String)this.mExtraDataCreator.apply(paramMessageEntity));
    }
  }

  public static class SendMessageMediaTypeData
  {
    static final String DEFAULT_EXTRA_DATA = "";
    private final String mCdrExtraData;
    private final int mCdrExtraMediaType;
    private final int mOriginalMediaType;

    SendMessageMediaTypeData(int paramInt)
    {
      this(paramInt, paramInt, "");
    }

    SendMessageMediaTypeData(int paramInt1, int paramInt2, String paramString)
    {
      this.mOriginalMediaType = paramInt1;
      this.mCdrExtraMediaType = paramInt2;
      this.mCdrExtraData = paramString;
    }

    public String getCdrExtraData()
    {
      return this.mCdrExtraData;
    }

    public int getCdrMediaType()
    {
      return this.mCdrExtraMediaType;
    }

    public int getMediaType()
    {
      return this.mOriginalMediaType;
    }

    public String toString()
    {
      return "SendMessageMediaTypeData{mOriginalMediaType=" + this.mOriginalMediaType + ", mCdrExtraMediaType=" + this.mCdrExtraMediaType + ", mCdrExtraData='" + this.mCdrExtraData + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.entity.SendMessageMediaTypeFactory
 * JD-Core Version:    0.6.2
 */