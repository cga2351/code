package com.viber.jni.publicgroup;

import com.viber.jni.PublicGroupChangeEvent;
import com.viber.jni.PublicGroupMessage;
import java.util.Map;

public abstract interface PublicGroupControllerDelegate
{
  public static abstract interface EnabledDelegate
  {
    public abstract void onPublicChatSupported(int paramInt);
  }

  public static abstract interface InviteReceive
  {
    public abstract boolean onPublicGroupInvite(long paramLong1, String paramString1, long paramLong2, int paramInt1, String paramString2, long paramLong3, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }

  public static abstract interface InviteSend
  {
    public abstract void onSendPublicGroupInviteReply(int paramInt1, long paramLong, int paramInt2, Map<String, Integer> paramMap);
  }

  public static abstract interface PublicGroupDelegate extends PublicGroupControllerDelegate.InviteReceive, PublicGroupControllerDelegate.InviteSend, PublicGroupControllerDelegate.PublicGroupGetMessages
  {
  }

  public static abstract interface PublicGroupGetMessages
  {
    public abstract void onGetPublicGroupMessages(int paramInt1, long paramLong, PublicGroupMessage[] paramArrayOfPublicGroupMessage, PublicGroupChangeEvent[] paramArrayOfPublicGroupChangeEvent, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PublicGroupControllerDelegate
 * JD-Core Version:    0.6.2
 */