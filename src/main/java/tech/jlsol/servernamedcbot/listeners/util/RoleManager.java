package tech.jlsol.servernamedcbot.listeners.util;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import tech.jlsol.servernamedcbot.util.Logger;

public class RoleManager {
    public static void giveRole(GuildMessageReactionAddEvent event, String role){
        if(!hasRole(event, event.getGuild().getRolesByName(role, true).get(0))){
            event.getGuild().addRoleToMember(event.getUserId(), event.getGuild().getRolesByName(role, true).get(0)).reason("reacted to Message").queue();
            Logger.warning(String.format("User %s got role %s", event.getUserId(), role));
        }
    }
    static boolean hasRole(GuildMessageReactionAddEvent event, Role role){
        return event.getMember().getRoles().contains(role);
    }
}
