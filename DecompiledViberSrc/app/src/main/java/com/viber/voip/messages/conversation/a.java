package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.g;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.model.entity.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a extends d<Integer>
{
  private final dagger.a<bv> l;
  private long m;
  private final bv.n n = new bv.n()
  {
    public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousSet.contains(Long.valueOf(a.a(a.this))))
        a.this.l();
    }

    public void onContactStatusChanged(Map<Long, bv.n.a> paramAnonymousMap)
    {
    }

    public void onInitCache()
    {
      a.this.l();
    }

    public void onNewInfo(List<m> paramAnonymousList, boolean paramAnonymousBoolean)
    {
    }

    public void onParticipantDeleted(m paramAnonymousm)
    {
    }
  };

  public a(Context paramContext, LoaderManager paramLoaderManager, dagger.a<bv> parama, d.a parama1)
  {
    super(36, c.g.b, paramContext, paramLoaderManager, parama1, 0);
    this.l = parama;
    a(new String[] { "COUNT(*)" });
    a("participants.conversation_id=? AND participants.active=2");
  }

  public long a(int paramInt)
  {
    return 0L;
  }

  public void a(long paramLong)
  {
    this.m = paramLong;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(this.m);
    b(arrayOfString);
  }

  public Integer e(int paramInt)
  {
    if (b_(paramInt))
      return Integer.valueOf(this.f.getInt(0));
    return null;
  }

  public void p()
  {
    super.p();
    ((bv)this.l.get()).a(this.n);
  }

  public void q()
  {
    super.q();
    ((bv)this.l.get()).b(this.n);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.a
 * JD-Core Version:    0.6.2
 */