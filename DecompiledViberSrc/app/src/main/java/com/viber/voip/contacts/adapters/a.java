package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import java.util.Set;

public class a extends BaseAdapter
  implements n
{
  private final ac a;
  private final LayoutInflater b;
  private final e c;
  private final f d;
  private Set<ParticipantSelector.Participant> e;
  private Set<ParticipantSelector.Participant> f;

  public a(Context paramContext, ac paramac, LayoutInflater paramLayoutInflater)
  {
    this.a = paramac;
    this.b = paramLayoutInflater;
    this.c = e.a(paramContext);
    this.d = f.b(paramContext);
  }

  private void a(ae paramae, a parama)
  {
    ParticipantSelector.Participant localParticipant = ParticipantSelector.Participant.from(paramae);
    if (this.e != null);
    for (boolean bool1 = this.e.contains(localParticipant); ; bool1 = false)
    {
      if (this.f != null)
      {
        boolean bool3 = this.f.contains(localParticipant);
        bool2 = false;
        if (bool3);
      }
      for (boolean bool2 = true; ; bool2 = true)
      {
        parama.b.setChecked(bool1);
        parama.b.setEnabled(bool2);
        parama.c.setEnabled(bool2);
        return;
      }
    }
  }

  public ae a(int paramInt)
  {
    return this.a.e(paramInt);
  }

  public void a(Set<ParticipantSelector.Participant> paramSet1, Set<ParticipantSelector.Participant> paramSet2, boolean paramBoolean)
  {
    this.e = paramSet1;
    this.f = paramSet2;
  }

  public boolean a(int paramInt, ParticipantSelector.Participant paramParticipant)
  {
    ae localae = a(paramInt);
    if (localae != null)
      return paramParticipant.equals(ParticipantSelector.Participant.from(localae));
    return false;
  }

  public boolean e_(int paramInt)
  {
    return false;
  }

  public int getCount()
  {
    return this.a.getCount();
  }

  public long getItemId(int paramInt)
  {
    return this.a.a(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala;
    if (paramView == null)
    {
      locala = new a(this.b.inflate(R.layout.admin_selector_item, paramViewGroup, false));
      paramView = locala.a;
      paramView.setTag(locala);
    }
    while (true)
    {
      ae localae = a(paramInt);
      locala.c.setText(localae.k());
      a(localae, locala);
      Uri localUri = localae.j();
      this.c.a(localUri, locala.d, this.d);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }

  public static class a
  {
    public final View a;
    public final CheckBox b;
    public final TextView c;
    public final ImageView d;

    a(View paramView)
    {
      this.a = paramView;
      this.b = ((CheckBox)paramView.findViewById(R.id.check));
      this.d = ((ImageView)paramView.findViewById(R.id.icon));
      this.c = ((TextView)paramView.findViewById(R.id.name));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.a
 * JD-Core Version:    0.6.2
 */