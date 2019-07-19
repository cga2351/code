package com.viber.voip.calls.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.model.Call;
import com.viber.voip.ui.h.b;
import com.viber.voip.ui.h.f;
import com.viber.voip.util.ae;
import com.viber.voip.util.dc;

public class a extends b<Call, a>
{
  private Context a;
  private int b;
  private int c;
  private int d;
  private int e;

  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = dc.d(paramContext, R.attr.contactDetailsCallItemTypeNormalColor);
    this.e = dc.d(paramContext, R.attr.contactDetailsCallItemTypeMissedColor);
  }

  public a a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    View localView = paramLayoutInflater.inflate(R.layout.contact_detailes_call_log_item, paramViewGroup, false);
    localView.setPadding(this.b, localView.getPaddingBottom(), this.c, localView.getPaddingTop());
    return new a(localView);
  }

  public void a(a parama, Call paramCall, int paramInt)
  {
    String str1 = ae.a(this.a, paramCall.getDate(), true);
    parama.a.setText(str1);
    if (paramCall.isTransferredIn())
    {
      parama.d.setVisibility(0);
      parama.d.setText(R.string.call_transferred_on_another_device);
      label52: if ((paramCall.getType() != 3) && (!paramCall.isAnswerredOnAnotherDevice()))
        break label163;
      parama.b.setVisibility(8);
    }
    while (true)
      switch (paramCall.getType())
      {
      case 4:
      default:
        return;
        if (paramCall.isAnswerredOnAnotherDevice())
        {
          parama.d.setVisibility(0);
          parama.d.setText(R.string.call_answered_on_another_device);
          break label52;
        }
        parama.d.setVisibility(8);
        break label52;
        label163: parama.b.setVisibility(0);
        if (!paramCall.isTransferredIn())
          break label199;
        parama.b.setText(ae.g(paramCall.getDuration()));
      case 1:
      case 5:
      case 2:
      case 3:
      }
    label199: TextView localTextView4 = parama.b;
    if (paramCall.getDuration() == 0L);
    for (String str2 = this.a.getString(R.string.type_cancelled); ; str2 = ae.g(paramCall.getDuration()))
    {
      localTextView4.setText(str2);
      break;
    }
    TextView localTextView3 = parama.c;
    if (paramCall.isTypeViberVideo());
    for (int k = R.string.type_incoming_video; ; k = R.string.type_incoming)
    {
      localTextView3.setText(k);
      parama.c.setTextColor(this.d);
      return;
    }
    TextView localTextView2 = parama.c;
    int j;
    if (paramCall.isTypeViberOut())
      j = R.string.type_viber_out_call;
    while (true)
    {
      localTextView2.setText(j);
      parama.c.setTextColor(this.d);
      return;
      if (paramCall.isTypeViberVideo())
        j = R.string.type_outgoing_video;
      else
        j = R.string.type_outgoing;
    }
    TextView localTextView1 = parama.c;
    if (paramCall.isTypeViberVideo());
    for (int i = R.string.type_missed_video; ; i = R.string.type_missed)
    {
      localTextView1.setText(i);
      parama.c.setTextColor(this.e);
      return;
    }
  }

  public boolean a(Object paramObject)
  {
    return paramObject instanceof Call;
  }

  public static class a extends f<Call>
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;

    public a(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.callDate));
      this.b = ((TextView)paramView.findViewById(R.id.callDuration));
      this.c = ((TextView)paramView.findViewById(R.id.callType));
      this.d = ((TextView)paramView.findViewById(R.id.transferType));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.a
 * JD-Core Version:    0.6.2
 */