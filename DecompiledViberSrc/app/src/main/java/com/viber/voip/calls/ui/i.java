package com.viber.voip.calls.ui;

import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.ui.h.a;
import java.util.ArrayList;
import java.util.List;

public class i
  implements a
{
  private k a;
  private List<ConferenceParticipant> b;

  public i(k paramk)
  {
    this.a = paramk;
    this.b = new ArrayList();
  }

  public int a()
  {
    if (this.b.isEmpty())
      return 0;
    return 1 + this.b.size();
  }

  public void a(List<ConferenceParticipant> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
  }

  public Object b(int paramInt)
  {
    if (paramInt > 0)
      return this.b.get(paramInt - 1);
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.i
 * JD-Core Version:    0.6.2
 */