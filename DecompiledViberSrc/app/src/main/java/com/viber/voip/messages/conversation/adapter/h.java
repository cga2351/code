package com.viber.voip.messages.conversation.adapter;

import android.view.LayoutInflater;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.aa;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ab;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ac;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ad;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ae;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.af;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ag;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ah;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ai;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.aj;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ak;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.al;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.am;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.an;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.ao;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.c;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.d;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.e;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.f;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.g;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.i;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.j;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.k;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.l;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.m;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.n;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.o;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.p;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.q;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.r;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.s;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.t;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.u;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.v;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.w;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.x;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.y;
import com.viber.voip.messages.conversation.adapter.viewbinders.a.z;

class h extends a
{
  h(LayoutInflater paramLayoutInflater, com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    super(paramLayoutInflater);
    a(0, R.layout.msg_list_notification, new v(parama));
    a(33, R.layout.msg_list_deleted_incoming, new e(parama));
    a(34, R.layout.msg_list_deleted_outgoing, new x(parama));
    a(1, R.layout.msg_list_text_incoming, new o(parama));
    a(3, R.layout.msg_list_image_incoming, new i(parama));
    a(5, R.layout.msg_list_video_incoming, new q(parama));
    a(7, R.layout.msg_list_location_incoming, new k(parama));
    a(2, R.layout.msg_list_text_outgoing, new ai(parama));
    a(4, R.layout.msg_list_image_outgoing, new ac(parama));
    a(6, R.layout.msg_list_video_outgoing, new ak(parama));
    a(8, R.layout.msg_list_location_outgoing, new ae(parama));
    a(9, R.layout.msg_list_sticker_incoming, new n(parama));
    a(10, R.layout.msg_list_sticker_outgoing, new ah(parama));
    a(11, R.layout.msg_list_call, new com.viber.voip.messages.conversation.adapter.viewbinders.a.a(parama));
    a(14, R.layout.msg_list_fm_incoming, new g(parama));
    a(15, R.layout.msg_list_fm_outgoing, new aa(parama));
    a(12, R.layout.msg_list_voice_message_incoming, new r(parama));
    a(13, R.layout.msg_list_voice_message_outgoing, new al(parama));
    a(17, R.layout.msg_list_empty, new c(parama));
    a(16, R.layout.msg_list_debug_empty, new b(parama));
    a(18, R.layout.msg_list_file_incoming, new f(parama));
    a(19, R.layout.msg_list_file_outgoing, new z(parama));
    a(27, R.layout.msg_list_ivm_incoming, new j(parama));
    a(28, R.layout.msg_list_ivm_outgoing, new ad(parama));
    a(31, R.layout.msg_list_bigemoticon_incoming, new d(parama));
    a(32, R.layout.msg_list_bigemoticon_outgoing, new w(parama));
    a(29, R.layout.msg_list_rich_incoming, new l(parama));
    a(30, R.layout.msg_list_rich_outgoing, new af(parama));
    a(25, R.layout.msg_list_gif_incoming, new com.viber.voip.messages.conversation.adapter.viewbinders.a.h(parama));
    a(26, R.layout.msg_list_gif_outgoing, new ab(parama));
    a(36, R.layout.msg_list_translate_outgoing, new aj(parama));
    a(38, R.layout.msg_list_screenshot_outgoing, new ag(parama));
    a(35, R.layout.msg_list_translate_incoming, new p(parama));
    a(20, R.layout.msg_list_wink_image_incoming, new t(parama));
    a(21, R.layout.msg_list_wink_image_outgoing, new an(parama));
    a(22, R.layout.msg_list_wink_video_incoming, new u(parama));
    a(23, R.layout.msg_list_wink_video_outgoing, new ao(parama));
    a(24, R.layout.msg_list_expired_wink_outgoing, new y(parama));
    a(37, R.layout.msg_list_screenshot_incoming, new m(parama));
    a(39, R.layout.msg_list_vote_incoming, new s(parama));
    a(40, R.layout.msg_list_vote_outgoing, new am(parama));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.h
 * JD-Core Version:    0.6.2
 */