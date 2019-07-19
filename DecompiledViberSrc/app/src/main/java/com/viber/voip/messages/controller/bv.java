package com.viber.voip.messages.controller;

import android.os.Handler;
import com.viber.jni.slashkey.SlashKeyAdapterErrorCode;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.w;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface bv
{
  public abstract void a(a parama);

  public abstract void a(b paramb);

  public abstract void a(c paramc);

  public abstract void a(e parame);

  public abstract void a(e parame, Handler paramHandler);

  public abstract void a(h paramh);

  public abstract void a(h paramh, Handler paramHandler);

  public abstract void a(k paramk);

  public abstract void a(l paraml);

  public abstract void a(l paraml, Handler paramHandler);

  public abstract void a(m paramm);

  public abstract void a(n paramn);

  public abstract void a(r paramr);

  public abstract void a(s params);

  public abstract void b(a parama);

  public abstract void b(b paramb);

  public abstract void b(c paramc);

  public abstract void b(e parame);

  public abstract void b(h paramh);

  public abstract void b(k paramk);

  public abstract void b(l paraml);

  public abstract void b(m paramm);

  public abstract void b(n paramn);

  public abstract void b(r paramr);

  public abstract void b(s params);

  public static abstract interface a
  {
    public abstract void a(String paramString);

    public abstract void a(String paramString, BotReplyConfig paramBotReplyConfig);

    public abstract void a(String paramString1, String paramString2, boolean paramBoolean);
  }

  public static abstract interface b
  {
    public abstract void a();
  }

  public static abstract interface c
  {
    public abstract void a(long paramLong1, boolean paramBoolean, long paramLong2);
  }

  @Deprecated
  public static class d
    implements bv.e
  {
    public void onChange(Set<Long> paramSet, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
    }

    public void onConversationClosed(boolean paramBoolean, long paramLong)
    {
    }

    public void onDelete(Set<Long> paramSet, int paramInt, boolean paramBoolean)
    {
    }

    public void onOpen1to1(Set<Long> paramSet, boolean paramBoolean)
    {
    }

    public void onOpenConversation(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
    {
    }

    public void onOpenPublicGroup(long paramLong, Set<Long> paramSet)
    {
    }

    public void onRead(Set<Long> paramSet, int paramInt, boolean paramBoolean)
    {
    }

    public void onReadOutgoing(long paramLong, int paramInt, boolean paramBoolean)
    {
    }

    public void onWatchersCountChange(long paramLong, int paramInt)
    {
    }
  }

  public static abstract interface e
  {
    public abstract void onChange(Set<Long> paramSet, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

    public abstract void onConversationClosed(boolean paramBoolean, long paramLong);

    public abstract void onDelete(Set<Long> paramSet, int paramInt, boolean paramBoolean);

    public abstract void onOpen1to1(Set<Long> paramSet, boolean paramBoolean);

    public abstract void onOpenConversation(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

    public abstract void onOpenPublicGroup(long paramLong, Set<Long> paramSet);

    public abstract void onRead(Set<Long> paramSet, int paramInt, boolean paramBoolean);

    public abstract void onReadOutgoing(long paramLong, int paramInt, boolean paramBoolean);

    public abstract void onWatchersCountChange(long paramLong, int paramInt);
  }

  public static abstract interface f
  {
    public abstract void a(Set<String> paramSet);
  }

  public static abstract interface g extends bv.c
  {
  }

  public static abstract interface h
  {
    public abstract void onAssignRole(int paramInt1, String[] paramArrayOfString, int paramInt2, Map<String, Integer> paramMap);

    public abstract void onGroupCreateError(int paramInt1, int paramInt2, Map<String, Integer> paramMap);

    public abstract void onGroupCreated(int paramInt, long paramLong1, long paramLong2, Map<String, Integer> paramMap, boolean paramBoolean);

    public abstract void onGroupIconChanged(int paramInt1, long paramLong, int paramInt2);

    public abstract void onGroupInfoUpdateStarted(int paramInt);

    public abstract void onGroupRenamed(int paramInt1, long paramLong, int paramInt2);

    public abstract void onGroupUnknownChanged(long paramLong, int paramInt);

    public abstract void onMembersAddedToGroup(int paramInt1, long paramLong, int paramInt2, Map<String, Integer> paramMap);

    public abstract void onMembersRemovedFromGroup(long paramLong, int paramInt, String[] paramArrayOfString, Map<String, Integer> paramMap);
  }

  public static abstract interface i
  {
    public abstract void a(int paramInt1, int paramInt2, long paramLong, List<w> paramList, Set<String> paramSet);
  }

  public static abstract interface j
  {
    public abstract void a();

    public abstract void a(long paramLong);
  }

  public static abstract interface k
  {
    public abstract void a(String paramString1, String paramString2, d[] paramArrayOfd, @SlashKeyAdapterErrorCode String paramString3);
  }

  public static abstract interface l
  {
    public abstract void a(long paramLong1, long paramLong2, boolean paramBoolean);

    public abstract void a(long paramLong, Set<Long> paramSet);

    public abstract void a(MessageEntity paramMessageEntity, boolean paramBoolean);

    public abstract void a(Set<Long> paramSet, boolean paramBoolean);

    public abstract void a(Set<Long> paramSet, boolean paramBoolean1, boolean paramBoolean2);

    public abstract void b(long paramLong1, long paramLong2, boolean paramBoolean);
  }

  public static abstract interface m
  {
    public abstract void a(MessageEntity paramMessageEntity, int paramInt);
  }

  public static abstract interface n
  {
    public abstract void onChange(Set<Long> paramSet, Set<String> paramSet1, boolean paramBoolean);

    public abstract void onContactStatusChanged(Map<Long, a> paramMap);

    public abstract void onInitCache();

    public abstract void onNewInfo(List<m> paramList, boolean paramBoolean);

    public abstract void onParticipantDeleted(m paramm);

    public static enum a
    {
      static
      {
        a[] arrayOfa = new a[4];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
        arrayOfa[3] = d;
      }
    }
  }

  public static abstract interface o
  {
    public abstract void a();

    public abstract void a(String paramString);
  }

  public static abstract interface p extends bv.o
  {
  }

  public static class q
    implements bv.r
  {
    public void a(long paramLong)
    {
    }

    public void a(String paramString)
    {
    }

    public void a(String paramString, int paramInt)
    {
    }
  }

  public static abstract interface r
  {
    public abstract void a(long paramLong);

    public abstract void a(String paramString);

    public abstract void a(String paramString, int paramInt);
  }

  public static abstract interface s
  {
    public abstract void T_();
  }

  public static class t
    implements bv.u
  {
    public void onAssignRole(int paramInt1, String[] paramArrayOfString, int paramInt2, Map<String, Integer> paramMap)
    {
    }

    public void onGroupCreateError(int paramInt1, int paramInt2, Map<String, Integer> paramMap)
    {
    }

    public void onGroupCreated(int paramInt, long paramLong1, long paramLong2, Map<String, Integer> paramMap, boolean paramBoolean)
    {
    }

    public void onGroupIconChanged(int paramInt1, long paramLong, int paramInt2)
    {
    }

    public void onGroupInfoUpdateStarted(int paramInt)
    {
    }

    public void onGroupRenamed(int paramInt1, long paramLong, int paramInt2)
    {
    }

    public void onGroupUnknownChanged(long paramLong, int paramInt)
    {
    }

    public void onJoinToPublicGroup(int paramInt1, long paramLong, int paramInt2, int paramInt3)
    {
    }

    public void onMembersAddedToGroup(int paramInt1, long paramLong, int paramInt2, Map<String, Integer> paramMap)
    {
    }

    public void onMembersRemovedFromGroup(long paramLong, int paramInt, String[] paramArrayOfString, Map<String, Integer> paramMap)
    {
    }

    public void onPublicGroupCreateError(int paramInt1, int paramInt2)
    {
    }

    public void onPublicGroupCreated(int paramInt, long paramLong1, long paramLong2, String paramString1, Map<String, Integer> paramMap, String paramString2, String paramString3)
    {
    }

    public void onPublicGroupInfoChanged(int paramInt1, long paramLong, int paramInt2, int paramInt3)
    {
    }

    public void onPublicGroupInfoUpdateError(int paramInt1, int paramInt2)
    {
    }

    public void onPublicGroupSyncFinished(int paramInt1, long paramLong, int paramInt2)
    {
    }

    public void onPublicGroupSyncQueued(int paramInt, long paramLong)
    {
    }

    public void onPublicGroupSyncRequestCanceled(int paramInt)
    {
    }

    public void onPublicGroupSyncStarted(int paramInt, long paramLong)
    {
    }

    public void onValidateGroupUriReply(long paramLong, int paramInt)
    {
    }
  }

  public static abstract interface u extends bv.h
  {
    public abstract void onJoinToPublicGroup(int paramInt1, long paramLong, int paramInt2, int paramInt3);

    public abstract void onPublicGroupCreateError(int paramInt1, int paramInt2);

    public abstract void onPublicGroupCreated(int paramInt, long paramLong1, long paramLong2, String paramString1, Map<String, Integer> paramMap, String paramString2, String paramString3);

    public abstract void onPublicGroupInfoChanged(int paramInt1, long paramLong, int paramInt2, int paramInt3);

    public abstract void onPublicGroupInfoUpdateError(int paramInt1, int paramInt2);

    public abstract void onPublicGroupSyncFinished(int paramInt1, long paramLong, int paramInt2);

    public abstract void onPublicGroupSyncQueued(int paramInt, long paramLong);

    public abstract void onPublicGroupSyncRequestCanceled(int paramInt);

    public abstract void onPublicGroupSyncStarted(int paramInt, long paramLong);

    public abstract void onValidateGroupUriReply(long paramLong, int paramInt);
  }

  public static abstract interface v
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.bv
 * JD-Core Version:    0.6.2
 */