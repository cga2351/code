package com.viber.voip.messages.conversation.publicaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.viber.voip.R.id;
import com.viber.voip.messages.controller.ai.n;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.k;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.cj;
import dagger.a;
import java.util.ArrayList;
import java.util.List;

public class TabletPublicGroupConversationFragment extends PublicGroupConversationFragment
  implements View.OnClickListener
{
  private View a;
  private int b = 0;
  private b c;

  private void c(int paramInt)
  {
    if (this.a != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      if (localLayoutParams.width != paramInt)
      {
        localLayoutParams.width = paramInt;
        this.a.setLayoutParams(localLayoutParams);
      }
    }
  }

  public void a()
  {
    ((k)aj().get()).h().a(new ai.n()
    {
      public void a(String paramAnonymousString, final List<PublicAccount> paramAnonymousList)
      {
        TabletPublicGroupConversationFragment.a(TabletPublicGroupConversationFragment.this, new Runnable()
        {
          public void run()
          {
            TabletPublicGroupConversationFragment.this.a(new ArrayList(paramAnonymousList));
          }
        });
      }
    });
  }

  public void a(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      c(this.b);
    }
  }

  protected void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    super.a(paramPublicGroupConversationItemLoaderEntity);
    a(false);
  }

  protected void a(ArrayList<PublicAccount> paramArrayList)
  {
    if ((paramArrayList.size() == 0) && (!cj.b(getActivity())))
    {
      this.c.b();
      return;
    }
    this.c.a(paramArrayList);
  }

  public void a(boolean paramBoolean)
  {
    int i = 8;
    int j;
    View localView2;
    if (this.a != null)
    {
      View localView1 = this.a;
      if (!paramBoolean)
        break label51;
      j = 0;
      localView1.setVisibility(j);
      localView2 = getView().findViewById(R.id.conversation_top);
      if (!paramBoolean)
        break label57;
    }
    while (true)
    {
      localView2.setVisibility(i);
      return;
      label51: j = i;
      break;
      label57: i = 0;
    }
  }

  public void b()
  {
    if (this.c == null)
      this.c = new p();
    if (!this.c.e())
    {
      ((ViewStub)getView().findViewById(R.id.empty_stub)).inflate();
      this.c.a(getView(), this, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TabletPublicGroupConversationFragment.this.startActivity(ViberActionRunner.aq.a(TabletPublicGroupConversationFragment.this.getActivity(), false, ((PublicAccount)paramAnonymousView.getTag()).hasPublicChat(), new PublicGroupConversationData((PublicAccount)paramAnonymousView.getTag())));
        }
      });
    }
    a(true);
    if (cj.b(getActivity()))
    {
      a();
      return;
    }
    this.c.b();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == R.id.empty_button) || (i == R.id.emptyDescription))
    {
      if (this.c.c())
        b();
    }
    else
      return;
    ViberActionRunner.aq.a(getContext());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = localView.findViewById(R.id.empty_container);
    if (this.b != 0)
      c(this.b);
    this.c = new p();
    return localView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.TabletPublicGroupConversationFragment
 * JD-Core Version:    0.6.2
 */