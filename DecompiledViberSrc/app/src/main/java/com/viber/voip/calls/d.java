package com.viber.voip.calls;

import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.Call;
import java.util.Collection;

public abstract interface d
{
  public abstract void a();

  public abstract void a(long paramLong, b paramb);

  public abstract void a(long paramLong1, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4, long paramLong2, long paramLong3, int paramInt5, boolean paramBoolean3, ConferenceInfo paramConferenceInfo, String paramString3, a parama);

  public abstract void a(b paramb);

  public abstract void a(c paramc);

  public abstract void a(d paramd);

  public abstract void a(Collection<AggregatedCall> paramCollection, d paramd);

  public abstract boolean a(long paramLong);

  public abstract void b(b paramb);

  public abstract void b(c paramc);

  public abstract void b(Collection<Call> paramCollection, d paramd);

  public static abstract interface a
  {
    public abstract void onInsert(Call paramCall);
  }

  public static abstract interface b
  {
    public abstract void a(long paramLong, Collection<Call> paramCollection);
  }

  public static abstract interface c
  {
    public abstract void a();
  }

  public static abstract interface d
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.d
 * JD-Core Version:    0.6.2
 */