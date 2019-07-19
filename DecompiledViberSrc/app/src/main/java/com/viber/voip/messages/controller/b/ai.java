package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.ConversationSettings;
import com.viber.jni.Engine;
import com.viber.jni.Group2LatestParams;
import com.viber.jni.GroupUserChanged;
import com.viber.jni.PGLatestParamsWithRole;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.user.UserManager;
import java.util.Map;

public class ai extends l
{
  private final Handler d;
  private final l[] e;
  private int f = -1;

  public ai(Context paramContext, Handler paramHandler, l[] paramArrayOfl)
  {
    super(paramContext, UserManager.from(paramContext).getRegistrationValues());
    this.d = paramHandler;
    this.e = paramArrayOfl;
  }

  public void a(Engine paramEngine)
  {
    l[] arrayOfl = this.e;
    int i = arrayOfl.length;
    for (int j = 0; j < i; j++)
      arrayOfl[j].a(paramEngine);
  }

  public void onChangeConversationSettingsReply(final String paramString, final ConversationSettings paramConversationSettings, final int paramInt)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onChangeConversationSettingsReply(paramString, paramConversationSettings, paramInt);
      }
    });
  }

  public void onChangeGroup(final long paramLong1, long paramLong2, final int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onChangeGroup(paramLong1, paramInt1, paramInt3, paramInt4, this.e, this.f);
      }
    });
  }

  public void onChangeGroupSettingsReply(final long paramLong, ConversationSettings paramConversationSettings, final int paramInt)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onChangeGroupSettingsReply(paramLong, paramInt, this.c);
      }
    });
  }

  public void onGlobalDeleteMessageReply(final long paramLong1, long paramLong2, final int paramInt1, int paramInt2)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onGlobalDeleteMessageReply(paramLong1, paramInt1, this.c, this.d);
      }
    });
  }

  public void onGroupAddMembers(final long paramLong1, int paramInt1, final long paramLong2, final int paramInt2, String[] paramArrayOfString, final Map<String, Integer> paramMap, final int paramInt3, final int paramInt4)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int j = arrayOfl.length;
        for (int k = 0; k < j; k++)
          arrayOfl[k].onGroupAddMembers(paramLong1, paramLong2, paramInt2, paramMap, paramInt3, paramInt4, this.g, this.h);
      }
    });
  }

  public boolean onGroupChanged(final long paramLong1, String paramString1, final long paramLong2, final int paramInt1, long paramLong3, final String paramString2, final String paramString3, int paramInt2, final GroupUserChanged[] paramArrayOfGroupUserChanged, final int paramInt3, final String paramString4)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int m = arrayOfl.length;
        for (int n = 0; n < m; n++)
          arrayOfl[n].onGroupChanged(paramLong1, paramLong2, paramInt1, paramString2, paramString3, paramArrayOfGroupUserChanged, paramInt3, paramString4, this.i, this.j, this.k);
      }
    });
    return false;
  }

  public void onGroupLeave(final long paramLong1, long paramLong2, final int paramInt)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onGroupLeave(paramLong1, paramInt, this.c);
      }
    });
  }

  public boolean onHandleSelfDetails(final long paramLong, String paramString1, final String paramString2, final int paramInt)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onHandleSelfDetails(paramLong, paramString2, paramInt, this.d);
      }
    });
    return false;
  }

  public void onPublicGroupsUpdated(final PGLatestParamsWithRole[] paramArrayOfPGLatestParamsWithRole, final long paramLong, Group2LatestParams[] paramArrayOfGroup2LatestParams)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onPublicGroupsUpdated(paramArrayOfPGLatestParamsWithRole, paramLong, this.c);
      }
    });
  }

  public boolean onSecondaryRegistered(final long paramLong, int paramInt1, final int paramInt2, final int paramInt3)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onSecondaryRegistered(paramLong, paramInt2, paramInt3, this.d);
      }
    });
    return false;
  }

  public void onServiceStateChanged(final int paramInt)
  {
    if (this.f == paramInt)
      return;
    this.f = paramInt;
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onServiceStateChanged(paramInt);
      }
    });
  }

  public boolean onUpdateUnsavedContactDetails(final long paramLong, String paramString1, final String paramString2, final String paramString3, final int paramInt, final String paramString4)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onUpdateUnsavedContactDetails(paramLong, paramString2, paramString3, paramInt, paramString4, this.f);
      }
    });
    return false;
  }

  public void onUpdateUserName(int paramInt)
  {
    l[] arrayOfl = this.e;
    int i = arrayOfl.length;
    for (int j = 0; j < i; j++)
      arrayOfl[j].onUpdateUserName(paramInt);
  }

  public void onUpdateUserPhoto(int paramInt)
  {
    l[] arrayOfl = this.e;
    int i = arrayOfl.length;
    for (int j = 0; j < i; j++)
      arrayOfl[j].onUpdateUserPhoto(paramInt);
  }

  public void onValidatePublicGroupUri(final String paramString, final int paramInt1, final int paramInt2)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        l[] arrayOfl = ai.a(ai.this);
        int i = arrayOfl.length;
        for (int j = 0; j < i; j++)
          arrayOfl[j].onValidatePublicGroupUri(paramString, paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.ai
 * JD-Core Version:    0.6.2
 */