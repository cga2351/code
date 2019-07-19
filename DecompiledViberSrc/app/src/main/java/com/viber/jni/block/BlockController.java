package com.viber.jni.block;

public abstract interface BlockController
{
  public abstract boolean handleBlockGroupInvite(long paramLong, boolean paramBoolean, int paramInt);

  public static class CBlockGroupInviteReplyState
  {
    public static final int FAIL = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.block.BlockController
 * JD-Core Version:    0.6.2
 */