package com.viber.voip.messages.conversation.chatinfo.presentation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m.g;
import com.viber.common.dialogs.z;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.ui.list.t;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.chatinfo.d.h;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.i;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.j;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.b.q;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.bg;
import com.viber.voip.permissions.e;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.report.community.CommunityReportPresenter;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.style.InternalURLSpan;
import com.viber.voip.ui.style.InternalURLSpan.a;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.ay;
import com.viber.voip.util.ay.a;
import com.viber.voip.util.bi;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import javax.inject.Inject;

public class ChatInfoGroupFragment extends o
  implements m.g, j
{
  private static final Logger R = ViberEnv.getLogger();

  @Inject
  com.viber.voip.analytics.story.g.a O;

  @Inject
  com.viber.voip.report.a.a.a P;

  @Inject
  com.viber.voip.report.community.a Q;
  private Uri S;
  private long T;
  private String U;
  private String V;
  private PublicAccount W;
  private c X;
  private bg Y;
  private final com.viber.common.permission.b Z;
  private final InternalURLSpan.a aa;

  public ChatInfoGroupFragment()
  {
    android.util.Pair[] arrayOfPair = new android.util.Pair[5];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(9);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(127);
    arrayOfPair[2] = com.viber.voip.permissions.m.a(63);
    arrayOfPair[3] = com.viber.voip.permissions.m.a(48);
    arrayOfPair[4] = com.viber.voip.permissions.m.a(96);
    this.Z = new e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 9:
        case 127:
        case 48:
        case 63:
        case 96:
        }
        do
        {
          return;
          ChatInfoGroupFragment.a(ChatInfoGroupFragment.this, ay.a(ChatInfoGroupFragment.this, 2006));
          return;
          ay.b(ChatInfoGroupFragment.this, 2006);
          return;
        }
        while (ChatInfoGroupFragment.a(ChatInfoGroupFragment.this) == null);
        ChatInfoGroupFragment.a(ChatInfoGroupFragment.this).a(paramAnonymousInt, paramAnonymousArrayOfString, paramAnonymousObject);
      }
    };
    this.aa = new u(this);
  }

  private int Q()
  {
    if (this.G == null);
    do
    {
      return 0;
      if (this.G.isInBusinessInbox())
        return 2;
      if (this.G.isSecret())
        return 1;
    }
    while (!this.G.isVlnConversation());
    return 3;
  }

  private void R()
  {
    if ((this.G != null) && (this.G.isGroupBehavior()) && ((getActivity() instanceof ChatInfoActivity)))
      if (!(this.G instanceof PublicGroupConversationItemLoaderEntity))
        break label65;
    label65: for (String str = da.b(this.x, (PublicGroupConversationItemLoaderEntity)this.G); ; str = da.a(this.x))
    {
      dj.b((AppCompatActivity)getActivity(), str);
      return;
    }
  }

  private PublicAccount S()
  {
    if ((this.G instanceof PublicGroupConversationItemLoaderEntity))
      return new PublicAccount((PublicGroupConversationItemLoaderEntity)this.G);
    return null;
  }

  private void T()
  {
    if (this.X.a(com.viber.voip.permissions.n.c))
    {
      this.V = "Camera";
      this.S = ay.a(this, 2006);
      return;
    }
    this.X.a(this, 9, com.viber.voip.permissions.n.c);
  }

  private void U()
  {
    if (this.X.a(com.viber.voip.permissions.n.m))
    {
      this.V = "Gallery";
      ay.b(this, 2006);
      return;
    }
    this.X.a(this, 127, com.viber.voip.permissions.n.m);
  }

  private void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.G.isCommunityType()) && (paramLong == this.G.getId()))
    {
      int i = ((PublicGroupConversationItemLoaderEntity)this.G).getWatchersCount();
      boolean bool1 = this.G.isCommunityBlocked();
      boolean bool2 = bi.a(this.G);
      if ((paramInt != i) || (paramBoolean1 != bool1) || (paramBoolean2 != bool2))
      {
        if ((paramBoolean1 != bool1) && (bool1))
        {
          z.b(this, DialogCode.DC19);
          z.b(this, DialogCode.D509);
          z.b(this, DialogCode.D2002a);
        }
        d(this.G);
      }
    }
  }

  private void a(Intent paramIntent)
  {
    ay.a locala = ay.a(getActivity(), paramIntent, this.S);
    Intent localIntent = ay.a(getActivity(), locala, 720, 720);
    if (localIntent != null)
      startActivityForResult(localIntent, 2007);
  }

  private void a(Uri paramUri, long paramLong, PublicAccount paramPublicAccount)
  {
    int i = 1;
    a(i);
    a(paramUri);
    com.viber.voip.analytics.story.g.a locala;
    String str1;
    if (this.F == i)
    {
      if (paramUri == null)
        break label124;
      locala = this.O;
      str1 = ae.b();
      if (this.G == null)
        break label130;
    }
    int k;
    label130: for (String str2 = this.G.getGroupName(); ; str2 = this.U)
    {
      locala.a(str1, 0, paramLong, str2, i, "Image", this.V);
      this.V = null;
      if (paramLong > 0L)
      {
        k = this.f.getPhoneController().generateSequence();
        if (paramPublicAccount != null)
          break label139;
        this.b.d().a(k, paramLong, paramUri);
      }
      return;
      label124: int j = 0;
      break;
    }
    label139: paramPublicAccount.setIcon(paramUri);
    this.b.d().a(k, 2, paramPublicAccount);
  }

  private void b(Intent paramIntent)
  {
    Uri localUri = Uri.parse(paramIntent.getAction());
    if (this.G != null)
    {
      a(localUri, this.G.getGroupId(), S());
      return;
    }
    a(localUri, this.T, this.W);
  }

  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      InternalURLSpan.addClickListener(this.aa);
      return;
    }
    InternalURLSpan.removeClickListener(this.aa);
  }

  public void K()
  {
    this.z.k();
  }

  public void L()
  {
    this.v.a();
  }

  protected com.viber.voip.messages.conversation.chatinfo.presentation.a.a a(Context paramContext)
  {
    return new com.viber.voip.messages.conversation.chatinfo.presentation.a.a(getLayoutInflater(), new i(paramContext, this, this.H), this.w);
  }

  public void a(int paramInt)
  {
    if (cd.c(paramInt))
    {
      A();
      return;
    }
    this.y.k();
  }

  protected void a(Uri paramUri)
  {
    android.support.v4.util.Pair localPair = this.L.a(com.viber.voip.messages.conversation.chatinfo.presentation.a.d.c, 0);
    if ((localPair != null) && (localPair.second != null) && (localPair.first != null))
    {
      ((h)localPair.second).a(paramUri);
      this.L.notifyItemChanged(((Integer)localPair.first).intValue());
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    boolean bool1 = true;
    long l;
    int i;
    label40: boolean bool2;
    if (this.G != null)
    {
      l = this.G.getId();
      if (!(this.G instanceof PublicGroupConversationItemLoaderEntity))
        break label101;
      i = ((PublicGroupConversationItemLoaderEntity)this.G).getWatchersCount();
      if ((this.G == null) || (!this.G.isCommunityBlocked()))
        break label107;
      bool2 = bool1;
      label60: if ((this.G == null) || (!bi.a(this.G)))
        break label113;
    }
    while (true)
    {
      super.a(paramConversationItemLoaderEntity, paramBoolean);
      a(l, i, bool2, bool1);
      return;
      l = 0L;
      break;
      label101: i = 0;
      break label40;
      label107: bool2 = false;
      break label60;
      label113: bool1 = false;
    }
  }

  public void b(long paramLong)
  {
    this.Q.a(paramLong);
  }

  public void b(String paramString)
  {
    if (!n())
      return;
    this.y.a(paramString);
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    super.createViewPresenters(paramView, paramBundle);
    CommunityReportPresenter localCommunityReportPresenter = new CommunityReportPresenter(this.P, this.Q, this.v);
    addMvpView(new com.viber.voip.report.community.d(this, localCommunityReportPresenter, paramView), localCommunityReportPresenter, paramBundle);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!isAdded())
    {
      this.K = new o.a();
      this.K.a = paramInt1;
      this.K.b = paramInt2;
      this.K.c = paramIntent;
      return;
    }
    if (paramInt2 == -1)
      switch (paramInt1)
      {
      default:
      case 1233:
      case 2002:
      case 2003:
      case 2006:
      case 2007:
      }
    while (true)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      int i = paramIntent.getIntExtra("action", 0);
      if ((i > 0) && (cj.a(true)))
        switch (i)
        {
        default:
          break;
        case 102:
          T();
          break;
        case 104:
          if (this.G.isCommunityBlocked())
          {
            com.viber.voip.ui.dialogs.d.r().b(this);
          }
          else
          {
            this.V = "Image Removed";
            a(null, this.G.getGroupId(), S());
          }
          break;
        case 103:
          U();
          continue;
          if (paramIntent.getData() != null)
          {
            Uri localUri = paramIntent.getData();
            if (!localUri.equals(this.J))
              at.d(getActivity(), this.J);
            startActivityForResult(com.viber.voip.messages.extras.image.b.a(getActivity(), new com.viber.voip.backgrounds.n(localUri)), 2005);
            continue;
            if (this.J != null)
            {
              startActivityForResult(com.viber.voip.messages.extras.image.b.a(getActivity(), new com.viber.voip.backgrounds.n(this.J)), 2005);
              continue;
              a(paramIntent);
              this.S = null;
              continue;
              if (this.G.isCommunityBlocked())
                com.viber.voip.ui.dialogs.d.r().b(this);
              else
                b(paramIntent);
            }
          }
          break;
        }
    }
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.X = c.a(paramContext);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.Y != null)
      return this.Y.a(paramMenuItem.getItemId());
    return super.onContextItemSelected(paramMenuItem);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Uri))
    {
      FragmentActivity localFragmentActivity = requireActivity();
      int i = Q();
      Uri localUri = (Uri)localObject;
      if ((this.G != null) && (this.G.isSecret()));
      for (boolean bool = true; ; bool = false)
      {
        this.Y = new bg(localFragmentActivity, paramContextMenu, i, localUri, bool, null, 63, 48, 96, R.id.menu_chat_info_empty, R.id.menu_chat_info_viber_call, R.id.menu_chat_info_message_send, R.id.menu_chat_info_viber_out_call, R.id.menu_chat_info_invite_viber, R.id.menu_chat_info_add_contact);
        paramView.setTag(null);
        return;
      }
    }
    this.Y = null;
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (paramBundle != null)
    {
      this.S = ((Uri)paramBundle.getParcelable("com.viber.voip.ConversationInfo#TempIcon"));
      this.T = paramBundle.getLong("com.viber.voip.ConversationInfo#GroupId");
      this.U = paramBundle.getString("com.viber.voip.ConversationInfo#GroupName");
      this.W = ((PublicAccount)paramBundle.getParcelable("com.viber.voip.ConversationInfo#PublicAccount"));
      this.V = paramBundle.getString("com.viber.voip.ConversationInfo#GroupIconSource");
    }
    return localView;
  }

  public void onDialogListAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.DC19))
    {
      if (paramInt != 0)
        break label25;
      T();
    }
    while (true)
    {
      super.onDialogAction(paramm, paramInt);
      return;
      label25: if (1 == paramInt)
        U();
      else if (2 == paramInt)
        if (this.G.isCommunityBlocked())
          com.viber.voip.ui.dialogs.d.r().b(this);
        else
          a(null, this.G.getGroupId(), S());
    }
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    if (!this.mIsTablet)
      k(paramBoolean);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    super.onLoadFinished(paramd, paramBoolean);
    R();
  }

  public void onPause()
  {
    super.onPause();
    if (this.mIsTablet)
      k(false);
  }

  public void onResume()
  {
    super.onResume();
    if (this.mIsTablet)
      k(true);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("com.viber.voip.ConversationInfo#TempIcon", this.S);
    paramBundle.putString("com.viber.voip.ConversationInfo#GroupIconSource", this.V);
    if (this.G != null)
    {
      paramBundle.putLong("com.viber.voip.ConversationInfo#GroupId", this.G.getGroupId());
      paramBundle.putParcelable("com.viber.voip.ConversationInfo#PublicAccount", S());
      paramBundle.putString("com.viber.voip.ConversationInfo#GroupName", this.G.getGroupName());
    }
  }

  public void onStart()
  {
    super.onStart();
    this.X.a(this.Z);
  }

  public void onStop()
  {
    super.onStop();
    this.X.b(this.Z);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.ChatInfoGroupFragment
 * JD-Core Version:    0.6.2
 */