package com.viber.voip.storage.manage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.mvp.core.d;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.ac.a;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ProgressBar;
import java.util.ArrayList;

class k extends d<ManageStoragePresenterBase>
  implements i
{
  private final h a;
  private final Handler b;
  private final ProgressBar c;
  private final View d;
  private final RecyclerView e;
  private final b f;
  private MenuSearchMediator g;
  private String h = "";

  k(ManageStoragePresenterBase paramManageStoragePresenterBase, h paramh, Handler paramHandler, View paramView)
  {
    super(paramManageStoragePresenterBase, paramView);
    this.a = paramh;
    this.b = paramHandler;
    this.c = ((ProgressBar)paramView.findViewById(R.id.loading_progress));
    this.d = paramView.findViewById(R.id.empty_text_message);
    this.e = ((RecyclerView)paramView.findViewById(R.id.conversation_list));
    Context localContext = paramView.getContext();
    ManageStoragePresenterBase localManageStoragePresenterBase = (ManageStoragePresenterBase)this.mPresenter;
    localManageStoragePresenterBase.getClass();
    this.f = new b(localContext, l.a(localManageStoragePresenterBase));
    this.e.setAdapter(this.f);
    this.e.setHasFixedSize(true);
    this.g = new MenuSearchMediator(new ac.a()
    {
      public boolean onQueryTextChange(String paramAnonymousString)
      {
        ((ManageStoragePresenterBase)k.a(k.this)).a(paramAnonymousString);
        return true;
      }

      public boolean onQueryTextSubmit(String paramAnonymousString)
      {
        return false;
      }

      public boolean onSearchViewShow(boolean paramAnonymousBoolean)
      {
        return true;
      }
    });
  }

  public void a()
  {
    dj.b(this.c, false);
    this.f.notifyDataSetChanged();
  }

  public void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity)
  {
    this.a.a(paramConversationWithMediaSizesEntity);
  }

  public void a(String paramString)
  {
    this.h = paramString;
  }

  public void a(ArrayList<ConversationWithMediaSizesEntity> paramArrayList)
  {
    dj.b(this.d, false);
    dj.b(this.e, true);
    this.f.a(paramArrayList);
    this.f.notifyDataSetChanged();
  }

  public void b()
  {
    dj.b(this.c, false);
    dj.b(this.e, false);
    dj.b(this.d, true);
  }

  public boolean onBackPressed()
  {
    if (this.g.e())
    {
      this.g.f();
      return true;
    }
    return false;
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.manage_storage, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(R.id.menu_search);
    ((SearchView)localMenuItem.getActionView()).setMaxWidth(this.mRootView.getResources().getDimensionPixelOffset(R.dimen.search_view_max_width));
    this.b.post(new m(this, localMenuItem));
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.k
 * JD-Core Version:    0.6.2
 */