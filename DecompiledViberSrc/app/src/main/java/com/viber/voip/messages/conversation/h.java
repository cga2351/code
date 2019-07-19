package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.m;
import dagger.a;
import java.util.Set;

public class h extends c<Long>
{
  public h(Context paramContext, LoaderManager paramLoaderManager, a<bv> parama, d.a parama1)
  {
    super(34, paramContext, paramLoaderManager, parama, parama1, 0);
    a(new String[] { "COUNT(*)" });
  }

  public long a(int paramInt)
  {
    return 0L;
  }

  public Long e(int paramInt)
  {
    if (b_(paramInt))
      return Long.valueOf(this.f.getLong(0));
    return null;
  }

  protected bv.e r()
  {
    return new bv.d()
    {
      public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        if (m.f(paramAnonymousInt))
          h.this.l();
      }

      public void onDelete(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (m.f(paramAnonymousInt))
          h.this.l();
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.h
 * JD-Core Version:    0.6.2
 */