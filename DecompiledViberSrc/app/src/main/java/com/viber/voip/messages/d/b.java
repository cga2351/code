package com.viber.voip.messages.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ui.ck;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.m;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface b
{
  public abstract Bitmap a(Context paramContext, int paramInt1, int paramInt2, h paramh, m paramm);

  public abstract Bitmap a(Context paramContext, int paramInt1, int paramInt2, h paramh, List<m> paramList);

  public abstract Uri a(long paramLong);

  public abstract Uri a(String paramString, int paramInt);

  public abstract b a();

  public abstract m a(Member paramMember);

  public abstract m a(m paramm, Member paramMember);

  public abstract String a(Resources paramResources, ck paramck, int paramInt1, int paramInt2, int paramInt3);

  public abstract String a(Resources paramResources, Collection<ck> paramCollection, int paramInt1, int paramInt2, int paramInt3);

  public abstract String a(String paramString, int paramInt1, int paramInt2);

  public abstract String a(String paramString1, int paramInt1, int paramInt2, String paramString2);

  public abstract Set<m> a(Map<m, Member> paramMap);

  public abstract void a(g paramg);

  public abstract void a(String paramString);

  public abstract void a(Set<String> paramSet);

  public abstract void a(boolean paramBoolean, List<String> paramList);

  public abstract m b(long paramLong);

  public abstract String b(String paramString, int paramInt);

  public abstract void b();

  public abstract m c(String paramString, int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.d.b
 * JD-Core Version:    0.6.2
 */