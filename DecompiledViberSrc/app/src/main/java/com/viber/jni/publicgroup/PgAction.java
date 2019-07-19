package com.viber.jni.publicgroup;

public class PgAction
{
  private long actionFlags;
  private int likeCount;

  private PgAction(int paramInt, long paramLong)
  {
    this.likeCount = paramInt;
    this.actionFlags = paramLong;
  }

  public long getActionFlags()
  {
    return this.actionFlags;
  }

  public int getLikeCount()
  {
    return this.likeCount;
  }

  public String toString()
  {
    return "PgAction [likeCount=" + this.likeCount + ", actionFlags=" + this.actionFlags + "]";
  }

  public static final class PgActionFlags
  {
    public static final long DELETED = 1L;
    public static final long NONE;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PgAction
 * JD-Core Version:    0.6.2
 */