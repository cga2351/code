package com.viber.voip.storage.overall;

import android.arch.lifecycle.h;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.storage.a.i;
import com.viber.voip.storage.a.i.a;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaFileType;
import com.viber.voip.storage.repository.MediaStorageInteractor;
import com.viber.voip.storage.repository.MediaStorageInteractor.a;
import com.viber.voip.storage.repository.p.a;
import java.util.Iterator;
import java.util.List;

class ManageOverallStoragePresenter extends BaseMvpPresenter<c, ManageOverallStorageState>
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private final MediaStorageInteractor c;
  private final i d;
  private final com.viber.voip.analytics.story.g.a e;
  private final LongSparseArray<ConversationWithMediaSizesEntity> f = new LongSparseArray();
  private long g = 0L;
  private boolean h;
  private final MediaStorageInteractor.a i = new MediaStorageInteractor.a()
  {
    private void b(ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity)
    {
      if (paramAnonymousConversationWithMediaSizesEntity.getSummaryMediaSizeBytes() > 0L)
      {
        ManageOverallStoragePresenter.a(ManageOverallStoragePresenter.this).put(paramAnonymousConversationWithMediaSizesEntity.getId(), paramAnonymousConversationWithMediaSizesEntity);
        return;
      }
      ManageOverallStoragePresenter.a(ManageOverallStoragePresenter.this).remove(paramAnonymousConversationWithMediaSizesEntity.getId());
    }

    public void a()
    {
      ManageOverallStoragePresenter.b(ManageOverallStoragePresenter.this);
      ManageOverallStoragePresenter.c(ManageOverallStoragePresenter.this);
      ((c)ManageOverallStoragePresenter.d(ManageOverallStoragePresenter.this)).a();
    }

    public void a(ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity)
    {
      b(paramAnonymousConversationWithMediaSizesEntity);
    }

    public void a(List<ConversationWithMediaSizesEntity> paramAnonymousList)
    {
      ManageOverallStoragePresenter.a(ManageOverallStoragePresenter.this).clear();
      Iterator localIterator = paramAnonymousList.iterator();
      while (localIterator.hasNext())
        b((ConversationWithMediaSizesEntity)localIterator.next());
    }
  };
  private final i.a j = new i.a()
  {
    public void a(int paramAnonymousInt)
    {
      ((c)ManageOverallStoragePresenter.e(ManageOverallStoragePresenter.this)).a(paramAnonymousInt);
    }

    public void a(p.a paramAnonymousa)
    {
      if (paramAnonymousa.a())
      {
        ManageOverallStoragePresenter.a(ManageOverallStoragePresenter.this, 0L);
        ManageOverallStoragePresenter.c(ManageOverallStoragePresenter.this);
      }
      while (true)
      {
        ManageOverallStoragePresenter.h(ManageOverallStoragePresenter.this).c();
        ((c)ManageOverallStoragePresenter.i(ManageOverallStoragePresenter.this)).c();
        ManageOverallStoragePresenter.a(ManageOverallStoragePresenter.this, false);
        return;
        ((c)ManageOverallStoragePresenter.f(ManageOverallStoragePresenter.this)).d();
        ManageOverallStoragePresenter.g(ManageOverallStoragePresenter.this).a();
      }
    }
  };

  ManageOverallStoragePresenter(int paramInt, MediaStorageInteractor paramMediaStorageInteractor, i parami, com.viber.voip.analytics.story.g.a parama)
  {
    this.b = paramInt;
    this.c = paramMediaStorageInteractor;
    this.d = parami;
    this.e = parama;
  }

  private void d()
  {
    long l = 0L;
    int k = this.f.size();
    for (int m = 0; m < k; m++)
      l += ((ConversationWithMediaSizesEntity)this.f.valueAt(m)).getSummaryMediaSizeBytes();
    this.g = l;
  }

  private void e()
  {
    ((c)this.mView).a(this.g);
  }

  private void f()
  {
    if (g())
    {
      this.h = true;
      ((c)this.mView).b();
      ConversationWithMediaSizesEntity[] arrayOfConversationWithMediaSizesEntity = new ConversationWithMediaSizesEntity[this.f.size()];
      int k = this.f.size();
      for (int m = 0; m < k; m++)
        arrayOfConversationWithMediaSizesEntity[m] = ((ConversationWithMediaSizesEntity)this.f.valueAt(m));
      com.viber.voip.storage.a.a locala = new com.viber.voip.storage.a.a(arrayOfConversationWithMediaSizesEntity, this.b, this.g, MediaFileType.getTypes());
      this.d.a(locala, this.j);
    }
  }

  private boolean g()
  {
    return (this.g > 0L) && (this.f.size() > 0);
  }

  protected ManageOverallStorageState a()
  {
    return new ManageOverallStorageState(this.c.a(), this.g, this.h);
  }

  protected void a(ManageOverallStorageState paramManageOverallStorageState)
  {
    super.onViewAttached(paramManageOverallStorageState);
    if (paramManageOverallStorageState != null)
    {
      this.c.a(paramManageOverallStorageState.getInteractorSaveState());
      this.g = paramManageOverallStorageState.getLocalDataSizeBytes();
      this.h = paramManageOverallStorageState.isClearMediaRunning();
      e();
      ((c)this.mView).a();
      return;
    }
    this.e.a(this.b);
  }

  public void b()
  {
    if (g())
      this.e.b();
    f();
  }

  public void c()
  {
    f();
  }

  public void onCreate(h paramh)
  {
    super.onCreate(paramh);
    this.c.b();
  }

  public void onDestroy(h paramh)
  {
    this.c.e();
    super.onDestroy(paramh);
  }

  public void onPause(h paramh)
  {
    super.onPause(paramh);
    this.c.d();
  }

  public void onResume(h paramh)
  {
    super.onResume(paramh);
    this.c.a(this.i);
    if (this.d.a(-1L, this.j))
    {
      if (!this.h)
        ((c)this.mView).b();
      return;
    }
    ((c)this.mView).c();
    this.h = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.overall.ManageOverallStoragePresenter
 * JD-Core Version:    0.6.2
 */