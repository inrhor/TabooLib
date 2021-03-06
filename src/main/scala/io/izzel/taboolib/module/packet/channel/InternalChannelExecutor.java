package io.izzel.taboolib.module.packet.channel;

import io.izzel.taboolib.module.locale.logger.TLogger;
import io.netty.channel.Channel;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * @author 坏黑
 * @since 2018-10-28 15:12
 */
public class InternalChannelExecutor extends ChannelExecutor {

    @Override
    public void sendPacket(Player player, Object packet) {
        if (packet instanceof Packet) {
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket((Packet<?>) packet);
        } else {
            TLogger.getGlobalLogger().warn("Invalid packet: " + packet.getClass().getName());
        }
    }

    @Override
    public Channel getPlayerChannel(Player player) {
        return ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel;
    }
}
