package com.viber.voip.storage.a;

import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaFileType;
import java.util.Arrays;

public class a
{
  private final ConversationWithMediaSizesEntity[] a;
  private final int b;
  private final long c;
  private final MediaFileType[] d;

  public a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity, int paramInt, long paramLong, MediaFileType[] paramArrayOfMediaFileType)
  {
    this(new ConversationWithMediaSizesEntity[] { paramConversationWithMediaSizesEntity }, paramInt, paramLong, paramArrayOfMediaFileType);
  }

  public a(ConversationWithMediaSizesEntity[] paramArrayOfConversationWithMediaSizesEntity, int paramInt, long paramLong, MediaFileType[] paramArrayOfMediaFileType)
  {
    this.a = paramArrayOfConversationWithMediaSizesEntity;
    this.b = paramInt;
    this.c = paramLong;
    this.d = paramArrayOfMediaFileType;
  }

  public long a()
  {
    if (this.a.length == 1)
      return this.a[0].getId();
    return -1L;
  }

  public ConversationWithMediaSizesEntity[] b()
  {
    return this.a;
  }

  public long c()
  {
    return this.c;
  }

  public MediaFileType[] d()
  {
    return this.d;
  }

  public String toString()
  {
    return "ClearConversationMediaTaskData{mConversations=" + Arrays.toString(this.a) + ", mSource=" + this.b + ", mSizeBytes=" + this.c + ", mSelectedMediaTypes=" + Arrays.toString(this.d) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.a.a
 * JD-Core Version:    0.6.2
 */