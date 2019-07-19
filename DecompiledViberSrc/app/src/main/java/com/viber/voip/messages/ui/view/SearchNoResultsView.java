package com.viber.voip.messages.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.viber.voip.R.string;
import com.viber.voip.ui.ViberTextView;

public class SearchNoResultsView extends ViberTextView
{
  public SearchNoResultsView(Context paramContext)
  {
    super(paramContext);
  }

  public SearchNoResultsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SearchNoResultsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void setQueryText(String paramString)
  {
    setText(getContext().getString(R.string.search_no_results_label, new Object[] { paramString }));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.SearchNoResultsView
 * JD-Core Version:    0.6.2
 */