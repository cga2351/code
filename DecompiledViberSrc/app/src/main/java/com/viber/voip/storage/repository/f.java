package com.viber.voip.storage.repository;

import android.content.ContentResolver;
import android.database.Cursor;
import com.viber.voip.contacts.d.a;
import com.viber.voip.contacts.d.d;
import com.viber.voip.messages.controller.manager.ad;
import com.viber.voip.messages.controller.manager.ad.a;
import com.viber.voip.messages.controller.manager.ad.b;
import com.viber.voip.messages.controller.manager.ad.c;
import com.viber.voip.messages.controller.manager.ad.d;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;

class f extends ad
{
  protected f(ad.c paramc, ad.d paramd, ad.b paramb, ad.a parama, a parama1, ContentResolver paramContentResolver)
  {
    super(paramc, paramd, paramb, parama, parama1, paramContentResolver);
  }

  public static f a(com.google.d.f paramf, ContentResolver paramContentResolver)
  {
    return new f(new c(null), new d(null), new b(null), new a(paramf, null), new d(), paramContentResolver);
  }

  private static class a
    implements ad.a
  {
    private final com.google.d.f a;

    private a(com.google.d.f paramf)
    {
      this.a = paramf;
    }

    public ConversationLoaderEntity a(Cursor paramCursor)
    {
      return new ConversationWithMediaSizesEntity(paramCursor, this.a, true);
    }
  }

  private static class b extends ad.b
  {
    protected String[] a()
    {
      return ConversationWithMediaSizesEntity.PROJECTIONS;
    }

    protected String b()
    {
      return super.b() + " LEFT OUTER JOIN conversation_auxiliary ON (conversations._id = conversation_auxiliary._id)";
    }
  }

  private static class c extends ad.c
  {
    protected String[] a()
    {
      return ConversationWithMediaSizesEntity.PROJECTIONS;
    }

    protected String b()
    {
      return super.b() + " LEFT OUTER JOIN conversation_auxiliary ON (conversations._id = conversation_auxiliary._id)";
    }
  }

  private static class d extends ad.d
  {
    protected String[] a()
    {
      return ConversationWithMediaSizesEntity.PROJECTIONS;
    }

    protected String b()
    {
      return super.b() + " LEFT OUTER JOIN conversation_auxiliary ON (conversations._id = conversation_auxiliary._id)";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.f
 * JD-Core Version:    0.6.2
 */