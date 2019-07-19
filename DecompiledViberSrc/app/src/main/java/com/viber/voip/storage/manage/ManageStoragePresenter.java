package com.viber.voip.storage.manage;

import android.arch.lifecycle.h;
import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaStorageInteractor;
import com.viber.voip.storage.repository.MediaStorageInteractor.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ManageStoragePresenter extends ManageStoragePresenterBase
{
  private static final Logger b = ViberEnv.getLogger();
  private static final Comparator<ConversationWithMediaSizesEntity> c = g.a;
  private final MediaStorageInteractor d;
  private final Handler e;
  private final LongSparseArray<ConversationWithMediaSizesEntity> f = new LongSparseArray();
  private final List<ConversationWithMediaSizesEntity> g = new ArrayList();
  private boolean h = false;
  private final Runnable i = new f(this);
  private final MediaStorageInteractor.a j = new MediaStorageInteractor.a()
  {
    public void a()
    {
      if (ManageStoragePresenter.a(ManageStoragePresenter.this).size() == 0)
        ((i)ManageStoragePresenter.e(ManageStoragePresenter.this)).b();
      while (true)
      {
        ManageStoragePresenter.h(ManageStoragePresenter.this);
        return;
        ((i)ManageStoragePresenter.f(ManageStoragePresenter.this)).a();
        ManageStoragePresenter.g(ManageStoragePresenter.this);
      }
    }

    public void a(ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity)
    {
      ManageStoragePresenter.c(ManageStoragePresenter.this).add(paramAnonymousConversationWithMediaSizesEntity);
      ManageStoragePresenter.d(ManageStoragePresenter.this);
    }

    public void a(List<ConversationWithMediaSizesEntity> paramAnonymousList)
    {
      ManageStoragePresenter.a(ManageStoragePresenter.this).clear();
      Iterator localIterator = paramAnonymousList.iterator();
      while (localIterator.hasNext())
      {
        ConversationWithMediaSizesEntity localConversationWithMediaSizesEntity = (ConversationWithMediaSizesEntity)localIterator.next();
        if (localConversationWithMediaSizesEntity.hasCalculatedSummaryMediaSize())
          ManageStoragePresenter.a(ManageStoragePresenter.this).append(localConversationWithMediaSizesEntity.getId(), localConversationWithMediaSizesEntity);
      }
      ManageStoragePresenter.b(ManageStoragePresenter.this);
    }
  };

  ManageStoragePresenter(MediaStorageInteractor paramMediaStorageInteractor, Handler paramHandler)
  {
    this.d = paramMediaStorageInteractor;
    this.e = paramHandler;
  }

  private void c()
  {
    if (this.h)
    {
      d();
      this.e.postDelayed(this.i, 300L);
    }
  }

  private void d()
  {
    if (!this.g.isEmpty())
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        ConversationWithMediaSizesEntity localConversationWithMediaSizesEntity = (ConversationWithMediaSizesEntity)localIterator.next();
        this.f.append(localConversationWithMediaSizesEntity.getId(), localConversationWithMediaSizesEntity);
      }
      this.g.clear();
      e();
    }
  }

  private void e()
  {
    ArrayList localArrayList = new ArrayList(this.f.size());
    int k = 0;
    int m = this.f.size();
    while (k < m)
    {
      localArrayList.add(this.f.valueAt(k));
      k++;
    }
    Collections.sort(localArrayList, c);
    ((i)this.mView).a(localArrayList);
  }

  private void f()
  {
    if (!this.h)
    {
      this.h = true;
      this.i.run();
    }
  }

  private void g()
  {
    this.h = false;
    this.e.removeCallbacks(this.i);
  }

  protected ManageStorageState a()
  {
    return new ManageStorageState(this.d.a(), this.a);
  }

  protected void a(ManageStorageState paramManageStorageState)
  {
    super.a(paramManageStorageState);
    if (paramManageStorageState != null)
      this.d.a(paramManageStorageState.getInteractorSaveState());
  }

  public void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity)
  {
    ((i)this.mView).a(paramConversationWithMediaSizesEntity);
  }

  public void a(String paramString)
  {
    super.a(paramString);
    this.d.a(paramString);
  }

  public void onCreate(h paramh)
  {
    super.onCreate(paramh);
    this.d.b();
  }

  public void onDestroy(h paramh)
  {
    this.d.e();
    super.onDestroy(paramh);
  }

  public void onPause(h paramh)
  {
    super.onPause(paramh);
    this.d.d();
    g();
  }

  public void onResume(h paramh)
  {
    super.onResume(paramh);
    this.d.a(this.j);
    d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.ManageStoragePresenter
 * JD-Core Version:    0.6.2
 */