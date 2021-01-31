package tech.jlsol.servernamedcbot.features;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.util.Config;
import tech.jlsol.servernamedcbot.util.ErrorHandler;
import tech.jlsol.servernamedcbot.util.Logger;
import tech.jlsol.servernamedcbot.util.SQLHandler;

import javax.annotation.Nonnull;
import java.sql.SQLException;
import java.util.Objects;

public class Birthday extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event)
    {
        int i = 0;
        while (Objects.requireNonNull(event.getJDA().getGuildById(
                Config.readConfig("data", "settings", "guildID"))).getJDA().getUsers().size() > i){
            try {
                SQLHandler.MySQLUseDataManager.setBirthday(Objects.requireNonNull(event.getJDA().getGuildById(
                        Config.readConfig("data", "settings", "guildID"))).getJDA().getUsers().get(i).getId(),
                        Objects.requireNonNull(event.getJDA().getGuildById(
                                Config.readConfig("data", "settings", "guildID"))).getJDA().getUsers().get(i).getTimeCreated());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                Logger.error(ErrorHandler.getErrorMessage(ErrorHandler.ErrorCodes.SQL_EXCEPTION,
                        java.util.Optional.ofNullable(throwables.getMessage())));
            }
            i++;
        }

    }
    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event) {
        try {
            SQLHandler.MySQLUseDataManager.setBirthday(event.getUser().getId(), event.getUser().getTimeCreated());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Logger.error(ErrorHandler.getErrorMessage(ErrorHandler.ErrorCodes.SQL_EXCEPTION,
                    java.util.Optional.ofNullable(throwables.getMessage())));
        }
    }
}
