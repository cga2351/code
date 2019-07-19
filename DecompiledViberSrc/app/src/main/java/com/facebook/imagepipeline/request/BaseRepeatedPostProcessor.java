package com.facebook.imagepipeline.request;

public abstract class BaseRepeatedPostProcessor extends BasePostprocessor
  implements RepeatedPostprocessor
{
  private RepeatedPostprocessorRunner mCallback;

  private RepeatedPostprocessorRunner getCallback()
  {
    try
    {
      RepeatedPostprocessorRunner localRepeatedPostprocessorRunner = this.mCallback;
      return localRepeatedPostprocessorRunner;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setCallback(RepeatedPostprocessorRunner paramRepeatedPostprocessorRunner)
  {
    try
    {
      this.mCallback = paramRepeatedPostprocessorRunner;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void update()
  {
    RepeatedPostprocessorRunner localRepeatedPostprocessorRunner = getCallback();
    if (localRepeatedPostprocessorRunner != null)
      localRepeatedPostprocessorRunner.update();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.request.BaseRepeatedPostProcessor
 * JD-Core Version:    0.6.2
 */