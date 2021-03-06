package io.izzel.taboolib.module.tellraw;

import io.izzel.taboolib.module.inject.TInject;
import io.izzel.taboolib.module.inject.TSchedule;
import io.izzel.taboolib.module.tellraw.internal.AbstractTellraw;
import org.bukkit.Bukkit;

/**
 * Minecraft Tellraw 信息扩展构建工具
 *
 * @author 坏黑
 * @since 2018-11-07 22:58
 */
public class TellrawCreator {

    @TInject(asm = "io.izzel.taboolib.module.tellraw.internal.InternalTellraw")
    private static AbstractTellraw abstractTellraw;
    private static boolean viaVersionLoaded;
    private static boolean protocolSupportLoaded;

    @TSchedule
    static void tick() {
        viaVersionLoaded = Bukkit.getPluginManager().getPlugin("ViaVersion") != null;
        protocolSupportLoaded = Bukkit.getPluginManager().getPlugin("ProtocolSupport") != null;
    }

    public static AbstractTellraw getAbstractTellraw() {
        return abstractTellraw;
    }

    public static boolean isViaVersionLoaded() {
        return viaVersionLoaded;
    }

    public static boolean isProtocolSupportLoaded() {
        return protocolSupportLoaded;
    }
}
