package com.viber.voip.messages.conversation;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.e;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.controller.by;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d extends com.viber.provider.d
{
  private final long l;
  private final bv m;
  private final bv.d n = new bv.d()
  {
    public void onReadOutgoing(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      d.this.l();
    }
  };
  private final bv.n o = new bv.n()
  {
    public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
    {
    }

    public void onContactStatusChanged(Map<Long, bv.n.a> paramAnonymousMap)
    {
    }

    public void onInitCache()
    {
      d.this.l();
    }

    public void onNewInfo(List<m> paramAnonymousList, boolean paramAnonymousBoolean)
    {
    }

    public void onParticipantDeleted(m paramAnonymousm)
    {
    }
  };
  private final bv.l p = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousMessageEntity.getBroadcastMessageId() == d.a(d.this))
        d.this.l();
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      d.this.l();
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };

  public d(Context paramContext, bv parambv, LoaderManager paramLoaderManager, d.a parama, long paramLong)
  {
    super(26, c.e.d, paramContext, paramLoaderManager, parama, 0);
    this.m = parambv;
    a(e.a);
    a("broadcast_msg_id>0 AND broadcast_msg_id=? AND deleted<>1 AND extra_mime<>1008 AND participant_type=1");
    this.l = paramLong;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    b(arrayOfString);
  }

  public e e(int paramInt)
  {
    if (b_(paramInt))
      return new e(this.f);
    return null;
  }

  public void p()
  {
    super.p();
    this.m.a(this.n);
    this.m.a(this.o);
    this.m.a(this.p);
  }

  public void q()
  {
    super.q();
    this.m.b(this.n);
    this.m.b(this.o);
    this.m.b(this.p);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.d
 * JD-Core Version:    0.6.2
 */