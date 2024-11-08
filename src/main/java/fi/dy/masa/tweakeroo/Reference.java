package fi.dy.masa.tweakeroo;

import net.minecraft.MinecraftVersion;

import fi.dy.masa.malilib.util.StringUtils;

public class Reference
{
    public static final String ID = "tweakeroo";
    public static final String MOD_ID = "tweakerge";
    public static final String MOD_NAME = "Tweakerge";
    public static final String MOD_VERSION = StringUtils.getModVersionString(MOD_ID);
    public static final String MC_VERSION = MinecraftVersion.CURRENT.getName();
    public static final String MOD_TYPE = "neoforge";
    public static final String MOD_STRING = MOD_ID + "-" + MOD_TYPE + "-" + MC_VERSION + "-" + MOD_VERSION;
}
