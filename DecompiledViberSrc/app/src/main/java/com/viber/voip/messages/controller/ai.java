package com.viber.voip.messages.controller;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pair;
import com.viber.voip.apps.b;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.af;
import com.viber.voip.messages.controller.manager.az.a;
import com.viber.voip.messages.controller.manager.y;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.l;
import com.viber.voip.model.entity.m;
import com.viber.voip.publicaccount.entity.PublicAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface ai
{
  public abstract void a();

  public abstract void a(int paramInt, long paramLong, PublicAccount paramPublicAccount, e parame);

  public abstract void a(int paramInt, Member paramMember, long paramLong, boolean paramBoolean1, boolean paramBoolean2, e parame);

  public abstract void a(long paramLong);

  public abstract void a(long paramLong, int paramInt);

  public abstract void a(long paramLong, int paramInt, m paramm);

  public abstract void a(long paramLong, int paramInt, CharSequence paramCharSequence, String paramString, LongSparseArray<Integer> paramLongSparseArray);

  public abstract void a(long paramLong, int paramInt, String paramString);

  public abstract void a(long paramLong, int paramInt, String paramString, j paramj);

  public abstract void a(long paramLong, int paramInt, boolean paramBoolean);

  public abstract void a(long paramLong1, long paramLong2);

  public abstract void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2, String[] paramArrayOfString, boolean paramBoolean, Bundle paramBundle);

  public abstract void a(long paramLong, Uri paramUri);

  public abstract void a(long paramLong, b paramb);

  public abstract void a(long paramLong, d paramd);

  public abstract void a(long paramLong, e parame);

  public abstract void a(long paramLong, f paramf);

  public abstract void a(long paramLong, h paramh);

  public abstract void a(long paramLong, String paramString);

  public abstract void a(long paramLong, boolean paramBoolean);

  public abstract void a(long paramLong, boolean paramBoolean, int paramInt);

  public abstract void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2);

  public abstract void a(long paramLong, boolean paramBoolean, m paramm);

  public abstract void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void a(Pin paramPin, long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2);

  public abstract void a(a parama);

  public abstract void a(k paramk);

  public abstract void a(y paramy, af paramaf, l paraml);

  public abstract void a(ConversationLoaderEntity paramConversationLoaderEntity);

  public abstract void a(aa paramaa);

  public abstract void a(aa paramaa, int paramInt1, int paramInt2);

  public abstract void a(CallEntity paramCallEntity, int paramInt, long paramLong, String paramString);

  public abstract void a(MessageEntity paramMessageEntity, Bundle paramBundle);

  public abstract void a(h paramh, i parami);

  public abstract void a(Runnable paramRunnable);

  public abstract void a(String paramString);

  public abstract void a(String paramString, e parame);

  public abstract void a(String paramString, i parami);

  public abstract void a(List<b> paramList);

  public abstract void a(Map<String, az.a> paramMap, long paramLong);

  public abstract void a(Set<Long> paramSet);

  public abstract void a(Set<Long> paramSet, int paramInt);

  public abstract void a(Set<Long> paramSet, c paramc);

  public abstract void a(Set<Long> paramSet, boolean paramBoolean, int paramInt);

  public abstract void a(Set<Long> paramSet, boolean paramBoolean, b paramb);

  public abstract void a(long[] paramArrayOfLong, Bundle paramBundle, ConversationItemLoaderEntity paramConversationItemLoaderEntity, g paramg);

  public abstract void a(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle);

  public abstract boolean a(int paramInt, boolean paramBoolean);

  public abstract void b();

  public abstract void b(long paramLong);

  public abstract void b(long paramLong, int paramInt);

  public abstract void b(long paramLong, Uri paramUri);

  public abstract void b(long paramLong, b paramb);

  public abstract void b(long paramLong, String paramString);

  public abstract void b(long paramLong, boolean paramBoolean);

  public abstract void b(long paramLong, boolean paramBoolean, m paramm);

  public abstract void b(aa paramaa);

  public abstract void b(List<MessageEntity> paramList);

  public abstract void c();

  public abstract void c(long paramLong);

  public abstract void c(long paramLong, int paramInt);

  public abstract void c(long paramLong, b paramb);

  public abstract void c(long paramLong, boolean paramBoolean);

  public abstract void c(long paramLong, boolean paramBoolean, m paramm);

  public abstract u d();

  public abstract void d(long paramLong);

  public abstract void d(long paramLong, boolean paramBoolean);

  public abstract void d(long paramLong, boolean paramBoolean, m paramm);

  public abstract void e();

  public abstract void e(long paramLong);

  public static abstract interface a
  {
    public abstract void a();
  }

  public static abstract interface b
  {
    public abstract void a(Set<Long> paramSet);
  }

  public static abstract interface c
  {
    public abstract void a(Map<Long, Integer> paramMap);
  }

  public static abstract interface d
  {
    public abstract void a(h paramh);
  }

  public static abstract interface e
  {
    public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity);
  }

  public static abstract interface f
  {
    public abstract void a(List<MessageCallEntity> paramList);
  }

  public static abstract interface g
  {
    public abstract void a(List<MessageEntity> paramList1, List<MessageEntity> paramList2);
  }

  public static abstract interface h
  {
    public abstract void a(Map<m, l> paramMap);
  }

  public static abstract interface i
  {
    public abstract void a(PublicAccount paramPublicAccount);
  }

  public static abstract interface j
  {
    public abstract void a(List<Pair<MessageEntity, Integer>> paramList);
  }

  public static abstract interface k
  {
    public abstract void a(int paramInt);
  }

  public static class l<T extends ConversationLoaderEntity>
  {
    public void a(y paramy, ArrayList<T> paramArrayList)
    {
    }
  }

  public static abstract interface m
  {
    public abstract void a();
  }

  public static abstract interface n
  {
    public abstract void a(String paramString, List<PublicAccount> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.ai
 * JD-Core Version:    0.6.2
 */