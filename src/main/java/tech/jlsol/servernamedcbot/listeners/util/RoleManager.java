package tech.jlsol.servernamedcbot.listeners.util;

import java.util.Objects;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import tech.jlsol.servernamedcbot.util.Logger;

public class RoleManager {

  public static void giveRole(GuildMessageReactionAddEvent event, String role) {
    if (!hasRole(event, event.getGuild().getRolesByName(role, true).get(0))) {
      event
        .getGuild()
        .addRoleToMember(
          event.getUserId(),
          event.getGuild().getRolesByName(role, true).get(0)
        )
        .reason("reacted to Message")
        .queue();
      Logger.msg(String.format("User %s got role %s", event.getUserId(), role));
    }
  }

  public static void removeRole(
    GuildMessageReactionRemoveEvent event,
    String role
  ) {
    if (
      hasRoleRemove(event, event.getGuild().getRolesByName(role, true).get(0))
    ) {
      event
        .getGuild()
        .removeRoleFromMember(
          event.getUserId(),
          event.getGuild().getRolesByName(role, true).get(0)
        )
        .reason("removed reaction from message")
        .queue();
      Logger.msg(
        String.format("User %s got role removed %s", event.getUserId(), role)
      );
    }
  }

  static boolean hasRole(GuildMessageReactionAddEvent event, Role role) {
    return event.getMember().getRoles().contains(role);
  }

  static boolean hasRoleRemove(
    GuildMessageReactionRemoveEvent event,
    Role role
  ) {
    return Objects.requireNonNull(event.getMember()).getRoles().contains(role);
  }
}
