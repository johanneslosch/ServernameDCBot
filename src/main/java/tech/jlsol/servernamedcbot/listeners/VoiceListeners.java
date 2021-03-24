package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class VoiceListeners extends ListenerAdapter {

    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
        if (!event.getGuild().getTextChannels().isEmpty()) {
            if(event.getChannelJoined().getMembers().size() <=1){
                event.getGuild().createTextChannel(event.getChannelJoined().getName() + "-mute")
                        .setParent(event.getChannelJoined().getParent()).queue();
            }
        }
    }

    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent event) {

        if (!event.getGuild().getTextChannels().isEmpty()) {
            if(event.getChannelJoined().getMembers().size() <=1){
                event.getGuild().createTextChannel(event.getChannelJoined().getName() + "-mute")
                        .setParent(event.getChannelJoined().getParent()).queue();
            }
        }
        if(event.getChannelLeft().getMembers().isEmpty()) {
            if (event.getGuild().getTextChannelsByName(
                    event.getChannelLeft().getName() + "-mute", true).get(0).getParent()
                    == event.getChannelLeft().getParent()) {
                event.getGuild().getTextChannelsByName(
                        event.getChannelLeft().getName() + "-mute", true).get(0)
                        .getManager().getChannel().delete().queue();
            }
        }

    }

    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
        if(event.getChannelLeft().getMembers().isEmpty()) {
            if (event.getGuild().getTextChannelsByName(
                    event.getChannelLeft().getName() + "-mute", true).get(0).getParent()
                    == event.getChannelLeft().getParent()) {
                event.getGuild().getTextChannelsByName(
                        event.getChannelLeft().getName() + "-mute", true).get(0)
                        .getManager().getChannel().delete().queue();
            }
        }
    }
}
