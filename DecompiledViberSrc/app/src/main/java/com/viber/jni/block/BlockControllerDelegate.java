package com.viber.jni.block;

public abstract interface BlockControllerDelegate
{
  public static abstract interface BlockDelegate extends BlockControllerDelegate.BlockPgInvites
  {
  }

  public static abstract interface BlockPgInvites
  {
    public abstract void onBlockGroupInviteReply(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.block.BlockControllerDelegate
 * JD-Core Version:    0.6.2
 */