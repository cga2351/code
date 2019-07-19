package com.viber.voip.messages.conversation;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.e;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;

public class f extends d
{
  private long l;
  private final bv m;
  private final bv.d n = new bv.d()
  {
    public void onReadOutgoing(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      synchronized (f.this)
      {
        if (f.a(f.this) > 0L)
        {
          i = 1;
          if (i != 0)
            f.this.l();
          return;
        }
        int i = 0;
      }
    }
  };

  public f(Context paramContext, bv parambv, LoaderManager paramLoaderManager, d.a parama, long paramLong)
  {
    super(25, c.e.c, paramContext, paramLoaderManager, parama, 0);
    this.m = parambv;
    a(g.a);
    a("broadcast_msg_id>0 AND deleted<>1 AND extra_mime<>1008 AND broadcast_msg_id IN (SELECT _id FROM messages WHERE messages.conversation_id=?)");
    b("broadcast_msg_id");
    c("total_count=read_count");
    d("messages.order_key DESC, messages.msg_date DESC");
    d(1);
    this.l = paramLong;
    r();
  }

  private void r()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(this.l);
    b(arrayOfString);
  }

  public void a(long paramLong)
  {
    try
    {
      if (this.l != paramLong)
      {
        this.l = paramLong;
        r();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public g e(int paramInt)
  {
    if (b_(paramInt))
      return new g(this.f);
    return null;
  }

  public void p()
  {
    super.p();
    this.m.a(this.n);
  }

  public void q()
  {
    super.q();
    this.m.b(this.n);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.f
 * JD-Core Version:    0.6.2
 */