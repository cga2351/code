package com.viber.voip.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.util.dc;

public class n
{
  public View a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public ViewStub e;
  public Button f;

  public n(View paramView)
  {
    this.a = paramView.findViewById(R.id.empty_root);
    this.b = ((TextView)paramView.findViewById(R.id.empty_title));
    this.c = ((TextView)paramView.findViewById(R.id.empty_subtitle));
    this.d = ((ImageView)paramView.findViewById(R.id.empty_image));
    this.e = ((ViewStub)paramView.findViewById(R.id.empty_container_stub));
    this.f = ((Button)paramView.findViewById(R.id.empty_button));
  }

  private void a(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
    int i = this.c.getResources().getDimensionPixelSize(paramInt);
    localMarginLayoutParams.rightMargin = i;
    localMarginLayoutParams.leftMargin = i;
    this.c.setLayoutParams(localMarginLayoutParams);
  }

  public void a()
  {
    this.b.setText(R.string.empty_no_calls_yet);
    this.c.setVisibility(8);
    this.d.setImageResource(R.drawable.empty_no_calls);
    this.f.setVisibility(8);
  }

  public void b()
  {
    this.b.setText(R.string.market_error_no_connection);
    this.c.setText(R.string.pgroups_noconnectivity_description);
    this.d.setImageResource(R.drawable.empty_no_connection);
    this.f.setVisibility(0);
    this.f.setText(R.string.market_error_btn_try_again);
  }

  public void c()
  {
    this.b.setText(R.string.start_chatting);
    this.b.setTextColor(dc.d(this.b.getContext(), R.attr.textSecondaryColor));
    this.c.setVisibility(8);
    this.c.setText(R.string.subtitle_chat_empty_screen);
    a(R.dimen.general_empty_holder_no_messages_subtitle_horizontal_margin);
    this.d.setImageResource(R.drawable.empty_not_found);
    this.e.setLayoutResource(R.layout.empty_messages_inner);
    this.e.inflate();
    this.f.setText(R.string.btn_msg_compose);
    this.f.setVisibility(8);
    this.f.setId(R.id.compose_btn);
  }

  public void d()
  {
    this.b.setText(R.string.contacts_sync);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setImageResource(R.drawable.empty_syncing_contacts);
    this.f.setVisibility(8);
  }

  public void e()
  {
    this.b.setText(R.string.no_contacts);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setImageResource(R.drawable.empty_no_contacts);
    this.f.setVisibility(8);
  }

  public void f()
  {
    this.b.setText(R.string.noViberContacts);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setImageResource(R.drawable.empty_no_viber_contacts);
    this.f.setVisibility(0);
    this.f.setText(R.string.conversation_info_invite_btn_text);
    this.f.setId(R.id.invite_contact_btn);
  }

  public void g()
  {
    this.b.setText(R.string.no_contacts_found);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setImageResource(R.drawable.empty_not_found);
    this.f.setVisibility(8);
  }

  public void h()
  {
    this.b.setText(R.string.msg_syncing_failed);
    this.c.setVisibility(0);
    this.c.setText(R.string.msg_syncing_failed_detailes);
    this.d.setVisibility(8);
    this.f.setVisibility(0);
    this.f.setText(R.string.btn_sync_contacts);
    this.f.setId(R.id.sync_contact_btn);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.n
 * JD-Core Version:    0.6.2
 */