package tech.jlsol.servernamedcbot.listeners.logger;

import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageEmbedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.util.Logger;
import tech.jlsol.servernamedcbot.util.SQLHandler;

import javax.annotation.Nonnull;
import java.sql.SQLException;


import static tech.jlsol.servernamedcbot.util.SQLHandler.MySQLUseDataManager.timeStamp;

public class Messages extends ListenerAdapter {


    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        try {
            SQLHandler.MySQLUseDataManager.setMessageReceive(timeStamp, event.getChannel().getId(),
                    event.getMessage().getContentDisplay().length(), event.getAuthor().isBot(), event.getAuthor().getJDA().getRoles().size(), event.getGuild().getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Logger.error(throwables.getMessage());
        }
    }
    public void onGuildMessageUpdate(@Nonnull GuildMessageUpdateEvent event) {
        try {
            SQLHandler.MySQLUseDataManager.setMessageReceive(timeStamp, event.getChannel().getId(),
                    event.getMessage().getContentDisplay().length(), event.getAuthor().isBot(), event.getAuthor().getJDA().getRoles().size(), event.getGuild().getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Logger.error(throwables.getMessage());
        }
    }
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        try {
            SQLHandler.MySQLUseDataManager.setMessageReact(timeStamp, event.getChannel().getId(), event.getUser().isBot(), event.getUser().getJDA().getRoles().size(), event.getGuild().getId(), event.getReaction().getReactionEmote().getEmoji());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Logger.error(throwables.getMessage());
        }
    }
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent event) {
        try {
            SQLHandler.MySQLUseDataManager.setMessageReact(timeStamp, event.getChannel().getId(), event.getUser().isBot(), event.getUser().getJDA().getRoles().size(), event.getGuild().getId(), event.getReaction().getReactionEmote().getEmoji());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Logger.error(throwables.getMessage());
        }
    }

}
