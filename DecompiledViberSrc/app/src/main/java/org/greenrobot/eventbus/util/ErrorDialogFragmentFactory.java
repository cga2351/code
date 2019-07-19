package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Bundle;

public abstract class ErrorDialogFragmentFactory<T>
{
  protected final ErrorDialogConfig config;

  protected ErrorDialogFragmentFactory(ErrorDialogConfig paramErrorDialogConfig)
  {
    this.config = paramErrorDialogConfig;
  }

  protected abstract T createErrorFragment(ThrowableFailureEvent paramThrowableFailureEvent, Bundle paramBundle);

  protected String getMessageFor(ThrowableFailureEvent paramThrowableFailureEvent, Bundle paramBundle)
  {
    int i = this.config.getMessageIdForThrowable(paramThrowableFailureEvent.throwable);
    return this.config.resources.getString(i);
  }

  protected String getTitleFor(ThrowableFailureEvent paramThrowableFailureEvent, Bundle paramBundle)
  {
    return this.config.resources.getString(this.config.defaultTitleId);
  }

  protected T prepareErrorFragment(ThrowableFailureEvent paramThrowableFailureEvent, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramThrowableFailureEvent.isSuppressErrorUi())
      return null;
    if (paramBundle != null);
    for (Bundle localBundle = (Bundle)paramBundle.clone(); ; localBundle = new Bundle())
    {
      if (!localBundle.containsKey("de.greenrobot.eventbus.errordialog.title"))
        localBundle.putString("de.greenrobot.eventbus.errordialog.title", getTitleFor(paramThrowableFailureEvent, localBundle));
      if (!localBundle.containsKey("de.greenrobot.eventbus.errordialog.message"))
        localBundle.putString("de.greenrobot.eventbus.errordialog.message", getMessageFor(paramThrowableFailureEvent, localBundle));
      if (!localBundle.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog"))
        localBundle.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", paramBoolean);
      if ((!localBundle.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close")) && (this.config.defaultEventTypeOnDialogClosed != null))
        localBundle.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.config.defaultEventTypeOnDialogClosed);
      if ((!localBundle.containsKey("de.greenrobot.eventbus.errordialog.icon_id")) && (this.config.defaultDialogIconId != 0))
        localBundle.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.config.defaultDialogIconId);
      return createErrorFragment(paramThrowableFailureEvent, localBundle);
    }
  }

  @TargetApi(11)
  public static class Honeycomb extends ErrorDialogFragmentFactory<android.app.Fragment>
  {
    public Honeycomb(ErrorDialogConfig paramErrorDialogConfig)
    {
      super();
    }

    protected android.app.Fragment createErrorFragment(ThrowableFailureEvent paramThrowableFailureEvent, Bundle paramBundle)
    {
      ErrorDialogFragments.Honeycomb localHoneycomb = new ErrorDialogFragments.Honeycomb();
      localHoneycomb.setArguments(paramBundle);
      return localHoneycomb;
    }
  }

  public static class Support extends ErrorDialogFragmentFactory<android.support.v4.app.Fragment>
  {
    public Support(ErrorDialogConfig paramErrorDialogConfig)
    {
      super();
    }

    protected android.support.v4.app.Fragment createErrorFragment(ThrowableFailureEvent paramThrowableFailureEvent, Bundle paramBundle)
    {
      ErrorDialogFragments.Support localSupport = new ErrorDialogFragments.Support();
      localSupport.setArguments(paramBundle);
      return localSupport;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
 * JD-Core Version:    0.6.2
 */