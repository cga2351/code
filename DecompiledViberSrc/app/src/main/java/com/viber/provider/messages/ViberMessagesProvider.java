package com.viber.provider.messages;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.provider.ViberContentProvider;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.bk;
import com.viber.voip.s.a.a;
import com.viber.voip.s.a.ab;
import com.viber.voip.s.a.ac;
import com.viber.voip.s.a.ad;
import com.viber.voip.s.a.ae;
import com.viber.voip.s.a.ah;
import com.viber.voip.s.a.ai;
import com.viber.voip.s.a.e;
import com.viber.voip.s.a.g;
import com.viber.voip.s.a.h;
import com.viber.voip.s.a.s;
import com.viber.voip.s.a.t;
import com.viber.voip.s.a.u;
import com.viber.voip.s.a.v;
import com.viber.voip.s.a.w;
import com.viber.voip.s.a.x;
import com.viber.voip.s.a.y;
import com.viber.voip.s.a.z;

public class ViberMessagesProvider extends ViberContentProvider
{
  private static UriMatcher a;
  private static Logger b;

  private static UriMatcher c()
  {
    if (a == null);
    try
    {
      if (a == null)
      {
        UriMatcher localUriMatcher = new UriMatcher(-1);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "messages_list", 201);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "broadcast_message_status", 204);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "broadcast_message_info", 205);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "message_likes_list", 203);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "conversations_list", 101);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "conversation", 102);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "conversations_extra_list", 104);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "conversations_extra_with_ad_list", 103);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "public_group_conversation", 105);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "public_account", 106);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "community", 107);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "common_groups", 108);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "participants_list", 301);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "banned_participants_status", 302);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "blocked_data", 401);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "pin_messages_list", 402);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "chat_extensions_list", 501);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "conversation_auxiliary_list", 601);
        localUriMatcher.addURI("com.viber.voip.provider.vibermessages", "conversation_auxiliary", 602);
        a = localUriMatcher;
      }
      return a;
    }
    finally
    {
    }
  }

  private static Logger d()
  {
    if (b == null)
      b = ViberEnv.getLogger();
    return b;
  }

  protected b a()
  {
    return com.viber.provider.messages.b.d.a(getContext());
  }

  protected b b()
  {
    return com.viber.provider.messages.b.d.b(getContext());
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("ViberMessagesProvider does not support delete operation");
  }

  public String getType(Uri paramUri)
  {
    c().match(paramUri);
    throw new IllegalArgumentException("Unknown URI " + paramUri);
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("ViberMessagesProvider does not support insert operation");
  }

  public boolean onCreate()
  {
    bk.a(getContext());
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (a(paramUri, null, null))
      return null;
    int i = c().match(paramUri);
    d();
    Object localObject;
    switch (i)
    {
    default:
      throw new IllegalArgumentException("Unsupported URI:" + paramUri);
    case 101:
    case 104:
      localObject = new y();
    case 102:
    case 103:
    case 105:
    case 106:
    case 107:
    case 108:
    case 201:
    case 204:
    case 205:
    case 203:
    case 301:
    case 302:
    case 401:
    case 402:
    case 501:
    case 601:
    case 602:
    }
    while (true)
    {
      boolean bool = TextUtils.isEmpty(paramString2);
      String str = null;
      if (bool);
      try
      {
        while (true)
        {
          i.a();
          Cursor localCursor = ((ai)localObject).a(b(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
          return localCursor;
          localObject = new t();
          break;
          localObject = new x();
          break;
          localObject = new u();
          break;
          localObject = new v();
          break;
          localObject = new s();
          break;
          localObject = new h();
          break;
          localObject = new ac();
          break;
          localObject = new e();
          break;
          localObject = new com.viber.voip.s.a.d();
          break;
          localObject = new ab();
          break;
          localObject = new ad();
          break;
          localObject = new a();
          break;
          localObject = new ah("blocked_data");
          break;
          localObject = new ae();
          break;
          localObject = new g();
          break;
          localObject = new z();
          break;
          localObject = new w();
          break;
          str = paramString2;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        throw localRuntimeException;
      }
    }
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("ViberMessagesProvider does not support update operation");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.ViberMessagesProvider
 * JD-Core Version:    0.6.2
 */