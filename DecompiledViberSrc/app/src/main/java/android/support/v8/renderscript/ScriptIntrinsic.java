package android.support.v8.renderscript;

public abstract class ScriptIntrinsic extends Script
{
  ScriptIntrinsic(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
    if (paramLong == 0L)
      throw new RSRuntimeException("Loading of ScriptIntrinsic failed.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsic
 * JD-Core Version:    0.6.2
 */