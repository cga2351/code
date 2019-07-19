package com.viber.voip.messages.conversation.chatinfo.a;

import android.content.res.Resources;
import android.net.Uri;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.backgrounds.m;
import com.viber.voip.block.g;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.chatinfo.d.a;
import com.viber.voip.messages.conversation.chatinfo.d.f;
import com.viber.voip.messages.conversation.chatinfo.d.h;
import com.viber.voip.messages.conversation.chatinfo.d.i;
import com.viber.voip.messages.conversation.chatinfo.d.j;
import com.viber.voip.messages.conversation.chatinfo.d.l;
import com.viber.voip.messages.conversation.chatinfo.d.m.a;
import com.viber.voip.messages.conversation.chatinfo.d.p;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;

final class c
{
  static com.viber.voip.messages.conversation.chatinfo.d.d a()
  {
    return new f();
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d a(Resources paramResources)
  {
    return new i(2, R.attr.chatInfoCommunityInsightsIconTint, R.drawable.ic_insights, paramResources.getString(R.string.community_insights_title), null);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d a(Resources paramResources, int paramInt)
  {
    int i = R.string.public_group_info_participant_count_upper;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.toString(paramInt);
    return new j(2, paramResources.getString(i, arrayOfObject), null, R.attr.chatInfoTextMembersHeader, paramResources.getDimension(R.dimen.group_info_hider_text_size_normal), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom_small));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d a(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    String str1 = paramConversationItemLoaderEntity.getPublicAccountTagsLine();
    String str2;
    if (da.a(str1))
    {
      str2 = paramResources.getString(R.string.group2_info_about_hint);
      if ((!paramConversationItemLoaderEntity.isAdministratorRole()) || (paramConversationItemLoaderEntity.isCommunityBlocked()))
        break label55;
    }
    label55: for (boolean bool = true; ; bool = false)
    {
      return new a(str2, str1, bool);
      str2 = "";
      break;
    }
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d a(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt)
  {
    String str1;
    if (paramInt > 0)
    {
      int i = R.string.public_group_info_admin_count;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.toString(paramInt);
      str1 = paramResources.getString(i, arrayOfObject);
      if (!cd.d(paramConversationItemLoaderEntity.getGroupRole(), paramConversationItemLoaderEntity.getConversationType()))
        break label95;
    }
    label95: for (String str2 = paramResources.getString(R.string.public_group_info_add_admins); ; str2 = "")
    {
      return new j(1, str1, str2, R.attr.chatInfoTextMembersHeader, paramResources.getDimension(R.dimen.group_info_hider_text_size_normal), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom_small));
      str1 = paramResources.getString(R.string.public_group_info_admin);
      break;
    }
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d a(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity, a parama, PeerTrustState.PeerTrustEnum paramPeerTrustEnum, com.viber.voip.messages.conversation.chatinfo.presentation.n paramn)
  {
    boolean bool;
    if (!paramn.e())
    {
      bool = true;
      if (!paramn.e())
        break label79;
    }
    label79: for (String str = paramResources.getString(R.string.encrypted_chat_label); ; str = paramResources.getString(parama.b()))
    {
      int i = parama.c();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramConversationItemLoaderEntity.getParticipantName();
      return new com.viber.voip.messages.conversation.chatinfo.d.o(bool, str, paramResources.getString(i, arrayOfObject), parama.d(), paramPeerTrustEnum);
      bool = false;
      break;
    }
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d a(Resources paramResources, boolean paramBoolean)
  {
    if (paramBoolean)
      return new p(paramResources.getString(R.string.verified_community), 0);
    int i = R.dimen.chat_info_top_padding;
    return new p(paramResources.getString(R.string.verified_community), paramResources.getDimensionPixelSize(i));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool1 = paramConversationItemLoaderEntity.isCommunityBlocked();
    boolean bool2;
    boolean bool3;
    Uri localUri;
    boolean bool4;
    if ((bool1) || (!cd.f(paramConversationItemLoaderEntity.getGroupRole(), paramConversationItemLoaderEntity.getConversationType())))
    {
      bool2 = true;
      bool3 = paramConversationItemLoaderEntity.isBroadcastListType();
      localUri = paramConversationItemLoaderEntity.getIconUri();
      if ((!paramConversationItemLoaderEntity.isCommunityType()) || (!paramConversationItemLoaderEntity.isAdministratorRole()) || (bool1) || (localUri != null))
        localUri = paramConversationItemLoaderEntity.getIconUriOrDefault();
      if ((bool1) || (!paramConversationItemLoaderEntity.canChangeGroupName()))
        break label118;
      bool4 = true;
      label79: if ((bool1) || (!paramConversationItemLoaderEntity.canChangeGroupIcon()))
        break label124;
    }
    label118: label124: for (boolean bool5 = true; ; bool5 = false)
    {
      return new h(dg.b(paramConversationItemLoaderEntity), bool2, bool4, bool3, bool5, localUri);
      bool2 = false;
      break;
      bool4 = false;
      break label79;
    }
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d a(com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb)
  {
    return new l(paramb);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d b(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.c(8, paramResources.getString(R.string.member_privileges_title));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d b(Resources paramResources, int paramInt)
  {
    int i = R.string.recipients_count;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.toString(paramInt);
    return new j(2, paramResources.getString(i, arrayOfObject), null, R.attr.chatInfoTextMembersHeader, paramResources.getDimension(R.dimen.group_info_hider_text_size_normal), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom_small));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d b(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool1 = paramConversationItemLoaderEntity.isMuteConversation();
    if (!paramConversationItemLoaderEntity.isSnoozedConversation());
    for (boolean bool2 = true; ; bool2 = false)
      return new m.a().a(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.j).a(1).a(bool1).b(bool2).a("mute_pref_").b(paramResources.getString(R.string.chat_info_mute_title)).c(paramResources.getString(R.string.conversation_info_pref_mute_group_description)).c(true).a();
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d b(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt)
  {
    if ((paramConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity))
      paramInt += ((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity).getWatchersCount();
    if ((cd.f(paramConversationItemLoaderEntity.getGroupRole())) && (!paramConversationItemLoaderEntity.isDisabledConversation()))
      paramInt--;
    int i = R.string.members_count;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.toString(paramInt);
    String str1 = paramResources.getString(i, arrayOfObject);
    if ((cd.c(paramConversationItemLoaderEntity.getGroupRole())) && (!paramConversationItemLoaderEntity.isCommunityBlocked()));
    for (String str2 = paramResources.getString(R.string.public_group_info_add_admins); ; str2 = "")
      return new j(2, str1, str2, R.attr.chatInfoTextMembersHeader, paramResources.getDimension(R.dimen.group_info_hider_text_size_normal), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom_small));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d c(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.c(3, paramResources.getString(R.string.banned_users_title));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d c(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool = paramConversationItemLoaderEntity.isSmartNotificationOn();
    m.a locala = new m.a().a(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.j).a(4).a(bool).b(true).a("notification_pref_").b(paramResources.getString(R.string.conversation_info_pref_notify_title));
    if (bool);
    for (String str = paramResources.getString(R.string.conversation_info_pref_notify_sum_on); ; str = paramResources.getString(R.string.conversation_info_pref_notify_sum_off))
      return locala.c(str).a();
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d d(Resources paramResources)
  {
    return new com.viber.voip.messages.conversation.chatinfo.d.o(false, paramResources.getString(R.string.encrypted_group_chat_label), paramResources.getString(R.string.secure_messages_tooltip_unverified_group), R.drawable.ic_secure_chat_unverified_normal, PeerTrustState.PeerTrustEnum.SECURE_TRUSTED);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d d(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool = paramConversationItemLoaderEntity.isShareLocation();
    return new m.a().a(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.j).a(3).a(bool).b(true).a("location_pref_").b(paramResources.getString(R.string.conversation_info_pref_attach_location_title)).c(paramResources.getString(R.string.conversation_info_pref_attach_location_summary)).a();
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d e(Resources paramResources)
  {
    String str1 = paramResources.getString(R.string.share_group_link);
    String str2 = paramResources.getString(R.string.link_explanation_text);
    return new i(1, R.drawable.share_link_icon, str1, str2);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d e(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool = paramConversationItemLoaderEntity.isSnoozedConversation();
    return new m.a().a(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.j).a(2).a(bool).b(true).a("snooze_pref_").b(paramResources.getString(R.string.snooze_community_pref_title)).c(paramResources.getString(R.string.snooze_community_pref_body)).a();
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d f(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.a(6, paramResources.getString(R.string.conversation_info_switch_to_secret_chat));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d f(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    boolean bool = e.a((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity);
    return new m.a().a(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.k).a(5).a(bool).c(true).b(true).a("m2m_one_on_one_messages_pref_").b(paramResources.getString(R.string.community_receive_one_on_one_messages_title)).c(paramResources.getString(R.string.community_receive_one_on_one_messages_description)).a();
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d g(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.a(7, paramResources.getString(R.string.conversation_info_switch_to_regular_chat));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d g(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    String str = paramConversationItemLoaderEntity.getBackgroundPortrait();
    if (m.d(paramConversationItemLoaderEntity.getBackgroundPortrait()))
      str = new com.viber.voip.backgrounds.o().a(false).toString();
    if (da.a(str));
    for (int i = R.string.conversation_info_bg_not_assigned; ; i = R.string.conversation_info_bg_assigned)
      return new com.viber.voip.messages.conversation.chatinfo.d.c(paramResources.getString(R.string.conversation_info_pref_bg_title), paramResources.getString(i), str);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d h(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.a(14, paramResources.getString(R.string.conversation_info_groups_in_common));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d h(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (g.a(Member.from(paramConversationItemLoaderEntity)));
    for (String str = paramResources.getString(R.string.unblock_this_contact); ; str = paramResources.getString(R.string.block_this_contact))
      return com.viber.voip.messages.conversation.chatinfo.d.n.a(4, str);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d i(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.a(5, paramResources.getString(R.string.communities_faq));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d i(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity.isHiddenConversation());
    for (String str = paramResources.getString(R.string.conversation_info_unhide_btn_text); ; str = paramResources.getString(R.string.conversation_info_hide_btn_text))
      return com.viber.voip.messages.conversation.chatinfo.d.n.a(2, str);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d j(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.a(13, paramResources.getString(R.string.menu_report_community));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d j(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int i;
    if ((paramConversationItemLoaderEntity.isGroupType()) || (paramConversationItemLoaderEntity.isCommunityType()))
      i = R.string.conversation_info_leave_btn_text;
    while (true)
    {
      return com.viber.voip.messages.conversation.chatinfo.d.n.b(1, paramResources.getString(i));
      if (paramConversationItemLoaderEntity.isBroadcastListType())
        i = R.string.delete_broadcast_list;
      else
        i = R.string.btn_delet_this_chat;
    }
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d k(Resources paramResources)
  {
    return new j(1, paramResources.getString(R.string.list_admins), null, R.attr.chatInfoTextMembersHeader, paramResources.getDimension(R.dimen.group_info_hider_text_size_normal), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom_small));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d k(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (cd.f(paramConversationItemLoaderEntity.getGroupRole()));
    for (int i = R.string.public_group_info_add_me_as_admin; ; i = R.string.add_me_as_superadmin)
      return new j(6, paramResources.getString(i), null, R.attr.textLinkColor, paramResources.getDimension(R.dimen.group_info_hider_text_size_big), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d l(Resources paramResources)
  {
    return new j(6, paramResources.getString(R.string.public_group_info_add_me_as_admin), null, R.attr.textLinkColor, paramResources.getDimension(R.dimen.group_info_hider_text_size_big), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d l(Resources paramResources, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    int i = R.string.anonymous_chat_blurb_description;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = dg.a(paramConversationItemLoaderEntity);
    return com.viber.voip.messages.conversation.chatinfo.d.n.d(9, paramResources.getString(i, arrayOfObject));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d m(Resources paramResources)
  {
    return new i(3, R.drawable.share_link_icon, paramResources.getString(R.string.join_community_link_msg_title), paramResources.getString(R.string.join_community_link_msg));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d n(Resources paramResources)
  {
    return new i(4, R.drawable.add_participants_button, paramResources.getString(R.string.chat_info_add_members_header), null);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d o(Resources paramResources)
  {
    return new j(3, paramResources.getString(R.string.show_all), null, R.attr.textLinkColor, paramResources.getDimension(R.dimen.group_info_hider_text_size_big), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d p(Resources paramResources)
  {
    return new j(4, paramResources.getString(R.string.public_group_info_show_all_admins), null, R.attr.textLinkColor, paramResources.getDimension(R.dimen.group_info_hider_text_size_big), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d q(Resources paramResources)
  {
    return new j(5, paramResources.getString(R.string.public_group_info_show_all_participants), null, R.attr.textLinkColor, paramResources.getDimension(R.dimen.group_info_hider_text_size_big), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d r(Resources paramResources)
  {
    return new j(5, paramResources.getString(R.string.show_all_recipients), null, R.attr.textLinkColor, paramResources.getDimension(R.dimen.group_info_hider_text_size_big), paramResources.getDimensionPixelSize(R.dimen.public_group_header_item_add_me_as_admin_bottom));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d s(Resources paramResources)
  {
    return new com.viber.voip.messages.conversation.chatinfo.d.b(2, paramResources.getString(R.string.add_participants), R.drawable.add_participants_button, R.attr.chatInfoIconTint);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d t(Resources paramResources)
  {
    return new com.viber.voip.messages.conversation.chatinfo.d.b(2, paramResources.getString(R.string.add_recipients), R.drawable.add_participants_button, R.attr.chatInfoIconTint);
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d u(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.b(11, paramResources.getString(R.string.public_account_one_on_one_subscribe));
  }

  static com.viber.voip.messages.conversation.chatinfo.d.d v(Resources paramResources)
  {
    return com.viber.voip.messages.conversation.chatinfo.d.n.b(12, paramResources.getString(R.string.public_account_one_on_one_unsubscribe));
  }

  static enum a
  {
    private final PeerTrustState.PeerTrustEnum e;
    private final int f;
    private final int g;
    private final int h;

    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }

    private a(PeerTrustState.PeerTrustEnum paramPeerTrustEnum, int paramInt1, int paramInt2, int paramInt3)
    {
      this.e = paramPeerTrustEnum;
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = paramInt3;
    }

    static a a(PeerTrustState.PeerTrustEnum paramPeerTrustEnum)
    {
      for (a locala : values())
        if (paramPeerTrustEnum == locala.a())
          return locala;
      return d;
    }

    PeerTrustState.PeerTrustEnum a()
    {
      return this.e;
    }

    int b()
    {
      return this.f;
    }

    int c()
    {
      return this.g;
    }

    int d()
    {
      return this.h;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.a.c
 * JD-Core Version:    0.6.2
 */