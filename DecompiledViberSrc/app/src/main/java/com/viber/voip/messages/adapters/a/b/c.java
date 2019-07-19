package com.viber.voip.messages.adapters.a.b;

import android.os.SystemClock;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.ui.g.e;
import com.viber.voip.widget.AccurateChronometer;

public class c extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private final AccurateChronometer a;

  public c(AccurateChronometer paramAccurateChronometer)
  {
    this.a = paramAccurateChronometer;
    this.a.setUseLightVisibilityStrategy(true);
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    OngoingConferenceCallModel localOngoingConferenceCallModel = parama.h();
    if (localOngoingConferenceCallModel == null)
      return;
    long l = Math.max(System.currentTimeMillis() - localOngoingConferenceCallModel.startTimeMillis, 0L);
    this.a.setBase(SystemClock.elapsedRealtime() - l);
    this.a.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.c
 * JD-Core Version:    0.6.2
 */