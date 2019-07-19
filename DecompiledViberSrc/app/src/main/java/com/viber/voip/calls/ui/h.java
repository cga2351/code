package com.viber.voip.calls.ui;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.ui.h.b;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.AvatarWithInitialsView;

public class h extends b<ConferenceParticipant, b>
{
  private e a;
  private com.viber.voip.util.e.f b;
  private final a c;

  public h(e parame, com.viber.voip.util.e.f paramf, a parama)
  {
    this.a = parame;
    this.b = paramf;
    this.c = parama;
  }

  public b a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return new b(paramLayoutInflater.inflate(R.layout.group_call_details_participant_list_item, paramViewGroup, false), this.c);
  }

  public void a(b paramb, ConferenceParticipant paramConferenceParticipant, int paramInt)
  {
    String str = paramConferenceParticipant.getImage();
    e locale = this.a;
    if (!TextUtils.isEmpty(str));
    for (Uri localUri = Uri.parse(str); ; localUri = null)
    {
      locale.a(localUri, b.a(paramb), this.b);
      b.b(paramb).setText(paramConferenceParticipant.getName());
      return;
    }
  }

  public boolean a(Object paramObject)
  {
    return paramObject instanceof ConferenceParticipant;
  }

  public static abstract interface a
  {
    public abstract void a(ConferenceParticipant paramConferenceParticipant);
  }

  static class b extends com.viber.voip.ui.h.f<ConferenceParticipant>
    implements View.OnClickListener
  {
    private final h.a a;
    private AvatarWithInitialsView b;
    private TextView c;

    public b(View paramView, h.a parama)
    {
      super();
      this.a = parama;
      paramView.setOnClickListener(this);
      this.b = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
      this.c = ((TextView)paramView.findViewById(R.id.name));
    }

    public void onClick(View paramView)
    {
      if (this.a != null)
        this.a.a((ConferenceParticipant)e());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.h
 * JD-Core Version:    0.6.2
 */