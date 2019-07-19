package com.viber.voip.group.participants.settings;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class i extends com.viber.voip.messages.conversation.adapter.a.b.c
  implements CompoundButton.OnCheckedChangeListener
{
  private final c e;
  private final SwitchCompat f;
  private final k g;
  private ae h;

  public i(e parame, f paramf, c paramc, View paramView, k paramk)
  {
    super(parame, paramf, paramc, paramView);
    this.e = paramc;
    this.f = ((SwitchCompat)paramView.findViewById(R.id.checker));
    this.g = paramk;
    this.f.setOnCheckedChangeListener(this);
  }

  private b a()
  {
    Object localObject = this.e.a(this.h.h());
    if (localObject == null)
      localObject = this.h;
    return localObject;
  }

  public void a(s params)
  {
    super.a(params);
    this.h = ((ae)params);
    b localb = a();
    this.f.setOnCheckedChangeListener(null);
    this.f.setChecked(localb.canWrite());
    this.f.setOnCheckedChangeListener(this);
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.g.a(this.h, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.settings.i
 * JD-Core Version:    0.6.2
 */